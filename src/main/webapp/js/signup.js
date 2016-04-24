$(function() {
	console.log("[AniB]: Signup.js");

	$(".button").click(function() {
		console.log("[AniB]: Button Clicked!!!");
		var username = $("input#username").val();
		console.log("username: " +username);

		var email = $("input#email").val();
		console.log("email: " +email);

		var password = $("input#password").val();
		console.log("password: " +password);

		var myData = {
			"username" : username,
			"email" : email,
			"password" : btoa(password)
		};

		console.log("[AniB]: data: " +myData);
		$.ajax({
			type: "POST",
			contentType: 'application/json',
			url: "/myresource/activity", /*TODO: Change to proper URL*/
			data: myData,
			dataType: "json",
			success: function(data){
				console.log("Form Submission Sucess" +data);
			},
			error:function(data){
				console.log("Form Submission Failed" +data);
			}
		});

	});
});