import Dependencies._

lazy val commonSettings = Seq(
  organization := "com.knoldus",
  scalaVersion := "2.12.8",
  version := "1.0.0"
)

lazy val root = project
  .in(file("."))
  .settings(
    commonSettings,
    name := "acclerator-delta-lake"
  ).aggregate(sparkDeltaLake, examples)

lazy val sparkDeltaLake = project
  .in(file("./spark-delta-lake"))
  .settings(
    commonSettings,
    name := "spark-delta-lake",
    libraryDependencies ++= sparkDeltaLakeDependencies
  )

lazy val examples = project
  .in(file("./examples"))
  .configs(IntegrationTest)
  .settings(
    name := "examples",
    commonSettings,
    libraryDependencies ++= testingDependencies
  )
  .dependsOn(sparkDeltaLake)
