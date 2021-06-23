<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>KnowledgeHolder</title>
        <script src="js/currentdate.js"></script>
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/search.css">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0">
    </head>
    <body class="container dark">
        <div class="gar-item">
            <img src="images/garbairdnoword.png"  width="250px" class="garbird">
            <p>GAR GAR BIRD</p>
        </div>

    <div class="toggle_switch mode-change">
        <input type="checkbox" name="view-mode" id="cb_toggle_switch">
        <label for="cb_toggle_switch"></label>
    </div>

        <div class="ht">
            <span class="h-logo">KnowledgeHolder</span>
            <span class="h-mode">ダークモード</span>
            <img src="images/garbairdnoword.png" class="gargarbird">
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
            <div class="search-item">
                <form method="POST" action="/KnowledgeHolder/SearchServlet">
                    <img src="images/Folder-add.png" width="30px" class="folder4"><input type="text" id="target" name="que_category" placeholder="カテゴリを選択" class="category-target">
                    <img src="images/icon-search.png" width="30px" class="icon-search"> <input type="text" name="keyword" placeholder="キーワードを入力" class="search-word">
                    <input type="submit" name="submit" value="検索" class="search-button">
                </form>
                <form method="POST" action="/KnowledgeHolder/SearchServlet" class="sort-item">
                    <select name="status" class="sort" id="status">
                        <option value="登録順(降順)">登録順(降順)</option>
                        <option value="登録順(昇順)">登録順(昇順)</option>
                        <option value="アクセス数">アクセス数</option>
                        <option value="完了済み">完了済</option>
                        <option value="未完了">未完了</option>
                    </select>
                    <input type="submit" name="submit" value="並び替え" class="sort-word">
                    <input type="hidden" name="sort_category" value="<%=request.getParameter("que_category")%>">
                    <input type="hidden" name="sort_keyword" value="<%=request.getParameter("keyword")%>">
                    <input type="hidden" id="hidden_status" value="<%=request.getParameter("status")%>">
                </form>
            </div>

            <div class="search-wrapper">
                <div class="left box1">
                    <div class="quetable">
                        <span class="catelist1"><th><img src="images/Screen.png" class="folder1" width="30px">検索結果一覧</th></span>
                        <span class="catecau1">
                            <span>&#9670;この画面には質問一覧が表示されます。</span><br>
                            <span>&#9670;質問をクリックすると質問詳細画面に遷移します。</span>
                        </span>

                        <div class="print-item">
                            <div class="pri-left">
                                <img src="images/printer.png" width="30px">
                            </div>
                            <div class="pri-right">
                                <a class="printon" style="text-decoration: underline; text-decoration-thickness: 1px;">印刷する</a>
                            </div>
                        </div>

                        <div class="list-group">
                            <c:forEach var="e" items="${questionList}" >
                                <form method="POST" action="QuestionListServlet" class="que-sc">
                                    <div class="Side que-hr">
                                        <div class="side-left">
                                            <input type="hidden" name="que_id" value="${e.que_id}">
                                            <input type="hidden" name="que_category" value="${e.que_category}">
                                            <input type="hidden" name="que_count" value="${e.que_count}">
                                            <div class="que-li">
                                                <div>
                                                    <div class="ecategory"><span class="pri-h0">カテゴリ:</span>${e.que_category}</div>
                                                    <button name="submit" value="詳細表示" class ="clear-button"><div class="etitle"><span class="pri-h2">タイトル:</span>${e.que_title}</div></button>
                                                    <div class="SideBySide">
                                                        <p><img src="./images/clock1.png" class="img-clock" width="25px"></p>
                                                        <p><span class="edate"><span class="pri-h3">日付:</span>${e.que_date}</span><p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="side-right">
                                            <img src="images/qaicon.png" width="90px" class="qa-icon">
                                        </div>
                                    </div>
                                    <hr class="pri-hr">
                                </form>
                            </c:forEach>
                        </div>
                    </div>
                </div>

                <div class="right box2">
                    <form>
                    <tr>
                        <span class="catelist"><th><img src="images/Folder-add.png" class="folder" width="30px">カテゴリ一覧</th></span>
                        <span class="catecau">
                            <span>&#9670;下記のカテゴリをクリックすれば検索欄が入力されます。</span><br>
                            <span>&#9670;カテゴリ選択できるのは最大で5つまでです。</span>
                        </span>
                        <th><input type="button" onclick="func(this)" value="アルゴリズム" style="text-decoration: underline; text-decoration-thickness: 1px;"></th>
                        <th><input type="button" onclick="func(this)" value="HTML" style="text-decoration: underline; text-decoration-thickness: 1px;"></th>
                        <th><input type="button" onclick="func(this)" value="CSS" style="text-decoration: underline; text-decoration-thickness: 1px;"></th>
                        <th><input type="button" onclick="func(this)" value="JavaScript" style="text-decoration: underline; text-decoration-thickness: 1px;"></th>
                        <th><input type="button" onclick="func(this)" value="SQL" style="text-decoration: underline; text-decoration-thickness: 1px;"></th>
                        <th><input type="button" onclick="func(this)" value="Java" style="text-decoration: underline; text-decoration-thickness: 1px;"></th>
                        <th><input type="button" onclick="func(this)" value="Servlet" style="text-decoration: underline; text-decoration-thickness: 1px;"></th>
                        <th><input type="button" onclick="func(this)" value="JSP" style="text-decoration: underline; text-decoration-thickness: 1px;"></th>
                        <th><input type="button" onclick="func(this)" value="その他" style="text-decoration: underline; text-decoration-thickness: 1px;"></th>
                    </tr>
                    <jsp:include page="../components/modal.jsp" flush="true" />
                    </form>

                    <main>
                        <span class="catelist2"><th><img src="images/weatcher.png" class="weicon" width="30px">お天気</th></span>
                        <span class="catecau2">
                            <span>&#9670;現在地の取得を許可するとあなたの地域の天気を表示します</span><br>
                            <span>&#9670;拒否すると東京の3日分の天気を表示します</span>
                        </span>
                        <div class="weatherMain">
                            <div class="day">
                                <div>
                                    <div class="wdate">
                                        <span id="today"></span>
                                    </div>
                                    <div>
                                        <span></span><span class="dayWeather"></span>
                                    </div>
                                    <div>
                                        <img class="dayWeatherIcon">
                                    </div>
                                    <div>
                                        <span></span><span class="nowTemp"></span><span>度</span>
                                    </div>
                                </div>
                            </div>
                            <div class="tomorrow">
                                <div>
                                    <div class="wdate">
                                        <span id="nexttoday"></span>
                                    </div>
                                    <div>
                                        <span></span><span class="tomorrowWeather"></span>
                                    </div>
                                    <div>
                                        <img class="tomorrowWeatherIcon">
                                    </div>
                                    <div>
                                        <span></span><span class="tomorrowTemp"></span><span>度</span>
                                    </div>
                                </div>
                            </div>
                            <div class="dayAfterTomorrow">
                                <div>
                                    <div class="wdate">
                                        <span id="twoday"></span>
                                    </div>
                                    <div>
                                        <span></span><span class="dayAfterTomorrowWeather"></span>
                                    </div>
                                    <div>
                                        <img class="dayAfterTomorrowWeatherIcon">
                                    </div>
                                    <div>
                                        <span></span><span class="dayAfterTomorrowTemp"></span><span>度</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </main>

                    <div class="uranai">
                        <span class="catelist3"><th><img src="images/flog.png" class="flogicon" width="30px">運勢占い</th></span>
                        <div class="uranai-posi">
                            <button class = "button_omikuji" onclick="tryFortune()">おみくじを引く</button><br>
                            <p id = "result">結果...
                            </p>
                            <div class="uranai-back">
                                <img src="images/uranai.png" width="170px" class="uranai_img">
                                <img src="images/torii.png" width="50px" class="torii_img">
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <div class="footer"><!-- フッター -->
                © 2021 GAR GAR BIRD
            </div>

            <span id="prefecture"></span>

        </div>

        <!--JS関連のファイル読み込み-->
        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
        <script src="js/printThis.js"></script>
        <script src="js/darkmode.js"></script>
        <script src="js/paginathing.min.js"></script>
        <script src="js/search-page.js"></script>
        <script src="js/print.js"></script>
        <script src="js/app.js"></script>

        <script type="text/javascript">
            document.getElementById("today").innerHTML = getNow();
            document.getElementById("nexttoday").innerHTML = getNext();
            document.getElementById("twoday").innerHTML = getTwo();

            function getNow() {
                var now = new Date();
                var mon = now.getMonth()+1; //１を足すこと
                var day = now.getDate();
                //出力用
                var s = mon + "/" + day;
                return s;
            }
            function getNext() {
                var now = new Date();
                var mon = now.getMonth()+1; //１を足すこと
                var day = now.getDate()+1;
                //出力用
                var s = mon + "/" + day;
                return s;
            }
            function getTwo() {
                var now = new Date();
                var mon = now.getMonth()+1; //１を足すこと
                var day = now.getDate()+2;
                //出力用
                var s = mon + "/" + day;
                return s;
            }
        </script>

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

        <script>
            function tryFortune() {
                var resultInt = Math.floor(Math.random () * 7)
                switch (resultInt) {
                    case 0 : resultText = "大凶";   break;
                    case 1 : resultText = "最凶";     break;
                    case 2 : resultText = "末吉";   break;
                    case 3 : resultText = "小吉";   break;
                    case 4 : resultText = "中吉";   break;
                    case 5 : resultText = "最吉";     break;
                    default : resultText = "大吉";  break;
                }
                document.getElementById("result").textContent = resultText;
            }
        </script>

    </body>
</html>
