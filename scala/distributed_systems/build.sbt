
ThisBuild / organization := "sysmo"
//ThisBuild / scalaVersion := "3.1.2"
ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val root = project
  .in(file("."))
  .settings(
    name := "distributed_systems",
//    libraryDependencies ++= Seq(
//      "org.scalameta" %% "munit" % "0.7.29" % Test,
//    ),
  ).dependsOn(ds_lib)

lazy val ds_lib = project
  .settings(
    name := "ds_lib",
    version := "0.1.0-SNAPSHOT",

    libraryDependencies ++= Seq(
      // Logging
      "org.slf4j" % "slf4j-api" % "1.7.36",
      // Cats
      "org.typelevel" %% "cats-core" % "2.6.1",
      // Monix
      "io.monix" %% "monix" % "3.4.0",
      // Class graph
      "io.github.classgraph" % "classgraph" % "4.8.146",
      // Finagle
      "com.twitter" %% "finagle-http"  % "22.4.0"
      // Airframe RPC
//      "org.wvlet.airframe" %% "airframe" % "22.4.2",
//      "org.wvlet.airframe" %% "airframe-http" % "22.4.2",
    )
  )