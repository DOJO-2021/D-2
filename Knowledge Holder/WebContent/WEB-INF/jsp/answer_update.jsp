<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>knowledgeholder</title>
</head>
<body>
<h1>回答更新</h1>
<div><!-- ヘッダー -->
        <span>knowledgeholder</span>
        <a href="">検索ページ</a>｜
        <a href="">登録ページ</a>｜
        <a href="">履歴一覧</a>｜
        <a href="">ログアウト</a>
    </div>

    <br>

<form method="POST" action="">
  <div>
 	タイトル<br>
	  <input type="text" value="">
  </div>
  <div>
  	カテゴリー<br>
       <input type="text" value="">
  </div>
  <div>
	回答内容<br>
	  <textarea cols="40" rows="10" name="ans-contents"></textarea>
  </div>
  <div>
	  <input type="file" name="ans-file" value="ans-file">
  </div>
  <div>
  	  <input type="submit" name="submit" value="更新">
  </div>

  <div><!-- フッター -->
        c 2021 GAR GAR BIRD
    </div>
</form>
</body>
</html>