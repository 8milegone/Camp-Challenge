<%-- 
    Document   : Kadai8
    Created on : 2016/07/20, 1:11:57
    Author     : 8mile_000
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%!   /*課題8 先にInteger limit=2を定義しておき、課題7の処理のうち2人目(limitで定義した値の人数)
            まででループ処理を抜けるようにする*/
        
                HashMap<String, String> Person1(int i){ //limitの値をメソッドと連結させるために"int"で表示。 
                HashMap<String, String> infomation = new HashMap<String, String>();
                
                if(i==1){
                infomation.put("ID","0001");
                infomation.put("名前","東方仗助");
                infomation.put("生年月日","1983年5月6日");
                infomation.put("住所","M県S市杜王町");
                
                }
                //limitの値をメソッドと連結させるためにif文で表現。
                
                
                if(i==2){
                infomation.put("ID","0022");
                infomation.put("名前","虹村億泰");
                infomation.put("生年月日","1983年4月5日");
                //okuyasuの住所をnullとして設定。
                infomation.put("住所",null);
                
                }
                
                if(i==3){
                infomation.put("ID","0003");
                infomation.put("名前","広瀬康一");
                infomation.put("生年月日","1984年3月28日");
                infomation.put("住所","M県S市杜王町");
                
                }
                return infomation;
    }
    %>
    
    <%
                int limit=2;    //2人目でループ処理を抜けるためにlimitの上限を定義。
                for(int i=1;i<=limit;i++){
                    HashMap<String , String> answer=Person1(i);     //limit値の中でのfor文内でメソッド呼び出し。
                    for(Map.Entry<String, String> param:answer.entrySet() )     //answer→paramへ変数が変わり、拡張for文で表示する。
                    {
                        out.println(param.getKey());    //Keyの内容(ID,名前,生年月日,住所)を表示する。
                        if( param.getKey().equals("ID") || param.getValue()==null)      //※1 Keyの中身がID または Valueの中身がnull なら
                                {                                                       //Valueの中身は表示させない。 IDの中身,nullの住所
                                continue;
                                } 
                        out.println(param.getValue()+"<br>");       //※1以外のValueの中身は表示させる。
                    }
                }
    %>
    </body>
</html>
