package com.martind.editorBlog.Mapper;

import com.martind.editorBlog.po.Article;

import java.util.List;

public interface EditorBlogMapper {
    void insertArticle(Article article);
    List<Article> queryAllArticle();
    Article queryArticleById(Long id);
    void deleteArticleById(Long id);
    void updateArticle(Article article);
}
