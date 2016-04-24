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

		var myData = JSON.stringify({
			"username" : username,
			"email" : email,
			"password" : btoa(password)
		});

		$("#message").text("Please Wait authentication in progress...");
		$("#message").css('display', 'block');

		console.log("[AniB]: data: " +myData);
		$.ajax({
			type: "POST",
			contentType: 'application/json',
			url: "webapi/myresource/activity", /*TODO: Change to proper URL*/
			data: myData,
			dataType: "json",
			beforeSend: function (jqXHR, settings) {
		    	url = settings.url + "?" + settings.data;
		  	},
			success: function(data){
				console.log("Form Submission Sucess" +data);
				$("#message").text("Authentication Sucessful !!!!.");
				window.location.replace("./html/blogPost.html");
			},
			error:function(data){
				console.log("Form Submission Failed" +data +" url: " +url);
				$("#message").text("Authentication FAILED !!!!.");
				window.location.replace("./html/login.html");
			}
		});

	});
});