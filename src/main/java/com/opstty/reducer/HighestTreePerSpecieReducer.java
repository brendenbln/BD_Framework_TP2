package com.opstty.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class HighestTreePerSpecieReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
}
