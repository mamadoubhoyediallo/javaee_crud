<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adresse</title>
<link href="css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header"
				style="background-color: cyan; text-align: center">
				<h1>Gestion des Adresses</h1>
			</div>
			<a href="view/adresse/saisie.jsp"><button type="button" class="btn btn-primary btn-lg">Ajouter des nouvelles adresses</button></a>
			<p></p>
			<form class="form-inline" action="ListeAdresseServlet" method="get">
				<div class="form-group">
					<label>Mot Clé</label> 
					<input class="form-control" type="text" name="matricule" value="${a.matricule}" style="width: 300px"/>
				</div>
					<button type="submit" class="btn btn-success">Chercher</button>
			</form>
			<p></p>
			<div class="card-body">
				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Matricule</th>
						<th>Ville</th>
						<th>Quartier</th>
						<th>Rue</th>
						<th>Editer</th>
						<th>Supprimer</th>
					</tr>

					<c:forEach items="${search}" var="a">
						<tr>
							<td>${a.id}</td>
							<td>${a.matricule}</td>
							<td>${a.ville}</td>
							<td>${a.quartier}</td>
							<td>${a.rue}</td>
							<td><a onclick="return confirm('Etes-vous sûr ?')" href="SupprimerAdresseServlet?id=${a.id}">Supprimer</a></td>
							<td><a href="EditerAdresseServlet?id=${a.id}">Editer</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${liste}" var="a">
						<tr>
							<td>${a.id}</td>
							<td>${a.matricule}</td>
							<td>${a.ville}</td>
							<td>${a.quartier}</td>
							<td>${a.rue}</td>
							<td><a onclick="return confirm('Etes-vous sûr ?')" href="SupprimerAdresseServlet?id=${a.id}">Supprimer</a></td>
							<td><a href="EditerAdresseServlet?id=${a.id}">Editer</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>