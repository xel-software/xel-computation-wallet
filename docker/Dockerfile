#
# Source code
#
FROM alpine/git as sources

RUN git clone --depth 1 https://github.com/xel-software/xel-miner /miner
RUN git clone --depth 1 https://github.com/xel-software/xel-computation-wallet /code

#
# Maven build
#
FROM maven:3.6.3-openjdk-11 as build

COPY --from=sources /code/ /build/

RUN cd /build && mvn package

FROM openjdk:11.0.7-jre-buster as miner
ENV DEBIAN_FRONTEND noninteractive
ENV XEL_DIR=/xel-computation-wallet
ENV XEL_MINER_DIR=/xel-miner

RUN apt-get update
RUN apt-get -y install apt-utils
RUN apt-get -y install curl gnupg dos2unix
RUN apt-get -y autoremove

RUN apt-get install -y libcurl4-openssl-dev cmake build-essential libssl-dev locales
RUN apt-get install -y cmake libcurl4-openssl-dev libudev-dev screen libtool pkg-config libjansson-dev libssl-dev

COPY --from=sources /miner/ /${XEL_MINER_DIR}/

RUN cd ${XEL_MINER_DIR} && cmake . && make install

#
# Final image
#
FROM openjdk:11.0.7-jre-slim-buster

RUN apt-get update
RUN apt-get install -y libcurl4-openssl-dev cpp gcc libssl-dev

RUN mkdir /opt/app

COPY --from=sources /code/run.sh /opt/app/run.sh
COPY --from=sources /code/conf/ /opt/app/conf/
COPY --from=sources /code/html/ /opt/app/html/
COPY --from=sources /code/work/ /opt/app/work/
COPY --from=sources /code/logs/ /opt/app/logs/
COPY --from=sources /code/src/test/testfiles/verification.epl /opt/app/src/test/testfiles/verification.epl

COPY --from=build /build/xel-computation-wallet.jar /opt/app/xel-wallet.jar

COPY --from=miner /xel-miner/ElasticPL/ElasticPLFunctions.h /opt/app/work/ElasticPL/ElasticPLFunctions.h
COPY --from=miner /xel-miner/ElasticPL/libElasticPLFunctions.a /opt/app/work/crypto/libElasticPLFunctions.a
COPY --from=miner /xel-miner/xel_miner /opt/app/work/xel_miner

WORKDIR /opt/app
CMD java ${JAVA_OPTS} -cp xel-wallet.jar:conf org.xel.Nxt
