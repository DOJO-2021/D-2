/**
 *
 */
 $(function(){
      // ボタン押下時の処理
      $('#btn').on('click',function(){
        $.ajax({
          url: "AjaxServlet",
          type: "GET",
          data: {num : $("#text1").val()}
        }).done(function (result) {
          // 通信成功時のコールバック
          $("#text1").val(result);
        }).fail(function () {
          // 通信失敗時のコールバック
          alert("読み込み失敗");
        }).always(function (result) {
          // 常に実行する処理
        });
      });
});