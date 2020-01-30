<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cc" uri="aloc-color-calc" %>
<script src="${pageContext.request.contextPath}/js/others/dashboardExpand.js" type="text/javascript"></script>

<s:iterator value="results.bundle.requestDetails"> 
<table style="margin-bottom:10px; width: 100%;">
     <tr class="${cc:getBundleAttributes(instrumentTypeId, transactionParties.instrumentPurposeId).rowInnerIdValue}">
            <td colspan="10" class="${cc:getBundleAttributes(instrumentTypeId, transactionParties.instrumentPurposeId).colorClassValue}">
<div class="innerDiv">
	<div id="report-details-container">
	    <h3><s:text name="label.dashboard.tableHeader.alocRecordNo"/>&nbsp;&nbsp;<s:property value="alocRecordId"/></h3>
		<div id="report-details">
			<div id="report-details-inner">
				<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.applicant"/></div>
				<div class="right-col-rdi">
					<c:choose>
                		<c:when test="${not empty applicantDetails.addressDtls.name}">
                			<s:property value="applicantDetails.addressDtls.name"/><br />
                			<s:property value="applicantDetails.addressDtls.address[0]"/><br />
                			<s:property value="applicantDetails.addressDtls.address[1]"/><br />
							<s:property value="applicantDetails.addressDtls.city"/><br />
							<s:property value="applicantDetails.addressDtls.stateProvince"/><br />
							<s:property value="applicantDetails.addressDtls.ZIPPostalCode"/><br />
							<s:property value="applicantDetails.addressDtls.country"/>
                		</c:when>
                		<c:when test="${not empty transactionParties.tpApplicantDetails.addressDtls.name}">
                			<s:property value="transactionParties.tpApplicantDetails.addressDtls.name"/>
                			<s:property value="transactionParties.tpApplicantDetails.addressDtls.address[0]"/><br />
                			<s:property value="transactionParties.tpApplicantDetails.addressDtls.address[1]"/><br />
							<s:property value="transactionParties.tpApplicantDetails.addressDtls.city"/><br />
							<s:property value="transactionParties.tpApplicantDetails.addressDtls.stateProvince"/><br />
							<s:property value="transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode"/><br />
							<s:property value="transactionParties.tpApplicantDetails.addressDtls.country"/>
                		</c:when>     					                 		           	
                		<c:otherwise>
                			-
                		</c:otherwise>
                	</c:choose>
				</div>
				<div class="clear"></div>

				<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.instrumentType"/></div>
				<div class="right-col-rdi">${not empty instrumentType ? instrumentType : '-'}</div>
				<div class="clear"></div>

				<div class="left-col-rdi"><s:text name="label.dashboard.bundle.bundlerName"/></div>
				<div class="right-col-rdi">
					<c:choose>
                		<c:when test="${not empty bundleDetails.bundleCreatorLastName or not empty bundleDetails.bundleCreatorFirstName}">
                			<div style="word-wrap: break-word; width: 140px;">
                				<s:property value="bundleDetails.bundleCreatorLastName"/>
                				<s:property value="bundleDetails.bundleCreatorFirstName"/>
                		    </div>
                		</c:when>
                		<c:otherwise>
                		    -
                		</c:otherwise>
                	</c:choose>
					
				</div>
				<div class="clear"></div>	
				
				<div class="left-col-rdi"><s:text name="label.dashboard.bundle.bundlerSSO"/></div>
				<div class="right-col-rdi">
					<c:choose>
                		<c:when test="${not empty bundleDetails.bundleCreator}">
                			<s:property value="bundleDetails.bundleCreator"/>
                		</c:when>
                		<c:otherwise>
                		    -
                		</c:otherwise>
                	</c:choose>	
				</div>
				<div class="clear"></div>
			</div>
		</div>

		<div id="report-details">
			<div id="report-details-inner">
				<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.beneficiary"/></div>
				<div class="right-col-rdi">
					<c:choose>
                		<c:when test="${not empty beneficiaryDetails.addressDtls.name}">
                			<s:property value="beneficiaryDetails.addressDtls.name"/><br />
							<s:property value="beneficiaryDetails.addressDtls.address[0]"/><br />
							<s:property value="beneficiaryDetails.addressDtls.address[1]"/><br />
							<s:property value="beneficiaryDetails.addressDtls.city"/><br />
							<s:property value="beneficiaryDetails.addressDtls.stateProvince"/><br />
							<s:property value="beneficiaryDetails.addressDtls.ZIPPostalCode"/><br />
							<s:property value="beneficiaryDetails.addressDtls.country"/>
                		</c:when>
                		<c:when test="${not empty transactionParties.customer.addressDtls.name}">
                			<s:property value="transactionParties.customer.addressDtls.name"/><br />
							<s:property value="transactionParties.customer.addressDtls.address[0]"/><br />
							<s:property value="transactionParties.customer.addressDtls.address[1]"/><br />
							<s:property value="transactionParties.customer.addressDtls.city"/><br />
							<s:property value="transactionParties.customer.addressDtls.stateProvince"/><br />
							<s:property value="transactionParties.customer.addressDtls.ZIPPostalCode"/><br />
							<s:property value="transactionParties.customer.addressDtls.country"/>
                		</c:when>                	
                		<c:otherwise>
                			-
                		</c:otherwise>
                	</c:choose>
				</div>
				<div class="clear"></div>

				<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.geReferenceNumber"/></div>
				<div class="right-col-rdi">
				<c:choose>
                   	<c:when test="${not empty transactionParties.tpApplicantDetails.refDetails[0].refValue}">
						<s:property value="transactionParties.tpApplicantDetails.refDetails[0].refValue"/>
					</c:when>					
					<c:when test="${not empty applicantDetails.refDetails[0].refValue}">
						<s:property value="applicantDetails.refDetails[0].refValue"/>
					</c:when>
					<c:otherwise>-</c:otherwise>
               	</c:choose></div>
				<div class="clear"></div>
			
				<div class="left-col-rdi"><s:text name="label.dashboard.bundle.requestorName"/></div>
				<div class="right-col-rdi">
					<c:choose>
                		<c:when test="${not empty requestorLName or not empty requestorFName}">
                			<div style="word-wrap: break-word; width: 140px;">
                				<s:property value="requestorLName"/>
                				<s:property value="requestorFName"/>
                		    </div>
                		</c:when>
                		<c:otherwise>
                		    -
                		</c:otherwise>
                	</c:choose>
				</div>
				<div class="clear"></div>	
				
				<div class="left-col-rdi"><s:text name="label.dashboard.bundle.requestorSSO"/></div>
				<div class="right-col-rdi">
					<c:choose>
                		<c:when test="${not empty requestorSSO}">
                			<s:property value="requestorSSO"/>
                		</c:when>
                		<c:otherwise>
                		    -
                		</c:otherwise>
                	</c:choose>	
				</div>
				<div class="clear"></div>
			</div>
		</div>

		<div id="report-details">
			<div id="report-details-inner">
			<c:if test="${not empty transactionParties.triPartyApplicant.name}">
				<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.triPartyApplicant"/></div>
				<div class="right-col-rdi">
				<c:choose>
              		<c:when test="${not empty transactionParties.triPartyApplicant.name}">
				        <s:property value="transactionParties.triPartyApplicant.name"/><br />
						<s:property value="transactionParties.triPartyApplicant.address[0]"/><br />
						<s:property value="transactionParties.triPartyApplicant.address[1]"/><br />
						<s:property value="transactionParties.triPartyApplicant.city"/><br />
						<s:property value="transactionParties.triPartyApplicant.stateProvince"/><br />
						<s:property value="transactionParties.triPartyApplicant.ZIPPostalCode"/><br />
						<s:property value="transactionParties.triPartyApplicant.country"/>
				   </c:when>
				<c:otherwise>-</c:otherwise>
               	</c:choose>
				</div>
				<div class="clear"></div>
			</c:if>

				<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.currency"/></div>
				<div class="right-col-rdi">
				<c:choose>
                	<c:when test="${not empty instrumentDetails.instrumentCurrencyId}">
               			<s:property value="instrumentDetails.instrumentCurrencyId"/>
                	</c:when>
                	<c:when test="${not empty transactionDetails.contranctCurId}">
               			<s:property value="transactionDetails.docLCCurId"/>
                	</c:when>
                	<c:otherwise>-</c:otherwise>
               	</c:choose></div>
				<div class="clear"></div>

				<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.amount"/></div>
				<div class="right-col-rdi"><c:choose>
                	<c:when test="${not empty instrumentDetails.instrumentAmt}">
               			<s:property value="instrumentDetails.instrumentAmt"/>
                	</c:when>
                	<c:when test="${not empty transactionDetails.docLCAmt}">
               			<s:property value="transactionDetails.docLCAmt"/>
                	</c:when>
                	<c:otherwise>-</c:otherwise>
               	</c:choose></div>
				<div class="clear"></div>
                
                <c:if test="${not empty instrumentDetails.expiryDt}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.expirationDate"/></div>
					<div class="right-col-rdi"><c:choose>
	                	<c:when test="${not empty instrumentDetails.expiryDt}">
	               			<s:date name="instrumentDetails.expiryDt" format="MM-dd-yyyy"/>
	                	</c:when>
	                	<c:otherwise>-</c:otherwise>
	               	</c:choose></div>
					<div class="clear"></div>
				</c:if>
				
			</div>
		</div>
		<div class="clear"></div>
	</div>
</div>
<div id="${cc:getBundleAttributes(instrumentTypeId, transactionParties.instrumentPurposeId).sectionColor}">
 	<div class="innerBS">
      	<div id="deleteRequestB">
          	<a href="#" class="btn-tertiary" data-toggle="modal" id="#removeBundle"											
				onclick="javascript:popUpRemoveRequestFromBundle(<s:property value="requestId"/>,<s:property value="bundleDetails.bundleId"/>,'<s:property value="alocRecordId"/>')">
				<s:text name="label.dashboard.bundle.removeBundle"/>																			
		    </a>
         </div>                                                            
        <div class="clear"></div> 
	</div>
</div>
<s:hidden id="beneficiaryName" name="beneficiaryName" value="%{beneficiaryName}" />
<s:hidden id="bundleId" name="bundleId" value="%{bundleId}" />   
<s:hidden id="bundleTransactionStateId" name="bundleTransactionState" value="%{bundleTransactionState}" />  
</td>     
</tr>
</table>
</s:iterator>
<div class="clear"></div>
<div style="height:10px;"></div>
<div class="clear">
	<c:if test="${bundleTransactionState eq 'DRAFT'}">	
	  	<a class="btn-secondary left" data-toggle="modal" id="#submitBundle"
			 href="#" onclick="javascript:popUpSubmitBundle(<s:property value="%{bundleId}"/>,'${beneficiaryName}')">
			 <s:text name="label.dashboard.bundle.submitBundle"/>
		</a>
	</c:if>
	<c:if test="${bundleTransactionState ne 'DRAFT'}">	 	
		<input type="submit" class="btn-secondary left" value="Submit Bundle" disabled="disabled"/>		 
	</c:if>
   	<a href="#" class="left btn-tertiary" style="margin-top:6px!important;" data-toggle="modal" id="#deleteEntireBundle"											
		onclick="javascript:popUpRemoveEntireBundle(<s:property value="%{bundleId}"/>)"><s:text name="label.dashboard.bundle.unbundleAllRequest"/> <span class="ttip info" data-original-title='<s:text name="label.request.tooltip.unBundleStatus"/>'></span></a>  
</div>

