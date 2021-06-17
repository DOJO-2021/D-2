<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>knowledgeholder</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/answer_update.css">
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

    <div class="answer-img">
        <dl class="fukidashi">
            <dt>回答更新</dt>
            <dd>回答内容を登録します。内容の入力は必須です。</dd>
        </dl>

        <div class="ansup-wrapper">
        	<c:forEach var="e" items="${up_view}">
            <form method="POST" enctype="multipart/form-data" action="AnswersUpdateDeleteServlet" class="ansup-form">
               <div>
                    <span class="caution1">必須</span>回答内容<br>
                    <textarea cols="40" rows="10" name="ans_contents">${e.ans_contents}</textarea>
                </div>
                <div>
                    <input type="file" name="ans_file" value="${e.ans_file}" class="file">
                </div>
                <div>
                	<input type="hidden" name="ans_id" value="${e.ans_id }">
                </div>
                <div class="regist">
                    <input type="submit" value="回答内容を更新する" class="regist">
                </div>
            </form>
        </c:forEach>
        </div>
        <div class="footer"><!-- フッター -->
            © 2021 GAR GAR BIRD
        </div>
    </div>
</body>
</html>