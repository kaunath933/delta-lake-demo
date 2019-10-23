package com.knoldus.structuredstreaming

import com.knoldus.kafka.InputSource
import com.knoldus.utils.Constants
import org.apache.spark.sql.{DataFrame, Dataset}

/**
 * StructuredStreamingJob is the main working unit of project.
 * Which gets a dataFrame from InputSource and persists it on OutputSource .
 */
trait StructuredStreamingJob {

  def main(args: Array[String]): Unit = {

    val dataFrame: DataFrame = InputSource.takeInput()

    import InputSource.sparkSession.implicits._

    val dataSet: Dataset[String] = dataFrame.selectExpr(Constants.CastToStringValue).as[String]

    run(dataSet)

  }

  /**
   * abstract run method where the the main job logic will be written
   *
   * @param dataset is a dataset  spark-session
   *
   */
  def run(dataset: Dataset[String]): Unit

}
