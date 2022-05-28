import org.apache.spark.sql.SparkSession

object CounterDemo {
 def main(args: Array[String]): Unit = {
   val conf = new SparkConf().setAppName("CounterDemo").setMaster("local[*]")
   val sc = new SparkContext(conf);
   val spark = SparkSession.builder.appName("Test app").getOrCreate()
   val path = "/home/nikitka/tourist.csv"
   val df = spark.read.option("header", "true").csv(path)
   df.show()
   df.createOrReplaceTempView("tourist")
   spark.sql("select tourist_id, count(tourist_id) as counter from click group by tourist_id").show()
   spark.stop()
 }
}
