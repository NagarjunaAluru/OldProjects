<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<% String servletContextUrl = request.getContextPath();  %>

<c:set var="transferPricingInfo"
	value="${deal:getTransferPricing(param.id, pageContext.request)}" />
<fmt:setLocale value="en-US"/>
       <div class="display-row">
				<div class="row">
					<div class="span5">
						<div class="form-row autosize-container1">
							<label>Transfer Pricing Summary</label>
							 ${not empty transferPricingInfo.TPSummary ? transferPricingInfo.TPSummary : '-'}
						</div>
					</div> <!-- end of block -->
				</div>
       </div>