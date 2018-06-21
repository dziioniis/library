<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<style>
   <%@include file='/jsp/css/request.css' %>
</style>
<html>
<head>
<title>Admin page</title>
</head>
<body>
<table>
<tr><td> <c:out value="${user.name}"/></td>
<form class="log_out" method="get" action="/servlet"/>
<input type="hidden" name="command" value="logout"/>
<td><input type="submit" value="logout"></td>
</form>
<form action="/servlet" method="POST">
<input type="hidden" name="command" value="goToAddBook"/>
<td><input type="submit" value="addBook"></td></tr>
</form>
</table>
<div class="requests">
<h1>requests</h1>
<c:if test="${requestlist.size() > 0}">
<form  method="POST" action="/servlet"/>
<jsp:useBean id="chboxiter" class="org.company.name.logic.ChboxIter"/>
<table>
 <tr>
 <c:forEach  items="${requestlist}" var="list">
 <td>
<jsp:setProperty name="chboxiter" property="firstIterator" value="${list.id}"/>
<jsp:setProperty name="chboxiter" property="secondIterator" value="${list.id}"/>
<jsp:setProperty name="chboxiter" property="thirdIterator" value="${list.id}"/>
<table>
<tr><td> название:<c:out value="${list.title}"/></td></tr>
<tr><td> читатель:<c:out value="${list.user}"/></td></tr>
<tr><td> статус:<c:out value="${list.status}"/></td></tr>
<c:if test="${list.status=='OPEN'}">
<tr><td>room <input type="radio"
                name="${chboxiter.checkboxNamee}"
                value="room"></td></tr>
    <td>subcription <input type="radio"
               name="${chboxiter.checkboxNamee}"
               value="subcription"></td></tr>
    <td>reject <input type="radio"
            name="${chboxiter.checkboxNamee}"
            value="reject"></td></tr>
            </table>
            </td>
            </c:if>
 </c:forEach>
 <input type="hidden" name="command" value="approve"/>
 <tr><td><input type="submit" value="approve"></td></tr>
 </c:if>
 </tr>
 </table>
 </div>
</form>
</body>
</html>