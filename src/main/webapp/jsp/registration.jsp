<html>
<head>
<title>LIBRARY</title>
</head>
<style>
   <%@include file='/jsp/css/log.css' %>
</style>
<body>
<div class="login">
<h1>Registration</h1>
		<form class="registrartion" action="/servlet" method="get">
			<table>
				<tr>
					<td>E-mail:</td>
					<td><input name="email" type="email"
					size="35" required /></td>
				</tr>
				<tr>
					<td>password:</td>
					<td><input name="password" type="password" size="35"
						maxlength="35" required /></td>
				</tr>
				<tr>
					<td>confirm your password:</td>
					<td><input name="passwordConfirm" type="password" size="35"
						maxlength="35" required /></td>
				</tr>
				<tr>
					<td>username:</td>
					<td><input name="username"
					type="text" size="35" maxlength="35" required /></td>
				</tr>
			</table>

				    <input type="hidden" name="command" value="register"/>
					<<input type="submit" class="button-accept" name="create"
						value="submit" /></td>
		</form>
		<form name="logout" method="get" action="/servlet">
                                <input type="hidden" name="command" value="logout">
                                <input type="submit" value="logout">
	</div>
</body>
</html>