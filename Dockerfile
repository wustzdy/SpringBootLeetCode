FROM nginx:1.24.0

# Install Basic Frontend Libs
RUN curl -sL https://deb.nodesource.com/setup_12.x | bash - && \
    apt-get -y install nodejs && \
    npm config set registry http://registry.npm.taobao.org/ && \
    npm install -g http-server


CMD ["/bin/bash"]