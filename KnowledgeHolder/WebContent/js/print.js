$(function() {
	$('.printon').click(function(){  //印刷ボタンをここで指定
	    $('.edate, pri-h2, .ecategory, pri-h3, .etitle, .pri-hr').printThis({
            importCSS: true,
            importStyle: true,
            loadCSS: "../css/print.css",
            header: "<h1>検索結果一覧表</h1>"
        })
	});
});
