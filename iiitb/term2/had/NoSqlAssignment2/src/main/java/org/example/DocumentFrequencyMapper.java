package org.example;

import opennlp.tools.stemmer.PorterStemmer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class DocumentFrequencyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] words = line.split("\\s+");

        File file = new File(context.getConfiguration().get("filePath"));
        Set<String> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String tempString = br.readLine();

        while(tempString != null) {
            StringTokenizer st = new StringTokenizer(tempString);
            while(st.hasMoreTokens()){
                set.add(st.nextToken().toLowerCase());
            }
            tempString = br.readLine();
        }
        br.close();

        PorterStemmer porterStemmer = new PorterStemmer();
        Set<String> uniqueWords = new HashSet<>();

        for (String w : words) {
            String afterStemmingW = porterStemmer.stem(w);
            if (!set.contains(afterStemmingW.toLowerCase())) {
                uniqueWords.add(afterStemmingW);
            }
        }

        for (String w : uniqueWords) {
            word.set(w);
            context.write(word, one);
        }
    }
}