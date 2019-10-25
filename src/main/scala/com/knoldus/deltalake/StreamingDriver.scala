package com.knoldus.deltalake

import org.apache.spark.sql.{DataFrame, Dataset}

/**
 * StreamingDriver is the main working unit of project.
 * Which gets a dataFrame from MessageReader and persists it on DataFrameWriter .
 */
trait StreamingDriver extends MessageReader {

  def main(args: Array[String]): Unit = {

    val dataFrame: DataFrame = MessageReader.takeInput()

    import MessageReader.sparkSession.implicits._

    val dataSet: Dataset[String] = dataFrame.selectExpr(Constants.CastToStringValue).as[String]

    val result: DataFrame = run(dataSet)

    DataFrameWriter.writeToDelta(result, Constants.ParquetFilePath, Constants.CheckPointPath)

  }

  /**
   * abstract run method where the the main job logic will be written
   *
   * @param dataset is a dataset  spark-session
   *
   */
  def run(dataset: Dataset[String]): DataFrame

}
