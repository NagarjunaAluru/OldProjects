<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
 <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><s:text name="label.dashboard.bundle.bundleTitle"/></title>
    
	<%@include file="../../common/includeCommonScripts.jsp"%>
	<script src="${pageContext.request.contextPath}/js/others/dashboards.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/css/common/dashboards.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div class="container main">
     <!-- HEADER SECTION START-->
		<jsp:include page="../../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
	 <!-- HEADER SECTION END-->	
		<s:url action="displayDraftDashboard.action" namespace="/int/dashboard"	var="draftsDashboardURL" >
			 <s:param name="dashboardViewType">DRAFTS</s:param>
		</s:url>
		<s:url action="displayBundleDashboard.action" namespace="/int/dashboard" var="bundleDashboardURL">
		 	<s:param name="dashboardViewType">BUNDLES</s:param>
		 </s:url>
					
   		<s:url action="createBundle"  namespace="/int/bundle"   var="createBundletURL" >
   			<s:param name="requestId"><s:property value="bundleRequestId"/></s:param>
   		</s:url>     
   		
 			<h1><s:text name="label.dashboard.bundle.createAddBundle"/></h1>
        	<p class="span12 left clear dashdesc"><s:text name="label.dashboard.bundle.createBundleDiscription"/></p>
			<c:if test="${empty bundleIDToRequestsMap}"> 
                <div id="siteMsg" class="clear"><s:text name="label.dashboard.bundle.createManageAddToBundleValidationMessage"/></div>
       		</c:if>
        	<a  href="<s:property value="#createBundletURL" />" class="btn-primary" class="left">       	
        	<s:text name="label.dashboard.bundle.createNewBundle"/> <span class="ttip info" data-original-title="<s:text  name="label.dashboard.tooltip.createNewBundle"/>"></span></a>
            <p>&nbsp;</p>     
                  
    	 <div>    	 
    	   <s:if test="%{bundleIDToRequestsMap == null || bundleIDToRequestsMap.isEmpty()}">
    	    <table class="table table-striped table-bordered paginate">    	                
	       	 <thead>
	                  <tr>
	                    <th><s:text name="label.dashboard.bundle.alocRecordNumber"/></th>
	                    <th><s:text name="label.dashboard.bundle.instrumentType"/></th>
	                     <th><s:text name="label.dashboard.bundle.currency"/></th> 	
	                    <th><s:text name="label.dashboard.bundle.amount"/></th>	                                       
	                    <th><s:text name="label.dashboard.bundle.applicantName"/></th>
	                    <th><s:text name="label.dashboard.bundle.beneficiaryName"/></th>
	                    <th><s:text name="label.dashboard.bundle.geReferenceNumber"/></th>
	                    <th><s:text name="label.dashboard.bundle.customerBeneficiaryReferenceNumber"/></th> 	                                                         
	                  </tr>
	                </thead>	       
	                <tbody>          
		        		<tr class="shown">
		       	 			<td colspan="8" style="text-align:center;color:blue; size:40px;"><s:text name="label.dashboard.bundle.display"/></td>
		    			</tr>
    			</tbody>
    			</table>
        	</s:if>
        	<s:else>                
	        <s:iterator value="bundleIDToRequestsMap" status="stat">	
	         <div id="bundleSubHeaderId">
	            <h2><s:text name="label.dashboard.bundle.bundleId"/> - <s:property value="key"/> -
	            <s:text name="label.dashboard.bundle.totalNunmberOfRequestsInBundle"/>  <s:property value="value.size"/>  
					<s:url action="createBundle"  namespace="/int/bundle"   var="addToBundleURL" >
						<s:param name="requestId"><s:property value="bundleRequestId"/></s:param>
					   	<s:param name="bundleId"><s:property value="key"/></s:param>
					</s:url> 															
					<a href="<s:property value="#addToBundleURL" />" class="btn"><s:text name="label.dashboard.bundle.addBundle"/></a>
				</h2><hr class="h2-hr">
            </div><br>     
	        <table class="table table-striped table-bordered paginate">    	                
	       	 <thead>
	                  <tr>
	                    <th><s:text name="label.dashboard.bundle.alocRecordNumber"/></th>
	                    <th><s:text name="label.dashboard.bundle.instrumentType"/></th>
	                     <th><s:text name="label.dashboard.bundle.currency"/></th> 	
	                    <th><s:text name="label.dashboard.bundle.amount"/></th>	                                       
	                    <th><s:text name="label.dashboard.bundle.applicantName"/></th>
	                    <th><s:text name="label.dashboard.bundle.beneficiaryName"/></th>
	                    <th><s:text name="label.dashboard.bundle.geReferenceNumber"/></th>
	                    <th><s:text name="label.dashboard.bundle.customerBeneficiaryReferenceNumber"/></th> 	                                                         
	                  </tr>
	                </thead>
	                
	         <tbody>                    
	              <s:iterator value="value"> 	            
	             	 <c:set var="rowIdValue" value=""></c:set>
				        	<c:choose>
					        	<c:when test="${instrumentTypeId eq '4'}">
					        		<c:set var="rowIdValue" value="docRow"></c:set>
					        	</c:when>
					        	<c:otherwise>
						        	<c:choose>
						        		<c:when test="${transactionParties.instrumentPurposeId eq '1'}">
						        			<c:set var="rowIdValue" value="bidsRow"></c:set>	
						        		</c:when>
						        		<c:when test="${transactionParties.instrumentPurposeId eq '12'}">
						        			<c:set var="rowIdValue" value="advanceRow"></c:set>
						        		</c:when>
						        		<c:when test="${transactionParties.instrumentPurposeId eq '13' or transactionParties.instrumentPurposeId eq '14' or transactionParties.instrumentPurposeId eq '16'}">
						        			<c:set var="rowIdValue" value="perforRow"></c:set>
						        		</c:when>
						        		<c:when test="${transactionParties.instrumentPurposeId eq '15'}">
						        			<c:set var="rowIdValue" value="financialRow"></c:set>
						        		</c:when>
						        	</c:choose>
					        	</c:otherwise>
				        	</c:choose>				          	
				        	
						<tr class="shown">							
							<td id="${rowIdValue}" width="15%"><s:property value="alocRecordId"/></td>		
							<td width="15%"><s:property value="instrumentType"/></td>
							<td width="10%">
							<c:choose>
			                		<c:when test="${not empty instrumentDetails.instrumentCurrencyId}">
			                			<s:property value="instrumentDetails.instrumentCurrencyId"/><br />
			                		</c:when>
			                		<c:when test="${not empty transactionDetails.docLCCurId}">
			                			<s:property value="transactionDetails.docLCCurId"/>
			                		</c:when>
			                		<c:otherwise>
			                			-
			                		</c:otherwise>
                			</c:choose>               									
							</td>	
							<td width="10%">
							<c:choose>
			                		<c:when test="${not empty instrumentDetails.instrumentAmt}">
			                			<s:property value="instrumentDetails.instrumentAmt"/><br />
			                		</c:when>
			                		<c:when test="${not empty transactionDetails.docLCAmt}">
			                			<s:property value="transactionDetails.docLCAmt"/>
			                		</c:when>
			                		<c:otherwise>
			                			-
			                		</c:otherwise>
                			</c:choose>						
							</td>																		
							<td width="15%">
								<c:choose>
			                		<c:when test="${not empty applicantDetails.addressDtls.name}">
			                			<s:property value="applicantDetails.addressDtls.name"/><br />
			                		</c:when>
			                		<c:when test="${not empty transactionParties.tpApplicantDetails.addressDtls.name}">
			                			<s:property value="transactionParties.tpApplicantDetails.addressDtls.name"/>
			                		</c:when>
			                		<c:otherwise>
			                			-
			                		</c:otherwise>
                			</c:choose>               								
						</td>
						<td width="15%">					
                			<c:choose>
		                		<c:when test="${not empty beneficiaryDetails.addressDtls.name}">
		                			<s:property value="beneficiaryDetails.addressDtls.name"/> 		                		
		                		</c:when>
		                		<c:when test="${not empty transactionParties.customer.addressDtls.name}">
		                			<s:property value="transactionParties.customer.addressDtls.name"/>
		                		</c:when>
		                		<c:otherwise>
		                			-
		                		</c:otherwise>
                			</c:choose>                	        						
						</td>
						<td width="10%">	
							<c:choose>
									<c:when test="${not empty applicantDetails.refDetails[0].refValue}">
			                			<s:property value="applicantDetails.refDetails[0].refValue"/><br />
			                		</c:when>
			                		<c:when test="${not empty transactionParties.tpApplicantDetails.refDetails[0].refValue}">
			                			<s:property value="transactionParties.tpApplicantDetails.refDetails[0].refValue"/>
			                		</c:when>
			                		<c:otherwise>
			                			-
			                		</c:otherwise>
                			</c:choose>  			                																					
						</td>
						<td width="10%">
							<c:choose>
									<c:when test="${not empty beneficiaryDetails.refDetails[0].refValue}">
			                			<s:property value="beneficiaryDetails.refDetails[0].refValue"/><br />
			                		</c:when>
			                		<c:when test="${not empty transactionParties.customer.refDetails[0].refValue}">
			                			<s:property value="transactionParties.customer.refDetails[0].refValue"/>
			                		</c:when>
			                		<c:otherwise>
			                			-
			                		</c:otherwise>
                			</c:choose> 						
						</td>																			
						</tr>		
					</s:iterator>
			</tbody>
		</table><br> 
		</s:iterator>   
		</s:else>      		    
	</div>        
            <p>&nbsp;</p>  
            <a href="<s:property value="#draftsDashboardURL" />" class="btn-tertiary left" style="margin-top:6px!important;">&lt;<s:text name="label.dashboard.bundle.bundlePrevious"/></a>           
            <a href="<s:property value="#bundleDashboardURL" />" class="btn"><s:text name="label.dashboard.bundle.bundleDashboard"/></a>            
            <p>&nbsp;</p><br>    
            	<div class="row">
			<!-- pagination pagination-right -->
					<div class="span right">
				       	<div class="pagenavi left">
				       		
				       	</div>
				    	<div class="span3 jump-page">
							Jump to
							<input type="text" class="span1 manual">
							<a class="btn btn-success-blue" type="submit">Go</a> 
						</div>
					</div>
				</div>
				<input type='hidden' id='current_page' />
		    <script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>    
  </div>
      <!-- FOOTER SECTION -->
       
       <%@include file="../../common/footerSection.jsp" %>
       </body>
       </html>