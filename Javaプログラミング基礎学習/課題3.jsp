<%-- 
    Document   : 課題3
    Created on : 2016/07/06, 17:24:35
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
        //課題3 自分の自己紹介を作成してみてください。
        final String LINE_BREAK = "<br>";
        out.print("私の名前は"+"長島　奨"+"(ナガシマ ススム)"+"です。"+LINE_BREAK);
        out.println("今年で29才になります。"+LINE_BREAK);
        out.println("出身は三重県です。"+LINE_BREAK);
        out.println("プログラミングは初めて勉強しますが、頑張ります!"+LINE_BREAK);
        //質問:改行の方法が不明→定義を設けて(+LINE_BREAK)=<br>として文字列に代入する
        %>
    </body>
</html>
