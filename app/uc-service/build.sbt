import com.twitter.sbt._

seq(Project.defaultSettings ++
  StandardProject.newSettings ++
  CompileThriftScrooge.newSettings: _*)

name := "uc-service"

scalaVersion := "2.11.7"

CompileThriftScrooge.scroogeVersion := "2.5.4"

CompileThriftScrooge.scroogeBuildOptions := List("--verbose", "--finagle")

libraryDependencies ++= Seq(
   "com.twitter" %% "scrooge-runtime" % "1.1.3"
 )

//mainClass in (Compile, run) := Some("com.cloud9ers.director.ThriftServer")

//mainClass in (Compile, client) := Some("com.cloud9ers.director.ThriftClient")
