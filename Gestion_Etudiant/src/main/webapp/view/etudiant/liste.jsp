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
			<div class="card-header" style="background-color: cyan; text-align: center">
				<h1>Gestion des Etudiants</h1>
			</div>
			<a href="SaisieEtudiantServlet"><button type="button" class="btn btn-primary btn-lg">Ajouter des nouveaux etudiant</button></a>
			<p></p>
			<form class="form-inline" action="ListeEtudiantServlet" method="get">
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
						<th>Nom</th>
						<th>Prenom</th>
						<th>Telephone</th>
						<th>Adresse</th>
						<th>Editer</th>
						<th>Supprimer</th>
					</tr>

					<c:forEach items="${liste}" var="e">
						<tr>
							<td>${e.id}</td>
							<td>${e.matricule}</td>
							<td>${e.nom}</td>
							<td>${e.prenom}</td>
							<td>${e.telephone}</td>
							<td>${e.adresse.id}</td>
							<td><a href="EditerEtudiantServlet?id=${e.id}">Editer</a></td>
							<td><a onclick="return confirm('Etes-vous sûr ?')" href="SupprimerAdresseServlet?id=${e.id}">Supprimer</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>