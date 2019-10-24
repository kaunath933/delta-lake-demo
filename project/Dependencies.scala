import sbt._

object Dependencies {

  val scala: String = "2.12.8"
  val logbackClassicVersion: String = "1.2.3"
  val scalaTestVersion: String = "3.0.5"
  val sparkVersion: String = "2.4.4"

  val logback: ModuleID = "ch.qos.logback" % "logback-classic" % logbackClassicVersion
//  val kafka: ModuleID = "org.apache.kafka" %% "kafka" % "2.3.0"
  val config: ModuleID = "com.typesafe" % "config" % "1.2.1"
  val sparkCore: ModuleID = "org.apache.spark" %% "spark-core" % sparkVersion
  val sparkSql: ModuleID = "org.apache.spark" %% "spark-sql" % sparkVersion
  val sparkStreaming: ModuleID = "org.apache.spark" %% "spark-streaming" % sparkVersion
  val sparkSqlKafka: ModuleID = "org.apache.spark" %% "spark-sql-kafka-0-10" % sparkVersion
  val deltaLake: ModuleID = "io.delta" %% "delta-core" % "0.3.0"
  val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % scalaTestVersion % "test"

  val sparkDeltaLakeDependencies = List(logback,config,sparkCore,sparkSql,sparkStreaming,sparkSqlKafka,deltaLake)
   val testingDependencies = List(scalaTest)

}
