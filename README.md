This Map Reduces works over a set of data where each column is separated by a **TAB** (\t).

We don't care if there are more than two, but at least must have two. And the field we are going to process is the second one. In our case we expect a Hostname

```
2015 hostname1.com
2014 hostname2.net
```

To execute it you first needs to compile java class:

`javac -classpath $HADOOP_HOME/hadoop-core.jar *.java`

Pack at them into a JAR file:

`jar cvf program_count.jar *.class`

And then add and execute the jar using Hadoop:

`hadoop jar program_count.jar ProgramCount set-of-logs path-destination`

