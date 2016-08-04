<%@page import="jums.UserDataBeans"%>   <!--インスタンスのクラスをインポート-->
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    //HttpSessionインスタンスの取得                                             //課題3 Servletからインスタンスデータを取得
    HttpSession hs = request.getSession();                                      //udbをjspで使用する為に、ここにてインスタンス化
    UserDataBeans udb = new UserDataBeans();
    if(hs.getAttribute("udb") !=null){                                          //「取得したデータがnullでなければ」という条件で分岐させる
        udb = (UserDataBeans)hs.getAttribute("udb");                            //UserDataBeansの取得したデータを参照させる為に"getAttribute"で表記
    
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <%if(udb.getName().equals("")){%>                                       <%--課題3 UserDataBeansで格納されているデータが""ならデータを挿入(分岐)--%>
            <input type="text" name="name" value="">
            <%}else{%>
            <input type="text" name="name" value="<%=udb.getName()%>">          <%--課題3 名前が既に格納されていたらその値を表示--%>
        <%}%>
        <br><br>

        生年月日:　
        <select name="year">                                                    <%--課題5 nsertconfirmからinsertへ再入力時フォームに値が保持されていない対策--%>
            <option value="">----</option>
            <%if(udb.getYear().equals("")){
                for(int i=1950; i<=2010; i++){ %>
            <option value= "<%=i%>" >  <%=i%>  </option>
            <% }%>
            <%}else{ %>
            <option value="<%=udb.getYear()%>"><%=udb.getYear()%> </option>
            <% } %>                                                             
        </select>年
        
        <select name="month">
            <option value="">--</option>
            <%if(udb.getMonth().equals("")){
                for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" > <%=i%> </option>
            <% } %>
            <%}else{%>
            <option value="<%=udb.getMonth()%>"><%=udb.getMonth()%></option>
            <% } %>
            
        </select>月
        <select name="day">
            <option value="">--</option>
            <%if(udb.getDay().equals("")){
                for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
            <%} else{%>
            <option value="<%=udb.getDay()%>"><%=udb.getDay()%></option>
            <% } %>
            
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1"
        <% if(udb.getType()!=0){
            if(udb.getType()==1){
                out.println("checked");
            }
           }
         %>>    エンジニア<br>
        
        <input type="radio" name="type" value="2"
        <% if(udb.getType()!=0){
            if(udb.getType()==2){
                out.println("checked");
            }
           }
         %>>    営業<br>
         
        <input type="radio" name="type" value="3"
        <% if(udb.getType()!=0){
            if(udb.getType()==3){
                out.println("checked");
            }
           }
        %>>     その他<br>
        <br>

        電話番号:
        <%if(udb.getTell().equals("")){%>
            <input type="text" name="tell" value="">
            <%}else{%>
            <input type="text" name="tell" value="<%=udb.getTell()%>">
        <%}%>
        
        
        <br><br>

        自己紹介文
        <br>
        <% if(udb.getComment().equals("")){%>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><!--コメント入力ボックス--></textarea><br><br>
            <%}else{%>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=udb.getComment()%></textarea>
        <%}%>                                                                   <%--rows:表示行数 cols:1行あたりの最大文字 wrap:改行ルール--%>
                
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">    <!--Insert.javaから与えられた"ac"の情報をhs.getAttribute("ac")から
                                                                                隠れデータとして反映させる-->
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
        <!--課題1 全部のページにトップへのリンクが表示-->
    </body>
</html>
