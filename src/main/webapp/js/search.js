$(function() {
	console.log("search.js");
	$(".searchButton").click(function() {
		console.log("---search.js");

		var search = $("input#search").val();
		console.log("search: " +search);
		event.stopPropagation();
		// window.location.url = "webapi/search/activities?description=" +search
		$("#searchMessage").text("Please Wait search is in progress...");
		$("#searchMessage").css('display', 'block');

		$.ajax({
			type: "GET",
			url: "webapi/myresource/description?description="+search, 
			beforeSend: function (jqXHR, settings) {
		    	url = settings.url + "?" + settings.data;
		  	},
		  	success: function(data){
				console.log("Form Submission Sucess" +data);
				$("#searchMessage").text("You are welcome");
			},
			error:function(data){
				console.log("Form Submission Failed" +data +" url: " +url);
				$("#searchMessage").text("No search result found | Try Again");	
			}
		});
	});
});