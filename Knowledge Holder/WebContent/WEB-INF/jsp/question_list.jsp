<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>knowledge holder</title>
		<link rel="styleSheet" href="/Knowledge Holder/css/style.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script type="text/javascript">

		</script>
	</head>

	<body>
		<div class=header>
		</div>

	<main>
		<div class="question">
			<c:forEach var="e" items="${quesitionList}" >
						<form class="questionitem" method="POST" action="/Knowledge Holder/QuestionListServlet">
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
		</div>

		<br>
		<br>

		<div class="open_bottom">
		回答フォーム
			<div class="hidden_window">
				質問への回答<br>
				<form class="boxitem" method="POST" enctype="multipart/form-data" action="/Knowledge Holder/AnswerServlet">
					<input type="file" name="file"><br>
					<textarea rows="10" cols="50">回答内容記入</textarea><br>
					<input class="btn" type="submit" name="SUBMIT" value="回答する">
				</form>
			</div>
		</div>

		<div class="Answer">
			<c:forEach var="e" items="${AnswerList}" >
						<form class="Answeritem" method="POST" action="/Knowledge Holder/AnswerServlet">
						<input type="hidden" name="que_id" value="${e.que-id}"><br>
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
		</div>

		<br>
		<br>


		<div class="Category_lanking">
			カテゴリ<input class= scroll type="text" name="Que-Category" value="${e.que-category}">
			<c:forEach var="e" items="${QuestionList}" >
				<form class="Answeritem" method="POST" action="/Knowledge Holder/QuestionListServlet">
					<input class= scroll type="text" name="que_count" value="${e.que_count}">閲覧数
					タイトル<input class= scroll type="text" name="que_title" value="${e.que_title}">
				</form>

		</div>

	</main>

	</body>
</html>