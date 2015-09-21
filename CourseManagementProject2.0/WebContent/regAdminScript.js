/**
 * 
 */
$("#register").submit(function(event) {

	if (validateForm()==false) {
		event.preventDefault();
	}
});
function validateForm() {
	var name = document.forms["register"]["name"].value;
	var username = document.forms["register"]["user"].value;
	var password = document.forms["register"]["pass"].value;
	var confirm = document.forms["register"]["confirmPass"].value;
	var email = document.forms["register"]["email"].value;

	if (name == null || name == "") {
		$("#name").attr('style',
				"border-radius: 20px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}

	if (username == null || username == "") {
		$("#user").attr('style',
				"border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}

	if (password == null || password == "") {
		$("#pass").attr('style',
				"border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}
	if (confirm == null || confirm == "") {
		$("#confirmPass").attr('style',
				"border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}
	if (password != confirm) {
		$("#pass").attr('style',
				"border-radius: 5px; border:#FF0000 1px solid;");
		$("#confirmPass").attr('style',
				"border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage2();
		return false;
	}
	if (email == null || email == "") {
		$("#email").attr('style',
				"border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}

	if (checkCharacters(name) == false) {
		console.log("here1");
		return false;
	}

	if (checkCharacters(username)==false) {
		console.log("here2");
		return false;
	}
	if (checkCharacters(password)==false) {
		console.log("here3");

		return false;
	}

}

function displayMessage() {
	$("<div></div>", {
		text : "Must fill out the highlighted field"
	}).insertAfter("form");

}

function displayMessage2() {
	$("<div></div>", {
		text : "Passwords must match!"
	}).insertAfter("form");

}

function checkCharacters(variable) {

	var re = new RegExp(/[\[\]\(\)=,"\/\?@\:\;]/g);

	if (re.test(variable)) {
		$("<div></div>", {
			text : "Can Not Contain illegal characters!"
		}).insertAfter("form");
		return false;
	}

}