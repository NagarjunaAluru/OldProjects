<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

	<div id="mainPage" style="width: 100%;">
			
			<s:set name="isEditMode" value="editMode" />
			
			<!-- Including Expiration Dates -->
			<div class="form-mod">
				<div class="acc_container">
				<div class="row">
                    <div class="span6">
                    	<div class="form-row">
						<h2 id="expirationDates" class="acc acc_active">
							<a href="javascript:;">
								<s:text	name="label.request.bglocSectionName.14" />
							</a>
						</h2><hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/amendment/amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.expirationDates" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<div class="span5 left">
						<jsp:include page="/jsp/common/request/amendment/amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.expirationDates" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div>
				</div>
				</div>
			</div>
			
			<div class="clear"></div>
			
			<!-- Including Instrument Amount/Currency -->
			<div class="form-mod">
				<div class="acc_container">
				<div class="row">
                    <div class="span6">
                    	<div class="form-row">
						<h2 id="instrumentAmountCurrency" class="acc acc_active">
							<a href="javascript:;">
								Instrument Details
							</a>
						</h2><hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/amendment/amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.instrumentAmountCurrency" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<%-- <div class="span5 left">
						<jsp:include page="/jsp/common/request/amendment/amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.instrumentAmountCurrency" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div> --%>
				</div>
				</div>
			</div>
			
			<div class="clear"></div>
			
			<!-- Including Transaction Parties -->
			<div class="form-mod">
				<div class="acc_container">
				<h2 id="transactionParties" class="acc acc_active">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.1" />
					</a>
				</h2><hr class="h2-hr">
				<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
					<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag}">
					<div class="row">
	                    <div class="span6">	
	                    <div class="row smallrow">
							<div class="span2a">
								<h3 id="triPartyHeader" class="span12"><s:text name="label.request.triPartyApplicant" /></h3>
							</div>
						</div>
						<jsp:include page="/jsp/common/request/amendment/amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.tripartyAddress" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
						</div>
						<div class="span5 left">
							<jsp:include page="/jsp/common/request/amendment/amendmentTreasuryApprovalRequestSection.jsp">
								<jsp:param name="sectionId"	value="request.section.tripartyAddress" />
								<jsp:param name="includeScripts" value="false" />
								<jsp:param name="pageSection" value="Previous" />
							</jsp:include>
						</div>
					</div>
					</s:if>
				</c:if>
				<div class="row">
                    <div class="span6">	
                    	<div class="row smallrow">
							<div class="span2a">
							<h3 id="applicantHeader" class="span12"><s:text name="label.request.applicant"/></h3>
							</div>
						</div>
						<jsp:include page="/jsp/common/request/amendment/amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.tpapplicant" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<div class="span5 left">
						<jsp:include page="/jsp/common/request/amendment/amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.tpapplicant" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div>
				</div>
				<jsp:include page="/jsp/common/request/amendment/amendmentLEDetails.jsp">
					<jsp:param value="TreasuryApprover" name="pageType"/>
				</jsp:include>
				<jsp:include page="/jsp/common/request/amendment/amendmentGERefDetails.jsp">
					<jsp:param value="TreasuryApprover" name="pageType"/>
				</jsp:include>
				<div class="row">
                    <div class="span6">	
                    	<div class="row smallrow">
							<div class="span2a">
							<h3 id="customerHeader" class="span12"><s:text name="label.request.customer" /></h3>
							</div>
						</div>
						<jsp:include page="/jsp/common/request/amendment/amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.tpCustomerbeneficiary" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<div class="span5 left">
						<jsp:include page="/jsp/common/request/amendment/amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.tpCustomerbeneficiary" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div>
				</div>
				<jsp:include page="/jsp/common/request/amendment/amendmentCustBenRefDetails.jsp">
					<jsp:param value="TreasuryApprover" name="pageType"/>
				</jsp:include>
				</div>
			</div>
			<div class="clear"></div>
			
			<!-- Including Other Changes -->
			<div class="form-mod">
				<h2 id="otherChanges" class="section_flip">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.18" />
					</a>
				</h2><hr class="h2-hr">
				<div id="otherChangesPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/amendment/amendmentTreasuryApprovalRequestSection.jsp">
						<jsp:param name="sectionId"	value="request.section.otherChanges" />
						<jsp:param name="includeScripts" value="false" />
						<jsp:param name="pageSection" value="Current" />
					</jsp:include>
				</div>
			</div>
			<div class="clear"></div>
			
			<!-- Including Delivery Instruction -->
			<div class="form-mod">
		   		<h2 id="deliveryInstructions" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.8"/></a>
				</h2><hr class="h2-hr">
				<div id="deliveryInstructionsPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/amendment/amendmentTreasuryApprovalRequestSection.jsp">
						<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
						<jsp:param name="includeScripts" value="false" />
						<jsp:param name="pageSection" value="Current" />
					</jsp:include>
				</div>
		   	</div>
			<div class="clear"></div>
			
			<!-- Including Attachments   -->
			<div class="form-mod" id="attachmentsDiv">
				<h2 id="attachmentsFlip" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.9" /></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsFlipPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/amendment/amendmentTreasuryApprovalRequestSection.jsp">
						<jsp:param name="sectionId"	value="request.section.attachments" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
			<div class="clear"></div>
			
			<!-- Including Audit Log and Tranaction History   -->
			<div class="form-mod">
	    		<jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp"/>	            
   			</div>		
		<s:url action="cancelTaxonomy.action" namespace="/int" var="cancelBtnlURL"/>
		<div class="form-mod">
			<div class="row">
				<div class="span12">
					<nav> 
					    <ul>
					        <li class="last"><a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal">
					        	<s:text name="label.request.exitRequest" /></a></li>
					    </ul>
					</nav>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		</div>
		<div id="fullHistoryDiv" style="width: 100%;"></div>