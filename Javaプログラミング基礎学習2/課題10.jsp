<%-- 
    Document   : 課題10
    Created on : 2016/07/12, 14:17:15
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
    //課題10 クエリストリングを利用して、以下の処理を実現してください。
    //簡易素因数分解のロジックを作成します。
    //クエリストリングから渡された数値を1ケタの素数で可能な限り分解し、元の値と素因数分解の結果を表示するようにしてください。
    //2ケタ以上の素数が含まれた数値の場合は、「元の値　1ケタの素因数　その他」と表記して、その他　に含んでください。
    //1ケタの素数は2, 3, 5, 7
    final String LINE_BREAK = "<br>";
    String param1 = request.getParameter("ti");// 元の数値
    int num = Integer.parseInt(param1);//文字列から数値への型変換
//クエリストリングから渡された数値が"200"の場合のURLは     ?ti=200
//クエリストリングから渡された数値が"220"の場合のURLは     ?ti=220
//クエリストリングから渡された数値が"10"の場合のURLは      課題10.jsp?ti=14
    out.println("素因数分解の結果を表示します。"+LINE_BREAK);
        if(num>1){
            out.println("元の値は"+num+"です。"+LINE_BREAK);
       }
       while(num!=1){
           if(num % 2 == 0){
               out.println(2);
               out.println(" "); 
               num /= 2;//2で割り切れるまで計算する。
           } else if(num % 3 == 0){
               out.println(3);
               out.println(" "); 
               num /= 3;//3で割り切れるまで計算する。
           } else if(num % 5 == 0){
               out.println(5);
               out.println(" "); 
               num /= 5;//5で割り切れるまで計算する。
           } else if(num % 7 == 0){
               out.println(7);
               out.println(" "); 
               num /= 7;//7で割り切れるまで計算する。
           } else  {
               out.println("その他"); //素数が10以上の場合は"その他"と表記追加する。
               break;
           }
           
           
       }
     %>
    </body>
</html>
