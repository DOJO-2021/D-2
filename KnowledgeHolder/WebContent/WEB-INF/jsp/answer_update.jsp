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
        <label>
            <div class="box hedder-point">
                <input type="submit" class="hedder-clear-button" onclick="location.href='SearchServlet'" value="">
                <img src="images/World-search.png" width="42px">
                <span>検索ページ</span>
            </div>
        </label>
        <label>
            <div class="box hedder-point">
                <input type="submit" class="hedder-clear-button" onclick="location.href='RegistServlet'" value="">
                <img src="images/Address-book.png" width="42px">
                <span>登録ページ</span>
            </div>
        </label>
        <label>
            <div class="box hedder-point">
                <input type="submit" class="hedder-clear-button" onclick="location.href='LogServlet'" value="">
                <img src="images/Clock.png" width="42px">
                <span>履歴一覧</span>
            </div>
        </label>
        <label>
            <div class="box hedder-point">
                <input type="submit" class="hedder-clear-button" onclick="location.href='LogoutServlet'" value="">
                <img src="images/Person-x-black.png" width="42px">
                <span>ログアウト</span>
            </div>
        </label>
    </div>

    <div class="answer-img">
        <dl class="fukidashi">
            <dt>回答更新</dt>
            <dd>回答内容を登録します。内容の入力は必須です。</dd>
        </dl>

        <div class="ansup-wrapper">
        	<c:forEach var="e" items="${up_view}">
            <form method="POST" enctype="multipart/form-data" action="AnswersUpdateDeleteServlet" class="ansup-form">
            	 <div class="title">
                    タイトル :<input type="text" name="que_title" value="${e.que_title}" disabled>
                </div>
                <div class="category">
                    カテゴリ :${e.que_category}
                </div>

               <div>
                    <span class="caution1">必須</span>回答内容<br>
                    <textarea cols="40" rows="10" name="ans_contents">${e.ans_contents}</textarea>
                </div>
                <div>
                    <input type="file" name="ans_file" value="${e.ans_file}" class="file">
                </div>
                <div>
                	<input type="hidden" name="que_id" value="${e.que_id }">
                </div>
                 <div>
                	<input type="hidden" name="ans_id" value="${e.ans_id }">
                </div>
                                 <div>
                	<input type="hidden" name="que_category" value="${e.que_category}">
                </div>
                <div class="regist">
                    <input type="submit" name="submit" value="回答内容を更新する" class="regist">
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