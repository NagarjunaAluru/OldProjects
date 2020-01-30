//waypoint

$('.bag-desc').waypoint(function() {
   console.log('You have scrolled to an entry.');
    $(this).parents('tr').css('background','#FFCCCC')
}, {
   context: '#pre-audits_body_container'
});

//first event

$('.test').bind('click',function(){

    $(this).clone().insertAfter(this)

    $(this).css('position','relative').css('z-index','-1')
    
    $(this).next().css({
		position:'absolute',
		top: '36px'
	})

    $(this).next().addClass('new')
var td = $('.test td')
var col1 = td.eq(0).width()
var col2 = td.eq(1).width()
var col3 = td.eq(2).width()
var col4 = td.eq(3).width()

console.log(col1, col2, col3, col4)

$('.new td').eq(0).css('width',col1)
$('.new td').eq(1).css('width',col2)
$('.new td').eq(2).css('width',col3)
$('.new td').eq(3).css('width',col4)
});



//working

//$('.bag-desc').click()
$('.expanded').waypoint(function(){

    $(this).clone().insertAfter(this)

    $(this).addClass('row-hide')
    $(this).next().addClass('row-fix')

    $(this).next().addClass('new')
var td = $('.test td')
var col1 = td.eq(0).width()
var col2 = td.eq(1).width()
var col3 = td.eq(2).width()
var col4 = td.eq(3).width()

console.log(col1, col2, col3, col4)

$('.new td').eq(0).css('width',col1)
$('.new td').eq(1).css('width',col2)
$('.new td').eq(2).css('width',col3)
$('.new td').eq(3).css('width',col4)
}, {
   context: '#pre-audits_body_container'
});

$('.next').waypoint(function(){
    $('.new').remove()
    $('.test').removeClass('row-hide')
}, {
   context: '#pre-audits_body_container'
});