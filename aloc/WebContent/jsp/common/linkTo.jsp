<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
 <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><s:text name="label.linkTo"/></title>
    
	<%@include file="../common/includeCommonScripts.jsp"%>
	<script src="${pageContext.request.contextPath}/js/others/dashboards.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/css/common/dashboards.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
</head>
  <body>
	<div class="container main">
     <jsp:include page="../common/headerSection.jsp">
		<jsp:param name="createReqPopup" value="Yes"></jsp:param>
	</jsp:include>		
        <h1><s:text name="label.linkTo"/></h1>
        <p class="span12 left clear dashdesc"><s:text name="label.linkingTransaction"/></p>
	        <div class="row">
	            <div class="span12">
	                <div class="form-row" style="text-align:right;">
	                    <s:textfield onblur="this.value=(this.value=='') ? 'Search...' : this.value;" onfocus="this.value=(this.value=='Search...') ? '' : this.value;" value="Search...">
	                    </s:textfield>
	                                       
	                    <s:select theme="aloc"
							name="selectedValue"
							list="%{#attr['com.ge.aloc.StaticDataFactory'].linkSearchList}"
							headerKey="" headerValue="Select..." listKey="ID" listValue="name"
							id="linkTransId" 
							 />
	                    <a class="btn-secondary lookup conditional-btn" type="submit" style="margin-left:10px;"><s:text name="label.linkTo.search"/></a>
	                    &nbsp;<a href="#"><s:text name="label.linkTo.advancedSearch"/></a>
	                </div>
	            </div>
	
	        </div>             
        <c:if test="${not empty requestDetails.comments}" >
               <h5 style=color:green;><s:property value="requestDetails.comments" /></h5>	
         </c:if>		
        <div><s:text name="label.linkTo.placeFilteringHere"/></div>                    	
            <p>&nbsp;</p>
			<table id="tableeLinks" class="table table-striped table-bordered paginate">             
             <colgroup width="110"></colgroup>           
                <thead>
                  <tr>                                      
                   <th><s:label key="label.linkTo.action" cssStyle="color:#FFFFFF;"/></th>
                   <th><s:label key="label.linkTo.alocRecordNumber" cssStyle="color:#FFFFFF;"/></th>
                    <th><s:label key="label.linkTo.bankReferenceNumber" cssStyle="color:#FFFFFF;"/></th>
                    <th><s:label key="label.linkTo.linkId" cssStyle="color:#FFFFFF;"/></th>
                    <th><s:label key="label.linkTo.applicantPrincipal" cssStyle="color:#FFFFFF;"/></th>
                    <th><s:label key="label.linkTo.beneficiaryObligee" cssStyle="color:#FFFFFF;"/></th>
                    <th><s:label key="label.linkTo.instrumentAmount" cssStyle="color:#FFFFFF;"/></th>
                    <th><s:label key="label.linkTo.currency" cssStyle="color:#FFFFFF;"/></th> 
                    <th><s:label key="label.linkTo.expirationDate" cssStyle="color:#FFFFFF;"/></th>                                              
                  </tr>
                </thead>
                <tbody>
                <s:iterator value="requestDetailsList" status="stat">                    	                              
	             <tr class="shown">
                    	<td>
	                    	<c:choose>
		                    	<c:when test="${linkDetails.linkId==null}">
		                    	 <s:url action="linkTransaction.action" namespace="/int/linkto" var="linkTransactionURL"  escapeAmp="false">
	                    	 		<s:param name="requestId"><s:property value="linkRequestId"/></s:param>
	                    	 		<s:param name="requestId1"><s:property value="requestId"/></s:param>  
	                    	 		<s:param name="dashboardViewType"><s:property value="dashboardViewType"/></s:param>                 
	                    		 </s:url>	
	                    		 <s:if test="%{linkRequestId != requestId}">
		                    		<a href="<s:property value="#linkTransactionURL" />">&lt;<s:text name="label.link"/>&gt;</a>  | &lt;<s:text name="label.unlink"/>&gt;
		           				</s:if>
		           				<s:else>
		           					&lt;<s:text name="label.link"/>&gt;  | &lt;<s:text name="label.unlink"/>&gt;
		           				</s:else>                   		                    			
	                    		</c:when>
		                        <c:otherwise>
									<s:url action="unLinkTransaction.action" namespace="/int/linkto" var="unlinkTransactionURL" escapeAmp="false">
                    					<s:param name="linkId"><s:property value="linkDetails.linkId" /></s:param>
                    					<s:param name="requestId"><s:property value="requestId"/></s:param>
	                    			</s:url>	 		                        
	                    	  		 &lt;<s:text name="label.link"/>&gt; |  <a href="<s:property value="#unlinkTransactionURL" />">&lt;<s:text name="label.unlink"/>&gt;</a>
	                    	 	 </c:otherwise>
	                        </c:choose>   
                    	  </td>                    	  
                        <td><s:property value="requestId"/></td>
                        <td><s:property value="lastName"/></td>
                        <td><s:property value="linkDetails.linkId"/></td>
                        <td><s:property value="applicantDetails.addressDtls.address"/>
                        <s:property value="applicantDetails.addressDtls.city"/>
                        <s:property value="applicantDetails.addressDtls.zipPostalCode"/>
						</td>
                        <td><s:property value="beneficiaryDetails.addressDtls.address"/>
                        <s:property value="beneficiaryDetails.addressDtls.city"/>
                        <s:property value="beneficiaryDetails.addressDtls.zipPostalCode"/>
						</td>
                        <td><s:property value="instrumentDetails.instrumentAmt"/></td>
                        <td><s:property value="instrumentDetails.instrCurrency"/></td>
                        <td><s:property value="instrumentDetails.expiryDt"/></td>
                    </tr>
                    </s:iterator>                                                                                          
                </tbody>
              </table>	
   </div>
  <div class="clear"></div>
  <div style="height:50px;"></div>
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
    
	<%@include  file="../common/footerSection.jsp" %>
</body>
</html>