<%-- 
    Document   : 課題9
    Created on : 2016/07/12, 14:17:04
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
    <%@ page import="java.util.HashMap" %>
    <%
     //課題9 以下の順で、連想配列を作成してください。
     //"1"に"AAA", "hello"に"world", "soeda"に"33", "20"に"20"
     HashMap <String , String > name1 =new HashMap <String ,String> ( );
     name1.put("1","AAA");
     name1.put("hello","world");
     name1.put("soeda","23");
     name1.put("20","20");
     
     out.println(name1.get("1"));//要素の管理が連想配列により文字列で行っている
     out.println(name1.get("hello"));//それによりfor文によるint i=0は使用出来ない
     out.println(name1.get("soeda"));
     out.println(name1.get("20"));
    %>
    </body>
</html>
