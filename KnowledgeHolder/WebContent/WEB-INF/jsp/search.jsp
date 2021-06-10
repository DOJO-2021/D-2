<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>KnowledgeHolder</title>
	    <link rel="stylesheet" href="/Knowledge Holder/css/search.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	</head>
	<body>
	    <div><!-- ヘッダー -->
	        <span>KnowledgeHolder</span>
        <a href="/KnowledgeHolder/SearchServlet">検索ページ</a>｜
        <a href="/KnowledgeHolder/ResistServlet">登録ページ</a>｜
        <a href="/KnowledgeHolder/LogServlet">履歴一覧</a>｜
        <a href="/KnowledgeHolder/LogoutServlet">ログアウト</a>
	    </div>

	    <br>

	    <input type="text" id="target" name="search" placeholder="キーワードを入力">
	    <input type="submit" value="検索"><br>
	    <select name="status">
	        <option value="登録順(降順)">登録順(降順)</option>
	        <option value="登録順(昇順)">登録順(昇順)</option>
	        <option value="アクセス数">アクセス数</option>
	        <option value="完了済み">完了済み</option>
	        <option value="未完了">未完了</option>
	    </select>

	    <br>

	    <table>
	        <hr>
	        <span>2021-06/08</span><br>
	        <span>質問のタイトル</span><br>
	        <span>java</span>
	        <hr>
	    </table>

	    <br>
		<div>
			<form>
		    <tr>
		        <th>(カテゴリー一覧) i</th><br>
		        <th><input type="button" onclick="func(this)" value="アルゴリズム"></th><br>
		        <th><input type="button" onclick="func(this)" value="HTML"></th><br>
		        <th><input type="button" onclick="func(this)" value="CSS"></th><br>
		        <th><input type="button" onclick="func(this)" value="JavaScript"></th><br>
		        <th><input type="button" onclick="func(this)" value="SQL"></th><br>
		        <th><input type="button" onclick="func(this)" value="Java"></th><br>
		        <th><input type="button" onclick="func(this)" value="Servlet"></th><br>
		        <th><input type="button" onclick="func(this)" value="JSP"></th><br>
		        <th><input type="button" onclick="func(this)" value="その他"></th><br>
		    </tr>
		    </form>
		</div>

	    <div><!-- フッター -->
	        c 2021 GAR GAR BIRD
	    </div>

	    <script type="text/javascript">
			//クリックした際に検索フォームにカテゴリー名が表示される
			let func = (button) => {
	   			document.getElementById("target").value =(button.value);
			}
		</script>

	</body>
</html>