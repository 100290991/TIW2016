<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@ page import="clases.User"%>
<!DOCTYPE html>
<html lang="en" class="wide wow-animation">
<head>
<!-- Site Title-->
<title>Perfil personal</title>
<meta name="format-detection" content="telephone=no">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta charset="utf-8">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<!-- Stylesheets-->
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,700%7CMontserrat:400,700">
<link rel="stylesheet" href="css/style.css">
<!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]-->
<script type="text/javascript">
	function ConfirmDelete() {
		var confirmar = confirm("Are you Sure?");
		if (confirmar) {
			alert("Su usuario ha sido eliminado");
			document.formal.action = "/Practica-Tiw/DeleteUserServlet";
			document.formal.submit();
		}
	}
</script>

</head>
<body>
	<!-- Recogo el usuario guardado en la session -->
	<%!User u = new User();%>
	<%
		u = (User) session.getAttribute("usuario");
	%>
	<h1>
		BIENVENIDO
		<%=u.getName()%>
		con ID
		<%=u.getId()%></h1>
	<div class="page">
		<!-- Page Header-->
		<header class="page-head"> </header>
		<!-- Page Content-->
		<main class="page-content text-left"> <!-- Section Title Breadcrumbs-->
		<section class="section-full">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<h1>Perfil personal</h1>
						<p></p>
						<ol class="breadcrumb">
							<li><a href="index.html">Index</a></li>
							<li class="active">Perfil personal</li>
						</ol>
					</div>
				</div>
			</div>
		</section>
		<!--Section Contact Us 1-->
		<section class="section-sm">
			<div class="container">
				<div class="row">
					<div class="col-md-8">
						<h2>Datos personales</h2>
						<hr>
						<p>Aqu� puede ver y modificar sus datos de usuario. Si desea
							modificar su email deber� ponerse en contacto con el servicio
							t�cnico.</p>
						<p>No se olvide de comprobar que los datos son correctos</p>

						<div class="col-xs-12 offset-2">
							<h4>Sus datos personales</h4>
							<!-- Rd Mailform result field-->
							<div class="rd-mailform-validate"></div>
							<!-- RD Mailform-->
							<form data-form-type="contact" method="post"
								action="ModifyUserServlet" class="rd-mailform">
								<div class="row">
									<div class="col-sm-6">
										<input type="text" name="name" Value="<%=u.getName()%>">
									</div>
									<div class="col-sm-6 input-mod-1">
										<input type="text" name="surname" value="<%=u.getSurname()%>">
									</div>
								</div>
								<input type="text" name="email" Value="<%=u.getEmail()%>"
									disabled> <input type="password" name="clave1"
									Value="<%=u.getPassword()%>>"> <select name="city"
									class="rd-mailform-select" required>
									<option value="<%=u.getCity()%>"><%=u.getCity()%></option>
									<option style="color: black" value="Madrid">Madrid</option>
									<option style="color: black" value="Barcelona">Barcelona</option>
									<option style="color: black" value="Sevilla">Valencia</option>
									<option style="color: black" value="Galicia">Galicia</option>
									<option style="color: black" value="Valencia">Sevilla</option>
									<option style="color: black" value="Extremadura">Extremadura</option>
								</select> <input type="submit" class="btn btn-primary btn-md"
									value="Modificar">
							</form>
						</div>
						<form method="post">
							<input type="button" onclick="ConfirmDelete()"
								value="Eliminar Usuario" />
						</form>
					</div>
				</div>
				<div class="col-md-4 offset-7">
					<div class="row flow-offset-6 sidebar">
						<br> <br>
						<div class="col-xs-12 col-sm-4 col-md-12">
							<address class="address">
								<span class="h4">�Tienes productos en l�nea? </span>

								<div class="container">
									<span class="h4">Modif�calos aqu�</span>
									<hr>
									<hr>
									<hr>
									<hr>

									<div class="btn-group-mod-1">
										<a href="#" class="btn btn-primary btn-sm btn-shadow-1">Productos</a>
									</div>
							</address>
						</div>

					</div>
				</div>
			</div>
	</div>
	</section>
	</main>
	<!-- Page Footer-->
	<footer class="page-foot text-center text-md-left bg-gray">
		<div class="container-fluid">
			<div class="footer-wrap">
				<div class="rd-navbar-brand">
					<a href="index.html" class="brand-name">Grand<br> <span>Estate</span></a>
				</div>
				<ul class="list-inline">
					<li><a href="#" class="fa-facebook"></a></li>
					<li><a href="#" class="fa-twitter"></a></li>
					<li><a href="#" class="fa-pinterest-p"></a></li>
					<li><a href="#" class="fa-vimeo"></a></li>
					<li><a href="#" class="fa-google"></a></li>
					<li><a href="#" class="fa-rss"></a></li>
				</ul>
				<div class="copyright">
					<p>
						&#169;<span id="copyright-year"></span> All Rights Reserved <a
							href="terms.html">Terms of Use and Privacy Policy</a>
					</p>
				</div>
			</div>
		</div>
	</footer>
	</div>
	<!-- Java script-->
	<script src="js/core.min.js"></script>
	<script src="js/script.js"></script>
</body>
</html>