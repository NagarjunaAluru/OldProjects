<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				<c:if test="${instrumentTypeId eq '1' || instrumentTypeId eq '2'}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.expirationDate"/></div>
					<div class="right-col-rdi">
						<c:choose>
							<c:when test="${not empty reqContactInfo.expDt}">
								<s:property value="reqContactInfo.expDt"/>
							</c:when>
							<c:otherwise>
							     -
							</c:otherwise>
						</c:choose>
					</div>
					<div class="clear"></div>
				</c:if>
				
	       		<c:if test="${not empty reqContactInfo.prefLocDocPresentaion}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.preferLocForDoc"/></div>
					<div class="right-col-rdi"><s:property value="reqContactInfo.prefLocDocPresentaion"/></div>
					<div class="clear"></div>
				</c:if>
				 
				<c:if test="${not empty reqContactInfo.ecnoExpDt}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.EconomicExpDate"/></div>
					<div class="right-col-rdi"><s:property value="reqContactInfo.ecnoExpDt"/></div>
					<div class="clear"></div>
				</c:if>
					
				<c:if test="${not empty reqContactInfo.advised || not empty reqContactInfo.confirmed}">
					<c:choose>
						<c:when test="${not empty reqContactInfo.advised}">
							<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.bidState"/></div>
							<div class="right-col-rdi">
							<c:choose>
							<c:when test="${reqContactInfo.advised eq 'Y' or reqContactInfo.advised eq 'Yes' or reqContactInfo.advised eq 'YES'}">
								<s:text name="label.request.common.yes" />
							</c:when>
							<c:when test="${reqContactInfo.advised eq 'N' or reqContactInfo.advised eq 'No' or reqContactInfo.advised eq 'NO'}">
								<s:text name="label.request.common.no" />
							</c:when>
							<c:otherwise><s:property value="reqContactInfo.advised"/></c:otherwise>
							</c:choose>
							</div>
							<div class="clear"></div>
						</c:when>
						<c:when test="${not empty reqContactInfo.confirmed}">
							<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.bidState"/></div>
							<div class="right-col-rdi">
							<c:choose>
							<c:when test="${reqContactInfo.confirmed eq 'Y' or reqContactInfo.confirmed eq 'Yes' or reqContactInfo.confirmed eq 'YES'}">
								<s:text name="label.request.common.yes" />
							</c:when>
							<c:when test="${reqContactInfo.confirmed eq 'N' or reqContactInfo.confirmed eq 'No' or reqContactInfo.confirmed eq 'NO'}">
								<s:text name="label.request.common.no" />
							</c:when>
							<c:otherwise><s:property value="reqContactInfo.confirmed"/></c:otherwise>
							</c:choose>
							</div>
							<div class="clear"></div>
						</c:when>
					</c:choose>
				</c:if>
				
				<c:if test="${instrumentTypeId eq '1' || instrumentTypeId eq '2'}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.specInstructions"/></div>
				<c:choose>
					<c:when test="${not empty reqContactInfo.specialInstructions}">
						<div class="right-col-rdi"><s:property value="reqContactInfo.specialInstructions"/></div>
					</c:when>
					<c:otherwise>
						 -
					</c:otherwise>
				</c:choose>
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
				
	        		<c:if test="${not empty reqContactInfo.issuingBankName}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.IssuingBank"/></div>
					<div class="right-col-rdi"><s:property value="reqContactInfo.issuingBankName"/></div>
					<div class="clear"></div>
					</c:if>
					
					<c:if test="${not empty reqContactInfo.businessSelectedBank}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.businessSelBank"/></div>
					<div class="right-col-rdi"><s:property value="reqContactInfo.businessSelectedBank"/></div>
					<div class="clear"></div>
					</c:if>
					
					<c:if test="${not empty reqContactInfo.geSigningDocs}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.geSignDoc"/></div>
					<div class="right-col-rdi"><s:property value="reqContactInfo.geSigningDocs"/></div>
					<div class="clear"></div>
					</c:if>
				
					<c:if test="${not empty reqContactInfo.bundleId}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.bundleID"/></div>
					<div class="right-col-rdi"><s:property value="reqContactInfo.bundleId"/></div>
					<div class="clear"></div>
					</c:if>
			</div>
		</div>

		<div id="report-details">
			<div id="report-details-inner">
			
	        		<c:if test="${not empty reqContactInfo.paymentTerms}">
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.paymentTerms"/></div>
						<div class="right-col-rdi"><s:property value="reqContactInfo.paymentTerms"/>					
						</div>
						<div class="clear"></div>
					</c:if>
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
	
					<c:if test="${not empty reqContactInfo.countryOfAdvisement}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.countryOfAdvisement"/></div>
					<div class="right-col-rdi"><s:property value="reqContactInfo.countryOfAdvisement"/>
					</div>
					<div class="clear"></div>
					</c:if>
					
					<c:if test="${not empty reqContactInfo.countryOfConfirmation}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.countryOfConfirm"/></div>
					<div class="right-col-rdi">
						<c:choose>
						<c:when test="${reqContactInfo.countryOfConfirmation eq 'Y' or reqContactInfo.countryOfConfirmation eq 'Yes' or reqContactInfo.countryOfConfirmation eq 'YES'}">
							<s:text name="label.request.common.yes" />
						</c:when>
						<c:when test="${reqContactInfo.countryOfConfirmation eq 'N' or reqContactInfo.countryOfConfirmation eq 'No' or reqContactInfo.countryOfConfirmation eq 'NO'}">
							<s:text name="label.request.common.no" />
						</c:when>
						<c:otherwise><s:property value="reqContactInfo.countryOfConfirmation"/></c:otherwise>
						</c:choose>
					</div>
					<div class="clear"></div>
					</c:if>
		
					<c:if test="${not empty reqContactInfo.privateLabel}">
					<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.privateLabel"/></div>
					<div class="right-col-rdi">
					<c:choose>
					<c:when test="${reqContactInfo.privateLabel eq 'Y' or reqContactInfo.privateLabel eq 'Yes' or reqContactInfo.privateLabel eq 'YES'}">
						<s:text name="label.request.common.yes" />
					</c:when>
					<c:when test="${reqContactInfo.privateLabel eq 'N' or reqContactInfo.privateLabel eq 'No' or reqContactInfo.privateLabel eq 'NO'}">
						<s:text name="label.request.common.no" />
					</c:when>
					<c:otherwise><s:property value="reqContactInfo.privateLabel"/></c:otherwise>
					</c:choose>
					</div>
					<div class="clear"></div>
					</c:if>
					
					<c:if test="${instrumentTypeId eq '3'}">
					<c:if test="${not empty reqContactInfo.expDt}">
						<div class="left-col-rdi"><s:text name="label.dashboard.expandLabel.expirationDate"/></div>
						<div class="right-col-rdi"><s:property value="reqContactInfo.expDt"/></div>
						<div class="clear"></div>
				    </c:if>
				    </c:if>
				
			</div>
		</div>

		<div class="clear"></div>
	</div>
	<c:choose>
		<c:when test="${instrumentTypeId eq '1' || instrumentTypeId eq '2'}">
		<div class="right"><s:text name="label.dashboard.bidProcess.approximate"/></div>
	<table class="table table-striped table-bordered">
    	<thead>
     	   <tr>
        	  <th class="bgtr"><s:text name="label.dashboard.tableHeader.modelAction"/></th>
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
        	<s:iterator value="reqContactInfo.bidDetails" status="stat">
	              <tr style="display: table-row;" class="odd">
	              <td rowspan="2">
	              	<c:choose>
	              	  <c:when test="${bidFlag eq 'Y'}">
		              	<a href="#" class="btn-secondary selectWinnerInExpView" id="selectBidWinId" data-toggle="modal"><s:text name="label.dashboard.modal.body.selectAsWin"/></a>
		              </c:when>
		              <c:when test="${bidFlag eq 'N'}">
		              	 <s:text name="label.dashboard.expandLabel.optoutMessage"/>	 
		              </c:when>		              
		              <c:otherwise>
		              	--
		              </c:otherwise>
		            </c:choose>
	              </td>
	              <td>
	              <c:if test="${bidFlag eq 'Y'}">
		             <s:form name="bankBidAwardForm" id="bankBidAwardFormID" action="openRequest" namespace="/int">
		             	<input type="hidden" class ="requestId" name="requestId" value="${requestId}">
                		<input type="hidden" class ="dashboardViewType" name="dashboardViewType" value="${dashboardViewType}">
                		<input type="hidden" class = "stageId" name="stage" value="${stage}">
                		<input type="hidden" class ="instrumentId" name="instrumentId" value="${instrumentTypeId}">
                		<input type="hidden" class = "wfId" name="wfid" value="${wfid}">
	                	<input type="hidden" class = "queueNameId" name="queueName" value="${queueName}">
	                	<input type="hidden" class = "procedureNameId" name="procedureName" value="${procedureName}">
	                	<input type="hidden" class ="stageNameId" name="stageName" value="${stageName}">
	                	<input type="hidden" class ="bankBidId" name="bankBidId" value="${bankBidId}">
	                	<input type="hidden" class ="bidFlag" name="bidFlag" value="${bidFlag}">
	                	<input type="hidden" class ="bidReplyId" name="bidReplyId" value="${bidReplyId}">
	                	<input type="hidden" class ="bundleId" name="bundleId" value="${reqContactInfo.bundleId}">
	                	<input type="hidden" class ="issuingBankName" name="issuingBankName" value="${issuingBankName}">
	                	<input type="hidden" class ="swfitFlag" name="transmissionPlatform" value="${swfitFlag}">
                	    <div class="left-col-rdi1"><s:submit cssStyle="word-wrap: break-word; width: 90px;" cssClass="submitLink1" value="%{issuingBankName}" action="openRequest" namespace="/int" /></div>and
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
							</c:if>
							<c:if test="${empty bankName}"> &nbsp;&nbsp;--  </c:if><br/>						
						</div>
                      </s:form>
		           </c:if>
		            <c:if test="${bidFlag eq 'N' or empty bidFlag}">
		           	  <c:if test="${not empty issuingBankName}"><c:out value="${issuingBankName}"/></c:if> <c:if test="${empty issuingBankName}"> -- </c:if>&nbsp;&nbsp; and
		           	  <c:if test="${not empty bankName}">&nbsp;&nbsp;<c:out value="${bankName}"/></c:if> <c:if test="${empty bankName}">&nbsp;&nbsp; --  </c:if>
		           </c:if>
		          </td>
	              <td><c:if test="${empty apprxUSLifetimeFees}">-</c:if><c:if test="${not empty apprxUSLifetimeFees}"><s:property value="apprxUSLifetimeFees"/></c:if></td>
	              <td><c:if test="${empty apprxForeignLifetimeFees}">-</c:if><c:if test="${not empty apprxForeignLifetimeFees}"><s:property value="apprxForeignLifetimeFees"/></c:if></td>
	              <td><c:if test="${empty apprxAmendmentFees}">-</c:if><c:if test="${not empty apprxAmendmentFees}"><s:property value="apprxAmendmentFees"/></c:if></td>
	              <td><c:if test="${empty apprxOtherFees}">-</c:if><c:if test="${not empty apprxOtherFees}"><s:property value="apprxOtherFees"/></c:if></td>
	              <td style="width: 75px;"><c:if test="${empty bidExpDt}">-</c:if><c:if test="${not empty bidExpDt}"><s:date name="bidExpDt" format="dd MMM yyyy HH:mm aa zzz"/></c:if></td>
	              </tr>
	              <tr style="display: table-row;" class="odd">
	              	<td colspan="6" style="word-wrap: break-word; border-left: #a6c2d6 1px solid;"><div style="width: 750px; overflow: auto;"><strong><s:text name="label.dashboard.tableHeader.bidReplyComments"/></strong> <c:if test="${empty bankbidReplyComments}">-</c:if><c:if test="${not empty bankbidReplyComments}"><s:property value="bankbidReplyComments"/></c:if></div></td>
	              </tr>
              </s:iterator>
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
        	  <th class="bgtr"><s:text name="label.dashboard.tableHeader.modelAction"/></th>
              <th class="bgtr" style="word-wrap: break-word; width: 70px;"><s:text name="label.dashboard.tableHeader.relBankAndissBank"/></th>
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
        	<s:iterator value="reqContactInfo.bidDetails" status="stat">
	              <tr style="display: table-row;" class="odd">
	              <td rowspan="2">
		              <c:choose>
	              	  <c:when test="${bidFlag eq 'Y'}">
		              	<a href="#" class="btn-secondary selectWinnerInExpView" id="selectBidWinId" data-toggle="modal"><s:text name="label.dashboard.modal.body.selectAsWin"/></a>
		              </c:when>
		              <c:when test="${bidFlag eq 'N'}">
		              	 <s:text name="label.dashboard.expandLabel.optoutMessage"/>	 
		              </c:when>
		              <c:otherwise>
		              	--
		              </c:otherwise>
		            </c:choose>
	              </td>
	              <td style="word-wrap: break-word; width: 70px;">
	               <c:if test="${bidFlag eq 'Y'}">
		           <s:form name="bankBidAwardForm" id="bankBidAwardFormID" action="openRequest" namespace="/int">
	                	<input type="hidden" class ="requestId" name="requestId" value="${requestId}">
                		<input type="hidden" class ="dashboardViewType" name="dashboardViewType" value="${dashboardViewType}">
                		<input type="hidden" class = "stageId" name="stage" value="${stage}">
                		<input type="hidden" class ="instrumentId" name="instrumentId" value="${instrumentTypeId}">
                		<input type="hidden" class = "wfId" name="wfid" value="${wfid}">
	                	<input type="hidden" class = "queueNameId" name="queueName" value="${queueName}">
	                	<input type="hidden" class = "procedureNameId" name="procedureName" value="${procedureName}">
	                	<input type="hidden" class ="stageNameId" name="stageName" value="${stageName}">
	                	<input type="hidden" class ="bankBidId" name="bankBidId" value="${bankBidId}">
	                	<input type="hidden" class ="bidFlag" name="bidFlag" value="${bidFlag}">
	                	<input type="hidden" class ="bidReplyId" name="bidReplyId" value="${bidReplyId}">
	                	<input type="hidden" class ="bundleId" name="bundleId" value="${reqContactInfo.bundleId}">
	                	<input type="hidden" class ="issuingBankName" name="issuingBankName" value="${issuingBankName}">
	                	<div class="left-col-rdi1"><s:submit cssStyle="word-wrap: break-word; width: 90px;" cssClass="submitLink1" value="%{issuingBankName}" action="openRequest" namespace="/int" /></div>and
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
							</c:if>
							<c:if test="${empty bankName}"> &nbsp;&nbsp;--  </c:if><br/>						
						</div>
                      </s:form>
		            </c:if>
		             <c:if test="${bidFlag eq 'N' or empty bidFlag}">
		             	<c:if test="${not empty issuingBankName}"><c:out value="${issuingBankName}"/></c:if> <c:if test="${empty issuingBankName}"> -- </c:if>&nbsp;&nbsp; and
		             	<c:if test="${not empty bankName}">&nbsp;&nbsp;<c:out value="${bankName}"/></c:if> <c:if test="${empty bankName}">&nbsp;&nbsp; --  </c:if>
		             </c:if>
		            <br>
		           <%--  <s:property value="issuingBankName"/> --%></td>
	              <td><c:if test="${empty confirmationFees}">-</c:if><c:if test="${not empty confirmationFees}">${confirmationFees}</c:if></td>
	              <td><c:if test="${empty otherFees}">-</c:if><c:if test="${not empty otherFees}"><s:property value="otherFees"/></c:if></td>
	              <td style="width: 75px;"><c:if test="${empty bidExpDt}">-</c:if><c:if test="${not empty bidExpDt}"><s:date name="bidExpDt" format="dd MMM yyyy HH:mm aa zzz"/></c:if></td>
				  </tr>
	              <tr style="display: table-row;" class="odd">
	              	<td colspan="4" style="word-wrap: break-word; border-left: #a6c2d6 1px solid;"><div style="width: 750px; overflow: auto;"><strong><s:text name="label.dashboard.tableHeader.bidReplyComments"/></strong> <c:if test="${empty bankbidReplyComments}">-</c:if><c:if test="${not empty bankbidReplyComments}"><s:property value="bankbidReplyComments"/></c:if></div></td>
	              </tr>
              </s:iterator>
              </s:else>
        </tbody>
    </table>
   </c:when>
  <c:when test="${instrumentTypeId eq '3'}">
     <!-- Surety Table -->
    <table class="table table-striped table-bordered">
    	<thead>
     	   <tr>
        	  <th class="bgtr"><s:text name="label.dashboard.tableHeader.modelAction"/></th>
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
        	<s:iterator value="reqContactInfo.bidDetails" status="stat">
	              <tr style="display: table-row;" class="odd">
	              <td rowspan="2">
		             <c:choose>
	              	  <c:when test="${bidFlag eq 'Y'}">
		              	<a href="#" class="btn-secondary selectWinnerInExpView" id="selectBidWinId" data-toggle="modal"><s:text name="label.dashboard.modal.body.selectAsWin"/></a>
		              </c:when>
		              <c:when test="${bidFlag eq 'N'}">
		              	 <s:text name="label.dashboard.expandLabel.optoutMessage"/>	 
		              </c:when>
		              <c:otherwise>
		              	--
		              </c:otherwise>
		            </c:choose>
	              </td>
	              <td>
	               <c:if test="${bidFlag eq 'Y'}">
	               <s:form name="bankBidAwardForm" id="bankBidAwardFormID" action="openRequest" namespace="/int">
	              		<input type="hidden" class ="requestId" name="requestId" value="${requestId}">
                		<input type="hidden" class ="dashboardViewType" name="dashboardViewType" value="${dashboardViewType}">
                		<input type="hidden" class = "stageId" name="stage" value="${stage}">
                		<input type="hidden" class ="instrumentId" name="instrumentId" value="${instrumentTypeId}">
                		<input type="hidden" class = "wfId" name="wfid" value="${wfid}">
	                	<input type="hidden" class = "queueNameId" name="queueName" value="${queueName}">
	                	<input type="hidden" class = "procedureNameId" name="procedureName" value="${procedureName}">
	                	<input type="hidden" class ="stageNameId" name="stageName" value="${stageName}">
	                	<input type="hidden" class ="bankBidId" name="bankBidId" value="${bankBidId}">
	                	<input type="hidden" class ="bidFlag" name="bidFlag" value="${bidFlag}">
	                	<input type="hidden" class ="bidReplyId" name="bidReplyId" value="${bidReplyId}">
	                	<input type="hidden" class ="bundleId" name="bundleId" value="${reqContactInfo.bundleId}">
	                	<input type="hidden" class ="issuingBankName" name="issuingBankName" value="${issuingBankName}">
	                    <s:submit cssClass="submitLink1" value="%{issuingSuretyName}" action="openRequest" namespace="/int" />  &nbsp;&nbsp; and
	                    <c:if test="${not empty bankName}">&nbsp;&nbsp;<c:out value="${bankName}"/></c:if> <c:if test="${empty bankName}"> &nbsp;&nbsp;--  </c:if>
                      </s:form>
		              </c:if>
		               <c:if test="${bidFlag eq 'N' or empty bidFlag}">
		               		<div style="word-wrap: break-word;">
		               		<c:if test="${not empty issuingSuretyName}"><c:out value="${issuingSuretyName}"/></c:if> <c:if test="${empty issuingSuretyName}"> -- </c:if>&nbsp;&nbsp; and
		               		<c:if test="${not empty bankName}">&nbsp;&nbsp;<c:out value="${bankName}"/></c:if> <c:if test="${empty bankName}">&nbsp;&nbsp; --  </c:if>
		               		</div>
		               </c:if>
		              <%-- <br><s:property value="issuingSuretyName"/> --%></td>
	              <td><c:if test="${empty premiumFees}">-</c:if><c:if test="${not empty premiumFees}"><s:property value="premiumFees"/></c:if></td>
	              <td><c:if test="${empty changeForRider}">-</c:if><c:if test="${not empty changeForRider}"><s:property value="changeForRider"/></c:if></td>
	              <td><c:if test="${empty totalFees}">-</c:if><c:if test="${not empty totalFees}"><s:property value="totalFees"/></c:if></td>
	              <td style="width: 75px;"><c:if test="${empty bidExpDt}">-</c:if><c:if test="${not empty bidExpDt}"><s:date name="bidExpDt" format="dd MMM yyyy HH:mm aa zzz"/></c:if></td>
	              </tr>
	              <tr style="display: table-row;" class="odd"> 
	              	<td colspan="11" style="word-wrap: break-word; border-left: #a6c2d6 1px solid;"><div style="width: 750px; overflow: auto;"><strong><s:text name="label.dashboard.suretyReplyComments"/></strong> <c:if test="${empty bankbidReplyComments}">-</c:if><c:if test="${not empty bankbidReplyComments}"><s:property value="bankbidReplyComments"/></c:if></div></td>
	              </tr>
              </s:iterator>
              </s:else>
        </tbody>
    </table>
   </c:when>
   </c:choose>
</div>
