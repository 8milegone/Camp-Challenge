<%-- 
    Document   : Kadai4
    Created on : 2016/07/19, 13:30:26
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
        <%//課題1で定義したメソッドに追記する形として、戻り値　true(boolean)を返却するように修正し
        //メソッドの呼び出し側でtrueを受け取れたら「この処理は正しく実行できました」
        //そうでないなら「正しく実行できませんでした」と表示する
        
        final String LINE_BREAK = "<br>";
        String myself1 = profile.get(0);
        String myself2 = profile.get(1);
        String myself3 = profile.get(2);
        String myself4 = profile.get(3);
        
        
        for(int i=0;i<10;i++){  //10回メソッドを呼び出す処理を指示しています。
            out.println(myself1+LINE_BREAK);
            out.println(myself2+myself3+LINE_BREAK);
            out.println(myself4+LINE_BREAK);
            if(profile.get(4).equals("")){
                out.println("この処理は正しく実行できました"+LINE_BREAK);
            }else{
                out.println("正しく実行できませんでした"+LINE_BREAK);
            }
        }
        %>     
    </body>
</html>
