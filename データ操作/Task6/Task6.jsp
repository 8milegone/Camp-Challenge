<%-- 
    Document   : Task6
    Created on : 2016/07/29, 15:24:51
    Author     : 8mile_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           /*課題6 HTMLについて調べましょう。
             HTMLには入力フィールド意外にも様々なタグが存在します。
             Webページをデザインする上で欠かせない知識なので、
             タグを調べ、色々と使ってみましょう。*/
           HttpSession hs = request.getSession();
           String s = (String)hs.getAttribute("sweet");
           String b = (String)hs.getAttribute("meat");
           String ss = (String)hs.getAttribute("fish");
           String d = (String)hs.getAttribute("doggy");
        %>
        <form action="TaskAnswer1" method="get">
        
            <h5>あなたの好きな食べ物を教えてください</h5>
            <h4>ひとつだけ選んでね</h4>
            <input type="checkbox" name="myQ1">スイーツ
            <br>
            <input type="checkbox" name="myQ2">焼肉
            <br>
            <input type="checkbox" name="myQ3">寿司
            <br>
            <input type="checkbox" name="myQ4">犬
            <br>
            
            <input type="submit" value="送信する">
        </form>
    </body>
</html>
