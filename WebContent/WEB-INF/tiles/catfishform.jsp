<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">

<!-- <script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
	function init() {
		var geocoder = new google.maps.Geocoder();
		document.getElementById('submit').addEventListener('click', function() {
			geocodeAddress(geocoder);
		});
	}

	function geocodeAddress(geocoder) {
		var address = document.getElementById('address').value;
		geocoder.geocode({
			'address' : address
		}, function(results, status) {

			console.log(results[0].geometry.location);
			console.log(results[0].geometry.location.lat());
			console.log(results[0].geometry.location.lng());
			var lat = results[0].geometry.location.lat();
			var lng = results[0].geometry.location.lng();
			alert("Lat: " + lat + " Lng: " + lng);
			return lat + lng;
		});
	}
</script>
 -->
<script type="text/javascript">
	$(document).ready(function() {
		init()
	});
</script>

<form id="form" method="POST" enctype="multipart/form-data"
	action="catfishform">
	First Name: <input type="text" name="catFirstName"><br /> Last
	Name: <input type="text" name="catLastName"><br /> Email: <input
		type="text" name="catEmail"><br /> Address: <input
		type="text" name="address" id="address"><br /> Age: <input
		type="text" name="catDateOfBirth"><br /> Gender: <input
		type="radio" name="catGender" value="male" checked> Male <input
		type="radio" name="catGender" value="female">Female<br>
	Phone (home): <input type="tel" name="catHomePhone"><br />
	Phone (mobile): <input type="tel" name="catMobilePhone"><br />
	Facebook link: <input type="url" name="catFacebook"><br />
	Pictures: <input type="file" name="image"><br /> <input
		id="submit" type="submit" value="Enter">
</form>

