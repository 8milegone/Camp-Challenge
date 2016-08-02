<%@page import="jums.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error</title>
    </head>
    <body>
        エラーが発生しました。以下の項目を確認してください。<br>
        <%=request.getAttribute("error")%>
        <form action="index.jsp" method="POST">
        <br>
        <input type="submit" name="btnSubmit" value="トップへ戻る">
        <!--課題1;全てのページに対してトップへ戻る機能を追加する為追加-->       
    </form>
    </body>
</html>
