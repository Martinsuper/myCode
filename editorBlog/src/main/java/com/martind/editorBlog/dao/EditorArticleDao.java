package com.martind.editorBlog.dao;


import com.martind.editorBlog.po.Article;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.List;

public interface EditorArticleDao {
    void insertArticle(Article article) throws IOException;
    List<Article> queryAllArticle() throws IOException;
    Article queryArticleById(Long id) throws IOException;
    void deleteArticleById(Long id) throws IOException;
    void updateArticle(Article article) throws IOException;
    void outputToMarkdown(List<Article> articleList, String path) throws IOException;
    void outputToArticle(Article article, String path) throws IOException;
}
