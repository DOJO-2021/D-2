<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>KnowledgeHolder</title>
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/log.css">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0">
    </head>

    <body class="container dark">

        <div class="toggle_switch mode-change">
            <input type="checkbox" name="view-mode" id="cb_toggle_switch">
            <label for="cb_toggle_switch"></label>
        </div>

        <div class="ht">
        	<label>
	        	<input type="submit" class="h-logo cleared-button" onclick="location.href='SearchServlet'" value="KnowledgeHolder">
	            <img src="images/garbairdnoword.png" class="gargarbird">
           	</label>
            <span class="h-mode">ダークモード</span>
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
		<img src="images/people_zoom.png" width="140px" class="zoom">
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
						<input type="submit" name="submit" id="submit" value="質問を並び替え" class="queans-sort">
						<input type="hidden" id="hidden_q_status" value="<%=request.getParameter("q_status")%>">
						<input type="hidden" id="hidden_tab" value="<%=request.getParameter("submit")%>">
					</form>

					<br>
					<hr class="que-hr"></hr>
					<c:forEach var="e" items="${q_logList}">
						<table>
							<span class="flex">
								<span class="left">
									<form method="POST" action="/KnowledgeHolder/QuestionListServlet">
										<input type="hidden" name="que_id" value="${e.que_id}">
										<input type="hidden" name="que_category" value="${e.que_category}">
										<input type="hidden" name="que_count" value="${e.que_count}">
										<span class="e_size">${e.que_date}</span><br>
										<button name="submit" value="詳細表示" class ="clear-button"><span class="e_contents">${e.que_title}</span></button><br>
										<span class="e_size">${e.que_category}</span><br>
									</form>
								</span>
								<span class="right">
									<form method="POST" action="/KnowledgeHolder/CrudServlet" >
										<input type="hidden" id="que_id" name="que_id" value="${e.que_id}">
										<br><button name="q&a_submit" value="q_update" class ="updel que-form">更新</button>
										<button name="q&a_submit" value="q_delete" class ="updel que-form">削除</button>
									</form>
									<!--
									<span class="que-right">
										<button id=opened_btn name="f_tag" value="0">未完了</button>
										<button id=closed_btn name="f_tag" value="1">完了</button>
									</span>
									 -->
								</span>
							</span>
							<hr class="que-hr"></hr>
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
						<input type="submit" name="submit" id="submit" value="回答を並び替え" class="queans-sort">
						<input type="hidden" id="hidden_a_status" value="<%=request.getParameter("a_status")%>">
						<input type="hidden" id="hidden_tab" value="<%=request.getParameter("submit")%>">
					</form>
					<br>

					<hr class="que-hr"></hr>
					<c:forEach var="e" items="${a_logList}">
						<table>
							<span class="flex">
								<span class="left">
									<form method="POST" action="/KnowledgeHolder/QuestionListServlet" class="ans-form">
										<input type="hidden" name="que_id" value="${e.que_id}">
										<input type="hidden" name="que_category" value="${e.que_category}">
										<input type="hidden" name="que_count" value="${e.que_count}">
										<span class="ans-form">
											<span class="e_size">${e.ans_date}</span><br>
											<button name="submit" value="詳細表示" class ="clear-button text-overflow"><span class="e_contents">${e.ans_contents}</span></button>
										</span>
									</form>
								</span>
								<span class="right">
									<form method="POST" action="/KnowledgeHolder/CrudServlet">
										<input type="hidden" name="que_id" value="${e.que_id}">
										<input type="hidden" name="ans_id" value="${e.ans_id}">
										<br><button name="q&a_submit" value="a_update" class ="updel">更新</button>
										<button name="q&a_submit" value="a_delete" class ="updel">削除</button>
									</form>
								</span>
							</span>
							<hr class="que-hr"></hr>
						</table>
					</c:forEach>
				</div>
			</div>
		</div>

		<div class="footer"><!-- フッター -->
			© 2021 GAR GAR BIRD
		</div>
	</div>

	<script src="js/jquery-3.6.0.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
	<script src="js/darkmode.js"></script>
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

		// ▼hidden_tabの値によって表示するタブを変更

		function loadFinished_tab(){

			var tab = document.getElementById("hidden_tab").value;
			console.log(tab);

			if('null' === tab) {
				tabs[0].onclick();
			}
			else if ('質問を並び替え' === tab){
				tabs[0].onclick();
			}
			else if ('回答を並び替え' === tab){
				tabs[1].onclick();
			}
		}
		window.addEventListener('load', loadFinished_tab);

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


		//プルダウン選択（回答欄）
		function loadFinished_ans(){
            // Servletから取得したステータス
            var id = document.getElementById("hidden_a_status").value;
            console.log(id);
            // select要素
            var selectElem = document.getElementById("a_status");
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
		window.addEventListener('load', loadFinished_ans);


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