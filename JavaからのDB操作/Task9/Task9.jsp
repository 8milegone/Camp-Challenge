<%-- 
    Document   : java_DB09
    Created on : 2016/07/09, 23:42:01
    Author     : yoshikawatoshio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        課題9:フォームからデータを挿入できる処理を構築してください。
      <form action="Task9" method="post" >
            ＩＤ：<input type="number" name="id"><br>
            名前：<input type="text" name="name"><br>
            電話番号：<input type="text" name="tell"><br>
            年齢：<input type="number" name="age"><br>
            生年月日：
            <input type="text" name="year"><br>
            <input type="text" name="month"><br>
            <input type="text" name="day"><br><br>
            
            <input type="submit" value="送信">
        </form>
    </body>
</html>