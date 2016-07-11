<%-- 
    Document   : 課題2
    Created on : 2016/07/06, 17:24:15
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
        //課題2「groove」「-」「gear」の３つの文字列を連結して表示してください。
        //変数作成
        String message = "groove";
        //文字列作成
        out.println(message+'-'+"gear");
        //messageの変数と「'」で-を表現し最後に「"」でgearを表現してみました。
        %>
    </body>
</html>
