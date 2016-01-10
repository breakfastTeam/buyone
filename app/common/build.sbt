name := "common"

libraryDependencies ++= Seq(
  cache, ws, specs2 % Test, evolutions,
  "org.scala-lang" % "scala-reflect" % "2.11.6",
  "org.slf4j" % "slf4j-api" % "1.7.2",
  "joda-time" % "joda-time" % "2.3",
  "org.joda" % "joda-convert" % "1.5",
  "commons-lang" % "commons-lang" % "2.5",
  "redis.clients" % "jedis" % "2.2.0",
  "commons-io" % "commons-io" % "2.0.1",
  "org.codehaus.jackson" % "jackson-core-asl" % "1.9.13",
  "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.13",
  "commons-httpclient" % "commons-httpclient" % "3.1",
  "org.apache.httpcomponents" % "httpcore" % "4.3.1",
  "org.apache.httpcomponents" % "httpclient" % "4.3.1",
  "com.google.code.gson" % "gson" % "2.2.4",
  "org.mindrot" % "jbcrypt" % "0.3m",
  "commons-codec" % "commons-codec" % "1.10",
  "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.3",
  "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
  "com.typesafe.play" %% "play-mailer" % "3.0.1",
  "org.jsoup" % "jsoup" % "1.8.1",
  "dom4j" % "dom4j" % "1.6.1",
  "log4j" % "log4j" % "1.2.14"
)