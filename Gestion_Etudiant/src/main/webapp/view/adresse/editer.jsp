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
						<label class="control-label">Ville</label> 
						<input type="text" name="ville" class="form-control" value="${editer.ville}" />
					</div>
					<div class="form-group">
						<label class="control-label">Quartier</label> 
						<input type="text" name="quartier" class="form-control" value="${editer.quartier}" />
					</div>
					<div class="form-group">
						<label class="control-label">Rue</label> 
						<input type="text" name="rue" class="form-control" value="${editer.rue}" />
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