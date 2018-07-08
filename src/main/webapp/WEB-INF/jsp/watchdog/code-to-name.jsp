<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><spring:message code="watchdog.codetoname"></spring:message></title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>
				<spring:message code="watchdog.test"></spring:message>
			</h1>
			<div>
				<br> <label class="col-sm-2"><spring:message
						code="watchdog.label.EnterStationCode"></spring:message></label> <span
					class="col-sm-5"><input class="form-control"
					id="stationCode" name="stationCode" type="text" value="" /></span> <span
					class="col-sm-5"></span> <br> <br> <br> <br>
				<button class="btn btn-primary" type="submit"
					onclick="submitRequest()">
					<spring:message code="watchdog.label.Submit"></spring:message>
				</button>
			</div>

		</div>

	</div>
	<div class="row">
		<div class="row text-left">
			<div class="col-md-12 ">
				<div class="col-md-3">
					<ul class="plan">
					<c:if test="${not empty codeToNameResponse.stations}">
						<c:forEach items="${codeToNameResponse.stations}" var="station">
							<li class="plan-head c-b" id="commitHistory"><c:out
									value="${station.name }" /></li>
						</c:forEach>
					</c:if>
						<li class="plan-head c-b" id="commitHistory">Nothing returned <c:out
									value="${codeToNameResponse.id}" /></li>
					
					</ul>
				</div>
			</div>
		</div>


	</div>

	<script type="text/javascript">
		function submitRequest() {
			var stationCode = $("#stationCode").val();

			$
					.post(
							"<c:url value="/watchdog/functions/code-to-name.html"></c:url>",
							{
								stationCode : stationCode
							})
					.fail(
							function(data) {
								window.location.href = "<c:url value="/watchdog/functions.html"></c:url>"
										+ "?message="
										+ data.responseJSON.message;
							});
		}
	</script>
</body>

</html>
