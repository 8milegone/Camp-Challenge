<%-- 
    Document   : Task1
    Created on : 2016/07/27, 13:21:23
    Author     : 8mile_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
            <title>Task1</title>
    <body>
            <form action="./Task2.jsp" method="post">
                
                <h3>名前</h3>
                <input type="text" name="txtName">
                <h3>性別</h3>
                <p5>
                    男性
                <input type="radio" name="rdoSex" value="男性">
                    女性
                <input type="radio" name="doSex" value="女性">
                </p5>
                <h3>趣味</h3>
                <textarea name="mulText"></textarea>
                <input type="submit" name="btnSubmit">
                
            </form>
     </body>
</html>
