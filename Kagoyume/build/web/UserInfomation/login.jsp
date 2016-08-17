<%-- 
    ログイン管理ページ
    どのページからも遷移できる。ログインしているかいないかで処理が分岐する
    ログインしていない状態(各ページの「ログイン」というリンクから)で遷移してきた場合は、ユーザー名とパスワードを入力するフォームが表示される。また、「新規会員登録」というリンクも表示される。
    ログインに成功すると、その情報をログイン状態を管理できるセッションに書き込み、そのまま直前まで閲覧していたページに遷移する
    ログインしている状態で(各ページの「ログアウト」というリンクから)遷移してきた場合は、ログアウト処理を行う(セッションの破棄、クッキーに保存されたセッションIDを破棄)その後topへ
    ユーザーデータの削除フラグが1の場合は削除されたユーザーとして処理すること

    Document   : login
    Created on : 2016/08/15, 16:28:49
    Author     : 8mile_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <span class="yconnectLogin"></span>

<script type="text/javascript">
<span class="yconnectLogin"></span>

<script type="text/javascript">
window.yconnectInit = function() {
    YAHOO.JP.yconnect.Authorization.init({
        button: {
            format: "image",
            type: "a",
            textType:"a",
            width: 196,
            height: 38,
            className: "yconnectLogin"
        },
        authorization: {
            clientId: "dj0zaiZpPW1vUU1ESlAzZFo5TSZzPWNvbnN1bWVyc2VjcmV0Jng9OTc-",
            redirectUri: "http://developer.yahoo.co.jp/start/",
            scope: "openid",
            state: "",
            nonce: "",
            windowWidth: "500",
            windowHeight: "400"
        },
        onError: function(res) {
            // エラー発生時のコールバック関数
        },
        onCancel: function(res) {
            // 同意キャンセルされた時のコールバック関数
        }
    });
};
(function(){
var fs = document.getElementsByTagName("script")[0], s = document.createElement("script");
s.setAttribute("src", "https://s.yimg.jp/images/login/yconnect/auth/1.0.3/auth-min.js");
fs.parentNode.insertBefore(s, fs);
})();
</script>
</html>
