<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Make a pet!</title>
<link rel="stylesheet" type="text/css" href="static/style/index.css">
</head>
<body>
	<div>
		<fieldset>
			<legend>Create a Dog</legend>
			<form action="animals/dogs" method="get">
				<p>
					Name:
					<input type="text" name="name">
				</p>
				<p>
					Breed:
					<input type="text" name="breed">
				</p>
				<p>
					Weight:
					<input type="number" name="weight">
				</p>
				<input type="submit" value="submit">
			</form>
		</fieldset>
		<fieldset>
			<legend>Create a Cat</legend>
			<form action="animals/cats" method="get">
				<p>
					Name:
					<input type="text" name="name">
				</p>
				<p>
					Breed:
					<input type="text" name="breed">
				</p>
				<p>
					Weight:
					<input type="number" name="weight">
				</p>
				<input type="submit" value="submit">
			</form>
		</fieldset>
	</div>
</body>
</html>