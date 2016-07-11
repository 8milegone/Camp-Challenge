<%-- 
    Document   : 課題6
    Created on : 2016/07/06, 17:25:40
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
    //課題6  変数を宣言し、その変数の中身によって以下の表示を行ってください。
    //値が 1 なら「１です！」
    //値が 2 なら「プログラミングキャンプ！」
    //それ以外なら「その他です！」
    final String LINE_BREAK="<br>";//改行
    String MG1 =("1です！");//値が1
    String MG2 =("プログラミングキャンプ！");//値が2
    String MG3 =("その他です！");//それ以外
    //文字列を表示する変数宣言
    
    out.println("変数の中身によって課題通り表示されるようにしました。"+LINE_BREAK);
    out.println("例として変数の中身が2であると仮定し表示します。"+LINE_BREAK);
   
    int param = 2;
    
    if (param == 1) 
    {out.println(MG1+LINE_BREAK);}//数値が1ならMG1を表記する様にしています。
    
    else if (param == 2) 
    {out.println(MG2+LINE_BREAK);}//数値が2ならMG2を表記する様にしています。
    
    else 
    {out.println(MG3+LINE_BREAK);}//それ以外ならMG3を表記する様にしています。
    
    
    %>
    </body>
</html>
