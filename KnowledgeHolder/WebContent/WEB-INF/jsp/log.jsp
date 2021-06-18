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
						<select name="status" class="sort">
							<option value="登録順(降順)">登録順(降順)</option>
							<option value="登録順(昇順)">登録順(昇順)</option>
							<option value="アクセス数">アクセス数</option>
							<option value="完了済み">完了済み</option>
							<option value="未完了">未完了</option>
						</select>
						<button name="submit" value="question_sort"><span>並び替え</span></button>
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
										<span>${e.que_date}</span><br>
										<button name="submit" value="詳細表示" class ="clear-button"><span>${e.que_title}</span></button><br>
										<span>${e.que_category}</span><br>
									</form>
								</span>
								<span class="right">
									<form method="POST" action="/KnowledgeHolder/CrudServlet">
										<input type="hidden" name="que_id" value="${e.que_id}">
										<select name="f_tag" class="f-tag">
											<option value="">完了/未完了</option>
											<option value="完了">完了</option>
											<option value="未完了">未完了</option>
										</select>
										<br><button name="q&a_submit" value="q_update" class ="updel">更新</button>
										<button name="q&a_submit" value="q_delete" class ="updel">削除</button>
									</form>
								</span>
							</span>
							<hr>
						</table>
					</c:forEach>
				</div>
				<div id="tabpage2">
					<form method="POST" action="/KnowledgeHolder/LogServlet">
						<select name="status" class="sort">
							<option value="登録順(降順)">登録順(降順)</option>
							<option value="登録順(昇順)">登録順(昇順)</option>
							<option value="アクセス数">アクセス数</option>
							<option value="完了済み">完了済み</option>
							<option value="未完了">未完了</option>
						</select>
						<button name="submit" value="answer_sort"><span>並び替え</span></button>
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
	</script>
</body>
</html>