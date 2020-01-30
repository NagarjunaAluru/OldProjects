<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<link href="${pageContext.request.contextPath}/ext/public/css/others/closure.css" type="text/css" rel="stylesheet" />  

		<s:hidden name="errorShow" id="closureErrorShowId"/>
		<div class="row hide" id="closurePageLevelErrorDivId">
			<div class="span12">
				<div class="errorbox">
					<div class="errorHead">
						<p class="erroricon">Error</p>
					</div>
					<div class="errorContent">
						<p>
							<s:fielderror/>
						</p>
						<p>&nbsp;</p>
					</div>
				</div>
			</div>
		</div>					 
		<!-- Including applicant/principal details -->
		<div class="form-mod">
				<jsp:include page="/jsp/requestor/treasury/applicantAddress.jsp" />
		</div>
	    <div class="clear"></div>
	    
    	<!-- Including obligee/beneficiary Details -->
		<div class="form-mod">
				<jsp:include page="/jsp/requestor/treasury/beneficiaryAddress.jsp" />
		</div>
	    <div class="clear"></div>
	    
	   <div class="form-mod"> 
	   <br/>
	     <!-- Including expiration dates   -->
			<h2 class="acc_triggerExtra"><s:text name="label.request.closureDate" /></h2><hr class="h2-hr">
			<br/>
			<div class="acc_containerExtra">
	            <div class="row">
	                <div class="span3b">
	                	<div class="form-row">
	                    <label><s:text name="label.request.currentExpirationDate"/>:</label>
	                    </div>
	                </div>
	                <div class="span5 left">
	                	<div class="form-row">
	                      <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2'}">	
							     <s:if test="%{requestDetails.issuingBankDetails.USExpirationDate != null}">
							     	<s:property value="requestDetails.issuingBankDetails.USExpirationDate"/>
							     </s:if>
							     <s:elseif test="%{requestDetails.instrumentDetails.econoExpiryDt != null}">
							     	<s:property value="requestDetails.instrumentDetails.econoExpiryDt"/>
							     </s:elseif>
							     <s:else>
							     	<s:property value="requestDetails.instrumentDetails.expiryDt"/>
							     </s:else>
						 </c:if>
						  <c:if test="${requestDetails.instrumentTypeId eq '5'}">	
							     <s:property value="requestDetails.amendment.expiryDate.revisedExpiryDate"/>
						 </c:if>
	                     <c:if test="${requestDetails.instrumentTypeId eq '3' || requestDetails.instrumentTypeId eq '6'}"> 
							   <s:property value="requestDetails.bondInfo.expirationDt"/>
						 </c:if>
						</div>
	                </div>
	            </div><!-- row ends here -->
	            
	            <div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text name="label.request.issuanceDate" />:</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							    <s:property value="requestDetails.issuanceDate"/>
						</div>
					</div>
          		</div>
	
	            <div class="row">
	            	 <div class="span3 left">
	            	 	 <label><s:text name="label.request.closureFielddate"/>:</label>
	            	 </div>
	            	 <div class="span5 left">
	            	 	 <p class="padding40">  
	            	 	 	<s:property value="requestDetails.newExpDate"/>  </p> 
	            	 </div>
	            	 
	            </div><!-- row ends here -->
			</div>
	
	    </div>	 
		<!-- Including Attachments   -->
		<div class="form-mod">	
                 	<div id="attachmnetRefresh">
                     <jsp:include page="/jsp/ext/request/taxonomy/closureAttachmentsReadOnly.jsp"/>
				</div>
	</div>
		<div class="clear"></div>
	<div class="form-mod"> 
		<!-- Including comments -->
		<h2 class="acc_triggerExtra"><s:text name="label.request.comments" /></h2><hr class="h2-hr">
		 <br/>
			<div class="acc_containerExtra">
				<div class="row">
					 <div class="span3 left">
	            	 	 <label><s:text name="Notes"/>:</label>
	            	 </div>
	            	 <div class="span5 left">
	            	 	 <p class="padding40">  
	            	 	 	<s:property value="requestDetails.closerNotes"/>  </p> 
	            	 </div>
			</div>	
		</div>
   </div>
