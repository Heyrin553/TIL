AI.onclick = function() {
	alert("AI 기술 사이트로 이동하시겠습니까?");
};

$(document).ready(function() {
	$('#loginBtn').click(function() {
		var id = $('#id').val();
		var pw = $('#pw').val();
		alert(id + ":" + pw);

		$.post("http://localhost:8989/BasicServlet/main",
			{
				id:id,
			},
			function(data, status) {
				alert("Data: " + id +"님 login ok"+ "\nStatus: " + status);
			});
	});
});
