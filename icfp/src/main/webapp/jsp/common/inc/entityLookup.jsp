<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="html" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>

<c:set var="item" value="${param.entityName}" />
<c:set var="cdr">PEntities[${item}].CDRCd</c:set>
<c:set var="goldId">PEntities[${item}].LEGoldId</c:set>
<c:set var="leName">PEntities[${item}].LEName</c:set>
<c:set var="country">PEntities[${item}].country</c:set>
<c:set var="regulatedFlag">PEntities[${item}].regulatedEntityFlag</c:set>
<c:set var="principalFlag">PEntities[${item}].princplEntityFlag</c:set>
<c:set var="businessSegment">PEntities[${item}].businessSegment</c:set>
<c:set var="capitalIndustrial">PEntities[${item}].capitalIndustrial</c:set>
<c:set var="meName">PEntities[${item}].MEName</c:set>
<c:set var="whichCompany">PEntities[${item}].fundHoldOperationId</c:set>
<c:set var="tcodeName">PEntities[${item}].treasuryCodes</c:set>

<c:set var="entityName"><t:getEntityName/></c:set>
<c:set var="MEval">${sessionScope.inputform.PEntities[item].MEName}</c:set>
<c:set var="bsval">${sessionScope.inputform.PEntities[item].businessSegment}</c:set>
<c:set var="whichCompanayVal">
	${sessionScope.inputform.PEntities[item].fundHoldOperationId}
</c:set>
<c:if test="${requestScope.vaultLookup}">
	<c:set var="isVaultLooup" value="true"/>
	<c:set var="vaultCdr" value="${sessionScope.inputform.PEntities[item].CDRCd}"/>
	<c:set var="vaultGoldId" value="${sessionScope.inputform.PEntities[item].LEGoldId}"/>
	<c:set var="vaultLEName" value="${sessionScope.inputform.PEntities[item].LEName}"/>
	<c:set var="vaultCountry" value="${sessionScope.inputform.PEntities[item].country}"/>
</c:if>

<div id="1" class="form-mod entitylookup">
<h3>${entityName}</h3>

<div class="form-row">
<span class="required">*</span>
<label>
	${entityName}
	<span class="ttip info" 
		data-original-title="<bean:message key="label.tooltip.lenderProvider" />">
	</span>
</label>
</div>
 
<div class="row">
<div class="span search-container">
	<div class="form-row">
		<span  class="help-block notfound error" style="display:none;">
			Invalid value
		</span>		
		<select class="span2 entity-filtername">
			<option value="CDR"><bean:message key="label.adLeg.cdr" /></option>
			<option value="GOLD"><bean:message key="label.adLeg.goldId" /></option>
		</select>
		<input type="text" class="span3 entity-filtervalue" style="text-transform:uppercase; margin-top: -10px!important; margin-left: 10px;"/>
		<span class="req-error" style="display:none;">error</span>		
		<a class="btn entity-lookup" type="submit" data-cmd="getLE" style="margin-top: -11px!important;">Search</a>
		
		<a class="btn-link clear-conditional-results" type="submit" >
			<bean:message key="label.addLeg.clearResults" />
		</a>
		
	</div>
</div>
</div> 
<div class="${isVaultLooup ? '' : 'conditional-row'}">
<div class="row highlighted">
	<div class="span5">
		<div class="form-row">
			<p><b><bean:message key="label.addLeg.cdrCode" /></b></p>
			<p class="cdrCd">${isVaultLooup? vaultCdr : '-'}</p>
			<input type="hidden" class="cdrCd" name="${cdr}" value="${isVaultLooup? vaultCdr : ''}"/>
		</div>
	</div><!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p><b><bean:message key="label.addLeg.legalEntityGoldId" /></b></p>
			<p class="leGoldId">${isVaultLooup? vaultGoldId : '-'}</p>
			<input type="hidden" class="leGoldId" name="${goldId}" value="${isVaultLooup? vaultGoldId : ''}"/>
		</div>
	</div><!-- end of block -->
</div>
<div class="row">
	<div class="span5">
		<div class="form-row">
			<p><b><bean:message key="label.addLeg.legalEntityName" /></b></p>
			<p class="leName">${isVaultLooup? vaultLEName : '-'}</p>
			<input type="hidden" class="leName" name="${leName}" value="${isVaultLooup? vaultLEName : ''}"/>
		</div>
	</div><!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p><b><bean:message key="label.addLeg.country" /></b></p>
			<p class="country">${isVaultLooup? vaultCountry : '-'}</p>
			<input type="hidden" class="country" name="${country}" value="${isVaultLooup? vaultCountry : ''}"/>
		</div>
	</div><!-- end of block -->
</div>
</div>

<div class="row ">
	<div class="span5">
		<div class="form-row">		
			<p><b>Is ${entityName} a Regulated Entity?</b></p>
	
			<div class="radio-container regulatedEntityFlag">
				<label class="radio" style="font-weight:normal;">
					<html:radio name="inputform" property="${regulatedFlag}" disabled="disabled" styleClass=""  value="true"/>
					<bean:message key="label.addLeg.yes" />
				</label>
				<label class="radio"  style="font-weight:normal;">
					<html:radio name="inputform" property="${regulatedFlag}" disabled="disabled" value="false"/>
					<bean:message key="label.addLeg.no" />
				</label>
			</div>
			
		</div>
	</div><!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p><b>Is ${entityName} a Principal Entity?</b></p>
			
			<div class="radio-container princplEntityFlag">
				<label class="radio" style="font-weight:normal;">
					<html:radio name="inputform" property="${principalFlag}" disabled="disabled" value="true"/>
					<bean:message key="label.addLeg.yes" />
				</label>
				<label class="radio"  style="font-weight:normal;">
					<html:radio name="inputform" property="${principalFlag}" disabled="disabled" value="false"/>
					<bean:message key="label.addLeg.no" />
				</label>
			</div>
			
		</div>
	</div><!-- end of block -->
</div>

<div class="row">
	<div class="span5">
		<div class="form-row">
			<span class="required">*</span>
			<label><bean:message key="label.addLeg.managementEntity" /><span class="ttip info" data-original-title="<bean:message key="label.tooltip.managementEntity" />"></span></label>
			<span  class="help-block error" style="display:none;">
				Please select Management Entity 
			</span>			
			<input type="text" class="span2" style="text-transform:uppercase"/>
			<a href="#1" class="btn me-lookup" type="submit">Search</a>
			<a href="#1" class="btn-link clear-conditional-results">Clear results</a>
			<span class="req-error" style="display:none;">error</span>
		</div>					
	</div> <!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<label>
				<bean:message key="label.addLeg.capitalOrIndustrial" />				
			</label>
			<span class="help-block error" style="display:none;">
				Please select Capital or Industrial 
			</span>
			<p class="capitalIndustrial">-</p>
			<input type="hidden" name="${capitalIndustrial}" class="capitalIndustrial" />
		</div>
	</div> <!-- end of block -->	
</div>
			
<div class="ME conditional-row">
	<div class="row">
	<div class="span3 highlighted">
		<div class="form-row">						
			<p>${MEval}</p>
			<input type="hidden" name="${meName}" value="${MEval}"/>
		</div>					
	</div>		
	</div>			
</div>	

<div class="row">
	<div class="span5">
		<div class="form-row">
			<label>
				<bean:message key="label.addLeg.treasuryCode" />
				<span class="ttip info" data-original-title="<bean:message key="label.tooltip.Tcode" />"></span>
			</label>
			<span  class="help-block error" style="display:none;"></span>			
			<input type="text" maxlength="20"  class="span3" 
				data-provide="typeahead" style="text-transform:uppercase" data-source=""/>
			<span class="req-error" style="display:none;">error</span>
			<a class="btn addtcode" data-assign="${tcodeName}"
				 type="submit">Search</a>
			<a class="btn-link right clear-conditional-results" 
				href="#1" type="submit">
				<bean:message key="label.addLeg.clearResults" />
			</a>
		</div>
	</div> <!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<label>Business Segment</label>
			<div class="radio-container" id="lenBusSegConDiv">
				<p class="businessSegment">${bsval}</p>					
				<input type="hidden" name="${businessSegment}" 
					class="businessSegment" value="${bsval}">
			</div>
		</div>
	</div> <!-- end of block -->
</div>

<div class="row conditional-row">
	<div class="span5 highlighted">
		<div class="form-row tcode">
			<p><b><bean:message key="label.addLeg.treasuryCode"/></b></p>
			<c:forEach var="i" 
				items="${sessionScope.inputform.PEntities[item].treasuryCodes}"
				varStatus="curindex">
				<c:if test="${i ne '-'}">
				<p>${i}</p>
				<input type="hidden" name="${tcodeName}" value="${i}"/>
				</c:if>
			</c:forEach>			
		</div>
	</div><!-- end of block -->	
</div>

<div class="row">
	<div class="span5 right">
		<div class="form-row">
			<label>Funding Company/Holding Company/Operating Company<span class="ttip info" data-original-title="<bean:message key="label.tooltip.funCOholCO" />"></span></label>
			 <html:select property="${whichCompany}" styleClass="span2" 
			 	value="${whichCompanayVal}" >
				<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
				<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
			</html:select>  
			<span class="req-error" style="display:none;">error</span>
		</div>
	</div> <!-- end of block -->
</div>	

</div>		

