<%-- 
    Document   : Task3
    Created on : 2016/07/27, 13:21:48
    Author     : 8mile_000
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            /*課題3 クッキーに現在時刻を記録し、次にアクセスした際に、前回記録した日時を表示してください。*/
            
            Date time = new Date();     //timeをDateからインスタンス化
            //Cookieで表示される内容を
            /*Calendar cal = Calendar.getInstance();
                cal.setTime(time);
                int yy = cal.get(Calendar.YEAR);
                int mm = cal.get(Calendar.MONTH)+1; //現在の月の前月が表示されないように+1を追加
                int dd = cal.get(Calendar.DAY_OF_MONTH);
                int hh = cal.get(Calendar.HOUR_OF_DAY);
                int min = cal.get(Calendar.MINUTE);
                int ss = cal.get(Calendar.SECOND);
            SimpleDateFormat now2 = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒");//文字列だがyyyyやMMなどは非常に重要 年や月などは変更可能
            String now2date = now2.format(time);
            out.print(now2date+"(SimpleDateFormatクラスを利用して取得)"); //ここまで成功*/
            
            
            Cookie c = new Cookie("LastLogin", time.toString());        //cをCookieからインスタンス化
            response.addCookie(c);
            
            // 次の訪問で。。。
            Cookie cs[] = request.getCookies();
            if (cs != null) {
                for (int i=0; i<cs.length; i++) {
                    if (cs[i].getName().equals("LastLogin")) {
                        out.print("最後のログインは、"+cs[i].getValue());
                        break;
                    }
                }
            }
        %>
    </body>
</html>
