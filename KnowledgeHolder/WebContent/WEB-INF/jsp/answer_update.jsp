<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>knowledgeholder</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/answer_update.css">
</head>
<body>
    <div class="nav"><!-- ヘッダー -->
        <span class="h-logo">KnowledgeHolder</span>
        <a href="/KnowledgeHolder/SearchServlet">検索ページ</a>｜
        <a href="/KnowledgeHolder/ResistServlet">登録ページ</a>｜
        <a href="/KnowledgeHolder/LogServlet">履歴一覧</a>｜
        <a href="/KnowledgeHolder/LogoutServlet">ログアウト</a>
    </div>

    <h1>回答更新</h1>

    <div class="ansup-wrapper">
        <form method="POST" action="" class="ansup-form">
            <div>
                タイトル<br>
                <input type="text" value="">
            </div>
            <div>
                カテゴリー<br>
                <input type="text" value="">
            </div>
            <div>
                回答内容<br>
                <textarea cols="40" rows="10" name="ans-contents"></textarea>
            </div>
            <div>
                <input type="file" name="ans-file" value="ans-file">
            </div>
            <div>
                <input type="submit" name="submit" value="更新">
            </div>
        </form>
    </div>
    <div class="footer"><!-- フッター -->
        c 2021 GAR GAR BIRD
    </div>
</body>
</html>