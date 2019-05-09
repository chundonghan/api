$(function(){
	$("button#login").click(function(){
		var account = $("input#account").val();
		var passwd = $("input#passwd").val();
		$.ajax({
			type:'POST',
			url:'/api/login',
			data:{
				account: account,
				passwd: passwd
			},
			//contentType:'application/json',
			dataType:'json',
			success: function(data){
			    console.log(data)
			  },
			  error:function(e){
			  	console.log(e);
			
			  }
		})
	})
	
})