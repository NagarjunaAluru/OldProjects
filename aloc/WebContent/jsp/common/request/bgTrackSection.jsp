<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


					<c:set var="isrequireEditSecDiv" value="false"/>
						
						<s:if test="%{requestDetails.transactionParties.requiresEdits && requestDetails.transactionParties.sendBackNotes != null && requestDetails.transactionParties.sendBackNotes !=''}">
							<c:set var="isrequireEditSecDiv" value="true"/>
						</s:if>
						<s:if
							test="%{requestDetails.transactionParties.tpApplicantDetails.requiresEdits && requestDetails.transactionParties.tpApplicantDetails.sendBackNotes != null && requestDetails.transactionParties.tpApplicantDetails.sendBackNotes !=''}">
							<c:set var="isrequireEditSecDiv" value="true"/>
						</s:if>
						<s:if
							test="%{requestDetails.transactionParties.triPartyApplicant.requiresEdits && requestDetails.transactionParties.triPartyApplicant.sendBackNotes != null && requestDetails.transactionParties.triPartyApplicant.sendBackNotes !=''}">
							<c:set var="isrequireEditSecDiv" value="true"/>
						</s:if>
						<s:if
							test="%{requestDetails.transactionParties.customer.addressDtls.requiresEdits && requestDetails.transactionParties.customer.addressDtls.sendBackNotes != null && requestDetails.transactionParties.customer.addressDtls.sendBackNotes !=''}">
							<c:set var="isrequireEditSecDiv" value="true"/>
						</s:if>
						<s:if test="%{requestDetails.projDescription.requiresEdits && requestDetails.projDescription.sendBackNotes != null && requestDetails.projDescription.sendBackNotes !=''}">
							<c:set var="isrequireEditSecDiv" value="true"/>
						</s:if>
						<s:if test="%{requestDetails.instrumentDetails.requiresEdits && requestDetails.instrumentDetails.sendBackNotes != null && requestDetails.instrumentDetails.sendBackNotes !=''}">
							<c:set var="isrequireEditSecDiv" value="true"/>
						</s:if>
						<s:if test="%{requestDetails.instrumentRisk.requiresEdits && requestDetails.instrumentRisk.sendBackNotes != null && requestDetails.instrumentRisk.sendBackNotes !=''}">
							<c:set var="isrequireEditSecDiv" value="true"/>
						</s:if>
						<s:if test="%{requestDetails.SBLC.requiresEdits && requestDetails.SBLC.sendBackNotes != null && requestDetails.SBLC.sendBackNotes !=''}">
							<c:set var="isrequireEditSecDiv" value="true"/>
						</s:if>
						<s:if test="%{requestDetails.instrReporting.requiresEdits && requestDetails.instrReporting.sendBackNotes != null && requestDetails.instrReporting.sendBackNotes !=''}">
							<c:set var="isrequireEditSecDiv" value="true"/>
						</s:if>
						<s:if test="%{requestDetails.deliveryInstructions.requiresEdits && requestDetails.deliveryInstructions.sendBackNotes != null && requestDetails.deliveryInstructions.sendBackNotes !=''}">
							<c:set var="isrequireEditSecDiv" value="true"/>
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
								<label><s:text name="label.request.editSections" />: </label>

								<s:iterator value="editSectionList">
									<s:if test="%{name=='request.section.tripartyFlag'}">
										<p id="transactionParties" class="tracking_section_flip">
											<a href="javascript:;"><s:text
													name="label.request.bglocSectionName.1" /></a>
										</p>
									</s:if>
									<s:if test="%{name=='request.section.tpapplicant'}">
										<p id="transactionParties" class="tracking_section_flip">
											<a href="javascript:;"><s:text
													name="label.request.applicant" /></a>
										</p>
									</s:if>
									<s:if test="%{name=='request.section.tripartyAddress'}">
										<p id="transactionParties" class="tracking_section_flip">
											<a href="javascript:;"><s:text
													name="label.request.triPartyApplicant" /></a>
										</p>
									</s:if>
									<s:if test="%{name=='request.section.tpCustomerbeneficiary'}">
										<p id="transactionParties" class="tracking_section_flip">
											<a href="javascript:;"><s:text
													name="label.request.customer" /></a>
										</p>
									</s:if>
									
									<s:if test="%{name=='request.section.projectDescription'}">
										<p id="projectDescription" class="tracking_section_flip">
											<a href="javascript:;"><s:text
													name="label.request.bglocSectionName.2" /></a>
										</p>
									</s:if>
									<s:if test="%{name=='request.section.instrumentDetails'}">
										<p id="instrumentDetails" class="tracking_section_flip">
											<a href="javascript:;"><s:text
													name="label.request.bglocSectionName.3" /></a>
										</p>
									</s:if>
									<s:if test="%{name=='request.section.instrumentRisk'}">
										<p id="instrumentRisk" class="tracking_section_flip">
											<a href="javascript:;"><s:text
													name="label.request.bglocSectionName.4" /></a>
										</p>
									</s:if>
									<s:if test="%{name=='request.section.standbyLetterofCredit'}">
										<p id="locConditions" class="tracking_section_flip">
											<a href="javascript:;"><s:text
													name="label.request.bglocSectionName.5" /></a>
										</p>
									</s:if>
									<s:if test="%{name=='request.section.instrumentReporting'}">
										<p id="instrumentReporting" class="tracking_section_flip">
											<a href="javascript:;"><s:text
													name="label.request.bglocSectionName.6" /></a>
										</p>
									</s:if>
									<s:if test="%{name=='request.section.format'}">
										<p id="formatSectionFlip" class="tracking_section_flip">
											<a href="javascript:;"><s:text
													name="label.request.bglocSectionName.7" /></a>
										</p>
									</s:if>
									<s:if test="%{name=='request.section.deliveryInstructions'}">
										<p id="deliveryInstructions" class="tracking_section_flip">
											<a href="javascript:;"><s:text
													name="label.request.bglocSectionName.8" /></a>
										</p>
									</s:if>
									<s:if test="%{name=='request.section.attachments'}">
										<p id="attachmentsFlip" class="tracking_section_flip">
											<a href="javascript:;"><s:text
													name="label.request.bglocSectionName.9" /></a>
										</p>
									</s:if>
								</s:iterator>
								<br/>
								<br/>
									<div class="form-row" style="margin-left:50px;">
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
									    <label><s:text name="label.request.requireEditsDetails" />: </label>
									    <s:if test="%{requestDetails.transactionParties.requiresEdits}">
											<p class="requiresEdits"><s:text name="label.request.bglocSectionName.1" /></p>
										</s:if>
										<s:if test="%{requestDetails.transactionParties.tpApplicantDetails.requiresEdits}">
											<p class="requiresEdits"><s:text name="label.request.applicant" /></p>
										</s:if>
										<s:if test="%{requestDetails.transactionParties.triPartyApplicant.requiresEdits}">
											<p class="requiresEdits"><s:text name="label.request.triPartyApplicant" /></p>
										</s:if>
										<s:if test="%{requestDetails.transactionParties.customer.addressDtls.requiresEdits}">
											<p class="requiresEdits"><s:text name="label.request.customer" /></p>
										</s:if>
			                            <s:if test="%{requestDetails.projDescription.requiresEdits}">
											<p class="requiresEdits"><s:text name="label.request.bglocSectionName.2" /></p>
										</s:if>
										<s:if test="%{requestDetails.instrumentDetails.requiresEdits}">
											<p class="requiresEdits"><s:text name="label.request.bglocSectionName.3" /></p>
										</s:if>
										<s:if test="%{requestDetails.instrumentRisk.requiresEdits}">
											<p class="requiresEdits"><s:text name="label.request.bglocSectionName.4" /></p>
										</s:if>
										<s:if test="%{requestDetails.SBLC.requiresEdits}">
											<p class="requiresEdits"><s:text name="label.request.bglocSectionName.5" /></p>
										</s:if>
										<s:if test="%{requestDetails.instrReporting.requiresEdits}">
											<p class="requiresEdits"><s:text name="label.request.bglocSectionName.6" /></p>
										</s:if>
										<s:if test="%{requestDetails.deliveryInstructions.requiresEdits}">
											<p class="requiresEdits"><s:text name="label.request.bglocSectionName.8" /></p>
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
						</div> <!-- end of block -->
					</div>
				</div>
			</c:if>

