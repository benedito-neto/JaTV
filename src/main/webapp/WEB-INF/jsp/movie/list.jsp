<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<title>Movies</title>
		
		<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
			<h1>Movies</h1>
	
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Title</th>
						<th scope="col">Tagline</th>
						<th scope="col">Overview</th>
					</tr>
				</thead>
	
				<tbody>
					<c:forEach items="${movies}" var="movie">
						<tr>
							<th scope="row">${movie.id}</th>
							<td>${movie.title}</td>
							<td>${movie.tagline}</td>
							<td>${movie.overview}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>