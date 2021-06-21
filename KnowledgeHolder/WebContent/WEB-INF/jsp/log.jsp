<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>KnowledgeHolder</title>
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/log.css">
</head>
<body class="container">
		<!-- ヘッダー -->
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
		<!-- ヘッダー終わり -->
	<div class="log-img">
		<div class="log-wrapper">
			<span id="tabcontrol">
			<a href="#tabpage1">質問履歴</a>
			<a href="#tabpage2">回答履歴</a>
			</span>
			<div id="tabbody">
				<div id="tabpage1">
					<form method="POST" action="/KnowledgeHolder/LogServlet">
						<select name="q_status" class="sort" id="q_status">
							<option value="登録順(降順)">登録順(降順)</option>
							<option value="登録順(昇順)">登録順(昇順)</option>
							<option value="アクセス数">アクセス数</option>
							<option value="完了済み">完了済み</option>
							<option value="未完了">未完了</option>
						</select>
						<input type="submit" name="submit" id="submit" value="質問を並び替え">
						<input type="hidden" id="hidden_q_status" value="<%=request.getParameter("q_status")%>">
					</form>

					<br>
					<c:forEach var="e" items="${q_logList}">
						<table>
							<hr>
							<span class="flex">
								<span class="left">
									<form method="POST" action="/KnowledgeHolder/QuestionListServlet">
										<input type="hidden" name="que_id" value="${e.que_id}">
										<input type="hidden" name="que_category" value="${e.que_category}">
										<input type="hidden" name="que_count" value="${e.que_count}">
										<span>${e.que_date}</span><br>
										<button name="submit" value="詳細表示" class ="clear-button"><span>${e.que_title}</span></button><br>
										<span>${e.que_category}</span><br>
									</form>
								</span>
								<span class="right">
									<form method="POST" action="/KnowledgeHolder/CrudServlet">
										<input type="hidden" id="que_id" name="que_id" value="${e.que_id}">
										<br><button name="q&a_submit" value="q_update" class ="updel">更新</button>
										<button name="q&a_submit" value="q_delete" class ="updel">削除</button>
									</form>
									<span class="que-right">
										<button id=opened_btn name="f_tag" value="0">未完了</button>
										<button id=closed_btn name="f_tag" value="1">完了</button>
									</span>
								</span>
							</span>
							<hr>
						</table>
					</c:forEach>
				</div>
				<div id="tabpage2">
					<form method="POST" action="/KnowledgeHolder/LogServlet">
						<select name="a_status" class="sort" id="a_status">
							<option value="登録順(降順)">登録順(降順)</option>
							<option value="登録順(昇順)">登録順(昇順)</option>
							<option value="アクセス数">アクセス数</option>
							<option value="完了済み">完了済み</option>
							<option value="未完了">未完了</option>
						</select>
						<input type="submit" name="submit" id="submit" value="回答を並び替え">
						<input type="hidden" id="hidden_a_status" value="<%=request.getParameter("a_status")%>">
					</form>
					<br>

					<c:forEach var="e" items="${a_logList}">
						<table>
							<hr>
							<span class="flex">
								<span class="left">
									<form method="POST" action="/KnowledgeHolder/QuestionListServlet">
										<input type="hidden" name="que_id" value="${e.que_id}">
										<span>${e.ans_date}</span><br>
										<button name="submit" value="詳細表示" class ="clear-button"><span>${e.ans_contents}</span></button><br>
										<span>${e.ans_contents}</span><br>
									</form>
								</span>
								<span class="right">
									<form method="POST" action="/KnowledgeHolder/CrudServlet">
										<input type="hidden" name="que_id" value="${e.que_id}">
										<input type="hidden" name="ans_id" value="${e.ans_id}">
										<select name="f_tag" class="f-tag">
											<option value="">完了/未完了</option>
											<option value="完了">完了</option>
											<option value="未完了">未完了</option>
										</select>
										<br><button name="q&a_submit" value="a_update" class ="updel">更新</button>
										<button name="q&a_submit" value="a_delete" class ="updel">削除</button>
									</form>
								</span>
							</span>
							<hr>
						</table>
					</c:forEach>
				</div>
			</div>
		</div>

		<div class="footer"><!-- フッター -->
			© 2021 GAR GAR BIRD
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
		var tabs = document.getElementById('tabcontrol').getElementsByTagName('a');
		var pages = document.getElementById('tabbody').getElementsByTagName('div');

		function changeTab() {
			// ▼href属性値から対象のid名を抜き出す
			var targetid = this.href.substring(this.href.indexOf('#')+1,this.href.length);

			// ▼指定のタブページだけを表示する
			for(var i=0; i<pages.length; i++) {
				if( pages[i].id != targetid ) {
					pages[i].style.display = "none";
				}
				else {
					pages[i].style.display = "block";
				}
			}

			// ▼クリックされたタブを前面に表示する
			for(var i=0; i<tabs.length; i++) {
				tabs[i].style.zIndex = "0";
			}
			this.style.zIndex = "10";

			// ▼ページ遷移しないようにfalseを返す
			return false;
		}

		// ▼すべてのタブに対して、クリック時にchangeTab関数が実行されるよう指定する
		for(var i=0; i<tabs.length; i++) {
			tabs[i].onclick = changeTab;
		}

		// ▼最初は先頭のタブを選択
		tabs[0].onclick();

		//プルダウン選択（質問欄）
		function loadFinished(){
            // Servletから取得したステータス
            var id = document.getElementById("hidden_q_status").value;
            console.log(id);
            // select要素
            var selectElem = document.getElementById("q_status");
            // option要素
            var options = selectElem.children;
            for (var i=0; i < options.length; i++) {
                // option要素のvalueとServletから取得したIDが同じ場合
                if (options[i].value==id) {
                    // 選択する
                    options[i].selected = true;

                }
            }
        }
		window.addEventListener('load', loadFinished);


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
				});
			});
		});

	</script>
</body>
</html>