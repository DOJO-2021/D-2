<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>knowledge holder</title>
	<link rel="stylesheet" href="css/common.css">
	<link rel="styleSheet" href="css/question_list.css">
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

	<div class="quelist-img">
		<main>
			<div class="question-wrapper">
				<div class="left">
					<span class="catelist1"><th><img src="images/Folder-remove.png" class="folder1" width="40px">&nbsp;&nbsp;&nbsp;&nbsp;質問内容表示画面</th></span><br>
					<span class="catecau1">
						<span>&#9670;検索一覧にてクリックした質問の詳細画面が表示されます。</span><br>
						<span>&#9670;質問や回答が表示され、削除や更新が可能です。</span>
					</span>
					<div class="question">
						<c:forEach var="e" items="${queList}" >
							<form class="questionitem" method="POST" action="/KnowledgeHolder/CrudServlet">
								<input type="hidden" name="que_id" value="${e.que_id}"><br>
								<span class="flexbox">
									<span class="que-left">
										タイトル<input class= scroll type="text" name="que_title" value="${e.que_title}">
										<br>
										氏名<input class= scroll type="text" name="User_name" value="${e.user_name}">
									</span>
									<span class="que-right">
										<button id=status_btn name="f_tag" value="0">未完了</button>
										<button id=status_btn name="f_tag" value="1">完了</button>
									</span>
								</span>
								<br>
								<textarea rows="10" cols="40" name="que_contents" placeholder="質問内容表示" disabled>${e.que_contents}</textarea>
								<br>
								<a href ="${e.que_file }">添付ファイル</a>
								<br>
								カテゴリ<input class= scroll type="text" name="que-category" value="${e.que_category}" disabled><br>
								更新日時<input class= scroll type="text" name="que-date" value="${e.que_date}" disabled>
								・<input class= scroll type="text" name="que-count" value="${e.que_count}" disabled>閲覧
								<br>
								<div class="queup">
									<button name="q&a_submit" value="q_update">更新</button>
									<button name="q&a_submit" value="q_delete">削除</button>
								</div>
							</form>
						</c:forEach>
					</div>

					<div class="ans-button">
						<input type="button" value="回答" onclick="clickUpdate()"/>
					</div>

					<div id="form_display">
						<span class="ans-form">回答フォーム</span>
						<div class="hidden_window">
							質問への回答<br>
							<c:forEach var="e" items="${queList}" >
							<form class="boxitem" method="POST" enctype="multipart/form-data" action="/KnowledgeHolder/QuestionListServlet">
								<input type="file" name="ans_file"><br>
								<textarea rows="10" cols="40" name="ans_contents" placeholder="回答内容記入"></textarea><br>
								<input type="hidden" name="que_id" value="${e.que_id}">
								<span class="ans-btn"><input class="btn" type="submit" name="submit" value="回答する"></span>
							</form>
							</c:forEach>
						</div>
					</div>
					<c:if test="${not empty ansList}">
						<div class="Answer">
							<c:forEach var="e" items="${ansList}" >
								<form class="Answeritem" method="POST" action="/KnowledgeHolder/CrudServlet">
									<input type="hidden" name="que_id" value="${e.que_id}"><br>
									<input type="hidden" name="ans_id" value="${e.ans_id}"><br>
									氏名<input class= scroll type="text" name="user_name" value="${e.user_name}"  disabled><br>
									<textarea rows="10" cols="40" name="ans_contents" disabled>${e.ans_contents}</textarea>
									<br>
									添付ファイル<br>
									<!-- カテゴリ<input class= scroll type="text" name="que_category" value="${e.que_category}" disabled><br>
									更新日時<input class= scroll type="text" name="que_date" value="${e.ans_date}"  disabled>
									・<input class= scroll type="text" name="que_count" value="${e.que_count}" disabled>閲覧 -->
									<br>
									<div class="queup">
										<button name="q&a_submit" value="a_update">更新</button>
										<button name="q&a_submit" value="a_delete">削除</button>
									</div>
								</form>
							</c:forEach>
						</div>
					</c:if>

					<c:if test="${not empty multi_ansList}">
						<div class="other-ans">
							<input type="button" value="その他の回答を表示する。" onclick="clickOther()" />
						</div>
						<div id="other_display">
							<div class="other_Answer">
								<c:forEach var="e" items="${multi_ansList}" >
									<form class="Answeritem" method="POST" action="/KnowledgeHolder/CrudServlet">
										<input type="hidden" name="que_id" value="${e.que_id}"><br>
										<input type="hidden" name="user_id" value="${e.ans_id}"><br>
										氏名<input class= scroll type="text" name="user_name" value="${e.user_name}"  disabled><br>
										<textarea rows="10" cols="40" name="ans_contents" placeholder="回答内容表示" disabled>${e.ans_contents}</textarea>
										<br>
										添付ファイル<br>
										カテゴリ<input class= scroll type="text" name="que_category" value="${e.que_category}" disabled><br>
										更新日時<input class= scroll type="text" name="que_date" value="${e.ans_date}"  disabled>
										・<input class= scroll type="text" name="que_count" value="${e.que_count}" disabled>閲覧
										<br>
										<div class="queup">
											<button name="q&a_submit" value="a_update">更新</button>
											<button name="q&a_submit" value="a_delete">削除</button>
										</div>
									</form>
								</c:forEach>
							</div>
						</div>
					</c:if>
				</div>

				<div class="right">
					<span class="catelist2"><th><img src="images/Plus.png" class="folder2" width="40px">&nbsp;&nbsp;&nbsp;&nbsp;最新人気質問ランキング</th></span><br>
					<span class="catecau2">
						<span>&#9670;検索フォームに何も入れない状態だと質問一覧が表示されます。</span><br>
						<span>&#9670;質問をクリックすると質問詳細画面委に遷移します。</span>
					</span>
					<div class="Category_lanking">
						カテゴリ<input class= scroll type="text" name="Que_Category" value="${e.que_category}">
						<c:forEach var="e" items="${rankList}" >
							<form class="Answeritem" method="POST" action="/Knowledge Holder/QuickListServlet">
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

	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.10.1/jquery.min.js"></script>
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

		//完了未完了タグ
		$(function(){
			// ボタン押下時の処理
			$('#status_btn').on('click',function(){
				$.ajax({
					url: "CrudServlet",
					type: "POST",
					data: {status : $("#status_btn").val()}
				}).done(function (result) {
					// 通信成功時のコールバック
					$("#status_btn").val(result);
				}).always(function (result) {
					// 常に実行する処理
				});
			});
		});

	</script>
</body>
</html>