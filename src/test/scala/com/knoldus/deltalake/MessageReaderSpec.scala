package com.knoldus.deltalake

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.scalatest.{BeforeAndAfterAll, FlatSpec}

class MessageReaderSpec extends FlatSpec with BeforeAndAfterAll with MessageReader {

  override val sparkSession: SparkSession = SparkSession
    .builder
    .appName(Constants.SparkAppName)
    .master(Constants.SparkMaster)
    .getOrCreate()

  override def afterAll(): Unit = {
    sparkSession.close()
    sparkSession.stop()
  }

  "takeInput method" should "give a dataFrame which should not be null" in {
    val actualResult: DataFrame = takeInput()
    assert(actualResult != null)
  }
}
