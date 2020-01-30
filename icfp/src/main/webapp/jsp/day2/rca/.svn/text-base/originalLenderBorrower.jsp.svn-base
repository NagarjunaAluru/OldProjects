<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<fmt:setLocale value="en-US"/>
		

    <h2 class="span12">Original <logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Lender</logic:equal>
								<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Provider</logic:equal>
								<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Purchaser</logic:equal>
								<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Lender</logic:equal>
								<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Lender</logic:equal></h2>
        <div class="clear"></div>
		<div class="row">
				<div class="span12">        
		<div class="form-mod entitylookup">
			<div id="1" class="tab-content">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label>Original 
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Provider</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Purchaser</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Lender</logic:equal>
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								<span  class="help-block error" id="lenderInfofailed" style="display:none;">Please enter <span class="conditional-lender"></span> </span>
								<span  class="help-block error notfound" id="lenderInfoInvalid" style="display:none;"><bean:message key="label.adLeg.invalidValue" /> </span>
								<span  class="help-block error duplicate" id="lenderDiffFailed" style="display:none;">Legal Entities must be different</span>
								<span  class="help-block error" id="lenIdReq" style="display:none;">Please enter Gold ID or CDR</span>
								
								<select class="span14 cpa-search-id entity-filtername" id="lenderSearchId">
									<option value="CDR"><bean:message key="label.adLeg.cdr" /></option>
									<option value="GOLD"><bean:message key="label.adLeg.goldId" /></option>
								</select>
								
							
								<input type="text" name="legSummary.lenderEntity.LEGoldId" value="<bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEGoldId" />" maxlength="9" class="span3 entity-filtervalue" id="lenderOrProvider" style="text-transform:uppercase"/>
								<html:hidden name= "ICFPLegRequestForm" property="legSummary.lenderEntity.leTypeId" styleId="tempLenderLeTypeId"/>
								<span id="lenderInfofailedBar" class="req-error" style="display:none;">error</span>
								<a href="#1" class="btn entity-lookup" type="submit" data-cmd="getLE">Search</a>
								
									<label class="checkbox info-checkbox pending ">
										<html:checkbox name="ICFPLegRequestForm" property="legSummary.lenderEntity.entitySetupFlag" value="Y" styleClass="" styleId="lenderEntitySetupFlag"/>
										Legal Entity Setup Pending
									</label>
								
								<a class="btn-link right clear-conditional-results" id="orgLenderClear" href="#" type="submit" onclick="javascript:clearLenderDetails();"></a>
							</div>
						</div> <!-- end of block -->
					</div> 
					  <div id="lenderGoldIdDetails" class="conditional-row">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.CDRCd">
										<p class="cdrCd">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.CDRCd">
										<p class="cdrCd"><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.CDRCd"/></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEGoldId">
										<p class="leGoldId">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEGoldId">
										<p class="leGoldId"><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEGoldId" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName">
										<p class="leName">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName">
										<p class="leName"><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEName" styleClass="leName" />
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<logic:empty  name="ICFPLegRequestForm" property="legSummary.lenderEntity.country">
										<p class="country">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.country">
										<p class="country"><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.country" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.country" styleClass="country" />
								</div>
							</div><!-- end of block -->
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.CDRCd" styleId="lenderLegalEntityGoldId" styleClass="cdrCd" />
						<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.LEGoldId" styleId="LEGoldId" styleClass="leGoldId"/>
						</div>
						
						<div id="lenderPEorMEDiv">
						<div class="row ">
							<div class="span5">
								
								<div class="form-row"><p><b>
									<span class="condition-lenderReg required">*</span>Is 
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Provider</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Purchaser</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Lender</logic:equal>
									 a Regulated Entity?</b></p>

									<div id ="lenderRegDiv" class="radio-container regulatedEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.lenderEntity.regulatedEntityFlag" styleId="regulatedEntityFlag1" disabled="disabled" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.lenderEntity.regulatedEntityFlag" styleId="regulatedEntityFlag2" disabled="disabled" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
										<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.regulatedEntityFlag" styleClass="regulatedEntityFlag" />
									</div>
									
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><span class="condition-lenderPrn required">*</span>Is 
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Provider</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Purchaser</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Lender</logic:equal>
									 a Principal Entity?</b></p>
									
									<div id ="lenderPriDiv" class="radio-container princplEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.lenderEntity.princplEntityFlag" styleId="princplEntityFlag1" disabled="disabled" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.lenderEntity.princplEntityFlag" styleId="princplEntityFlag2" disabled="disabled" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
										<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.princplEntityFlag" styleClass="princplEntityFlag" />
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
						<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
						<span  class="help-block error" id="lenderMgmtfailed" style="display:none;">Please select Management Entity </span>
						
						
						<input type="text" class="span2" style="text-transform:uppercase" maxlength="20"/>
						
						<a href="#1" class="btn me-lookup" type="submit">Search</a>
						
						<a href="#1" class="btn-link clear-conditional-results">Clear results</a>
						
						
 						<span id="lenderMgmtfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div id="lenderCapitalDiv" class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<span  class="help-block error" id="lenderCapfailed" style="display:none;">Please select Capital or Industrial </span>
						<div class="radio-container" id="lenderCap">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.capitalIndustrial" >
								<p class="capitalIndustrial">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.capitalIndustrial" >
								<div id="LenderSetUpFlagTDiv" style="display: none;">
									<p class="capitalIndustrial">-</p>
								</div>
								<div id="LenderSetUpFlagFDiv" style="display: none;">
									<p class="capitalIndustrial"><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.capitalIndustrial" /></p>
								</div>
							</logic:notEmpty>
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.capitalIndustrial" styleId="lenderCapOrIndustrial" styleClass="capitalIndustrial" />
					</div>
				</div> <!-- end of block -->
				
			</div>
			
			<div class="ME conditional-row">
				<div class="row highlighted">
				<div class="span3">
					<div class="form-row">						
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.MEName" /></p>
						<input class="meValue" id="selectedLenderMgmtEntity" type="hidden" name="legSummary.lenderEntity.MEName" value="<bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.MEName" />"/>
					</div>					
				</div>		
				</div>			
			</div>
			
			<div class="row">
				<div class="span6">
					<div class="form-row">
						<label><bean:message key="label.addLeg.treasuryCode" />
							<span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span>
						</label>
						<span  class="help-block error" id="lenderTreasuryInvalid" style="display:none;">Invalid value</span>
						<input type="text" maxlength="20"  class="span3" data-provide="typeahead" style="text-transform:uppercase" data-source="" />
						
						<span id="lenderTreasuryfailedBar" class="req-error" style="display:none;">error</span>
						
						<a class="btn addtcode alwaysone" type="submit" 
							data-assign="legSummary.lenderTCodeEntity.treasuryCode">
							Search
						</a>
						<a class="btn-link clear-conditional-results" id="clearLenderTreasury" href="#" type="submit">
							<bean:message key="label.addLeg.clearResults" />
						</a>
						
					</div>
				</div> <!-- end of block -->
				<div id="lenBusSegDiv" class="span5 right">
					<div class="form-row">
						<label>Business Segment
						</label>
						<div class="radio-container" id="lenBusSegConDiv">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.lenderEntity.businessSegment" >
								<p class="businessSegment">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.lenderEntity.businessSegment" >
								<div id="lenBusSegTDiv" style="display: none;">
									<p class="businessSegment">-</p>
								</div>
								<div id="lenBusSegFDiv">
									<p class="businessSegment"><bean:write name="ICFPLegRequestForm" property="legSummary.lenderEntity.businessSegment" /></p>
								</div>
							</logic:notEmpty>
							<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderEntity.businessSegment" styleClass="businessSegment" />
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
			
			<div class="row highlighted conditional-row" id="lenderTreasuryDetails">
				<div class="span5">
					<div class="form-row tcode">
							<p><b><bean:message key="label.addLeg.treasuryCode"/></b></p>
							<p><bean:write name="ICFPLegRequestForm" property="legSummary.lenderTCodeEntity.treasuryCode" /></p>
							<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderTCodeEntity.treasuryCode" styleId="lenderTreasuryCode" /> 
					</div>
				</div><!-- end of block -->
				<html:hidden name="ICFPLegRequestForm" property="legSummary.lenderTCodeEntity.LEGoldId" styleId="lenderTreasuryGoldId" />
			</div>
				
                              
		<div class="row">
			
			<div class="span5 right">
				<div class="form-row">
					<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
					 <html:select name="ICFPLegRequestForm" property="legSummary.lenderEntity.fundHoldOperationId" styleClass="span2" styleId="selectedFunCompany">
						<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
						<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
 					</html:select>  
					<span id="lenderTreasuryfailedBar" class="req-error" style="display:none;">error</span>
				</div>
			</div> <!-- end of block -->
		</div>
		</div><!-- end of form form-mod -->
        </div></div>       
        
        <h2 class="span12">Original <logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Recipient</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Issuer</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Borrower</logic:equal></h2>
        <div class="clear"></div>
		<div class="row">
				<div class="span12">        
		<div id="1a" class="form-mod entitylookup">
			<div id="1b" class="tab-pane fade active in">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label>Original 
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Recipient</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Issuer</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Borrower</logic:equal>
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								<span  class="help-block error" id="borrowerInfofailed" style="display:none;">Please enter <span class="conditional-borrower"></span> </span>
								<span  class="help-block notfound error" id="borrowerInfoInvalid" style="display:none;">Invalid value </span>
								<span  class="help-block error duplicate" id="borrowerGoldIdInvalid" style="display:none;">Legal Entities must be different</span>
								<span  class="help-block error" id="borIdReq" style="display:none;">Please enter Gold ID or CDR</span>
								
								<select class="span14 cpa-search-id entity-filtername" id="borrowerSearchId">
									<option value="CDR">CDR</option>
									<option value="GOLD">Gold ID</option>
								</select>
								
								
								<input type="text" name="legSummary.borrowerEntity.LEGoldId" value="<bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEGoldId" />" maxlength="9" class="span3 entity-filtervalue" data-cmd="getLE" id="borrowerOrRecipient" style="text-transform:uppercase"/>
								<html:hidden name= "ICFPLegRequestForm" property="legSummary.borrowerEntity.leTypeId" styleId="tempBorrowerLeTypeId"/>
								<span id="borrowerInfofailedBar" class="req-error" style="display:none;">error</span>
								<a href="#1a" class="btn entity-lookup" data-cmd="getLE" type="submit">Search</a>
								
									<label class="checkbox info-checkbox pending">
										<html:checkbox name="ICFPLegRequestForm" property="legSummary.borrowerEntity.entitySetupFlag" value = "Y" styleClass="" styleId="borrowerEntitySetupFlag"/>
										Legal Entity Setup Pending
									</label>
								
								<a class="btn-link right clear-conditional-results" id="orgBorrowerClear" href="#" type="submit"onclick="javascript:clearBorrowerDetails();"></a>
							</div>
						</div> <!-- end of block -->
					</div> 
					<div id="borrowerGoldIdDetails" class="conditional-row">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.CDRCd">
										<p class="cdrCd">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.CDRCd">
										<p class="cdrCd"><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.CDRCd"/></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEGoldId">
										<p class="leGoldId">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEGoldId">
										<p class="leGoldId"><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEGoldId" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName"/></b></p>
									<logic:empty  name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEName" >
										<p class="leName">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEName">
										<p class="leName"><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEName" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEName" styleClass="leName" />
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.country">
										<p class="country">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.country">
										<p class="country"><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.country" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.country" styleClass="country" />
								</div>
							</div><!-- end of block -->
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.CDRCd" styleId="borrowerLegalEntityGoldId" styleClass="cdrCd" />
						<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.LEGoldId" styleId="borLEGoldId" styleClass="leGoldId" />
						</div>
						
						<div id="borrowerPEorMEDiv">
						<div class="row ">
							<div class="span7">
								<div class="form-row">
									<p><b><span class="condition-borrowerReg required">*</span>Is 
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Recipient</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Issuer</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Borrower</logic:equal>
									 a Regulated Entity?</b></p>

									<div id ="borrowerRegDiv" class="radio-container regulatedEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.borrowerEntity.regulatedEntityFlag" styleId="borRegulatedEntityFlag1" disabled="disabled" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.borrowerEntity.regulatedEntityFlag" styleId="borRegulatedEntityFlag2" disabled="disabled" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
										<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.regulatedEntityFlag" styleClass="regulatedEntityFlag" />
									</div>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><span class="condition-borrowerPrn required">*</span>Is 
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Recipient</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Issuer</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Borrower</logic:equal>
									 a Principal Entity?</b></p>
									
									<div id ="borrowerPriDiv" class="radio-container princplEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.borrowerEntity.princplEntityFlag" styleId="borPrincplEntityFlag1" disabled="disabled" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.borrowerEntity.princplEntityFlag" styleId="borPrincplEntityFlag2" disabled="disabled" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
										<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.princplEntityFlag" styleClass="princplEntityFlag" />
									</div>
									
								</div>
							</div><!-- end of block -->
						</div>
					
					</div> 
						
				</div>
			
			<div class="row MESearch">
				<div class="span5">
					<div  class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
						<span  class="help-block error" id="borrowerMgmtfailed" style="display:none;">Please select Management Entity </span>
						
						<input type="text" class="span2" style="text-transform:uppercase" maxlength="20"/>
						<span id="borrowerMgmtfailedBar" class="req-error" style="display:none;">error</span>
 						<a href="#1a" class="btn me-lookup" type="submit">Search</a>
 						
						<a href="#1a" class="btn-link clear-conditional-results">Clear results</a>
					</div>
				</div> <!-- end of block -->
				<div  id="borrowerCapitalDiv" class="span5 right">
					<div class="form-row" >
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<span  class="help-block error" id="borrowerCapfailed" style="display:none;">Please select Capital or Industrial</span>
						<div class="radio-container" id="borrowerCap">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.capitalIndustrial" >
								<p class="capitalIndustrial">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.capitalIndustrial" >
								<div id="BorrowerSetUpFlagTDiv" style="display: none;">
									<p class="capitalIndustrial">-</p>
								</div>
								<div id="BorrowerSetUpFlagFDiv" style="display: none;">
									<p class="capitalIndustrial"><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.capitalIndustrial" /></p>
								</div>
							</logic:notEmpty>
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.capitalIndustrial" styleId="borrowerCapOrIndustrial" styleClass="capitalIndustrial"/>
					</div>
				</div> <!-- end of block -->
			</div>
			
			<div class="ME conditional-row">
				<div class="row highlighted">
				<div class="span3">
					<div class="form-row">						
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.MEName" /></p>
						<input class="meValue" id="selectedBorrowerMgmtEntity" type="hidden" name="legSummary.borrowerEntity.MEName" value="<bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.MEName" />"/>
					</div>					
				</div>		
				</div>			
			</div>
			
			<div class="row">
				<div class="span6">
					<div class="form-row">
						<label><bean:message key="label.addLeg.treasuryCode" />
							<span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span>
						</label>
						<span  class="help-block error" id="borrowerTreasuryInvalid" style="display:none;">Invalid value</span>
						<input type="text" class="span3" data-provide="typeahead"  style="text-transform:uppercase"/>
						
						<span id="borrowerTreasuryfailedBar" class="req-error" style="display:none;">error</span>
						
						<a class="btn addtcode alwaysone" type="submit" data-assign="legSummary.borrowerTCodeEntity.treasuryCode">Search</a>
						<a class="btn-link clear-conditional-results" id="clearBorrowerTCode" href="#" type="submit" ><bean:message key="label.addLeg.clearResults"/></a>
						
					</div>
				</div> <!-- end of block -->
				<div id="borBusSegDiv" class="span5 right">
					<div class="form-row">
						<label>Business Segment
						</label>
						<div class="radio-container" id="borBusSegConDiv">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.businessSegment" >
								<p class="businessSegment">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.borrowerEntity.businessSegment" >
								<div id="borBusSegTDiv" style="display: none;">
									<p class="businessSegment">-</p>
								</div>
								<div id="borBusSegFDiv">
									<p class="businessSegment"><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerEntity.businessSegment" /></p>
								</div>
							</logic:notEmpty>
							<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerEntity.businessSegment" styleClass="businessSegment" />
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
			
			<div class="row highlighted conditional-row" id="borrowerTreasuryDetails">
				<div class="span5">
					<div class="form-row tcode">
						<p><b><bean:message key="label.addLeg.treasuryCode" /></b></p>
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.borrowerTCodeEntity.treasuryCode" /></p>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerTCodeEntity.treasuryCode" styleId="borrowerTreasuryCode" />
					</div>
				</div><!-- end of block -->
				<html:hidden name="ICFPLegRequestForm" property="legSummary.borrowerTCodeEntity.LEGoldId" styleId="borrowerTreasuryGoldId" />
			</div>
				
			
			<div class="row">
				<div class="span5 right">
					<div class="form-row">
						<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
						 <html:select name="ICFPLegRequestForm" property="legSummary.borrowerEntity.fundHoldOperationId" styleClass="span2" styleId="selectedBorFunCompany">
							<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
							<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
 						</html:select>  
						<span id="lenderTreasuryfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
			
			
		</div><!-- end of form form-mod -->
</div></div>
                
		


