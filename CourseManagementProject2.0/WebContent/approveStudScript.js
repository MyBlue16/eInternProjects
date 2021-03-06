/**
 * 
 */

/**
 * 
 */

$("#approve").submit(function(event) {
	if (validateForm() == false) {
		event.preventDefault();
	}
});

function validateForm() {

	var id = document.forms["approve"]["id"].value;
	var checkbox = document.forms["approve"]["approve"].value;

	if (id == null || id == "") {
		$("#id").attr('style', "border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}
	if (checkbox == null || checkbox == "") {
		$("#approve").attr('style', "border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}

}

function displayMessage() {
	$("<div></div>", {
		text : "Must fill out the highlighted field"
	}).insertAfter("form");

}

function displayStudents() {

	var button = document.getElementById("displayStudents");
	button.addEventListener("click", ajaxMajorsRequest);
}

function ajaxMajorsRequest() {
	var url = "students";
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
			var students = xml.getElementsByTagName("student");
			var output = "";

			for (i = 0; i < students.length; i++) {
				output += students[i].innerHTML + "<br/>";
			}
			document.getElementById("message").innerHTML = output;
		} else {
			// alert("Something aint right here");
		}
	};
	xhr.send();
}

displayStudents();