<%--
  Created by IntelliJ IDEA.
  User: Martin_working
  Date: 2018/9/6
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="link/articlePage_.jsp" %>
<html>
<head>
    <title>${article.articleTitle}</title>
</head>
<body>
<a href="/updateArticle"></a>
<div class="container">
    <div id="test-editormd-view2">
        <textarea id="append-test" style="display:none;">${article.articleMarkdown}
        </textarea>
    </div>
</div>

</body>
</html>
