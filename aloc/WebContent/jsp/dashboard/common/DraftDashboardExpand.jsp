<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cc" uri="aloc-color-calc" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

<script src="${pageContext.request.contextPath}/js/others/dashboardExpand.js" type="text/javascript"></script>

<div class="innerDiv">

           <div id="report-details-container">
           <div id="report-details">
                <div id="report-details-inner">
                    <div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.applicantPrincipal"/></div>
                    <div class="right-col-rdi">
                    <c:choose>
					<c:when test="${not empty reqContactInfo.applicant.addressDtls.name}">
						${reqContactInfo.applicant.addressDtls.name} <br>
						${reqContactInfo.applicant.addressDtls.address[0]} <br>
						${reqContactInfo.applicant.addressDtls.address[1]} <br>
						${reqContactInfo.applicant.addressDtls.city} <br>
						${reqContactInfo.applicant.addressDtls.stateProvince} <br>
						${reqContactInfo.applicant.addressDtls.ZIPPostalCode} <br>
						${reqContactInfo.applicant.addressDtls.country} 
					</c:when>
					<c:when test="${not empty reqContactInfo.principal.addressDtls.name}">
						${reqContactInfo.principal.addressDtls.name} <br>
						${reqContactInfo.principal.addressDtls.address[0]} <br>
						${reqContactInfo.principal.addressDtls.address[1]} <br>
						${reqContactInfo.principal.addressDtls.city} <br>
						${reqContactInfo.principal.addressDtls.stateProvince} <br>
						${reqContactInfo.principal.addressDtls.ZIPPostalCode} <br>
						${reqContactInfo.principal.addressDtls.country} 
					</c:when>
					<c:otherwise>
						-
					</c:otherwise>
					</c:choose>
                    </div>
                    <div class="clear"></div>
                
                    <div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.expirationDate"/></div>
                    <div class="right-col-rdi">
                    <s:if test="reqContactInfo.expDt != null">
                    	<s:property value="reqContactInfo.expDt"/>
                    </s:if>
                    <s:else>-</s:else>
                    </div>
                    <div class="clear"></div>
                </div>
		</div>
        
		<div id="report-details">
            <div id="report-details-inner">
                <div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.beneficiaryObligee"/></div>
                <div class="right-col-rdi">
                   <c:choose>
					<c:when test="${not empty reqContactInfo.beneficiary.addressDtls.name}">
						${reqContactInfo.beneficiary.addressDtls.name} <br>
						${reqContactInfo.beneficiary.addressDtls.address[0]} <br>
						${reqContactInfo.beneficiary.addressDtls.address[1]} <br>
						${reqContactInfo.beneficiary.addressDtls.city} <br>
						${reqContactInfo.beneficiary.addressDtls.stateProvince} <br>
						${reqContactInfo.beneficiary.addressDtls.ZIPPostalCode} <br>
						${reqContactInfo.beneficiary.addressDtls.country} 
					</c:when>
					<c:when test="${not empty reqContactInfo.obligee.addressDtls.name}">
						${reqContactInfo.obligee.addressDtls.name} <br>
						${reqContactInfo.obligee.addressDtls.address[0]} <br>
						${reqContactInfo.obligee.addressDtls.address[1]} <br>
						${reqContactInfo.obligee.addressDtls.city} <br>
						${reqContactInfo.obligee.addressDtls.stateProvince} <br>
						${reqContactInfo.obligee.addressDtls.ZIPPostalCode} <br>
						${reqContactInfo.obligee.addressDtls.country} 
					</c:when>
					<c:otherwise>
						-
					</c:otherwise>
					</c:choose>
                </div>
                <div class="clear"></div>
                
                <div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.requestorName"/></div>
                <div class="right-col-rdi">
               		${reqContactInfo.lastName} ${reqContactInfo.firstName} 
					<br>SSO - ${reqContactInfo.userSso}
                </div>
                <div class="clear"></div>                
                
            </div>            
        </div>
        
        <div id="report-details">
            <div id="report-details-inner">
            <c:if test="${not empty reqContactInfo.triPartyApplicant.addressDtls.name}">
                <div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.triPartyApplicant"/></div>
                <div class="right-col-rdi">
                    ${reqContactInfo.triPartyApplicant.addressDtls.name} <br>
					${reqContactInfo.triPartyApplicant.addressDtls.address[0]} <br>
					${reqContactInfo.triPartyApplicant.addressDtls.address[1]} <br>
					${reqContactInfo.triPartyApplicant.addressDtls.city} <br>
					${reqContactInfo.triPartyApplicant.addressDtls.stateProvince} <br>
					${reqContactInfo.triPartyApplicant.addressDtls.ZIPPostalCode} <br>
					${reqContactInfo.triPartyApplicant.addressDtls.country}
                </div>
                <div class="clear"></div>
                </c:if>
                
                <c:if test="${instrumentTypeId eq '1' || instrumentTypeId eq '2' || instrumentTypeId eq '3'||instrumentTypeId eq '4'}">
					<c:if test="${not empty reqContactInfo.instrumentAmt}"> 
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.currentAmount"/></div>
						<div class="right-col-rdi"><s:property value="reqContactInfo.instrumentAmt"/></div>
						<div class="clear"></div>
				    </c:if>
				    <c:if test="${not empty reqContactInfo.USDEquivalent}"> 
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.currentUSDEquivalent"/></div>
						<div class="right-col-rdi"><s:property value="reqContactInfo.USDEquivalent"/></div>
						<div class="clear"></div>
				    </c:if>
			    </c:if>
			    
			    <c:if test="${instrumentTypeId eq '5'}">
			    	<c:if test="${not empty reqContactInfo.instrumentAmt}"> 
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.revisedAmendmentAmount"/></div>
						<div class="right-col-rdi"><br><s:property value="reqContactInfo.instrumentAmt"/></div>
						<div class="clear"></div>
				    </c:if>
				    <c:if test="${not empty reqContactInfo.USDEquivalent}"> 
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.revisedUSDEquivalent"/></div>
						<div class="right-col-rdi"><br><s:property value="reqContactInfo.USDEquivalent"/></div>
						<div class="clear"></div>
				    </c:if>
			    </c:if>
			    
			     <c:if test="${instrumentTypeId eq '6'}">
			    	<c:if test="${not empty reqContactInfo.instrumentAmt}"> 
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.revisedRiderAmount"/></div>
						<div class="right-col-rdi"><br><s:property value="reqContactInfo.instrumentAmt"/></div>
						<div class="clear"></div>
				    </c:if>
				    <c:if test="${not empty reqContactInfo.USDEquivalent}"> 
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.revisedUSDEquivalent"/></div>
						<div class="right-col-rdi"><br><s:property value="reqContactInfo.USDEquivalent"/></div>
						<div class="clear"></div>
				    </c:if>
			    </c:if>
			    
			      <c:if test="${not empty reqContactInfo.bankReference or not empty reqContactInfo.surityReference}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.bankSuretyReference"/></div>
					<div class="right-col-rdi"><br>
						<c:choose>
							<c:when test="${not empty reqContactInfo.bankReference}">
								${reqContactInfo.bankReference}
							</c:when>
							<c:when test="${not empty reqContactInfo.surityReference}">
								${reqContactInfo.surityReference}
							</c:when>
						</c:choose>
					</div>
				<div class="clear"></div>
				</c:if>

            </div>
        </div>
			
            <div class="clear"></div>
            </div>
         
            </div><!-- innerDiv ends here -->
 
             <div id="${cc:getSectionColor(param.rowIdValue)}">
            	<div class="innerBS">
            		<s:hidden cssClass ="bundleId" name="bundleId" value="%{reqContactInfo.bundleId}"> </s:hidden>
					<s:hidden cssClass ="requestId" name="requestId" value="%{reqContactInfo.alocRequestId}"> </s:hidden>
					<s:hidden cssClass ="stageNameId" name="stageName" value="%{stageName}"> </s:hidden>
					<s:hidden cssClass = "wfId" name="wfid" value="%{wfid}"> </s:hidden>
					<s:hidden cssClass = "queueNameId" name="queueName" value="%{queueName}"> </s:hidden>
					<s:hidden cssClass = "procedureNameId" name="procedureName" value="%{procedureName}"> </s:hidden>
					<s:hidden cssClass = "stageId" name="workFlowstageId" value="%{workFlowstageId}"> </s:hidden>
					<s:hidden name="alocRecordId" value="%{reqContactInfo.alocRecordId}" cssClass="alocRecordId"/>
					<s:hidden cssClass="amendmentId" name="amendmentId" value="%{amendmentId}" />
					<s:hidden cssClass="instrumentTypeId" name="instrumentTypeId" value="%{instrumentTypeId}"/>
            		<c:if test="${reqContactInfo.instrumentTypeId eq '1' || reqContactInfo.instrumentTypeId eq '2' || reqContactInfo.instrumentTypeId eq '4'}">
	                  
	                	<s:url action="loadBundleList" namespace="/int/bundle" var="loadBundleListURL">
	                    	<s:param name="requestId"><s:property value="reqContactInfo.alocRequestId" /></s:param>
	                    </s:url>   
	                       <c:if test="${reqContactInfo.bundleId==null && designatedForBundlingFlag eq 'Y'}"> 
		                      <div id="create">
				                    <a href="<s:property value="#loadBundleListURL"/>" id="createbundleLink"> <s:text  name="label.dashboard.bundle.createManageAddToBundle"/></a> 
				                        <span class="ttip info" data-original-title="<s:text name="label.dashboard.tooltip.createAddBundle"/>"></span>
				               </div>				                  
		                   </c:if>
		                   
		                   <c:if test="${reqContactInfo.bundleId !=null || designatedForBundlingFlag eq '' || designatedForBundlingFlag eq 'N'}"> 
		                   		<div id="blankBox">&nbsp;</div>
		                   </c:if>                         	                                                            
	                    </c:if>         
                   
                    <c:if test="${reqContactInfo.instrumentTypeId eq '3' || reqContactInfo.instrumentTypeId eq '5' || reqContactInfo.instrumentTypeId eq '6'}">
                   		 <div id="blankBox">&nbsp;</div>
                    </c:if>       
                	<div id="blankBox">&nbsp;</div>
                	<div id="blankBox">&nbsp;</div> 
                	
                <c:set var="isTreasury" value="N"/>
                <hwfs:checkComponentPermission name="TreasuryDashboardAccess" domainName="BusinessAccess">
                	<c:set var="isTreasury" value="Y"/>
	            	<div id="deleteRequestB">
		                    <a href="#" id="deleteRequestId" data-toggle="modal" class="deleteExpRequest"> 
					       		<s:text name="label.dashboard.link.deleteRequest"/>
					        </a>
	            		</div> 
	            </hwfs:checkComponentPermission>
	            <c:if test="${isTreasury =='N'}">
	                <hwfs:checkComponentPermission name="BusinessDashboardAccess" domainName="BusinessAccess"> 
		                <c:if test="${reqContactInfo.userSso eq reqContactInfo.msgHeader.auditCreator}">
		                	<div id="deleteRequestB">
			                    <a href="#" id="deleteRequestId" data-toggle="modal" class="deleteExpRequest"> 
						       		<s:text name="label.dashboard.link.deleteRequest"/>
						        </a>
		            		</div> 
		            	</c:if> 
		            </hwfs:checkComponentPermission>
	           </c:if>
                    
        <div class="clear"></div>
	</div>
</div><!-- blueSection ends here -->