<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
       <div class="display-row">
				<div class="row">
					<div class="span5">
						<div class="form-row autosize-container1">
							<c:if test="${param.transactionEventTypeId eq '1'}"> <span class="required">*</span> </c:if>
							<label>Transfer Pricing Summary</label>
							 <div class="char-count">1000</div>
							<html:textarea name="cpaLegRequestForm" styleClass="xlarge autosize1 messageinput" property="TPLegRequest.TPSummary" styleId="tpSummary"  rows="1" onblur="scriptInjection(this);" ></html:textarea>
							<c:if test="${param.transactionEventTypeId eq '1'}"> <div id="tpSummaryBar" class="req-error" style="display:none;">error</div> </c:if>
						</div>
					</div> <!-- end of block -->
				</div>
       </div>