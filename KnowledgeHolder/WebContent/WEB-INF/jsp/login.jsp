<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body class="login-img">
    <div class="nav"><!-- ヘッダー -->
        <span class="h-logo">KnowledgeHolder</span>
        <a href="/KnowledgeHolder/SearchServlet">検索ページ</a>｜
        <a href="/KnowledgeHolder/ResistServlet">登録ページ</a>｜
        <a href="/KnowledgeHolder/LogServlet">履歴一覧</a>｜
        <a href="/KnowledgeHolder/LogoutServlet">ログアウト</a>
    </div>
    <div class="login-wrapper">
        <div class="left">
            <div class="left-word">
                <p class="title">GAR BIRD</p>
                <p class="t-intro">Although it’s true you have little control,<br>
                over your experience of the events and circumstances.<br>
                because and get as near the as I can.
                </p>
            </div>

        </div>
        <div class="right">
            <p class="logmsg">ナレッジホルダーにログイン</p>
            <form method="POST" action="/knowledgeholder/LoginServlet" class="login-form">
                <p>メールアドレス</p>
                <input class ="input_text" type="text" name="MAIL_ADRESS" placeholder="Mail_adress" />
                <p>パスワード</p>
                <input class ="input_text" type="password" name="PW" placeholder="Password" />
                <input class = "btn_login" type="submit" name="LOGIN" value="ログイン">
            </form>
        </div>
    </div>
    <div class="footer"><!-- フッター -->
        © 2021 GAR GAR BIRD
    </div>
</body>
</html>