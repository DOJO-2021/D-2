<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>knowledgeholder</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/question_update.css">
</head>
<body class="container">
    <div class="nav"><!-- ヘッダー -->
        <span class="h-logo">KnowledgeHolder</span>
        <a href="/KnowledgeHolder/SearchServlet">検索ページ</a>｜
        <a href="/KnowledgeHolder/RegistServlet">登録ページ</a>｜
        <a href="/KnowledgeHolder/LogServlet">履歴一覧</a>｜
        <a href="/KnowledgeHolder/LogoutServlet">ログアウト</a>
    </div>

    <div class="queup-img">
        <dl class="fukidashi">
            <dt>質問更新</dt>
            <dd>質問内容を更新します。タイトル、カテゴリ、内容を任意で更新してください。</dd>
        </dl>

        <div class="queup-wrapper">
            <form method="POST" action="/KnowledgeHolder/QuestionsUpdateDeleteServlet" class="queup-form">
                <div class="title">
                    <p class="title-word"><span class="caution">任意</span>変更したいタイトルを付けてください。</p>
                    タイトル :
                    <input type="text" name="que_title" value="${que_title}">
                </div>
                <div class="category">
                    <p class="title-word"><span class="caution">任意</span>変更したいタイトルを付けてください。</p>
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
                    <span class="caution1">任意</span>質問内容<br>
                    <textarea cols="40" rows="10" name="que_contents" value="${que_contents}"></textarea>
                </div>
                <div>
                    <input type="file" name="ans_file" value="${ans_file}" class="file">
                </div>
                <div class="regist">
                    <input type="submit" name="submit" value="質問内容を更新する" class="regist">
                </div>
            </form>
        </div>
        <div class="footer"><!-- フッター -->
            © 2021 GAR GAR BIRD
        </div>
    </div>
</body>
</html>