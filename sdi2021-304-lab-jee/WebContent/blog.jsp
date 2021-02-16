<%@ page language="java" contentType="text/html;	charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html	PUBLIC "-//W3C//DTD	HTML	4.01	Transitional//EN"	
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Blog</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,	initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<!-- Volver -->
	<div>
		<a href="index.jsp">Volver</a>
	</div>


	<!-- Codigo -->


	<h2>Blog</h2>

	<!-- Form para el post -->
	<div class="container">
		<h3>Agregar Comentario</h3>
		<form class="form-horizontal" method="post" action="ServletBlog">
			<div class="form-group">
				<label class="control-label	col-sm-2" for="nombre">Nombre:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label	col-sm-2" for="imagen">Titulo</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="title"
						required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label	col-sm-2" for="precio">Comentario:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="text" required="true" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2	col-sm-10">
					<button type="submit" class="btn	btn-primary">Agregar</button>
				</div>
			</div>
		</form>
	</div>




	<!-- Entradas del blog -->

	
	<div class="container">
	<h3>Comentarios</h3>
		<div class="row">
			<c:forEach var="post" begin="0" items="${postsList}">

				<div class="col-xs-12	col-sm-6	col-md-4	col-lg-3 ">
					<div class="col-xs-12	col-sm-6	col-md-4	col-lg-3 border border-primary">

						<div>
							<p>
								Nombre:<br>
								<c:out value="${post.name}"></c:out>
							</p>
							<div>
								<h4>
									Titulo:<br>
									<c:out value="${post.title}"></c:out>
								</h4>
							</div>
							<div>
								<p>
									Comentario:<br>
									<c:out value="${post.text}"></c:out>
								</p>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>


</body>
</html>