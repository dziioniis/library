<html>
<head>
<title>addBook</title>
</head>
<style>
   <%@include file='/jsp/css/log.css' %>
</style>
<body>
<div class="login">
<h1>AddBook</h1>
<form action="/servlet" method="POST" enctype="multipart/form-data" >
			<table>
				<tr>
					<td>title:</td>
					<td><input name="title" type="text" /></td>
				</tr>
				<tr>
					<td>genre:</td>
					<td><input name="genre" type="text"  /></td>
				</tr>
				<tr>
					<td>author:</td>
					<td><input name="author" type="text" /></td>
				</tr>
				<tr>
                					<td>pageCount:</td>
                					<td><input name="pageCount" type="text" /></td>
                				</tr>
				<tr>
                					<td>stock:</td>
                					<td><input name="stock" type="text"  /></td>
                				</tr>
               	<tr>
                                     <td>data:</td>
                                     <td><input name="data" type="text"  /></td>
                                </tr>
<<input type="hidden" name="command" value="addBook" />
<tr><td>photo:</td><td><input type="file" name="file"/></td></tr>
<td><input type="submit" value="addBook"></td></tr>
</table>
</form>
</div>
</body>
</html>
