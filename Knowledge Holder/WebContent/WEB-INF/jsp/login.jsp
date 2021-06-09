<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/knowledgholder/css/style.css">
</head>
<body class="background">
<hr>
<div class="right">
<p>かっこいい英語</p>
</div>
<div class="left">
<form method="POST" action="/knowledgeholder/LoginServlet">
<p>メールアドレス</p>
<input class ="input_text" type="text" name="MAIL_ADRESS" placeholder="Mail_adress" />
<p>パスワード</p>
<input class ="input_text" type="password" name="PW" placeholder="Password" />
<input class = "btn_login" type="submit" name="LOGIN" value="ログイン">
</form>
</div>
</body>
</html>