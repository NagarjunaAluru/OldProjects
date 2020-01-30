<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="cc" uri="aloc-color-calc" %>
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

              	<c:if test="${not empty reqContactInfo.foreignExpDt}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.foreignExpirationDate"/></div>
					<div class="right-col-rdi">
						<c:choose>
							<c:when test="${not empty reqContactInfo.foreignExpDt}">
								<s:date name="reqContactInfo.foreignExpDt" format="dd MMM yyyy"/>
							</c:when>
							<c:otherwise>
								-
							</c:otherwise>
						</c:choose>
					</div>
				<div class="clear"></div>
				</c:if>

				<c:if test="${not empty reqContactInfo.USExpDt}">
				<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.USExpirationDate"/></div>
				<div class="right-col-rdi"><s:date name="reqContactInfo.USExpDt" format="dd MMM yyyy"/></div>
				<div class="clear"></div>
				</c:if>
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

				<c:if test="${not empty reqContactInfo.bundleId}">
				<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.bundleID"/></div>
				<div class="right-col-rdi"><fmt:formatNumber type="NUMBER" value="${reqContactInfo.bundleId}" maxFractionDigits="0"/></div>
				<div class="clear"></div>
				</c:if>
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
				<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.triPartyApplicant"/></div>
					<div class="right-col-rdi">
					<c:if test="${not empty reqContactInfo.triPartyApplicant.addressDtls.name}">
						${reqContactInfo.triPartyApplicant.addressDtls.name} <br>
						${reqContactInfo.triPartyApplicant.addressDtls.address[0]} <br>
						${reqContactInfo.triPartyApplicant.addressDtls.address[1]} <br>
						${reqContactInfo.triPartyApplicant.addressDtls.city} <br>
						${reqContactInfo.triPartyApplicant.addressDtls.stateProvince} <br>
						${reqContactInfo.triPartyApplicant.addressDtls.ZIPPostalCode} <br>
						${reqContactInfo.triPartyApplicant.addressDtls.country}
						
					</c:if>
					<c:if test="${empty reqContactInfo.triPartyApplicant.addressDtls.name}"> - </c:if>
					</div>
				<div class="clear"></div>

				<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.dateSubmitted"/></div>
				<div class="right-col-rdi">
					<c:choose>
						<c:when test="${not empty reqContactInfo.dateSubmitted}">
							<s:property value="reqContactInfo.dateSubmitted"/> 
						</c:when>
						<c:otherwise>
							-
						</c:otherwise>
					</c:choose>
				</div>
				<div class="clear"></div>
			    
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
			    
			    
			    
			    <c:if test="${not empty reqContactInfo.bundleId}"> 
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.bundleid"/></div>
						<div class="right-col-rdi"><s:property value="reqContactInfo.bundleId"/></div>
						<div class="clear"></div>
				    </c:if>
				   <c:if test="${reqContactInfo.bundleId==null}"> 
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.bundleid"/></div>
						<div class="right-col-rdi">-</div>
						<div class="clear"></div>
				    </c:if>
				    
				    <c:if test="${reqContactInfo.reqCount==null}"> 
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.bundlecount"/></div>
						<div class="right-col-rdi">-</div>
						<div class="clear"></div>
				    </c:if>
				    
				    <c:if test="${not empty reqContactInfo.reqCount}"> 
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.bundlecount"/></div>
						<div class="right-col-rdi"><fmt:formatNumber type="NUMBER" value="${reqContactInfo.reqCount}"  pattern="######"/></div>
						
						<div class="clear"></div>
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
				
				
				<div class="linkedTransactionNumber">
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
				</div>

			</div>
		</div>

		<div class="clear"></div>
	</div>
</div>
<div id="${cc:getSectionColor(param.rowIdValue)}">
	<div class="innerBS">
		<c:if test="${reqContactInfo.bundleId!=null}">
		<s:url action="manageBundle.action" namespace="/int/dashboard" var="manageBundleURL" encode="true" escapeAmp="false">
        	<s:param name="bundleId"><s:property value="reqContactInfo.bundleId" /></s:param>
        	<s:param name="expandBundle">Yes</s:param>
        </s:url>  	
			<div id="create">
			<a href="<s:property value="#manageBundleURL"/>" class="managebundleLink"> <s:text  name="label.dashboard.bundle.manageBundle"/></a>
				 <span class="ttip info" data-original-title="<s:text name="label.dashboard.tooltip.createAddBundle"/>"></span>
			</div>
		</c:if>
		<c:if test="${reqContactInfo.instrumentTypeId eq '1' or reqContactInfo.instrumentTypeId eq '2' or reqContactInfo.instrumentTypeId eq '3' or reqContactInfo.instrumentTypeId eq '4'}">
		<div class="linkDiv" id="linkto">
			
			<a href="javascript:;" class="linkto"><s:text name="label.dashboard.link.linkto"/></a> 
			<span class="ttip info" data-original-title="<s:text name="label.dashboard.tooltip.linkto"/>"></span>
			<div class="hide linkShow" >
				<div>
                <label><s:text name="label.dashboard.link.alocRecordNumber"/></label>
                <span class="alocRecordError" style="display: none;color: #990000;"><s:text name="label.dashboard.link.PleasEnterALOCRecordNumber"/></span>
                <div class="left">
                <s:textfield name="alocRecordNumber" id="recordNumber" cssClass="span23a"/>
                </div>
                <div class="left" style="margin-top: 5px;">
				<a data-toggle="modal" class="btn-primary btn_linkTo" style="color: #fff;" id="<s:property value="reqContactInfo.alocRequestId"/>" >
                <s:text name="label.dashboard.link.Link"/></a>
                </div>
                </div>
            </div>
		</div>
		
		<div id="closeRequest">
			<s:url action="cloneRequest.action" namespace="/int/requestor" var="cloneRequestURL" >
            	<s:param name="requestId"><s:property value="reqContactInfo.alocRequestId"/></s:param>
            </s:url>
			<a href="<s:property value="#cloneRequestURL" />"><s:text name="label.dashboard.link.clonethisRequest"/></a>
			<span class="ttip info" data-original-title="<s:text name="label.dashboard.tooltip.cloneRequest"/>"></span>
		</div>
		</c:if>
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
		<s:hidden cssClass="amdRiderExistId" name="amdRiderExist" value="%{reqContactInfo.amdRiderExist}"/>
		<s:hidden cssClass="paymentsPaidId" name="paymentsPaid" value="%{reqContactInfo.paymentsPaid}"/>
		<c:set var="isTreasury" value="N"/>
		<hwfs:checkComponentPermission name="TreasuryDashboardAccess" domainName="BusinessAccess">
			<c:set var="isTreasury" value="Y"/>
			<c:if test="${reqContactInfo.deleteAllow eq 'Y'}">
				<div id="deleteRequest">
					<a href="#" id="deleteRequestId" data-toggle="modal" class="deleteExpRequest">
				    	<s:text name="label.dashboard.link.deleteRequest"/>
				    </a>
				</div>
			</c:if>
	    </hwfs:checkComponentPermission>
		
		<c:if test="${isTreasury =='N'}">
			<hwfs:checkComponentPermission name="DeleteRequestAccess" domainName="BusinessAccess">
				<c:if test="${reqContactInfo.userSso eq reqContactInfo.msgHeader.auditCreator}">
					<c:if test="${workFlowstageId eq '0' or workFlowstageId eq '1' or workFlowstageId eq '2' or workFlowstageId eq '3' or workFlowstageId eq '17' or workFlowstageId eq '18'}">
						<c:if test="${reqContactInfo.deleteAllow eq 'Y'}">
							<div id="deleteRequest">
								<a href="#" id="deleteRequestId" data-toggle="modal" class="deleteExpRequest">
					            	<s:text name="label.dashboard.link.deleteRequest"/>
					            </a>
							</div>
						</c:if>
					</c:if>
				</c:if> 
			</hwfs:checkComponentPermission>
		</c:if>
	    		
		<div class="clear"></div>
	</div>
</div>