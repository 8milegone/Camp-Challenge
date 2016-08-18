<%-- 
    新規会員登録ページ
    loginからのみ遷移
    フォームがあり、入力するのは以下の要素
        ユーザー名
        パスワード
        メールアドレス
        住所
    registrationconfirmから戻ってきた場合は、値を保持して記入済みにできる

    Document   : registration
    Created on : 2016/08/15, 16:29:07
    Author     : 8mile_000
--%>

<%@page import="Kagoyume.UserData"%>
<%@page import="Kagoyume.JumsHelper"%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData ud = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        ud = (UserData)hs.getAttribute("ud");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規会員登録ページ</title>
    </head>
    <body>
        <form action="insertconfirm" method="POST">
        ユーザー名:
        <input type="text" name="name" value="<% if(reinput){out.print(ud.getName());} %>">
        <br><br>
        
        パスワード:
        
        メールアドレス:
        
        住所:
        
        
        </form>
    </body>
</html>
