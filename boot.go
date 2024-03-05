package boot

import (
	"context"
	"fmt"
	"os"
	"os/signal"
	"syscall"
	"time"

	"github.com/sirupsen/logrus"
)

type Booter struct {
	app  App
	quit chan os.Signal
}

func NewBooter(app App) *Booter {
	return &Booter{
		app:  app,
		quit: make(chan os.Signal, 1),
	}
}

func (b *Booter) Boot(ctx context.Context) {
	var cancel context.CancelFunc
	ctx, cancel = context.WithCancel(ctx)

	logrus.Info("initializer app")
	err := b.app.Initializer(ctx)
	if err != nil {
		panic(fmt.Sprintf("%+v\n", err))
	}

	signal.Notify(b.quit, syscall.SIGHUP, syscall.SIGQUIT, syscall.SIGTERM, syscall.SIGINT)

	go func() {
		logrus.Info("start app")
		err := b.app.Start(ctx)
		logrus.Errorf("%+v", err)
		b.quit <- syscall.SIGQUIT
	}()

	for {
		s := <-b.quit
		logrus.Infof("get a signal %s", s.String())
		switch s {
		case syscall.SIGQUIT, syscall.SIGTERM, syscall.SIGINT:
			ctx, cancel = context.WithTimeout(ctx, 35*time.Second)
			defer cancel()

			logrus.Info("stop app")
			err := b.app.Stop(ctx)
			if err != nil {
				logrus.Errorf("stop app failed. error: %+v", err)
			}

			logrus.Info("uninitializer app")
			err = b.app.Uninitializer(ctx)
			if err != nil {
				logrus.Errorf("uninitializer app failed. err: %+v", err)
			}
			time.Sleep(time.Second)
			os.Exit(0)
			return
		case syscall.SIGHUP:
		default:
			return
		}
	}
}

func (b *Booter) Shutdown() {
	b.quit <- syscall.SIGQUIT
}
