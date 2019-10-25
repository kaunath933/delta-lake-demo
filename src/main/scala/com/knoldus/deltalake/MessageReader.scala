package com.knoldus.deltalake

import org.apache.spark.sql.{DataFrame, SparkSession}

/**
 * MessageReader a Trait which contains the spark session and a method to read from Kafka.
 */
trait MessageReader {

  /**
   * takeInput() will provide us the DataFrame which is being read from Kafka.
   *
   * @return DataFrame for further process on it.
   */
  def takeInput(): DataFrame = sparkSession
    .readStream
    .format(Constants.SparkInputSource)
    .option(Constants.SparkKafkaServerKey, Constants.SparkKafkaServerValue)
    .option(Constants.SparkKafkaTopicKey, Constants.SparkKafkaTopicValue)
    .load()

  val sparkSession: SparkSession = SparkSession
    .builder
    .appName(Constants.SparkAppName)
    .master(Constants.SparkMaster)
    .getOrCreate()
}

/**
 * MessageReader is a Singleton object to access the methods from InputAdapterService Trait.
 */
object MessageReader extends MessageReader
