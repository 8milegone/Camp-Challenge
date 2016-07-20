<%-- 
    Document   : Kadai7
    Created on : 2016/07/20, 1:11:45
    Author     : 8mile_000
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!   //課題7 課題6の3人分のプロフィールのうち1人だけ住所が値nullの状態で定義し
              //ループ処理で全員分のプロフィールをid以外表示する処理を実行する。
              //この際、歯抜けになっているデータはcontinueで飛ばす

                
                HashMap<String, String> Person1(){      //3人分のプロフィールをそれぞれメソッドで作成
                HashMap<String, String> zyousuke = new HashMap<String, String>();
                zyousuke.put("ID","0001");
                zyousuke.put("名前","東方仗助");
                zyousuke.put("生年月日","1983年5月6日");
                zyousuke.put("住所","M県S市杜王町");
                return zyousuke;
                }
                
                
                HashMap<String, String> Person2(){      //3人分のプロフィールをそれぞれメソッドで作成
                HashMap<String, String> okuyasu = new HashMap<String, String>();
                okuyasu.put("ID","0022");
                okuyasu.put("名前","虹村億泰");
                okuyasu.put("生年月日","1983年4月5日");
                okuyasu.put("住所",null);       //okuyasuの住所をnullとして設定。
                return okuyasu;
                }
                
                HashMap<String, String> Person3(){      //3人分のプロフィールをそれぞれメソッドで作成
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
                HashMap<String, String> answer1=Person1();      //上記で作成したメソッドの呼び出し。
                HashMap<String, String> answer2=Person2();
                HashMap<String, String> answer3=Person3();
                
                ArrayList<HashMap>infomation=new ArrayList<HashMap>();      //呼び出したメソッドを1つの配列で表現
                infomation.add(answer1);                                    //呼び出したメソッドはHashMapなので定義する文字列は<HashMap>
                infomation.add(answer2);
                infomation.add(answer3);
                
/*              HashMap userinfomation1 = infomation.get(0);    //上記のArrayListで配列に情報をまとめたのに
                HashMap userinfomation2 = infomation.get(1);    //その情報を再度展開しようとしていました。
                HashMap userinfomation3 = infomation.get(2);
                HashMap userinfomation4 = infomation.get(3);  間違い参考資料  */

                for(HashMap<String, String> user : infomation) {        //infomation→userへ変数が変わる。 infomationのループを処理
                    for(Map.Entry<String, String> param:user.entrySet() )       //user→paramへ変数が変わる。infomationの要素のループを処理
                    {
                        out.println(param.getKey());
                        if( param.getKey().equals("ID") || param.getValue()== null)
                                {
                                continue;
                                }
                        out.println(param.getValue()+LINE_BREAK);
                        }
                    }
    %>
    </body>
</html>
