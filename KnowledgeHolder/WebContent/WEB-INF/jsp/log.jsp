<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="nav">
		<span class="h-logo">KnowledgeHolder</span>
		<a href="/KnowledgeHolder/SearchServlet">検索ページ</a>｜
		<a href="/KnowledgeHolder/RegistServlet">登録ページ</a>｜
		<a href="/KnowledgeHolder/LogServlet">履歴一覧</a>｜
		<a href="/KnowledgeHolder/LogoutServlet">ログアウト</a>
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
					<select name="status" class="sort">
						<option value="登録順(降順)">登録順(降順)</option>
						<option value="登録順(昇順)">登録順(昇順)</option>
						<option value="アクセス数">アクセス数</option>
						<option value="完了済み">完了済み</option>
						<option value="未完了">未完了</option>
					</select>
					<br>
					<c:forEach var="e" items="${questionList}" >
						<form method="POST" action="/KnowledgeHolder/CrudServlet">
							<table>
								<hr>
								<span class="flex">
									<span class="left">
										<span>${e.que_date}</span>
										<span>${e.que_id}</span><br>
										<span>${e.que_title}q_test</span><br>
										<span>${e.que_category}</span><br>
									</span>
									<span class="right">
										<select name="f_tag" class="f-tag">
											<option value="">完了/未完了</option>
											<option value="完了">完了</option>
											<option value="未完了">未完了</option>
										</select>
										<br><button name="q&a_submit" value="q_view" class ="updel">詳細表示</button>
										<button name="q&a_submit" value="q_update" class ="updel">更新</button>
										<button name="q&a_submit" value="q_delete" class ="updel">削除</button>
									</span>
								</span>
								<hr>
							</table>
						</form>
					</c:forEach>
				</div>
				<div id="tabpage2">
					<select name="status" class="sort">
						<option value="登録順(降順)">登録順(降順)</option>
						<option value="登録順(昇順)">登録順(昇順)</option>
						<option value="アクセス数">アクセス数</option>
						<option value="完了済み">完了済み</option>
						<option value="未完了">未完了</option>
					</select>
					<br>
					<c:forEach var="e" items="${AnswerList}">
						<form method="POST" action="/KnowledgeHolder/CrudServlet">
							<table>
								<hr>
								<span class="flex">
									<span class="left">
										<span>${e.ans_date}</span>
										<span>${e.ans_id}</span><br>
										<span>${e.ans_title}a_test</span><br>
										<span>${e.que_category}</span><br>
									</span>
									<span class="right">
										<select name="f_tag" class="f-tag">
											<option value="">完了/未完了</option>
											<option value="完了">完了</option>
											<option value="未完了">未完了</option>
										</select>
										<br><button name="q&a_submit" value="a_view" class ="updel">詳細表示</button>
										<button name="q&a_submit" value="a_update" class ="updel">更新</button>
										<button name="q&a_submit" value="a_delete" class ="updel">削除</button>
									</span>
								</span>
								<hr>
							</table>
						</form>
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