package com.knoldus.deltalake

/**
 * A singleton object named Constants where all constants are placed
 * This constants are used in the main program
 */
object Constants {

  val SparkAppName: String = "SparkApp"
  val SparkMaster: String = "local[*]"
  val SparkInputSource: String = "kafka"
  val SparkKafkaServerKey: String = "kafka.bootstrap.servers"
  val SparkKafkaServerValue: String = "localhost:9092"
  val SparkKafkaTopicKey: String = "subscribe"
  val SparkKafkaTopicValue: String = "topic1"
  val CastToStringValue: String = "CAST(value AS STRING)"
  val CastToStringKey: String = "CAST(key AS STRING)"
  val ExistingNameOfColumn: String = "count(1)"
  val NewNameOfColumn: String = "Count"
  val SelectColumn: String = "value"
  val ParquetFilePath: String = "./deltafiles/files"
  val CheckPointLocation: String = "checkpointLocation"
  val CheckPointPath: String = "./deltafiles/checkpoints"
  val FileFormat: String = "delta"
  val SaveMode: String = "complete"

}
