<%-- 
    Document   : 課題4 5
    Created on : 2016/07/06, 17:25:26
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
        //課題4 定数と変数を宣言し、それぞれに数値を入れて四則演算を行ってください。 
        final String LINE_BREAK = "<br>";
        final Integer num1 = 11;
        //定数宣言
        Integer num2 = 5;
        Integer num3 = 13;
        //変数宣言
        out.println(num1-10+LINE_BREAK);//11-10=1(num1=11)※定数 num1 に++num1 としてもエラーになる
        out.println(num1+LINE_BREAK);//上記の計算式の回答は無視される
        out.println(--num2-10+LINE_BREAK);//4-10=-6(num2=4 5に-1をして4)
        out.println(num2-num1+LINE_BREAK);//4-11=-7 (上の回答のnum2=4を代入)
        out.println(num3+num2+LINE_BREAK);//13+4=17(上の回答のnum2=4を代入)
        
        out.println(num2+++LINE_BREAK);//4(上の回答のnum2=4が表示される)
        out.println(num2+LINE_BREAK);//5(num2=4に+1されたあと)
        out.println(num2+1+LINE_BREAK);//5+1=6(上記のnum2に+1)
        out.println(num1+1+LINE_BREAK); //11+1=12(定数であるnum1に+1)
        out.println(num1+LINE_BREAK);//上記の計算式の回答は無視される
        //
        
        %>
    </body>
</html>
