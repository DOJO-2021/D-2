<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>KnowledgeHolder</title>
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/search.css">

    </head>
    <body>
        <div class="nav"><!-- ヘッダー -->
        <span class="h-logo">KnowledgeHolder</span>
        <a href="/KnowledgeHolder/SearchServlet">検索ページ</a>｜
        <a href="/KnowledgeHolder/RegistServlet">登録ページ</a>｜
        <a href="/KnowledgeHolder/LogServlet">履歴一覧</a>｜
        <a href="/KnowledgeHolder/LogoutServlet">ログアウト</a>
        </div>

        <div class="search-wrapper">
            <div class="left">
                <div class="search-item">
                    <form method="POST" action="/KnowledgeHolder/SearchSeavlet"></form>
                        <input type="text" id="target" name="search" placeholder="キーワードを入力" class="search-word">
                        <input type="submit" value="検索" class="search-button"><br>
                        <select name="status">
                            <option value="登録順(降順)">登録順(降順)</option>
                            <option value="登録順(昇順)">登録順(昇順)</option>
                            <option value="アクセス数">アクセス数</option>
                            <option value="完了済み">完了済み</option>
                            <option value="未完了">未完了</option>
                        </select>
                    </form>
                </div>

                <br>

                <table>
                    <hr>
                    <span>2021-06/08</span><br>
                    <span>質問のタイトル</span><br>
                    <span>java</span>
                    <hr>
                </table>
            </div>

            <div class="right">
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
        </div>

        <div class="footer"><!-- フッター -->
            c 2021 GAR GAR BIRD
        </div>

        <script type="text/javascript">
            let func = (button) => {
                var elements = document.getElementById("target").value;
                document.getElementById("target").value =elements +(button.value) + " ";
            }
        </script>

    </body>
</html>