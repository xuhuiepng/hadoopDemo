package cn.atguigu.mapreduce.inputformat;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SequenceFileDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		args = new String[] {"H:/input2","H:/output2"};
		
		Configuration conf=new Configuration();
		
		Job job = Job.getInstance(conf);
		job.setJarByClass(SequenceFileDriver.class);
		job.setMapperClass(SequenceFileMapper.class);
		job.setReducerClass(SequenceFileReducer.class);
		
		//设置输入的inputFormat
		job.setInputFormatClass(WholeFileInputformat.class);
		//设置输入的outputFormat
		job.setOutputFormatClass(org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(BytesWritable.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(BytesWritable.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
		
	}
	
}
