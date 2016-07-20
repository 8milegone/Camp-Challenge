<%-- 
    Document   : Kadai3
    Created on : 2016/07/16, 23:35:37
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
    <%!
        //引き数が3つのメソッドを定義する。1つ目は適当な数値を、2つ目はデフォルト値が5の数値を
        //最後はデフォルト値がfalse(boolean)のtypeを引き数として定義する。
        //1つ目の引き数に2つ目の引き数を掛ける計算をするメソッドを作成し、typeがfalseの時はその値を表示、trueのときはさらに2乗して表示する。
        //例）Integer sample(Integer AAA, Integer BBB, boolean type) // 引数が３つのメソッド書き出し部分
        String getNum(int No1,int defaultvalue,boolean type) {
                String method= "";
                int Answer = No1 * defaultvalue;
                
                if (type==false){
                   method=""+Answer;
                   return method;//空のmethodにAnswerの値を代入させる。
                }else{
                       Answer*=Answer;//falseの条件以外はAnswerの値の2乗する。
                       method=""+Answer;
                       return method;//空のmethodにAnswerの値を代入させる。
                 }      
        }
    %>
    <%
            String Answer=getNum(8,5,true); //メソッドのgetNumを呼び出す。1つ目の値は"8"で設定。
            out.println(Answer);

    %>
    </body>
</html>

