<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

	<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/common/issuance.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/js/requestor/issuance.js" type="text/javascript"></script>
	
		<div class="clear"></div>
			<c:if test="${not empty errorMsg}">
		 		<div class="row" id="errorMsg">
						<div class="span12">
							<div class="errorbox">
								<div class="errorHead">
									<p class="erroricon">Error</p>
								</div>
								<div class="errorContent">
									<p>
										<s:property value="errorMsg" />
									</p>
									<p>&nbsp;</p>
								</div>
							</div>
						</div>
					</div>	
			</c:if>
	    <s:hidden name="errorShow" id="errorShowId"/>
		<div class="row hide" id="issuerPageLevelErrorDivId">
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
 <s:hidden name="errorShow" id="errorShowId"/>	
				<div class="row hide" id="issuancePageLevelErrorDivId">
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
	<div class="clear"></div> 	
   
   <!-- Including Documentation.jsp  -->
   <s:form id="issuerSubmitForm" action="issuerSubmit" namespace="/int/approver" onsubmit="return validateIssuer();"> 
   <input type="hidden" name="actionType" id="actionTypeId">
   <input type="hidden" name="issuerRadioOption" id="issuerRadioOption">
   <div class="form-mod">
		<div class="row">	  
		   <div class="span12">
			   <jsp:include page="instrumentDocumentationReadOnly.jsp"/>
		  </div>
		</div>
   </div> 
   </s:form>
