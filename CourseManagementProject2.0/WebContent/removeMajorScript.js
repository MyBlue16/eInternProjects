/**
 * 
 */

/**
 * 
 */

$("#remove").submit(function(event) {
	if (validateForm()==false) {
		event.preventDefault();
	}
});

function validateForm() {

	var name = document.forms["remove"]["name"].value;
	
	if (name == null || name == "") {
		$("#name").attr('style',
				"border-radius: 5px; border:#FF0000 1px solid;");
		displayMessage();
		return false;
	}
	

}


function displayMessage() {
	$("<div></div>", {
		text : "Must fill out the highlighted field"
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