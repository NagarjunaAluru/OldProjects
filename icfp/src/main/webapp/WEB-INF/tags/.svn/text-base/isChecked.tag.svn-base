<%@attribute name="value" required="true" rtexprvalue="true" %>
<%@attribute name="label" required="true" rtexprvalue="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:choose>

<c:when test="${param.legType eq 'CPA' }">
 <c:set  var="legType" value="${sessionScope.curLeg.CPASummary.qualitativeFactors[0].assessment}"/>
</c:when>
<c:otherwise>
<c:set var="legType" value="${sessionScope.curLeg.legSummary.qualitativeFactors[0].assessment}"/>
</c:otherwise>

</c:choose>

	
<input type="radio" name="qAssessment" value="${value}" class="${ value ne '3' ? 'condition':'' }" ${legType eq value ? 'checked=checked' : '' } >
${label}
