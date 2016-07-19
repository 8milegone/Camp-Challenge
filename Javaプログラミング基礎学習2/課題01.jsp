<%-- 
    Document   : 課題1
    Created on : 2016/07/12, 14:15:26
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
        //課題1 switch文を利用して、以下の処理を実現してください。
        //値が1なら「one」、値が2なら「two」、それ以外は「想定外」と表示する処理
    String count = request.getParameter("ti");
    //クエリストリングを利用して入力された値によって表示形式を変更してみようとアレンジしています。
    //サンプル  値が1のURLは      ?ti=1
    //          値が2のURLは      ?ti=2
    //          値が3のURLは      ?ti=3      それ以外の値のURLは省略
    int num = Integer.parseInt(count);
    String message = "  ";
    switch(num)
  { case 1 : message ="「one」";
    out.println(message);
    case 2 : message = "「two」";
    out.println(message);
    default : message = "「想定外」";
    out.println(message);
  }
    
    %>
    </body>
</html>
