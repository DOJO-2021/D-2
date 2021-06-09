<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>KnowledgeHolder</title>
    <link rel="stylesheet" href="/Knowledge Holder/css/log.css">
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

    <div>質問履歴<br>
        <select name="status">
            <option value="登録順(降順)">登録順(降順)</option>
            <option value="登録順(昇順)">登録順(昇順)</option>
            <option value="アクセス数">アクセス数</option>
            <option value="完了済み">完了済み</option>
            <option value="未完了">未完了</option>
        </select>

        <br>
        <form method="POST" action="/Knowledge Holder/QuestionsUpdateDeleteServlet">
                            　 <!-- /Knowledge Holder/AnswersUpdateDeleteServlet -->
            <table>
                <hr>
                <span>2021-06/08</spna><br>
                <span>質問のタイトル</span><br>
                <span>java</span><br>
                <select name="f_tag">
                    <option value="">完了/未完了</option>
                    <option value="完了">完了</option>
                    <option value="未完了">未完了</option>
                </select>
                <input type="submit" value="更新">
                <input type="submit" value="削除">
                <hr>
            </table>
        </form>
    </div>

    <br>

    <div><!-- フッター -->
        © 2021 GAR GAR BIRD
    </div>
</body>
</html>