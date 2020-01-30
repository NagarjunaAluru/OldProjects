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
					  	<a data-toggle="modal" href="#" onclick="javascript:linkTransactionsPopUp(<s:property value="reqContactInfo.alocRequestId"/>)">
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

<c:if test="${workFlowstageId eq '10' or workFlowstageId eq '14' or workFlowstageId eq '15'}">
	<s:set var = "isTreasuryUser" value = "%{false}" />
	<hwfs:checkComponentPermission name="TreasuryDashboardAccess" domainName="BusinessAccess">
	        	<s:set var = "isTreasuryUser" value = "%{true}" />
    </hwfs:checkComponentPermission>
	<c:choose>
		<c:when test="${instrumentTypeId eq '1' || instrumentTypeId eq '2'}">
		<div class="right"><s:text name="label.dashboard.bidProcess.approximate"/></div>
		<table class="table table-striped table-bordered">
	    	<thead>
	     	   <tr>
	              <th class="bgtr" width="30%"><s:text name="label.dashboard.tableHeader.relBankAndissBank"/></th>
	              <th class="bgtr"><s:text name="label.dashboard.tableHeader.usLifetimeFees"/></th>
	              <th class="bgtr"><s:text name="label.dashboard.tableHeader.foreignLifetimeFees"/></th>
	              <th class="bgtr"><s:text name="label.dashboard.tableHeader.amendmentFees"/></th> 
	              <th class="bgtr"><s:text name="label.dashboard.tableHeader.otherFees"/></th>
	              <th class="bgtr"><s:text name="label.dashboard.tableHeader.bidExpirationDate"/></th>
	           </tr>
	        </thead>
	        <tbody>
	        	<s:if test="%{reqContactInfo.bidDetails == null || reqContactInfo.bidDetails.isEmpty()}">
	        		<tr class="shown odd">
	       	 			<td colspan="12" style="text-align:center;color:blue; size:40px;"><s:text name="label.dashboard.bundle.display"/></td>
	    			</tr>
	        	</s:if>
	        	<s:else>
	        	<s:if test = "#isTreasuryUser">
	        	<s:iterator value="reqContactInfo.bidDetails" status="stat">
		              <tr style="display: table-row;" class="odd">
		              <td>
		              	<c:if test="${bidAction eq 'Winner' or bidAction eq 'WINNER'}">
		              	<div class="left-col-rdi1">
		                	<c:if test="${not empty issuingBankName}">
		                	<b><c:out value="${issuingBankName}"/></b></c:if>
		                	<c:if test="${empty issuingBankName}"> - </c:if>
		                </div>
		                <b>and</b>
		                <div class="right-col-rdi1">
		                	<c:if test="${not empty bankName}">
		                		<b><c:out value="${bankName}"/> - <c:out value="${bidAction}"/></b><br>
								<s:iterator var="addressDtlsItr" value="addressDtls.address">
									<c:if test="${addressDtlsItr != null && addressDtlsItr != ''}">
										<s:property value="addressDtlsItr" /><br />
									</c:if>
                                </s:iterator>
                                <c:if test="${addressDtls.city != null && addressDtls.city != ''}"><s:property value="addressDtls.city"/><br></c:if>
                                <c:if test="${addressDtls.stateProvince != null && addressDtls.stateProvince != ''}"><s:property value="addressDtls.stateProvince"/><br></c:if>
                                <c:if test="${addressDtls.ZIPPostalCode != null && addressDtls.ZIPPostalCode != ''}"> <s:property value="addressDtls.ZIPPostalCode"/><br /></c:if>
                                <c:if test="${addressDtls.country != null && addressDtls.country != ''}"><s:property value="addressDtls.country"/></c:if>
		                	</c:if>
		                	<c:if test="${empty bankName}"> - </c:if>
		                </div>
		                </c:if>
		                <c:if test="${bidAction ne 'Winner' or empty bidAction}">
		                	<%-- <c:if test="${not empty issuingBankName}"><c:out value="${issuingBankName}"/></c:if> <c:if test="${empty issuingBankName}"> - </c:if> --%>
		                	<div class="left-col-rdi1">
		                	<c:if test="${not empty issuingBankName}">
		                	<c:out value="${issuingBankName}"/></c:if>
		                	<c:if test="${empty issuingBankName}"> - </c:if>
		                </div>
		                <c:if test="${not empty bankName}">
		                and
		                <div class="right-col-rdi1">
		                	<c:if test="${not empty bankName}">
		                		<c:out value="${bankName}"/><br>
								<s:iterator var="addressDtlsItr" value="addressDtls.address">
									<c:if test="${addressDtlsItr != null && addressDtlsItr != ''}">
										<s:property value="addressDtlsItr" /><br />
									</c:if>
                                </s:iterator>
                                <c:if test="${addressDtls.city != null && addressDtls.city != ''}"><s:property value="addressDtls.city"/><br></c:if>
                                <c:if test="${addressDtls.stateProvince != null && addressDtls.stateProvince != ''}"><s:property value="addressDtls.stateProvince"/><br></c:if>
                                <c:if test="${addressDtls.ZIPPostalCode != null && addressDtls.ZIPPostalCode != ''}"> <s:property value="addressDtls.ZIPPostalCode"/><br /></c:if>
                                <c:if test="${addressDtls.country != null && addressDtls.country != ''}"><s:property value="addressDtls.country"/></c:if>
		                	</c:if>
		                	<c:if test="${empty bankName}"> - </c:if>
		                </div>
		                </c:if>
		                </c:if>
		              </td>
		              <td><c:if test="${empty apprxUSLifetimeFees}">-</c:if><c:if test="${not empty apprxUSLifetimeFees}"><s:property value="apprxUSLifetimeFees"/></c:if></td>
		              <td><c:if test="${empty apprxForeignLifetimeFees}">-</c:if><c:if test="${not empty apprxForeignLifetimeFees}"><s:property value="apprxForeignLifetimeFees"/></c:if></td>
		              <td><c:if test="${empty apprxAmendmentFees}">-</c:if><c:if test="${not empty apprxAmendmentFees}"><s:property value="apprxAmendmentFees"/></c:if></td>
		              <td><c:if test="${empty apprxOtherFees}">-</c:if><c:if test="${not empty apprxOtherFees}"><s:property value="apprxOtherFees"/></c:if></td>
		              <td style="width: 75px;"><c:if test="${empty bidExpDt}">-</c:if><c:if test="${not empty bidExpDt}"><s:date name="bidExpDt" format="dd MMM yyyy HH:mm aa zzz"/></c:if></td>
		              </tr>
	              </s:iterator>
	              </s:if>
	              <s:else>
	              <s:iterator value="reqContactInfo.bidDetails" status="stat">
	              	<c:if test="${bidAction eq 'Winner' or bidAction eq 'WINNER'}">
		              <tr style="display: table-row;" class="odd">
		              <td>
		              <div class="left-col-rdi1">
		              	<c:if test="${not empty issuingBankName}"><b><c:out value="${issuingBankName}"/></b></c:if>
		              	<c:if test="${empty issuingBankName}"> - </c:if>
		              </div> <b>and</b>
		              <div class="right-col-rdi1">
		                <c:if test="${not empty bankName}"><b><c:out value="${bankName}"/> - <c:out value="${bidAction}"/></b><br>
								<s:iterator var="addressDtlsItr" value="addressDtls.address">
									<c:if test="${addressDtlsItr != null && addressDtlsItr != ''}">
										<s:property value="addressDtlsItr" /><br />
									</c:if>
                                </s:iterator>
                                <c:if test="${addressDtls.city != null && addressDtls.city != ''}"><s:property value="addressDtls.city"/><br></c:if>
                                <c:if test="${addressDtls.stateProvince != null && addressDtls.stateProvince != ''}"><s:property value="addressDtls.stateProvince"/><br></c:if>
                                <c:if test="${addressDtls.ZIPPostalCode != null && addressDtls.ZIPPostalCode != ''}"> <s:property value="addressDtls.ZIPPostalCode"/><br /></c:if>
                                <c:if test="${addressDtls.country != null && addressDtls.country != ''}"><s:property value="addressDtls.country"/></c:if>
		                </c:if> 
		                <c:if test="${empty bankName}"> - </c:if>
		              </div>
		               </td>
		              <td><c:if test="${empty apprxUSLifetimeFees}">-</c:if><c:if test="${not empty apprxUSLifetimeFees}"><s:property value="apprxUSLifetimeFees"/></c:if></td>
		              <td><c:if test="${empty apprxForeignLifetimeFees}">-</c:if><c:if test="${not empty apprxForeignLifetimeFees}"><s:property value="apprxForeignLifetimeFees"/></c:if></td>
		              <td><c:if test="${empty apprxAmendmentFees}">-</c:if><c:if test="${not empty apprxAmendmentFees}"><s:property value="apprxAmendmentFees"/></c:if></td>
		              <td><c:if test="${empty apprxOtherFees}">-</c:if><c:if test="${not empty apprxOtherFees}"><s:property value="apprxOtherFees"/></c:if></td>
		              <td style="width: 75px;"><c:if test="${empty bidExpDt}">-</c:if><c:if test="${not empty bidExpDt}"><s:date name="bidExpDt" format="dd MMM yyyy HH:mm aa zzz"/></c:if></td>
		              </tr>
		             </c:if>
	              </s:iterator>
	              </s:else>
	              </s:else>
	        </tbody>
	    </table>
	   </c:when>
	   <c:when test="${instrumentTypeId eq '4'}">
	    <div class="right"><s:text name="label.dashboard.bidProcess.approximate"/></div>
	    <!-- DLOC Table -->
	    <table class="table table-striped table-bordered">
	    	<thead>
	     	   <tr>
	              <th class="bgtr" style="word-wrap: break-word; width: 250px;"><s:text name="label.dashboard.tableHeader.relBankAndissBank"/></th>
	              <th class="bgtr"><s:text name="label.dashboard.tableHeader.confirmFees"/></th>
	              <th class="bgtr"><s:text name="label.dashboard.tableHeader.otherFees"/></th>
	              <th class="bgtr"><s:text name="label.dashboard.tableHeader.bidExpirationDate"/></th>
	           </tr>
	        </thead>
	        <tbody>
	        	<s:if test="%{reqContactInfo.bidDetails == null || reqContactInfo.bidDetails.isEmpty()}">
	        		<tr class="shown odd">
	       	 			<td colspan="5" style="text-align:center;color:blue; size:40px;"><s:text name="label.dashboard.bundle.display"/></td>
	    			</tr>
	        	</s:if>
	        	<s:else>
	        	<s:if test = "#isTreasuryUser">
	        		<s:iterator value="reqContactInfo.bidDetails" status="stat">
		              <tr style="display: table-row;" class="odd">
		              <td>
		              	<c:if test="${bidAction eq 'Winner' or bidAction eq 'WINNER'}">
		              		<div class="left-col-rdi1">
		                	<c:if test="${not empty issuingBankName}"><b><c:out value="${issuingBankName}"/></b>
		                	</c:if><c:if test="${empty issuingBankName}"> - </c:if>
		                	</div><b>and</b>
		                	<div class="right-col-rdi1">
		                	<c:if test="${not empty bankName}"><b><c:out value="${bankName}"/> - <c:out value="${bidAction}"/></b><br>
								<s:iterator var="addressDtlsItr" value="addressDtls.address">
									<c:if test="${addressDtlsItr != null && addressDtlsItr != ''}">
										<s:property value="addressDtlsItr" /><br />
									</c:if>
                                </s:iterator>
                                <c:if test="${addressDtls.city != null && addressDtls.city != ''}"><s:property value="addressDtls.city"/><br></c:if>
                                <c:if test="${addressDtls.stateProvince != null && addressDtls.stateProvince != ''}"><s:property value="addressDtls.stateProvince"/><br></c:if>
                                <c:if test="${addressDtls.ZIPPostalCode != null && addressDtls.ZIPPostalCode != ''}"> <s:property value="addressDtls.ZIPPostalCode"/><br /></c:if>
                                <c:if test="${addressDtls.country != null && addressDtls.country != ''}"><s:property value="addressDtls.country"/></c:if>
		                	</c:if> <c:if test="${empty bankName}"> - </c:if>
		                	</div>
		                </c:if>
		                <c:if test="${bidAction ne 'Winner' or empty bidAction}">
		                	<%-- <c:if test="${not empty issuingBankName}"><c:out value="${issuingBankName}"/></c:if> <c:if test="${empty issuingBankName}"> - </c:if> --%>
		                	<div class="left-col-rdi1">
		                	<c:if test="${not empty issuingBankName}"><c:out value="${issuingBankName}"/>
		                	</c:if><c:if test="${empty issuingBankName}"> - </c:if>
		                	</div> <c:if test="${not empty bankName}">
		                	and
		                	<div class="right-col-rdi1">
		                	<c:if test="${not empty bankName}"><c:out value="${bankName}"/><br>
								<s:iterator var="addressDtlsItr" value="addressDtls.address">
									<c:if test="${addressDtlsItr != null && addressDtlsItr != ''}">
										<s:property value="addressDtlsItr" /><br />
									</c:if>
                                </s:iterator>
                                <c:if test="${addressDtls.city != null && addressDtls.city != ''}"><s:property value="addressDtls.city"/><br></c:if>
                                <c:if test="${addressDtls.stateProvince != null && addressDtls.stateProvince != ''}"><s:property value="addressDtls.stateProvince"/><br></c:if>
                                <c:if test="${addressDtls.ZIPPostalCode != null && addressDtls.ZIPPostalCode != ''}"> <s:property value="addressDtls.ZIPPostalCode"/><br /></c:if>
                                <c:if test="${addressDtls.country != null && addressDtls.country != ''}"><s:property value="addressDtls.country"/></c:if>
		                	</c:if> <c:if test="${empty bankName}"> - </c:if>
		                	</div>
		                	</c:if>
		                </c:if>
		               </td>
		              <td><c:if test="${empty confirmationFees}">-</c:if><c:if test="${not empty confirmationFees}"><s:property value="confirmationFees"/></c:if></td>
		              <td><c:if test="${empty otherFees}">-</c:if><c:if test="${not empty otherFees}"><s:property value="otherFees"/></c:if></td>
		              <td style="width: 75px;"><c:if test="${empty bidExpDt}">-</c:if><c:if test="${not empty bidExpDt}"><s:date name="bidExpDt" format="dd MMM yyyy HH:mm aa zzz"/></c:if></td>
					  </tr>
	              	</s:iterator>
	              </s:if>
	              <s:else>
	              	<s:iterator value="reqContactInfo.bidDetails" status="stat">
	              	<c:if test="${bidAction eq 'Winner' or bidAction eq 'WINNER'}">
		              <tr style="display: table-row;" class="odd">
		              <td>
		              <div class="left-col-rdi1">
		                <c:if test="${not empty issuingBankName}"><b><c:out value="${issuingBankName}"/></b></c:if> 
		                <c:if test="${empty issuingBankName}"> - </c:if>
		              </div><b>and</b>
		              <div class="right-col-rdi1">
		                	<c:if test="${not empty bankName}"><b><c:out value="${bankName}"/> - <c:out value="${bidAction}"/></b><br>
								<s:iterator var="addressDtlsItr" value="addressDtls.address">
									<c:if test="${addressDtlsItr != null && addressDtlsItr != ''}">
										<s:property value="addressDtlsItr" /><br />
									</c:if>
                                </s:iterator>
                                <c:if test="${addressDtls.city != null && addressDtls.city != ''}"><s:property value="addressDtls.city"/><br></c:if>
                                <c:if test="${addressDtls.stateProvince != null && addressDtls.stateProvince != ''}"><s:property value="addressDtls.stateProvince"/><br></c:if>
                                <c:if test="${addressDtls.ZIPPostalCode != null && addressDtls.ZIPPostalCode != ''}"> <s:property value="addressDtls.ZIPPostalCode"/><br /></c:if>
                                <c:if test="${addressDtls.country != null && addressDtls.country != ''}"><s:property value="addressDtls.country"/></c:if>
		                	</c:if>
		                	<c:if test="${empty bankName}"> - </c:if>
		               </div>
		               </td>
		              <td><c:if test="${empty confirmationFees}">-</c:if><c:if test="${not empty confirmationFees}"><s:property value="confirmationFees"/></c:if></td>
		              <td><c:if test="${empty otherFees}">-</c:if><c:if test="${not empty otherFees}"><s:property value="otherFees"/></c:if></td>
		              <td style="width: 75px;"><c:if test="${empty bidExpDt}">-</c:if><c:if test="${not empty bidExpDt}"><s:date name="bidExpDt" format="dd MMM yyyy HH:mm aa zzz"/></c:if></td>
					  </tr>
					  </c:if>
	              	</s:iterator>	              
	              </s:else>
	              </s:else>
	        </tbody>
	    </table>
	   </c:when>
	  <c:when test="${instrumentTypeId eq '3'}">
	     <!-- Surety Table -->
	    <table class="table table-striped table-bordered">
	    	<thead>
	     	   <tr>
	              <th class="bgtr"><s:text name="label.dashboard.tableHeader.relSuretyAndissBank"/></th>
	              <th class="bgtr"><s:text name="label.dashboard.tableHeader.premiumFees"/></th>
	              <th class="bgtr"><s:text name="label.dashboard.tableHeader.chargeForRider"/></th>
	              <th class="bgtr"><s:text name="label.dashboard.tableHeader.totalFees"/></th>
	              <th class="bgtr"><s:text name="label.dashboard.tableHeader.bidExpirationDate"/></th>
	           </tr>
	        </thead>
	        <tbody>
	        	<s:if test="%{reqContactInfo.bidDetails == null || reqContactInfo.bidDetails.isEmpty()}">
	        		<tr class="shown odd">
	       	 			<td colspan="12" style="text-align:center;color:blue; size:40px;"><s:text name="label.dashboard.bundle.display"/></td>
	    			</tr>
	        	</s:if>
	        	<s:else>
	        	<s:if test = "#isTreasuryUser">
	        		<s:iterator value="reqContactInfo.bidDetails" status="stat">
		              <tr style="display: table-row;" class="odd">
		              <td>
		                <c:if test="${bidAction eq 'Winner' or bidAction eq 'WINNER'}">
		                	<c:if test="${not empty issuingSuretyName}"><b><c:out value="${issuingSuretyName}"/></b></c:if> <c:if test="${empty issuingSuretyName}"> - </c:if><b>and</b>
		                	<c:if test="${not empty bankName}"><b><c:out value="${bankName}"/> - <c:out value="${bidAction}"/></b></c:if> <c:if test="${empty bankName}"> - </c:if>
		                </c:if>
		                <c:if test="${bidAction ne 'Winner' or empty bidAction}">
		                	<c:if test="${not empty issuingSuretyName}"><c:out value="${issuingSuretyName}"/></c:if> <c:if test="${empty issuingSuretyName}"> - </c:if>
		                </c:if>
		              <td><c:if test="${empty premiumFees}">-</c:if><c:if test="${not empty premiumFees}"><s:property value="premiumFees"/></c:if></td>
		              <td><c:if test="${empty changeForRider}">-</c:if><c:if test="${not empty changeForRider}"><s:property value="changeForRider"/></c:if></td>
		              <td><c:if test="${empty totalFees}">-</c:if><c:if test="${not empty totalFees}"><s:property value="totalFees"/></c:if></td>
		              <td style="width: 75px;"><c:if test="${empty bidExpDt}">-</c:if><c:if test="${not empty bidExpDt}"><s:date name="bidExpDt" format="dd MMM yyyy HH:mm aa zzz"/></c:if></td>
		              </tr>
	              	</s:iterator>
	              </s:if>
	              <s:else>
	              	<s:iterator value="reqContactInfo.bidDetails" status="stat">
	              	<c:if test="${bidAction eq 'Winner' or bidAction eq 'WINNER'}">
		              <tr style="display: table-row;" class="odd">
		              <td>
		                <c:if test="${not empty issuingSuretyName}"><b><c:out value="${issuingSuretyName}"/></b></c:if> <c:if test="${empty issuingSuretyName}"> - </c:if><b>and</b>
		                <c:if test="${not empty bankName}"><b><c:out value="${bankName}"/> - <c:out value="${bidAction}"/></b></c:if> <c:if test="${empty bankName}"> - </c:if>
		              <td><c:if test="${empty premiumFees}">-</c:if><c:if test="${not empty premiumFees}"><s:property value="premiumFees"/></c:if></td>
		              <td><c:if test="${empty changeForRider}">-</c:if><c:if test="${not empty changeForRider}"><s:property value="changeForRider"/></c:if></td>
		              <td><c:if test="${empty totalFees}">-</c:if><c:if test="${not empty totalFees}"><s:property value="totalFees"/></c:if></td>
		              <td style="width: 75px;"><c:if test="${empty bidExpDt}">-</c:if><c:if test="${not empty bidExpDt}"><s:date name="bidExpDt" format="dd MMM yyyy HH:mm aa zzz"/></c:if></td>
		              </tr>
		              </c:if>
	              	</s:iterator>
	              </s:else>
	              </s:else>
	        </tbody>
	    </table>
	   </c:when>
	  </c:choose>
	</c:if> 
</div>

<div id="${cc:getSectionColor(param.rowIdValue)}">
	<div class="innerBS">
		<c:if test="${reqContactInfo.bundleId!=null}">
		<div id="create">
			<a href="add-to-bundle.html">Manage bundle</a> <span
				class="ttip info"
				data-original-title="<s:text name="label.dashboard.tooltip.createAddBundle"/>"></span>
		</div>
		</c:if>
		<c:if test="${reqContactInfo.instrumentTypeId eq '1' or reqContactInfo.instrumentTypeId eq '2' or reqContactInfo.instrumentTypeId eq '3' or reqContactInfo.instrumentTypeId eq '4'}">
		
		<div class="linkDiv" id="linkto">
			
			<a href="javascript:;" class="linkto"><s:text name="label.dashboard.link.linkto"/></a> 
			<span class="ttip info" data-original-title="<s:text name="label.dashboard.tooltip.linkto"/>"></span>
			<div class="hide linkShow">
			
				<div>
                <label><s:text name="label.dashboard.link.alocRecordNumber"/></label>
                <span class="alocRecordError" style="display: none;color: #990000;"><s:text name="label.dashboard.link.PleasEnterALOCRecordNumber"/><s:actionmessage/></span>
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