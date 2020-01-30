<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<div class="form-mod entitylookup">
<!-- Edit Mode -->
<c:choose>
		<c:when test="${param.day eq 'day2'}"> 
			<h2 class="span12">Original Transaction Details</h2>
			<div class="clear"></div>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<label>Product Type</label>
				<div class="radio-container">Cash Pool</div>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right ">
		<div class="row">
			<div class="form-row">
						<label>Vault Request ID</label>
						<c:if test="${param.tab eq 'REQ'}">
							<logic:messagesPresent property="vaultId">
								<span class="req-error" >a</span>
							  </logic:messagesPresent>
							<html:text name="cpaLegRequestForm" style="float:left;"  property="vaultId"  onkeyup="javascript:validateVaultDetails()"  styleId="vaultTextID" maxlength="50"   />
							<a href="#vaultRequestScreenID" id="valultReqIDLookupID"  onclick="javascript:getVaultDetails()"  class="initiate btn right cancel" style="float:left;"> Lookup</a>
						</c:if>
						<c:if test="${param.tab eq 'FO'}">
							<html:text name="cpaLegRequestForm" style="float:left;" readonly="true" property="vaultId" styleId="vaultTextID" maxlength="50"   />
						</c:if>
					   <div class="clear">
					   </div>
					</div>
		</div>
		<!-- end of block -->
	</div>
</div>
		</c:when>
		<c:otherwise>
			<h2 class="span12">Details</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>Vault Request ID</label>
						<logic:messagesPresent property="vaultId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="cpaLegRequestForm" style="float:left;"  property="vaultId"  onkeyup="jacascript:validateVaultDetails()"  styleId="vaultTextID" maxlength="50"   />
						<a href="#vaultRequestScreenID" id="valultReqIDLookupID"  onclick="javascript:getVaultDetails()"  class="initiate btn right cancel" style="float:left;"> Lookup</a>
					   <div class="clear">
					   </div>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	
	
	
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
								<a class="btn-link right  clear-conditional-results" href="#" type="submit" id="clearParIdDiv"  onclick="javascript:clearLEDetails();"></a>
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
									<html:hidden name="cpaLegRequestForm" property="cpaSummary.participantEntity.LEName" styleClass="leName" />
									
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
									<html:hidden name="cpaLegRequestForm" property="cpaSummary.participantEntity.country" styleClass="country" />
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
									<p><b><span class="condition-lenderReg required">*</span>Is Participant a Regulated Entity?</b></p>

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
									<p><b><span class="condition-lenderPrn required">*</span>Is Participant a Principal Entity?</b></p>
									
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
						<label>Management Entity<span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
						<span  class="help-block error" id="lenderMgmtfailed" style="display:none;">Please select Management Entity </span>
						
						<input type="text" class="span2" style="text-transform:uppercase" maxlength="20"/>
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
			
			<div class="ME conditional-row" id="meDetailsID">
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
						<span  class="help-block invalid notfound error" id="lenderTreasuryInvalid" style="display:none;">Invalid value</span>
					    <input type="text" maxlength="20" data-provide="typeahead" data-source="" name="treasuryCode"  id="lenderTreasuryCode"  style="text-transform:uppercase"/> 
					    <span id="lenderTreasuryfailedBar" class="req-error" style="display:none;">error</span>
						
						 <a class="btn addtcode" type="submit" data-assign="cpaSummary.participantTCodeEntities"
						 data-bankassign="cpaSummary.participantEntity.bankTreasuryCd">Search</a>
											
						<a id="clearCPALenderTreasury" class="btn-link right" type="submit" >
							<bean:message key="label.addLeg.clearResults" />
						</a> 
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
							<html:hidden name="cpaLegRequestForm" property="cpaSummary.participantEntity.businessSegment"  styleClass="businessSegment" />
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
			
				
				<div id="lenderTreasuryDetails" class="row conditional-row highlighted">
					<div class="span5">
						<div class="form-row tcode">
							<p><b><bean:message key="label.addLeg.treasuryCode"/></b></p>
							
							<p>
								<c:if test="${not empty cpaLegRequestForm.map['cpaSummary'].map['participantTCodeEntities']}">
									<logic:iterate id="lenderTreasuryCode" name="cpaLegRequestForm" property="cpaSummary.participantTCodeEntities">
										<input type="hidden" name="participantTCodeEntities" value="${lenderTreasuryCode}">
	                          			${lenderTreasuryCode}<br>
	                       			</logic:iterate>
	                       			<input type="hidden" id="showTreasuryCode" value="true"/>
                       			</c:if>
                       		</p> 
							
						<p><html:hidden  name="cpaSummaryForm" property="participantTCodeEntities"  value="" ></html:hidden></p>
						</div>
					</div><!-- end of block -->
					<div class="span5 right">
						<div class="form-row bankName">
							<p><b><bean:message key="label.addLeg.bankName"/></b></p>
							<p>
								<c:if test="${not empty cpaLegRequestForm.map['cpaSummary'].map['participantEntity'].map['bankTreasuryCd']}">
								<c:forEach var="num" items="${fn:split(cpaLegRequestForm.map['cpaSummary'].map['participantEntity'].map['bankTreasuryCd'], ';;')}">
									${num}<br/>
								</c:forEach>
								</c:if>
							</p>
							<html:hidden styleId="participantBankNameID" name="cpaLegRequestForm"  property="cpaSummary.participantEntity.bankTreasuryCd"   />
						</div>
					</div>
				</div>

			<c:if test="${not empty cpaLegRequestForm.map['cpaSummary'].map['participantTCodeEntities']}">
			  <input type="hidden" id="praticipantCodesExists" value="true"/>
			</c:if>
			<c:if test="${empty cpaLegRequestForm.map['cpaSummary'].map['participantTCodeEntities']}">
			  <input type="hidden" id="praticipantCodesExists" value="false"/>
			</c:if>
				
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
		
