#!/bin/bash

cd /xel-computation-wallet

echo "set config..."

CONFIG_FILE=conf/nxt.properties

if [ ! -z ${nxt_adminPassword+x} ]
then
  echo "set nxt.adminPassword=HIDDEN"
  echo "nxt.adminPassword=${nxt_adminPassword}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_apiServerHost+x} ]
then
  echo "set nxt.apiServerHost=${nxt_apiServerHost}"
  echo "nxt.apiServerHost=${nxt_apiServerHost}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_peerServerHost+x} ]
then
  echo "set nxt.peerServerHost=${nxt_peerServerHost}"
  echo "nxt.peerServerHost=${nxt_peerServerHost}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_defaultPeers+x} ]
then
  echo "set nxt.defaultPeers=${nxt_defaultPeers}"
  echo "nxt.defaultPeers=${nxt_defaultPeers}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_allowedUserHosts+x} ]
then
  echo "set nxt.allowedUserHosts=${nxt_allowedUserHosts}"
  echo "nxt.allowedUserHosts=${nxt_allowedUserHosts}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_wellKnownPeers+x} ]
then
  echo "set nxt.wellKnownPeers=${nxt_wellKnownPeers}"
  echo "nxt.wellKnownPeers=${nxt_wellKnownPeers}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_allowedBotHosts+x} ]
then
  echo "set nxt.allowedBotHosts=${nxt_allowedBotHosts}"
  echo "nxt.allowedBotHosts=${nxt_allowedBotHosts}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_myPlatform+x} ]
then
  echo "set nxt.myPlatform=${nxt_myPlatform}"
  echo "nxt.myPlatform=${nxt_myPlatform}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_myAddress+x} ]
then
  echo "set nxt.myAddress=${nxt_myAddress}"
  echo "nxt.myAddress=${nxt_myAddress}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_myHallmark+x} ]
then
  echo "set nxt.myHallmark=${nxt_myHallmark}"
  echo "nxt.myHallmark=${nxt_myHallmark}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_disableAdminPassword+x} ]
then
  echo "set nxt.disableAdminPassword=${nxt_disableAdminPassword}"
  echo "nxt.disableAdminPassword=${nxt_disableAdminPassword}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_longPollFromAnywhere+x} ]
then
  echo "set nxt.longPollFromAnywhere=${nxt_longPollFromAnywhere}"
  echo "nxt.longPollFromAnywhere=${nxt_longPollFromAnywhere}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_compuchainPassphrase+x} ]
then
  echo "set nxt.compuchainPassphrase=HIDDEN"
  echo "nxt.compuchainPassphrase=${nxt_compuchainPassphrase}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_enableAPIUPnP+x} ]
then
  echo "set nxt.enableAPIUPnP=${nxt_enableAPIUPnP}"
  echo "nxt.enableAPIUPnP=${nxt_enableAPIUPnP}" >> ${CONFIG_FILE}
fi

if [ ! -z ${nxt_faucet+x} ]
then
  echo "set nxt.faucet=${nxt_faucet}"
  echo "nxt.faucet=${nxt_faucet}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_faucetPassphrase+x} ]
then
  echo "set nxt.faucetPassphrase=***"
  echo "nxt.faucetPassphrase=${nxt_faucetPassphrase}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_faucetLockout+x} ]
then
  echo "set nxt.faucetLockout=${nxt_faucetLockout}"
  echo "nxt.faucetLockout=${nxt_faucetLockout}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_faucetAmount+x} ]
then
  echo "set nxt.faucetAmount=${nxt_faucetAmount}"
  echo "nxt.faucetAmount=${nxt_faucetAmount}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_isTestnet+x} ]
then
  echo "set nxt.isTestnet=${nxt_isTestnet}"
  echo "nxt.isTestnet=${nxt_isTestnet}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_defaultTestnetPeers+x} ]
then
  echo "set nxt.defaultTestnetPeers=${nxt_defaultTestnetPeers}"
  echo "nxt.defaultTestnetPeers=${nxt_defaultTestnetPeers}" >> ${CONFIG_FILE}
fi
if [ ! -z ${nxt_testnetPeers+x} ]
then
  echo "set nxt.testnetPeers=${nxt_testnetPeers}"
  echo "nxt.testnetPeers=${nxt_testnetPeers}" >> ${CONFIG_FILE}
fi

if [ ! -z ${JAVA_OPTS+x} ]
then
  export JAVA_OPTS=${JAVA_OPTS}
  echo "set JAVA_OPTS=${JAVA_OPTS}"
fi

./run.sh
