<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="leType" value="${sessionScope.inputform.PEntities[param.entityName].leTypeId}"/>

<c:choose>
	<c:when test="${leType eq 1}">Lender</c:when>
	<c:when test="${leType eq 2}">Borrower</c:when>
	<c:when test="${leType eq 3}">Guarantor</c:when>
	<c:when test="${leType eq 4}">Assigner</c:when>
	<c:when test="${leType eq 5}">Assignee</c:when>
	<c:when test="${leType eq 6}">Payer</c:when>
	<c:when test="${leType eq 7}">Participant</c:when>
	<c:when test="${leType eq 8}">Pool Leader</c:when>	
	<c:when test="${leType eq 9}">Provider</c:when>	
	<c:when test="${leType eq 10}">Recipient</c:when>
	<c:when test="${leType eq 11}">Payee</c:when>	
	<c:when test="${leType eq 12}">New Lender</c:when>	
	<c:when test="${leType eq 13}">New Borrower</c:when>	
	<c:when test="${leType eq 14}">Issuer</c:when>	
	<c:when test="${leType eq 15}">Purchaser</c:when>	
	<c:when test="${leType eq 16}">New Issuer</c:when>	
	<c:when test="${leType eq 17}">New Purchaser</c:when>	
</c:choose>