<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<fmt:setLocale value="en-US"/>
<% String servletContextUrl1 = request.getContextPath(); %>


	<script src="<%=servletContextUrl1%>/js/rcaRequestor.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl1%>/js/bootstrap-typeahead.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl1%>/js/day2/frontOffice.js" type="text/javascript"></script>
	
	<script>var contextURL = '<%=servletContextUrl1%>';</script>
	
	<html:form action="/frontoffice/RCALegRequest.do" styleId="ICFPLegRequestForm" method="post" enctype="multipart/form-data" >
	            <c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
             	<c:set var="legNumber" value="${sessionScope.ICFPLegRequestForm.map['legNumber']}" />
				<input type="hidden" id="legNumberID" name="legNumber" value="<bean:write name="ICFPLegRequestForm" property="legNumber" />" />
				<input type="hidden"  id="derivativeNumber" name="derivativeNumber" />
		        <input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />      
		     
                <jsp:include page="currentLegdetails.jsp" >
					<jsp:param name="id" value="${legNumber }"/>
				</jsp:include>
                
                
                <jsp:include page="originalTransaction.jsp" />
				<jsp:include page="foOriginalLenderBorrower.jsp" />
		        
      
				
	<div>
			<h2 class="span12">Assignment Details</h2>
      <div class="clear"></div>
            
        <div class="row">
			<div class="span5">
				<div class="form-row">
            <span class="required">*</span>
            <label>New <span class="conditional-lender"></span> or <span class="conditional-borrower"></span></label>
            <div id="newLenBorDiv" class="radio-container">
            <label class="radio">
            	<html:radio name="ICFPLegRequestForm" styleClass="condition" styleId="newFOLenderOrBorrower" property="dayTwoOperations.assignment.newLenderOrBorrowerFlag"  onclick="javascript:lenderFOD();" value="true"/><span class="conditional-lender"></span>
            </label>
            <label class="radio">
                <html:radio name="ICFPLegRequestForm" styleClass="condition" styleId="newFOLenderOrBorrower" property="dayTwoOperations.assignment.newLenderOrBorrowerFlag"  onclick="javascript:borrowerFOD();" value="false"/><span class="conditional-borrower"></span>
            </label>
             
            </div>    
        </div>     
        </div>
        </div>


		<div id="newFOLenderDetails" style="display:none;">

        <h2 class="span12">New <span class="conditional-lender"></span></h2>
        <div id="NewLenderReadOnlyDetails" class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable exceptions">
					<thead>
					  <tr>
						<th width="5%">Action</th>
						<th colspan="2"><logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Provider</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Purchaser</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Lender</logic:equal> Details</th>
					  </tr>
					</thead>
					<tbody>
						<tr>
							<td>
							
							<a class="edit-leg ttip" href="javascript:;" data-original-title="Edit this leg" id="newLenderEdit"></a>
							
							</td>
							<td  width="45%"><p><b>CDR Code</b> <br> 
									<logic:empty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.CDRCd">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.CDRCd">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.CDRCd"/></p>
									</logic:notEmpty>
									</p>
									</td>
							<td><p><b>Legal Entity Gold Id</b><br /> 
									<logic:empty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEGoldId">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEGoldId">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEGoldId" /></p>
									</logic:notEmpty>
									</p>
									</td>
						</tr>
						<tr>
                        	<td>&nbsp;</td>
							<td width="45%"><p><b>Legal Entity Name</b> <br> <logic:empty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEName">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEName">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEName" /></p>
									</logic:notEmpty>
									</p></td>
							<td><p><b>Country</b><br /> <logic:empty  name="ICFPLegRequestForm" property="legSummary.newLenderEntity.country">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.country">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.country" /></p>
									</logic:notEmpty>
									</p></td>
						</tr>  
						<tr>
                        	<td>&nbsp;</td>
							<td width="45%"><p><b>Is <span class="conditional-lender"></span> a regulated Entity?</b> <br> <logic:empty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.regulatedEntityFlag">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.regulatedEntityFlag">
										 <logic:equal name="ICFPLegRequestForm" property="legSummary.newLenderEntity.regulatedEntityFlag" value="true">
	                                    <p>Yes</p>
                                       </logic:equal>
                                    <logic:equal name="ICFPLegRequestForm" property="legSummary.newLenderEntity.regulatedEntityFlag" value="false">
	                                    <p>No</p>
                                    </logic:equal>
									</logic:notEmpty></p></td>
							<td><p><b>Is <span class="conditional-lender"></span> a principal Entity?</b><br /> <logic:empty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.princplEntityFlag">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.princplEntityFlag">
										 <logic:equal name="ICFPLegRequestForm" property="legSummary.newLenderEntity.princplEntityFlag" value="true">
	                                    <p>Yes</p>
                                       </logic:equal>
                                    <logic:equal name="ICFPLegRequestForm" property="legSummary.newLenderEntity.princplEntityFlag" value="false">
	                                    <p>No</p>
                                    </logic:equal>
									</logic:notEmpty></p></td>
						</tr>  
						<tr>
                        	<td>&nbsp;</td>
							<td width="45%"><p><b>Management Entity</b> <br> <logic:empty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.MEName">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.MEName">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.MEName" /></p>
									</logic:notEmpty>
									</p></td>
							<td><p><b>Capital or Industrial</b><br /> <logic:empty name="ICFPLegRequestForm"
											property="legSummary.newLenderEntity.capitalIndustrial">
											<p>-</p>
										</logic:empty>
										<logic:notEmpty name="ICFPLegRequestForm"
											property="legSummary.newLenderEntity.capitalIndustrial">
											<p><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.capitalIndustrial" /></p>
										</logic:notEmpty>
									</p></td>
						</tr> 
						<tr>
                        	<td>&nbsp;</td>
                        	<td width="45%"><p><b>Treasury Code</b> <br> <logic:empty name="ICFPLegRequestForm"
											property="legSummary.newLenderTCodeEntity.treasuryCode">
											<p>-</p>
										</logic:empty>
										<logic:notEmpty name="ICFPLegRequestForm"
											property="legSummary.newLenderTCodeEntity.treasuryCode">
											<p><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderTCodeEntity.treasuryCode"/></p>
										</logic:notEmpty>
										</p></td>
                        	
							<td><p><b>Business Segment</b> <br> <logic:empty name="ICFPLegRequestForm"
											property="legSummary.newLenderEntity.businessSegment">
											<p>-</p>
										</logic:empty>
										<logic:notEmpty name="ICFPLegRequestForm"
											property="legSummary.newLenderEntity.businessSegment">
											<p><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.businessSegment" /></p>
											
										</logic:notEmpty>
										</p></td>
							
						</tr>                                                                                                
						<tr>
                        	<td>&nbsp;</td>
                        	<td width="45%"></td>
							<td><p><b>Funding Company/Holding Company/Operating Company</b><br /> <logic:empty name="ICFPLegRequestForm"
											property="legSummary.newLenderEntity.fundHoldOperation">
											<p>-</p>
										</logic:empty>
										<logic:notEmpty name="ICFPLegRequestForm"
											property="legSummary.newLenderEntity.fundHoldOperation">
											<p><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.fundHoldOperation"/></p>
											
										</logic:notEmpty>
										</p></td>
							
						</tr>                                                                        
					 </tbody>
				  </table>
				</div>
			</div>
          
        
        
        
       <div id="newLenderEditDetails">
        <div class="clear"></div>
        <div class="row">
		<div class="form-mod entitylookup">
			<div id="2c" class="tab-content">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label>New <span class="conditional-lender"></span>
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								<span  class="help-block error" id="newLenderInfofailed" style="display:none;">Please enter <span class="conditional-lender"></span> </span>
								<span  class="help-block error notfound" id="lenderInfoInvalid" style="display:none;"><bean:message key="label.adLeg.invalidValue" /> </span>
								<span  class="help-block error duplicate" id="newLenderDiffFailed" style="display:none;">Legal Entities must be different</span>
								
								<select class="span14 cpa-search-id entity-filtername" id="newLenderSearchId">
									<option value="CDR"><bean:message key="label.adLeg.cdr" /></option>
									<option value="GOLD"><bean:message key="label.adLeg.goldId" /></option>
								</select>
								
							
								<input type="text" name="legSummary.newLenderEntity.LEGoldId" id="newLenderLEGoldId" value="<bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEGoldId" />" maxlength="9" class="span3 entity-filtervalue" id="newLenderOrProvider" style="text-transform:uppercase"/>
								
								<span id="newLenderInfofailedBar" class="req-error" style="display:none;">error</span>
								<a href="#1" class="btn entity-lookup" type="submit" data-cmd="getLE" id="searchByNewLenderGoldId">Search</a>
								<label class="checkbox info-checkbox pending ">
								
									<html:checkbox name="ICFPLegRequestForm" property="legSummary.newLenderEntity.entitySetupFlag" value="Y" styleClass="" styleId="newLenderEntitySetupFlag"/>
									Legal Entity Setup Pending
								</label>
								<a class="btn-link right clear-conditional-results" id="newLenderClear" href="#" type="submit" onclick="javascript:clearNewLenderDetails();"></a>
							</div>
						</div> <!-- end of block -->
					</div> 
					  <div id="newLenderGoldIdDetails" class="conditional-row">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.CDRCd">
										<p class="cdrCd">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.CDRCd">
										<p class="cdrCd"><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.CDRCd"/></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEGoldId">
										<p class="leGoldId">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEGoldId">
										<p class="leGoldId"><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEGoldId" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEName">
										<p class="leName">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEName">
										<p class="leName"><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEName" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEName" styleClass="leName" styleId="newLeName" />
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country" /></b></p>
									<logic:empty  name="ICFPLegRequestForm" property="legSummary.newLenderEntity.country">
										<p class="country">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.country">
										<p class="country"><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.country" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.newLenderEntity.country" styleClass="country" styleId="newLecountry" />
								</div>
							</div><!-- end of block -->
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.newLenderEntity.CDRCd" styleId="newLenderLegalEntityGoldId" styleClass="cdrCd" />
						<html:hidden name="ICFPLegRequestForm" property="legSummary.newLenderEntity.LEGoldId" styleId="newLEGoldId" styleClass="leGoldId"/>
						</div>
						
						<div id="newLenderPEorMEDiv">
						<div class="row ">
							<div class="span5">
								<div class="form-row"><p><b><span class="condition-newLenderReg required">*</span>Is 
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Provider</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Purchaser</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Lender</logic:equal>
									 a Regulated Entity?</b></p>

									<div id ="newLenderRegDiv" class="radio-container regulatedEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.newLenderEntity.regulatedEntityFlag" styleId="newRegulatedEntityFlag1" disabled="disabled" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.newLenderEntity.regulatedEntityFlag" styleId="newRegulatedEntityFlag2" disabled="disabled" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
										<html:hidden name="ICFPLegRequestForm" property="legSummary.newLenderEntity.regulatedEntityFlag" styleClass="regulatedEntityFlag" />
									</div>
									
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><span class="condition-newLenderPrn required">*</span>Is
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Provider</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Purchaser</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Lender</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Lender</logic:equal>
									 a Principal Entity?</b></p>
									
									<div id ="newLenderPriDiv" class="radio-container princplEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.newLenderEntity.princplEntityFlag" styleId="newPrincplEntityFlag1" disabled="disabled" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.newLenderEntity.princplEntityFlag" styleId="newPrincplEntityFlag2" disabled="disabled" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
										<html:hidden name="ICFPLegRequestForm" property="legSummary.newLenderEntity.princplEntityFlag" styleClass="princplEntityFlag" />
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
									
 						<span id="newLenderMgmtfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div id="newLenderCapitalDiv" class="span5 right">
					<div class="form-row">
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<span  class="help-block error" id="lenderCapfailed" style="display:none;">Please select Capital or Industrial </span>
						<div class="radio-container" id="newLenderCap">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.capitalIndustrial" >
								<p class="capitalIndustrial">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.capitalIndustrial" >
								<div id="newLenderSetUpFlagTDiv" style="display: none;">
									<p class="capitalIndustrial">-</p>
								</div>
								<div id="newLenderSetUpFlagFDiv" style="display: none;">
									<p class="capitalIndustrial"><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.capitalIndustrial" /></p>
								</div>
							</logic:notEmpty>
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.newLenderEntity.capitalIndustrial" styleId="newLenderCapOrIndustrial" styleClass="capitalIndustrial" />
					</div>
				</div> <!-- end of block -->
			</div>
			
			<div class="ME conditional-row">
				<div class="row highlighted">
				<div class="span3">
					<div class="form-row">						
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.MEName" /></p>
						<input class="meValue" id="selectedNewLenderMgmtEntity" type="hidden" name="legSummary.newLenderEntity.MEName" value="<bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.MEName" />"/>
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
					<span  class="help-block error" id="newLenderTreasuryfailed" style="display:none;">Please enter Treasury Code </span>
					<input type="text" maxlength="20" id="lenderTreasuryCode" class="span3" data-provide="typeahead" style="text-transform:uppercase" data-source=""/>
					
					<span id="newLenderTreasuryfailedBar" class="req-error" style="display:none;">error</span>
					
					<a class="btn addtcode alwaysone" type="submit" 
						data-assign="legSummary.newLenderTCodeEntity.treasuryCode">
						Search
					</a>
					<a class="btn-link clear-conditional-results" id="clearNewLenderTCode" href="#" type="submit">
						<bean:message key="label.addLeg.clearResults" />
					</a>
										
				</div>
			</div> <!-- end of block -->
				<div id="newLenBusSegDiv" class="span5 right">
					<div class="form-row">
						<label>Business Segment
						</label>
						<div class="radio-container" id="lenBusSegConDiv">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.businessSegment" >
								<p class="businessSegment">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newLenderEntity.businessSegment" >
								<div id="newLenBusSegTDiv" style="display: none;">
									<p class="businessSegment">-</p>
								</div>
								<div id="newLenBusSegFDiv">
									<p class="businessSegment"><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderEntity.businessSegment" /></p>
								</div>
							</logic:notEmpty>
							<html:hidden name="ICFPLegRequestForm" property="legSummary.newLenderEntity.businessSegment" styleClass="businessSegment" styleId="newLenderbusinessSegment"/>
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row highlighted conditional-row" id="newLenderTreasuryDetails">
				<div class="span5">
					<div class="form-row tcode">
						<p><b><bean:message key="label.addLeg.treasuryCode"/></b></p>
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.newLenderTCodeEntity.treasuryCode" /></p>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.newLenderTCodeEntity.treasuryCode" styleId="newLenderTreasuryCode"  />
					</div>
				</div><!-- end of block -->
			</div>
			<html:hidden name="ICFPLegRequestForm" property="legSummary.newLenderTCodeEntity.LEGoldId" styleId="newLenderTreasuryGoldId" />
		            
		<div class="row">
			
			<div class="span5 right">
				<div class="form-row">
					<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
					 <html:select name="ICFPLegRequestForm" property="legSummary.newLenderEntity.fundHoldOperationId" styleClass="span2" styleId="selectedNewFunCompany">
						<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
						<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
 					</html:select>  
					<span id="lenderTreasuryfailedBar" class="req-error" style="display:none;">error</span>
				</div>
			</div> <!-- end of block -->
		</div>
		
		</div><!-- end of form form-mod -->
		</div>
		<div class="span12 btn-container" style="margin-left:-10px!important;">
		   <a href="#" class="btn right btn-success" id="saveNewLenderDetails">Save Selection</a>
		   <a class="btn-link right clear-conditional-results" id="newLenderClear" href="#" type="submit" onclick="javascript:clearNewLenderDetails();"><bean:message key="label.addLeg.clearResults" /></a>
			                 
		</div>
		
	</div><!-- end of new lender edit details -->
        
        
    </div><!-- LENDER DIV ENDS HERE -->

		
        
        <div id="newFOBorrowerDetails" style="display:none;">
        
		<h2 class="span12">New <span class="conditional-borrower"></span></h2>
		<div  id="NewBorrowerReadOnlyDetails" class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable exceptions">
					<thead>
					  <tr>
						<th width="5%">Action</th>
						<th colspan="2"><logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Recipient</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Issuer</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Borrower</logic:equal> Details</th>
					  </tr>
					</thead>
					<tbody>
						<tr>
							<td><a class="edit-leg ttip" href="javascript:;" data-original-title="Edit this leg" id="newBorrowerEdit"></a></td>
							<td  width="45%"><p><b>CDR Code</b> <br> <logic:empty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.CDRCd">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.CDRCd">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.CDRCd"/></p>
									</logic:notEmpty>
									</p></td>
							<td><p><b>Legal Entity Gold Id</b><br /> <logic:empty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEGoldId">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEGoldId">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEGoldId" /></p>
									</logic:notEmpty>
									</p></td>
						</tr>
						<tr>
                        	<td>&nbsp;</td>
							<td  width="45%"><p><b>Legal Entity Name</b> <br> <logic:empty  name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEName" >
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEName">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEName" /></p>
									</logic:notEmpty>
									</p></td>
							<td><p><b>Country</b><br /> <logic:empty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.country">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.country">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.country" /></p>
									</logic:notEmpty>
									</p></td>
						</tr>  
						<tr>
                        	<td>&nbsp;</td>
							<td  width="45%"><p><b>Is <span class="conditional-borrower"></span> a regulated Entity?</b> <br> <logic:empty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.regulatedEntityFlag" >
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.regulatedEntityFlag">
										 <logic:equal name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.regulatedEntityFlag" value="true">
	                                    <p>Yes</p>
                                       </logic:equal>
                                    <logic:equal name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.regulatedEntityFlag" value="false">
	                                    <p>No</p>
                                    </logic:equal>
									</logic:notEmpty>
									</p></td>
									
							<td><p><b>Is <span class="conditional-borrower"></span> a principal Entity?</b><br /> <logic:empty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.princplEntityFlag">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.princplEntityFlag">
										 <logic:equal name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.princplEntityFlag" value="true">
	                                    <p>Yes</p>
                                       </logic:equal>
                                    <logic:equal name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.princplEntityFlag" value="false">
	                                    <p>No</p>
                                    </logic:equal>
									</logic:notEmpty>
									</p></td>
						</tr>  
						<tr>
                        	<td>&nbsp;</td>
							<td  width="45%"><p><b>Management Entity</b> <br> <logic:empty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.MEName">
										<p>-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.MEName">
										<p><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.MEName" /></p>
									</logic:notEmpty></p></td>
							<td><p><b>Capital or Industrial</b><br /> <logic:empty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.capitalIndustrial" >
								<p >-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.capitalIndustrial" >
								<p><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.capitalIndustrial" /></p>
							</logic:notEmpty></p></td>
						</tr>  
						<tr>
                        	<td>&nbsp;</td>
                        	<td width="45%"><p><b>Treasury Code</b> <br> <logic:empty name="ICFPLegRequestForm"
											property="legSummary.newBorrowerTCodeEntity.treasuryCode">
											<p>-</p>
										</logic:empty>
										<logic:notEmpty name="ICFPLegRequestForm"
											property="legSummary.newBorrowerTCodeEntity.treasuryCode">
											<p><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerTCodeEntity.treasuryCode"/></p>
										</logic:notEmpty>
										</p></td>
							<td><p><b>Business Segment</b> <br> <logic:empty name="ICFPLegRequestForm"
											property="legSummary.newBorrowerEntity.businessSegment">
											<p>-</p>
										</logic:empty>
										<logic:notEmpty name="ICFPLegRequestForm"
											property="legSummary.newBorrowerEntity.businessSegment">
											<p><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.businessSegment" /></p>
											
										</logic:notEmpty>
										</p></td>
							
						</tr>                                                                                                
						<tr>
                        	<td>&nbsp;</td>
							<td width="45%"></td>
							<td><p><b>Funding Company/Holding Company/Operating Company</b><br /> <logic:empty name="ICFPLegRequestForm"
											property="legSummary.newBorrowerEntity.fundHoldOperation">
											<p>-</p>
										</logic:empty>
										<logic:notEmpty name="ICFPLegRequestForm"
											property="legSummary.newBorrowerEntity.fundHoldOperation">
											<p><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.fundHoldOperation"/></p>
											
										</logic:notEmpty>
										</p></td>
						</tr>                                                                        
					                                                               
					 </tbody>
				  </table>
				</div>
			</div>
				
		<div id="newBorrowerEditDetails">
        <div class="clear"></div>
        <div class="row">
		<div class="form-mod entitylookup">
			<div id="2d" class="tab-pane fade active in">
					<div class="row">
						<div class="span search-container">
							<div class="form-row">
								<span class="required">*</span>
								<label>New <span class="conditional-borrower"></span>
									<span class="ttip info" data-original-title="<bean:message key="label.tooltip.lenderProvider" />"></span>
								</label>
								<span  class="help-block error" id="borrowerInfofailed" style="display:none;">Please enter <span class="conditional-borrower"></span> </span>
								<span  class="help-block notfound error" id="borrowerInfoInvalid" style="display:none;">Invalid value </span>
								<span  class="help-block error duplicate" id="newBorrowerGoldIdInvalid" style="display:none;">Legal Entities must be different</span>
								
								<select class="span14 cpa-search-id entity-filtername" id="newBorrowerSearchId">
									<option value="CDR">CDR</option>
									<option value="GOLD">Gold ID</option>
								</select>
								
								
								<input type="text" name="legSummary.newBorrowerEntity.LEGoldId" id="newBorrowerLEGoldId" value="<bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEGoldId" />" maxlength="9" class="span3 entity-filtervalue" data-cmd="getLE" id="newBorrowerOrRecipient" style="text-transform:uppercase"/>
								<span id="newBorrowerInfofailedBar" class="req-error" style="display:none;">error</span>
								<a href="#1a" class="btn entity-lookup" data-cmd="getLE" type="submit" id="searchByNewBorrowerGoldId">Search</a>
								<label class="checkbox info-checkbox pending">
									<html:checkbox name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.entitySetupFlag" value = "Y" styleClass="" styleId="newBorrowerEntitySetupFlag"/>
									Legal Entity Setup Pending
								</label>
								<a class="btn-link right clear-conditional-results" id="newBorrowerClear" href="#" type="submit"onclick="javascript:clearNewBorrowerDetails();"></a>
							</div>
						</div> <!-- end of block -->
					</div> 
					<div id="newBorrowerGoldIdDetails" class="conditional-row">
						<div class="row highlighted">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.cdrCode"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.CDRCd">
										<p class="cdrCd">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.CDRCd">
										<p class="cdrCd"><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.CDRCd"/></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityGoldId"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEGoldId">
										<p class="leGoldId">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEGoldId">
										<p class="leGoldId"><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEGoldId" /></p>
									</logic:notEmpty>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span5">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.legalEntityName"/></b></p>
									<logic:empty  name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEName" >
										<p class="leName">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEName">
										<p class="leName"><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEName" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEName" styleClass="leName" styleId="newBoLeName" />
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><bean:message key="label.addLeg.country"/></b></p>
									<logic:empty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.country">
										<p class="country">-</p>
									</logic:empty>
									<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.country">
										<p class="country"><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.country" /></p>
									</logic:notEmpty>
									<html:hidden name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.country" styleClass="country" styleId="newBocountry"/>
								</div>
							</div><!-- end of block -->
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.CDRCd" styleId="newBorrowerLegalEntityGoldId" styleClass="cdrCd" />
						<html:hidden name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.LEGoldId" styleId="newBorLEGoldId" styleClass="leGoldId" />
						</div>
						
						<div id="borrowerPEorMEDiv">
						<div class="row ">
							<div class="span5">
								<div class="form-row">
									<p><b><span class="condition-newBorrowerReg required">*</span>Is 
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Recipient</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Issuer</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Borrower</logic:equal>
									 a Regulated Entity?</b></p>

									<div id ="newBorrowerRegDiv" class="radio-container regulatedEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.regulatedEntityFlag" styleId="newBorRegulatedEntityFlag1" disabled="disabled" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.regulatedEntityFlag" styleId="newBorRegulatedEntityFlag2" disabled="disabled" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
										<html:hidden name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.regulatedEntityFlag" styleClass="regulatedEntityFlag" />
									</div>
								</div>
							</div><!-- end of block -->
							<div class="span5 right">
								<div class="form-row">
									<p><b><span class="condition-newBorrowerPrn required">*</span>Is
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="1">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="2">Recipient</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="6">Issuer</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="5">Borrower</logic:equal>
									<logic:equal name="ICFPLegRequestForm" property="legSummary.legTypeId" value="4">Borrower</logic:equal>
									 a Principal Entity?</b></p>
									
									<div id ="newBorrowerPriDiv" class="radio-container princplEntityFlag">
										<label class="radio" style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.princplEntityFlag" styleId="newBorPrincplEntityFlag1" disabled="disabled" value="true"/>
										<bean:message key="label.addLeg.yes" />
										</label>
										<label class="radio"  style="font-weight:normal;">
										<html:radio name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.princplEntityFlag" styleId="newBorPrincplEntityFlag2" disabled="disabled" value="false"/>
										<bean:message key="label.addLeg.no" />
										</label>
										<html:hidden name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.princplEntityFlag" styleClass="princplEntityFlag" />
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
 						<a href="#1a" class="btn me-lookup" type="submit">Search</a>
						<a href="#1a" class="btn-link clear-conditional-results">Clear results</a>
						
 						<span id="newBorrowerMgmtfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div  id="newBorrowerCapitalDiv" class="span5 right">
					<div class="form-row" >
						<label><bean:message key="label.addLeg.capitalOrIndustrial" />
						</label>
						<div class="radio-container" id="newBorrowerCap">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.capitalIndustrial" >
								<p class="capitalIndustrial">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.capitalIndustrial" >
								<div id="newBorrowerSetUpFlagTDiv" style="display: none;">
									<p class="capitalIndustrial">-</p>
								</div>
								<div id="newBorrowerSetUpFlagFDiv" style="display: none;">
									<p class="capitalIndustrial"><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.capitalIndustrial" /></p>
								</div>
							</logic:notEmpty>
						</div>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.capitalIndustrial" styleId="newBorrowerCapOrIndustrial" styleClass="capitalIndustrial"/>
					</div>
				</div> <!-- end of block -->
			</div>
			
			<div class="ME conditional-row">
				<div class="row highlighted">
				<div class="span3">
					<div class="form-row">						
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.MEName" /></p>
						<input class="meValue" id="selectedNewBorrowerMgmtEntity" type="hidden" name="legSummary.newBorrowerEntity.MEName" value="<bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.MEName" />"/>
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
						<span  class="help-block error" id="newBorrowerTreasuryInvalid" style="display:none;">Invalid value</span>
						<input type="text" class="span3" data-provide="typeahead"  id="borrowerTreasuryCode" style="text-transform:uppercase"/>
						
						<span id="newBorrowerTreasuryfailedBar" class="req-error" style="display:none;">error</span>
						
						<a class="btn addtcode alwaysone" type="submit" data-assign="legSummary.newBorrowerTCodeEntity.treasuryCode">Search</a>
						<a class="btn-link right clear-conditional-results" id="clearNewBorrowerTCode" href="#" type="submit" ><bean:message key="label.addLeg.clearResults"/></a>
					
					</div>
				</div> <!-- end of block -->
			
			
				<div id="newBorBusSegDiv" class="span5 right">
					<div class="form-row">
						<label>Business Segment
						</label>
						<div class="radio-container" id="newBorBusSegConDiv">
							<logic:empty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.businessSegment" >
								<p class="businessSegment">-</p>
							</logic:empty>
							<logic:notEmpty name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.businessSegment" >
								<div id="newBorBusSegTDiv" style="display: none;">
									<p class="businessSegment">-</p>
								</div>
								<div id="newBorBusSegFDiv">
									<p class="businessSegment"><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.businessSegment" /></p>
								</div>
							</logic:notEmpty>
							<html:hidden name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.businessSegment" styleClass="businessSegment" styleId="newBorrowerbusinessSegment" />
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row highlighted conditional-row" id="newBorrowerTreasuryDetails">
				<div class="span5">
					<div class="form-row tcode">
						<p><b><bean:message key="label.addLeg.treasuryCode" /></b></p>
						<p><bean:write name="ICFPLegRequestForm" property="legSummary.newBorrowerTCodeEntity.treasuryCode" /></p>
						<html:hidden name="ICFPLegRequestForm" property="legSummary.newBorrowerTCodeEntity.treasuryCode" styleId="newBorrowerTreasuryCode" />
					</div>
				</div><!-- end of block -->
			</div>
			<html:hidden name="ICFPLegRequestForm" property="legSummary.newBorrowerTCodeEntity.LEGoldId" styleId="newBorrowerTreasuryGoldId" />
			<div class="row">
				
				<div class="span5 right">
					<div class="form-row">
						<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
						 <html:select name="ICFPLegRequestForm" property="legSummary.newBorrowerEntity.fundHoldOperationId" styleClass="span2" styleId="newSelectedBorFunCompany">
							<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
							<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
 						</html:select>  
						<span id="lenderTreasuryfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
			
            
		</div><!-- end of form form-mod -->
		</div>
		<div class="span12 btn-container" style="margin-left:-10px!important;">
		   <a href="#" class="btn right btn-success" id="saveNewBorrowerDetails">Save Selection</a>
		   <a class="btn-link right clear-conditional-results" id="newBorrowerClear" href="#" type="submit"onclick="javascript:clearNewBorrowerDetails();"><bean:message key="label.addLeg.clearResults" /></a>
			                
		</div>
		
	</div><!-- end of new borrow edit details -->
        
        
  </div><!-- BORROWER DETAILS ENDS HERE -->        
			


			<div class="row">
			        <div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Accrued Interest Amount</label>
							<span  class="help-block invalid error" style="display:none;">Invalid value </span>
							<input type="text"  name="legSummary.accruedInterestAmt" maxlength="30" class="currencynoconversion" id="accruedInterestAmt" 
							value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.accruedInterestAmt}" />"/>
                            <span id="accruedInterestBar" class="req-error" style="display:none;">error</span>
						</div>
					</div> <!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Currency</label>
                            <span  class="help-block error" id="originalCCYValidate" style="display:none;">Please select currency </span>
							<span  class="help-block error" id="originalCCYInvalid" style="display:none;">Invalid currency </span>
							<input type="text" id="originalCCY" name="legSummary.originalCCY" value="<bean:write name="ICFPLegRequestForm" property="legSummary.originalCCY"/>"
							class="span2 originalCCY" data-provide="typeahead" 
							data-source="<c:out value="${applicationScope['com.ge.icfp.MasterData'].allCurrencies}"/>" >
							
	 						<span id="originalCCYValidateBar" class="req-error" style="display:none;">error</span>
						</div>
					</div> <!-- end of block --> 
					                                   
				</div>
			
				<div class="row">
					<div class="span5">
						<div class="form-row">

							<span class="required">*</span>
							<label>Fees</label>
							<span  class="help-block invalid error" style="display:none;">Invalid value </span>
							<input type="text"  name="legSummary.fees" maxlength="30" class="currencynoconversion" id="fees" 
							value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.fees}" />"/>
                           
                            <span id="feesBar" class="req-error" style="display:none;">error</span>
                            
						</div>
					</div> <!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Principal Amount</label>
                            <span  class="help-block error" id="originalCCYAmountValidate" style="display:none;">Please enter Prinicipal Amount</span>
							<span  class="help-block invalid error" style="display:none;">Invalid value </span>
							
							<input type="text"  name="legSummary.originalCCYAmount" maxlength="30" class="span2 currency" id="originalCCYAmount" 
								data-for="originalCCY" data-replace="usdEquiDiv" 
								value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.originalCCYAmount}" />"/>
								
							<span class="req-error" style="display:none;">error</span> 
							<span id="originalCCYAmountValidateBar" class="req-error" style="display:none;">error</span> 
							</div>
					</div> <!-- end of block -->    
					                   
				</div> 
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>P&amp;L Amount from Lender/Provider perspective</label>
							<span  class="help-block invalid error" style="display:none;">Invalid value </span>
							<input type="text"  name="dayTwoOperations.assignment.pandLAmt" maxlength="30" class="currencynegnoconversion" id="pandLAmt" 
							value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.dayTwoOperations.map.assignment.map.pandLAmt}" />"/>
							
                            <span id="pandLAmtBar" class="req-error" style="display:none;">error</span>
						</div>
					</div> <!-- end of block -->
					
					<div class="span5 right"  id="usdEquiDiv">
						<div class="form-row">
							<label>USD Equivalent</label>
							<html:hidden  name="ICFPLegRequestForm" property="legSummary.USDEquivalent" styleId="USDEquivalent"/>
							<span id="usdValidateBar" class="req-error" style="display:none;">error</span>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent eq '0.00'}">
							   <p>-</p>
							</c:if>
							<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent != '0.00'}">
								<p>${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent}</p>
							</c:if>
						</div>
					</div> <!-- end of block -->
					               
                    
				</div>        
 

				<div class="row">
					<div class="span5">
						<div class="form-row">

                            <span class="required">*</span>
							<label>Request Derivatives</label>
							<span  class="help-block error" id="derivativesfailed" style="display:none;">Please select Request Derivatives</span>
							<div id="derivativDiv" class="radio-container derivativesConditional">
								<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.derivativesFlag" styleId="derivativesFlag" value="true" styleClass="condition"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.derivativesFlag" styleId="derivativesFlag" value="false"/>
								<bean:message key="label.addLeg.no" />
							</label>
							</div>                               
						</div>
					</div> <!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
                        	<span class="required">*</span>
							<label>Original Legal Agreement Attached</label>
								<div id="originalAgmtDiv" class="radio-container ">
									<label class="radio">
										<html:radio name="ICFPLegRequestForm" styleClass="condition" property="legSummary.eventNoticeAttachedFlag" styleId="isOrigLegalAgreementAttachedFlag" value="true"/>
										<bean:message key="label.addLeg.yes" />
									</label>
									<label class="radio">
										<html:radio name="ICFPLegRequestForm" property="legSummary.eventNoticeAttachedFlag" styleId="isOrigLegalAgreementAttachedFlag" value="false"/>
										<bean:message key="label.addLeg.no" />
									</label>
								</div> 
						</div>
					</div> <!-- end of block -->     

				</div>
				<jsp:include page="rcaDerivativesCommon.jsp" />	
				
				                     
        </div><!-- FORM MODE ENDS HERE --> 
		
		<jsp:include page="settlementDetails.jsp" />
		<jsp:include page="termsAndConditions.jsp" />
		        
		<jsp:include page="otherConsiderations.jsp" />
			
 
		 <jsp:include page="/jsp/frontOffice/qualitativeAssessment.jsp">
				<jsp:param name="factors" value="Regulatory Risk,Finance Risk,Legal Governance Risk,Reputational Risk,Sovereign Risk"/>			
		</jsp:include>
			 
                         
		<div class="form-mod">			
			<jsp:include page="/jsp/common/inc/commentsLog.jsp">
				<jsp:param name="formName" value="dealRequestForm"/>
				<jsp:param value="frontoffice/fourBlocker" name="path"/>
			    <jsp:param value="${param.name}" name="name"/>
			    <jsp:param value="openLeg" name="method"/>
			    <jsp:param value="Front Office" name="origin"/>
			    <jsp:param value="${sessionScope.ICFPLegRequestForm.map['legNumber']}" name="legNumber"/>			
			</jsp:include>
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<label>Comments</label>
						<div class="char-count">500</div>
						<html:textarea name="ICFPLegRequestForm" styleId="requestException" property="legSummary.comments" styleClass="xlarge autosize messageinput" rows="1" onblur="scriptInjection(this);"/>
					</div>
				</div> <!-- end of block -->
			</div>
        </div><!-- end of form form-mod -->
        
			       <!-- starts uploads-->
			<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
			<jsp:param name="mode" value="edit" />
				<jsp:param name="legIndex" value="${legNumber}" />
			</jsp:include>  
			<!-- end uploads -->

		<jsp:include page="/jsp/common/inc/auditLog.jsp">
			<jsp:param name="formName" value="dealRequestForm"/>
			<jsp:param value="frontoffice/fourBlocker" name="path"/>
		    <jsp:param value="${param.name}" name="name"/>
			<jsp:param value="openLeg" name="method"/>
			<jsp:param value="Front Office" name="origin"/>
			<jsp:param value="${sessionScope.ICFPLegRequestForm.map.legNumber}" name="legNumber"/>			
		</jsp:include>        
<!--         <div class="span8 right btn-container">
		<input type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validateFOAssignment(this);">
		<input type="button" value="Save" class="btn right" onclick="javascript:saveAsDraft(this);">
		<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal">Cancel</a>
		</div>   --> 
		
        		<!-- ------------- -->
			<div class="span12 btn-container" style="margin-left:-10px!important;">
				<c:if test="${sessionScope.section eq 'myTasks'}">
				<div class="span3 right" style="background-color: #D9EDF7;   border:1px solid #A6C2D6;padding:5px;">
					<div class="form-row" style="margin-bottom:15px;">
						<div id="saveRadioDiv" class="radio-container conditional-required">
							<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'" id="reviewNextLegID">
								<input type="radio" name="saveAction" value="saveNextLeg" class="condition">
								Save and go to next Leg
							</label>
							<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'">
								<input type="radio" name="saveAction" value="saveReturnDeal" class="condition">
								Save and return to deal
							</label>
						</div>
					</div>
					
					<input type="button" class="btn btn-success btn-large" onclick="javascript:validateFOAssignment(this);"
					value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" />
					
				</div>
				
				<c:choose>
					<c:when test="${requestScope.nextLeg ne 'false'}">
						<input type="button" value="Save" class="btn right" style="margin-top: 85px;" onclick="javascript:saveAsDraft(this);">
						<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="button" value="Save" style="margin-top: 60px;" class="btn right" onclick="javascript:saveAsDraft(this);">
						<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:70px">Cancel</a>
					</c:otherwise>
				</c:choose>
				</c:if>
				<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
				<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
				</c:if>				
			</div>
		<!-- --------------- -->		
		 
		<input type="hidden" id="actionId" value="${actionId}"> 
		<html:hidden name="ICFPLegRequestForm" property="legSummary.transactionEventTypeId" styleId="transactionEventTypeId" />    
       </html:form>
  	<div class="modal hide fade" id="confirm">
			<div class="modal-header">
				<a class="close" href="javascript:closeConfirmModal()">X</a>
				<h3>Cancel Leg</h3>
			</div>
			<div class="modal-body" style="margin-top:-16px;">
				<div class="row">
					<p><b>Are you sure you want to cancel?</b><br>
					Any changes you have made will be lost
					</p>
				</div>
			</div>
			<div class="modal-footer">
				<a href="${pageContext.request.contextPath}/frontoffice/RCALegRequest.do?command=redirectFundingRequest&isFrontOffice=Yes" class="btn right btn-success">Yes, cancel the leg</a>
				<a class="btn-link right cancel" href="javascript:closeConfirmModal()">No, take me back to the Leg</a>
			</div>
		</div>
		
         