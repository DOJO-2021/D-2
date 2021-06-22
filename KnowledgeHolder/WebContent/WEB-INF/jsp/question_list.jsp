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
								<input type="hidden" id="que_id" name="que_id" value="${e.que_id}">
								<span class="flexbox">
									<span class="que-left">
										タイトル:<span class= scroll>${e.que_title}</span>
										<br>
										氏名:<span class= scroll>${e.user_name}</span>
									</span>
								</span>
								<br>
								<span>
									${e.que_contents}
								</span>
								<br><br>
								<c:if test="${not empty e.que_file}">
									<jsp:include page="../components/image.jsp" flush="true" /><br>
								</c:if>
								カテゴリ:<span class= scroll>${e.que_category}</span><br>
								更新日時:<span class= scroll>${e.que_date}</span>
								・<span class= scroll>${e.que_count}</span>閲覧
								<br>
								<c:if test="${user_id == e.user_id}">
									<div class="queup">
										<button name="q&a_submit" value="q_update">更新</button>
										<button name="q&a_submit" value="q_delete">削除</button>
									</div>
								</c:if>
							</form>
							<c:if test="${user_id == e.user_id}">
								<input type="hidden" id="f_button" value="${e.f_tag}">
								<div id="nf_view_tag">
									<button id=opened_btn name="f_tag" value="0">完了</button>
								</div>
								<div id="f_view_tag">
									<button id=closed_btn name="f_tag" value="1">未完了</button>
								</div>
							</c:if>
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
									<input type="hidden" name="que_category" value="${e.que_category}">
									<span class="ans-btn"><input class="btn" type="submit" name="submit" value="回答する"></span>
								</form>
							</c:forEach>
						</div>
					</div>
					<c:if test="${not empty ansList}">
						<div class="Answer">
							<c:forEach var="e" items="${ansList}" >
								<form class="Answeritem" method="POST" action="/KnowledgeHolder/CrudServlet">
									<input type="hidden" name="que_id" value="${e.que_id}">
									<input type="hidden" name="ans_id" value="${e.ans_id}">
									氏名<span class= scroll>${e.user_name}</span>
									<br><br>
									<span class= scroll>${e.ans_contents}</span>
									<br><br>
									<c:if test="${not empty e.ans_file}">
										<jsp:include page="../components/image.jsp" flush="true" /><br>
									</c:if>
									更新日時:${e.ans_date}
									<br>
									<c:if test="${user_id == e.user_id}">
										<div class="queup">
											<button name="q&a_submit" value="a_update">更新</button>
											<button name="q&a_submit" value="a_delete">削除</button>
										</div>
									</c:if>
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
										氏名<span class= scroll>${e.user_name}</span>
										<br><br>
										<span class= scroll>${e.ans_contents}</span>
										<br><br>
										<c:if test="${not empty e.ans_file}">
											<jsp:include page="../components/image.jsp" flush="true" /><br>
										</c:if>
										更新日時:${e.ans_date}
										<br>
										<c:if test="${user_id == e.user_id}">
											<div class="queup">
												<button name="q&a_submit" value="a_update">更新</button>
												<button name="q&a_submit" value="a_delete">削除</button>
											</div>
										</c:if>
									</form>
								</c:forEach>
							</div>
						</div>
					</c:if>
				</div>

				<div class="right">
					<span class="catelist2"><th><img src="images/Plus.png" class="folder2" width="40px">&nbsp;&nbsp;&nbsp;&nbsp;カテゴリ別Qランキング</th></span><br>
					<span class="catecau2">
						<span>&#9670;検索フォームに何も入れない状態だと質問一覧が表示されます。</span><br>
						<span>&#9670;質問をクリックすると質問詳細画面委に遷移します。</span>
					</span>
					<br>
					<c:forEach var="e" items="${queList}" >
						<span class= scroll>カテゴリ:${e.que_category}</span>
					</c:forEach>
					<div class="Category_lanking">
						<ol type="1">
							<c:forEach var="e" items="${rankList}" begin="0" end="9">
								<form class="Answeritem" method="POST" action="/KnowledgeHolder/QuestionListServlet">
									<input type="hidden" name="que_id" value="${e.que_id}">
									<input type="hidden" name="que_category" value="${e.que_category}">
									<input type="hidden" name="que_count" value="${e.que_count}">
									<button name="submit" value="詳細表示" class ="clear-button">
										<li>${e.que_title}<span class="ranking-view">view:${e.que_count}</span></li>
									</button><br>
								</form>
							</c:forEach>
						</ol>
					</div>
				</div>
			</div>
		</main>

		<div class="footer"><!-- フッター -->
			© 2021 GAR GAR BIRD
		</div>

	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">


		$(function() {
			console.log($('#f_button').val());
			if ($('#f_button').val() == 1) {
				$("#f_view_tag").hide();
			} else {
				$("#nf_view_tag").hide();
			}
		});

		//未完了タグ
		$(function(){
			// ボタン押下時の処理
			$("#opened_btn").click(function(){
				console.log($("#opened_btn").val());
				console.log($("#que_id").val());

				$.ajax({
					url : "AjaxServlet",
					type : "POST",
					data : {
						status : $("#opened_btn").val(),
						que_id : $("#que_id").val(),
						}

				})
				.done( (data) => {
					$("#nf_view_tag").hide();
					$("#f_view_tag").show();
				});
			});
		});

		//完了タグ
		$(function(){
			// ボタン押下時の処理
			$("#closed_btn").click(function(){
				console.log($("#closed_btn").val());
				console.log($("#que_id").val());

				$.ajax({
					url : "AjaxServlet",
					type : "POST",
					data : {
						status : $("#closed_btn").val(),
						que_id : $("#que_id").val(),
						}
				}).done( (data) => {
					$("#f_view_tag").hide();
					$("#nf_view_tag").show();
				});
			});
		});


		//回答フォーム
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

		//他の回答
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


	</script>
</body>
</html>