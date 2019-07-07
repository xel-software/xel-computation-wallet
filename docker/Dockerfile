FROM ubuntu:19.04
ENV DEBIAN_FRONTEND noninteractive
ENV XEL_DIR=/xel-wallet
ENV XEL_MINER_DIR=/xel-miner
ENV LANG C.UTF-8

RUN apt-get update
RUN apt-get -y install apt-utils
RUN apt-get -y install git curl gnupg dos2unix
RUN apt-get -y autoremove

RUN apt-get install -y libcurl4-openssl-dev cmake build-essential libssl-dev locales
RUN apt-get install -y cmake libcurl4-openssl-dev libudev-dev screen libtool pkg-config libjansson-dev libssl-dev
RUN apt-get install -y openjdk-12-jdk

RUN git clone --depth 1 https://github.com/xel-software/xel-miner ${XEL_MINER_DIR}
RUN cd ${XEL_MINER_DIR} && cmake . && make install

ENV TEST=v1

RUN git clone --depth 1 https://github.com/xel-software/xel-wallet ${XEL_DIR}

RUN cd ${XEL_DIR} && ./gradlew classes

RUN cp ${XEL_MINER_DIR}/xel_miner ${XEL_DIR}/work/xel_miner
RUN cp ${XEL_MINER_DIR}/ElasticPL/ElasticPLFunctions.h ${XEL_DIR}/work/ElasticPL/ElasticPLFunctions.h
RUN cp ${XEL_MINER_DIR}/ElasticPL/libElasticPLFunctions.a ${XEL_DIR}/work/crypto/libElasticPLFunctions.a

COPY start-wallet.sh ${XEL_DIR}/start-wallet.sh
RUN dos2unix ${XEL_DIR}/start-wallet.sh

WORKDIR ${XEL_DIR}
ENTRYPOINT bash start-wallet.sh
