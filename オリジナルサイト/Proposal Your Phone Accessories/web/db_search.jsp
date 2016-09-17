<%-- 
    Document   : db_search
    Created on : 2016/09/07, 17:33:31
    Author     : 8mile_000
--%>
<%@page import="DB_Manage.DB_Search"%>
<%
    DB_Search db = DB_Search.getInstance();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>スマホアイテム検索画面</title>
    </head>
    <body>
        <h1>検索フォーム</h1>
        <!--methodをPOSTからGETへ変更-->
        <form action="DB_Search_Result" method="GET">
        ケース/液晶シート選択:
        <% for(int i=1; i<=2; i++) {%>
        <input type="radio" name="type1" value="<%=i%>" <%out.print("id="+i);%>>
        <label <%out.print("for="+i);%>><%=db.exType(i)%></label>
        <% } %>
        <br><br>
        
        アイテム名:
        <input type="text" name="name" placeholder="キーワード検索">
        <br><br>
        
        ケースカテゴリ検索(第1カテゴリ):
        <% for(int i=1; i<=4; i++) {%>
        <br>
        <input type="radio" name="type2" value="<%=i%>" <%out.print("id="+i);%>>
        <label <%out.print("for="+i);%>><%=db.exTypeCase1(i)%></label>
        <% } %>
        <br><br>
        
        ケースカテゴリ検索(第2カテゴリ):
        <% for(int i=1; i<=7; i++) {%>
        <br>
        <input type="radio" name="type3" value="<%=i%>" <%out.print("id="+i);%>>
        <label <%out.print("for="+i);%>><%=db.exTypeCase2(i)%></label>
        <% } %>
        <br><br>
        
        シートカテゴリ検索:
        <% for(int i=1; i<=3; i++) {%>
        <br>
        <input type="radio" name="type4" value="<%=i%>" <%out.print("id="+i);%>>
        <label <%out.print("for="+i);%>><%=db.exTypeSheet(i)%></label>
        <% } %>
        <br><br>
        
        方法:
        <br>
            <label for="and">
            <input type="radio" name="searchMethod" value="1" id="and" checked>AND  
            </label>
            <label for="or">
            <input type="radio" name="searchMethod" value="2" id="or">OR
            </label>
        <br><br>
        <!-- 追加点(仕様書に規定無し) ここまで--><!--フォントの色は赤-->
        <font color="#ff0000">※全件表示させたい際は, 何も記入せずに検索ボタンを押してください.</font><br>
        <input type="submit" name="btnSubmit" value="検索" style="width:100px">
        </form>
    </body>
</html>
