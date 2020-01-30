<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<fmt:setLocale value="en-US"/>
		
		<h2>Settlement Details</h2>
        <div class="clear"></div>

			
			
		<div class="form-mod entitylookup">

				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Gross Settlement amount</label>
							<div class="radio-container" >
							 <input type="hidden"  name="legSummary.grossSettlementAmt" id="grossSettlementAmt" 
							 value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.grossSettlementAmt}" />"/>
								<span class="grosssSet"></span>
							</div>
						</div>
					</div> <!-- end of block -->
					
				</div>

                                
				
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label>Payor
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								<span  class="help-block error" id="payorInfofailed" style="display:none;">Please enter Payor</span>
								<span  class="help-block notfound error" id="payorInfoInvalid" style="display:none;">Invalid value </span>
								
								<select class="span14 cpa-search-id entity-filtername" id="payorSearchId">
									<option value="CDR">CDR</option>
									<option value="GOLD">Gold ID</option>
								</select>
								
								
								<input type="text" name="legSummary.payorEntity.LEGoldId" id="payorGoldId" value="<bean:write name="ICFPLegRequestForm" property="legSummary.payorEntity.LEGoldId" />" maxlength="9" class="span3 entity-filtervalue" data-cmd="getLE" id="payor" style="text-transform:uppercase"/>
								<span id="payorInfofailedBar" class="req-error" style="display:none;">error</span>
								<a href="#searchByPayorGoldId" class="btn entity-lookup novalidate" data-cmd="getLE" type="submit" id="searchByPayorGoldId">Search</a>
								<label class="checkbox info-checkbox pending">
									<html:checkbox name="ICFPLegRequestForm" property="legSummary.payorEntity.entitySetupFlag" value = "Y" styleClass="" styleId="payorEntitySetupFlag"/>
									Legal Entity Setup Pending
								</label>
								<a class="btn-link right clear-conditional-results" id="payorClear" href="#" type="submit"onclick="javascript:clearPayorDetails();"></a>
							</div>
						</div> <!-- end of block -->
					</div> 
					<div id="payorGoldIdDetails" class="conditional-row">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.payorEntity.CDRCd">
										<p class="cdrCd">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.payorEntity.CDRCd">
										<p class="cdrCd"><bean:write name="ICFPLegRequestForm" property="legSummary.payorEntity.CDRCd"/></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.payorEntity.LEGoldId">
										<p class="leGoldId">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.payorEntity.LEGoldId">
										<p class="leGoldId"><bean:write name="ICFPLegRequestForm" property="legSummary.payorEntity.LEGoldId" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName"/></b></p>
									<logic:empty  name="ICFPLegRequestForm" property="legSummary.payorEntity.LEName" >
										<p class="leName">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.payorEntity.LEName">
										<p class="leName"><bean:write name="ICFPLegRequestForm" property="legSummary.payorEntity.LEName" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.payorEntity.LEName" styleClass="leName" />
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.payorEntity.country">
										<p class="country">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.payorEntity.country">
										<p class="country"><bean:write name="ICFPLegRequestForm" property="legSummary.payorEntity.country" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.payorEntity.country" styleClass="country" />
								</div>
							</div><!-- end of block -->
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.payorEntity.CDRCd" styleId="payorLegalEntityGoldId" styleClass="cdrCd" />
						<html:hidden name="ICFPLegRequestForm" property="legSummary.payorEntity.LEGoldId" styleId="payorLEGoldId" styleClass="leGoldId" />
						</div>
						
						<div id="borrowerPEorMEDiv">
						<div class="row ">
							<div class="span5">
								<div class="form-row">
									<p><b><span class="condition-payorReg required">*</span>Is Payor a Regulated Entity?</b></p>
									<div id ="payorRegDiv" class="radio-container regulatedEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.payorEntity.regulatedEntityFlag" styleId="payorRegulatedEntityFlag1" disabled="disabled" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.payorEntity.regulatedEntityFlag" styleId="payorRegulatedEntityFlag2" disabled="disabled" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
										<html:hidden name="ICFPLegRequestForm" property="legSummary.payorEntity.regulatedEntityFlag" styleClass="regulatedEntityFlag" />
									</div>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><span class="condition-payorPrn required">*</span>Is Payor a Principal Entity?</b></p>
									<div id ="payorPriDiv" class="radio-container princplEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.payorEntity.princplEntityFlag" styleId="payorPrincplEntityFlag1" disabled="disabled" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.payorEntity.princplEntityFlag" styleId="payorPrincplEntityFlag2" disabled="disabled" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
										<html:hidden name="ICFPLegRequestForm" property="legSummary.payorEntity.princplEntityFlag" styleClass="princplEntityFlag" />
									</div>
									
								</div>
							</div><!-- end of block -->
						</div>
					
					</div> 
						
				
			
			<div class="row MESearch">
				<div class="span5">
					<div  class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
						<span  class="help-block error" id="payorMgmtfailed" style="display:none;">Please select Management Entity </span>
						
						<input type="text" class="span2" style="text-transform:uppercase" maxlength="20"/>
 						<a href="#1a" class="btn me-lookup" type="submit">Search</a>
						<a href="#1a" class="btn-link clear-conditional-results">Clear results</a>
						
 						<span id="payorMgmtfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div  id="payorCapitalDiv" class="span5 right">
					<div class="form-row" >
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<div class="radio-container" id="newBorrowerCap">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.payorEntity.capitalIndustrial" >
								<p class="capitalIndustrial">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.payorEntity.capitalIndustrial" >
								<div id="payorSetUpFlagTDiv" style="display: none;">
									<p class="capitalIndustrial">-</p>
								</div>
								<div id="payorSetUpFlagFDiv" style="display: none;">
									<p class="capitalIndustrial"><bean:write name="ICFPLegRequestForm" property="legSummary.payorEntity.capitalIndustrial" /></p>
								</div>
							</logic:notEmpty>
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.payorEntity.capitalIndustrial" styleId="payorCapOrIndustrial" styleClass="capitalIndustrial"/>
					</div>
				</div> <!-- end of block -->
			</div>
			
			<div class="ME conditional-row">
				<div class="row highlighted">
				<div class="span3">
					<div class="form-row">						
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.payorEntity.MEName" /></p>
						<input class="meValue" id="selectedPayorMgmtEntity" type="hidden" name="legSummary.payorEntity.MEName" value="<bean:write name="ICFPLegRequestForm" property="legSummary.payorEntity.MEName" />"/>
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
						<span  class="help-block error" id="payorTreasuryInvalid" style="display:none;">Invalid value</span>
						<input type="text" class="span3" data-provide="typeahead"  id="payorTreasuryCode" style="text-transform:uppercase"/>
						
						<span id="payorTreasuryfailedBar" class="req-error" style="display:none;">error</span>
						
						<a class="btn addtcode alwaysone" type="submit" data-assign="legSummary.payorTCodeEntity.treasuryCode">Search</a>
						<a class="btn-link right clear-conditional-results" href="#" type="submit" ><bean:message key="label.addLeg.clearResults"/></a>
						
						
					</div>
				</div> <!-- end of block -->
				<div id="newBorBusSegDiv" class="span5 right">
					<div class="form-row">
						<label>Business Segment
						</label>
						<div class="radio-container" id="newBorBusSegConDiv">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.payorEntity.businessSegment" >
								<p class="businessSegment">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.payorEntity.businessSegment" >
								<div id="payorBusSegTDiv" style="display: none;">
									<p class="businessSegment">-</p>
								</div>
								<div id="payorBusSegFDiv">
									<p class="businessSegment"><bean:write name="ICFPLegRequestForm" property="legSummary.payorEntity.businessSegment" /></p>
								</div>
							</logic:notEmpty>
							<html:hidden name="ICFPLegRequestForm" property="legSummary.payorEntity.businessSegment" styleClass="businessSegment" />
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row highlighted conditional-row" id="payorTreasuryDetails">
				<div class="span5">
					<div class="form-row tcode">
						<p><b><bean:message key="label.addLeg.treasuryCode" /></b></p>
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.payorTCodeEntity.treasuryCode" /></p>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.payorTCodeEntity.treasuryCode" styleId="borrowerTreasuryGoldId" />
					</div>
				</div><!-- end of block -->
				<html:hidden name="ICFPLegRequestForm" property="legSummary.payorTCodeEntity.LEGoldId" styleId="payorTreasuryGoldId" />
			</div>
			
			<html:hidden name="ICFPLegRequestForm" property="legSummary.payorTCodeEntity.treasuryCode" styleId="payorTreasuryCode1" />
			<div class="row">
				<div class="span5 right">
					<div class="form-row">
						<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
						 <html:select name="ICFPLegRequestForm" property="legSummary.payorEntity.fundHoldOperationId" styleClass="span2" styleId="SelectedPayorFunCompany">
							<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
							<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
 						</html:select>  
						<span id="payorTreasuryfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			
			</div>
		</div>