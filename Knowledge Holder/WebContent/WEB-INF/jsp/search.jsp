<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>knowledgeholder</title>
</head>
<body>
    <div><!-- ヘッダー -->
        <span>knowledgeholder</span>
        <a href="">検索ページ</a>｜
        <a href="">登録ページ</a>｜
        <a href="">履歴一覧</a>｜
        <a href="">ログアウト</a>
    </div>

    <br>

    <input type="text" name="search" placeholder="キーワードを入力"><br>
    <select name="category">
        <option value="登録順(降順)">登録順(降順)</option>
        <option value="登録順(昇順)">登録順(昇順)</option>
        <option value="アクセス数">アクセス数</option>
        <option value="完了済み">完了済み</option>
        <option value="未完了">未完了</option>
    </select>

    <br>

    <table>
        <hr>
        <span>2021-06/08</spna><br>
        <span>質問のタイトル</span><br>
        <span>java</span>
        <hr>
    </table>

    <br>
	<div>
	    <tr>
	        <th>(カテゴリー一覧)</th><br>
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