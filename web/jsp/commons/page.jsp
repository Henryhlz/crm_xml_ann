<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>分页</title>
</head>
<script language="JavaScript">
    function toPage(num) {
        //1.给表单中提供的一个隐藏域赋值，用于提供当前页
        document.getElementById("pageNum").value = num;
        //2.提交表单
        document.forms[0].submit();
    }
</script>
<style type="text/css">
    td div {
        margin-top: 15px;
    }

    div a {
        border: 1px lightblue solid;
        padding: 3px 3px 3px 3px;
        border-radius: 20%;
    }

    a:active {
        border-left: 3px solid lightblue;
        border-top: 3px solid lightblue;
        border-right: 0px solid white;
        border-bottom: 0px solid white;
    }
</style>
<body>
<div>
    <%--action动作类的pageNum--%>
    <input name="pageNum" value="" id="pageNum" type="hidden"/>
    <a href="javascript:toPage(1)">首页</a>
    <a href="javascript:toPage(${page.upPageNum})">上一页</a>
    <%--遍历显示页号 --%>
    <s:iterator begin="%{page.beginPageNum}" end="%{page.endPageNum}" var="snum">
        <a href="javascript:toPage('${snum}')">${snum}</a>
    </s:iterator>
    <a href="javascript:toPage(${page.nextPageNum})">下一页</a>
    <a href="javascript:toPage(${page.totalPageNum})"> 末页</a>
    &nbsp;&nbsp;&nbsp;&nbsp;
    第${page.currentPageNum}页/共${page.totalPageNum}页
</div>
</body>
</html>
