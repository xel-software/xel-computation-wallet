----
# XEL TESTNET BRANCH

----
## disclaimer

THIS BRANCH IS HIGHLY UNSTABLE. IT IS MEANT TO BE USED WITH XEL TESTNET, WHICH CAN BE RESETED AT ANY MOMENT

----
## HOW TO RUN THE TESTNET

### dependencies
  - Java 12 : [oracle jdk](https://www.oracle.com/technetwork/java/javase/downloads/jdk12-downloads-5295953.html) or [openjdk](https://jdk.java.net/12/)

### clone the repository

```
git clone --single-branch --branch testing https://github.com/xel-software/xel-computation-wallet xel-testnet-wallet
cd xel-testnet-wallet
```

### clone the miner

clone the miner next to your wallet folder like this :

```
my_main_folder/xel-testnet-wallet
my_main_folder/xel-miner
```

```
git clone https://github.com/xel-software/xel-miner
cd xel-miner
cmake .
make install
```

### integrate the miner into the computation wallet

```
cd xel-testnet-wallet
./pull_miner.sh
```

### mandatory configuration

In order to connect to the main testnet nodes, you need to add this configuration :

```
nxt.defaultTestnetPeers=testnet-01.xel.org; testnet-02.xel.org
nxt.testnetPeers=
nxt.isTestnet=true
```


### start from the command line:
- Linux/macOS: `./run.sh`
- Windows: `run.bat`


----
## Improve it

  - we love **pull requests**
  - we love issues (resolved ones actually ;-) )
  - in any case, make sure you leave **your ideas**
  - assist others on the issue tracker
  - **review** existing code and pull requests

----
## Troubleshooting (XEL Reference Software)

  - UI Errors or Stacktraces?
    - report on github

----
## Further Reading

  - on discord : https://link.xel.org/discord
