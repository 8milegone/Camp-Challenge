<%-- 
    Document   : Kadai2
    Created on : 2016/07/15, 16:32:50
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
    <%!
     //課題2 引数として数値を受け取り、その値が奇数か偶数か判別＆表示する処理をメソッドとして制作し
     //適当な数値に対して奇数・偶数の判別を行ってください   
    String num1(int num) 
    {
        if (num % 2 == 0) 
        {return "偶数です。";}
        else
        {return "奇数です";}
    }
    %>  //メソッドの終了
    
    <%
        int num=19;//適当な数値として19を代入しています。
        String Answer = num1(num);//メソッドを呼び出し
        out.println(Answer);
    %>
    </body>
</html>
