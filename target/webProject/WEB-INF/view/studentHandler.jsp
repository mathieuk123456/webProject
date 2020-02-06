<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<style>
button.delete {
	background-image: url(/webProject/ressources/delete.svg);
	background-size: contain;
	background-color: transparent;
	backround-repeat: no(repeat);
	height: 20px;
	width: 20px;
	border: none !important;
	backround-repeat: no(repeat);
}

button.edit {
	background-image: url(/webProject/ressources/edit.svg);
	background-size: contain;
	background-color: transparent;
	backround-repeat: no(repeat);
	height: 20px;
	width: 20px;
	border: none !important;
	backround-repeat: no(repeat);
}

input {
	width: 100%;
}

input.readonly {
	background: transparent;
	border: none;
}

table {
	text-align: center;
}
</style>

</head>
<body>
	<div class="container">
		<div id="accordion">
			<div class="card">
				<div class="card-header" id="headingOne">
					<h5 class="mb-0">
						<button class="btn btn-link" data-toggle="collapse"
							data-target="#collapseOne" aria-expanded="true"
							aria-controls="collapseOne">Student creation</button>
					</h5>
				</div>
				<div class="card-body collapse" id="collapseOne"
					data-parent="#accordion">
					<form:form modelAttribute="student" action="studentCreation">
						<form:input path="id" value="${student.getId()}" type="hidden" />
						<div class="form-group">
							<form:label path="firstName">First name : </form:label>
							<form:input path="firstName" value="${student.getFirstName()}"
								class="form-control" />
						</div>

						<div class="form-group">
							<form:label path="lastName">Last name : </form:label>
							<form:input path="lastName" value="${student.getLastName()}"
								class="form-control" />
						</div>

						<div class="form-group">
							<form:label path="email">E-mail : </form:label>
							<form:input path="email" value="${student.getEmail()}"
								class="form-control" />
						</div>
						<input type="submit" value="Submit" class="btn btn-primary" />
					</form:form>
				</div>
			</div>


			<div class="card">
				<div class="card-header" id="headingTwo">
					<h5 class="mb-0">
						<button class="btn btn-link collapsed" data-toggle="collapse"
							data-target="#collapseTwo" aria-expanded="false"
							aria-controls="collapseTwo">Student listing</button>
					</h5>
				</div>
				<div class="card-body collapse" id="collapseTwo"
					data-parent="#accordion">


					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">Photo</th>
								<th scope="col">#</th>
								<th scope="col">First</th>
								<th scope="col">Last</th>
								<th scope="col">E-mail</th>
								<th scope="col">Delete</th>
								<th scope="col">Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="s" items="${studentList}">
								<tr>
									<form:form modelAttribute="student" action="studentEdit">

										<th scope='row'><c:if test="${s.photoExists()}">
												<form:label path="photo">
													<img src="data:image/jpg;base64,${s.getBase64Photo()}"
														width="100" height="100"></img>
												</form:label>
											</c:if></th>

										<th scope='row'><form:label path="id">${s.getId()}</form:label>
											<form:input path="id" value="${s.getId()}" type="hidden" />
										</th>
										<td><form:label path="firstName">${s.getFirstName()}</form:label>
											<form:input path="firstName" value="${s.getFirstName()}"
												type="hidden" /></td>
										<td><form:label path="lastName">${s.getLastName()}</form:label>
											<form:input path="lastName" value="${s.getLastName()}"
												type="hidden" /></td>
										<td><form:label path="email">${s.getEmail()}</form:label>
											<form:input path="email" value="${s.getEmail()}"
												type="hidden" /></td>
										<td><button class='delete' type="submit" name='edit'
												value='delete'></button></td>
										<td><button class='edit' type="submit" name='edit'
												value='edit'></button></td>
									</form:form>
								</tr>
							</c:forEach>
						</tbody>
					</table>


				</div>
			</div>
		</div>
	</div>


</body>
</html>