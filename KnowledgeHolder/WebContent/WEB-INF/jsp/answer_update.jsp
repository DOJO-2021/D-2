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
<body class="container">
    <div class="nav"><!-- ヘッダー -->
        <span class="h-logo">KnowledgeHolder</span>
        <a href="/KnowledgeHolder/SearchServlet">検索ページ</a>｜
        <a href="/KnowledgeHolder/ResistServlet">登録ページ</a>｜
        <a href="/KnowledgeHolder/LogServlet">履歴一覧</a>｜
        <a href="/KnowledgeHolder/LogoutServlet">ログアウト</a>
    </div>

    <div class="answer-img">
        <dl class="fukidashi">
            <dt>回答更新</dt>
            <dd>回答内容を登録します。内容の入力は必須です。</dd>
        </dl>

        <div class="ansup-wrapper">
            <form method="POST" action="" class="ansup-form">
                <div class="title">
                    <p class="title-word"><span class="caution">自動</span>質問タイトルが表示されます。</p>
                    タイトル :
                    <input type="text" value="${que_title}" disabled>
                </div>
                <div class="category">
                    <p class="title-word"><span class="caution">自動</span>質問カテゴリが表示されます。</p>
                    カテゴリ :
                    <input type="text" value="${que_category}" disabled>
                </div>
                <div>
                    <span class="caution1">必須</span>回答内容<br>
                    <textarea cols="40" rows="10" name="ans_contents" value="${ans_contents}"></textarea>
                </div>
                <div>
                    <input type="file" name="ans_file" value="${ans_file}" class="file">
                </div>
                <div class="regist">
                    <input type="submit" name="submit" value="回答内容を更新する" class="regist">
                </div>
            </form>
        </div>
        <div class="footer"><!-- フッター -->
            © 2021 GAR GAR BIRD
        </div>
    </div>
</body>
</html>