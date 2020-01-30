<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
    
<div class="form-mod">
			<c:if test="${param.transactionEventTypeId eq '1'}"> <h2 class="span12">Settlement Details</h2> </c:if>
			<c:if test="${param.transactionEventTypeId eq '2'}"> <h2 class="span12">Other Details</h2> </c:if>
			<div class="row">
			  <div class="span5">
			   <label></label>
			  </div>
			</div>
			<div class="row">
				<div class="span5">
					<div id="settlementOtherDiv" class="form-row autosize-container1">
                    	<span class="required">*</span>
						<div class="char-count" style="margin-top:-20px;"  >
						  <label id="otherDetailsSizeID" ></label>
						</div>
						<c:if test="${param.transactionEventTypeId eq '1'}"> <html:textarea  name="cpaLegRequestForm" styleClass="xlarge autosize1 messageinput" property="dayTwoOperations.CPATermination.settlementDetailsComments" styleId="settlementOtherDetailsId" rows="1" onblur="scriptInjection(this);"/> </c:if>
						<c:if test="${param.transactionEventTypeId eq '2'}"> <html:textarea  name="cpaLegRequestForm" styleClass="xlarge autosize1 messageinput" property="dayTwoOperations.CPATermination.otherDetailsComments" styleId="settlementOtherDetailsId" rows="1" onblur="scriptInjection(this);" /> </c:if>
						<span id="settlementDetailsErrorBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> 
			</div>
        </div>
        


        
        