<%-- 
    Document   : 課題8
    Created on : 2016/07/12, 14:16:54
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
    <%@ page import="java.util.ArrayList" %>
    <%
    //課題8 課題7で作成した配列の"soeda"を"33"に変更してください。
    //"10", "100", "soeda", "hayashi", "-20", "118", "END"  (要素数は7)  
    String name1[]={"10","100","soeda","hayashi","-20","118","END"};
    name1[2]="33";//要素数の3番目を指定して変更
    for (int i = 0 ; i<7 ; i++)//作成した配列を表示させる為にfor文を作成
    {out.println(name1[ i ]); }//name1[ ]の要素数のカウントアップは"i"で表現
    
    //ArrayListで表現してみます。
    ArrayList <String> name2 = new ArrayList <String> ( );
    name2.add("10");//データの追加①
    name2.add("100");//データの追加②
    name2.add("soeda");//データの追加③
    name2.add("hayashi");//データの追加④
    name2.add("-20");//データの追加⑤
    name2.add("118");//データの追加⑥
    name2.add("END");//データの追加⑦
    //要素追加
    name2.set(2,"33");
    for (int i=0 ; i<name2.size() ; i++)
    {out.println(name2.get(i)); }
     %>
  </body>
</html>
