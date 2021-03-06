
<%@page import="org.company.name.entity.Book"%>
<%@page import="org.company.name.entity.Genre"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@include file="/WEB-INF/jspf/left_menu.jspf" %>

<div class="books">
<div class="info">
 <form name="orderer" method="get" action="/servlet">
 <jsp:useBean id="chboxiter" class="org.company.name.logic.ChboxIter"/>
 <table class="tableOfInform">
 <tr>
 <c:forEach items="${bookslist}" var="list">
 <jsp:setProperty name="chboxiter" property="firstIterator" value="${list.id}"/>
 <jsp:setProperty name="chboxiter" property="secondIterator" value="${list.id}"/>
 <td>
  <table>
  <img src="${list.urlImage}" height="250" width="190">
 <tr><td> название:<c:out value="${list.name}"/></tr></td>
 <tr><td> автор:<c:out value="${list.author}"/></tr></td>
 <tr><td> количество страниц:<c:out value="${list.pageCount}"/></tr></td>
 <tr><td> в наличии:<c:out value="${list.stock}"/>
 <c:if test="${list.stock>0}">
    <INPUT type="checkbox"  name="${chboxiter.checkboxName}" value="${chboxiter.checkboxValue}">
    </c:if>
 </tr></td>
     </table>
   </td>
   </div>
   </c:forEach>
   </tr>
<input type="hidden" name="command" value="order">
 <tr><td><input type="submit" value="order"> </tr></td>
   </table>
</form>
 </div>
