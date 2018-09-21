<%--
  Created by IntelliJ IDEA.
  User: Martin_working
  Date: 2018/9/13
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
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
                path: "../editor/lib/",
                // theme : "dark",
                // previewTheme : "dark",
                // editorTheme : "pastel-on-dark",
                // markdown : md,
                // codeFold : true,
                //syncScrolling : false,
                saveHTMLToTextarea : true,    // 保存 HTML 到 Textarea
                // searchReplace : true,
                //watch : false,                // 关闭实时预览
                // htmlDecode : "style,script,iframe|on*",            // 开启 HTML 标签解析，为了安全性，默认不开启
                toolbar  : false,             //关闭工具栏
                //previewCodeHighlight : false, // 关闭预览 HTML 的代码块高亮，默认开启
                // emoji : true,
                taskList : true,
                tocm            : true,         // Using [TOCM]
                tex : true,                   // 开启科学公式TeX语言支持，默认关闭
                flowChart : true,             // 开启流程图支持，默认关闭
                sequenceDiagram : true,       // 开启时序/序列图支持，默认关闭,
                //dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为true
                //dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为true
                //dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为true
                //dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为0.1
                //dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff
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
