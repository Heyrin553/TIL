$(document).ready(function(){
	$('#loginBtn').click(function(){
		//alert("어쩌고");
		$.post("home.heyrin", 
				{}, 
				function(data, status){
					console.log(data);
					$("#msgDiv").html(data);
				});
	});
});