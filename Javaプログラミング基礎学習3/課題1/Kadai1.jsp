<%-- 
    Document   : 課題1
    Created on : 2016/07/15, 15:52:16
    Author     : 8mile_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<String> profile = (ArrayList<String>)request.getAttribute("profile"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
   <%
        //課題1 自分のプロフィール(名前、生年月日、自己紹介)を3行に分けて表示するユーザー定義メソッドを作り
        //メソッドを10回呼び出して下さい
        final String LINE_BREAK = "<br>";
        String myself1 = profile.get(0);
        String myself2 = profile.get(1);
        String myself3 = profile.get(2);
        String myself4 = profile.get(3);
        
        for(int i=0;i<10;i++){  ////10回メソッドを呼び出す処理を指示しています。
            
            out.println(myself1+LINE_BREAK);
            out.println(myself2+myself3+LINE_BREAK);
            out.println(myself4+LINE_BREAK);
            
        }
    %>
    </body>
</html>
