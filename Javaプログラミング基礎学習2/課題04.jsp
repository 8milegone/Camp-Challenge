<%-- 
    Document   : 課題4
    Created on : 2016/07/12, 14:16:05
    Author     : 8mile_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
     //課題4 for文を利用して、"A"を30個連結する処理を実現してください。    
     String message = "A" ;//動画で指定された通り先に文字列の変数を作成
     for (int i = 0 ; i < 30 ; i++ )
     {  out.println(message);//作成した変数をi<30の条件内で表示するようにしています。
     }
    %>
    </body>
</html>
