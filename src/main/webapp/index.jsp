<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <html>
<head>
<title>LIBRARY</title>
</head>

<style>
   <%@include file='jsp/css/log.css' %>
</style>

<div  class="login">
<h1>Login here</h1>
<c:choose>
                       <c:when test="${user.name =='admin'}">
                           <jsp:forward page="/jsp/admin.jsp"/>
                       </c:when>
                       <c:when test="${user.name != null}">
                          <jsp:forward page="/jsp/page/general.jsp"/>
                       </c:when>
                   </c:choose>
		<form action="servlet" method="POST">
		<table>
		<tr>
		<td>username</td>
		<td><input name="username" type="text" size="35"  /></td>
		</tr>
		<td>password</td>
		<td> <input name="password" type="password" size="35" /></td>
		</table>
					<input type="hidden" name="command" value="login">
					<input type="submit" name="submit" />
		</form>
		<form action="servlet" method="POST">
		<input type="hidden" name="command" value="goToRegister"/>
		<input type="submit"  value="registration" />
		</form>
		</div>
</body>
</html>
