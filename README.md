# Spark-SQL-Strava
Using Spark SQL with Strava Dataset


This was made with IntelliJ IDE as a Maven project.

# Search in Strava activities

Using the data provided in this dataset, you have to search for:

    Longest 'Ride' activity
    Longest 'Walk' activity
    Maximun elevation gain
    Lowest average temperature
    Higest average temperature
    Maximun calories
    Max speed
    Longest moving time
    Last and first activites
    Count activities

You may want to use Spark DataFrame and/or Spark SQL.

As a reference, use the Spark SQL documentation at https://spark.apache.org/docs/latest/sql-programming-guide.html


Compile sources

$ mvn clean && mvn package

Run the Main class locally

$ mvn exec:exec

Run the Main class on Hadoop cluster

$ spark-submit \
  --master yarn \
  --driver-memory 512m  \
  --executor-memory 512m \
  --class it.StravaMain \
  --deploy-mode cluster \
  target/search-strava-1.0-SNAPSHOT.jar
