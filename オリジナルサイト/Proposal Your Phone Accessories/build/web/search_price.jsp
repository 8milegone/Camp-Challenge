<%-- 
    Document   : serach_price
    Author     : 長島 奨
--%>

<%@page import="DB_Manage.UserData"%>
<%@page import="Origin_Site.ItemDataclass"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Origin_Site.JumsHelper"%>
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
        <p>全機種での該当アイテムを表示しています。</p>
        <p>会員登録から『あなたの機種』を登録すると『あなたの機種』に対応するアイテムのみを表示できます。</p>
        <%=jh.login()%><br><%--JumsHelperから引用--%>
        <%=jh.register()%><br><%--JumsHelperから引用--%>
        <%=jh.cart()%><br><%--JumsHelperから引用--%>
        
        <%--ログイン情報がnullじゃなければ--%>
        <% }else { %>
        <%--ユーザー情報・ログアウト・カートを表示させる--%>
        <p>ようこそ <a href="MyData"><%=ud.getName()%></a> さん</p>
        <p><%=ud.getName()%>さんの<a href="MyData"><%=ud.getTerminal()%></a>対応のアイテムのみをカテゴリー検索から表示しています。</p>
        
        <%=jh.logout()%><br>
        <%=jh.cart()%>
        <% } %>
        <%--情報を見やすくさせる為、水平の罫線を作成--%>
        <HR>
        <h4>商品検索結果</h4>
        <%--検索キーワード、検索結果数を表示--%>
        検索件数; <%=request.getAttribute("totalresults")%>件<br>
                       <%if(request.getAttribute("keyword")!=null){%>
                                    <% out.print("カテゴリー; "+request.getAttribute("keyword"));}%>
                       <%if(request.getAttribute("fromprice")!=null){%>                 
                                    <%out.print("コストパフォーマンス重視を重視; "+request.getAttribute("fromprice"));}%>
                       <%if(request.getAttribute("toprice")!=null){%>    
                                    <%out.print(request.getAttribute("toprice"));}%>
        <br><br>
        <table border="1">    <%--仕様要件②縦のリスト型に表示。サムネイルと、その横に商品名、金額が載っている。クリックでitem_priceへ--%>
        <tr>
        <th>サムネイル</th>
        <th>商品名</th>
        <th>価格</th>
        </tr>
        <% for (int i = 0; i < 20; i++) { %>  <%--検索結果の上限は20件--%>
        <%ItemDataclass item = (ItemDataclass)array.get(i);%>
            <tr>
                <%--商品画像--%>
                <td><a href="Item_price?itemcode=<%=item.getItemcode() %>"><img src="<%=item.getImageurl() %>"></a></td>
                <%--商品名--%>
                <td><a href="Item_price?itemcode=<%=item.getItemcode() %>"><%=item.getName() %></a></td>
                <%--価格--%>
                <td>    <%=item.getPrice() %>円     </td>
            </tr>
            <% } %>
        </table>
        <br>
        <%=jh.pages_price(request)%><%--JumsHelperから引用--%>
        <br>
        <%=jh.home()%><%--JumsHelperから引用--%>
    </body>
</html>
