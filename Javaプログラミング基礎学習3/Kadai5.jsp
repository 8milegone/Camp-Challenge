<%-- 
    Document   : Kadai5
    Created on : 2016/07/19, 15:32:33
    Author     : 8mile_000
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!//課題5 戻り値としてある人物のid(数値),名前,生年月日、住所
          //を返却するメソッドを作成し、受け取った後はid以外の値を表示する
              //int getPerson(int id,String name,String birthday,String adress) {
              ArrayList<String> method1(){
                ArrayList<String> profile = new ArrayList<String>();
                
                  profile.add("ID:12345");
                  profile.add("名前:長島 奨");
                  profile.add("生年月日:1987年9月20日");
                  profile.add("住所:千葉県");
                  return profile;
              }
        %>
        <%
            ArrayList<String> answer = method1();
            for(int i=1; i < answer.size();i++){
                out.println(answer.get(i));
            }
            
        %>
    </body>
</html>
