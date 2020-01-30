<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<div> 
				<p class="required-fields"> <s:text name="label.request.common.allFieldsRequiredUnlessSpecified"/> </p>
				<div class="row">
				    <div class="span13">
					    <div class="form-row autosize-container">
						    <label><s:text name="label.request.name"/>:</label>
					    </div>
				    </div>
					<div class="span5 left">
					    <div class="form-row">
                            <p class="padding40"><s:property value="requestDetails.msgHeader.auditCreatorLastName"/>, <s:property value="requestDetails.msgHeader.auditCreatorFirstName"/></p>
						</div>
				    </div>
			    </div> <!-- end of block -->
				<div class="row">
				    <div class="span12">
						<s:textfield name="requestDetails.indicativePricingCompletedDetails.pricingExpirationDateTime" 
							cssClass="date" 
							id="pricingExpDt" 
							key="label.request.bidReplyExpirationDate"
							theme="aloc"
						/>
				    </div>
			    </div> <!-- end of block -->
				<div class="row lastrow">
				    <div class="span12">
			<div class="form-row">
				<label> <s:text name="label.request.bidReplyExpirationTime"></s:text>
				</label>
				<s:textfield name="bidHours" maxlength="2"
					cssClass="span1c bigInt"/> : <s:textfield name="bidMinutes"
					cssClass="span1c bigInt" maxlength="2"/> 
				<s:select list="#{'AM':'AM','PM':'PM'}" cssClass="span1c"
					cssStyle="margin-bottom:0px; width:50px!important;"
					id="selectPeriod"
					name="bidPeriod" /> EST
				<p>&nbsp; &nbsp; HH&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp;MM</p>
				<span style="color:red"><s:fielderror>
					<s:param>bidHours</s:param>
					<s:param>bidMinutes</s:param>
				</s:fielderror></span>
			</div>
		</div>
			    </div> <!-- end of block -->
			</div>