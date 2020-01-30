<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>

<fmt:setLocale value="en-US"/>
<%	String servletContextUrl = request.getContextPath();%>

<script> var servletContextUrl = '<%=servletContextUrl%>';</script>
<script src="<%=servletContextUrl%>/js/rcaRequestor.js" type="text/javascript"></script>
<script src="<%=servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>

<%
String addOrMofifyJS = (String)request.getSession().getAttribute("addOrModifyFlag");
String legLenforJS ="0";
if(addOrMofifyJS==null) {
	legLenforJS ="1"; 
} else {
	legLenforJS ="0";
}

%>



	
	<html:form action="/RCALegRequest.do" styleId="ICFPLegRequestForm" method="post" enctype="multipart/form-data">

		<c:set var="legNumber" value="${sessionScope.ICFPLegRequestForm.map['legNumber']}" />
		<input type="hidden" name="legNumber" value="<bean:write name="ICFPLegRequestForm" property="legNumber" />" />
		<input type="hidden"  id="derivativeNumber" name="derivativeNumber" />
		
		<jsp:include page="originalTransactionUsd.jsp">
			<jsp:param name="productType" value="${param.productType}"/>
		</jsp:include>
		<jsp:include page="originalLenderBorrower.jsp">
			<jsp:param name="hideLESetup" value="Yes" />
		</jsp:include>
		
	<div class="form-mod">
			<h2 class="span12">Problem Statement</h2>
			<div class="row">
                <div class="span5">
                    <div class="form-row">
                        <span class="required">*</span>
                        <div class="form-row autosize-container1">
                            <label>&nbsp;</label>
                            <div class="char-count" style="margin-left:-10px;">1000</div>
                            <html:textarea  name="ICFPLegRequestForm"  styleClass="xlarge autosize1 messageinput"  property="dayTwoOperations.correction.problemStatement" styleId="problemStatement" tabindex="3" rows="1" onblur="scriptInjection(this);" ></html:textarea>
                            <span id="problemStatementBar" class="req-error" style="display:none;">error</span>
                        </div>
                    </div>
                </div> <!-- end of block -->
            </div>
		</div><!-- end of form form-mod -->
        


		<div class="form-mod">
			<h2 class="span12">Correction Needed</h2>
			<div class="row">
					<div class="span5">
						<div class="form-row ">
							<span class="required">*</span>
                            <div class="form-row autosize-container1">
                                <label>&nbsp;</label>
                                <div class="char-count" style="margin-left:-10px;">1000</div>
                                  <html:textarea  name="ICFPLegRequestForm"  styleClass="xlarge autosize1 messageinput"  property="dayTwoOperations.correction.correctionNeededComments" styleId="correctionNeededComments" tabindex="3" rows="1"  onblur="scriptInjection(this);"></html:textarea>
                                   <span id="correctionNeededCommentsBar" class="req-error" style="display:none;">error</span>
	                          </div>
						</div>
					</div> <!-- end of block -->
				</div>
			<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
                            <label>Action Needed By</label>
                            <html:text name="ICFPLegRequestForm"  styleClass="span3 requestdatepicker-field"  property="dayTwoOperations.correction.actionNeededByDt" readonly="readonly" styleId="actionNeededByDt" />
                            <span id="actionNeededByDtBar" class="req-error" style="display:none;">error</span>
                        	<span class="help-block clear">MM/DD/YYYY</span>	
						</div>
					</div> <!-- end of block -->
				</div>				
		</div><!-- end of form form-mod -->
		
                
		       		
				<!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
		<jsp:param name="mode" value="edit" />
			<jsp:param name="legIndex" value="${legNumber}" />
		</jsp:include>  
		<!-- end uploads -->

		<div class="span12 right btn-container" style="margin-left: -20px;">
			<c:if test="${sessionScope.section eq 'myTasks'}">
				<input type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validateCorrection('?command=saveAndReturnToDeal','${param.productType}');">
            	<input type="button" value="Save" class="btn right" onclick="javascript:saveLeg('?command=saveAsDraft');">
			</c:if>
			<c:if test="${sessionScope.section eq 'myRequests'}">
				<c:choose>
						<c:when test="${empty deal.WFStage}">
						<c:if test="${deal.action eq 'Draft' || deal.action eq 'DRAFT' || empty deal.action}"> 
							<input type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validateCorrection('?command=saveAndReturnToDeal','${param.productType}');">
            				<input type="button" value="Save" class="btn right" onclick="javascript:saveLeg('?command=saveAsDraft');">
						</c:if>
						</c:when>
				</c:choose>
			</c:if>
			
			<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal">Cancel</a>                 
		</div>
		
		<div class="modal hide fade" id="confirm">
			<div class="modal-header">
				<a class="close" href="javascript:closeConfirmModal()">X</a>
				<h3>Cancel Leg</h3>
			</div>
			<div class="modal-body">
				<div class="row">
					<p><b>Are you sure you want to cancel?</b><br>
				Any changes you have made will be lost
				</p>
				</div>
			</div>
			<div class="modal-footer">
				<a href="javascript:redirectFundingRequest('?command=redirectFundingRequest');" class="btn right btn-success">Yes, cancel the leg</a>
				<a class="btn-link right cancel" href="javascript:closeConfirmModal()">No, take me back to the leg</a>
			</div>
		</div>
		
		<input type="hidden" id="actionId" value="${actionId}">
</html:form>

