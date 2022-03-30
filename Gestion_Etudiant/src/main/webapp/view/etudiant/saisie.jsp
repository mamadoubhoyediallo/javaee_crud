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
			<div class="card-header">Ajouter un etudiant</div>
			<div class="card-body">
				<form action="<%=request.getContextPath()%>/SaisieEtudiantServlet" method="post">
					<div class="form-group">
						<label class="control-label">Matricule</label> 
						<input type="text" name="matricule" class="form-control" />
					</div>
					<div class="form-group">
						<label class="control-label">nom</label> 
						<input type="text" name="nom" class="form-control" />
					</div>
					<div class="form-group">
						<label class="control-label">Prenom</label> 
						<input type="text" name="prenom" class="form-control" />
					</div>
					<div class="form-group">
						<label class="control-label">Telephone</label> 
						<input type="text" name="telephone" class="form-control" />
					</div>
					<div class="form-group">
						<label class="control-label">Adresse</label> 
						<select name="adresse" class="form-control">
						<option value="">Veillez selectionez</option>
							<c:forEach items="${listea}" var="adresse">
								<option value="${adresse.id}">${adresse.ville}</option>
							</c:forEach>
						</select>
					</div>
					<p></p>
					<div>
						<button type="submit" class="btn btn-primary">Ajouter</button>
					</div>
				</form> 
			</div>
		</div>
	</div>
</body>
</html>