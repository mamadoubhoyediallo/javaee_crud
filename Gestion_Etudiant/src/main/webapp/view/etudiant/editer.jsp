<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Saisie</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Modifier une adresse</div>
			<div class="card-body">
				<form action="<%=request.getContextPath()%>/ModifierAdresseServlet" method="post">
				<div hidden class="form-group">
						<label class="control-label">ID</label> 
						<input type="text" name="id" class="form-control" value="${editer.id}" />
					</div>
					<div class="form-group">
						<label class="control-label">Matricule</label> 
						<input type="text" name="matricule" class="form-control" value="${editer.matricule}" />
					</div>
					<div class="form-group">
						<label class="control-label">Nom</label> 
						<input type="text" name="nom" class="form-control" value="${editer.nom}" />
					</div>
					<div class="form-group">
						<label class="control-label">Prenom</label> 
						<input type="text" name="prenom" class="form-control" value="${editer.prenom}" />
					</div>
					<div class="form-group">
						<label class="control-label">Telephone</label> 
						<input type="text" name="telephone" class="form-control" value="${editer.telephone}" />
					</div>
					<div class="form-group">
						<label class="control-label">Adresse</label> 
						<input type="text" name="adresse" class="form-control" value="${editer.adresse.id}" />
					</div>
					<p></p>
					<div>
						<button type="submit" class="btn btn-primary">Editer</button>
					</div>
				</form> 
			</div>
		</div>
	</div>
</body>
</html>