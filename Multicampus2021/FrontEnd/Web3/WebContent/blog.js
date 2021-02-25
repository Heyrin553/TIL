$(document).ready() = $(function() {
	$('.outer-menu-item').hover(function() {
		// 마우스 enter
		$(this).find('.inner-menu').show();
	}, function() {
		// 마우스 leave
		$(this).find('.inner-menu').hide();
	});

	$('#css3').click(function() {
		$('#main-section').hide();
		$('#csscontent').html('<h1>CSS3 개요</h1>');
		$('#csscontent').show();
	});
	
	$('#html5_title').click(function() {
		$('#main-section').show();
		$('#csscontent').hide();
	});
	
});
