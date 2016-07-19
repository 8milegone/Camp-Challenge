<%-- 
    Document   : 課題5
    Created on : 2016/07/12, 14:16:17
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
    //課題5 for文を利用して、0から100を全部足す処理を実現してください。    
    int count = -1;
    //"0から100を全部足す処理"だと実際は0から100までを表示させると認識したので、-1を要素数にしています。
    for (int i = 0 ; i<101 ; i++)//上記の理由から101回繰り返す様に指定しています。
    {   count = count + 1 ;
        out.println( count ) ;//作成した変数をi<101の条件内で表示するようにしています。
    }
    %>
    </body>
</html>
