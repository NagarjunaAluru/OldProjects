<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>

<c:set var="rateInfoVO" value="${deal:fetchRateInfo(requestScope.legNumber, pageContext.request)}" scope="page"/>

<div class="form-mod">
			<h2>Terms and Conditions</h2>
			<div class="clear"></div>
			<div class="row highlighted">
				<div class="span5">
						<label>Interest type</label>
							<span id="interestFailed"></span>
							<c:if test="${rateInfoVO.interestTypeId eq 1}">Fixed</c:if>
							<c:if test="${rateInfoVO.interestTypeId eq 2}">Float</c:if>
				</div>
        	</div>
		
		<c:if test="${rateInfoVO.interestTypeId eq 1}">
				<div class="row">
					<div class="span5 ">
							<label>Base fixed rate %</label>
							<c:if test="${not empty rateInfoVO.baseFixedRate}">${rateInfoVO.baseFixedRate}</c:if>
						</div>
					<div class="span5 right">
							<label>Spread (bps)</label>
							<c:if test="${not empty rateInfoVO.minSpread}">${rateInfoVO.spread}</c:if>	
					</div>
				</div>
		</c:if>
		
		<c:if test="${rateInfoVO.interestTypeId eq 2}">
				<div class="row">
					<div class="span5">
							<label>Float Rate Index</label>
							<c:if test="${not empty rateInfoVO.floatingRateIndex}">${rateInfoVO.floatingRateIndex}</c:if>	
					</div>
					<div class="span5 right">
							<label>Spread (bps)</label>
							 <c:if test="${not empty rateInfoVO.maxSpread}">${rateInfoVO.spread}</c:if>	
					</div>
				</div>
				<div class="row highlighted">
					<div class="span5">
							<label>Float Rate Index term</label>
								<c:if test="${not empty rateInfoVO.floatingRateIndexTerm}">${rateInfoVO.floatingRateIndexTerm}</c:if>	
						</div>
				</div> 
		</c:if>
			
		</div>