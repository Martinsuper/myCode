<%--
  Created by IntelliJ IDEA.
  User: Martin_working
  Date: 2018/9/13
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="../editor/examples/css/style.css"/>
    <link rel="stylesheet" href="../editor/css/editormd.css"/>
    <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>

    <script src="../editor/examples/js/jquery.min.js"></script>
    <script src="../editor/editormd.js"></script>
    <script type="text/javascript">
        $(function () {
            md_edit = editormd("blog_mdedit", {
                width: "90%",
                height: 800,
                syncScrolling: "single",
                emoji: true,
                path: "../editor/lib/",
                saveHTMLToTextarea: true
            });
        });


        function submitToEditorPage() {
            console.log(md_edit.getMarkdown())
            console.log(md_edit.getHTML())
            var formData = new Object();
            formData.articleMarkdown = md_edit.getMarkdown();
            formData.articleHtml = md_edit.getHTML();
            formData.articleTitle = document.getElementById("articleTitle").value;
            formData.articleCategory = document.getElementById("articleCategory").value;
            formData.id = ${article.id};
            $.ajax({
                url: "/updateArticle",
                type: "post",
                contentType:"application/json",
                data: JSON.stringify(formData),
                dataType:"json",
                success:function (data) {
                    window.location.href = "/queryAllArticle";
                },
                error:function (e) {
                    alert("错误！");
                }
            });
        }
    </script>
</head>
<body>

</body>
</html>
