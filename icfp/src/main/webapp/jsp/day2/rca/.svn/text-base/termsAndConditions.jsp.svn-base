<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ page import="com.ge.icfp.util.Utils"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<fmt:setLocale value="en-US"/>

<div class="form-mod">
			<h2 class="span12 collapsible">Terms and Conditions</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>Interest type</label>
						<span  class="help-block error" id="interestFailed" style="display:none;">Please select Interest Type</span>
						<div id="interestTypeDiv" class="radio-container intrest-type-condition">
							<span id="interestFailed"></span>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleId="fixedOrFloatRadioId" styleClass="fixed-condition" property="rateInformation.interestTypeId" value="1" onclick="javascript:fixedClick();"/>
								Fixed
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm"  styleId="fixedOrFloatRadioId" styleClass="float-condition" property="rateInformation.interestTypeId" value="2" onclick="javascript:floatClick();"/>
								Float
							</label>
						</div>
					</div>
				</div> <!-- end of block -->
			</div>
        </div><!-- end of form form-mod -->
		
		<div class="form-mod fixed-container" id="fixed-container" style="display:block;">
			<h3 class="span12">Fixed</h3>
			<div class="row">
				<div class="span5 ">
					<div class="form-row">
						<label>Base fixed rate %</label>
						<html:text name="ICFPLegRequestForm"  styleId="baseFixedRateID" maxlength="14" property="rateInformation.baseFixedRate"  styleClass="span1" />
						<span id="baseFixedRatefailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<label>Spread (bps)</label>
						<span  class="help-block invalid error" id="fixedSpread" style="display:none;">Invalid value </span>
						<span  class="help-block error" id="fixedSpreadIDFailed" style="display:none;">Spread must be between <bean:write name="ICFPLegRequestForm" property="rateInformation.minSpread"/> and <bean:write name="ICFPLegRequestForm" property="rateInformation.maxSpread"/></span>
						<html:text name="ICFPLegRequestForm"  styleId="fixedSpreadID" maxlength="11" property="rateInformation.spread"  styleClass="span1 spreadvalidate" />
						<span id="fixedSpreadfailedBar" class="req-error" style="display:none;">error</span>						
					</div>
				</div> <!-- end of block -->
				<html:hidden name="ICFPLegRequestForm" styleId="fixedMinSpreadID" property="rateInformation.minSpread" />
				<html:hidden name="ICFPLegRequestForm" styleId="fixedMaxSpreadID" property="rateInformation.maxSpread" />
			</div>
		</div><!-- end of form form-mod -->
		<div class="form-mod float-container" id="float-container" style="display:block;">
			<h3 class="span12">Float</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>Float Rate Index</label>
						<span  class="help-block error" id="floatRatefailed" style="display:none;">Please select Float Rate</span>
						 <html:select name="ICFPLegRequestForm" property="rateInformation.floatingRateIndex" styleId="floatRateIndexId" styleClass="span3" onchange="getFOIndexTermDetails()">
							<html:option value="">Select</html:option>
							<logic:notEmpty name="com.ge.icfp.MasterData"  property="floatingIndex">
								<html:optionsCollection name="com.ge.icfp.MasterData"  property="floatingIndex" value="name" label="name"/>
							</logic:notEmpty>
						</html:select>
						<span id="floatRatefailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<label>Spread (bps)</label>
						<span  class="help-block invalid error" id="floatSpread" style="display:none;">Invalid value </span>
						<span  class="help-block error" id="floatSpreadIDFailed" style="display:none;">Spread must be between <bean:write name="ICFPLegRequestForm" property="rateInformation.minSpread"/> and <bean:write name="ICFPLegRequestForm" property="rateInformation.maxSpread"/></span>
						<html:text name="ICFPLegRequestForm" maxlength="11" styleId="floatSpreadID"  property="rateInformation.spread"  styleClass="span1 spreadvalidate" />
						<span id="floatSpreadfailedBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
				<html:hidden name="ICFPLegRequestForm" styleId="floatMinSpreadID" property="rateInformation.minSpread" />
				<html:hidden name="ICFPLegRequestForm" styleId="floatMaxSpreadID" property="rateInformation.maxSpread" />
			</div>
			<div class="row" id="indexTermDivID">
				<div class="span5">
					<div class="form-row">
						<label>Float Rate Index term</label>
						<!-- need to change -->
										
						<span  class="help-block error" id="floatRateTermfailed" style="display:none;">Please select Float Rate Index term</span>
						 <html:select name="ICFPLegRequestForm" property="rateInformation.floatingRateIndexTerm" styleId="floatRateIndexTermId" styleClass="span2">
							    <html:option value="">Select..</html:option>
								<html:optionsCollection name="ICFPLegRequestForm" property="indexTermMap" label="value" value="key"/>
						</html:select>
						<span id="floatRateTermfailedBar" class="req-error" style="display:none;">error</span>
						
					</div>
				</div> <!-- end of block -->
			</div>
			
		</div><!-- end of form form-mod -->