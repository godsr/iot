/* ------------------------------------------------------------------------------
 *
 *  # Custom JS code
 *
 *  Place here all your custom js. Make sure it's loaded after app.js
 *
 * ---------------------------------------------------------------------------- */

function changeTheme() {
	
	if (document.getElementById('theme').href == "assets/css/bootsrap.min.css") {
		document.getElementById('theme').href = "assets_dark/css/bootstrap.min.css";
	} else {
		document.getElementById('theme').href = "assets/css/bootstrap.min.css";
	}
	
	var button = document.getElementById("switch");
	
 	if(button.innerHTML == "Dark Mode") {
 		button.innerHTML = "Light Mode";
 	} else {
 		button.innerHTML = "Dark Mode";
 	}
};