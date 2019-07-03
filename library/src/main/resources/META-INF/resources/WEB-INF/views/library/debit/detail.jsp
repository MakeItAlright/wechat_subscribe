<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>借阅归还</title>
    <style type="text/css">
        .item:hover{
            background-color: #aaa;
        }
    </style>
</head>
<body>
    图书列表：<br />
    <c:forEach items="${debitList.items }" var="item">
        <div class="item">
            <%--借阅时间：${item.book.borrowtime}--%>
                    ${item.book.name }
                <a href="/library/debit/refer/${item.book.id }" style="float: right;">归还</a>
            <%--归还时间：${item.book.refertime}--%>
        </div>
    </c:forEach>

    <a href="/library/debit/list">返回</a>

</body>
</html>