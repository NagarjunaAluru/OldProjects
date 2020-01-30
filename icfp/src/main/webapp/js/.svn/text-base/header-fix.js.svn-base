//for 1360 viewport only


//for transaction owner add word-break: break-all




function fixLayout(){ //fix layout
    var width = "1277px"
    $('.span12, .container, footer').css("width", width) //change width
    $('.navbar-inner .container').css('width', "100%") //remove change from navbar...
    $('.top-container').css("width", width).css("width", "+=20px") //edit the change to fix head bg
}
function fixTableWidth(){//grab the thead width
    $('table:visible thead').removeAttr('style') //kill fix before grabbing th widths
    //make th, tr and td width static
    $('thead:visible th').each(function(){    $(this).css("width", $(this).width() )   })
    $('tbody:visible tr:visible').each(function(){    $(this).css("width", $(this).width() )   })
    $('tbody:visible tr:visible td').each(function(){ $(this).css("width", $(this).width() )   })
    $('tbody:visible tr:visible a img').each(function(){//change the img links to blocks
        var width = $(this).parent().parent().width()
        $(this).parent().css({"width":width, "display":"block" })
    })
    fixLayout() //fix the layout second
}
function adjustment(){ //when the page repaints from pagination/result amount
    fixTableWidth() //fix the table width first 
    headStick() // re-fire the fixed header               
    return false
}
var theadHeight = $('table:visible thead').outerHeight()
function headStick(){  //sticky container, once top of page reaches top of table, make th fixed
    var offset = 0,sticky = false,top = $(window).scrollTop();
    var topOfTable = $('table:visible').offset().top < top
    var bottomOfTable = ($('table:visible').height()-70 + $('table:visible').offset().top) > $(window).scrollTop()
    if(topOfTable && bottomOfTable){//while at table
        $('table:visible thead').css({"position":"fixed","top":"0px","left":""}) 
        $.browser.msie ? $('table:visible').before('<div class="table-buffer"style="height:'+theadHeight+'"></div>')
                       : $('table:visible').css("padding-top", theadHeight) 
        sticky = true;
    }else if(topOfTable){ //when after table
        $('table:visible thead').css('left','-9999px')
    }else{ // when before table
        $.browser.msie ? $('table:visible').prev().remove()
                       : $('table:visible').css("padding-top",  "0px") 
        $('table:visible thead').removeAttr('style')
    }
}
function activateFixHeader(){
     //on change on select readjust the table
      //$('.pagination-rows').on('change',adjustment)
      //$(document).on('click','.pagination a',adjustment)
      $('th:visible').on('click',adjustment)


      $(window).scroll(headStick);
      //needs to addjust 4 times to ensure matching.... hackish, i know.
      for (var i = 0; i < 3; i++) { 
           $('table:visible') ? adjustment() : undefined
      };
}
function deactivateFixHeader(){
    $(window).unbind('scroll',headStick)
    $('table:visible thead').removeAttr('style')
}
function init(){

  if( $('tbody tr').length < 1)
    return;
  //if the monitor resolution is too small....
  $(window).innerWidth() >= 1000 ? activateFixHeader() //standard res, fixes width and add fixed header
                                   : fixTableWidth() // below standard, fixes width, omits fixed header
}


//## use for production
//$(document).ready(init)


//## use for devlopment
//init()




