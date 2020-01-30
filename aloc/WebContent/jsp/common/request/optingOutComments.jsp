<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="acc_containerE">
	<p class="required-fields"><s:text name="label.request.common.allFieldsRequiredUnlessSpecified" /></p>
	
	<c:if test="${param.suretBond != true }">
	<s:if test="%{requestDetails.bundleDetails != null && requestDetails.bundleDetails.bundleId != null }">
		<div class="row bidOptingOutNotification" style="display: none;">
	            <div class="span12">
	            <div class="errorbox">
					<div class="noteHead"><p class="noteicon"><s:text name="label.common.alert"/></p></div>
					<div class="noteContent">
						<p><s:text name="label.request.optingOutCommentsDescription"/></p>
					</div>
					</div>
	            </div>
	      </div>
     </s:if>
     </c:if>
	
	<div class="row lastrow">
		<div class="span5">
			<div class="form-row">
				<s:textarea name="requestDetails.actionDetails.reasonForOptingOut" 
								id="optingOutCommentsReason" 
								cssClass="autosize messageinput"
								key="label.request.reasonForOptingout" 
								theme="aloc"
								onkeypress="return imposeMaxLength(this, 399);"	/>
				<div class="clear"></div>
				<div class="counter"><s:text  name="label.request.fourHundred"/></div> <!-- fix positions -->
                <div class="counterTxt"><p class="guidance"><s:text  name="label.request.textSize"/></p></div>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p>
					<br />
				</p>
			</div>
		</div>
	</div>
	<!-- end of block -->
</div>