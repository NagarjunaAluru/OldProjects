<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
          <h3><s:text name="label.request.fees"/></h3>
		       <div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.suretyFeeName"/> :</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<div style="word-wrap: break-word;"><p class="padding40"><s:property value="requestDetails.feesDetails.surityName"/></p></div>
						</div>
					</div>
		     </div>
		   <c:if test="${requestDetails.feesDetails.premiumFees != null && requestDetails.feesDetails.premiumFees!=''}">
		     <div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.Premiumfees-optional"/> :</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><s:property value="requestDetails.feesDetails.premiumFees"/></p>
						</div>
					</div>
		     </div>
		   </c:if>
		  <c:if test="${requestDetails.feesDetails.chargeForRider != null && requestDetails.feesDetails.chargeForRider!=''}">
		     <div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.ChargeforRider-optional"/></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><s:property value="requestDetails.feesDetails.chargeForRider"/></p>
						</div>
					</div>
		     </div>
		   </c:if>
		     <div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.totalPremium"/></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><s:property value="requestDetails.feesDetails.totoalPremium"/></p>
						</div>
					</div>
		     </div>
