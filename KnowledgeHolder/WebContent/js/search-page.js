$(function() {
	$('.list-group').paginathing({//親要素のclassを記述
		perPage: 5,//1ページあたりの表示件数
		prevText:'前へ',//1つ前のページへ移動するボタンのテキスト
		nextText:'次へ',//1つ次のページへ移動するボタンのテキスト
		activeClass: 'active',//現在のページ番号に任意のclassを付与できます
	})
});