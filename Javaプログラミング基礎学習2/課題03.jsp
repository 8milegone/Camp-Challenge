<%-- 
    Document   : 課題3
    Created on : 2016/07/12, 14:15:53
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
    //課題3 for文を利用して、8を20回掛ける処理を実現してください。        
    long h = 1;
    for (int i = 0 ; i < 20 ; i++ )  
    {   h = h*8 ;
        out.println(h);
    }
        
    %>
    </body>
</html>
