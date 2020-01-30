<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<s:set name="isEditMode" value="editMode" />
<%-- TODO: Check if we need to have the flag for editable option --%>
	<div class="acc_container1">
		<div class="clear"></div>
		<div class="row">
			<div class="span2c">
				<div class="form-row">
					<s:label key="label.request.todaysDate" />
				</div>
			</div>
			<div class="span5">
				<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.bidReplyDetails.todayDate"/></p>
				</div>
			</div>
		</div>
		<div class="row graybg lastrow">
			<div class="span12">
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<p style="padding: 10px;">
								<s:text name="label.request.bidDetailsDesc1" /> <br /> 
								<s:text name="label.request.bidDetailsDesc2" />
							</p>
						</div>
					</div>
				</div>
				<div class="whitebg whitemp">
					<div class="row">
						<div class="span2c">
							<div class="form-row">
								<s:label key="label.request.expirationDateC"/>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><s:property value="requestDetails.bidmemoDetails.expirationDateTime"/></p>
							</div>
						</div>
						<!-- end of block -->
					</div>
					<div class="row">
						<div class="span2c">
							<div class="form-row">
								<s:label key="label.request.expirationTimeC"/>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><s:property value="hours"/>:<s:property value="minutes"/> <s:property value="period"/> <s:date name="requestDetails.bidmemoDetails.expirationDateTime" format=" zzz"/></p>
							</div>
						</div>
						<!-- end of block -->
					</div>
				</div>
				<div class="row lastrow">
					<div class="span12">
						<div class="form-row">
							<p style="padding: 10px;">
								<span style="font-size: 14px;">
								<s:text name="label.request.emailNotifyDesc"></s:text>
								</span> <br /> <br />
								<s:text name="label.request.transactionQuoteDesc"></s:text>
								 <br />
								<s:text name="label.request.bidDeclineDesc"></s:text>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>


	</div>

