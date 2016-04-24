$(function() {
	console.log("[AniB]: Login.js");
	$(".button").click(function() {
		console.log("[AniB]: button clicked");

		var username = $("input#username").val();
		console.log("username: " +username);

		var password = $("input#password").val();
		console.log("password: " +password);

		var myData = JSON.stringify({
			"username" : username,
			"password" : btoa(password)
		});

		$("#message").text("Please Wait authentication in progress...");
		$("#message").css('display', 'block');

		console.log("[AniB]: data: " +myData);
		$.ajax({
			type: "POST",
			contentType: 'application/x-www-form-urlencoded',
			url: "webapi/myresource/login", /*TODO: Change to proper URL*/
			data: {
				"username" : username,
				"password" : btoa(password)
			},
			beforeSend: function (jqXHR, settings) {
		    	
		    	jqXHR.setRequestHeader ("Authorization", "Basic " + btoa(username + ":" + password));
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