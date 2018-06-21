<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/WEB-INF/jspf/left_menu.jspf" %>
<form method="get" action="servlet">
 <jsp:useBean id="chboxiter" class="org.company.name.logic.ChboxIter"/>
 <div class="requests">
 <h1>requests</h1>
 <table class="tableOfInform">
  <tr>
   <c:if test="${yourRequestList.size()>0}">
 <c:forEach  items="${yourRequestList}" var="list">
 <td>
 <jsp:setProperty name="chboxiter" property="firstIterator" value="${list.id}"/>
   <jsp:setProperty name="chboxiter" property="secondIterator" value="${list.id}"/>
<tr><td> название:<c:out value="${list.title}"/></td></tr>
<tr><td> ответ   :<c:out value="${list.status}"/></td></tr>
<tr><td> <input type="checkbox" name="${chboxiter.checkboxName}" value="$[chboxiter.checkboxValue}"/></td></tr>
</td>
 </c:forEach>
 </tr>
<input type="hidden" name="command" value="returnBook"/>
<tr><td><input type="submit" value="return"></tr></td>
</c:if>
</div>
</form>
