<%-- 
    Document   : icon_detail
    Author     : 長島 奨
--%>
<%@page import="DB_Manage.UserData"%>
<%@page import="Origin_Site.JumsHelper"%>
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
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        
        <form action="Search_user" method="GET">     
        商品キーワード検索<br>
        <font color="#ff0000" >※何も記入せずに検索ボタンを押すとエラーが表示されます。</font><br>
        <input type="text" name="query" placeholder="キーワードを入力" style="width:100px">
        <input type="submit" name="btnSubmit" value="検索" style="width:40px">
        </form>
        
        
        <h3>各アイコン説明</h3>
        <p>スマホケース</p>
        <br>
        ♡デザインを重視とは?<br>
          「女性に人気アイテム」と「男性に人気アイテム」とで区別した「アート」「写真」「キャラクター」などが描写されているアイテムを指しています。<br><br>
        □機能性重視とは?<br>
            端末を傷から守るだけではなく、「ICカードに対応」「スマホを立てかけて置くことができる」「ストラップホールがある」「受話音が聞き取りやすく加工されている」など
            の付加価値が付いているアイテムを指しています。<br><br>
        ○耐衝撃強度を重視とは?<br>
            端末を落としても傷から特に守れる工夫があるアイテムを指定しています。<br><br>
        ♠ブランド×コラボとは？<br>
            ケースデザインで人気なブランドとコラボをしているアイテムを指定できます。<br><br>
        ◇コストパフォーマンスを重視とは?<br>
            ご希望の価格を指定してアイテムを検索します。<br><br>
        <p>液晶シート</p>
        ♡綺麗な見栄えを重視とは?<br>
          「シートを貼り付けていない位、透明度があり写真、ビデオなどをクリアな画面で見たい！」というあなたにオススメなアイテムを指定しています。<br><br>
        □操作性や機能性重視とは?<br>
            液晶画面を操作する上で「指紋が目立ちにくい」「タッチの感触がさらさらしていて操作しやすい」「シートの役割以外にも特別な機能が付いている」などのアイテムを指定しています。<br><br>
        ○耐衝撃強度を重視とは?<br>
            端末を落としてしまった際にでも、液晶画面が割れにくい「ガラス製シート」「特殊加工された液晶画面専用ケース」などのアイテムを指定しています。<br><br>
        ◇コストパフォーマンスを重視とは?<br>
            ご希望の価格を指定してアイテムを検索します。<br><br>
       <%=jh.home()%>    
    </body>
</html>
