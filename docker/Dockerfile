FROM ubuntu:19.04
ENV DEBIAN_FRONTEND noninteractive
ENV ELASTIC_DIR=/xel-computation-wallet
ENV ELASTIC_MINER_DIR=/xel-miner

RUN apt-get update
RUN apt-get -y install apt-utils
RUN apt-get -y install git curl gnupg dos2unix maven
RUN apt-get -y autoremove

RUN apt-get install -y libcurl4-openssl-dev cmake build-essential libssl-dev locales
RUN apt-get install -y cmake libcurl4-openssl-dev libudev-dev screen libtool pkg-config libjansson-dev libssl-dev

RUN git clone --depth 1 https://github.com/xel-software/xel-miner ${ELASTIC_MINER_DIR}
RUN cd ${ELASTIC_MINER_DIR} && cmake . && make install

RUN git clone --depth 1 https://github.com/xel-software/xel-computation-wallet ${ELASTIC_DIR}

RUN cd ${ELASTIC_DIR} && mvn package

RUN cp ${ELASTIC_MINER_DIR}/xel_miner ${ELASTIC_DIR}/work/xel_miner
RUN cp ${ELASTIC_MINER_DIR}/ElasticPL/ElasticPLFunctions.h ${ELASTIC_DIR}/work/ElasticPL/ElasticPLFunctions.h
RUN cp ${ELASTIC_MINER_DIR}/ElasticPL/libElasticPLFunctions.a ${ELASTIC_DIR}/work/crypto/libElasticPLFunctions.a

COPY start-computation-wallet.sh ${ELASTIC_DIR}/start-computation-wallet.sh
RUN dos2unix ${ELASTIC_DIR}/start-computation-wallet.sh

WORKDIR ${ELASTIC_DIR}
ENTRYPOINT bash start-computation-wallet.sh
