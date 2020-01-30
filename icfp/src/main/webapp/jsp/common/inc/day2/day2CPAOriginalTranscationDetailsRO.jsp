<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>

	<c:set var="CPALegSummary" value="${deal:fetchLegSummary(1, pageContext.request)}" scope="page"/>
<div class="display-row">
			<h2 class="span12">Original Transaction Details</h2>
            <div class="clear"></div>
			<div class="row highlighted">
                <div class="span5">
                    <div class="form-row">
                        <p><b>Product Type</b></p>
                        <p>Cash Pool</p>
                    </div>
                </div> <!-- end of block -->
                
					  <div class="span5 right" id="vaultDivID">
						<div class="form-row">
						  <p>
			       				<c:if test="${param.page eq 'transactionCapture'}">
								<c:set var="vaultDet" value="${deal:getVaultID(pageContext.request)}" scope="page"/>
											<c:if test="${requestScope.details eq 'falseData'}">
									       		<span id="errorMessageID"  class="help-block invalid error">Participant and Pool Leader information entered does not match the Vault Request</span>
									       	</c:if>
									       	<span class="required">*</span>
											<b>Vault Request ID</b><br />
											<html:text property="vaultId" maxlength="50" tabindex="1" styleClass="span3" styleId="vaultTextID" value='${vaultDet}'  />
											<span class="req-error" style="display:none;" id="transactionCapturedVaultdIdBar" >error</span>
											<a href="#vaultRequestScreenID" id="valultReqIDLookupID"  class="initiate btn right cancel" style="float:right; margin-right: 75px;"> Lookup</a>
										
								</c:if>
								<c:if test="${param.page ne 'transactionCapture'}">
								<label>Vault Request ID</label>  
								   ${sessionScope.deal.vaultId}
							   </c:if>
						  </p>
						</div>
					 </div>
		 <!-- end of block -->
			</div>
            
		</div><!-- form mode ends here -->
        
