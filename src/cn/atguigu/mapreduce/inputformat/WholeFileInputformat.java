package cn.atguigu.mapreduce.inputformat;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

public class WholeFileInputformat  extends FileInputFormat<NullWritable, BytesWritable>{

	@Override
	protected boolean isSplitable(JobContext context, Path filename) {
		// 是否分割
		return false;
	}
	
	@Override
	public RecordReader<NullWritable, BytesWritable> createRecordReader(InputSplit split, TaskAttemptContext context)
			throws IOException, InterruptedException {
		//创建对象
		WholeRecordReader recordReader = new WholeRecordReader();
		//初始化
		recordReader.initialize(split, context);
		return recordReader;
	}

	
}
