<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
</head>
<style>
    body {
        background: url(../../img/newspaper.jpg);
    }
</style>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="navbar-brand">NEWS FEED FOR HYBRID CLOUD</div>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="panel panel-danger">
            <div class="panel-heading">
                <div class="panel-title">
                    Error
                </div>
            </div>
            <div class="panel-body">
                ${errorMessage}
            </div>
        </div>
    </div>
</div>
</body>
</html>
