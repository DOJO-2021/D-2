<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <div class="queup-img">
        <dl class="fukidashi">
            <dt>質問更新</dt>
            <dd>質問内容を更新します。タイトル、カテゴリ、内容を任意で更新してください。</dd>
        </dl>

        <div class="queup-wrapper">
        	<c:forEach var="e" items="${up_view}">
            <form method="POST" enctype="multipart/form-data" action="/KnowledgeHolder/QuestionsUpdateDeleteServlet" class="queup-form">
                <div class="title">
                    <p class="title-word"><span class="caution">任意</span>変更したいタイトルを付けてください。</p>
                    タイトル :
                    <input type="text" name="que_title" value="${e.que_title}" maxlength="20" required>
                </div>
                <div class="category">
                    <p class="title-word"><span class="caution">任意</span>変更したいタイトルを付けてください。</p>
                    カテゴリ :
                    <select name="que_category">
                    	<option value="others">${e.que_category}</option>
                        <option value="アルゴリズム">アルゴリズム</option>
                        <option value="HTML">HTML</option>
                        <option value="CSS">CSS</option>
                        <option value="JavaScript">JavaScript</option>
                        <option value="SQL">SQL</option>
                        <option value="Java">Java</option>
                        <option value="Servlet">Servlet</option>
                        <option value="JSP">JSP</option>
                        <option value="その他">その他</option>
                    </select>
                </div>
                <div>
                    <span class="caution1">任意</span>質問内容<br>
                    <textarea cols="40" rows="10" name="que_contents" maxlength="500" required>${e.que_contents}</textarea>
                </div>
                <div>
                    <input type="file" name="que_file" value="${e.que_file}" class="file">
                </div>
                <div >
                    <input type="hidden" name="que_id" value="${e.que_id}">
                </div>
				 <div>
                    <input type="hidden" name="que_count" value="${e.que_count}">
                </div>

                <div class="regist">
                    <input type="submit" name="submit" value="質問内容を更新する" class="regist">
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