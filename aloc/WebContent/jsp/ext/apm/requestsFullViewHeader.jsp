<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<h1 class="page-title span12"><s:text name="label.request.requestFullView" /></h1>
		<p class="span12 left clear dashdesc"><s:text name="label.optionalSentence.apmRequestFullView" /></p>
		<hr class="page-title-hr">
		<div class="row">
			<div class="span12">
				<s:url action="searchFeeHistory.action" namespace="/ext/admin" var="returnToFeeHistoryURL" />
            	<a href="<s:property value="#returnToFeeHistoryURL" />" ><s:text name="label.request.returnFeeHistory"/></a>
			</div>
		</div>
	<div class="form-mod">
		<div class="row graybg lastrow" style="margin-left: -10px;">
			<div class="span12">
				<h2 class="summary span12"><s:text name="label.request.requestSummary" /></h2><hr class="h2-hr">
				<div class="clear"></div>
				<div class="row lastrow">
					<div class="span12 whitebg">
						<div class="span3" style="margin-left: 10px!important;">
							<div class="marginT">
								<s:label key="label.request.alocRecNo" />
								<p><s:property value="requestDetails.alocRecordId" /></p>
							</div>
						</div> 
						<div class="span3 left">
							<div class="marginT">
								<s:label key="label.request.instrumentCurrencyandAmount"/>
								<p><s:property value="requestDetails.instrumentDetails.instrumentCurrencyId" />&nbsp;<s:property value="requestDetails.instrumentDetails.instrumentAmt" /></p>
							</div>
						</div> 
						
						<div class="span2 left">
							<div class="marginT">
								<s:label key="label.request.ExpirationDate"/>
								<p><s:property value="requestDetails.instrumentDetails.expiryDt" /></p>
							</div>
						</div>
						<div class="span3 left">
							<div class="form-row">
								<div class="req-error" style="color:#555; text-indent:9px;">
									<s:label key="label.request.instrumentType"/>
									<p><s:property value="requestDetails.instrumentType" /></p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row graybg lastrow" style="margin-left: -10px;">
			<div class="span12">
				<h2 class="summary span12"><s:text name="label.request.winner"/> - <s:property value="requestDetails.winningBankDetails.winnerDetails.winningBankName" /></h2><hr class="h2-hr">
				<div class="clear"></div>
				<div class="row">
					<div class="span12 whitebg">
						<div class="span3" style="margin-left: 10px!important;">
							<div class="marginT">
								<s:label key="label.amendment.bankRefNo"/>
								<p>
									<s:if test="%{requestDetails.winningBankDetails.winnerDetails.bankReferenceNumber==null}">-</s:if>
									<s:else><s:property value="requestDetails.winningBankDetails.winnerDetails.bankReferenceNumber" /></s:else>
								</p>
							</div>
						</div> 
						<div class="span3 left">
							<div class="marginT">
								<s:label key="label.request.issuingBankBranch"/>
								<p>
									<s:if test="%{requestDetails.winningBankDetails.winnerDetails.issuingBankBranch==null}">-</s:if>
									<s:else><s:property value="requestDetails.winningBankDetails.winnerDetails.issuingBankBranch" /></s:else>
								</p>
							</div>
						</div> 
					</div>
				</div>
			</div>
		</div>
	</div><!-- end of form form-mod -->
