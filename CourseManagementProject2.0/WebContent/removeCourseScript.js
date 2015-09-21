/**
 * 
 */

/**
 * 
 */

$("#remove").submit(function(event) {
	if (validateForm() == false) {
		event.preventDefault();
	}
});

function validateForm() {

	var id = document.forms["remove"]["id"].value;

	if (id == null || id == "") {
		$("#id").attr('style', "border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}

}

function displayMessage() {
	$("<div></div>", {
		text : "Must fill out the highlighted field"
	}).insertAfter("form");

}

function displayCourses() {

	var button = document.getElementById("displayCourses");
	button.addEventListener("click", ajaxMajorsRequest);
}

function ajaxMajorsRequest() {
	var url = "courses";
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
			var courses = xml.getElementsByTagName("course");
			var output = "";

			for (i = 0; i < courses.length; i++) {
				output += courses[i].innerHTML + "<br/>";
			}
			document.getElementById("message").innerHTML = output;
		} else {
			// alert("Something aint right here");
		}
	};
	xhr.send();
}

displayCourses();