<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="init"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<title>Movie</title>
		
		<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
		<link href="<c:url value='/css/styles.css'/>" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
			<h1>Movie</h1>
			
			<form id="movie-form" action="${linkTo[MovieController].add}" method="post">
				<div class="form-group">
					<label for="title">Title:</label>
					<input id="title" name="movie.title" value="${movie.title}" class="form-control">
					<init:errorMessage name="movie.title"/>
				</div>
				
				<div class="form-group">
					<label for="tagline">Tagline:</label>
					<input id="tagline" name="movie.tagline" value="${movie.tagline}" class="form-control">
				</div>
				
				<div class="form-group">
					<label for="overview">Overview:</label>
					<textarea id="overview" name="movie.overview" class="form-control">${movie.overview}</textarea>
				</div>
				
				<input type="submit" value="Adicionar" class="btn btn-primary">
			</form>
		</div>
	</body>
</html>