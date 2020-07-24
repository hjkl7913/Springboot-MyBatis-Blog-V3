let index = {
		
	init: function(){
		// let _this = this; //this 바인딩
		// $("#btn-save").on("click", function (){
		
		// 1. 리스너
		$("#btn-save").on("click", ()=>{
			// _this.save();
			
			// 콜백 스택
			this.save();
		});
		
	},
	
	save: function(){
		// alert("btn-save 로직 실행");
		let data = {
				title: $("#title").val(),
				content: $("#content").val(),
				userId: $("#userId").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/post",
			data: JSON.stringify(data), // json 으로 바꿔줌
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			 console.log(resp); 
			// 바꿔줌

				alert("글쓰기 성공");
				location.href="/";
		}).fail(function(error){
			alert("글쓰기 실패");
			console.log(error);
		})
	},
	
}

index.init();