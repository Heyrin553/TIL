$(document).ready(function() {
	$("#memberInsertBtn").click(function() { //회원 가입 처리
		var name = $("#name").val();
		var id = $("#id").val();
		var pw = $("#pw").val();
		//alert("name은"+name+"id는"+id+"pw는"+pw); 

		$.post("../memberInsert.heyrin",
			{
				name: name,
				id: id,
				pw: pw
			},
			function(data, status) {
				alert(data);
				window.close();
			});
	});

	$("#loginBtn").click(function() {//로그인 처리	

		var id = $("#id").val();
		var pw = $("#pw").val();

		//alert(id+":"+pw);	
		$.post("login.heyrin",
			  {			   
			    id:id,
			    pw:pw
			  },
			  function(data, status){	
			  	//alert(data);		 
			  	$.cookie("logined", data);   
				$("#msgDiv").html(data);						   
			  });//end post() 	
		

	
	});//end 로그인 처리



});