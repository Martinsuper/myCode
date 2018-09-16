package com.martind.editorBlog.controller;

import com.martind.editorBlog.po.Article;
import com.martind.editorBlog.service.EditorArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class EditorBlogArticleController {
    @Autowired
    private EditorArticleService editorArticleService;

    @RequestMapping("/")
    public String home() {
        return "homePage";
    }

    @RequestMapping(value = "/insertArticle")
    @ResponseBody
    public boolean insertArticle(@RequestBody Article article) throws IOException {
        article.setFirstEditorTime(new Date());
        article.setModifyTime(new Date());
        editorArticleService.insertArticle(article);
        String mypath = System.getProperty("user.dir")+"\\markdown\\";
        editorArticleService.outputToArticle(article,mypath);
        return true;
    }

    @RequestMapping(value = "/queryAllArticle")
    public String queryAllArticle(Model model) throws IOException {
        List<Article> articleList = editorArticleService.queryAllArticle();
        model.addAttribute("articleList", articleList);
        return "queryAllArticleResult";
    }

    @RequestMapping(value = "/queryArticleById/{id}")
    public String queryArticleById(@PathVariable Long id, Model model) throws IOException {
        Article article = editorArticleService.queryArticleById(id);
        model.addAttribute("article", article);
        return "articlePage";
    }

    @RequestMapping(value = "/deleteArticleById/{id}")
    public String deleteArticleById(@PathVariable Long id) throws IOException {
        editorArticleService.deleteArticleById(id);
        System.out.println(id);
        return "redirect: /queryAllArticle";
    }

    @RequestMapping(value = "/updateArticle")
    @ResponseBody
    public boolean updateArticle(@RequestBody Article article) throws IOException {
//        Article article = editorArticleService.queryArticleById(id);
        try {
            article.setModifyTime(new Date());
            editorArticleService.updateArticle(article);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/editorArticle/{id}")
    public String editorArticle(@PathVariable Long id, Model model) throws IOException {
        Article article = editorArticleService.queryArticleById(id);
        model.addAttribute("article", article);
        return "editorPage";
    }

    @RequestMapping(value = "/outputToMarkdown")
    public String outputToMarkdown() throws IOException {
        List<Article> articleList = editorArticleService.queryAllArticle();
        String mypath = System.getProperty("user.dir")+"\\markdown";
        editorArticleService.outputToMarkdown(articleList,mypath);
        return "success";
    }
}
