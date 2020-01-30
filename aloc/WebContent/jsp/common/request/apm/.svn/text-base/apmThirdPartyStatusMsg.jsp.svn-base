<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<s:if test="hasActionMessages()">
		<div class="row">
			<div class="span12">
				<div class="errorbox">
					<div class="errorHead">
						<p class="erroricon">
							<s:text name="label.eas.common.error" />
						</p>
					</div>
					<div class="errorContent">
						<p>
							<s:actionmessage />
						</p>
					</div>
				</div>
			</div>
		</div>
	</s:if>
	<s:if test="%{apmDetails.feePaymentRunDetails.IBSInvoiceFileUploadStatus != null || apmDetails.feePaymentRunDetails.webcashFileUploadStatus != null ||
										apmDetails.feePaymentRunDetails.paymentRunCompletionStatus != null}">
		<div class="row">
			<div class="span12">
				<div id="siteMsg">
		            <div class="sucessMsg"><s:text name="label.eas.common.success" /></div>
		            <div class="sucessContent"><s:text name="label.eas.common.success" /></div>
		        </div>
		    </div>
		</div>
	</s:if>
	
	