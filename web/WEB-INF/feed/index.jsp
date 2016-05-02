<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple news feed</title>
  </head>
  <style>
      body {
          background: url(../../resources/fuck-you2.jpg) no-repeat;
          background-size: cover;
      }
  </style>
  <body>
  <h1>GAE + Spring Example</h1>
  <h3>${message}</h3>
  <h3>Message from db: ${imagePath}</h3>
  <h3>Bucket: ${bucket}</h3>
  <img src="https://www.googleapis.com/storage/v1/b/newsfeed_data/o/images%2fcover.jpg">
  </body>
</html>
