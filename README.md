----
# Welcome to XEL!

[![GitHub version](https://badge.fury.io/gh/xel-software%2Fxel-lite-wallet.svg)](https://badge.fury.io/gh/xel-software%2Fxel-lite-wallet)

XEL is a decentralized supercomputer based on cryptography and blockchain technology.

----
## disclaimer

XEL CORE / XELINE IS OPEN-SOURCE SOFTWARE RUNNING ON THE MAIN-NET BUT IS STILL CONSIDERED "BETA" AND MAY CONTAIN BUGS, SOME OF WHICH MAY HAVE SERIOUS CONSEQUENCES. WE THEREFORE DISCLAIM ANY LIABILITY OF ANY KIND FOR ANY DAMAGES WHATSOEVER RESULTING DIRECTLY OR INDIRECTLY FROM THE USE OF THIS SOFTWARE OR OF ANY DERIVATIVE WORK. USE THE SOFTWARE AND THE INFORMATION PRESENTED HERE AT OUR OWN RISK.

----
## Run XEL Computation Wallet from sources (***recommended for advanced users***)

### dependencies
  - Java 12 : [oracle jdk](https://www.oracle.com/technetwork/java/javase/downloads/jdk12-downloads-5295953.html) or [openjdk](https://jdk.java.net/12/)
  - Maven : https://maven.apache.org/install.html

### clone the repository

```
git clone https://github.com/xel-software/xel-computation-wallet
cd xel-computation-wallet
```

### compile it

`mvn package`

### clone the miner

clone the miner next to your wallet folder like this :

```
my_main_folder/xel-computation-wallet
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
cd xel-computation-wallet
./pull_miner.sh
```

### start from the command line:
- Linux/macOS: `./start.sh`
- Windows: `run.bat`


***wait for the JavaFX wallet window to open***
***on platforms without JavaFX, open http://localhost:17876/ in a browser***


----
## Run XEL Computation Wallet from docker installer (***recommended for servers***)

https://github.com/xel-software/xel-installer-docker

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
