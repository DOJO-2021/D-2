<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>KnowledgeHolder</title>
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/search.css">

    </head>
    <body class="container">
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

        <div class="search-img">

            <div class="search-wrapper">
                <div class="left">
                    <div class="search-item">
                        <form method="POST" action="/KnowledgeHolder/SearchServlet">
                            <input type="text" id="target" name="que_category" >
                            <input type="text" name="keyword" placeholder="キーワードを入力" class="search-word">
                            <span class="search"><img src="images/Search1.png" class="search1" width="30px"><input type="submit" name="submit" value="検索" class="search-button"></span><br>
                        </form>
                        <form method="POST" action="/KnowledgeHolder/SearchServlet">
                            <select name="status" class="sort" id="status">
                                <option value="登録順(降順)">登録順(降順)</option>
                                <option value="登録順(昇順)">登録順(昇順)</option>
                                <option value="アクセス数">アクセス数</option>
                                <option value="完了済み">完了済み</option>
                                <option value="未完了">未完了</option>
                            </select>
                            <input type="submit" name="submit" id="submit" value="並び替え">
                            <input type="hidden" id="hidden_status" value="<%=request.getParameter("status")%>">
                        </form>
                    </div>

                    <div class="quetable">
                        <span class="catelist1"><th><img src="images/Screen.png" class="folder1" width="30px">検索結果一覧</th></span>
                        <span class="catecau1">
                            <span>&#9670;検索フォームに何も入れない状態だと質問一覧が表示されます。</span><br>
                            <span>&#9670;質問をクリックすると質問詳細画面に遷移します。</span>
                        </span>
                        <c:forEach var="e" items="${questionList}" >
                            <form method="POST" action="QuestionListServlet">
                                <input type="hidden" name="que_id" value="${e.que_id}">
                                <input type="hidden" name="que_category" value="${e.que_category}">
                                <input type="hidden" name="que_count" value="${e.que_count}">
                                <table>
                                    <hr>
                                    <span>${e.que_date}</span><br>
                                    <button name="submit" value="詳細表示" class ="clear-button"><span>${e.que_title}</span></button><br>
                                    <span>${e.que_category}</span>
                                    <hr>
                                </table>
                            </form>
                        </c:forEach>
                    </div>
                </div>
                <div class="right">
                    <form>
                    <tr>
                        <span class="catelist"><th><img src="images/Folder-add.png" class="folder" width="30px">カテゴリ一覧</th></span><br>
                        <span class="catecau">
                            <span>&#9670;下記のカテゴリをクリックすれば検索欄にカテゴリが入力されます。</span><br>
                            <span>&#9670;カテゴリ選択できるのは最大で5つまでです。</span>
                        </span>
                        <th><input type="button" onclick="func(this)" value="アルゴリズム" style="text-decoration: underline; text-decoration-thickness: 2px;"></th>
                        <th><input type="button" onclick="func(this)" value="HTML" style="text-decoration: underline; text-decoration-thickness: 2px;"></th>
                        <th><input type="button" onclick="func(this)" value="CSS" style="text-decoration: underline; text-decoration-thickness: 2px;"></th>
                        <th><input type="button" onclick="func(this)" value="JavaScript" style="text-decoration: underline; text-decoration-thickness: 2px;"></th>
                        <th><input type="button" onclick="func(this)" value="SQL" style="text-decoration: underline; text-decoration-thickness: 2px;"></th>
                        <th><input type="button" onclick="func(this)" value="Java" style="text-decoration: underline; text-decoration-thickness: 2px;"></th>
                        <th><input type="button" onclick="func(this)" value="Servlet" style="text-decoration: underline; text-decoration-thickness: 2px;"></th>
                        <th><input type="button" onclick="func(this)" value="JSP" style="text-decoration: underline; text-decoration-thickness: 2px;"></th>
                        <th><input type="button" onclick="func(this)" value="その他" style="text-decoration: underline; text-decoration-thickness: 2px;"></th>
                    </tr>
                    <jsp:include page="../components/modal.jsp" flush="true" />
                    <br>
                    </form>

                </div>
            </div>

            <div class="footer"><!-- フッター -->
                c 2021 GAR GAR BIRD
            </div>

        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript">
            let func = (button) => {
                var elements = document.getElementById("target").value;
                elementslist = elements.split(' ');
                count = elementslist.length;
                if (count>5){
                    alert("カテゴリ選択は" + 5 + "個までです。");
                }
                else {
                    document.getElementById("target").value =elements +(button.value) + " ";
                }
            }





            	//var submit = document.getElementById('submit');
            	//window.addEventListener('load',function()  {



            function loadFinished(){
                // Servletから取得したステータス
                var id = document.getElementById("hidden_status").value;
                // select要素
                var selectElem = document.getElementById("status");
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

        </script>

    </body>
</html>