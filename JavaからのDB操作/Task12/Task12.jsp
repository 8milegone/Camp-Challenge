<%-- 
    Document   : Task12
    Created on : 2016/08/05, 13:19:12
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
         課題12 検索用のフォームを用意し、名前、年齢、誕生日を使った複合検索ができるようにしてください。
        <form action="Task12" method="post" >
        検索ワード(名前)：<input type="text" name="NAME"><br>
        検索ワード(年齢)：<input type="number" name="AGE"><br>
        検索ワード(誕生日)<br><br>
        (年)：<input type="text" name="Year"><br>
        (月)：<input type="text" name="Month"><br>
        (日)：<input type="text" name="Day"><br>
            <br><br>
        <input type="submit" value="送信">
       </form>
    </body>
</html>
