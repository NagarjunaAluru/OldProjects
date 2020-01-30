<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

	<c:if test="${empty param.modelId or (not empty param.modelId and param.modelId eq '')}">
		<div class="row">
			<div class="span12">
				<div class="row lastrow">
					<div class="span22">
						<div class="form-row">
							<p>
								<s:text name="label.request.selectedSite" />
							</p>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.siteName" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
		</c:if>
		
		<div class="row">
			<div class="span12">
				<div class="row lastrow">
					<div class="span22">
						<div class="form-row">
							<label><s:text name="label.request.instrumentPurpose" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.transactionParties.instrumentPurpose" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
		
		<c:if test="${requestDetails.transactionParties.instrumentPurposeId eq 16}">
		<div class="row">
			<div class="span12">
				<div class="row lastrow">
					<div class="span22">
						<div class="form-row">
							<label><s:text name="label.request.otherFees.other" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.transactionParties.instrumentPurposeOther" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
		</c:if>
	
		<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
			<div class="row">
				<div class="span22">
					<div class="form-row">
						<p>
							<s:text name="label.request.isTriPartyRequest" />
						</p>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag}">
								<s:text name="label.request.common.yes" />
							</s:if>
							<s:else>
								<s:text name="label.request.common.no" />
							</s:else>
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span22">
					<div class="form-row">
						<p>
							<s:text name="label.request.privateLabel" />
						</p>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:if test="%{requestDetails.transactionParties.privateLabelFlag}">
								<s:text name="label.request.common.yes" />
							</s:if>
							<s:else>
								<s:text name="label.request.common.no" />
							</s:else>
						</p>
					</div>
				</div>
			</div>
			
		<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag != null && requestDetails.transactionParties.triPartyRequestFlag}">
		<h3>
			<s:text name="label.request.triPartyApplicant" />
		</h3>
		<hr class="hr3" >
		<div class="row">
			<div class="span12">
				<div class="row" style="margin-bottom: 0px;">
					<div class="span33">
						<div class="form-row">
							<label><s:text name="label.request.nameAndAddress" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property	value="requestDetails.transactionParties.triPartyApplicant.name" />
								<br />
								<s:iterator value="requestDetails.transactionParties.triPartyApplicant.address">
									<s:property />
									<br />
								</s:iterator>
	
								<s:property	value="requestDetails.transactionParties.triPartyApplicant.city" />
								<s:property	value="requestDetails.transactionParties.triPartyApplicant.stateProvince" />
								<s:property	value="requestDetails.transactionParties.triPartyApplicant.ZIPPostalCode" />
								<br />
								<s:property	value="requestDetails.transactionParties.triPartyApplicant.country" />
							</p>
						</div>
					</div>
				</div>
	
			</div>
		</div>
		</s:if>
		</c:if>
	
		<h3>
			<s:text name="label.request.applicant" />
		</h3>
		<hr class="hr3" >
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.common.legalEntityNameC" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.leName" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.common.legalEntityGOLDIdC" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.leGoldId" />
					</p>
				</div>
			</div>
		</div>
		<c:choose>
		<c:when test="${param.page eq 'Taxonomy'}">
		<div class="row">
			<c:if test="${empty requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId}">
				<c:set var="BusinessShowClass" value="display: none;"/>
			</c:if>
			<c:if test="${not empty requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId}">
				<s:set var="personNameSelected" value="%{'Yes'}"></s:set>
				<c:set var="BusinessShowClass" value="display: block;"/>
			</c:if>
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.businessContactPerson" name="personName" required="false" cssClass="span3 lookup-filterValue" id="businessContactPersonId" theme="aloc"/>
					<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
					<s:url action="BusinessContactPersonLookup" namespace="/int" var="getBusinessContactPersonURL" escapeAmp="false" encode="true">
					</s:url> 
					<a class="btn-secondary lookup" href="<s:property value="#getBusinessContactPersonURL"/>" ><s:text name="label.request.common.lookup"/></a>
					<img alt="Loading..." id="bcpIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
						style="height: 20px; display:none">
					<br />
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
			</div>
		</div>
		
		<div class="conditional-row" id="BusinessShow" style="${BusinessShowClass}">
			<s:hidden name="personNameSelection" id="personNameSelectionId" value="%{#personNameSelected}"/>
			
			<div class="row">
				<div class="span7">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<s:label key="label.request.businessContactPersonName"/>
							</div>
						</div>
						<div class="span4 right">	
							<div class="form-row">
								<p><s:property value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.lastName"/>, <s:property value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.firstName"/></p>
								<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.lastName" id="tpApplicantBCPLName"></s:hidden>
								<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.firstName" id="tpApplicantBCPFName"></s:hidden>
							</div>
						</div><!-- end of block -->
					</div>
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<s:label key="label.request.businessContactPersonSSO"/>
							</div>
						</div><!-- end of block -->
						<div class="span4 right">
							<div class="form-row">
								<p><s:property value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId"/></p>
								<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId" id="tpApplicantBCPSSO"></s:hidden>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		</c:when>
		<c:otherwise>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.businessContactPerson" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.lastName" />
						,
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.firstName" />
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId" />
					</p>
				</div>
			</div>
		</div>
		</c:otherwise>
		</c:choose>
		<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag == null || requestDetails.transactionParties.triPartyRequestFlag == false}">
			<div class="row">
				<div class="span33">
					<div class="form-row">
						<label><s:text name="label.request.nameAndAddress" /></label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property	value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.name" />
							<br />
							<s:iterator	value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address">
								<s:property />
								<br />
							</s:iterator>
		
							<s:property	value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.city" />
							<s:property	value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
							<s:property	value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" />
							<br />
							<s:property	value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.country" />
						</p>
					</div>
				</div>
			</div>
		</s:if>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.geApplicantReference" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.refDetails[0].refValue" />
					</p>
				</div>
			</div>
		</div>
		<s:set name="geRefSize"	value="requestDetails.transactionParties.tpApplicantDetails.refDetails.size" />
		<s:if test="#geRefSize > 1">
			<div class="row">
				<div class="span12">
					<s:iterator value="requestDetails.transactionParties.tpApplicantDetails.refDetails" status="stat">
						<s:if test="#stat.index != 0">
							<div class="row">
								<div class="span33">
									<div class="form-row">
										<label><s:text name="label.request.geApplicantReference" />
											<s:property value="#stat.count" />:</label>
									</div>
								</div>
								<div class="span5 left">
									<div class="form-row">
										<p class="padding40">
											<s:property value="refValue" />
										</p>
									</div>
								</div>
							</div>
						</s:if>
					</s:iterator>
				</div>
			</div>
		</s:if>
		
		<c:choose>
		<c:when test="${param.page eq 'Taxonomy'}">
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.buUnit"
							theme="aloc" 
							key="label.request.buc" 
							id="bussUnitCodeId"
							tooltip="%{getText('label.request.tooltip.buc')}">
						</s:textfield>
						
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.accDist"
							theme="aloc" 
							key="label.request.adn" 
							tooltip="%{getText('label.request.tooltip.adn')}"
							id="accDistNoId">
						</s:textfield>
						<img src="${pageContext.request.contextPath}/img/loading.gif" style="padding:10px 0 0 10px; height: 20px; display:none;" 
							id="bucadnLoading" align="middle"/>
						<img src="${pageContext.request.contextPath}/img/yes.png" title="Model Enabled" id="matched"
							style="vertical-align: middle; margin-left: 10px;display:none;" /> 
						<img src="${pageContext.request.contextPath}/img/no.png" title="Model Disabled" id="unMatched"
							style="vertical-align: middle; margin-left: 10px;display:none;" />
					</div>
				</div>
			</div>
			
			<div class="row ibsClassNotification bucAdnTimeOut" style="display: none;">
	            <div class="span12">
	            	<div class="errorbox">
						<div class="noteHead"><p class="noteicon"><s:text name="label.common.alert"/></p></div>
						<div class="noteContent">
							<p><s:text name="label.request.bucadNotification"/></p>
						</div>
					</div>
	            </div>
        	</div>
        	
			<div class="row bucBlocked bucAdnTimeOut" style="display: none;">
	            <div class="span12">
	                <div class="errorbox">
	                <div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
					<div class="errorContent">
		                <p><s:text name="label.request.bucBlocked"/></p>
		                <p id="blockedBUCContact"><s:text name="label.request.ibsContact" /> </p>
	                </div>
	                </div>
	            </div>
        	</div>
			<div class="row ibsClassWarning bucAdnTimeOut" style="display: none;">
	            <div class="span12">
	                <div class="errorbox">
	                <div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
					<div class="errorContent">
	                <p id="ibsMessage"><s:property value="requestDetails.transactionParties.tpApplicantDetails.IBSSystMsg"/></p>
	                <p id="ibsContact"><s:text name="label.request.ibsContact" /> <s:property value="requestDetails.transactionParties.tpApplicantDetails.IBSLastName"/>, <s:property value="requestDetails.transactionParties.tpApplicantDetails.IBSFirstName"/> </p>
	                <s:hidden name="requestDetails.transactionParties.tpApplicantDetails.IBSSystMsg" id="ibsSystemMsg"/>
					<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.IBSMsgId" id="ibsSystemMsgId"/>
					<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.IBSLastName" id="ibsLNameId"/>
					<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.IBSFirstName" id="ibsFNameId"/>
					<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.IBSPhoneNo" id="ibsPhoneId"/>
	                </div>
	                </div>
	            </div>
	        </div>

			<c:if test="${empty requestDetails.siteTypeName or (not empty requestDetails.siteTypeName and requestDetails.siteTypeName eq 'Financial Business')}">
			<div class="row hide" id="csoNoDiv">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.csoNo"
						theme="aloc" key="label.request.csoNo" id="csoID" 
						tooltip="%{getText('label.request.tooltip.csoId')}"></s:textfield>
						<img src="${pageContext.request.contextPath}/img/loading.gif" style="padding:10px 0 0 10px; height: 20px; display:none;" 
							id="csoleGoldLoading"/>
						<img src="${pageContext.request.contextPath}/img/yes.png" title="Model Enabled" id="csoMatched"
							style="vertical-align: middle; margin-left: 10px;display:none;" /> 
						<img src="${pageContext.request.contextPath}/img/no.png" title="Model Disabled" id="csoUnMatched"
							style="vertical-align: middle; margin-left: 10px;display:none;" />
						<span class="csoLEClass" style="padding: 6px 10px;"></span>
						<s:hidden name="validCSO" id="validCSOId"/>
					</div>
				</div>
				<!-- end of block -->
			</div>
			<div class="row hide" id="csoApprovalDtDiv">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.csoApprovalDt"
						theme="aloc" key="label.request.csoDate"
						tooltip="%{getText('label.request.tooltip.csoDate')}"
						cssClass="dateFutureOnly"></s:textfield>
					</div>
				</div>
				<!-- end of block -->
			</div>
	
			<div class="row hide" id="certifyDiv">
				<div class="span12">
					<div class="form-row">
						<p><s:text name="label.request.csoCertify"/> </p>
	                    <p>&nbsp;</p>
						<s:checkbox name="requestDetails.transactionParties.tpApplicantDetails.certifyFlag" fieldValue="true" 
						theme="aloc-TransactionParties" cssClass="checkbox" id="certifyFlagID" key="label.request.csoCertifyAgree"></s:checkbox>
						
					</div>
				</div>
			</div>
			</c:if>
		</c:when>
		<c:otherwise>
			<div class="row">
				<div class="span33">
					<div class="form-row">
						<label><s:text name="label.request.buc" /></label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property	value="requestDetails.transactionParties.tpApplicantDetails.buUnit"/>
						</p>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="span33">
					<div class="form-row">
						<label><s:text name="label.request.adn" /></label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property	value="requestDetails.transactionParties.tpApplicantDetails.accDist" />
						</p>
					</div>
				</div>
			</div>
		</c:otherwise>
		</c:choose>
		
		<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
			<div class="row">
				<div class="span12">
					<div class="row">
						<div class="span33">
							<div class="form-row">
								<label><s:text name="label.request.csoNo" /></label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<s:property	value="requestDetails.transactionParties.tpApplicantDetails.csoNo" />
								</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span33">
							<div class="form-row">
								<label><s:text name="label.request.csoDate" /></label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<s:property	value="requestDetails.transactionParties.tpApplicantDetails.csoApprovalDt" />
								</p>
							</div>
						</div>
					</div>
					<div class="row" style="margin-bottom: 0px;">
						<div class="span33">
							<div class="form-row">
								<label><s:text name="label.request.csoCretified" /></label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">Yes</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		
		<h3>
			<s:text name="label.request.customer" />
		</h3>
		<hr class="hr3" >
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.nameAndAddress" />
					</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property	value="requestDetails.transactionParties.customer.addressDtls.name" />
						<br />
						<s:iterator	value="requestDetails.transactionParties.customer.addressDtls.address">
							<s:property />
							<br />
						</s:iterator>
						<s:property	value="requestDetails.transactionParties.customer.addressDtls.city" />
						<s:property	value="requestDetails.transactionParties.customer.addressDtls.stateProvince" />
						<s:property	value="requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode" />
						<br />
						<s:property	value="requestDetails.transactionParties.customer.addressDtls.country" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.customerReference" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property	value="requestDetails.transactionParties.customer.refDetails[0].refValue" />
					</p>
				</div>
			</div>
		</div>
		<s:set name="customerRefSize" value="requestDetails.transactionParties.customer.refDetails.size" />
		<s:if test="#customerRefSize > 1">
			<div class="row">
				<div class="span12">
					<s:iterator value="requestDetails.transactionParties.customer.refDetails" status="stat">
						<s:if test="#stat.index != 0">
							<div class="row">
								<div class="span33">
									<div class="form-row">
										<label><s:text name="label.request.customerReference" />
											<s:property value="#stat.count" />:</label>
									</div>
								</div>
								<div class="span5 left">
									<div class="form-row">
										<p class="padding40">
											<s:property value="refValue" />
										</p>
									</div>
								</div>
							</div>
						</s:if>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<c:if test="${requestDetails.WFDetails.WFStage eq 'REQEST'}">
			<s:if test="%{requestDetails.transactionParties.requiresEdits}">
				<div class="row">
					<div class="span44">
						<div class="form-row">
							<label> <s:text name="label.request.Sendbacknotes" /> :
							</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property	value="requestDetails.transactionParties.sendBackNotes" />
							</p>
						</div>
					</div>
				</div>
			</s:if>
		</c:if>
