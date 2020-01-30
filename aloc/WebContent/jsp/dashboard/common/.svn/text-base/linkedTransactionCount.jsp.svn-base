<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="cc" uri="aloc-color-calc" %>
<script src="${pageContext.request.contextPath}/js/others/dashboardExpand.js" type="text/javascript"></script>

<c:if test="${not empty reqContactInfo.linkedTransactions and reqContactInfo.linkedTransactions ne 0.0}">
	<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.linkedTransaction"/></div>
	<div class="right-col-rdi">				
		<s:if test="%{reqContactInfo.linkedTransactions eq '0.0'}">
			<fmt:formatNumber type="NUMBER" value="0" maxFractionDigits="0"/>
	    </s:if>
		<s:else>
			<a href="javascript:;" onclick="javascript:linkTransactionsPopUp(<s:property value="reqContactInfo.alocRequestId"/>)">
				<fmt:formatNumber type="NUMBER" value="${reqContactInfo.linkedTransactions}" maxFractionDigits="0"/> transactions
			</a>		
			<div id="ltPopBox<s:property value="reqContactInfo.alocRequestId" />" class="hide ltPopBox">
			              	
			</div>
		</s:else>					   	
	</div>				
	<div class="clear"></div>
</c:if>