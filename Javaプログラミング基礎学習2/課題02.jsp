<%-- 
    Document   : 課題2
    Created on : 2016/07/12, 14:15:41
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
     //課題2 switch文を利用して、以下の処理を実現してください。
     //値が "A" なら英語、値が"あ"なら日本語、それ以外は何も表示しない処理。
     String moji = request.getParameter("kotoba");
     //クエリストリングを利用して入力された値によって表示形式を変更してみようとアレンジしています。
    //サンプル  値が A のURLは      ?kotoba=A
    //          値が あ のURLは     ?kotoba=あ
    //          値が い のURLは     ?kotoba=い      それ以外の値のURLは省略
    String message = "";
    switch(moji)
    {case "A" : message ="「英語」";//case 文字列 で判定できるように"  "で区切っています。
     break;
     case"あ" : message="「日本語」";
     break;
    }
     out.println(message);
  %>    
    </body>
</html>
