<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>knowledgeholder</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/regist.css">
</head>
<body class="container">
    <div class="ht">
        <span class="h-logo">KnowledgeHolder</span>
        <span class="h-mode">モード変更<span class="mycontent"></span></span>
        <span class="h-app">機能一覧<span class="mycontent"></span></span>
        <span class="h-user">ログインユーザー<span class="mycontent"></span></span>
    </div>
    <div class="nav"><!-- ヘッダー -->
        <div class="box">
            <img src="images/World-search.png" width="42px">
            <a href="/KnowledgeHolder/SearchServlet">検索ページ</a>
        </div>
        <div class="box">
            <img src="images/Address-book.png" width="42px">
            <a href="/KnowledgeHolder/RegistServlet">登録ページ</a>
        </div>
        <div class="box">
            <img src="images/Clock.png" width="42px">
            <a href="/KnowledgeHolder/LogServlet">履歴一覧</a>
        </div>
        <div class="box">
            <img src="images/Person-x-black.png" width="42px">
            <a href="/KnowledgeHolder/LogoutServlet">ログアウト</a>
        </div>
    </div>

    <div class="regist-img">

        <dl class="fukidashi">
            <dt>質問登録</dt>
            <dd>質問内容を登録します。タイトル、カテゴリ、内容は必須です。</dd>
        </dl>

        <div class="regist-wrapper">
            <form method="POST" enctype="multipart/form-data" action="/KnowledgeHolder/RegistServlet" class="regist-form">
                <div class="title">
                    <p class="title-word"><span class="caution">必須</span>入力内容に関するタイトルを入力してください。</p>
                    タイトル :
                    <input type="text" name="que_title">
                </div>
                <div class="category">
                    <p class="title-word"><span class="caution">必須</span>入力内容に関するカテゴリを選択してください。</p>
                    カテゴリ :
                    <select name="que_category">
                        <option value="algorithm">アルゴリズム</option>
                        <option value="html">HTML</option>
                        <option value="css">CSS</option>
                        <option value="javascript">JavaScript</option>
                        <option value="sql">SQL</option>
                        <option value="java">Java</option>
                        <option value="servlet">Servlet</option>
                        <option value="jsp">JSP</option>
                        <option value="others">その他</option>
                    </select>
                </div>
                <div>
                    <span class="caution1">必須</span>質問内容<br>
                    <textarea cols="40" rows="10" name="que_contents"></textarea>
                </div>
                <div>
                    <input type="file" name="que_file" class="file">
                </div>
                <div class="regist">
                    <input type="submit" name="submit" value="質問内容を登録する" class="regist">
                </div>
            </form>
        </div>
        <div class="footer"><!-- フッター -->
            © 2021 GAR GAR BIRD
        </div>
    </div>
</body>
</html>