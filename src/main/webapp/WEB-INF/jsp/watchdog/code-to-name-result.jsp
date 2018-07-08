<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>

<script type="text/javascript"
	src="/resources/assetsUser/js/dropzone.js"></script>
<script type="text/javascript">
	// Immediately after the js include
	Dropzone.autoDiscover = false;
</script>
<link rel="stylesheet" href="/resources/assetsUser/css/dropzone.css">

<script src="/resources/assetsUser/js/jquery.countdown.min.js"></script>


<!--HOME SECTION-->
<div class="container" id="home">
	<div class="row text-center">
		<div class="col-md-12">
			<span class="head-main">GIVE AND TAKE</span>
			<h2 class="head-sub-main">
				HELP ~ DAY
				<c:out value="${dayCount}" />
			</h2>
			<h3 class="head-last">WELCOME TO MMMINR.COM</h3>
			<a href="/user/commitment.html" class="btn btn-primary btn-lg"
				style="margin-right: 10%; padding: 10px 16px; font-size: 32px; line-height: 2.33;">GIVE
				HELP</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="/user/withdrawl.html"
				class="btn btn-success btn-lg"
				style="margin-left: 10%; padding: 10px 16px; font-size: 32px; line-height: 2.33;">TAKE
				HELP</a>
		</div>
	</div>
</div>
<!--END HOME SECTION-->

<!--PRICE SECTION-->
<section id="price-sec">
	<div class="container">
		<div class="row text-left">
			<div class="col-md-12 ">

				<div class="col-md-3">
					<ul class="plan">
						<li class="plan-head c-a" id="acceptHistory"><c:out
									value="${codeToNameResponse.id}" /><br>
					</ul>
					<c:forEach items="${codeToNameResponse.stations}" var="station">

						<ul class="plan accepthistory" style="display: none;"
							id="imageContainer${station.name }" data-toggle="popover"
							data-placement="right" data-trigger="hover"
							data-content="============================= Please wait till your help slip reaches you. It will be very soon not to worry.">
							<li class="plan-head c-v">Status : <c:out
									value="${station.name}" />
							</li>


						</ul>

					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- END PRICE SECTION-->

