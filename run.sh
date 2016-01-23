#sbt assembly
# /usr/local/spark/bin/spark-submit --master spark://ip-172-31-3-12:7077 --executor-memory 6000M --driver-memory 6000M /home/ubuntu/target/scala-2.10/sparkconsumer_2.10-0.0.1.jar
# ~/bin/spark/bin/spark-submit --master spark://ip-172-31-3-12:7077 --executor-memory 6000M --driver-memory 6000M $(pwd)/target/scala-2.10/SparkConsumer-assembly-0.0.1.jar
~/bin/spark/bin/spark-submit --master spark://ec2-52-33-208-8.us-west-2.compute.amazonaws.com:7077 --executor-memory 6000M --driver-memory 6000M $(pwd)/target/scala-2.10/SparkConsumer-assembly-0.0.1.jar
