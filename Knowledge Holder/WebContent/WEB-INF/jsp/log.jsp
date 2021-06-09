<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
		<style type="text/css">
			#tabcontrol a {
				   display: inline-block;            /* インラインブロック化 */
				   border-width: 1px 1px 0px 1px;    /* 下以外の枠線を引く */
				   border-style: solid;              /* 枠線の種類：実線 */
				   border-color: black;              /* 枠線の色：黒色 */
				   border-radius: 0.75em 0.75em 0 0; /* 枠線の左上角と右上角だけを丸く */
				   padding: 0.75em 1em;              /* 内側の余白 */
				   text-decoration: none;            /* リンクの下線を消す */
				   color: black;                     /* 文字色：黒色 */
				   background-color: white;          /* 背景色：白色 */
				   font-weight: bold;                /* 太字 */
				   position: relative;               /* JavaScriptでz-indexを調整するために必要 */
				}
				/* ▼タブにマウスポインタが載った際 */
				#tabcontrol a:hover {
				   text-decoration: underline;   /* リンクの下線を引く */
				}
				/* ▼タブの中身 */
				#tabbody div {
				   border: 1px solid black; /* 枠線：黒色の実線を1pxの太さで引く */
				   margin-top: -1px;        /* 上側にあるタブと1pxだけ重ねるために「-1px」を指定 */
				   padding: 1em;            /* 内側の余白量 */
				   background-color: white; /* 背景色：白色 */
				   position: relative;      /* z-indexを調整するために必要 */
				   z-index: 0;              /* 重なり順序を「最も背面」にするため */
				}
				#tabcontrol a:nth-child(1), #tabbody div:nth-child(1) { background-color: #ffffdd; }/* 1つ目のタブとその中身用の配色 */
				#tabcontrol a:nth-child(2), #tabbody div:nth-child(2) { background-color: #ddffdd; }/* 2つ目のタブとその中身用の配色 */
				#tabcontrol a:nth-child(3), #tabbody div:nth-child(3) { background-color: #ddddff; }/* 3つ目のタブとその中身用の配色 */
		</style>
    <title>KnowledgeHolder</title>
</head>
<body>
		<!-- ヘッダー -->
    <div>
        <span>KnowledgeHolder</span>
        <a href="/Knowledge Holder/SearchServlet">検索ページ</a>｜
        <a href="/Knowledge Holder/ResistServlet">登録ページ</a>｜
        <a href="/Knowledge Holder/LogServlet">履歴一覧</a>｜
        <a href="/Knowledge Holder/LogoutServlet">ログアウト</a>
    </div>
		<!-- ヘッダー終わり -->
	<span id="tabcontrol">
	   <a href="#tabpage1">質問履歴</a>
	   <a href="#tabpage2">回答履歴</a>
	</span>
	<div id="tabbody">
			<div id="tabpage1">
						<select name="status">
		            <option value="登録順(降順)">登録順(降順)</option>
		            <option value="登録順(昇順)">登録順(昇順)</option>
		            <option value="アクセス数">アクセス数</option>
		            <option value="完了済み">完了済み</option>
		            <option value="未完了">未完了</option>
		        </select>
		        <br>
		        <form method="POST" action="/Knowledge Holder/QuestionsUpdateDeleteServlet">
		            <table>
		                <hr>
		                <span>2021-06/08　</span>
										<span>山田太郎</span><br>
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
			<div id="tabpage2">
						<select name="status">
		            <option value="登録順(降順)">登録順(降順)</option>
		            <option value="登録順(昇順)">登録順(昇順)</option>
		            <option value="アクセス数">アクセス数</option>
		            <option value="完了済み">完了済み</option>
		            <option value="未完了">未完了</option>
		        </select>
		        <br>
		        <form method="POST" action="/Knowledge Holder/AnswersUpdateDeleteServlet">
		            <table>
		                <hr>
		                <span>2021-06/08　</span>
										<span>山田大</span><br>
		                <span>回答のタイトル</span><br>
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
	</div>
		<script type="text/javascript">
		   var tabs = document.getElementById('tabcontrol').getElementsByTagName('a');
		   var pages = document.getElementById('tabbody').getElementsByTagName('div');

		   function changeTab() {
		      // ▼href属性値から対象のid名を抜き出す
		      var targetid = this.href.substring(this.href.indexOf('#')+1,this.href.length);

		      // ▼指定のタブページだけを表示する
		      for(var i=0; i<pages.length; i++) {
		         if( pages[i].id != targetid ) {
		            pages[i].style.display = "none";
		         }
		         else {
		            pages[i].style.display = "block";
		         }
		      }

		      // ▼クリックされたタブを前面に表示する
		      for(var i=0; i<tabs.length; i++) {
		         tabs[i].style.zIndex = "0";
		      }
		      this.style.zIndex = "10";

		      // ▼ページ遷移しないようにfalseを返す
		      return false;
		   }

		   // ▼すべてのタブに対して、クリック時にchangeTab関数が実行されるよう指定する
		   for(var i=0; i<tabs.length; i++) {
		      tabs[i].onclick = changeTab;
		   }

		   // ▼最初は先頭のタブを選択
		   tabs[0].onclick();
		</script>
</body>
</html>