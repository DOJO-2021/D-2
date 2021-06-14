<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body class="login-img container">
    <img src="images/chicken.png" class="chiken">
    <div class="login-wrapper">
        <div class="left">
            <div class="left-word">
                <p class="title">GAR BIRD</p>
                <p class="t-intro">There is always a better way.
                </p>
            </div>

        </div>
        <div class="right">
            <div class="log-right">
                <p class="logmsg">ナレッジホルダーにログイン</p>
                <form method="POST" action="/KnowledgeHolder/LoginServlet" class="login-form">
                    <p>メールアドレス</p>
                    <span><img src="images/human.png" class="human"></span><input class ="input_text" type="text" name="MAIL_ADRESS" placeholder="Mail_adress" />
                    <p class="pw">パスワード</p>
                    <span><img src="images/key.png" class="key"></span><input class ="input_text" type="password" name="PW" placeholder="Password" />
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