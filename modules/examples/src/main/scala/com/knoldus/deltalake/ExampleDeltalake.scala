import com.knoldus.delta.OutputSource
import com.knoldus.structuredstreaming.StructuredStreamingJob
import com.knoldus.utils.Constants
import com.knoldus.kafka.InputSource
import org.apache.spark.sql.{DataFrame, Dataset}

/**
 * ExampleDeltalake is an object of using the Accelerator overriding the run method
 */
object ExampleDeltalake extends StructuredStreamingJob {

  import InputSource.sparkSession.implicits._

  override def run(dataSet: Dataset[String]) = {

    val result: DataFrame = dataSet
      .flatMap(value => value.split("\\s+"))
      .groupByKey(x => if (x == "hello") x + " world" else x)
      .count()
      .withColumnRenamed(Constants.ExistingNameOfColumn, Constants.NewNameOfColumn)

    OutputSource.writeToDelta(result, Constants.ParquetFilePath, Constants.CheckPointPath)

  }

}
