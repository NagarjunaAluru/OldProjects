<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.google.gson.Gson" %>
<%@ page errorPage="error.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>

<label>Results: ${fn:length( requestScope.results ) }</label>

<div style="height:350px; overflow:auto">
<table class="table table-striped table-bordered">
<thead>
<tr><th></th>
<th>Legal Entity name</th>
<th>CDR code</th>
<th>Legal Entity GOLD ID</th>
<th>Country</th>
<th>Capital or Industrial</th>
</tr>
</thead>
<tbody>
<c:forEach var="i" items="${requestScope.results}">
<tr>
<td><input type="radio" class="selectEntity" value='<%=new Gson().toJson( pageContext.getAttribute("i") )%>'/></td>
<td>${i.LEName}</td>
<td>${i.CDRCd}</td>
<td>${i.LEGoldId}</td>
<td>${i.country}</td>
<td>${i.capitalIndustrial}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>