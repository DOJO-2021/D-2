<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/login.css">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0">
</head>
<body class="login-img container">

    <div class="chi-back">
    <img src="images/garbairdnoword.png" class="chiken">
</div>
    <div class="login-wrapper">
        <div class="left">
            <div class="left-word">
                <p class="title">Knowledge Holder</p>
                <p class="t-intro">There is always a better way.<br>
                    I release all anger because anger harms me.
                </p>
            </div>
            <div class="check">
                <table class="t-left">
                    <tr>
                        <th><img src="images/check_mark.png" width="70px"></th>
                        <td><p>エラーを蓄積・検索できる</p></td>
                    </tr>
                    <tr>
                        <th><img src="images/check_mark.png" width="70px"></th>
                        <td><p>便利なファイル添付機能</p></td>
                    </tr>
                    <tr>
                        <th><img src="images/check_mark.png" width="70px"></th>
                        <td><p>人気質問ランキングを表示</p></td>
                    </tr>
                </table>
                <table class=t-right>
                    <tr>
                        <th><img src="images/check_mark.png" width="70px"></th>
                        <td><p>様々な条件で並び替え可能</p></td>
                    </tr>
                    <tr>
                        <th><img src="images/check_mark.png" width="70px"></th>
                        <td><p>柔軟な複合検索に対応</p></td>
                    </tr>
                    <tr>
                        <th><img src="images/check_mark.png" width="70px"></th>
                        <td><p>ダークモード搭載</p></td>
                    </tr>
                </table>
            </div>

        </div>
        <div class="right">
            <div class="log-right">
                <p class="logmsg">ナレッジホルダーにログイン</p>
                <hr class="hr1">
                <form method="POST" action="/KnowledgeHolder/LoginServlet" class="login-form" id="log-form" autocomplete="off">
                    <span class="log-center">
                        <p class="add">MAIL ADDRESS</p>
                        <span><img src="images/human.png" class="human"></span><input class ="input_text" id="log-id" type="text" name="user_mail"  placeholder="Mail_adress" />
                        <p class="pw">PASSWORD</p>
                        <span><img src="images/key.png" class="key"></span><input class ="input_text" id="log-pw" type="password" name="user_pw"  placeholder="Password" />
                    </span>
                    <div id="error">! メールアドレスまたはパスワードが未入力です。</div>
                    <button class ="btn_login" type="submit" name="LOGIN">ログイン</button>
                </form>
            </div>
            <p class="hello-word">HELLO EVERYONE. I AM GAR GAR BIRD.</p>
        </div>
    </div>
    <div class="footer"><!-- フッター -->
        © 2021 GAR GA<span>R BIRD</span>
    </div>

    <script src="js/jquery-3.6.0.min.js"></script>
    <script>
        $(function(){
            // 1.フォーム要素の取得
            var search_form = $("#log-form");
            // 2.フォームのsubmitイベントを取得
            search_form.submit(function(){
                // 3.入力されているキーワードを取得し、正規表現により未入力かどうかを判別する
                var keyword = $('input[id=log-id]').val();
                var keyword1 = $('input[id=log-pw]').val();
                if((keyword.match(/^[ 　\r\n\t]*$/)) || (keyword1.match(/^[ 　\r\n\t]*$/))){
                var doc0= document.getElementById("error");
                /* doc0.innerHTML= "id or passwordが未入力"; */
                document.getElementById("error").style.display ="inline-block";
                    return false;
                }
            });
        });
    </script>
</body>
</html>
