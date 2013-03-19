scalaVersion := "2.10.0"

resolvers += "Akka snapshots" at "http://repo.akka.io/snapshots"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-cluster-experimental" % "2.2-M2"
)
