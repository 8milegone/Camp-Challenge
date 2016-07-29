<%-- 
    Document   : Task6
    Created on : 2016/07/27, 13:22:16
    Author     : 8mile_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession hs = request.getSession();
    String n = (String)hs.getAttribute("name");
    String o = (String)hs.getAttribute("sex");
    String h = (String)hs.getAttribute("hobby");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           /*課題5 以下の機能を実装してください。
             名前・性別・趣味を入力するページを作成してください。
             また、入力された名前・性別・趣味を記憶し、次にアクセスした際に
             記録されたデータを初期値として表示してください。
             ※Javaと同時に、HTMLの知識が必要になります。
             ※入力フィールドの使い方を調べてみましょう。*/
        %>
       <form action="TaskAnswer" method="post">
           <h3>名前</h3>
                <input type="text" name="txtName" value=
                   "<% if(n!=null){
                        out.println(n);
                      }
                   %>"
                >
                <h3>性別</h3>
                
                    男性
                    <input type="radio" name="rdoSex" value="男性"
                    <% if(o!=null){
                        if(o.equals("男性")){
                            out.println("checked");
                        }
                    }
                    %>>
                    女性
                <input type ="radio" name="rdoSex" value="女性"
                       <% if(o!=null){
                           if(o.equals("女性")){
                               out.println("checked");
                           }
                       }
                       %>>
                
                <h3>趣味</h3>
                <textarea name="multxHobby">
                    <%if(h!=null){
                        out.println(h);
                    }
                    %></textarea>
                    <input type="submit" name="btnSubmit" value="送信">
       </form>
    </body>
</html>
