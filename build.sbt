ThisBuild / version := "0.5.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.4.2"
ThisBuild / organization := "com.laravelista"

ThisBuild / scalacOptions ++= Seq("-deprecation")

val http4sVersion = "0.23.27"
val awsSdkVersion = "2.18.22"

lazy val root = (project in file("."))
  .settings(
    name := "Website",
    maintainer := "mario@laravelista.com",
    dockerExposedPorts := Seq(8080),
    dockerBaseImage := "eclipse-temurin:21",
    dockerRepository := Some("ghcr.io"),
    dockerUsername := Some("laravelista/laravelista-n6"),
    dockerLabels := Map(
      "org.opencontainers.image.source" -> "https://github.com/laravelista/laravelista-n6"
    ),
    // NOTE: Fix for sbt run, not unbinding port on exit.
    run / fork := true,
    libraryDependencies += "org.http4s" %% "http4s-dsl" % http4sVersion,
    libraryDependencies += "org.http4s" %% "http4s-ember-server" % http4sVersion,
    libraryDependencies += "org.http4s" %% "http4s-scalatags" % "0.25.2",
    libraryDependencies += "com.lihaoyi" %% "scalatags" % "0.13.1",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.4.1",
    libraryDependencies += "com.amazonaws" % "aws-java-sdk-core" % "1.12.346",
    libraryDependencies += "com.amazonaws" % "aws-java-sdk-sesv2" % "1.12.346",
    libraryDependencies += "software.amazon.awssdk" % "bom" % awsSdkVersion,
    libraryDependencies += "software.amazon.awssdk" % "sesv2" % awsSdkVersion,
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.18"
  )
  .enablePlugins(UniversalPlugin)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(DockerPlugin)

lazy val js = (project in file("js"))
  .settings(
    name := "Website JS",
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.3.0",
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.13" % "test",
    jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv(),
    Compile / fastLinkJS / scalaJSLinkerOutputDirectory := baseDirectory.value / "../src/main/resources/js",
    Compile / fullLinkJS / scalaJSLinkerOutputDirectory := baseDirectory.value / "../src/main/resources/js"
  )
  .enablePlugins(ScalaJSPlugin)
  .disablePlugins(RevolverPlugin)
