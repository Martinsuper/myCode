package com.martind.editorBlog.service.impl;

import com.martind.editorBlog.dao.EditorArticleDao;
import com.martind.editorBlog.po.Article;
import com.martind.editorBlog.service.EditorArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EditorArticleServiceImpl implements EditorArticleService {

    @Autowired
    private EditorArticleDao editorArticleDao;
    @Override
    public void insertArticle(Article article) throws IOException {
        editorArticleDao.insertArticle(article);
    }

    @Override
    public List<Article> queryAllArticle() throws IOException {
        return editorArticleDao.queryAllArticle();
    }

    @Override
    public Article queryArticleById(Long id) throws IOException {
        return editorArticleDao.queryArticleById(id);
    }

    @Override
    public void deleteArticleById(Long id) throws IOException {
        editorArticleDao.deleteArticleById(id);
    }

    @Override
    public void updateArticle(Article article) throws IOException {
        editorArticleDao.updateArticle(article);
    }

    @Override
    public void outputToMarkdown(List<Article> articleList, String path) throws IOException {
        editorArticleDao.outputToMarkdown(articleList,path);
    }

    @Override
    public void outputToArticle(Article article, String path) throws IOException {
        editorArticleDao.outputToArticle(article,path);
    }
}
