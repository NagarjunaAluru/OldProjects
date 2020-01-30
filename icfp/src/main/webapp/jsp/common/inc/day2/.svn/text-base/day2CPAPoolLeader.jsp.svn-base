<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<script src="${pageContext.request.contextPath}/js/pagination.js"></script>
<div class="form-mod entitylookup">
<c:set var="rateInfoVO" value="${deal:fetchRateInfo(legNumber, pageContext.request)}" scope="page"/>
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
				 </div>   
	  	    </div>
	  	    <div class="row" style="margin-left:-1px;">
	  	     	<p class="left clear"><bean:message key="label.moreRecords.cpamessage" /></p>
	  	     </div>
	  	     
				<div class="row"  id="processDivID">
					
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
							<tbody >
							<logic:present name="cashPools" scope="request" >
							 
								<logic:iterate id="cashPool" name="cashPools" scope="request" indexId="i">
									<tr>
										<td><input type="radio" name="cashPoolOptions" id="optionsRadiosID" value="${cashPool.accountId}"></td>
										<td>${cashPool.legalEntity} - ${cashPool.country} - ${cashPool.currency} - ${cashPool.treasuryCode} - ${cashPool.bankName}</td>
										<td>${cashPool.region}</td>
										<td>${cashPool.country}</td>
										<td>${cashPool.currency}</td>
									</tr>
								</logic:iterate>
							</logic:present>
							</tbody>
						</table>
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
					<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.capitalIndustrial" styleClass="capitalIndustrial"/>
					
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
							<html:hidden name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.businessSegment"  styleClass="businessSegment" />
						</div>
					</div> <!-- end of block -->
					
				</div>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<label><bean:message key="label.addLeg.treasuryCode" />
							</label>
							
							<logic:empty  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.treasuryCode">
								<p class="treasuryCode">-</p>
							</logic:empty>
							<logic:notEmpty name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.treasuryCode">
								<p class="treasuryCode"><bean:write name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.treasuryCode" /></p>
							</logic:notEmpty>
							<html:hidden  name="cpaLegRequestForm" property="cpaSummary.poolLeaderEntity.treasuryCode" styleClass="treasuryCode"/>
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
				<h3>Rate Information</h3>
				<div class="row highlighted">
						<div class="span5">
							<div class="form-row">
								<p>
									<b>Interest Rate Index</b>
								</p>
								<p>
									<c:if test="${empty rateInfoVO.floatingRateIndex}">
										-
									</c:if>
									<c:if test="${not empty rateInfoVO.floatingRateIndex}">
										${rateInfoVO.floatingRateIndex}
									</c:if>
								</p>
							</div>
						</div>
						<!-- end of block -->
						<div class="span5 right">
							<div class="form-row">
								<p>
									<b>Index Term</b>
								</p>
								<p>
									<c:if test="${empty rateInfoVO.floatingRateIndexTerm}">
										-
									</c:if>
									<c:if test="${not empty rateInfoVO.floatingRateIndexTerm}">
										${rateInfoVO.floatingRateIndexTerm}
									</c:if>
								</p>
							</div>
						</div>
						<!-- end of block -->
					</div>
					<div class="row">
						<div class="span5">
							<div class="form-row">
								<p>
									<b>Deposit Spread (bps)</b>
								</p>
								<p>
									<c:if test="${empty rateInfoVO.maxSpread}">
										-
									</c:if>
									<c:if test="${not empty rateInfoVO.maxSpread}">
										${rateInfoVO.maxSpread}
									</c:if>
								</p>
							</div>
						</div>
						<!-- end of block -->
						<div class="span5 right">
							<div class="form-row">
								<p>
									<b>Borrowing Spread (bps)</b>
								</p>
								<p>
									<c:if test="${empty rateInfoVO.minSpread}">
										-
									</c:if>
									<c:if test="${not empty rateInfoVO.minSpread}">
										${rateInfoVO.minSpread}
									</c:if>
								</p>
							</div>
						</div>
						<!-- end of block -->
					</div>
			</div>
		</div> <!-- end of form mod -->
			