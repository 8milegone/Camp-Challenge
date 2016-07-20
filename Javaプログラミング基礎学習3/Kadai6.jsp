<%-- 
    Document   : Kadai6
    Created on : 2016/07/19, 21:50:31
    Author     : 8mile_000
--%>

<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%!     //課題6 引き数に1つのid(数値)をとり、3人分のプロフィール(項目は課題5参照)
            //をあらかじめメソッド内で定義しておく。
            //引き数のid値により戻り値として返却するプロフィールを誰のものにするか選択する。
            //それ以降などは課題5と同じ扱いに
                
                HashMap<String, String> Person1(){
                HashMap<String, String> zyousuke = new HashMap<String, String>();
                zyousuke.put("ID","0001");
                zyousuke.put("名前","東方仗助");
                zyousuke.put("生年月日","1983年5月6日");
                zyousuke.put("住所","M県S市杜王町");
                return zyousuke;
                }
                //3人分のプロフィールをそれぞれメソッドで作成
                //連想配列によりIDを引き数として設定
                
                HashMap<String, String> Person2(){
                HashMap<String, String> okuyasu = new HashMap<String, String>();
                okuyasu.put("ID","0022");
                okuyasu.put("名前","虹村億泰");
                okuyasu.put("生年月日","1983年4月5日");
                okuyasu.put("住所","M県S市杜王町");
                return okuyasu;
                }
                
                HashMap<String, String> Person3(){
                HashMap<String, String> kouichi = new HashMap<String, String>();
                kouichi.put("ID","0003");
                kouichi.put("名前","広瀬康一");
                kouichi.put("生年月日","1984年3月28日");
                kouichi.put("住所","M県S市杜王町");
                return kouichi;
                }
    %>
    <%
                final String LINE_BREAK = "<br>";
                HashMap<String, String> answer1=Person1();
                if(answer1.get("ID").equals("0001")){ //連想配列によりIDを引き数として設定
                out.println(answer1.get("名前")+LINE_BREAK);
                out.println(answer1.get("生年月日")+LINE_BREAK);
                out.println(answer1.get("住所")+LINE_BREAK);
                }
                
                HashMap<String, String> answer2=Person2();
                if(answer2.get("ID").equals("0002")){ //連想配列によりIDを引き数として設定
                out.println(answer2.get("名前")+LINE_BREAK);
                out.println(answer2.get("生年月日")+LINE_BREAK);
                out.println(answer2.get("住所")+LINE_BREAK);
                }
                
                HashMap<String, String> answer3=Person3();
                if(answer3.get("ID").equals("0003")){ //連想配列によりIDを引き数として設定
                out.println(answer3.get("名前")+LINE_BREAK);
                out.println(answer3.get("生年月日")+LINE_BREAK);
                out.println(answer3.get("住所")+LINE_BREAK);
                }
    %>
    </body>
</html>
