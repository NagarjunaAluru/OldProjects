<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

             <c:if test="${param.verify ne 'suretybidAward'}">
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<s:label key="label.request.common.legalEntityNameC" />
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.principal.leName" />
							</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<label><s:text name="label.request.common.legalEntityGOLDID" />: </label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.principal.leGoldId" />
							</p>
						</div>
					</div>
				</div>
			</c:if>
			
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<label><s:text name="label.request.common.nameAddress" />: </label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property value="requestDetails.principal.addressDtls.name" />
						</p>
						<p class="padding40">
							<s:property
								value="requestDetails.principal.addressDtls.address[0]" />
						</p>
						<p class="padding40">
							<s:property
								value="requestDetails.principal.addressDtls.address[1]" />
						</p>
						<p class="padding40">
							<s:property value="requestDetails.principal.addressDtls.city" />
							<s:property value="requestDetails.principal.addressDtls.stateProvince" />
							<s:property
								value="requestDetails.principal.addressDtls.ZIPPostalCode" />
						</p>
						<p class="padding40">
							<s:property value="requestDetails.principal.addressDtls.country" />
						</p>
						<p class="padding40">
							<s:property
								value="requestDetails.principal.addressDtls.countryOfInc" />
						</p>
						<p class="padding40">
							<s:property
								value="requestDetails.principal.addressDtls.stateOfInc" />
						</p>
						<s:hidden name="requestDetails.principal.addressDtls.address[0]" id="principalAddress1" />
						<s:hidden name="requestDetails.principal.addressDtls.address[1]" id="principalAddress2" />
						<s:hidden name="requestDetails.principal.addressDtls.city" id="principalAddressCity"/>
						<s:hidden name="requestDetails.principal.addressDtls.stateProvinceCd" id="principalAddressStatecode"/>
						<s:hidden name="requestDetails.principal.addressDtls.stateProvince" id="principalAddressState" />
						<s:hidden name="requestDetails.principal.addressDtls.ZIPPostalCode" id="principalAddressZip"/>
						<s:hidden name="requestDetails.principal.addressDtls.countryCd" id="principalCountryCd"/>
						<s:hidden name="requestDetails.principal.addressDtls.country" id="principalAddressCountry" />					
					</div>
				</div>
				<!-- end of block -->
			</div>
			
        	<c:if test="${param.verify ne 'suretybidAward'}">
				<s:iterator value="requestDetails.principal.refDetails" status="status">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label><s:text name="label.request.gePrincipalReference" />&nbsp;<s:if test="%{#status.count > 1}"> <s:property value="%{#status.count}"/> </s:if>:</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<s:property value="refValue"/>
								</p>
							</div>
						</div>
						<!-- end of block -->
					</div>
				</s:iterator>
				
				<c:choose>
					<c:when test="${param.page eq 'Taxonomy'}">
						<div class="row">
							<div class="span12">
								<div class="form-row">
									<s:textfield name="requestDetails.principal.principalBuUniteCd"
										theme="aloc" cssClass="span1"
										key="label.request.principalBusinessUniteCode" id="bussUnitCodeId"
										tooltip="%{getText('label.request.tooltip.principalBUC')}">
									</s:textfield>
					
								</div>
							</div>
							<!-- end of block -->
						</div>				
						<div class="row">
							<div class="span12">
								<div class="form-row">
									<s:textfield name="requestDetails.principal.principalAccDistNo"
										theme="aloc"
										key="label.request.principalAccountingDistributionNumber"
										tooltip="%{getText('label.request.tooltip.principalADN')}"
										id="accDistNoId">
									</s:textfield>
									<img src="${pageContext.request.contextPath}/img/loading.gif"
										style="padding: 10px 0 0 10px; height: 20px; display: none;"
										id="bucadnLoading" align="middle" /> <img
										src="${pageContext.request.contextPath}/img/yes.png"
										title="Model Enabled" id="matched"
										style="vertical-align: middle; margin-left: 10px; display: none;" />
									<img src="${pageContext.request.contextPath}/img/no.png"
										title="Model Disabled" id="unMatched"
										style="vertical-align: middle; margin-left: 10px; display: none;" />
								</div>
							</div>
							<!-- end of block -->
						</div>			
						<div class="row ibsClass" style="display: none;">
							<div class="span12">
								<div class="form-row">
									<p style="padding: 6px 0;">
										<s:property value="requestDetails.principal.principalBuUniteCd" />
										<s:property value="requestDetails.principal.principalAccDistNo" />
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
							             <p id="ibsMessage"><s:property value="requestDetails.principal.IBSSystMsg"/></p>
							             <p id="ibsContact"><s:text name="label.request.ibsContact" /> <s:property value="requestDetails.principal.IBSLastName"/>, <s:property value="requestDetails.principal.IBSFirstName"/> </p>
							             <s:hidden name="requestDetails.principal.IBSSystMsg" id="ibsSystemMsg"/>
										 <s:hidden name="requestDetails.principal.IBSMsgId" id="ibsSystemMsgId"/>
										 <s:hidden name="requestDetails.principal.IBSLastName" id="ibsLNameId"/>
										 <s:hidden name="requestDetails.principal.IBSFirstName" id="ibsFNameId"/>
										 <s:hidden name="requestDetails.principal.IBSPhoneNo" id="ibsPhoneId"/>
						             </div>
					             </div>
					         </div>
					   </div>
					</c:when>
					
					<c:otherwise>
						<div class="row">
								<div class="span2">
									<div class="form-row">
										<label><s:text name="label.request.principalBUC"/> :</label>
									</div>
								</div>
								<div class="span5 left">
									<div class="form-row">
										<p class="padding40"  id="pBUC"><s:property value="requestDetails.principal.principalBuUniteCd"/></p>
									</div>
								</div>
						</div>
						<div class="row">
								<div class="span2">
									<div class="form-row">
										<label><s:text name="label.request.principalADN"/> :</label>
									</div>
								</div>
								<div class="span5 left">
									<div class="form-row">
										<p class="padding40"  id="pADN"><s:property value="requestDetails.principal.principalAccDistNo"/></p>
									</div>
								</div>
						</div>
					</c:otherwise>
				</c:choose>
				</c:if>
				<s:set name="refDetailsList" value="requestDetails.principal.refDetails" />
				<c:if test="${requestDetails.WFDetails.WFStage eq 'REQEST'}">
					<s:if test="%{requestDetails.principal.requiresEdits}">
						<div class="row">
							<div class="span2">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<s:property value="requestDetails.principal.sendBackNotes" />
									</p>
								</div>
							</div>
			
						</div>
					</s:if>
				</c:if>
			
