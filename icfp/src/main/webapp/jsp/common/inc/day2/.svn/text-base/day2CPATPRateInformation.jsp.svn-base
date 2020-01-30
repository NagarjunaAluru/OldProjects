<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
    <h3>Rate Information</h3>
		<div class="form-mod">
			
			<html:hidden name="cpaLegRequestForm" property="cpaSummary.legSeqId"   />
			
			<div>
				
				<div class="row">
					<div class="span5">
						<div class="form-row">
							
							<label>Interest Rate Index</label>
							<logic:messagesPresent property="rateInformation.floatingRateIndex">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
						 	  <html:select name="cpaLegRequestForm"  property="rateInformation.floatingRateIndex" onchange="getIndexTermDetails('CPA')" styleId="floatingRateIndexID"  styleClass="span2">
							    <html:option  value="">Select...</html:option>
							      <logic:notEmpty name="com.ge.icfp.MasterData"  property="floatingIndex">
								<html:optionsCollection name="com.ge.icfp.MasterData"  property="floatingIndex" value="name" label="name"/>
							</logic:notEmpty>
							 </html:select>
							  
						</div>
						
					</div>  <!-- end of block -->
					<div class="span5 right" id="indexTermDivID">
						<div class="form-row">
							
							<label>Index Term</label>
							<logic:messagesPresent property="rateInformation.floatingRateIndexTerm">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							    <html:select name="cpaLegRequestForm"  property="rateInformation.floatingRateIndexTerm"  styleClass="span2">
							       <html:option  value="">Select...</html:option>
							    	 <html:optionsCollection name="cpaLegRequestForm" property="indexTermMap" label="value" value="key"/>
							</html:select>
						</div>
						
					</div>  <!-- end of block -->
					
				</div>
			</div>
			 <div>
			   <div class="row">
					<div class="span5">
						<div class="form-row">
							
							
							<label>Deposit Spread (bps)</label>
							<span  class="help-block invalid error" style="display:none;">Invalid value </span>
							<logic:messagesPresent property="rateInformation.maxSpread">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							<html:text name="cpaLegRequestForm" styleClass="span2 spreadvalidate"   property="rateInformation.maxSpread"  styleId="floatMaxSpreadBPSID"  maxlength="10"   />
							<span class="req-error" style="display:none;">error</span>
						</div>
						
					</div> <!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							
							<label>Borrowing Spread (bps)</label>
							<span  class="help-block invalid error" style="display:none;">Invalid value </span>
							<logic:messagesPresent property="rateInformation.minSpread">
										<span class="req-error" >a</span>
						 	</logic:messagesPresent>
							<html:text name="cpaLegRequestForm" styleClass="span2 spreadvalidate"   property="rateInformation.minSpread"  styleId="floatMinSpreadBPSID"  maxlength="10"   />
							<span class="req-error" style="display:none;">error</span>
						</div>
						
					</div> <!-- end of block -->
				</div>
			 </div>
			
			
	   </div><!-- end of form form-mod -->


