<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page errorPage="../common/error.jsp" %>
<t:common/>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String servletContextUrl = request.getContextPath();
%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld"
	prefix="wfdesktop"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>



<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | Front Office</title>
    <meta name="description" content="">
    <meta name="author" content="">

   	<%@include file="../common/includeCssScripts.jsp" %>
     <script type="text/javascript" >
		//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
	</script>
	<script src="<%=servletContextUrl%>/js/addDerivative.js" type="text/javascript"></script>
	
<%String legLenforJS ="0";%>
					
<script type="text/javascript">
var legLen = '<%=legLenforJS%>';
</script>

<script type="text/javascript" src="<%=servletContextUrl%>/js/frontOffice/frontOfficeFourblockerLeader.js">
</script>
		
  </head>

  <body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		<html:form action="/frontOfficeFourBlocker.do" styleId="cashManagementFBId" method="post" enctype="multipart/form-data">
	
		<ul class="breadcrumb">
		    <li><a href="<%=servletContextUrl%>/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">Front Office</li>
			
		</ul>
		<h1 class="page-title span12">Front Office</h1>
		<p class="span12 left clear dashdesc"><bean:message key="label.fourBlockerLeader.frontOffice" />
			<span class="required-fields"><span>*</span> = Required</span>
		</p>
		        
       	<c:forEach items="${sessionScope.deal.actionLogs}" var="actionSection">
			<c:if test="${actionSection.groupName eq 'Requestor' and actionSection.decision eq 'Submit'}">
				<c:set var="reqInitiation" value="${actionSection.actionDt}"></c:set>
			</c:if>
			<c:if test="${actionSection.groupName eq 'Pipeline Review'}">
				<c:set var="plReview" value="${actionSection.actionDt}"></c:set>
			</c:if>
		</c:forEach>
		<jsp:include page="../common/inc/progreessBar.jsp">
			<jsp:param name="formName" value="fourBlockerForm"/>
			<jsp:param name="reqInitiation" value="${reqInitiation}"/>
			<jsp:param name="plReview" value="${plReview}"/>
		</jsp:include>
				<!-- <div class="form-mod">-->
		<%@ include file="../common/inc/projectSummary.jsp"%>
		
		<%@ include file="../common/inc/transctionSummaryAndOwner.jsp"%>
		
			<!-- end of form form-mod -->
			
		<%@ include file="../common/inc/transactionPriorityAndTiming.jsp"%>

		<jsp:include page="../common/inc/transactionLegs.jsp">
				<jsp:param value="treasuryLegal" name="path"/>
		</jsp:include>
				
		<!-- end of  form form-mod -->
		
		<jsp:include page="../common/inc/exceptionDetails.jsp" />
			
		<!-- end of  form form-mod -->

		<jsp:include page="../common/inc/viewAdditionalApprovers.jsp" />
        <c:if test="${not empty requestScope.isEquity && requestScope.isEquity == true}">
			<%@ include file="../common/inc/viewBusinessApprovers.jsp"%>
		</c:if>
		<!-- end of form form-mod -->
        
        <div class="form-mod">
        
        <jsp:include page="../common/inc/commentsLog.jsp">
				<jsp:param name="formName" value="fourBlockerForm"/>			
			</jsp:include>
				
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required"></span>
						<label><bean:message key="label.frontOfficeFourBlockerLeader.comments"/></label>
						<div class="char-count">500</div>
						<textarea class="xlarge autosize messageinput" name="textarea2"	rows="2" onblur="scriptInjection(this);"></textarea>
				    </div>
				</div> 
			</div>
        </div><!-- end of form form-mod -->
       <jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
        	<jsp:param name="mode" value="edit" />
        	<jsp:param name="legIndex" value="${legNumber}" />
        	</jsp:include>  
      	
       	 
        <jsp:include page="../common/inc/auditLog.jsp">
				<jsp:param name="formName" value="fourBlockerForm"/>			
			</jsp:include>
		<input type="hidden" name="forwardPage" id="forwardPageId" value="submitSuccess"> 
		<!-- end of form form-mod -->
		<div class="span8 right btn-container">
			<a href="#assignReviewer" id="assignReviewerId" class="btn right btn-success assign-reviewer" data-toggle="modal" href="#" >Assign Reviewer... </a>
			<a class="btn-link right cancel" data-toggle="modal" href="#confirm">Cancel</a>
		</div>
		</html:form>
    <hr>
    </div>
	<%@include  file="../common/footerSection.jsp" %>
	<!-- Modals start -->
	<div class="modal hide fade" id="assignReviewer">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Assign Reviewer</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<div class="span5"><p>Select a team member to assign this deal to:</p>
				</div>
				
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Team member</label>
  							 <html:select name="dealRequestForm" styleId="teamMemberId" property="uniqueId"  styleClass="span2">
								<html:option value="">Select</html:option>
								<logic:notEmpty name="teamMemberList" >
									<html:optionsCollection name="teamMemberList" value="ID" label="name"/>
								</logic:notEmpty>
							</html:select>
							<span id="teamMemberIdErrorSpan" class="req-error" style="display:none;">error</span>
					</div>
				</div>
				<!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" id="assignToTeamMember" data-dismiss="modal">Assign to team member</a>
			
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel Request</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
		    <a href="<%=servletContextUrl%>/homePage.do" class="btn right btn-success">Yes, cancel the request</a>
		  	<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
	</div>
	<div class="modal hide fade" id="attach">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3>Attach <span></span></h3>
			</div>
			<div class="modal-body">
			<!-- <form> -->
			<p>Add a document to <span></span>.</p>
				<h2><span class="required required-td">*</span>1. Select a Leg to attach a document</h2>
				<div class="row">
					<div class="span9">
						 <table class="table table-striped table-bordered sortable no-bottom">
						
						
							<thead>
							  <tr>
								<th rowspan="2">Select</th>
								<th rowspan="2">Leg #</th>
								<th rowspan="2">Product Type</th>
								<th rowspan="2">Term <span class="small">in months</span></th>
								<th colspan="2" class="nosort">Lender/Provider</th>
								<th colspan="2" class="nosort">Borrower/Recipient</th>
								<th colspan="2" class="nosort">Original Currency</th>
								<th rowspan="2">USD Equivalent</th>
								<th rowspan="2">Derivatives</th>
								<th rowspan="2">Existing</th>
							  </tr>
							  <tr>
								<th>Legal Entity</th>
								<th>County</th>
								<th>Legal Entity</th>
								<th>County</th>
								<th>Currency</th>
								<th>Amount</th>

							  </tr>
							</thead>
							<tbody>
							  <tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>1</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr><tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>2</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr><tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>3</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr><tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>5</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr><tr>
								<td><input type="radio"value="option1" name="optionsRadios"></td>
								<td>4</td>
								<td>RCA</td>
								<td>60</td>
								<td>001</td>
								<td>USA</td>
								<td>002</td>
								<td>USA</td>
								<td>USD</td>
								<td>2,000</td>
								<td>2,000</td>
								<td>Yes</td>
								<td>No</td>
							  </tr>
							</tbody>
						  </table>
						  <label class="checkbox apply-to-all" >
					<input type="checkbox" class="" id="optionsCheckbox" value="option1">
					Apply this Attachment to all Legs
				</label>
				</div><!-- end of block -->
				
				</div>
				<h2><span class="required required-td">*</span>2. Attachment document</h2>
				<div class="row">
					<div class="span4">
						<div class="form-row">
							<input type="file" id="fileInput" class="input-file-attach" >
						</div>
					</div> <!-- end of block -->

				</div>
			
			</div>
			<div class="modal-footer">
				<a href="#derivatives-table" class="btn right btn-success" id="saveAttachment" data-dismiss="modal">Save</a>
				<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
			</div>
	</div>
  </body>
</html>

