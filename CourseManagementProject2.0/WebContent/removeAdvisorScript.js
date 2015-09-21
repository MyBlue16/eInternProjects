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

function displayAdvisors() {

	var button = document.getElementById("displayAdvisors");
	button.addEventListener("click", ajaxMajorsRequest);
}

function ajaxMajorsRequest() {
	var url = "advisor";
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
			var advisors = xml.getElementsByTagName("advisor");
			var output = "";

			for (i = 0; i < advisors.length; i++) {
				output += advisors[i].innerHTML + "<br/>";
			}
			document.getElementById("message").innerHTML = output;
		} else {
			// alert("Something aint right here");
		}
	};
	xhr.send();
}

displayAdvisors();