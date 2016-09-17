<%-- 
    会員登録確認ページ
    フォームで入力された文字や選択を表示し、「上記の内容で登録いたします。よろしいですか？」と表示。「はい」でregistrationcomplete「いいえ」でregistrationに値を保持したまま(戻った時にフォーム入力済みになっている)遷移
    もし不足していた場合はどの項目のデータが不足しているのかを表示。registrationに値を保持したまま遷移するリンクを表示

    Document   : registrationconfirm
    Author     : 長島　奨
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DB_Manage.UserData"%>
<%@page import="Origin_Site.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  JumsHelper jh = JumsHelper.getInstance();  
  HttpSession hs = request.getSession();
  UserData ud = (UserData)hs.getAttribute("ud");
  ArrayList<String> chkList = ud.chkproperties();
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規会員登録確認画面</title>
    </head>
    <body>
        <%--登録フォームから未登録の情報がないか確認--%>
        <% if(chkList.size()==0){ %>
        <h3>登録確認</h3>
        ユーザー名:<%=ud.getName()%><br>
        パスワード:<%=ud.getPassword()%><br>
        メールアドレス;<%=ud.getMail()%><br>
        住所:<%=ud.getAddress()%><br>
        あなたのスマホ機種名(検索対象機種):<%=ud.getTerminal()%><br><br>
        上記の内容で登録致します。よろしいですか？
        <form action="RegistrationComplete" method="POST">
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい"><br><br>
        </form>
            <% }else{ %>
                <h3>以下の入力が不完全です。ご確認の上、記入して下さい。</h3>
                <%=jh.chkinput(chkList) %>
            <% } %>
                <form action="Registration" method="POST">
                <input type="submit" name="no" value="いいえ">
                <input type="hidden" name="mode" value="REINPUT">
                </form>
            
    <br>
    <%=jh.home()%>
    </body>
</html>
