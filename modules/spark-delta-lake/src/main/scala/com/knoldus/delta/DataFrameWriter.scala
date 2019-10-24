package com.knoldus.delta

import com.knoldus.constants.Constants
import org.apache.spark.sql.DataFrame

trait DataFrameWriter {

  /**
   * writeToDelta() writes the data to delta lake
   * the format of the data is in parquet file format
   *
   * @param outputDataFrame is a DataFrame which is used to write to delta table
   * @param filePath        is a path of type String which specifies the where to write the delta table
   */
  def writeToDelta(outputDataFrame: DataFrame, filePath: String, checkPointPath: String) = {

    outputDataFrame.select(Constants.SelectColumn).writeStream
      .format(Constants.FileFormat)
      .outputMode(Constants.SaveMode)
      .option(Constants.CheckPointLocation, checkPointPath)
      .start(filePath)
      .awaitTermination()
  }
}

object DataFrameWriter extends DataFrameWriter
