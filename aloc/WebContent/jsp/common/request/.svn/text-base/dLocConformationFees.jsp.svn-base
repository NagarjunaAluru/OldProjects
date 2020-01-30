<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div> 
				<p class="required-fields"> <s:text name="label.request.common.allFieldsRequiredUnlessSpecified"></s:text> </p>
				
				<div class="row">
					<div class="span2">
						<label><s:text name="label.request.Instructions"/> :</label>
					</div>
					<div class="span8">
						<p><s:text name="label.request.otherinfo.instructions"/><br />
						   <s:text name="label.request.otherinfo.instructions1"/> <br />
						   <s:text name="label.request.NegotiationFee" />  <br />
						   <s:text name="label.request.DiscrepancyFee"/></p>
					</div>
				</div>				
				
				<div class="row">
                    <div class="span12">
						<div class="form-row">
							<label><s:text name="label.request.selectFeeStructure"></s:text>
                            <span class="ttip info" data-original-title="This is an tooltip with more information"></span>
                            </label>
							<s:select headerKey=""  list="%{#attr['com.ge.aloc.StaticDataFactory'].feeStructures}" headerValue="Select..."
									listKey="ID" listValue="name" id="selectFeeStructure" name="requestDetails.confirmationFees.feeStructureId" theme="aloc"/>
						</div>
						
						<c:if test="${empty requestDetails.confirmationFees.feeStructureId}">
			         	<c:set var="confirmFeesDiv" value="hide"/>
		    			</c:if>
						<c:if test="${not empty requestDetails.confirmationFees.feeStructureId}">
						<c:set var="confirmFeesDiv" value=""/>
						</c:if>
						
						<div class="${confirmFeesDiv} confirmFeesDiv" id="confirmFeesDiv">
							<div class="row lastrow" style="margin-top: 20px !important;">
								<div class="span12">
									<div class="form-row">
										<s:textfield name="feeStructureValue" 
											cssClass="span1a bigDecimal"
											id="confirmFeesValue" 
											required="false"
											theme="aloc" maxlength="21"
										/>
									</div>
								</div>
							</div>
						</div>
					</div> <!-- end of block -->
			    </div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield name="requestDetails.confirmationFees.otherFees" 
								id="otherFees"  cssClass="bigDecimal"
								key="label.request.otherFeesWholeAmount" 
								required="false"
								theme="aloc" maxlength="21"
							/>
						</div>
					</div>
				</div>
				
				<div class="row lastrow">
					<div class="span12">
						<div class="form-row">
                            <s:textarea name="requestDetails.confirmationFees.additionalComments" 
								id="dlocBidadditionalComments" 
								rows="1" cols="50" onkeypress="return imposeMaxLength(this, 399);"
								cssClass="autosize messageinput"
								key="label.request.dlocAdditionalComments" 
								theme="aloc"
								required="false"
							/>
							<div class="clear"></div>
							<div class="counter" id="fourHundredCounter"><s:text  name="label.request.fourHundred"/></div> <!-- fix positions -->
                			<div class="counterTxt"><p class="guidance"><s:text  name="label.request.textSize"/></p></div>
                
						</div>
					</div>
				</div>
			</div>