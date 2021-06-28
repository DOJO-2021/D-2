<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>KnowledgeHolder</title>
        <script src="js/currentdate.js"></script>
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/answer_update.css">
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

        <div class="regist-img">

            <div class="yazirusi">
                <div class="yaz-left">
                    <img src="images/yazirusi.png" height="25px">
                </div>
                <div class="yaz-right">
                    <p>KnowledgeHolderで回答内容を更新する</p>
                </div>
            </div>

            <div class="reg-circle">
                <p>登録</p>
            </div>

            <div class="regist-wrapper">

                <div class="head">
                    <div class="head-left">
                        <p>KnowledgeHolderで回答内容を更新する</p>
                    </div>
                    <div class="head-right">
                        <ul class="step">
                            <li class="no-current">質問登録</li>
                            <li class="no-current">質問更新</li>
                            <li class="is-current">回答更新</li>
                        </ul>
                    </div>
                </div>

                <div class="flexbox">
                    <div class="reg-left">
                        <c:forEach var="e" items="${up_view}">
                            <form method="POST" enctype="multipart/form-data" action="AnswersUpdateDeleteServlet" class="ansup-form">
                                <table class="regist-table">
                                    <tr class="title">
                                        <th>タイトル<span class="required">不可</span></th>
                                        <td><input type="text" name="que_title" value="${e.que_title}" disabled></td>
                                    </tr>
                                    <tr class="category">
                                        <th>カテゴリ<span class="required">不可</span></th>
                                        <td><input type="text" name="que_title" value="${e.que_category}" disabled></td>
                                    </tr>
                                    <tr class="content">
                                        <th>回答内容<span class="required any">任意</span></th>
                                        <td><textarea cols="40" rows="10" name="ans_contents" required>${e.ans_contents}</textarea></td>
                                    </tr>
                                    <tr class="file">
                                        <th>添付ファイル<span class=" required any">任意</span></th>
                                        <td><input type="file" name="ans_file" value="${e.ans_file}" class="file"></td>
                                    </tr>
                                </table>

                                <div class="file_phone">
                                    <input type="file" name="que_file">
                                </div>

                                <div>
                                    <input type="hidden" name="que_id" value="${e.que_id }">
                                </div>
                                 <div>
                                    <input type="hidden" name="ans_id" value="${e.ans_id }">
                                </div>
                                <div>
                                    <input type="hidden" name="que_category" value="${e.que_category}">
                                </div>
                                <div class="regist-button">
                                    <input type="submit" name="submit" value="回答内容を更新する" class="btn_04">
                                </div>
                            </form>
                        </c:forEach>
                    </div>

                    <div class="reg-right">
                        <div class="reg-r-left">
                        </div>
                        <div class="reg-r-right">
                            <p class="about-que">
                                KnowledgeHolderでは、<br>
                                あなたの困っている質問や回答を<br>
                                必要としています。
                            </p>
                            <p class="about-intro">
                                みんなでみんなの疑問を解決するQ&Aコミュニティーです。 ちょっとした疑問や、一人では解決できない悩みを、みんなの力で解決できます。KnowledgeHolderなら匿名での質問投稿や画像添付もできるのでどんな疑問や悩みも質問できます。 回答や返信は履歴ページから確認できます。
                            </p>
                            <img src="images/rocket.png" alt="qustion_women_image" class="women">
                        </div>
                    </div>
                </div>

            </div>

            <div class="footer"><!-- フッター -->
                © 2021 GAR GAR BIRD
            </div>

        </div>

        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
        <script src="js/darkmode.js"></script>

</body>
</html>
