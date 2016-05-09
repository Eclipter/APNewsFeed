<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple news feed</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/style.css" rel="stylesheet"/>
    <link href="../../css/fileinput.min.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="../../js/fileinput.js" type="text/javascript"></script>
    <script src="../../js/fileinput_locale_ru.js" type="text/javascript"></script>
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
                    $.post(
                            "/like",
                            {
                                newsId: messageID
                            }
                    );
                    $(this).addClass("heartAnimation").attr("rel", "unlike");
                }
                else {
                    $.post(
                            "/dislike",
                            {
                                newsId: messageID
                            }
                    );
                    $(this).removeClass("heartAnimation").attr("rel", "like");
                    $(this).css("background-position", "left");
                }
            });
            $('#inputImage').fileinput({
                showUpload: false,
                allowedFileExtensions: ['jpg']
            });
        });
    </script>
</head>
<style>
    body {
        background: url(../../img/newspaper.jpg) no-repeat;
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
<div id="addNewsModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add news</h4>
            </div>
            <form action="<%= blobstoreService.createUploadUrl("/addNews")%>" method="post"
                  enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="inputTitle">Title</label>
                        <input type="text" name="title" class="form-control" id="inputTitle" placeholder="Title"
                               required="">
                    </div>
                    <div class="form-group">
                        <label for="inputDescription">Description</label>
                    <textarea name="description" rows="7" class="form-control" id="inputDescription"
                              required=""></textarea>
                    </div>
                    <div class="form-group">
                        <label for="inputImage">Image</label>
                        <input id="inputImage" type="file" name="image">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="reset" class="btn btn-default">Reset</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <c:forEach var="news" items="${newsList}">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2>${news.title}</h2>
                </div>
                <div class="panel-body">
                    <img src="${news.imageUrl}" style="max-width: 400px; max-height: 400px">
                    <h4>${news.description}</h4>
                    <div class="feed" id="feed${news.id}">
                        <div class="heart" id="like${news.id}" rel="like"></div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
