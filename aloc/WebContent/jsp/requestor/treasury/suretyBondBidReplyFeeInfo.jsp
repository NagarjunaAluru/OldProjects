<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

                <div class="row">
					<div class="span12">
						<div class="form-row">
							<s:select headerKey="" key="label.request.suretyFeeName" list="requestDetails.feesDetails.suretyNames" headerValue="Select..."
									listKey="suretyId" listValue="suretyName" id="suretyFeeNameId" name="requestDetails.feesDetails.surityId" theme="aloc"/>
							<s:hidden name="requestDetails.feesDetails.surityName" id="suretyFeeName" value="%{requestDetails.feesDetails.surityName}"/>		
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield name="requestDetails.feesDetails.premiumFees" 
								id="premiumFees" maxlength="21"
								key="label.request.premiumFees" 
								required="false"
								theme="aloc" cssClass="bigDecimal"
							/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield name="requestDetails.feesDetails.chargeForRider" 
								id="chargeForRider" maxlength="21"
								key="label.request.chargeForRider" 
								required="false"
								theme="aloc" cssClass="bigDecimal"
							/>
						</div>
					</div>
				</div>
				<div class="row lastrow">
					<div class="span12">
						<div class="form-row">
							<s:textfield name="requestDetails.feesDetails.totoalPremium" 
								id="totalPremium" maxlength="21"
								key="label.request.totalPremium" 
								theme="aloc" required="false" cssClass="bigDecimal"
							/>
						</div>
					</div>
				</div>