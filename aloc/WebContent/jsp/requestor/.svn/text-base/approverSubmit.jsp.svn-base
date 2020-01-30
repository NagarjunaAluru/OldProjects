<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--TODO: StageID should be taken from the previous page --%>

	<div class="row">
		<div class="span12">
			<div class="radio-container">
				<div class="form-row">	
					<s:radio cssClass="radio" name="actionType" id="rejectApprove"
						list="#{'4':'Approve','5':'Reject'}" theme="aloc" />	
					<div class="row hide" id="rejectComment">
							<div class="span12">
								<div class="form-row">
									<div class="span5">
										<div class="textareaCounter"></div>
										<s:textarea onkeypress="return imposeMaxLength(this, 399);"
											name="requestDetails.actionDetails.reasonForRejection"
											theme="aloc" key="label.request.rejectcomments"
											cssClass="autosize messageinput" />
										<div class="clear"></div>
										<div class="counter">400</div>
										<!-- fix positions -->
										<div class="counterTxt">
											<p class="guidance">
												<s:text name="label.request.textSize" />
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
	
			</div>
		</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:submit key="label.request.Submit" cssClass="btn-primary" />
				<s:url id="homePageURL" action="cancel" />
				<s:a href="%{homePageURL}" key="label.request.common.cancel"
					cssClass="btn-tertiary cancel">
					<s:text name="label.request.common.cancel"></s:text>
				</s:a>
			</div>
		</div>
		<!-- end of block -->
	</div>
