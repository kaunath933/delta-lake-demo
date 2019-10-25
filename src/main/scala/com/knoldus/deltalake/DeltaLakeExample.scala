import com.knoldus.deltalake.{Constants, MessageReader, StreamingDriver}
import org.apache.spark.sql.{DataFrame, Dataset}

/**
 * ExampleDeltaLake is an object of using the Accelerator overriding the run method
 */
object DeltaLakeExample extends StreamingDriver {

  import MessageReader.sparkSession.implicits._

  override def run(dataSet: Dataset[String]): DataFrame = {

    val result: DataFrame = dataSet
      .flatMap(value => value.split("\\s+"))
      .groupByKey(input => if (input == "hello") input + "world" else input)
      .count()
      .withColumnRenamed(Constants.ExistingNameOfColumn, Constants.NewNameOfColumn)

       result

  }
}
