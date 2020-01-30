<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p class="required-fields"><s:text name="label.request.common.allFieldsRequiredUnlessSpecified"/></p>
				<div class="row">
					<div class="span12">
							<s:textarea name="requestDetails.comments" 
								id="bidReplyComments" 
								rows="1" cols="50"
								cssClass="autosize messageinput"
								key="label.request.transferFeesComments" 
								theme="aloc"
								onkeypress="return imposeMaxLength(this, 399);"
							/>
						<div class="clear"></div>
						<div class="counter" id="fourHundredCounter"><s:text  name="label.request.fourHundred"/></div> <!-- fix positions -->
                        <div class="counterTxt"><p class="guidance"><s:text  name="label.request.textSize"/></p></div>
					</div>
				</div>