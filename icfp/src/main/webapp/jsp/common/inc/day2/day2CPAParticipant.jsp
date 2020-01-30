<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>

<div class="form-mod entitylookup">
			
			<h3>Participant</h3>
			
				<div id="1" class="tab-content">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label>Participant
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								<span  class="help-block error" id="lenderInfofailed" style="display:none;">Please enter Lender/Provider </span>
								<span  class="help-block error notfound" id="lenderInfoInvalid" style="display:none;">Invalid value </span>
								<span  class="help-block error" id="lenderDiffFailed" style="display:none;">Lender/Provider & Borrower/Recipient must be different</span>
							
								<select class="span14 cpa-search-id entity-filtername"  id="searchID">
									<option>CDR</option>
									<option>Gold ID</option>
								</select>
								
								<input type="text" name="cpaSummary.participantEntity.LEGoldId typeahead ajax" data-cmd="getLE" value="<bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEGoldId" />" maxlength="9" class="span3 entity-filtervalue" id="lenderOrProvider" style="text-transform:uppercase"/>
								<span id="lenderInfofailedBar" class="req-error" style="display:none;">error</span>
								<a href="#1" class="btn entity-lookup" type="submit" data-cmd="getLE">Search</a>
								<label class="checkbox info-checkbox pending ">
									<html:checkbox name="cpaLegRequestForm" property="cpaSummary.participantEntity.entitySetupFlag" styleClass="" styleId="lenderEntitySetupFlag" value="Y"/>
									Legal Entity Setup Pending
								</label>
								<a class="btn-link right  clear-conditional-results" href="#" type="submit" id="clearParIdDiv"  onclick="javascript:clearLEDetails();">Clear results</a>
							</div>
						</div> <!-- end of block -->
					</div> 
					<div id="participantDetailsDiv" class="conditional-row">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<logic:empty name="cpaLegRequestForm" property="cpaSummary.participantEntity.CDRCd">
										<p class="cdrCd">-</p>
									</logic:empty>
									<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.participantEntity.CDRCd">
										<p class="cdrCd"><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.CDRCd"/></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<logic:empty name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEGoldId">
										<p class="leGoldId">-</p>
									</logic:empty>
									<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEGoldId">
										<p class="leGoldId"><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEGoldId" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<logic:empty name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEName">
										<p class="leName">-</p>
									</logic:empty>
									<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEName">
										<p class="leName"><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEName" /></p>
									</logic:notEmpty>
									<input type="hidden" name="cpaSummary.participantEntity.LEName" class="leName"/>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<logic:empty  name="cpaLegRequestForm" property="cpaSummary.participantEntity.country">
										<p class="country">-</p>
									</logic:empty>
									<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.participantEntity.country">
										<p class="country"><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.country" /></p>
									</logic:notEmpty>
									<input type="hidden" name="cpaSummary.participantEntity.country" class="country"/>
								</div>
							</div><!-- end of block -->
						</div>
						<html:hidden name="cpaLegRequestForm" property="cpaSummary.participantEntity.CDRCd" styleId="lenderLegalEntityGoldId" styleClass="cdrCd" />
						<html:hidden name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEGoldId" styleId="LEGoldId" styleClass="leGoldId"/>
						</div>
						
						<div id="lenderPEorMEDiv">
						<div class="row ">
							<div class="span5">
								<div class="form-row">
									<p><b>Is Participant a Regulated Entity?</b></p>

									<div id ="lenderRegDiv" class="radio-container regulatedEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="cpaLegRequestForm" property="cpaSummary.participantEntity.regulatedEntityFlag" styleId="regulatedEntityFlag1" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="cpaLegRequestForm" property="cpaSummary.participantEntity.regulatedEntityFlag" styleId="regulatedEntityFlag2" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
									</div>
									
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b>Is Participant a Principal Entity?</b></p>
									
									<div id ="lenderPriDiv" class="radio-container princplEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="cpaLegRequestForm" property="cpaSummary.participantEntity.princplEntityFlag" styleId="princplEntityFlag1" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="cpaLegRequestForm" property="cpaSummary.participantEntity.princplEntityFlag" styleId="princplEntityFlag2" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
									</div>
									
								</div>
							</div><!-- end of block -->
						</div>
					
					</div> 
						
				</div>

			<div class="row MESearch">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Management Entity</label>
						<span  class="help-block error" id="lenderMgmtfailed" style="display:none;">Please select Management Entity </span>
						
						<input type="text" class="span2" style="text-transform:uppercase"/>
						<span id="lenderMgmtfailedBar" class="req-error" style="display:none;">error</span>

						<a href="#1" class="btn me-lookup" type="submit">Search</a>
						
						<a href="#1" class="btn-link clear-conditional-results">Clear results</a>
					</div>
				</div> <!-- end of block -->
				<div id="lenderCapitalDiv" class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<div class="radio-container" id="lenderCap">
							<logic:empty name="cpaLegRequestForm" property="cpaSummary.participantEntity.capitalIndustrial" >
								<p class="capitalIndustrial">-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.participantEntity.capitalIndustrial" >
								<div id="LenderSetUpFlagTDiv" style="display: none;">
									<p class="capitalIndustrial">-</p>
								</div>
								<div id="LenderSetUpFlagFDiv" style="display: none;">
									<p class="capitalIndustrial"><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.capitalIndustrial" /></p>
								</div>
							</logic:notEmpty>
						</div>
						<html:hidden name="cpaLegRequestForm" property="cpaSummary.participantEntity.capitalIndustrial" styleId="lenderCapOrIndustrial" styleClass="capitalIndustrial" />
					</div>
				</div>
				
				</div>
			
			<div class="ME conditional-row">
				<div class="row highlighted">
				<div class="span3">
					<div class="form-row">						
						<p><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.MEName" /></p>
						<input class="meValue" id="selectedLenderMgmtEntity"  type="hidden" name="cpaSummary.participantEntity.MEName" value="<bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.MEName" />"/>
					</div>					
				</div>		
				</div>			
			</div>
				
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label><bean:message key="label.addLeg.treasuryCode" />
							<span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span>
						</label>
						<span  class="help-block notfound error" id="lenderTreasuryInvalid" style="display:none;">Invalid value</span>
					    <input type="text" maxlength="20" name="treasuryCode"  id="lenderTreasuryCode"  style="text-transform:uppercase"/> 
					    <span id="lenderTreasuryfailedBar" class="req-error" style="display:none;">error</span>
						<a class="btn addtcode" type="submit" data-assign="cpaSummary.participantTCodeEntities">Search</a>
					
						<a id="clearLenderTreasury" class="btn-link right" href="#" type="submit" onclick="javascript:clearTreasuryDetails();"><bean:message key="label.addLeg.clearResults" /></a> 
				   </div>
				</div> <!-- end of block -->
				<div id="lenBusSegDiv" class="span5 right">
					<div class="form-row">
						<label>Business Segment
						</label>
						<div class="radio-container" id="lenBusSegConDiv">
							<logic:empty name="cpaLegRequestForm" property="cpaSummary.participantEntity.businessSegment" >
								<p class="businessSegment">-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.participantEntity.businessSegment" >
								<div id="lenBusSegTDiv" style="display: none;">
									<p class="businessSegment">-</p>
								</div>
								<div id="lenBusSegFDiv" style="display: none;">
									<p class="businessSegment"><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.businessSegment" /></p>
								</div>
							</logic:notEmpty>
							<input type="hidden" name="cpaSummary.participantEntity.businessSegment" class="businessSegment" value="<bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.businessSegment" />"/>
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
			
				
			<div class="row highlighted conditional-row" id="lenderTreasuryDetails">
				<div class="span5">
					<div class="form-row tcode">
						<p><b><bean:message key="label.addLeg.treasuryCode"/></b></p>
						
						<p>
							<c:if test="${not empty cpaLegRequestForm.map['cpaSummary'].map['participantTCodeEntities']}">
								<logic:iterate id="lenderTreasuryCode" name="cpaLegRequestForm" property="cpaSummary.participantTCodeEntities">
									<input type="hidden" name="participantTCodeEntities" value="${lenderTreasuryCode}">
                          			${lenderTreasuryCode}<br>
                       			</logic:iterate>
                      			</c:if>
                      		</p> 
						
					<p><html:hidden  name="cpaSummaryForm" property="participantTCodeEntities"  value="3" ></html:hidden></p>
					</div>
				</div><!-- end of block -->
			</div>

			<div class="row">
				<div class="span5 right">
					<div class="form-row">
						<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
						 <html:select name="cpaLegRequestForm" property="cpaSummary.participantEntity.fundHoldOperationId" styleClass="span2" styleId="selectedFunCompany">
							<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
							<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
 						</html:select>  
						<span id="lenderTreasuryfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
		</div><!-- end of form form-mod -->
		<html:hidden  name="cpaSummaryForm" property="participantTCodeEntities"  value="3" ></html:hidden>
		<%-- <html:hidden name="cpaLegRequestForm" property="cpaSummary.participantTCodeEntity.LEGoldId" styleId="lenderTreasuryGoldId" /> --%>
		
		<div class="modal hide fade" id="lookup">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Lookup Results</h3>
		</div>
		<div class="modal-body">
			<div class="alert fade in alert-danger hide">
            	<a href="#" data-dismiss="alert" class="close">X</a>
            	<strong>Select one to save.</strong> 
        	</div>
			<div class="form-row autosize-container">
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn right btn-success saveSelectEntity">Save selection</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Cancel</a>
		</div>
	</div>