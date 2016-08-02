<%-- 
    Document   : Task10
    Created on : 2016/08/01, 17:38:49
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
        課題11:profileIDで指定したレコードの、profileID以外の要素をすべて上書きできるフォームを作成してください<br><br>
      <form action="Task11" method="post" >
            上書き対象のprofileID：<input type="number" name="alloverdrive"><br>
            
            入力したID以外の①名前,②電話番号,③年齢,④生年月日が上書きされます。<br><br>
            ①名前:<input type="text" name="name"><br><br>
            ②電話番号:<input type="text" name="tell"><br><br>
            ③年齢:<input type="number" name="age"><br><br>
            ④生年月日<br>
            <input type="text" name="year">年<br>
            <input type="text" name="month">月<br>
            <input type="text" name="day">日<br><br>
            
            <input type="submit" value="送信">
        </form>
    </body>
</html>
