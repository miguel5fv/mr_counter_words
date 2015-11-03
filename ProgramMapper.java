import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class ProgramMapper extends MapReduceBase implements
    Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value,
      OutputCollector<Text, IntWritable> output, Reporter reporter)
      throws IOException {
    String s = value.toString();
        String[] fields = s.split("\\t+");

        // Hostname is the 2nd column. I want to count the words separated by "."
        String [] wordsIntoHost = fields[1].split("\\.");
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < wordsIntoHost.length; i++) s{
                int occurrences = 1;
                if ( null != map.get(wordsIntoHost[i]))
                {
                    map.put(wordsIntoHost[i], occurrences);
                }
        }

        for (String keyMap : map.keySet()) {
            output.collect(new Text(keyMap), new IntWritable(map.get(keyMap)));
        }
    }
}
