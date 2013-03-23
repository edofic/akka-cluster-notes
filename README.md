## An experiment with akka clustering

I wanted to try out how simple can it get to make a cluster with akka 2.2. Actually this might work with 2.1...gotta try. 

**EDIT** it works with akka 2.1 with minimal changes to config. see akka21 branch

Anyhow this is a reference for the future me(and hopefully somebody else).

Run with `sbt run` to set up a seed node and `sbt run -Dakka.remote.netty.tcp.port=2553` or some other number(0 for random free port) to run new nodes. Might be more practical to set 0 as default and then run with specified port for master. 

Change the list of seed nodes to IPs and possibly more than one node for any serious deployment. 

### Notes
- Don't forget to include configuration for remoting and actor-provider when using cluster. Ohterwise you might get weird exceptions and/or stalls. 
- you need to start local worker and "create" a service actor. this will not instantiate any workers but will give you an `ActorRef` that knows about the cluster. this was the only thing I couldn't remove from code and put into config. 
- you can even rescue a cluster where all(only?) seed nodes are down. Just start new nodes with seed-nodes list containing some of the existing nodes. How did I not figure out this earlier?
