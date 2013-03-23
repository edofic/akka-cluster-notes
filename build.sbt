scalaVersion := "2.10.0"

resolvers += "Akka releases" at "http://repo.akka.io/releases"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-cluster-experimental" % "2.1.0"
)
