<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="${pageContext.request.contextPath}/ext/public/js/others/dashboardExpand.js" type="text/javascript"></script>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="cc" uri="aloc-color-calc" %>
<div class="innerDiv">

	<div id="report-details-container">
		<div id="report-details">
			<div id="report-details-inner">
				<div class="left-col-rdi">
				 	<c:choose>
		        		<c:when test="${instrumentTypeId eq '1' || instrumentTypeId eq '2'  || instrumentTypeId eq '4' || instrumentTypeId eq '5'}">
		        			<s:text name="label.dashboard.expandLabel.applicant"/>
		        		</c:when>
		        		<c:when test="${instrumentTypeId eq '3' || instrumentTypeId eq '6'}">
		        			<s:text name="label.dashboard.expandLabel.principal"/>
		        		</c:when>
        	        </c:choose>	 
				</div>
				<div class="right-col-rdi">
					<c:choose>
						<c:when test="${instrumentTypeId eq '1' || instrumentTypeId eq '2'  || instrumentTypeId eq '4' || instrumentTypeId eq '5'}">
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
								<c:otherwise>
								   -
								</c:otherwise>
							</c:choose>	
						</c:when>
						<c:when test="${instrumentTypeId eq '3' || instrumentTypeId eq '6'}">
							<c:choose>
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
						</c:when>
					</c:choose>
				</div>
				<div class="clear"></div>
			    
			    <c:choose>
        			<c:when test="${instrumentTypeId eq '1' || instrumentTypeId eq '2' || instrumentTypeId eq '4'||instrumentTypeId eq '5'}">
				    <c:if test="${not empty reqContactInfo.foreignExpDt}">
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.foreignExpirationDate"/></div>
						<div class="right-col-rdi"><s:property value="reqContactInfo.foreignExpDt"/></div>
						<div class="clear"></div>
					</c:if>
	
					<c:if test="${not empty reqContactInfo.USExpDt}">
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.USExpirationDate"/></div>
						<div class="right-col-rdi"><s:property value="reqContactInfo.USExpDt"/></div>
						<div class="clear"></div>
					</c:if>
					</c:when>
					<c:otherwise>
						<c:if test="${not empty reqContactInfo.expDt}">
							<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.expirationDate"/></div>
							<div class="right-col-rdi"><s:property value="reqContactInfo.expDt"/></div>
							<div class="clear"></div>
						</c:if>
					
						<c:if test="${not empty reqContactInfo.closureDate}"> 
							<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.closureDate"/></div>
							<div class="right-col-rdi"><s:property value="reqContactInfo.closureDate"/></div>
							<div class="clear"></div>
					    </c:if>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<div id="report-details">
			<div id="report-details-inner">
				<div class="left-col-rdi">
					 <c:choose>
		        		<c:when test="${instrumentTypeId eq '1' || instrumentTypeId eq '2'  || instrumentTypeId eq '4' || instrumentTypeId eq '5'}">
		        			<s:text name="label.dashboard.expandLabel.beneficiary"/>
		        		</c:when>
		        		<c:when test="${instrumentTypeId eq '3' || instrumentTypeId eq '6'}">
		        			<s:text name="label.dashboard.expandLabel.obligee"/>
		        		</c:when>
        	        </c:choose>	  
				</div>
				<div class="right-col-rdi">
					 <c:choose>
						<c:when test="${instrumentTypeId eq '1' || instrumentTypeId eq '2'  || instrumentTypeId eq '4' || instrumentTypeId eq '5'}">
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
								<c:otherwise>
								   -
								</c:otherwise>
							</c:choose>	
						</c:when>
						<c:when test="${instrumentTypeId eq '3' || instrumentTypeId eq '6'}">
							<c:choose>
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
						</c:when>
					</c:choose>
				</div>
				<div class="clear"></div>
				
				<c:if test="${instrumentTypeId eq '1' || instrumentTypeId eq '2' || instrumentTypeId eq '4'||instrumentTypeId eq '5'}">
					<c:if test="${not empty reqContactInfo.closureDate}"> 
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.closureDate"/></div>
						<div class="right-col-rdi"><s:property value="reqContactInfo.closureDate"/></div>
						<div class="clear"></div>
				    </c:if>
			    </c:if>
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
				
				<c:if test="${instrumentTypeId eq '1' || instrumentTypeId eq '2' || instrumentTypeId eq '4'||instrumentTypeId eq '5'}">
					<c:if test="${not empty reqContactInfo.closureDate}"> 
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.closureDate"/></div>
						<div class="right-col-rdi"><s:property value="reqContactInfo.closureDate"/></div>
						<div class="clear"></div>
				    </c:if>
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
</div>
            
 <div id="${cc:getSectionColor(param.rowIdValue)}">  
 <s:form name="bankHistoricalTransExpForm" id="bankHistoricalTransExpFormID" action="openRequest" namespace="/ext">                           
    <div class="innerBankBS">
	    <hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
	       	        <s:hidden name="requestId" value="%{requestId}" />
                	<s:hidden name="dashboardViewType" value="%{dashboardViewType}"/>
        			<s:hidden name="stage" value="%{stage}" />
        			<s:hidden name="wfid" value="%{wfid}" />
        			<s:hidden name="queueName" value="%{queueName}"/>
        			<s:hidden name="procedureName" value="%{procedureName}"/>
        			<s:hidden name="stageName" value="%{stageName}"/>
        			<s:hidden name="instrumentId" value="%{instrumentTypeId}"/>
        			<c:if test="${instrumentTypeId eq 5}">
                		<s:hidden name="amendmentId" value="%{amendmentId}"/>
                	</c:if>
                	<c:if test="${instrumentTypeId eq 6}">
                		<s:hidden name="amendmentId" value="%{riderId}"/>
                	</c:if>
               		<c:if test="${instrumentTypeId eq 1 or instrumentTypeId eq 2 or instrumentTypeId eq 3}">
               			<c:if test="${state eq 'OUTSTANDING'}">
                			<s:submit key="label.dashboard.expandLabel.closeRequest" action="openRequest" namespace="/ext" cssClass="expandRequestLink btn-secondary"/>
                		</c:if>
                	</c:if>
                <div class="clear"></div>
     </hwfs:checkComponentPermission> 
    </div>
 </s:form>
 </div>        