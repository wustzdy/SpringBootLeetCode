package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.thread.printString;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;
//1195. 交替打印字符串
/*
编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
        如果这个数字可以被 3 整除，输出 "fizz"。
        如果这个数字可以被 5 整除，输出 "buzz"。
        如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
        例如，当n = 15，输出 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
*/

public class FizzBuzz {
    private static Semaphore number = new Semaphore(1);
    private static Semaphore fizz = new Semaphore(0);
    private static Semaphore buzz = new Semaphore(0);
    private static Semaphore fizzbuzz = new Semaphore(0);
    private static int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public static void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizz.acquire();
                printFizz.run();
                number.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public static void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                buzz.acquire();
                printBuzz.run();
                fizzbuzz.release();
            }
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public static void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzz.acquire();
                printFizzBuzz.run();
                number.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            number.acquire();
            if (i % 3 != 0 && i % 5 != 0) {//开始打印
                printNumber.accept(i);
                number.release();
            } else if (i % 3 == 0 && i % 5 != 0) {//fizz开始打印
                fizz.release();
            } else if (i % 3 != 0 && i % 5 == 0) {//buzz开始打印
                buzz.release();
            } else {
                fizzbuzz.release();//fizzbuzz开始打印
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz zeroEvenOdd = new FizzBuzz(5);
        new Thread(() -> {
            try {
                zeroEvenOdd.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread fizzThread = new Thread(() -> {
            try {
                FizzBuzz.fizz(() -> {
                    System.out.println("fizz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        fizzThread.start();

        Thread buzzThread = new Thread(() -> {
            try {
                FizzBuzz.buzz(() -> {
                    System.out.println("buzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        buzzThread.start();

        Thread fizzbuzzThread = new Thread(() -> {
            try {
                FizzBuzz.fizzbuzz(() -> {
                    System.out.println("fizzbuzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        fizzbuzzThread.start();
    }
}
//1 2 fizz 4 buzz