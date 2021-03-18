$(document).ready(function() {


    $("#writeBtn").click(function(){
    //alert("내용");
    	location.href ="write.html";
    })
    $.ajax({url: "../listBoard.heyrin", success: function(result){             
        var html = "";
    	result.forEach(function(item){
        	html+= "<tr> <td><a href = 'view?articleno=" + item.articleno + "'>" + item.title + "</a>"
        })
       $("#listArea").append(html)
       $('#example').DataTable();
     }});
     $("#deleteBtn").click(function(){
    	location.href ="write";
     })

});


