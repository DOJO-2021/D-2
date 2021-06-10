<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body class="login-img">
    <img src="image/chicken.png" class="chiken">
    <div class="login-wrapper">
        <div class="left">
            <div class="left-word">
                <p class="title">GAR BIRD</p>
                <p class="t-intro">Although it’s true you have little control,<br>
                over your experience of the events and circumstances.<br>
                because and get as near the as I can. On the other hand, <br>
                The early bird catches the worm. Two wrongs don’t make a right.
                </p>
            </div>

        </div>
        <div class="right">
            <div class="log-right">
                <p class="logmsg">ナレッジホルダーにログイン</p>
                <form method="POST" action="/KnowledgeHolder/LoginServlet" class="login-form">
                    <p>メールアドレス</p>
                    <input class ="input_text" type="text" name="MAIL_ADRESS" placeholder="Mail_adress" />
                    <p>パスワード</p>
                    <input class ="input_text" type="password" name="PW" placeholder="Password" />
                    <br><button class ="btn_login" type="submit" name="LOGIN">ログイン</button>
                </form>
            </div>
            <p class="hello-word">HELLO EVERYONE. I AM GAR GAR BIRD.</p>
        </div>
    </div>
    <div class="footer"><!-- フッター -->
        © 2021 GAR GAR BIRD
    </div>
</body>
</html>