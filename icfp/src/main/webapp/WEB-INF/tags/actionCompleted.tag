<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@attribute name="stage" required="true" type="com.ge.icfp.pipeline.form.ChartInfo" %>
<t:common/>
<c:set var="statusInfo" value="${stage.statusInfo}"/>

<td class="${stage.status} popup">
<c:if test="${not empty stage.status and stage.status eq 'notapplicable'}">-</c:if>
<input type="hidden" name="dealSeq" value="${statusInfo.dealSeqId}"/>
<input type="hidden" name="stageId" value="${statusInfo.roleName}"/>
<input type="hidden" name="actionId" value="${statusInfo.status}"/>
</td>