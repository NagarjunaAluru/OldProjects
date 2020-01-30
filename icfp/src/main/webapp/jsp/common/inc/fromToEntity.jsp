<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="en-US"/>

<c:if test="${deal:isCPADeal(pageContext.request)}">

<div class="form-mod">
	<h3>Vault Request ID</h3>
	<div class="span12">
		<div class="form-row">
			<span  class="help-block notfound error" style="display:none;">
			 Invalid value
		    </span>			
		    <span class="req-error" style="display:none;">error</span>

		    <c:set var="vaultIDDetailsVal" value="${param.vaultIDDetails}"/>
		    <c:if test="${empty vaultIDDetailsVal}">		    	
		    	<c:set var="vaultIDDetailsVal" value="${sessionScope.deal.vaultId}"/>
			</c:if>
			<input type="text" name="vaultId1" class="span3"  onkeyup="javascript:validateVaultDetails()"  style="float:left;" id="vaultTextID"  maxlength="50" 
			value='${vaultIDDetailsVal}'>
			
			<c:if test="${fn:length(sessionScope.inputform.PEntities) gt 0}">
				<a href="#vaultRequestScreenID" id="tcvalultReqIDLookupID"  class="initiate btn right cancel" style="float:left;"> Lookup</a>
			</c:if>
		   <div class="clear">
		   </div>
		</div>
	</div>
</div>
</c:if>
<c:if test="${requestScope.errorVault}">
	<script type="text/javascript">
		$(function(){
			
			$("#vaultTextID").siblings(".req-error").show();
			$("#vaultTextID").siblings(".help-block").show();	
		})
	</script>
</c:if>

<c:forEach items="${sessionScope.inputform.PEntities}" var="item" varStatus="i">
	<jsp:include page="entityLookup.jsp">
		 <jsp:param value="${i.index}" name="entityName"/>
	</jsp:include>
	<c:set var="showSave" value="true" scope="request"/>
</c:forEach>
