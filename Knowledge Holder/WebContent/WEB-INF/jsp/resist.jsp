<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>knowledgeholder</title>
</head>
<body>
<h1>質問登録</h1>
<div><!-- ヘッダー -->
        <span>knowledgeholder</span>
        <a href="">検索ページ</a>|
        <a href="">登録ページ</a>|
        <a href="">履歴一覧</a>｜
        <a href="">ログアウト</a>
    </div>

    <br>

<form method="POST" action="">
  <div>
 	タイトル<br>
	  <input type="text" name="que-title" value="">
  </div>
  <div>
  	カテゴリー<br>
      <select name="que-category">
		<option value="algorithm">アルゴリズム</option>
		<option value="html">HTML</option>
		<option value="css">CSS</option>
		<option value="javascript">JavaScript</option>
		<option value="sql">SQL</option>
		<option value="java">Java</option>
		<option value="servlet">Servlet</option>
		<option value="jsp">JSP</option>
		<option value="others">その他</option>
      </select>
  </div>
  <div>
	質問内容<br>
	  <textarea cols="40" rows="10" name="que-contents"></textarea>
  </div>
  <div>
	  <input type="file" name="que-file" value="que-file">
  </div>
  <div>
  	  <input type="submit" name="submit" value="送信">
  </div>

  <div><!-- フッター -->
        c 2021 GAR GAR BIRD
    </div>
</form>
</body>
</html>