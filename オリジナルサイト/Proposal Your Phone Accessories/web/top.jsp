<%-- 
    トップページ。
    このシステムの簡単な説明が記載されている。テキストは自由
    キーワード検索フォームが設置されている。検索の遷移先はsearchで、GETメソッド。未入力ならエラーを表示

    Document   : top
    Created on : 2016/08/15, 16:27:06
    Author     : 8mile_000
--%>
<%@page import="DB_Manage.UserData"%>
<%@page import="Origin_Site.JumsHelper"%>
<%--仕様要件③検索欄が未入力ならエラーとする--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    UserData ud = (UserData)hs.getAttribute("userdata");
    
    //検索キーワードがnullかを比較
    boolean keyword = false;
    if(request.getAttribute("empty") != null) {
        keyword = true;
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proposal Your Phone Accessories</title>
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
        <p>あなたの機種名は<a href="MyData"><%=ud.getTerminal()%></a>です。</p>
        <%=jh.logout()%><br>
        <%=jh.cart()%>
        <% } %>
        <%--情報を見やすくさせる為、水平の罫線を作成--%>
        <HR>
        
        <form action="Search_user" method="GET">     <%--仕様要件:①遷移先はsearch②GETメソッド--%>
        商品キーワード検索<br>
        <font color="#ff0000" >※何も記入せずに検索ボタンを押すとエラーが表示されます。</font><br>
        <input type="text" name="query" placeholder="キーワードを入力" style="width:100px">
        <input type="submit" name="btnSubmit" value="検索" style="width:40px">
        </form> 
        スマホケース
        <br><br>
        デザインを重視 <a href="Search_category_mens">男性目線</a> <br>
                       <a href="Search_category_ladys">女性目線</a> <br>
        機能性を重視 <a href="Search_category_fanction">機能性を重視</a> <br>
        耐衝撃強度を重視 <a href="Search_category_water">耐防水にこだわる(iPhoneのみ)</a> <br>
                         <a href="Search_category_protect">こだわらない</a> <br>
        ブランド×コラボ <a href="Search_category_apparel">アパレルブランド</a> <br>
                         <a href="Search_category_designer">デザイナーズブランド</a> <br>
                         <a href="Search_category_character">キャラクター</a> <br><br>
        液晶シート
        <br><br>
        <a href="Search_category_koukoutaku">綺麗な見栄えを重視</a> <br>
        <a href="Search_category_antigurea">操作性や機能性を重視</a> <br>
        <a href="Search_category_glass">耐衝撃強度を重視</a> <br><br>
        
<p>こんなことは経験したことはないでしょうか？<br>
スマホを購入したのはいいけど、どんなケース、シートを選べばいいだろう…?<br>
ショッピングサイトを見てもたくさん情報があって、よくわからなくなる…<br>
よくわからないから、物は試しに買ったら満足するものではなかった…<br>
持っている機種に対応していなかった…<br><br>

そんな「 あなた 」にこのサイトから是非提案させて下さい！<br>

会員登録の際にあなたのスマホの機種名を登録して検索時にあなたの端末に合うアイテムだけを見つけます。<br>
また、カテゴリ別に分類されている「こだわり」からあなたに気に入って頂けるアイテムを見つけられる様に一覧で表示します。<br>
ご購入の際には、会員登録が必要です。<br><br>

★会員登録のメリット★<br>
あなたの持っているスマホの機種名と検索条件を保存することが可能です。<br>
簡単に条件にあったアイテムを探すことができます。<br>
</p>        
    </body>
</html>
