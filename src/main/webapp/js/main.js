// When the browser is ready...
  $(function() {
  
    // Setup form validation on the #register-form element
    $("#register-form").validate({
        // Specify the validation rules
        rules: {
        	username: {
        		required: true,
        		minlength: 3
        	},
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 5
            },
            agree: "required"
        },        
        // Specify the validation error messages
        messages: {
        	username: {
        		required: "Please provide a username",
        		minlength: "Your username must be at least 5 characters long"
        	},
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            email: "Please enter a valid email address",
            agree: "Please accept our policy"
        }
    });

    $("#login-form").validate({
        // Specify the validation rules
        rules: {
            username: {
                required: true,
                minlength: 3
            },
            password: {
                required: true,
                minlength: 5
            },
            agree: "required"
        },        
        // Specify the validation error messages
        messages: {
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            username: {
                required: "Please provide a username",
                minlength: "Your username must be at least 5 characters long"
            },
            agree: "Please accept our policy"
        }
    });

  });
