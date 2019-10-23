# xl8r-delta-lake
  
It consists of methods which are mostly used while a job is related to apache spark and write into delta lake.  
  
## Table of contents  
1. [Getting Started](#Getting-Started)  
2. [How to Use](#How-to-Use)  
3. [How to Run](#How-to-Run)  
4. [Example](#Example)  
  
## Getting Started  
#### Minimum requirements  
To run the SDK you will need  **Java 1.8+, Scala 2.12.8, SBT 1.2.8**.   
  
#### Installation  
The way to use this project is to clone it from github and build it using sbt.  
  
## How to use   
We need to extend the `StructuredStreamingJob` trait and override the run method and write the job operations there.  

  
```scala  
object ExampleDeltalake extends StructuredStreamingJob {

  import InputSource.sparkSession.implicits._

  override def run(dataSet: Dataset[String]) = {

    // your codes here

   }

}

```  
  
#### Abstract Methods  
```scala 
 
  override def run(dataSet: Dataset[String]) : Unit

```  
  
#### Concrete Methods  
  
The available concrete methods are -   
  
```scala  
 def takeInput(): DataFrame
 
def writeToDelta(outputDataFrame: DataFrame, filePath: String, checkPointPath: String)

extractDfReadFromMultipleTopic(dataframe: DataFrame, topicName: String): DataFrame 

```  
## How to Run 
While running, we have to pass all the arguments written in application.conf file ```src/main/resources/application.conf```, we can pass it by writing a shell script and run the script before running the applicstion.  
  
## Example 
   
#### Writing to delta lake  :
By calling ```writeToDelta``` function with the required parameters ```dataFrame: Dataframe```,```filepath:String```, ```checkpointPath:String```we can write the processed data into delta lake.  
