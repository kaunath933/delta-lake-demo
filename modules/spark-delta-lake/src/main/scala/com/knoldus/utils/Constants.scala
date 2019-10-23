package com.knoldus.utils

import com.typesafe.config.{Config, ConfigFactory}

/**
 * A singleton object named Constants where all constants are placed
 * This constants are used in the main program
 */
object Constants {

  val config: Config =ConfigFactory.load()
  val SparkAppName: String = config.getString("spark.app-name")
  val SparkMaster: String = config.getString("spark.master-name")
  val SparkInputSource: String = config.getString("spark.input-source")
  val SparkKafkaServerKey: String = "kafka.bootstrap.servers"
  val SparkKafkaServerValue: String = config.getString("spark.kafka.server")
  val SparkKafkaTopicKey: String = "subscribe"
  val SparkKafkaTopicValue: String = config.getString("spark.kafka.topic")
  val CastToStringValue: String = "CAST(value AS STRING)"
  val CastToStringKey: String = "CAST(key AS STRING)"
  val ExistingNameOfColumn: String = "count(1)"
  val NewNameOfColumn: String = "Count"
  val SelectColumn: String = "value"
  val ParquetFilePath: String = config.getString("spark.delta.file-path")
  val CheckPointLocation: String = "checkpointLocation"
  val CheckPointPath: String = config.getString("spark.delta. checkpoint-path")
  val FileFormat: String = "delta"
  val SaveMode: String = config.getString("spark.delta.save-mode")

}