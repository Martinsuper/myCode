package com.martind.editorBlog.po;

import java.util.Date;

public class Article {
    private Long id;
    private Date firstEditorTime;
    private Date modifyTime;
    private String articleTitle;
    private String articleContent;
    private String articleCategory;
    private String articleMarkdown;
    private String articleHtml;

    public Article() {
    }

    public Article(Long id, Date firstEditorTime, Date modifyTime, String articleTitle, String articleContent, String articleCategory, String articleMarkdown, String articleHtml) {
        this.id = id;
        this.firstEditorTime = firstEditorTime;
        this.modifyTime = modifyTime;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleCategory = articleCategory;
        this.articleMarkdown = articleMarkdown;
        this.articleHtml = articleHtml;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFirstEditorTime() {
        return firstEditorTime;
    }

    public void setFirstEditorTime(Date firstEditorTime) {
        this.firstEditorTime = firstEditorTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(String articleCategory) {
        this.articleCategory = articleCategory;
    }

    public String getArticleMarkdown() {
        return articleMarkdown;
    }

    public void setArticleMarkdown(String articleMarkdown) {
        this.articleMarkdown = articleMarkdown;
    }

    public String getArticleHtml() {
        return articleHtml;
    }

    public void setArticleHtml(String articleHtml) {
        this.articleHtml = articleHtml;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", firstEditorTime=" + firstEditorTime +
                ", modifyTime=" + modifyTime +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleCategory='" + articleCategory + '\'' +
                ", articleMarkdown='" + articleMarkdown + '\'' +
                ", articleHtml='" + articleHtml + '\'' +
                '}';
    }
}
