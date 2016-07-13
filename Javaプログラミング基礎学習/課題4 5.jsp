<%-- 
    Document   : 課題4 5
    Created on : 2016/07/11, 11:49:43
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
         final String LINE_BREAK="<br>";
         final Integer num0 = 3;
         //定数の宣言
         Integer num1 = 12;
         Integer num2 = 5;
         //変数の宣言
    out.println("この課題では、num1=10の変数とnum2=5の変数とnum0=3の定数で四則演算を実施します。"+LINE_BREAK);
    Integer plus = num1 + num2;
    out.print(num1+"+"+num2+"は、"+plus+"です。"+LINE_BREAK);
    
    Integer minus = num1 - num0;
    out.print(num1+"-"+num0+"は、"+minus+"です。"+LINE_BREAK);
    
    Integer kake = num1 * num2;
    out.print(num1+"×"+num2+"は、"+kake+"です。"+LINE_BREAK);

    Integer wari = num1 / num0;
    out.print(num1+"÷"+num0+"は、"+wari+"です。"+LINE_BREAK);
    
    Integer amari = num1 % num2;
    out.print(num1+"÷"+num2+"の余りは、"+amari+"です。"+LINE_BREAK);
    
    out.print(LINE_BREAK);

    out.print("次に、++と--の動きを見てみましょう。"+LINE_BREAK);
    num1=20;
    out.print("num1に"+num1+"を代入し、++num1とした場合、");
    out.print(++num1);
    out.print("となります。"+LINE_BREAK);
    num1=20;
    out.print("これを、num1++とした場合、その場では");
    out.print(num1++);
    out.print("となりますが、"+LINE_BREAK);
    out.print("次の処理で呼び出すと、"+num1+"と、1加算された状態になります。"+LINE_BREAK);
    out.print("--についても、同じ動作になります。"+LINE_BREAK);
    
    out.print(LINE_BREAK);
%>
    </body>
</html>
