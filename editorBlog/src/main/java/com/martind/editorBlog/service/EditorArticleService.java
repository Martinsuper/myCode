package com.martind.editorBlog.service;

import com.martind.editorBlog.po.Article;
import com.martind.editorBlog.po.User;

import java.io.IOException;
import java.util.List;

public interface EditorArticleService {
    void insertArticle(Article article) throws IOException;
    List<Article> queryAllArticle() throws IOException;
    Article queryArticleById(Long id) throws IOException;
    void deleteArticleById(Long id) throws IOException;
    void updateArticle(Article article) throws IOException;
    void outputToMarkdown(List<Article> articleList, String path) throws IOException;
    void outputToArticle(Article article,String path) throws IOException;
    User queryUser(String name) throws IOException;
}
