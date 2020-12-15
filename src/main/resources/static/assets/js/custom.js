/* ------------------------------------------------------------------------------
 *
 *  # Custom JS code
 *
 *  Place here all your custom js. Make sure it's loaded after app.js
 *
 * ---------------------------------------------------------------------------- */

//localStorage.setItem('isDark', false);
//console.log(localStorage.getItem('isDark'));
//
//console.log('dark mode set');




$(document).ready(function() {
	
	change_darkmode();


	function change_darkmode(){
		if(localStorage.getItem('isDark')!='Y') {
			console.log('dark mode off');
			document.getElementById('theme1').href = "/assets/css/bootstrap.min.css";
			document.getElementById('theme2').href = "/assets/css/bootstrap_limitless.min.css";
			document.getElementById('theme3').href = "/assets/css/layout.min.css";
			document.getElementById('darkMode').innerHTML = 'light';
		}else{
			console.log('dark mode on');
			document.getElementById('theme1').href = "/assets_dark/css/bootstrap.min.css";
			document.getElementById('theme2').href = "/assets_dark/css/bootstrap_limitless.min.css";
			document.getElementById('theme3').href = "/assets_dark/css/layout.min.css";
			document.getElementById('darkMode').innerHTML = 'dark';			
		}
	}
	
	$('#darkMode').on('click', function (e){
		e.preventDefault();
		console.log('darkMode button clicked');
		if(localStorage.getItem('isDark')!= 'Y') {
			localStorage.setItem('isDark', 'Y');
		} else {
			localStorage.setItem('isDark', 'N');
		}
		change_darkmode();
	});
	
	

	
	
});

