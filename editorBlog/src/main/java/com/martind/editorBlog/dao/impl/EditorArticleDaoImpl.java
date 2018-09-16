package com.martind.editorBlog.dao.impl;

import com.martind.editorBlog.Mapper.EditorBlogMapper;
import com.martind.editorBlog.dao.EditorArticleDao;
import com.martind.editorBlog.po.Article;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

@Repository
public class EditorArticleDaoImpl implements EditorArticleDao {

    @Override
    public void insertArticle(Article article) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession opensession = sqlSessionFactory.openSession(true);
        try {
            EditorBlogMapper mapper = opensession.getMapper(EditorBlogMapper.class);
            mapper.insertArticle(article);
        } finally {
            opensession.close();
        }
    }

    @Override
    public Article queryArticleById(Long id) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession opensession = sqlSessionFactory.openSession(true);
        try {
            EditorBlogMapper mapper = opensession.getMapper(EditorBlogMapper.class);
            Article article = mapper.queryArticleById(id);
            return article;
        } finally {
            opensession.close();
        }
    }

    @Override
    public List<Article> queryAllArticle() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession opensession = sqlSessionFactory.openSession(true);
        try {
            EditorBlogMapper mapper = opensession.getMapper(EditorBlogMapper.class);
            List<Article> articleList = mapper.queryAllArticle();
            return articleList;
        } finally {
            opensession.close();
        }
    }

    @Override
    public void deleteArticleById(Long id) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession opensession = sqlSessionFactory.openSession(true);
        try {
            EditorBlogMapper mapper = opensession.getMapper(EditorBlogMapper.class);
            mapper.deleteArticleById(id);
        } finally {
            opensession.close();
        }
    }

    @Override
    public void updateArticle(Article article) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession opensession = sqlSessionFactory.openSession(true);
        try {
            EditorBlogMapper mapper = opensession.getMapper(EditorBlogMapper.class);
            mapper.updateArticle(article);
        } finally {
            opensession.close();
        }
    }

    @Override
    public void outputToMarkdown(List<Article> articleList, String path) throws IOException {
        File folder = new File(path);
        folder.mkdirs();
        for (Article article : articleList) {
            File file = new File(path + "\\" + article.getArticleTitle() + ".md");
            FileOutputStream out = new FileOutputStream(file, true);
            StringBuffer buffer = new StringBuffer();
            buffer.append(article.getArticleMarkdown());
            out.write(buffer.toString().getBytes("utf-8"));
            buffer.setLength(0);
        }
    }

    @Override
    public void outputToArticle(Article article, String path) throws IOException {
        File folder = new File(path);
        if(folder.exists()){
            System.out.println("文件已存在！");
        }
        else{
            folder.mkdirs();
        }
        File file = new File(path + article.getArticleTitle() + ".md");
        if(file.exists()){
            file.delete();
            System.out.println("delete!!");
        }else{
            file.createNewFile();
        }
        StringBuffer buffer = new StringBuffer();
        FileOutputStream out = new FileOutputStream(file,true);
        buffer.append(article.getArticleMarkdown());
        out.write(buffer.toString().getBytes("utf-8"));
        buffer.setLength(0);
    }
}
