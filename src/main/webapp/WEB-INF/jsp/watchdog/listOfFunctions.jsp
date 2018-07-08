<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layout/taglib.jsp"%>



<div id="contact">
	<div class="container">
		<div class="row pad-top-botm">
			<div
				class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">

				<form:form commandName="codeToNameResponse"
					onsubmit='alert("Thanks for contacting us. We will get back to your query soon...")'>


					<div class="form-group">
						<form:input path="requestedStation"
							class="form-control wow rotateIn animated" data-wow-delay="0.5s"
							required="required" placeholder="Requested Station" />
						<form:errors path="requestedStation" />
					</div>
					<div class="form-group">
						<button type="submit"
							class="btn btn-success btn wow rotateIn animated "
							data-wow-delay="0.8s">SUBMIT REQUEST</button>
					</div>
				</form:form>
			</div>

		</div>
		<c:forEach items="${codeToNameResponse.stations}" var="station">
			<div class="row text-left">

				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="portfolio-item wow rotateIn animated"
						data-wow-delay="0.9s">
						<div class="team-member">
							<strong style="color: blue; font-size: 20px;">Station Name :</strong>
							<c:out value="${station.name}"></c:out>
						</div>
						<div class="team-member">
							<strong style="color: blue; font-size: 20px;">Station Code :</strong>
							<c:out value="${station.code}"></c:out>
						</div>
						
						<div class="team-member">
							<strong style="color: blue; font-size: 20px;">Station State :</strong>
							<c:out value="${station.state}"></c:out>
						</div>
						
						<div class="team-member">
							<strong style="color: blue; font-size: 20px;">Station Longitude :</strong>
							<c:out value="${station.lng}"></c:out>
						</div>
						
						<div class="team-member">
							<strong style="color: blue; font-size: 20px;">Station Lattitude:</strong>
							<c:out value="${station.lat}"></c:out>
						</div>
						
						<div class="team-member">
							<strong style="color: blue; font-size: 20px;">Station Fullname:</strong>
							<c:out value="${station.fullname}"></c:out>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<!--./ CONTACT SECTION END -->