/**
 * 
 */

$("#register").submit(function(event) {

	if (validateForm()==false) {
		console.log("In if");
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
		console.log("here");
		return false;
	}

	if (checkCharacters(username) == false) {
		console.log("here2");
		return false;
	}
	if (checkCharacters(password) == false) {
		console.log("here3");
		return false;
	}

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

function displayMajors() {

	var button = document.getElementById("displayMajors");
	button.addEventListener("click", ajaxMajorsRequest);
}

function ajaxMajorsRequest() {
	var url = "majors";
	ajaxXMLRequest(url);
}

function ajaxXMLRequest(url) {
	var xhr;

	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else {
		xhr = new ActiveXObject("Microsoft.HMLHTTP");
	}
	
	xhr.open("GET", url, true);
	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4 && xhr.status == 200) {

				var xml = xhr.responseXML;
				var majors = xml.getElementsByTagName("major");
				var output = "";

				for (i = 0; i < majors.length; i++) {
					output += majors[i].innerHTML +"<br/>";
				}
				document.getElementById("message").innerHTML = output;
			}
			else {
				alert("Something aint right here");
			}
	};
	xhr.send();
}


displayMajors();