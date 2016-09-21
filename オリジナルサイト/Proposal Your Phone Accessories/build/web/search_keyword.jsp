<%-- 
    検索結果ページ
    topから検索により遷移できる。YahooショッピングAPIに直接検索キーワードを渡し、その結果を受け取り＆表示している
    検索キーワード、検索結果数を表示
    縦のリスト型に表示。サムネイルと、その横に商品名、金額が載っている。クリックでitemへ
    結果は上位20件まで
    Document   : search_keyword.jsp
    Author     : 長島 奨
--%>
<%@page import="Origin_Site.ItemDataclass"%>
<%@page import="java.util.List"%>
<%@page import="DB_Manage.UserData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Origin_Site.JumsHelper"%>
<%--ログインのチェック--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession hs = request.getSession(); 
   JumsHelper jh = JumsHelper.getInstance();
   ArrayList<ItemDataclass> array = (ArrayList<ItemDataclass>)request.getAttribute("searchresults"); 
    //ログインのチェック
    boolean loginChk = false;   
    UserData ud = (UserData)hs.getAttribute("userdata");
    if(ud != null) {
        loginChk =true;
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果ページ</title>
    </head>
    <body>
        <h4>スマホアイテム提案サイト Proposal Your Phone Accessories  </h4>
        <%--ユーザー情報を表示--%>
        <%--ログインを実装予定--%>
        <%--ログアウトを実装予定--%>
        <%--アカウントを作成していない場合は新規登録を表示--%>
        <%--カートの中身確認ボタンを表示--%>
        <%--アカウントを作成していない場合は新規登録を表示--%>
        
        <%if(hs.getAttribute("userdata") == null) {%>
        <%--ログイン情報が未記入なら--%>
        
        <%--ログインページ--%>
         
        <%=jh.login()%><br><%--JumsHelperから引用--%>
        <%=jh.register()%><br><%--JumsHelperから引用--%>
        <%=jh.cart()%><br><%--JumsHelperから引用--%>
        
        <%--ログイン情報がnullじゃなければ--%>
        <% }else { %>
        <%--ユーザー情報・ログアウト・カートを表示させる--%>
        <p>ようこそ <a href="MyData"><%=ud.getName()%></a> さん</p>
        <%=jh.logout()%><br>
        <%=jh.cart()%>
        <% } %>
        <%--情報を見やすくさせる為、水平の罫線を作成--%>
        <HR>
        <h4>商品検索結果</h4>
        <%--検索キーワード、検索結果数を表示--%>
        検索件数; <%=request.getAttribute("totalresults")%>件<br>
        検索キーワード;<%=request.getParameter("query")%><br>
        <br><br>
        <table border="1">    <%--仕様要件②縦のリスト型に表示。サムネイルと、その横に商品名、金額が載っている。クリックでitemへ--%>
        <tr>
        <th>サムネイル</th>
        <th>商品名</th>
        <th>価格</th>
        </tr>
        <% for (int i = 0; i < 20; i++) { %>  <%--検索結果の上限は20件--%>
        <%ItemDataclass item = (ItemDataclass)array.get(i);%>
            <tr>
                <%--商品画像--%>
                <td><a href="Item?itemcode=<%=item.getItemcode() %>"><img src="<%=item.getImageurl() %>"></a></td>
                <%--商品名--%>
                <td><a href="Item?itemcode=<%=item.getItemcode() %>"><%=item.getName() %></a></td>
                <%--価格--%>
                <td><%=item.getPrice() %>円</td>
            </tr>
            <% } %>
        </table>
        <%=jh.home()%>
    </body>
</html>
