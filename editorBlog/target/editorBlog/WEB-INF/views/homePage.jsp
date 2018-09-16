<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="link/homePage_.jsp"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form class="form-inline">
    <div class="form-group">
        <input type="text" id="articleTitle" name="articleTitle" autocomplete="off" placeholder="文章标题"
               class="form-control" style="width:500px;">
    </div>
    <div class="form-group">
        <input type="text" id="articleCategory" name="articleCategory" autocomplete="off" placeholder="文章分类"
               class="form-control">
    </div>
    <input type="button" class="btn btn-default" style="width: 100px;" onclick="submitToHomePage()" value="提交">
</form>

<div class="row clearfix">
    <div class="col-md-12 column">
        <div class="row">
            <div id="blog_mdedit">
            </div>
        </div>
    </div>
</div>

</body>
</html>