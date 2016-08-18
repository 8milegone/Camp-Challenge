<%-- 
    検索結果ページ
    topから検索により遷移できる。YahooショッピングAPIに直接検索キーワードを渡し、その結果を受け取り＆表示している
    検索キーワード、検索結果数を表示
    縦のリスト型に表示。サムネイルと、その横に商品名、金額が載っている。クリックでitemへ
    結果は上位20件まで
    Document   : search
    Created on : 2016/08/15, 16:27:30
    Author     : 8mile_000
--%>
<%--ログインのチェック--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession hs = request.getSession(); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果ページ</title>
    </head>
    <body>
        <h4>商品検索結果</h4>
        <%--検索キーワード、検索結果数を表示--%>
        検索件数; <%= sd.getQuery() %><br>
        検索キーワード;<%= sd.getTotalResult() %><br>
        <br><br>
        <table border="1" class="list"></table>     <%--仕様要件②縦のリスト型に表示。サムネイルと、その横に商品名、金額が載っている。クリックでitemへ--%>
        <tr>
        <th>サムネイル</th>
        <th>商品名</th>
        <th>価格</th>
        </tr>
        <% for (int i = 0; i < 20; i++) { %>  <%--仕様要件①検索結果の上限は20件--%>
            <tr>
                <th><img src=<%= sdList.get(i).getImage() %>/></th>
                <th><a href="Item?code=<%= sdList.get(i).getCode() %>"><%=sdList.get(i).getItemName() %></a></th>
                <th><%= sdList.get(i).getPrice() %> 円</th>
            </tr>
            <% } %>
        </table>
    </body>
</html>
