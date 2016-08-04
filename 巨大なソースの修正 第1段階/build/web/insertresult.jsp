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
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%= udb.getName()%><br>                                            <%--課題3 UserDataBeansで取得したデータを表示--%>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        以上の内容で登録しました。<br>
    <br>
        <%=JumsHelper.getInstance().home()%>
        <!--課題1 全部のページにトップへのリンクが表示-->
        <!--insertresultにて直リンク防止用の処理が存在しない。insertからinsertconfirmへの流れを参考に修正しなさい-->
    </body>
    
</html>
