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
		
		// 1. 리스너
		$("#btn-login").on("click", ()=>{
			// _this.save();
			
			// 콜백 스택
			this.login();
		});
	},
	
	save: function(){
		// alert("btn-save 로직 실행");
		let data = {
				username: $("#username").val(),
				password: $("#password").val(),
				email: $("#email").val(),
		};
		
		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), // json 으로 바꿔줌
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			// console.log(JSON.parse(resp)); // text 타입으로 데이터를 받았을때 json 오브젝트로
			// 바꿔줌

				alert("회원가입 성공");
				location.href="/";
		}).fail(function(error){
			alert("회원가입 실패");
			console.log(error);
		})
	},
	
	login: function(){
		// alert("btn-save 로직 실행");
		let data = {
				username: $("#username").val(),
				password: $("#password").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/auth/loginProc",
			data: JSON.stringify(data), // json 으로 바꿔줌
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			// console.log(JSON.parse(resp)); // text 타입으로 데이터를 받았을때 json 오브젝트로 바꿔줌
				if(resp.statusCode == 1){
					alert("로그인 성공");
					location.href="/";
				} else {
					alert("아이디와 패스워드를 다시 입력하세요");
					console.log(resp);
				}
		
		}).fail(function(error){
			alert("로그인 실패");
			console.log(error);
		})
	},
}

index.init();