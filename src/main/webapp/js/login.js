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
			
			},
			error:function(data){
				console.log("Form Submission Failed" +data +" url: " +url);
				
			}
		});


	});
});