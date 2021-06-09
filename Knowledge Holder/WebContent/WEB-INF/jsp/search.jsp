<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>KnowledgeHolder</title>
    <link rel="stylesheet" href="/Knowledge Holder/css/search.css">
</head>
<body>
    <div><!-- ヘッダー -->
        <span>KnowledgeHolder</span>
        <a href="/Knowledge Holder/SearchServlet">検索ページ</a>｜
        <a href="/Knowledge Holder/ResistServlet">登録ページ</a>｜
        <a href="/Knowledge Holder/LogServlet">履歴一覧</a>｜
        <a href="/Knowledge Holder/LogoutServlet">ログアウト</a>
    </div>

    <br>

    <input type="text" name="search" placeholder="キーワードを入力">
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
	    <tr>
	        <th>(カテゴリー一覧) i</th><br>
	        <th>java</th><br>
	        <th>JSP</th><br>
	        <th>サーブレット</th><br>
	        <th>データベース</th><br>
	    </tr>
	</div>
    <div><!-- フッター -->
        © 2021 GAR GAR BIRD
    </div>
</body>
</html>