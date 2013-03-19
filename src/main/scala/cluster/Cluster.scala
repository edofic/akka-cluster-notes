package cluster

import akka.actor._
import akka.routing.FromConfig

class Worker extends Actor {
  val id = (math.random*1000).toInt.toString

  println(s"\n\nNumber $id is alive!\n\n")

  def receive = {
    case msg => println("Got a message: "+msg)
  }
}

object Main {
  def main(args: Array[String]){
    println("\n\nstarting\n\n")

    val sys = ActorSystem("mysystem")
    sys.actorOf(Props[Worker], name = "myworker") //local worker
    val service = sys.actorOf(Props[Worker].withRouter(FromConfig), name = "myservice")

    println("\n\ninit'ed\n\n")

    def step {
      print("enter msg or exit: ")
      readLine() match {
        case "exit" => 
        case msg => 
          service ! msg
          step
      }
    }
    step
    
    sys.shutdown()
  }
}
