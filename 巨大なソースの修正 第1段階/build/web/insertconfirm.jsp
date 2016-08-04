<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();                                      //課題3 Servletからインスタンスデータを取得
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");                  //UserDataBeansの取得したデータを参照させる為に"getAttribute"で表記
                                                                                //前ページのinsert.jspにてnullの条件を提示しているので、ここでは省略
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <% if(!udb.getName().equals("")                                         //課題4 フォームの内容が未入力であっても通過してしまうのを修正
              && !udb.getYear().equals("")                                      //ifの条件に各フォームの情報も&&で表記する。
              && !udb.getMonth().equals("")                                     //全てのフォームの値が""ではなければ登録確認画面を表記する。
              && !udb.getDay().equals("")
              &&  udb.getType() != 0                                            //intで指定
              && !udb.getTell().equals("")
              && !udb.getComment().equals("")
             ){ %>
    
        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>                                            <%--課題3 UserDataBeansで取得したデータを表示--%>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">    
            <!--課題2 直リンク防止の処理 InsertConfirm.javaから与えられた"ac"の情報をhs.getAttribute("ac")から
            隠れデータとして反映させる-->
            
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        <h3>以下の未入力箇所を確認し訂正して下さい。</h3>
        <% 
           if(udb.getName().equals("")){
           out.println("名前が未入力です。<br>"); 
            }                                                                   //課題4 フォームの内容が未入力であっても通過してしまうのを修正
           if(udb.getYear().equals("")&&                                        //ifの条件に各フォームの情報も&&で表記する。
                udb.getMonth().equals("")&&                                     //全てのフォームの値が""ではなければ登録確認画面を表記する。
                udb.getDay().equals("")){
                    out.println("生年月日が未入力です。<br>");   
                 }
           if(udb.getType() == 0){                                              //if条件を0で指定
            out.println("種別が未選択です。<br>");
            }
           if(udb.getTell().equals("")){
            out.println("電話番号が未入力です。<br>");
            }
           if(udb.getComment().equals("")){
            out.println("自己紹介文が未入力です。<br>");
            }
        %>
        <%} %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
        <!--課題1 全部のページにトップへのリンクが表示-->
    </body>
</html>
