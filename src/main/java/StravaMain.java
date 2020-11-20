
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


public class StravaMain {


//$ mvn exec:exec -Dspark.master=local -P StravaMain

        public static void main(String[] args) {
            SparkSession spark = SparkSession
                    .builder()
                    .appName("Java Spark SQL on Strava dataset")
                    .config("spark.some.config.option", "some-value")
                    .getOrCreate();

            Dataset<Row> df = spark
                    .read()
                    .option("multiline", "true")
                    .json("dataset/strava_activities.json");  //it could be necessary to specify the absolute path for the file

            df.createOrReplaceTempView("strava_activities");

            // Longest Ride Activity
            Dataset<Row> sql1DF = spark.sql("SELECT MAX(`Elapsed Time`) FROM strava_activities Where `Activity Type`= 'Ride'");
            sql1DF.show();

            //Longest 'Walk' activity
            Dataset<Row> sql2DF = spark.sql("SELECT MAX(`Elapsed Time`) FROM strava_activities Where `Activity Type` = 'Walk'");
            sql2DF.show();

            //Maximun elevation gain
            Dataset<Row> sql3DF = spark.sql("SELECT MAX(`Elevation Gain`) FROM strava_activities");
            sql3DF.show();

            //Lowest average temperature
            Dataset<Row> sql4DF = spark.sql("SELECT MIN(`Average Temperature`) FROM strava_activities");
            sql4DF.show();

            //Higest average temperature
            Dataset<Row> sql5DF = spark.sql("SELECT MAX(`Average Temperature`) FROM strava_activities");
            sql5DF.show();

            //Maximun calories
            Dataset<Row> sql6DF = spark.sql("SELECT MAX(`Calories`) FROM strava_activities");
            sql6DF.show();

            //Max speed
            Dataset<Row> sql7DF = spark.sql("SELECT MAX(`Max Speed`) FROM strava_activities");
            sql7DF.show();

            //Longest moving time
            Dataset<Row> sql8DF = spark.sql("SELECT MAX(`Moving Time`) FROM strava_activities");
            sql8DF.show();

            //Last and first activites
            Dataset<Row> sql9DF = spark.sql("SELECT `Activity ID` FROM strava_activities ORDER BY `Activity ID` ASC Limit 1");
            sql9DF.show();

            Dataset<Row> sql10DF = spark.sql("SELECT `Activity ID` FROM strava_activities ORDER BY `Activity ID` DESC Limit 1");
            sql10DF.show();

            //Count activities
            Dataset<Row> sql11DF = spark.sql("SELECT COUNT(`Activity ID`) FROM strava_activities");
            sql11DF.show();



        }





}
