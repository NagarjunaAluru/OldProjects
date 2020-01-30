<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
			
			<div class="row">
				<div class="span2c">
					<div class="form-row">
						<label><s:text name="label.request.name" />:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property
								value="requestDetails.indicativePricingCompletedDetails.name" />
						</p>
					</div>
				</div>
			</div>
			<!-- end of block -->
			<div class="row">
				<div class="span2c">
					<div class="form-row">
						<label><s:text name="label.request.pricingExpirationDate" />:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property
								value="requestDetails.indicativePricingCompletedDetails.pricingExpirationDateTime" />
						</p>
					</div>
				</div>
			</div>
			<!-- end of block -->
			<div class="row lastrow">
				<div class="span2c">
					<div class="form-row">
						<label><s:text name="label.request.pricingExpirationTime" />:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property
								value="requestDetailsBO.indicativePricingCompletedDetailsBO.pricingExpirationTime.hours" />
							:
							<s:property
								value="requestDetailsBO.indicativePricingCompletedDetailsBO.pricingExpirationTime.period" />
							EST
						</p>
					</div>
				</div>
			</div>
			<!-- end of block -->
