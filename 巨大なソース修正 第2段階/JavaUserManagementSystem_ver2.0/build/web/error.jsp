<%@page import="jums.JumsHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error</title>
    </head>
    <body>
        エラーが発生しました。以下の項目を確認してください。<br>
        
        <%=request.getAttribute("error")%><br><br>
        
        入力内容を確認の上、再度実行して下さい。<br><br>
        <%--ホームへ戻る--%>
        <%=JumsHelper.getInstance().home()%>
    </body>
    
</html>
