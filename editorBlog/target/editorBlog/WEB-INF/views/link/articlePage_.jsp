<%--
  Created by IntelliJ IDEA.
  User: Martin_working
  Date: 2018/9/13
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="../editor/examples/css/style.css"/>
<link rel="stylesheet" href="../editor/css/editormd.preview.css"/>
<link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon"/>
<style>
    .editormd-html-preview {
        width: 50%;
        margin: 0 auto;
    }
</style>
<script src="../editor/examples/js/jquery.min.js"></script>
<script src="../editor/lib/marked.min.js"></script>
<script src="../editor/lib/prettify.min.js"></script>
<script src="../editor/lib/raphael.min.js"></script>
<script src="../editor/lib/underscore.min.js"></script>
<script src="../editor/lib/sequence-diagram.min.js"></script>
<script src="../editor/lib/flowchart.min.js"></script>
<script src="../editor/lib/jquery.flowchart.min.js"></script>
<script src="../editor/editormd.js"></script>


<script type="text/javascript">
    $(function () {
        var testEditormdView, testEditormdView2;

        $.get("test.md", function (markdown) {

            testEditormdView = editormd.markdownToHTML("test-editormd-view", {
                markdown: markdown,//+ "\r\n" + $("#append-test").text(),
                //htmlDecode      : true,       // 开启 HTML 标签解析，为了安全性，默认不开启
                htmlDecode: "style,script,iframe",  // you can filter tags decode
                //toc             : false,
                tocm: true,    // Using [TOCM]
                //tocContainer    : "#custom-toc-container", // 自定义 ToC 容器层
                //gfm             : false,
                //tocDropdown     : true,
                // markdownSourceCode : true, // 是否保留 Markdown 源码，即是否删除保存源码的 Textarea 标签
                emoji: true,
                taskList: true,
                tex: true,  // 默认不解析
                flowChart: true,  // 默认不解析
                sequenceDiagram: true,  // 默认不解析
            });

            //console.log("返回一个 jQuery 实例 =>", testEditormdView);

            // 获取Markdown源码
            //console.log(testEditormdView.getMarkdown());

            //alert(testEditormdView.getMarkdown());
        });

        testEditormdView2 = editormd.markdownToHTML("test-editormd-view2", {
            htmlDecode: "style,script,iframe",  // you can filter tags decode
            emoji: true,
            taskList: true,
            tex: true,  // 默认不解析
            flowChart: true,  // 默认不解析
            sequenceDiagram: true,  // 默认不解析
        });
    });
</script>
<body>

</body>
</html>
