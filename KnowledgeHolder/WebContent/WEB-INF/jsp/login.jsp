<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/knowledgholder/css/style.css">
</head>
<body>
    <div><!-- ヘッダー -->
        <span>KnowledgeHolder</span>
        <a href="/KnowledgeHolder/SearchServlet">検索ページ</a>｜
        <a href="/KnowledgeHolder/ResistServlet">登録ページ</a>｜
        <a href="/KnowledgeHolder/LogServlet">履歴一覧</a>｜
        <a href="/KnowledgeHolder/LogoutServlet">ログアウト</a>
    </div>
    <hr>
    <div class="right">
        <p>かっこいい英語</p>
    </div>
    <div class="left">
        <form method="POST" action="/KnowledgeHolder/LoginServlet">
            <p>メールアドレス</p>
            <input class ="input_text" type="text" name="MAIL_ADRESS" placeholder="Mail_adress" />
            <p>パスワード</p>
            <input class ="input_text" type="password" name="PW" placeholder="Password" />
            <input class = "btn_login" type="submit" name="LOGIN" value="ログイン">
        </form>
    </div>
    <div><!-- フッター -->
        © 2021 GAR GAR BIRD
    </div>
</body>
</html>