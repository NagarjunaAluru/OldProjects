<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

		<div class="acc_container8"> 
		
			<p class="required-fields"><s:text name="label.request.common.requiredFieldsUnlessSpecified" /></p>
			     <div class="row">
				    <div class="span22">
					    <div class="form-row">
						    <label><s:text name="label.request.instrumentTypeC" /></label>
					    </div>
				    </div>
					<div class="span5 left">
					    <div class="form-row">
                            <p><s:property value="requestDetails.instrumentType" /></p>
					    </div>
				    </div>
			    </div> <!-- end of block -->
				
				<div class="row">
					<div class="span12">
						<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].governingRules}" 
										listKey="ID"
										listValue="name" 
										id="governingRules" 
										name="requestDetails.additionalInstrumentDetails.governingRulesId"
										headerKey=""
										headerValue="Select..."
										key="label.request.governingRules"
										theme="aloc"
								/>
					</div>
				</div>
				<div class="row hide" id="other">
				    <div class="span12">
					    <div class="form-row">
                            
                            <s:textarea name="requestDetails.additionalInstrumentDetails.governingRulesOtherDescription" 
								id="specialInstructions" 
								rows="2" cols="50"
								cssClass="autosize messageinput"
								key="label.request.otherGoverningRules" 
								theme="aloc"
								onkeypress="return imposeMaxLength(this, 399);"
							/>
                            <div class="clear"></div>
                            <div class="counter"><s:text  name="label.common.siteAdmin.fourHundred"/></div>
                            <div class="counterTxt"><p class="guidance"><s:text  name="label.common.siteAdmin.limit400Characters"/></p></div>
					    </div>
				    </div>
				</div>
				<div class="row">
					<div class="span12">
						
						<s:radio theme="aloc" cssClass="radio" name="requestDetails.additionalInstrumentDetails.requestForProposal" 
						key="label.request.requestProposalInPlace" id="requestForProposal" list="#{'true':'Yes','false':'No'}"  />
					</div>
				</div>
							
		</div>				
