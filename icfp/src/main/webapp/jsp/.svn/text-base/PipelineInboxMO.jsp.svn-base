<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String servletContextUrl = request.getContextPath(); %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.*,com.ge.icfp.pipeline.form.PipelineDetails" %>
<%@taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="userDetails" %>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<fmt:setLocale value="en-US"/>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | Pipeline Management</title>
    <meta name="description" content="">
    <meta name="author" content="">
	<%@include file="common/includeCssScripts.jsp" %>
  	<script src="<%=servletContextUrl%>/js/pipelineMgmt.js" type="text/javascript"></script>
	<!-- TAB VIEW SCRIPTS -->
   	<script type="text/javascript" >
		//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 		var contextURL = '<%=servletContextUrl%>';
	</script>
    <script src="<%=servletContextUrl%>/js/header-fix.js" type="text/javascript"></script>    
  </head>

<body>

	<div class="container main">
		<%@include file="common/headerSection.jsp" %>
		<ul class="breadcrumb">
			<li><a href="<%=servletContextUrl%>/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active"><bean:message key="heading.pipelineInboxMO.pageTitle"/></li>
		</ul>
		
        <div class="alert fade in alert-success hide" style="display: ${empty requestScope.UpdateMessage ? 'none' : 'block'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.UpdateMessage}</strong> 
        </div>
        <div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
             <a href="#" data-dismiss="alert" class="close">X</a>
             <strong>${requestScope.atmtError}</strong> 
        </div>
        <html:form action="/pipelineReview/pipelineReviewView.do" styleId="pipelineInboxForm">
        <input type="hidden" id="typeId"/>
		<div id="pipelineMgmtScreen">
		<h1 class="page-title span12"><bean:message key="heading.pipelineInboxMO.pageTitle"/>
			<a href="javascript:void(0);" onclick="javascript:exportToExcelMO();" class="excel"><img src="<%=servletContextUrl%>/img/excel.gif" /></a>
			<c:choose>
				<c:when test="${requestScope.belowChart}">
					<c:set var="belowSelected" value="selected='selected'"/>
				</c:when>
				<c:when test="${requestScope.sideChart}">
					<c:set var="sideSelected" value="selected='selected'"/>
				</c:when>
			</c:choose>
			<select class="span2 chart-select-mo" style="float: right; margin-left: 10px;">
				<option>Show/Hide Chart</option>
				<option ${belowSelected}>Show below</option>
				<option ${sideSelected}>Show to side</option>
			</select>
		</h1>
		
		<div class="form-mod">
			<h2 class="span12 collapsible collapsed">Advanced Search</h2>
			<div class="row">
				<div class="span6">
					<div class="form-row">
					<p><b>Deal ID</b><br>
					<span id="dealIdErrorBar">&nbsp;</span>
					<html:text name="pipelineInboxForm" property="search.dealId" styleId="dealId"/>
					</p>
					</div>
				</div>
				<div class="span6 right">
					<div class="form-row">
					<p><b>CDR</b><br>
					<html:text name="pipelineInboxForm" property="search.CDR" styleId="cdrCodeId" style="text-transform: uppercase;"/> 
					</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span6">
					<div class="form-row">
					<p><b>Deal Name</b><br>
					<html:text name="pipelineInboxForm" property="search.dealName" styleId="dealNameId"/>
					</p>
					</div>
				</div>
				<div class="span6 right">
					<div class="form-row">
					<p><b>GOLD ID</b><br>
					<html:text name="pipelineInboxForm" property="search.goldId" styleId="LEGoldId" style="text-transform: uppercase;"/>
					</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span6">
					<div class="form-row">
					<p><b>Workflow State</b><br>
					<html:select name="pipelineInboxForm" property="workFlowState" styleClass="width: 100px;" 
					styleId="workflowStateID" size="5" multiple="true">
						<html:option value="">Select...</html:option>
						<c:forEach var="eachWorkFlowStage" items="${staticdata:getWorkFlowStageList(pageContext)}">
							<c:if test="${eachWorkFlowStage.WFStageId ne '13'}">
							<html:option value="${eachWorkFlowStage.WFStageId}">${eachWorkFlowStage.forSearch}</html:option>
							</c:if>
						</c:forEach>
					</html:select>
					</p>
					</div>
				</div>
				<div class="span6 right">
					<div class="form-row">
					<p><b>Deal Type</b><br>
					<html:select name="pipelineInboxForm" property="dealType" styleClass="width: 100px;" styleId="dealCategoryID" size="5" multiple="true">
						<html:option value="">Select...</html:option>
						<html:option value="Debt">Debt</html:option>
						<html:option value="Equity">Equity</html:option>
						<html:option value="CPA">Cash Pool</html:option>
						<html:option value="Other">Other</html:option>
						<html:option value="Multiple">Multiple</html:option>
					</html:select>
					</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span6">
					<div class="form-row">
					<p><b>Deal Category</b><span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span><br>
					<html:select name="pipelineInboxForm" property="dealCategory" styleClass="width: 100px;" 
						styleId="dealCategoryID" size="5" multiple="true">
					<html:option value="">Select...</html:option>
					<html:optionsCollection name="com.ge.icfp.StaticData" property="dealCategories" value="ID" label="name"/>
					</html:select>
					</p>
					</div>
				</div>
				<div class="span6 right">
					<div class="form-row">
					<p><b>Priority</b><br>
					<html:select name="pipelineInboxForm" property="priority" styleClass="width: 100px;" 
						styleId="priorityID" size="5" multiple="true">
						<html:option value="">Select...</html:option>
						<html:option value="1">High</html:option>
						<html:option value="2">Medium</html:option>
						<html:option value="3">Low</html:option>
						</html:select>
					</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span6">
					<div class="form-row">
					<p><b>Currency</b><br>
					<html:select name="pipelineInboxForm" property="currency" styleClass="width: 100px;" 
						styleId="dealCategoryID" size="5" multiple="true">	
					<html:option value="">Select...</html:option>
					<html:optionsCollection name="com.ge.icfp.MasterData" property="dealCurrencies" value="id" label="name"/>
					</html:select>
					</p>
					</div>
				</div>
				<div class="span6 right">
					<div class="form-row">
						<p><b>Value Date</b><br></p>
						<div class="left">
	                    <html:text name="pipelineInboxForm" property="search.valueDtFrom" styleClass="span2 searchdatepicker-field" maxlength="10"   />
	                    <span class="help-block clear">MM/DD/YYYY</span>
	                    </div> 
	                    <div class="left" style="margin-left:15px; margin-right:15px;">To</div> 
	                    <div class="left">
	                    <html:text name="pipelineInboxForm" property="search.valueDtTo" styleClass="span2 searchdatepicker-field" maxlength="10"   />
	                    <span class="help-block clear">MM/DD/YYYY</span>
	                    </div>
	                </div>
	                <div class="clear"></div>
	                <div class="form-row" style="margin-top: 20px; float: left;">
						<p><b>Days Remaining</b><br></p>
						<div class="left">
						<html:text name="pipelineInboxForm" property="search.daysRemainingFrom" styleClass="span2 numeric" maxlength="10" />
	                    </div> 
	                    <div class="left" style="margin-left:10px; margin-right:10px;">To</div> 
	                    <div class="left">
	                    <html:text name="pipelineInboxForm" property="search.daysRemainingTo" styleClass="span2 numeric" maxlength="10" />
	                    </div>
					</div>
	            </div>
			</div>
			<div class="row">
				<div class="span6">
					<div class="form-row">
					<p><b>Debt Value</b><br></p>
						<div class="left">
						<html:text name="pipelineInboxForm" property="search.debtValueFrom" styleClass="span2 numeric" maxlength="10" />
		                </div> 
		                <div class="left" style="margin-left:10px; margin-right:10px;">To</div> 
		                <div class="left">
		                <html:text name="pipelineInboxForm" property="search.debtValueTo" styleClass="span2 numeric" maxlength="10" />
		                </div>
					</div>
				</div>
				<div class="span6 right">
					<div class="form-row">
					<p><b>Equity Value</b><br></p>
						<div class="left">
						<html:text name="pipelineInboxForm" property="search.equityValueFrom" styleClass="span2 numeric" maxlength="10" />
		                </div> 
		                <div class="left" style="margin-left:10px; margin-right:10px;">To</div> 
		                <div class="left">
		                <html:text name="pipelineInboxForm" property="search.equityValueTo" styleClass="span2 numeric" maxlength="10" />
		                </div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span6">
				<div class="form-row">
					<label>Deal with Derivatives</label>
                       <label class="radio">
                       <html:radio name="pipelineInboxForm" property="search.dealWithDerivatives" value="1">Yes</html:radio>
                       </label>
                       <label class="radio">
                       <html:radio name="pipelineInboxForm" property="search.dealWithDerivatives" value="0">No</html:radio>
                       </label> 
				</div>
				</div>
			</div>
			<div class="row">
				<div class="span6">
					<div class="form-row">
						<h4>Product Type</h4>
						<c:forEach var="eachProduct" items="${staticdata:getProductTypes(pageContext)}">
							<html:multibox name="pipelineInboxForm" property="productType" value="${eachProduct.ID}"/> ${eachProduct.name}<br>
						</c:forEach>
					</div>
				</div>
				<div class="span6 right ">
					<div class="form-row">
						<h4>Event Type</h4>
						<div style="float: left;">
						<html:multibox name="pipelineInboxForm" property="eventType" value="4"/>Amendment - Agreement extension<br>
                        <html:multibox name="pipelineInboxForm" property="eventType" value="5"/>Amendment - Facility decrease/increase<br>
                        <html:multibox name="pipelineInboxForm" property="eventType" value="6"/>Amendment - General amendment<br>
                        <html:multibox name="pipelineInboxForm" property="eventType" value="3"/>Assignment<br>
                        <html:multibox name="pipelineInboxForm" property="eventType" value="10"/>Corrections<br>
                        <html:multibox name="pipelineInboxForm" property="eventType" value="12"/>Dividends<br>
                        </div>
                        <div style="float: right; margin-right: 50px;">
                        <html:multibox name="pipelineInboxForm" property="eventType" value="7"/>Prepayment<br>
                        <html:multibox name="pipelineInboxForm" property="eventType" value="8"/>Drawdown<br>
                        <html:multibox name="pipelineInboxForm" property="eventType" value="9"/>Early Termination<br>
                        <html:multibox name="pipelineInboxForm" property="eventType" value="11"/>Debt Equity other <br>
                        <html:multibox name="pipelineInboxForm" property="eventType" value="1"/>Cash Pool Termination<br>
                        <html:multibox name="pipelineInboxForm" property="eventType" value="2"/>Cash Pool - other<br>
                        </div>
					</div>
				</div> 
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<label>Transaction Owner</label>
						<div class="radio-container">
							<select id="searchCriteria">
								<option value=""><bean:message key="label.addLeg.select" /></option>
								<c:forEach var="eachSearch" items="${staticdata:getSearchCriteria(pageContext)}">
								<option value='<c:out value="${eachSearch.ID}"></c:out>'>
								${eachSearch.name}
								</option>
							</c:forEach>
							</select> 
							<input type="text" style="margin-top:-10px;" id="searchText">
							<a class="btn conditional-btn" type="submit" style="margin-top:-10px;" id="lookupUserInfo">Lookup</a>
							<html:hidden name="pipelineInboxForm" property="search.firstName" styleId="firstNameId"/>
							<html:hidden name="pipelineInboxForm" property="search.lastName" styleId="lastNameId"/>
							<html:hidden name="pipelineInboxForm" property="search.ssoId" styleId="ssoId"/>
						</div>
					</div>
				</div> <!-- end of block -->
				<div class="span10" id="userDiv">
					<div class="form-row">
					<table class="table table-striped table-bordered sortable no-bottom">
					<thead>
						<tr>
						<th class="nosort" style="width:20px;"></th>
						<th>SSOID</th>
						<th>Name</th>
						</tr>
					</thead>
					<tbody>
					<logic:notEmpty name="searchUserInfo" scope="session">
					<c:forEach var="eachSearchUserInfo" items="${sessionScope.searchUserInfo}" >
						<tr>
							<td><input type="radio" value="${eachSearchUserInfo.SSOID}" name="optionsRadios" onclick="javascript:selectUser(this);" ></td>
							<td>${eachSearchUserInfo.SSOID}</td>
							<td>${eachSearchUserInfo.lastName}, ${eachSearchUserInfo.firstName}</td>
					    </tr>
					</c:forEach>
					</logic:notEmpty>
					<logic:empty name="searchUserInfo" scope="session">
						<tr>
							<td colspan="3">Nothing found to display</td>
						</tr>
					</logic:empty>
					</tbody>
					</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
				<div class="form-row">
					<h4>Region and Business Segment</h4>
				</div>
				</div>
			</div>
			<div class="row">
				<div class="span6">
				<label style="margin-left: 10px;">Use Ctrl (or Cmd) on your keyboard to select multiple items</label>
					<div class="form-row">
						<label>Region<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
						<html:select name="pipelineInboxForm" property="region" styleClass="width: 100px;" styleId="regionID" size="4" multiple="true">
						<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
						<html:optionsCollection name="com.ge.icfp.StaticData" property="regionResponsibility" value="ID" label="name"/>
						</html:select>
					</div>
				</div> <!-- end of block -->
				<div class="span6 right" style="margin-top: 20px;">
					<div class="form-row">
						<label>Business Segment<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
						<html:select name="pipelineInboxForm" property="businessSegment" styleClass="width: 100px;" styleId="businessSegmentID" size="5" multiple="true">
						<html:option value="">Select...</html:option>
						<html:option value="CLL Americas">CLL Americas</html:option>
						<html:option value="Capital HQ/Other">Capital HQ/Other</html:option>
						<html:option value="Asia">Asia</html:option>
						<html:option value="Treasury">Treasury</html:option>
						<html:option value="EMEA">EMEA</html:option>
						<html:option value="GECAS">GECAS</html:option>
						<html:option value="EMRG">EMRG</html:option>
						<html:option value="Retail Finance">Retail Finance</html:option>
						<html:option value="Restructure Op.">Restructure Op.</html:option>
						<html:option value="EFS">EFS</html:option>
						<html:option value="Commercial Real Estate">Commercial Real Estate</html:option>
						</html:select>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span12 right btn-container">
				<a href="#" class="btn right btn-success" id="searchActionMO">Search</a>
				<a href="#" class="btn-link right cancel" id="clearForm">Clear Form</a>                  
				</div>
			</div>
		</div>
		<div class="form-mod">
		<h3 class="span12"><bean:message key="label.pipelineInbox.request"/>${fn:length(sessionScope.pipelineDetailList)}</h3>
        <div class="row">
		<div class="span12 pipeline-management-tables" style="margin-top: 30px;">
			<c:if test="${requestScope.noChart}">
			<div>
			<table class="table table-striped table-bordered sortable flyout active paginate"
			 data-toggle="Show/Hide Chart" id="mopipeline">
				<thead>
					<tr>
						<th>#</th>
						<th>Request Date</th>
						<th>Deal ID</th>
						<th>Deal Name</th>
						<th>Value (USD Equivalent)</th>
						<th>Event</th>
						<th>Deal Category</th>
						<th>Transaction Owner</th>
						<th>Standard (S)/Exception (E)</th>
						<th>Region Responsibility</th>
						<th>Value Date</th>
						<th>Days Remaining</th>
						<th>Priority</th>
						<th>Work Flow State</th>
						<th>Status</th>
					</tr>
					
				</thead>
				<tbody>
					<logic:notEmpty  name="pipelineDetailList" scope="session">
					<logic:iterate id="dealRequest" name="pipelineDetailList" scope="session" indexId="counter">
						<tr>
							<td>${ counter + 1 }</td>
							<td>${dealRequest.requestDate}</td>
							<td><div style="width:60px;overflow:auto">
							<a href="javascript:void(0);" onclick="javascript:openTransaction(${dealRequest.requestID},'MOPipeline');">${dealRequest.uniqueId}</a>
							</div></td>
							<td style="word-wrap:break-word;"><div style="width:120px;overflow:auto">${dealRequest.dealName}</div></td>
							<td>${dealRequest.debtValue} </td>
							<td>${dealRequest.event} </td>
							<td>${dealRequest.dealCategory}</td>
							<td style="word-wrap:break-word;">${dealRequest.transOwnerSsoId}</td>
							<td>${dealRequest.standardException}</td>
							<td>${dealRequest.responsibleRegion}</td>
							<td>${dealRequest.valueDate}</td>
							<td>${dealRequest.noOfDaysRemaining}</td>
							<td>${dealRequest.priority}</td>
							<td>${dealRequest.workFlowState}</td>
							<td>${dealRequest.status}</td>
						</tr>
					</logic:iterate>
					</logic:notEmpty>
					<logic:empty name="pipelineDetailList" scope="session">
					<tr>
						<td colspan="15">Nothing found to display</td>
					</tr>
					</logic:empty>
				</tbody>
			</table>
			</div>
			</c:if>
			<c:if test="${requestScope.belowChart}">
			<table class="table table-striped table-bordered sortable layer active paginate" data-toggle="Show below" id="mopipeline1">
				<thead>
					<tr>
						<th rowspan="2">#</th>
						<th rowspan="2">Request Date</th>
						<th rowspan="2">Deal ID</th>
						<th rowspan="2">Deal Name</th>
						<th rowspan="2" class="partial">Pipeline</th>
						<th colspan="7" class="nosort">Structuring &amp; Underwriting</th>
						<th colspan="4" class="nosort">Reviews &amp; Approvals</th>
						<th colspan="3" class="nosort">Closing</th>
					</tr>
					<tr>
						<th class="completed">Front Office</th>
						<th class="completed">Transfer Pricing</th>
						<th class="completed">Treasury Tax</th>
						<th class="completed">Regulatory/ Jurisdictional Reviews</th>
						<th class="completed">Legal</th>
						<th class="completed">Middle Office</th>
						<th class="completed">Cash Operations</th>
							
						<th class="light">Risk Management</th>
						<th class="light">Business Finance</th>
						<th class="light">IDAG</th>
						<th class="light">TESG</th>
						
						<th class="non-done">Additional Reviewers</th>
						<th class="non-done">Docs. and Certify</th>
						<th class="non-done">Booking and Close</th>
					</tr>
				</thead>
				<tbody>
					<logic:notEmpty name="pipelineDetailList" scope="session">
					<logic:iterate id="dealRequest" name="pipelineDetailList" scope="session" indexId="counter">
					
					<tr>
						<td>${ counter + 1 }</td>
						<td>${dealRequest.requestDate}</td>
						<td><div style="width:60px;overflow:auto"><a href="javascript:void(0);" onclick="javascript:openTransaction(${dealRequest.requestID},'MOPipeline');">${dealRequest.uniqueId}</a></div></td>
						<td style="word-wrap:break-word;"><div style="width:120px;overflow:auto">${dealRequest.dealName}</div></td>
						
						<t:actionCompleted stage="${dealRequest.pipeline}"/>
						<t:actionCompleted stage="${dealRequest.frontO}"/>
						<t:actionCompleted stage="${dealRequest.tPricing}"/>
						<t:actionCompleted stage="${dealRequest.tTax}"/>
						<t:actionCompleted stage="${dealRequest.countryT}"/>
						<%-- <c:choose>
						<c:when test="${dealRequest.productTypeCollection eq 'Cash Pool'}">
						<td class="${dealRequest.countryT.status} popup"></td>
						</c:when>
						<c:otherwise>
						<td class="completed">-</td>
						</c:otherwise>
						</c:choose> --%>
						<t:actionCompleted stage="${dealRequest.tLegal}"/>
						<t:actionCompleted stage="${dealRequest.middleO}"/>
						<t:actionCompleted stage="${dealRequest.cashM}"/>
						<t:actionCompleted stage="${dealRequest.riskM}"/>
						<t:actionCompleted stage="${dealRequest.businessF}"/>
						<t:actionCompleted stage="${dealRequest.idag}"/>
						<t:actionCompleted stage="${dealRequest.tesg}"/>
						<t:actionCompleted stage="${dealRequest.additionalR}"/>
						<t:actionCompleted stage="${dealRequest.certify}"/>
						<t:actionCompleted stage="${dealRequest.close}"/>

					</tr>
					</logic:iterate>
					</logic:notEmpty>
					<logic:empty name="pipelineDetailList" scope="session">
					<tr>
						<td colspan="19">Nothing found to display</td>
					</tr>
					</logic:empty>
				</tbody>
			</table>
			<script type="text/javascript">
			$(function() {
				$('.ledgend').show();
				$('.ledgend2').show();
			});
			</script>
			</c:if>
			<c:if test="${requestScope.sideChart}">
			<table class="table table-striped table-bordered sortable flyout active paginate" 
				data-toggle="Show to side" id="mopipeline2">
				<thead>
					<tr>
						<th rowspan="2">#</th>
						<th rowspan="2">Request Date</th>
						<th rowspan="2">Deal ID</th>
						<th rowspan="2">Deal Name</th>
						<th rowspan="2">Value (USD Equivalent)</th>
						<th rowspan="2">Event</th>
						<th rowspan="2">Deal Category</th>
						<th rowspan="2">Transaction Owner</th>
						<th rowspan="2">Standard (S)/Exception (E)</th>
						<th rowspan="2">Region Responsibility</th>
						<th rowspan="2">Value Date</th>
						<th rowspan="2">Days Remaining</th>
						<th rowspan="2">Priority</th>
						<th rowspan="2">Work Flow State</th>
						<th rowspan="2">Status</th>
						
						<th rowspan="2" class="partial">Pipeline</th>
						<th colspan="7" class="nosort">Structuring &amp; Underwriting</th>
						<th colspan="4" class="nosort">Reviews &amp; Approvals</th>
						<th colspan="3" class="nosort">Closing</th>
					</tr>
					<tr>
						<th class="completed">Front Office</th>
						<th class="completed">Transfer Pricing</th>
						<th class="completed">Treasury Tax</th>
						<th class="completed">Regulatory /Jurisdictional Reviews</th>
						<th class="completed">Legal</th>
						<th class="completed">Middle Office</th>
						<th class="completed">Cash Operations</th>
						
						<th class="light">Risk Management</th>
						<th class="light">Business Finance</th>
						<th class="light">IDAG</th>
						<th class="light">TESG</th>
						
						<th class="non-done">Additional Reviewers</th>	
						<th class="non-done">Docs. and Certify</th>
						<th class="non-done">Booking and Close</th>
					</tr>
				</thead>
				<tbody>
					<logic:notEmpty name="pipelineDetailList" scope="session">
					<logic:iterate id="dealRequest" name="pipelineDetailList" scope="session" indexId="counter">
					
					<tr>
						<td>${ counter + 1 }</td>
						<td>${dealRequest.requestDate}</td>
						<td><div style="width:60px;overflow:auto"><a href="javascript:void(0);" onclick="javascript:openTransaction(${dealRequest.requestID},'MOPipeline');">${dealRequest.uniqueId}</a></div></td>
						<td style="word-wrap:break-word;"><div style="width:120px;overflow:auto">${dealRequest.dealName}</div></td>
						
						<td>${dealRequest.debtValue} </td>
						<td>${dealRequest.event} </td>
						<td>${dealRequest.dealCategory}</td>
						<td style="word-wrap:break-word;">${dealRequest.transOwnerSsoId}</td>
						<td>${dealRequest.standardException}</td>
						<td>${dealRequest.responsibleRegion}</td>
						<td>${dealRequest.valueDate}</td>
						<td>${dealRequest.noOfDaysRemaining}</td>
						<td>${dealRequest.priority}</td>
						<td>${dealRequest.workFlowState}</td>
						<td>${dealRequest.status}</td>
						
						<t:actionCompleted stage="${dealRequest.pipeline}"/>
						<t:actionCompleted stage="${dealRequest.frontO}"/>
						<t:actionCompleted stage="${dealRequest.tPricing}"/>
						<t:actionCompleted stage="${dealRequest.tTax}"/>
						<t:actionCompleted stage="${dealRequest.countryT}"/>
						<%-- <c:choose>
						<c:when test="${dealRequest.productTypeCollection eq 'Cash Pool'}">
						<td class="${dealRequest.countryT.status} popup"></td>
						</c:when>
						<c:otherwise>
						<td class="completed">-</td>
						</c:otherwise>
						</c:choose> --%>
						<t:actionCompleted stage="${dealRequest.tLegal}"/>
						<t:actionCompleted stage="${dealRequest.middleO}"/>
						<t:actionCompleted stage="${dealRequest.cashM}"/>
						<t:actionCompleted stage="${dealRequest.riskM}"/>
						<t:actionCompleted stage="${dealRequest.businessF}"/>
						<t:actionCompleted stage="${dealRequest.idag}"/>
						<t:actionCompleted stage="${dealRequest.tesg}"/>
						<t:actionCompleted stage="${dealRequest.additionalR}"/>
						<t:actionCompleted stage="${dealRequest.certify}"/>
						<t:actionCompleted stage="${dealRequest.close}"/>

					</tr>
					</logic:iterate>
					</logic:notEmpty>
					<logic:empty name="pipelineDetailList" scope="session">
					<tr>
						<td colspan="30">Nothing found to display</td>
					</tr>
					</logic:empty>
				</tbody>
			</table>
			<script type="text/javascript">
			$(function() {
				$('.ledgend').show();
				$('.ledgend1').show();
			});
			</script>
			</c:if>

			<div class="ledgend span5">
				<div class=" color">
					<div class="block completed"></div>
					<label><bean:message key="label.pipelineInbox.blockCompleted"/></label>
				</div>
				<div class=" color">
					<div class="block partial"></div>
					<label><bean:message key="label.pipelineInbox.blockInprogress"/></label>
				</div>
				<div class=" color">
					<div class="block inprogress"></div>
					<label><bean:message key="label.pipelineInbox.blockNotStarted"/></label>
				</div>
						
			</div>
			
			<div class="ledgend1 span5" data-toggle="Show to side">
				<div class="check">
					<input type="checkbox" id="showChart1"/>Always show chart
				</div>
			</div>
			<div class="ledgend2 span5" data-toggle="Show below">
				<div class="check">
					<input type="checkbox" id="showChart2"/>Always show chart
				</div>
			</div>
		</div>
     	</div>
     	</div>
     	<div class="row">
     	<input type='hidden' id='current_page' />
     		
  		  	<div class="span8 pagination pagination-right">
     	  		<ul>
     	  		</ul>
     	 	</div>
         	<div class="span3 jump-page">
	      		Jump to
	      	<input type="text" class="span1 manual">
		  	<a class="btn jumpto" type="submit">Go</a>
		 	</div>
		 	<div class="jump-page">	
				<select class="span1 pagination-rows">				
					<option value="10" >10</option>					
					<option value="20">20</option>
					<option value="30">30</option>
					<option value="40">40</option>					
					<option value="50" selected="selected">50</option>
				</select>
			</div>
		</div>	
	</div>
	<script src="<%=servletContextUrl%>/js/pagination.js"></script>
    </html:form>
	
	
	
	</div>
	<div id="actionDetails" class="popover top">
	    <div class="arrow"></div>
	    <div class="popover-content loading">	      
	    </div>
   </div>
	<%@include file="common/footerSection.jsp" %>


  </body>
</html>