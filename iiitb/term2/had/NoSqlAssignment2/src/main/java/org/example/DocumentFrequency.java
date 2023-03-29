package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DocumentFrequency {

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println("Please provide 3 arguments\n1. Path to folder where all files are in hadoop fs\n2. Output file path in hadoop fs\n3. Path to stopwords.txt in local file system\n");
            System.exit(0);
        }

        Configuration conf = new Configuration();

        conf.set("filePath", args[2]);

        Job job = Job.getInstance(conf, "document frequency");
        job.setJarByClass(DocumentFrequency.class);
        job.setMapperClass(DocumentFrequencyMapper.class);
        job.setCombinerClass(DocumentFrequencyReducer.class);
        job.setReducerClass(DocumentFrequencyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}




































//        if (files == null) {
//            System.out.println("No files found");
//            System.exit(0);
//        }
//
//        System.out.println("files lngth" + files.length);
//        System.out.flush();
//
//        if (files.length == 0)  {
//            System.out.println("No files found");
//            System.exit(0);
//        }
//        for (File file : files) {
//            if (file.isFile()) {
//                MultipleInputs.addInputPath(job, new Path(file.getPath()), TextInputFormat.class);
//            }
//        }