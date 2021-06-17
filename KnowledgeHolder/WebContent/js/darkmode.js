$(function(){
    
  function dark(){
      $('body').addClass('dark').css('transition','0.3s');
      $('body').removeClass('light').css('transition','0.3s');
      $('input[name="view-mode"]').prop('checked', true);
      $.cookie('dark', 'on', { expires: 365, path:'/'});
  }
  
  function light(){
      $('body').addClass('light').css('transition','0.3s');
      $('body').removeClass('dark').css('transition','0.3s');
      $('input[name="view-mode"]').prop('checked', false);
      $.cookie('dark', 'off', { expires: 365, path:'/'});
  }
  
  if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
      if($.cookie('dark') === 'off'){
          light();
      }else{
          dark();
      }
  }else{
      if($.cookie('dark') === 'on'){
          dark();
      }else{
          light();
      }
  }
  
  $('input[name="view-mode"]').change(function(){
      if($(this).is(':checked')) {
          $('.mode-change label').addClass('dark-move');
          $('.mode-change label').removeClass('light-move');
          setTimeout(function(){
              dark();
          },250);
      } else {
          $('.mode-change label').removeClass('dark-move');
          $('.mode-change label').addClass('light-move');
          setTimeout(function(){
              light();
          },250);
      }
  }); 
  
});