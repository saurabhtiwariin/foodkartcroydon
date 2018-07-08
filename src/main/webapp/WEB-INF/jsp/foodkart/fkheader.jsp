<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layout/taglib.jsp"%>

<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
<div class='preloader'>
	<div class='loaded'>&nbsp;</div>
</div>
<header id="home" class="navbar-fixed-top">
	<div class="header_top_menu clearfix">
		<div class="container">
			<div class="row">
				<div class="col-md-5 col-md-offset-3 col-sm-12 text-right">
					<div class="call_us_text">
						<a href=""><i class="fa fa-clock-o"></i> Order Foods 24/7</a> <a
							href=""><i class="fa fa-phone"></i>07440768025</a>
					</div>
				</div>

				<div class="col-md-4 col-sm-12">
					<div class="head_top_social text-right">
						<a href=""><i class="fa fa-facebook"></i></a> <a href=""><i
							class="fa fa-google-plus"></i></a> <a href=""><i
							class="fa fa-twitter"></i></a> <a href=""><i
							class="fa fa-linkedin"></i></a> <a href=""><i
							class="fa fa-pinterest-p"></i></a> <a href=""><i
							class="fa fa-youtube"></i></a> <a href=""><i class="fa fa-phone"></i></a>
						<a href=""><i class="fa fa-camera"></i></a>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- End navbar-collapse-->


	<div class="main_menu_bg">
		<div class="container">
			<div class="row">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse"
								data-target="#bs-example-navbar-collapse-1"
								aria-expanded="false">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand our_logo"
								href='<spring:url value="/foodkart.html"/>'><img
								src="/resources/foodkart/assets/images/logo.png" alt="" /></a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse"
							id="bs-example-navbar-collapse-1">

							<ul class="nav navbar-nav navbar-right">
								<li><a href='<spring:url value="/foodkart.html"/>'>Home</a></li>
								<security:authorize access="isAuthenticated()">
									<li><a href='<spring:url value="/program.html"/>'>PROGRAM</a></li>
								</security:authorize>
								<li><a href='<spring:url value="/fkspecial.html"/>'>Special</a></li>
								<li><a href='<spring:url value="/fkmenu.html"/>'>Menu</a></li>
								
								<li><a href='<spring:url value="/fktakeawaypoint.html"/>'>Take Away Point</a></li>
								<li><a href='<spring:url value="/fkcomingsoon.html"/>'>ComingSoon</a></li>
								<li><a href="#" class="booking">ViewCart</a></li>
								<security:authorize access="isAuthenticated()">
									<li><a href="<spring:url value='/user/memberZone.html' />">DIVE
											IN</a></li>
									<security:authorize access="hasRole('ROLE_ADMIN')">
										<li><a
											href="<spring:url value="/admin/dashboard.html" />">ADMIN</a></li>
									</security:authorize>
									<li><a href="<spring:url value="/logout" />"
										class="btn btn-danger btn-block btn-xs">LOGOUT</a></li>
								</security:authorize>

							</ul>
						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>
		</div>
	</div>
</header>
<!-- End Header Section -->


