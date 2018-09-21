<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 2018/9/13
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="link/editorPage_.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

<body>

<form class="form-inline">
    <div class="form-group">
        <input type="text" id="articleTitle" name="articleTitle" value="${article.articleTitle}" autocomplete="off" placeholder="文章标题"
               class="form-control" style="width:500px;">
    </div>
    <div class="form-group">
        <input type="text" id="articleCategory" name="articleCategory" value="${article.articleCategory}" autocomplete="off" placeholder="文章分类"
               class="form-control">
    </div>
    <input type="button" class="btn btn-default" style="width: 100px;" onclick="submitToEditorPage()" value="提交">
</form>

<div class="row clearfix">
    <div class="col-md-12 column">
        <div class="row">
            <div id="blog_mdedit">
                <textarea>${article.articleMarkdown}</textarea>
            </div>
        </div>
    </div>
</div>

</body>
</html>