package com.hiyond.lucene.core;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;

/**
 * Created by hiyond on 2016/9/6.
 */
public class LuceneTest {

    public static void main(String[] args) throws IOException, ParseException {
        RAMDirectory directory = new RAMDirectory();


        StandardAnalyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

        Document doc = new Document();

        doc.add(new Field("name", "lin zhengle", TextField.TYPE_STORED));
        indexWriter.addDocument(doc);

        doc = new Document();
        doc.add(new Field("address", "中国上海", TextField.TYPE_STORED));
        indexWriter.addDocument(doc);

        doc = new Document();
        doc.add(new Field("dosometing", "I am learning lucene ",TextField.TYPE_STORED));
        indexWriter.addDocument(doc);

        doc = new Document();
        doc.add(new Field("dosometing", "learning lucene hehe hehe", TextField.TYPE_STORED));
        indexWriter.addDocument(doc);
        indexWriter.close();

        DirectoryReader directoryReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(directoryReader);
        Term term = new Term("dosometing", "lucene");
        Query query = new TermQuery(term);
//        QueryParser queryParser = new QueryParser("dosometing",analyzer);
//        query = queryParser.parse("lucene");
        TopDocs topDocs = indexSearcher.search(query,2);
        System.out.println(topDocs.totalHits);
        for (ScoreDoc scoreDoc : topDocs.scoreDocs){
            Document document = indexSearcher.doc(scoreDoc.doc);
            System.out.println(document.get("dosometing"));
        }


        indexWriter.close();
        directory.close();
    }
}
