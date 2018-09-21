<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 2018/9/20
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        .mylogin {
            width: 300px;
            top: 200px;
            left: 650px;
            position: absolute;
        }
    </style>
</head>
<body>

<div style="position:absolute; width:100%; height:100%; z-index:-1">
    <img src="../editor/mylogin.png" height="100%" width="100%"/>
</div>

<div class="mylogin">
    <form action="/login" method="post">
        <div class="form-group">
            <input type="text" class="form-control" id="inputName" name="userName" placeholder="账号"/>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" id="inputPassword" name="userPassword"placeholder="密码"/>
        </div>
        <div align="center">
            <button type="submit" class="btn btn-success" style="width: 100%;">提交</button>
        </div>
    </form>
</div>

<h2 align="center">${msg}</h2>
<%--<script>--%>
    <%--function loginSubmit(){--%>
        <%--var login = new Object();--%>
        <%--login.name = document.getElementById("inputName").value;--%>
        <%--login.password = document.getElementById("inputPassword").value;--%>
        <%--// console.log(login.name);--%>
        <%--.ajax({--%>
            <%--url:"/submitLogin",--%>
            <%--type:post,--%>
            <%--contentType: "application/json",--%>
            <%--data: JSON.stringify(login),--%>
            <%--dataType: "json",--%>
            <%--success: function (data) {--%>
                <%--window.location.href = "/homePage";--%>
            <%--},--%>
            <%--error: function (data) {--%>
                <%--// console.log(data)--%>
                <%--window.location.href="/loginPage";--%>
                <%--// alert("错误！");--%>
            <%--}--%>

        <%--})--%>
    <%--}--%>


<%--</script>--%>


</body>
</html>