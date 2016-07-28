<%-- 
    Document   : Task4
    Created on : 2016/07/27, 13:21:58
    Author     : 8mile_000
--%>

<%@page import="java.util.Date"%>
<%@page import="javax.servlet.http.HttpSession"%>       
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            /*課題4 課題3と同じ機能をセッションで作成してください。*/
            
            Date time = new Date();                                             // ユーザーの１回目の訪問
            HttpSession hs = request.getSession(true);
            hs.setAttribute("LastLogin", time.toString());

            out.print("最後のログインは、"+hs.getAttribute("LastLogin"));       // 次の訪問
        %>
    </body>
</html>
