<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	
				<c:set var="isrequireEditSecDiv" value="false" />
				<c:if test="%{requestDetails.bondDetails.requiresEdits  && requestDetails.bondDetails.sendBackNotes != null}">
					<c:set var="isrequireEditSecDiv" value="true" />
				</c:if>
				<s:if test="%{requestDetails.principal.requiresEdits && requestDetails.principal.sendBackNotes != null && requestDetails.principal.sendBackNotes !=''}">
					<c:set var="isrequireEditSecDiv" value="true" />
				</s:if>
				<s:if test="%{requestDetails.obligee.requiresEdits && requestDetails.obligee.sendBackNotes != null && requestDetails.obligee.sendBackNotes != ''}">
					<c:set var="isrequireEditSecDiv" value="true" />
				</s:if>
				<s:if test="%{requestDetails.bondReqDtls.requiresEdits && requestDetails.bondReqDtls.sendBackNotes != null && requestDetails.bondReqDtls.sendBackNotes != ''}">
					<c:set var="isrequireEditSecDiv" value="true" />
				</s:if>
				<s:if test="%{requestDetails.addressDtls.requiresEdits && requestDetails.addressDtls.sendBackNotes != null && requestDetails.addressDtls.sendBackNotes !=''}">
					<c:set var="isrequireEditSecDiv" value="true" />
				</s:if>
				<s:if test="%{requestDetails.deliveryInstructions.requiresEdits && requestDetails.deliveryInstructions.sendBackNotes != null && requestDetails.deliveryInstructions.sendBackNotes !=''}">
					<c:set var="isrequireEditSecDiv" value="true" />
				</s:if>
				<s:if test="%{requestDetails.bondInfo.requiresEdits && requestDetails.bondInfo.sendBackNotes != null && requestDetails.bondInfo.sendBackNotes != ''}">
					<c:set var="isrequireEditSecDiv" value="true" />
				</s:if>
				<s:if test="%{requestDetails.bondInfo.attorneyRequiresEdits && requestDetails.bondInfo.attorneySendBackNotes != null && requestDetails.bondInfo.attorneySendBackNotes != ''}">
					<c:set var="isrequireEditSecDiv" value="true" />
				</s:if>
				<s:if test="%{requestDetails.format.requiresEdits && requestDetails.format.sendBackNotes != null && requestDetails.format.sendBackNotes != ''}">
					<c:set var="isrequireEditSecDiv" value="true" />
				</s:if>
				<s:if test="%{requestDetails.attachments[0].requiresEdits && requestDetails.attachments[0].sendBackNotes != null && requestDetails.attachments[0].sendBackNotes != ''}">
					<c:set var="isrequireEditSecDiv" value="true" />
				</s:if>
				<c:if test="${fn:length(editSectionList) gt 0 or isrequireEditSecDiv eq 'true'}">
					<div class="row highlighted">
						<div class="span12">
							<s:if test="%{editSectionList.size > 0}">
							<div class="row">
								<div class="span5 wbg">
									<div class="form-row">
										<label><s:text name="label.request.editSections" />:
										</label>

										<s:iterator value="editSectionList">
											<%-- <s:if test="%{name=='request.section.bondDetails'}">
												<p id="bondDetails" class="tracking_section_flip">
													<a href="javascript:;"><s:text
															name="label.request.sbSectionBondDetails" /></a>
												</p>
											</s:if> --%>
											<s:if test="%{name=='request.section.bondDetails'}">
												<p id="bondDetails" class="tracking_section_flip">
													<a href="javascript:;"><s:text	name="label.request.bondType" /></a>
												</p>
											</s:if>
											<%-- <s:if test="%{name=='request.section.obligee'}">
												<p id="obligee" class="tracking_section_flip">
													<a href="javascript:;"><s:text
															name="label.request.sbSectionObligee" /></a>
												</p>
											</s:if> --%>
											<s:if
												test="%{name=='request.section.requestorMailingAddress'}">
												<p id="requestorMailingAddress"
													class="tracking_section_flip">
													<a href="javascript:;"><s:text
															name="label.request.sbSectionRequestorMailingAddress" /></a>
												</p>
											</s:if>
											<s:if test="%{name=='request.section.deliveryInstructions'}">
												<p id="deliveryInstructions" class="tracking_section_flip">
													<a href="javascript:;"><s:text
															name="label.request.sbSectionDeliveryInstructions" /></a>
												</p>
											</s:if>
											<s:if test="%{name=='request.section.bondInformation'}">
												<p id="bondInformation" class="tracking_section_flip">
													<a href="javascript:;"><c:if test="${requestDetails.bondDetails.bondTypeId eq '4'}">
														<s:text name="label.request.sbSectionCourtBondDetails" />
													</c:if>
													<c:if test="${requestDetails.bondDetails.bondTypeId ne '4'}">
														<s:text name="label.request.sbSectionBondInformation" />
													</c:if></a>
												</p>
											</s:if>
											<s:if
												test="%{name=='request.section.attorneyBondInformation'}">
												<p id="attorneyBondInformation"
													class="tracking_section_flip">
													<a href="javascript:;"><s:text
															name="label.request.sbSectionAttorneyInformation" /></a>
												</p>
											</s:if>
											<s:if test="%{name=='request.section.format'}">
												<p id="format" class="tracking_section_flip">
													<a href="javascript:;"><s:text
															name="label.request.sbSectionFormat" /></a>
												</p>
											</s:if>
											<s:if test="%{name=='request.section.attachments'}">
												<p id="attachments" class="tracking_section_flip">
													<a href="javascript:;"><s:text
															name="label.request.sbSectionAttachments" /></a>
												</p>
											</s:if>
										</s:iterator>
										<br /> <br />
										<div class="form-row" style="margin-left: 50px;">
											<s:url id="cancelAllURL" action="cancelAll" />
											<s:a href="%{cancelAllURL}" cssClass="btn-tertiary cancel">
												<s:text name="label.request.cancelAllChanges" />
											</s:a>
										</div>
									</div>
								</div>
							</div>
							</s:if>
							<div class="row" id="requireEditSecDiv">
								<c:if test="${isrequireEditSecDiv eq 'true'}">
									<div class="span5 wbg">
										<div class="form-row">
											<label><s:text
													name="label.request.requireEditsDetails" />: </label>
											<s:if test="%{requestDetails.bondDetails.requiresEdits}">
												<p class="requiresEdits">
													<s:text name="label.request.sbSectionBondDetails" />
												</p>
											</s:if>
											<s:if test="%{requestDetails.principal.requiresEdits}">
												<p class="requiresEdits">
													<s:text	name="label.request.bondType" />
												</p>
											</s:if>
											<s:if test="%{requestDetails.obligee.requiresEdits}">
												<p class="requiresEdits">
													<s:text name="label.request.sbSectionObligee" />
												</p>
											</s:if>
											<s:if test="%{requestDetails.addressDtls.requiresEdits}">
												<p class="requiresEdits">
													<s:text
														name="label.request.sbSectionRequestorMailingAddress" />
												</p>
											</s:if>
											<s:if
												test="%{requestDetails.deliveryInstructions.requiresEdits}">
												<p class="requiresEdits">
													<s:text name="label.request.sbSectionDeliveryInstructions" />
												</p>
											</s:if>
											<s:if test="%{requestDetails.bondInfo.requiresEdits}">
												<p class="requiresEdits">
													<c:if test="${requestDetails.bondDetails.bondTypeId eq '4'}">
														<s:text name="label.request.sbSectionCourtBondDetails" />
													</c:if>
													<c:if test="${requestDetails.bondDetails.bondTypeId ne '4'}">
														<s:text name="label.request.sbSectionBondInformation" />
													</c:if>
												</p>
											</s:if>
											<s:if test="%{requestDetails.bondInfo.attorneyRequiresEdits}">
												<p class="requiresEdits">
													<s:text name="label.request.sbSectionAttorneyInformation" />
												</p>
											</s:if>
											
											<s:if test="%{requestDetails.format.requiresEdits}">
												<p class="requiresEdits">
													<s:text	name="label.request.sbSectionFormat" />
												</p>
											</s:if>
											<s:if test="%{requestDetails.attachments[0].requiresEdits}">
												<p class="requiresEdits">
													<s:text	name="label.request.sbSectionAttachments" />
												</p>
											</s:if>
										</div>
									</div>
								</c:if>
							</div>	<!-- end of block -->
						</div>
					</div>
				</c:if>