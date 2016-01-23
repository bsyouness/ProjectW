#sbt assembly
/usr/local/spark/bin/spark-submit --master spark://ip-172-31-3-12:7077 --executor-memory 6000M --driver-memory 6000M /home/ubuntu/target/scala-2.10/sparkconsumer_2.10-0.0.1.jar