<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<fmt:setLocale value="en-US"/>
<c:set var="rateInfoVO" value="${deal:fetchRateInfo(requestScope.legNumber, pageContext.request)}" scope="page"/>
<div class="form-mod">
			<h2 class="span12 collapsible">Terms and Conditions</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>Interest type</label>
						<div class="radio-container">
							<c:if test="${rateInfoVO.interestTypeId eq 1}">
							   <label class="radio"> <input type="radio" checked disabled=disabled/> Fixed </label>
                               <label class="radio"> <input type="radio"  disabled=disabled/> Float </label>
                            </c:if>
                            <c:if test="${rateInfoVO.interestTypeId eq 2}">
                                	<label class="radio"> <input type="radio" disabled=disabled /> Fixed </label>
                                	<label class="radio"> <input type="radio" checked disabled=disabled /> Float </label>
                            </c:if>

						</div>
					</div>
				</div>
			</div>
        </div>
		
		<c:if test="${rateInfoVO.interestTypeId eq 1}">
			<h3 class="span12">Fixed</h3>
			<div class="row">
				<div class="span5 ">
					<div class="form-row">
						<label>Base fixed rate %</label>
						<input type="text" disabled="disabled" class="span1" value="${rateInfoVO.baseFixedRate}"/>
					</div>
				</div> <!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<label>Spread (bps)</label>
						<input type="text" disabled="disabled" class="span1" value="${rateInfoVO.spread}"/>
					</div>
				</div> <!-- end of block -->
				
			</div>
		</c:if>
		<c:if test="${rateInfoVO.interestTypeId eq 2}">
			<h3 class="span12">Float</h3>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>Float Rate Index</label>
						 <select disabled="disabled" class="span2 dual-selects">
							<option disabled="disabled"><c:if test="${empty rateInfoVO.floatingRateIndex}">Select</c:if>
											<c:if test="${not empty rateInfoVO.floatingRateIndex}">${rateInfoVO.floatingRateIndex}</c:if></option>
						</select>
					</div>
				</div>
				<div class="span5 right">
					<div class="form-row">
						<label>Spread (bps)</label>
						<input type="text" disabled="disabled" class="span1" value="${rateInfoVO.spread}"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>Float Rate Index term</label>
						<select disabled="disabled" class="span2 dual-selects">
							<option disabled="disabled"><c:if test="${empty rateInfoVO.floatingRateIndexTerm}">Select</c:if>
											<c:if test="${not empty rateInfoVO.floatingRateIndexTerm}">${rateInfoVO.floatingRateIndexTerm}</c:if></option>
						</select>					
					</div>
				</div> <!-- end of block -->
			</div>
			
		</c:if>