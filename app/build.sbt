// common settings shared by all projects
lazy val commonSettings = Seq(
  organization := "cn.xiaohuangdou",
  version := "1.0-SNAPSHOT",
  scalaVersion := "2.11.7",
  scalacOptions ++= Seq("-feature", "-language:postfixOps"),
  // favor oschina mirror
  resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
  resolvers += "oschina" at "http://maven.oschina.net/content/groups/public/",
  resolvers += "twitter-repo" at "http://maven.twttr.com",
  resolvers ++= Seq("releases", "snapshots").map(Resolver.sonatypeRepo),
  // prevent producing src jar
  publishArtifact in (Compile, packageSrc) := false,
  // prevent generating api doc
  sources in (Compile, doc) := Seq.empty,
  // prevent producing doc jar
  publishArtifact in (Compile, packageDoc) := false
)

name := "app"

lazy val common = project.settings(commonSettings: _*)

lazy val `uc-service` = project.settings(commonSettings: _*)

lazy val web = project.settings(commonSettings: _*).
  dependsOn(common, `uc-service`).aggregate(common, `uc-service`).
  enablePlugins(PlayScala, SbtNativePackager)