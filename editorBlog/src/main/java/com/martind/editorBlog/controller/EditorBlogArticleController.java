package com.martind.editorBlog.controller;

import com.martind.editorBlog.po.Article;
import com.martind.editorBlog.po.User;
import com.martind.editorBlog.service.EditorArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static java.io.File.separator;

@Controller
public class EditorBlogArticleController {
    @Autowired
    private EditorArticleService editorArticleService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String home() {
        return "loginPage";
    }
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String subminLogin(User submitUser, Model model, HttpSession session) throws IOException {
        User user = editorArticleService.queryUser(submitUser.getUserName());
        if(user!=null&&user.getUserPassword().equals(submitUser.getUserPassword())){
            session.setAttribute("USER_SESSION",submitUser);
            return "redirect:/editorPage";
        }
        model.addAttribute("msg","用户名或密码错误，请重新登录！");
        return "loginPage";
    }
    @RequestMapping(value = "/editorPage")
    public String editorPage(){
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
            editorArticleService.outputToArticle(article,System.getProperty("user.dir")+separator +"markdown");
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
        String mypath = System.getProperty("user.dir")+separator +"markdown";
        editorArticleService.outputToMarkdown(articleList,mypath);
        return "success";
    }
}
