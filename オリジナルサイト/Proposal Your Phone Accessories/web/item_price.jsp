<%-- 
    商品詳細ページ
    serchまたはcartから遷移できる。商品IDをGETメソッドにより受け渡す
    YahooショッピングAPIから取得したデータで、より詳細な情報(概要や評価値)、が表示される
    「カートに追加する」ボタンがあり、クリックするとaddに遷移する。

    Document   : item_price
    Author     : 長島 奨
--%>

<%@page import="Origin_Site.ItemDataclass"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DB_Manage.UserData"%>
<%@page import="Origin_Site.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    //ログインのチェック
    boolean loginChk = false;
    HttpSession hs = request.getSession();
    ItemDataclass item = (ItemDataclass)hs.getAttribute("itemdata"); 
    UserData ud = (UserData)hs.getAttribute("userdata");
    if(ud != null) {
        loginChk =true;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品詳細ページ</title>
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
        <p><%=ud.getName()%>さんの<a href="MyData"><%=ud.getTerminal()%></a>対応のアイテムのみをカテゴリー検索から表示しました。</p>
        
        <%=jh.logout()%><br>
        <%=jh.cart()%>
        <% } %>
        <%--情報を見やすくさせる為、水平の罫線を作成--%>
        <HR>
            <%--キーワード検索フォーム--%>
        <form action="Search_user" method="GET">     <%--仕様要件:①遷移先はsearch②GETメソッド--%>
        商品キーワード検索<br>
        <font color="#ff0000" >※何も記入せずに検索ボタンを押すとエラーが表示されます。</font><br>
        <input type="text" name="query" placeholder="キーワードを入力" style="width:100px">
        <input type="submit" name="btnSubmit" value="検索" style="width:40px">
        </form><br>
            <%--アイテムの検索方法を記述する--%>
                       <%if(hs.getAttribute("keyword")!=null){%>
                                    <% out.print("カテゴリー; "+hs.getAttribute("keyword"));}%>
                       <%if(hs.getAttribute("fromprice")!=null){%>                 
                                    <%out.print("コストパフォーマンス重視を重視; "+hs.getAttribute("fromprice")+"円～");}%>
                       <%if(hs.getAttribute("toprice")!=null){%>    
                                    <%out.print(hs.getAttribute("toprice")+"円");}%>
            <%--アイテムの見出し(存在する場合のみ表示する)--%>
            <p><%if(item.getHeadline()!=null){item.getHeadline();}%></p>
            <%--アイテム名--%>
            <h3 style="margin:1px"><%=item.getName()%></h3><br>
            <%--ストアネーム--%>
            <div style="font-size:small;margin-top:-1.5% "><%=item.getStorename()%></div>
            <%--レビューの評価--%>
            <div>レビュー評価☆:<%=item.getFavorite() %>/<%=item.getReviewer()%>件のカスタマーレビュー</div>
            <%--アイテムの価格--%>
            <h3 style="margin:1px">価格:  ¥ <%=item.getPrice()%></h3><br>
            <%--カートに追加する--%>
            <form action="Add" method="post">            
                <%--アイテムのカート追加個数を決める--%>
                個数:<input type="number" name="qty" value="1" style="width: 3em">個
                <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                <button type="submit" name="cartin">カートに入れる</button>
            </form>
            <br>
            <%--アイテムの画像--%>
            <img src="<%=item.getBigimageurl() %>"/><br>
            <%--アイテムの詳細説明--%> 
            <div style="a{pointer-events: none}">
                <p><%=item.getCaption()%></p>
                
            </div>
            <br><br>
            <%--各メソッドの検索結果へ戻る(価格指定の検索方法を除く)--%>
            <a href="<%=hs.getAttribute("search_method") %>?query=<%=hs.getAttribute("query")%>&fromprice=<%=hs.getAttribute("fromprice")%>&toprice=<%=hs.getAttribute("toprice")%>&page=<%=hs.getAttribute("page")%>">検索結果に戻る</a><br>
            <%=jh.home()%> 
    </body>
</html>