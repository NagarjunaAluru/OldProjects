<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="en-US"/>

<s:set name="isEditMode" value="editMode" />
	<p class="required-fields">
		<s:text name="label.request.common.allFieldsRequiredUnlessSpecified"></s:text>
	</p>

	<div class="row">
		<div class="span2">
			<div class="form-row">
				<label>
					<s:text name="label.request.todaysDate"></s:text>
				</label>
			</div>
		</div>
		<div class="span2">
			<div class="form-row">
					<s:date name="requestDetails.bidReplyDetails.todayDate" format="dd MMM yyyy"/>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<c:if test="${not empty bidFlag and (bidFlag eq 'Y' or bidFlag eq 'Bid')}">
	<div class="row highlighted">
		<div class="span12">
			<p style="padding: 10px;">
				<s:text name="label.request.quoteReviewDesc" />
			</p>
		</div>
	</div>
	</c:if>
	<div class="row">
		<div class="span4a">
			<div class="form-row">
				<s:textfield name="requestDetails.bidReplyDetails.bidExpirationDate" 
							cssClass="date" 
							id="bidExpDt" 
							key="label.request.bidReplyExpirationDate"
							theme="aloc"
						/>
				<p>DD MMM YYYY</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<label> <s:text name="label.request.bidReplyExpirationTime"></s:text> 
				</label> 
				<s:textfield name="bidHours" maxlength="2"
							cssClass="span1c bigInt" 
						/> : <s:textfield name="bidMinutes" 
							cssClass="span1c bigInt" maxlength="2"
						/> 
				<s:select list="#{'AM':'AM','PM':'PM'}" cssClass="span1c"  cssStyle="margin-bottom:0px; width:50px!important;"
					id="selectPeriod" name="bidPeriod"
					/>
									
				 EST
				<p>&nbsp; &nbsp; HH&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp;MM</p>
				<span style="color:red"><s:fielderror>
					<s:param>bidHours</s:param>
					<s:param>bidMinutes</s:param>
				</s:fielderror></span>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="span12">
			<div class="radio-container">
				<s:radio cssClass="radio" id="issuanceTypeFlagId"
					name="requestDetails.bidReplyDetails.issuanceTypeFlag"
					key="label.request.issuanceStructure" theme="aloc"
					list="#{'Direct':'Direct','Indirect':'In-direct'}"
					value="%{requestDetails.bidReplyDetails.issuanceTypeFlag}" />
			</div>
		</div>
	</div>
	
	<div class="row lastrow">
		<div class="span12">
			<div class="form-row">
				<s:textarea name="requestDetails.bidReplyDetails.notes" id="bgBidReplyNotesId"
							 key="label.request.bgBidReply.notes"
							 onkeypress="return imposeMaxLength(this, 249);"
							cssClass="autosize25 messageinput" theme="aloc"/>
						<div class="clear"></div>
						<div class="counter" id="twofiftyCounter"><s:text name="label.request.twofifty"/></div>
						<div class="counterTxt"><p class="guidance"><s:text name="label.request.250chars"/></p></div>
			</div>
		</div>
		<div class="span3 left">
			<p>
				<br />
			</p>
		</div>
	</div>
