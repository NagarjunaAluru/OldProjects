<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setLocale value="en-US"/>
<%@ page errorPage="../common/error.jsp" %>

    <title>ICF | Add a Request</title>
    <meta name="description" content="">
    <meta name="author" content="">
<% String servletContextUrl = request.getContextPath();   
%>
	<%
String addOrMofifyJS = (String)request.getSession().getAttribute("addOrModifyFlag");
String legLenforJS ="0";
if(addOrMofifyJS==null) {
	legLenforJS ="1";
} else {
	legLenforJS ="0";
}

%>
					
<script>
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
	<script src="<%= servletContextUrl%>/js/cpaRequest.js" type="text/javascript"></script>
	<script src="<%= servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/pagination.js"></script>
		<div id="validateFlag" style="display:none;" class="alert fade in alert-danger hide">
            <a href="#" class="close" onclick="javascript:closeMessage();">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
		<div class="alert fade in alert-success hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>You have successfully added a new leg to this transaction.</strong> 
			<a href="#" class="btn-link">Add another leg</a> |
			<a href="#legTable" class="btn-link">Go to table</a>
        </div>
         <div id="updateMessageID" class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
           			 <a href="#" data-dismiss="alert" class="close">X</a>
           		     <strong><font color="green">${requestScope.UpdateMessage}</font></strong> 
         </div>
         <div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
             <a href="#" data-dismiss="alert" class="close">X</a>
             <strong>${requestScope.atmtError}</strong> 
        </div>
        
		<html:form action="/CPALegRequest.do"  styleId="cpaLegRequestForm"  method="post"  enctype="multipart/form-data">
		<c:set var="legNumber" value="${sessionScope.cpaLegRequestForm.map['legNumber']}" />
		<input type="hidden" name="legNumber" id="legNumber" value="<bean:write name="cpaLegRequestForm" property="legNumber" />" />
			<html:hidden name="cpaLegRequestForm" property="cpaSummary.legTypeId" value="3" />
			<input type="hidden" id="actionId" value="${requestScope.actionId}">
		<div class="form-mod entitylookup">
			<h2 class="span12">Details</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>Vault Request ID</label>
						<logic:messagesPresent property="vaultId">
							<span class="req-error" >a</span>
						  </logic:messagesPresent>
						<html:text name="cpaLegRequestForm" style="float:left;"  property="vaultId"  onkeyup="javascript:validateVaultDetails()"  styleId="vaultTextID" maxlength="50"   />
						<a href="#vaultRequestScreenID" id="valultReqIDLookupID"  onclick="javascript:getVaultDetails()"  class="initiate btn right cancel" style="float:left;"> Lookup</a>
					   <div class="clear">
					   </div>
					</div>
				</div>
			</div>
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
						<span class="help-block invalid error" id="lenderTreasuryDuplicate" style="display:none;">Tcode already selected</span>						
					    <input type="text" maxlength="20" data-provide="typeahead" data-source="" name="treasuryCode"  id="lenderTreasuryCode"  style="text-transform:uppercase"/> 
					    <span id="lenderTreasuryfailedBar" class="req-error" style="display:none;">error</span>
					    <a class="btn addtcode" type="submit" data-assign="cpaSummary.participantTCodeEntities" 
					    data-bankassign="cpaSummary.participantEntity.bankTreasuryCd">Search</a>
						

						<a id="clearCPALenderTreasury"  class="btn-link right" type="submit"> 
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
								<div id="lenBusSegFDiv">
									<p class="businessSegment"><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.businessSegment" /></p>
								</div>
							</logic:notEmpty>
							<html:hidden name="cpaLegRequestForm" property="cpaSummary.participantEntity.businessSegment"  styleId="partBusSegID"  styleClass="businessSegment" />
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
	                       			<input type="hidden" id="showTreasuryCode" value="true"/>
                       			</c:if>
                       		</p> 
							<html:hidden  name="cpaSummaryForm" property="participantTCodeEntities"  value="" ></html:hidden>						
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
							<html:hidden styleId="participantBankNameID" name="cpaLegRequestForm"  property="cpaSummary.participantEntity.bankTreasuryCd" />
							
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
		<div class="form-mod entitylookup">
		<span class="required">*</span>
		<h3 class="span12">Pool Leader</h3>
		<span class="sub">Select one or more options to search Cash Pool</span>
		
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<label>Region</label>
						<span  class="req-error" id="poolLeaderEntityErrorId" style="display:none;">a </span>
						<html:select name="cpaLegRequestForm" property="cpaSummary.region" styleId="regionId" styleClass="span2" >
							<html:option value=""><bean:message key="label.addLeg.select" /></html:option>		
							<html:optionsCollection name="com.ge.icfp.MasterData" property="regions" value="id" label="name"/>	
						</html:select>
					</div>
				</div> <!-- end of block -->
				<div class="span2">
					<div class="form-row">
						<label>Country</label>
						<html:select name="cpaLegRequestForm" property="cpaSummary.country" styleId="countryId" styleClass="span2" >
							<html:option value=""><bean:message key="label.addLeg.select" /></html:option>		
							<html:optionsCollection name="com.ge.icfp.MasterData" property="countries" value="id" label="name"/>	
						</html:select>
					</div>
				</div> <!-- end of block -->
				<div class="span2">
					<div class="form-row">
						<label>Currency</label>
						<html:select name="cpaLegRequestForm" property="cpaSummary.currencyCd" styleId="currencyId" styleClass="span2" >
							<html:option value=""><bean:message key="label.addLeg.select" /></html:option>		
							<html:optionsCollection name="com.ge.icfp.MasterData" property="dealCurrencies" value="id" label="name"/>	
						</html:select>
					</div>
				</div> <!-- end of block -->
				<div class="span5">
					<div class="form-row" >
						<label>Treasury Code</label>
						 <input type="text" maxlength="20" name="poolTreasuryCode"  id="poolTreasuryCodeID"  style="text-transform:uppercase;margin-top:-7px;"/>
						 <a type="submit" class="btn leader-search" id="poolLeaderEntityId">Search</a>
					</div>
					
				</div> <!-- end of block -->
			</div>
			<div class="leader-search-results" id="cashPoolID">
			 <div class="row">
	  			<div  class="span2 left">
				    <label>Results : ${poolLeaderSize}</label>
				     <input type="hidden" name="recordCount" id="recordCountID" value="${recordCount}"/>
				     <input type="hidden" name="prevPageNumber" id="prevPageStart"  value="${prevPageNumber}"/>
				     <input type="hidden" name="nextPageNumber" id="nextPageStart"  value="${nextPageNumber}"/>

				  
				 </div>   				 
	  	    </div>
	  	     <div class="row" style="margin-left:-1px;">
	  	     	<p class="left clear"><bean:message key="label.moreRecords.cpamessage" /></p>
	  	     </div>	
				<div class="row" id="processDivID">
					<div class="span12">
						<span  class="help-block error" id="cashpoolSelect" style="display:none;">Please select Cash Pool </span>
						<table class="table table-striped table-bordered no-bottom paginate">
							<thead>
							  <tr>
								<th style="width:10px;"></th>
								<th>Pool Leader Name</th>
								<th>Region</th>
								<th>Country</th>
								<th>Currency</th>
							  </tr>
							</thead>
							<tbody>
							<logic:present name="cashPools" scope="request" >
							 
								<logic:iterate id="cashPool" name="cashPools" scope="request" indexId="i">
									<tr>
										<td><input type="radio" name="cashPoolOptions" id="optionsRadiosID" value="${cashPool.accountId}"></td>
										<td style="width:450px">${cashPool.legalEntity} - ${cashPool.country} - ${cashPool.currency} - ${cashPool.treasuryCode} - ${cashPool.bankName} </td>
										<td>${cashPool.region}</td>
										<td>${cashPool.country}</td>
										<td>${cashPool.currency}</td>
									</tr>
								</logic:iterate>
							</logic:present>
							</tbody>
						</table>
						   <div class="row span4 right" id="pageDivID">
								    <div style="width:280px;border:0px solid red;margin-top:10px;">
								    	<div style="width:120px;border:0px solid red;" class="left">
								    		<a type="submit"  id="previousID" href="#" class="leader-search" onclick="getPoolDetails('prev')"><img src="<%= servletContextUrl%>/images/prevBtn.gif"></a>
								    	</div>
								    	<div style="width:120px;text-align:right;border:0px solid red;" class="right">
								    		<a type="submit"  id="nextID" href="#" class="leader-search" onclick="getPoolDetails('next')"><img src="<%= servletContextUrl%>/images/nextBtn.gif"></a>
								    	</div>
								    	<div class="clear"></div>								    	
								   </div>
						    </div>
							<div class="row">
					  			<div class="span9 pagination pagination-right">
					     			<ul></ul>
					     		</div>
					        	<div class="span3 jump-page">
						     		Jump to
						    	<input type="text" class="span1 manual">
								<a class="btn jumpto" type="submit">Go</a>
								</div>
						    </div>
							<input type='hidden' id='current_page' />
						</div>
						<div class="span4 right leader-btn-container" >
						<div class="form-row">
							<a type="submit" class="btn right" onclick="saveSelectionClick()" id="saveSelectionId">Save selection</a>
							<a type="submit" href="#" class="btn-link right leader-clear">Clear result</a>
						</div>
					</div> <!-- end of block -->
				</div>
			</div>
			
			
			
			<div class="leader-saved-results" id="poolLeaderIdDetails" >
			
			<input type="hidden" name="region" id="regionID" value='<bean:write name="cpaLegRequestForm" property="cpaSummary.region"/>'/>
			<input type="hidden" name="country" id="countryID" value='<bean:write name="cpaLegRequestForm" property="cpaSummary.country"/>'/>
			<input type="hidden" name="currencyCd" id="currencyCdID" value='<bean:write name="cpaLegRequestForm" property="cpaSummary.currencyCd"/>'/>
	
			
			<a class="btn-link right clear-conditional-results" href="#" type="submit" onclick="javascript:clearLEDetails();"></a>
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b>Cash Pool Name</b></p>
							<logic:empty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName">
								<p><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName" /></p>
							</logic:notEmpty>
						</div>
					</div><!-- end of block -->
						<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName" />
					<div class="span5 right">
						<div class="form-row">
							<p><b>Legal Entity Gold ID</b></p>
							<logic:empty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEGoldId">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEGoldId">
								<p><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEGoldId" /></p>
							</logic:notEmpty>
						</div>
					</div><!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEGoldId"  styleId="poolLeGoldId"  />
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<p><b>CDR code</b></p>
							<logic:empty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.CDRCd">
								<p class="cdrCd">-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.CDRCd">
								<p class="cdrCd"><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.CDRCd"/></p>
							</logic:notEmpty>
						</div>
					</div><!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.CDRCd" />
					<div class="span5 right">
						<div class="form-row">
							<p><b>Country</b></p>
							<logic:empty  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.country">
								<p class="country">-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.country">
								<p  class="country" id="cashPoolNameId"><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.country" /></p>
							</logic:notEmpty>
						</div>
					</div><!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.country" />
				</div>
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b>Legal Entity Name</b></p>
							<logic:empty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName">
								<p class="leName">-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName">
								<p class="leName"><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName" /></p>
							</logic:notEmpty>
						</div>
					</div><!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.LEName" styleClass="leName" />
					
				</div>	
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<p><b>Is Pool/Leader a regulated Entity?</b></p>
							<logic:empty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.regulatedEntityFlag" >
								<p class="regulatedEntityFlag">-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.regulatedEntityFlag" >
								<logic:equal name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.regulatedEntityFlag" value="true">
									<p class="regulatedEntityFlag">Yes</p>
								</logic:equal>
								<logic:equal name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.regulatedEntityFlag" value="false">
									<p class="regulatedEntityFlag">No</p>
								</logic:equal>
							</logic:notEmpty>
						</div>
					</div><!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.regulatedEntityFlag" styleClass="regulatedEntityFlag"/>
					<div class="span5 right">
						<div class="form-row">
							<p><b>Is Pool/Leader  a principal Entity?</b></p>
									<logic:empty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.princplEntityFlag" >
										<p class="princplEntityFlag">-</p>
									</logic:empty>
									<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.princplEntityFlag" >
										<logic:equal name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.princplEntityFlag" value="true">
											<p class="princplEntityFlag">Yes</p>
										</logic:equal>
										<logic:equal name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.princplEntityFlag" value="false">
											<p class="princplEntityFlag">No</p>
										</logic:equal>
									</logic:notEmpty>
						</div>
					</div><!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.princplEntityFlag" styleClass="princplEntityFlag"/>
					
				</div>	
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<label>Management Entity</label>
							<logic:empty  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.MEName">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.MEName">
								<p><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.MEName" /></p>
							</logic:notEmpty>
						</div>
					</div> <!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.MEName" />
					<div class="span5 right">
						<div class="form-row">
							<label>Capital or Industrial</label>
							<logic:empty  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.capitalIndustrial">
								<p class="capitalIndustrial">-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.capitalIndustrial">
								<p class="capitalIndustrial"><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.capitalIndustrial" /></p>
							</logic:notEmpty>
						</div>
					</div> <!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.leType" styleClass="capitalIndustrial"/>
					
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<label>Bank Name</label>
							<logic:empty  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.bankTreasuryCd">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.bankTreasuryCd">
								<p><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.bankTreasuryCd" /></p>
							</logic:notEmpty>
						</div>
					</div> <!-- end of block -->
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.bankTreasuryCd" />
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.bnkName" />
					<div class="span5 right">
						<div class="form-row">
							<label>Business Segment</label>
							<div class="radio-container">
								<logic:empty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.businessSegment" >
									<p class="businessSegment">-</p>
								</logic:empty>
								<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.businessSegment" >
										<p class="businessSegment"><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.businessSegment" /></p>
								</logic:notEmpty>
							</div>
							<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.businessSegment" styleClass="businessSegment"/>							
						</div>
					</div> <!-- end of block -->
					
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<label><bean:message key="label.addLeg.treasuryCode" />
							</label>
							
							<logic:empty  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.treasuryCode">
								<p>-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.treasuryCode">
								<p><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.treasuryCode" /></p>
							</logic:notEmpty>
							<html:hidden  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.treasuryCode" />
						</div>
					</div> <!-- end of block -->
			
					
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
							 <html:select name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.fundHoldOperationId" styleClass="span2" styleId="poolFunCompany">
								<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
								<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
	 						</html:select>  
						</div>
					</div> <!-- end of block -->
				</div>
			<c:set var="rateInfoVO" value="${deal:fetchRateInfo(legNumber, pageContext.request)}" scope="page"/>
			<h3>Rate Information</h3>
			 
				<div class="row highlighted">
					<div class="span5">
						<div class="form-row">
							<p><b>Interest Rate Index</b></p>
							<p>
								<c:if test="${empty rateInfoVO.floatingRateIndex}">
									-
								</c:if>
								<c:if test="${not empty rateInfoVO.floatingRateIndex}">
									${rateInfoVO.floatingRateIndex}
								</c:if>
							</p>
						</div>
					</div><!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<p><b>Index Term</b></p>
							<p>
								<c:if test="${empty rateInfoVO.floatingRateIndexTerm}">
									-
								</c:if>
								<c:if test="${not empty rateInfoVO.floatingRateIndexTerm}">
									${rateInfoVO.floatingRateIndexTerm}
								</c:if>
							</p>
						</div>
					</div><!-- end of block -->
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<p><b>Deposit Spread (bps)</b></p>
							<p>
								<c:if test="${empty rateInfoVO.maxSpread}">
									-
								</c:if>
								<c:if test="${not empty rateInfoVO.maxSpread}">
									${rateInfoVO.maxSpread}
								</c:if>
							</p>
						</div>
					</div><!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<p><b>Borrowing Spread (bps)</b></p>
							<p>
								<c:if test="${empty rateInfoVO.minSpread}">
									-
								</c:if	>
								<c:if test="${not empty rateInfoVO.minSpread}">
									${rateInfoVO.minSpread}
								</c:if>
							</p>
						</div>
					</div><!-- end of block -->
				</div>
			
			</div>
		</div> <!-- end of form mod -->
			

		<div class="form-mod">
		<h3 class="span12">Other Considerations</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Cross Border<span class="ttip info" data-original-title="<bean:message key="label.tooltip.crossBoarder" />"></span></label>
						<span  class="help-block error" id="crossBorderFlagFailed" style="display:none;">Please select</span>
						<div id="crossBoarderDiv" class="radio-container">
							<label class="radio">
								<html:radio name="cpaLegRequestForm" styleClass="condition" styleId="crossBorderFlagId" property="crossBorderFlag" value="true"/>
								Yes
							</label>
							<label class="radio">
								<html:radio name="cpaLegRequestForm" property="crossBorderFlag" styleId="crossBorderFlagId" value="false"/>
								No
							</label>
						</div>
					</div>
				</div> <!-- end of block -->
				<div id="termDiv" class="span5 right">
					<div class="form-row">
						<div id="termMandatoryDiv"><span class="required">*</span></div>
						<label>
							<bean:message key="label.addLeg.term" /> 
							<span class="small"><bean:message key="label.addLeg.inMonths" /></span>
							<span data-original-title="<bean:message key="tooltip.addLeg.termInMonths" />" class="ttip info"></span>
						</label>
						<span  class="help-block error" id="termValidate" style="display:none;">Please enter Term</span>
						<span  class="help-block error" id="termValidateNumber" style="display:none;">Invalid value </span>
						<html:text name="cpaLegRequestForm" property="cpaSummary.term" maxlength="9" styleClass="span1" styleId="termInMonths" />
						<span id="termValidateBar" class="req-error" style="display:none;">error</span>
					</div>
	 			</div>
			</div>
			<div class="row">
				 
	 			<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Non-standard Legal Agreement(s)<span class="ttip info" data-original-title="<bean:message key="label.tooltip.nonStaLegAgr" />"></span></label>
						<span  class="help-block error" id="legalAgreementfailed" style="display:none;">Please select Non-standard Legal Agreement(s)</span>
						<div id="legalAgreementDiv" class="radio-container exceptionsConditional">
							<label class="radio">
								<html:radio name="cpaLegRequestForm" styleClass="condition" styleId="isNonStandardLegalAgreement" property="nonStandardAgreementsFlag" value="true"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="cpaLegRequestForm" property="nonStandardAgreementsFlag" styleId="isNonStandardLegalAgreement" value="false"/>
								<bean:message key="label.addLeg.no" />
							</label>
						</div>
						</div>
					</div>
			</div>
			</div>
			
			<!--  Exceptions -->
	      <jsp:include page="/jsp/common/legPageExceptions.jsp">
			<jsp:param value="edit" name="mode"/>
			<jsp:param value="${legNumber}" name="legIndex"/>      	
	      </jsp:include>

		
		  <!-- starts uploads-->
         <jsp:include page="/jsp/common/attachments/cpaLegPageAttachments.jsp">
        	<jsp:param name="mode" value="edit" />
     	   </jsp:include> 
        <!-- end uploads -->
		
		
		
		<div class="span8 right btn-container">
		<input type="hidden" name="productType" value="CPA"/>
		<c:if test="${sessionScope.section eq 'myTasks'}">
			  <input type="button" value="Save and return to Request" class="btn right btn-success" onclick="javascript:validate('?command=saveAndReturnToDeal&productType=CPA');">
			  <input type="button" value="Save" class="btn right" onclick="javascript:saveAsDraft('?command=saveAsDraft&productType=CPA');">
		</c:if>
		<c:if test="${sessionScope.section eq 'myRequests'}">
			<c:choose>
					<c:when test="${empty deal.WFStage}">
					<c:if test="${deal.action eq 'Draft' || deal.action eq 'DRAFT'}"> 
						<input type="button" value="Save and return to Request" class="btn right btn-success" onclick="javascript:validate('?command=saveAndReturnToDeal&productType=CPA');">
						<input type="button" value="Save" class="btn right" onclick="javascript:saveAsDraft('?command=saveAsDraft&productType=CPA');">
					</c:if>
					<c:if test="${empty deal.action}"> 
						<input type="button" value="Save and return to Request" class="btn right btn-success" onclick="javascript:validate('?command=saveAndReturnToDeal&productType=CPA');">
						<input type="button" value="Save" class="btn right" onclick="javascript:saveAsDraft('?command=saveAsDraft&productType=CPA');">
					</c:if>
					</c:when>
			</c:choose>
		</c:if>
			<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" >Cancel</a>
		</div>
		
		</html:form>
   <hr>
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" href="javascript:closeConfirmModal()">X</a>
			<h3>Cancel Financing Request</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="javascript:redirectFundingRequest('?command=redirectFundingRequest');" class="btn right btn-success">Yes, cancel the request</a>
			<a class="btn-link right cancel" href="javascript:closeConfirmModal()">No, take me back to the request</a>
		</div>
	</div>
	<!-- Modals start -->
	<div class="modal hide fade" id="derivatives">
			<div class="modal-header">
				<a class="close" href="javascript:closeDerivativesModal()">X</a>
				<h3>Add a Derivatives</h3>
			</div>
			<div class="modal-body" style="margin-top:-16px;">
				<div class="row">
					<div class="span4">
						<div class="form-row">
							<span class="required">*</span>
							<label>Derivatives?</label>
							<div class="radio-container">
								<label class="radio">
									<input type="radio" value="option1" name="optionsRadios">
									Internal
								</label>
								<label class="radio">
									<input type="radio" value="option1" name="optionsRadios">
									External
								</label>
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span4 right">
						<div class="form-row">
							<label>Hedge Designation  - U.S. GAAP</label>
							<select class="span2">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span4">
						<div class="form-row">
							<span class="required">*</span>
							<label>Derivative type</label>
							<select class="span2">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							  </select>
						</div>
					</div> <!-- end of block -->
					<div class="span4 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Hedge program</label>
							<select class="span2">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							  </select>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<span class="required">*</span>
							<label>Currency Pair</label>
							<select class="span1 left dual-selects">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
					<div class="span2">
						<div class="form-row">
							<label>&nbsp;</label>
							<select class="span1 left dual-selects">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
					
					<div class="span4 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Contract class</label>
							<select class="span2">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
					
				</div>
				
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<div class="left">
								<span class="required">*</span>
								<label>Amount</label>
								<input type="text" class="span1 dual-selects"> 
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span2">
						<div class="form-row">
							<div class="left">
								<label>Amount</label>
								<input type="text" class="span1 dual-selects"> 
							</div>
						</div>
					</div> <!-- end of block -->
					
					<div class="span4 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Tax Designation </label>
							<select class="span2">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<span class="required">*</span>
							<label>Fix or Float</label>
							<div class="radio-container conditional-radio-tri">
								<label class="radio">
									<input type="radio"value="High" name="optionsRadios" class="condition">
									Fixed
								</label>
								<div class="conditional-container">
									<div class="form-row">
											<span class="required">*</span>
											<label>Amount</label>
											<input type="text" class="span1 dual-selects"> 
									</div>
								</div>
								<label class="radio">
									<input type="radio"value="Medium" name="optionsRadios" class="condition">
									Float
								</label>
								<div class="conditional-container">
									<div class="form-row">
										<span class="required">*</span>
										<label>Index 1</label>
										<select class="span2 dual-selects">
											<option>Select...</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
										</select> 
									</div>
								</div>
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span2">
						<div class="form-row">
							<span class="required">*</span>
							<label>Fix or Float</label>
							<div class="radio-container conditional-radio-tri">
								<label class="radio">
									<input type="radio"value="High" name="optionsRadios" class="condition">
									Fixed
								</label>
								<div class="conditional-container">
									<div class="form-row">
											<span class="required">*</span>
											<label>Amount</label>
											<input type="text" class="span1 dual-selects"> 
									</div>
								</div>
								<label class="radio">
									<input type="radio"value="Medium" name="optionsRadios" class="condition">
									Float
								</label>
								<div class="conditional-container">
									<div class="form-row">
										<span class="required">*</span>
										<label>Index 2</label>
										<select class="span2 dual-selects">
											<option>Select...</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
										</select> 
									</div>
								</div>
							</div>
						</div>
					</div> <!-- end of block -->
					
				</div>
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<div class="left">
								<span class="required">*</span>
								<label>Spread (bps)</label>
								<input type="text" class="span1 dual-selects"> 
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span2">
						<div class="form-row">
							<div class="left">
								<label>&nbsp;</label>
								<input type="text" class="span1 dual-selects"> 
							</div>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<span class="required">*</span>
							<label>Day count</label>
							<select class="span1 left dual-selects">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
					<div class="span2">
						<div class="form-row">
							<label>&nbsp;</label>
							<select class="span1 left dual-selects">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<span class="required">*</span>
							<label class="nowrap">Interest reset frequency</label>
							<select class="span1 left dual-selects">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
					<div class="span2">
						<div class="form-row">
							<label>&nbsp;</label>
							<select class="span1 left dual-selects">
								<option>Select...</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div> <!-- end of block -->
				</div>
				
			</div>
			
			
			<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" id="saveDerivative" data-dismiss="modal">Save</a>
			<a href="#" class="btn right">Save and add new Derivative</a>
			<a href="javascript:closeDerivativesModal()" class="btn-link right cancel">Close window</a>			</div>
	</div>
	<div class="modal hide fade" id="attach">
			<div class="modal-header">
				<a class="close" href="javascript:closeAttachModal()">X</a>
				<h3>Attach <span></span></h3>
			</div>
			<div class="modal-body" style="margin-top:-16px;">
			<form>
			<p>Add a document to <span></span>.</p>
				<h2><span class="required required-td">*</span>1. Select a Leg to attach a document</h2>
				<div class="row">
					<div class="span9">
						 <table class="table table-striped table-bordered sortable no-bottom">
							<thead>
							  <tr>
								<th rowspan="2">Select</th>
								<th rowspan="2">Leg #</th>
								<th rowspan="2">Product Type</th>
								<th rowspan="2">Term <span class="small">in months</span></th>
								<th colspan="2" class="nosort">Participant</th>
								<th colspan="2" class="nosort">Borrower</th>
								<th colspan="2" class="nosort">Original Currency</th>
								<th rowspan="2">USD Equivalent</th>
								<th rowspan="2">Derivatives</th>
								<th rowspan="2">Existing</th>
							  </tr>
							  <tr>
								<th>Legal Entity</th>
								<th>Country</th>
								<th>Legal Entity</th>
								<th>Country</th>
								<th>Currency</th>
								<th>Amount</th>

							  </tr>
							</thead>
							<tbody>
							  <tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>1</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr><tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>2</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr><tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>3</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr><tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>5</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr><tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>4</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr>
							</tbody>
						  </table>
						  <label class="checkbox apply-to-all" >
					<input type="checkbox" class="" id="optionsCheckbox" value="option1">
					Apply this Attachment to all Legs
				</label>
				</div><!-- end of block -->
				
				</div>
				<h2><span class="required required-td">*</span>2. Attachment document</h2>
				<div class="row">
					<div class="span4">
						<div class="form-row">
							<input type="file" id="fileInput" class="input-file-attach" >
						</div>
					</div> <!-- end of block -->

				</div>
			</form>
			</div>
			<div class="modal-footer">
				<a href="#derivatives-table" class="btn right btn-success" id="saveAttachment" data-dismiss="modal">Save</a>
				<a href="javascript:closeAttachModal()" class="btn-link right cancel">Close window</a>
			</div>
	</div>
  	
	<div class="modal hide fade" id="lookup">
		<div class="modal-header">
			<a class="close" href="javascript:closeLookUpModal()">X</a>
			<h3>Lookup Results</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			<div class="alert fade in alert-danger hide">
            	<a href="#" data-dismiss="alert" class="close">X</a>
            	<strong>Select one to save.</strong> 
        	</div>
			<div class="form-row autosize-container">
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn right btn-success saveSelectEntity">Save selection</a>
			<a class="btn-link right cancel" href="javascript:closeLookUpModal()">Cancel</a>
		</div>
	</div>

