<%-- 
    Document   : Task2
    Created on : 2016/07/27, 13:21:40
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
        /*課題2 以下の機能を実装してください。
          課題1で作成したHTMLの入力データを取得し、画面に表示する*/

        request.setCharacterEncoding("UTF-8");
        String name =request.getParameter("txtName");
        String sexm =request.getParameter("rdoSex");
        String sexw =request.getParameter("doSex");
        String hobby =request.getParameter("mulText");
        
        response.setContentType("text/html; charset=UTF-8");
        out.println("名前");
        out.println(name);
        out.println("<br>");
        out.println("性別");
        out.println(sexm);
        out.println(sexw);
        out.println("<br>");
        out.println("趣味");
        out.println(hobby);
        
    %>
    </body>
</html>

    </body>
</html>
