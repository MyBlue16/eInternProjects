/**
 * 
 */

$("#registerCourse").submit(function(event) {
	console.log("Are we even in here bro");
	if (validateForm()==false) {
		console.log("In if");
		event.preventDefault();
	}
});

function validateForm() {
	var name = document.forms["registerCourse"]["name"].value;
	var start = document.forms["registerCourse"]["start"].value;
	var end = document.forms["registerCourse"]["end"].value;
	var semester = document.forms["registerCourse"]["semester"].value;
	var id = document.forms["registerCourse"]["id"].value;
	var major = document.forms["registerCourse"]["department"].value;
	var location = document.forms["registerCourse"]["location"].value;

	if (name == null || name == "") {
		$("#name").attr('style',
				"border-radius: 20px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}

	if (start == null || start == "") {
		$("#start").attr('style',
				"border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}

	if (end == null || end == "") {
		$("#end").attr('style',
				"border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}
	if (location == null || location == "") {
		$("#location").attr('style',
				"border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}
	if (id == null || id == "") {
		$("#id").attr('style',
				"border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}
	if (major == null || major == "") {
		$("#major").attr('style',
				"border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}
	if (semester == null || semester == "") {
		$("#semester").attr('style',
				"border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}

	if (checkCharacters(name) == false) {
		return false;
	}

	if (checkCharacters(location) == false) {
		return false;
	}
	if (checkCharacters(major) == false) {
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
				//alert("Something aint right here");
			}
	};
	xhr.send();
}


displayMajors();