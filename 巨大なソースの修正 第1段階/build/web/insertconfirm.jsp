<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();                                      //課題3 Servletからインスタンスデータを取得
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");                  //UserDataBeansの取得したデータを参照させる為に"getAttribute"で表記
                                                                                //前ページのinsert.jspにてnullの条件を提示しているので、ここでは省略
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <% if(!hs.getAttribute("name").equals("")){ %>
    <!--名前が未記入でなければif以降を実施-->
    <!--実際は名前だけ入力していてもelse以降が実施される-->
        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>                                            <%--課題3 UserDataBeansで取得したデータを表示--%>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="bc"  value="<%= hs.getAttribute("bc")%>">    
            <!--課題2 直リンク防止の処理 InsertConfirm.javaから与えられた"bc"の情報をhs.getAttribute("bc")から
            隠れデータとして反映させる-->
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
        <!--課題1 全部のページにトップへのリンクが表示-->
    </body>
</html>
