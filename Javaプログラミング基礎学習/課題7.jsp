<%-- 
    Document   : 課題7
    Created on : 2016/07/10, 23:51:42
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
    <%
    //課題7 クエリストリングを利用して、以下の処理を実現してください。
    //スーパーのレジでレシートを作る仕組みを作成します クエリストリングで総額・個数・商品種別を受け取って処理します。
    //①商品種別は、３つ。１：雑貨、２：生鮮食品、３：その他 まずは、この商品種別を表示してください。
    //②総額と個数から１個当たりの値段を算出してください。
    //総額と１個当たりの値段を表示してください。
    //③3000円以上購入で4%、5000円以上購入で5%のポイントが付きます。
    //購入額に応じたポイントの表示を行ってください。
   
    final String LINE_BREAK = "<br>";
    String param1 = request.getParameter("zakka");// 雑貨が入ります
    String param2 = request.getParameter("syokuhin");// 生鮮食品が入ります
    String param3 = request.getParameter("hoka");// その他が入ります
    String price1 = request.getParameter("sougaku");//総額が入ります
    String count1 = request.getParameter("kosuu");//購入個数が入ります
    int p1 = Integer.parseInt(price1);//文字列から数値への型変換
    int c1 = Integer.parseInt(count1);//文字列から数値への型変換
    
//3000円以上購入レシートのURLは     ?zakka=雑貨&syokuhin=生鮮食品&hoka=その他&sougaku=3200&kosuu=4
//5000円以上購入レシートのURLは     ?zakka=雑貨&syokuhin=生鮮食品&hoka=その他&sougaku=5400&kosuu=7
//3000円未満購入レシートのURLは     ?zakka=雑貨&syokuhin=生鮮食品&hoka=その他&sougaku=1600&kosuu=2

    out.println(param1 + LINE_BREAK);
    out.println(param2 + LINE_BREAK);
    out.println(param3 + LINE_BREAK);//商品種別を表示しています。
    
    out.println("総額"); out.println(price1 +"円"+ LINE_BREAK);//総額を表示しています。
    out.println("購入個数"); out.println(count1 +"個"+ LINE_BREAK);//購入個数を表示しています。
    out.println("1個当たりの値段"); out.println(p1/c1 +"円"+ LINE_BREAK);//1個当たりの値段を表示しています。
    
    out.println("進呈ポイント"); 
    
    if(p1 >= 5000) 
    {out.println("ポイント付け率 5%");
     out.println(p1*0.05 +"ポイント" + LINE_BREAK);}//5000円以上だと5%のポイントが付く
    
    else if (p1 >= 3000) 
    {out.println("ポイント付け率 4%");
     out.println(p1*0.04 +"ポイント" + LINE_BREAK);}//3000円以上だと4%のポイントが付く
    
    else
    {out.println("ポイント付け率 0%");
     out.println("0ポイント"+ LINE_BREAK);}//30000円未満だとポイントが付かない
    
    
    

    %>
    </body>
</html>
