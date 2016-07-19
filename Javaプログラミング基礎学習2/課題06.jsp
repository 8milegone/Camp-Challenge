<%-- 
    Document   : 課題6
    Created on : 2016/07/12, 14:16:29
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
    //課題6 while文を利用して、以下の処理を実現してください。
    //1000を2で割り続け、100より小さくなったらループを抜ける処理。   
    int num = 1000 ;
    while (num > 100)
    {   num = num/2 ;
        out.println (num) ; 
        //最後のnumが62になるのでそこで(num>100)の条件外でループを抜けます。
    }
    %>
    </body>
</html>
