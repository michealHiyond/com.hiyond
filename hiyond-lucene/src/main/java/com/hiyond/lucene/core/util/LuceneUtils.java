package com.hiyond.lucene.core.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by hiyond on 2016/9/6.
 */
public class LuceneUtils {

    public static IndexWriter getIndexWriter(String indexPath, boolean create) throws IOException {
        //创建目录对象
        Directory directory = FSDirectory.open(Paths.get(indexPath, new String[0]));

        //创建分析器
        Analyzer analyzer = new StandardAnalyzer();

        //IndexWriterConfig对象创建,
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        if(create){
            //如果是创建索引
            indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        }else {
            //追加索引
            indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        }

        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

        return indexWriter;
    }

    public static void main(String[] args) {
        System.out.println(Double.valueOf(".01")*100);
        System.out.println(1.000 == 1);

    }


}
