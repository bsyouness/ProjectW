import com.datastax.spark.connector.cql.CassandraConnector
import org.apache.spark.sql.{cassandra, SaveMode, Row, SQLContext}
import org.apache.spark.{SparkContext, SparkConf}
import com.datastax.spark.connector._
// import java.io._

object projectW{
  def main(args: Array[String]) {
    val conf = new SparkConf(true)
                .set("spark.cassandra.connection.host","52.33.250.208")
                .setAppName("projectW")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    
    try {

      val df = sqlContext.read.json("hdfs://ec2-52-33-208-8.us-west-2.compute.amazonaws.com:9000/camus/topics/wiki-data/hourly/2016/01/21/16/wiki-data.3.0.251191.409275.1453420800000.gz")
      val word_df = sqlContext.sql("SELECT * FROM words")
      word_df.show
      // df.write.format("org.apache.spark.sql.cassandra")
      //   .options(Map("table" -> "en", "keyspace" -> "wikidata"))
      //   .save() //mode(SaveMode.Append).save()

    } catch {
      case e: Exception =>
        println("Exe: ====== "+e.printStackTrace())
        println("Message :  ======= " +e.getMessage)
        println("Details "+e.getCause)
        e.fillInStackTrace()

/*    val wikiBatch = sc.textFile("hdfs://ec2-52-33-208-8.us-west-2.compute
        .amazonaws.com:9000/wiki-batch/enwiki-20080103.main.bz2")
    val wikiGroup = wikiBatch.grouped(14).map(_.dropRight(1))
    val wikiBatchGroup = wikiBatch.zipWithIndex.groupBy(x => x._2/14)
        .sortBy(._1.map(x => ) 
        */
    }
  }             

  // def streaming(args: Array[String]) { 
  //   val df = sqlContext.read.json("""hdfs://ec2-52-33-208-8.us-west-2
  //       .compute.amazonaws.com:9000/camus/topics/wiki-data/hourly/2016
  //       /01/20/10/wiki-data.3.0.122150.158084.1453312800000.gz""")
  //   df.groupBy("bot").count().show()
  // }

}
