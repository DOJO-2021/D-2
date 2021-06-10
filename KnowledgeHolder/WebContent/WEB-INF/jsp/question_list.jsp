<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>knowledge holder</title>
	<link rel="stylesheet" href="css/common.css">
    <link rel="styleSheet" href="css/question_list.css">
</head>

<body>
    <div class="nav"><!-- ヘッダー -->
        <span class="h-logo">KnowledgeHolder</span>
        <a href="/KnowledgeHolder/SearchServlet">検索ページ</a>｜
        <a href="/KnowledgeHolder/RegistServlet">登録ページ</a>｜
        <a href="/KnowledgeHolder/LogServlet">履歴一覧</a>｜
        <a href="/KnowledgeHolder/LogoutServlet">ログアウト</a>
    </div>

    <main>
		<div class="question-wrapper">
			<div class="left">
				<div class="question">
					<c:forEach var="e" items="${quesitionList}" >
						<form class="questionitem" method="POST" action="/KnowledgeHolder/QuestionListServlet">
							<!-- <input type="hidden" name="que_id" value="${e.que-id}"><br>
							<input type="hidden" name="user_id" value="${e.que-id}"><br> -->
							タイトル<input class= scroll type="text" name="que_title" value="${e.que_title}">
							<br>
							氏名<input class= scroll type="text" name="User_name" value="${e.user_name}"><br>
							<select name="kind">
								<option value="close">完了</option>
								<option value="open">未完了</option>
							<select>
							<br>
							<textarea rows="10" cols="50" name="que_contents" value="${e.que_contents}" disabled>質問内容表示</textarea>
							<br>
							添付ファイル
							<br>
							カテゴリ<input class= scroll type="text" name="que-category" value="${e.que_category}" disabled><br>
							更新日時<input class= scroll type="text" name="que-date" value="${e.que_date}" disabled>
							・<input class= scroll type="text" name="que-count" value="${e.que_count}" disabled>閲覧
							<br>
							<input class="btn" type="submit" name="SUBMIT" value="更新">
							<input class="btn" type="submit" name="SUBMIT" value="削除">
						</form>
					</c:forEach>
				</div>

				<br>
				<br>

				<input type="button" value="　　　　　回答　　　　　" onclick="clickUpdate()" />
				<div id="form_display">
					回答フォーム
					<div class="hidden_window">
						質問への回答<br>
						<form class="boxitem" method="POST" enctype="multipart/form-data" action="/KnowledgeHolder/AnswerServlet">
							<input type="file" name="file"><br>
							<textarea rows="10" cols="50">回答内容記入</textarea><br>
							<input class="btn" type="submit" name="SUBMIT" value="回答する">
						</form>
					</div>
				</div>

				<div class="Answer">
					<c:forEach var="e" items="${AnswerList}" >
						<form class="Answeritem" method="POST" action="/KnowledgeHolder/AnswerServlet">
							<input type="hidden" name="que_id" value="${e.que_id}"><br>
							<input type="hidden" name="user_id" value="${e.ans_id}"><br>
							氏名<input class= scroll type="text" name="user_name" value="${e.user_name}"  disabled><br>
							<textarea rows="10" cols="50" name="ans_contents" value="${e.ans_contents}" disabled>回答内容表示</textarea>
							<br>
							添付ファイル<br>
							カテゴリ<input class= scroll type="text" name="que_category" value="${e.que_category}" disabled><br>
							更新日時<input class= scroll type="text" name="que_date" value="${e.que_date}"  disabled>
							・<input class= scroll type="text" name="que_count" value="${e.que_count}" disabled>閲覧
							<br>
							<input class="btn" type="submit" name="SUBMIT" value="更新">
							<input class="btn" type="submit" name="SUBMIT" value="削除">
						</form>
					</c:forEach>
				</div>

				<br>
				<br>

				<input type="button" value="その他の回答を表示する。" onclick="clickOther()" />
				<div id="other_display">
					<div class="other_Answer">
						<c:forEach var="e" items="${AnswerList}" >
							<form class="Answeritem" method="POST" action="/KnowledgeHolder/QuestionListServlet">
								<input type="hidden" name="que_id" value="${e.que_id}"><br>
								<input type="hidden" name="user_id" value="${e.ans_id}"><br>
								氏名<input class= scroll type="text" name="user_name" value="${e.user_name}"  disabled><br>
								<textarea rows="10" cols="50" name="ans_contents" value="${e.ans_contents}" disabled>回答内容表示</textarea>
								<br>
								添付ファイル<br>
								カテゴリ<input class= scroll type="text" name="que_category" value="${e.que_category}" disabled><br>
								更新日時<input class= scroll type="text" name="que_date" value="${e.que_date}"  disabled>
								・<input class= scroll type="text" name="que_count" value="${e.que_count}" disabled>閲覧
								<br>
								<input class="btn" type="submit" name="SUBMIT" value="更新">
								<input class="btn" type="submit" name="SUBMIT" value="削除">
							</form>
						</c:forEach>
					</div>
				</div>
			</div>

            <div class="right">
				<div class="Category_lanking">
					カテゴリ<input class= scroll type="text" name="Que_Category" value="${e.que_category}">
					<c:forEach var="e" items="${QuestionList}" >
						<form class="Answeritem" method="POST" action="/Knowledge Holder/QuestionListServlet">
							<input class= scroll type="text" name="que_count" value="${e.que_count}">閲覧数
							タイトル<input class= scroll type="text" name="que_title" value="${e.que_title}">
						</form>
					</c:forEach>
				</div>
		    </div>
        </div>
    </main>

    <div class="footer"><!-- フッター -->
        © 2021 GAR GAR BIRD
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        document.getElementById("form_display").style.display ="none";
        function clickUpdate(){
            const form_display = document.getElementById("form_display");

            if(form_display.style.display=="block"){
                // noneで非表示
                form_display.style.display ="none";
            }else{
                // blockで表示
                form_display.style.display ="block";
            }
        }

        document.getElementById("other_display").style.display ="none";
        function clickOther(){
            const other_display = document.getElementById("other_display");

            if(other_display.style.display=="block"){
                // noneで非表示
                other_display.style.display ="none";
            }else{
                // blockで表示
                other_display.style.display ="block";
            }
        }

        //

    </script>
</body>
</html>