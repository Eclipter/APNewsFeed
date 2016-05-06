<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple news feed</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="../../css/style.css" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            $('body').on("click", '.heart', function () {
                var A = $(this).attr("id");
                var B = A.split("like");
                var messageID = B[1];
                $(this).css("background-position", "")
                var D = $(this).attr("rel");
                if (D === 'like') {
                    $(this).addClass("heartAnimation").attr("rel", "unlike");
                }
                else {
                    $(this).removeClass("heartAnimation").attr("rel", "like");
                    $(this).css("background-position", "left");
                }
            });
        });
    </script>
</head>
<style>
    body {
        background: url(../../resources/newspaper.jpg) no-repeat;
        background-size: cover;
    }
</style>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="navbar-brand">NEWS FEED FOR HYBRID CLOUD</div>
        </div>
        <ul class="nav navbar-nav">
            <li>
                <a href="#" data-toggle="modal" data-target="#addNewsModal">Add news</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <c:forEach var="news" items="${newsList}">
            <div class="panel panel-default">
                <div class="panel-body">
                    <h3>${news.title}</h3>
                    <img src="${news.imageUrl}" height="300" width="300">
                    <h4>${news.description}</h4>
                    <div align="right" class="feed" id="feed${news.id}">
                        <div class="heart" id="like${news.id}" rel="like"></div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
