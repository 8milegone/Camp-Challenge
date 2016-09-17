<%--
    トップページ。
    このシステムの簡単な説明が記載されている。テキストは自由
    

    Document   : top
    Author     : 長島 奨
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
        <h4>スマホアイテム提案サイト Proposal Your Phone Accessories</h4>
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
        
        <%--新規会員登録ページ--%>
        <%=jh.register()%><br><%--JumsHelperから引用--%>
        
        <%--ログイン情報がnullじゃなければトップ画面にユーザー情報を表示させる--%>
        <% }else { %>
        <%--ユーザー情報・ログアウト・カートを表示させる--%>
        <p>ようこそ <a href="MyData"><%=ud.getName()%></a> さん<p>
        <p>あなたのスマホは<a href="MyData"><%=ud.getTerminal()%></a>です。</p><br>
        <%=jh.logout()%>
        <%=jh.cart()%>
        <% } %>
        <%--情報を見やすくさせる為、水平の罫線を作成--%>
        <HR>
        
        <form action="Item" method="GET">     <%--仕様要件:①遷移先はsearch②GETメソッド--%>
        携帯電話用ケース・カバー<br>
        <input type="text" name="query" placeholder="キーワードを入力" style="width:100px">
        <input type="submit" name="btnSubmit" value="検索" style="width:40px">
        </form> 
        <p>
        こんなことは経験したことはないでしょうか？<br>
        スマホを購入したのはいいけど、どんなケース、シートを選べばいいだろう…?<br>
        ショッピングサイトを見てもたくさん情報があって、よくわからなくなる…<br>
        よくわからないから、物は試しに買ったら満足するものではなかった…<br>
        持っている機種に対応していなかった…<br><br>

        そんな「 あなた 」にこのサイトから是非提案させて下さい！<br><br>

        会員登録の際にあなたのスマホの機種名を登録して検索時にあなたの端末に合うアイテムだけを見つけます。<br>
        また、カテゴリ別に分類されている「こだわり」からあなたに気に入って頂けるアイテムを見つけられる様に一覧で表示します。<br>
        ご購入の際には、会員登録が必要です。<br><br>

        ★会員登録のメリット★<br>
        あなたの持っているスマホの機種名と検索条件を保存することが可能です。<br>
        簡単に条件にあったアイテムを探すことができます。<br>

        </p>        
    </body>
</html>
