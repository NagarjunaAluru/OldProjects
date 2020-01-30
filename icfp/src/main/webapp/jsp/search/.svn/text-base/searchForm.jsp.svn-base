<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String servletContextUrl = request.getContextPath(); %>
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
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setLocale value="en-US"/>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | Search Form</title>
    <meta name="description" content="">
    <meta name="author" content="">

   <%@include file="../common/includeCssScripts.jsp" %>
   	<script type="text/javascript" >
		//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
	</script>
	<script src="${context}/js/searchForm.js" type="text/javascript"></script>
	<script src="${context}/js/header-fix.js" type="text/javascript"></script>
  </head>

  <body>
	<div class="container main">
		<html:form action="/searchResults.do"  styleId="searchForm"  method="post"  enctype="multipart/form-data">
		<%@include file="../common/headerSection.jsp" %>
		<ul class="breadcrumb">
			<li><a href="<%=servletContextUrl%>/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">Search</li>
		</ul>
		<c:if test="${requestScope.showSearchResult eq true}">
		
		<h2 class="span12">Search Results - ${fn:length(sessionScope.searchResultList)}
			<a href="javascript:void(0);" onclick="javascript:exportToExcel();" class="excel"><img src="<%=servletContextUrl%>/img/excel.gif" /></a>
		</h2>
		
		<p class="span12 left clear dashdesc">You Searched for : 
		<c:set var="i" value="1"></c:set>
		<c:forEach var="searched" items="${sessionScope.searchedList}">
    	${searched.key} : ${searched.value}
    	<c:if test="${i lt fn:length(sessionScope.searchedList)}">; </c:if>
    	<c:set var="i" value="${i + 1}"></c:set> 
		</c:forEach>
		</p>
		<div style="margin-left: -2px;" class="span12 pipeline-management-tables">
		<table class="table table-striped table-bordered sortable active flyout paginate">
			<thead>
			<tr>
				<th rowspan="2">#</th>
				<th rowspan="2">State</th>
				<th rowspan="2">Deal ID</th>
                <th rowspan="2">Deal Name</th>
				<th colspan="2" class="nosort">(USD Equivalent)</th>
				<th rowspan="2">Deal Category</th>
				<th rowspan="2">Event</th>
                <th rowspan="2">Transaction Owner</th>
                <th rowspan="2">Value Date</th>
                <th rowspan="2">Number of days remaining</th>
                <th rowspan="2">Priority</th>
                <th rowspan="2">Work Flow State</th>
			</tr>
			<tr>
				<th>Debt Value</th>
				<th>Equity Value</th>
			</tr>
			</thead>
			<tbody>
			<logic:notEmpty  name="searchResultList" scope="session">
				<logic:iterate id="dealRequest" name="searchResultList" scope="session" indexId="counter">
					<tr>
						<td>${ counter + 1 }</td>
						<td><div style="width:65px;overflow:auto">${dealRequest.status}</div></td>
						<td><div style="width:65px;overflow:auto"><a href="javascript:void(0);" onclick="javascript:openTransaction('${dealRequest.uniqueId}','${dealRequest.requestID}');">${dealRequest.uniqueId}</a></div></td>
						<td style="word-wrap:break-word;"><div style="width:120px;overflow:auto">${dealRequest.dealName}</div></td>
						<td>${not empty dealRequest.debtValue ? dealRequest.debtValue : '-'}</td>
						<td>${not empty dealRequest.equityValue ? dealRequest.equityValue : '-'}</td>
						<td>${dealRequest.dealCategory}</td>
						<td style="word-wrap:break-word;">${not empty dealRequest.event ? dealRequest.event : '-'}</td>
						<td style="word-wrap:break-word;">${dealRequest.name}</td>
						<td><div style="width:65px;overflow:auto">${dealRequest.valueDate}</div></td>
						<td>${dealRequest.noOfDaysRemaining}</td>
						<td>${dealRequest.priority}</td>
						<td style="word-wrap:break-word;">${dealRequest.workFlowState}</td>
					</tr> 
				</logic:iterate>
			</logic:notEmpty>
			<logic:empty name="searchResultList" scope="session">
				<tr>
					<td colspan="13">No results found. Please try a different search.</td>
				</tr>
			</logic:empty>                                            
			</tbody>
		</table>
		</div>
		<c:if test="${fn:length(sessionScope.searchResultList) gt 10}">
		<div class="row span12">
     	<input type='hidden' id='current_page' />
  		<div class="span7 pagination pagination-right">
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
				<option value="10">10</option>					
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="40">40</option>					
				<option value="50" selected="selected">50</option>
			</select>
		</div>

		</div>	
 		<script src="<%=servletContextUrl%>/js/pagination.js"></script>
 		</c:if>
 		<c:if test="${fn:length(sessionScope.searchResultList) le 10}">
 		<div class="clear"></div>
 		</c:if>
		
		</c:if>
		<div class="clear"></div>
		<h1 class="page-title span12">Search</h1>
		<p class="span12 left clear dashdesc">
		</p>

		
		
		<div class="form-mod" style="width:100%;">
		<!-- <h3>Search</h3> -->
			<div class="row">
				<div class="span6">
					<div class="form-row">
						<h4>Product Type</h4>
						<c:forEach var="eachProduct" items="${staticdata:getProductTypes(pageContext)}">
							<html:multibox name="searchResultsForm" property="productType" value="${eachProduct.ID}"/> ${eachProduct.name}<br>
						</c:forEach>
					</div>
				</div> <!-- end of block -->
				<div class="span6 right ">
					<div class="form-row">
						<h4>Event Type</h4>
						<div style="float: left;">
						<html:multibox name="searchResultsForm" property="eventType" value="4"/> Amendment - Agreement extension<br>
                        <html:multibox name="searchResultsForm" property="eventType" value="5"/> Amendment - Facility decrease/increase<br>
                        <html:multibox name="searchResultsForm" property="eventType" value="6"/> Amendment - General amendment<br>
                        <html:multibox name="searchResultsForm" property="eventType" value="3"/> Assignment<br>
                        <html:multibox name="searchResultsForm" property="eventType" value="10"/> Corrections<br>
                        <html:multibox name="searchResultsForm" property="eventType" value="12"/> Dividends<br>
                        </div>
                        <div style="float: right; margin-right: 50px;">
                        <html:multibox name="searchResultsForm" property="eventType" value="7"/> Prepayment<br>
                        <html:multibox name="searchResultsForm" property="eventType" value="8"/> Drawdown<br>
                        <html:multibox name="searchResultsForm" property="eventType" value="9"/> Early Termination<br>
                        <html:multibox name="searchResultsForm" property="eventType" value="11"/> Debt Equity other <br>
                        <html:multibox name="searchResultsForm" property="eventType" value="1"/> Cash Pool Termination<br>
                        <html:multibox name="searchResultsForm" property="eventType" value="2"/> Cash Pool - other<br>
                        </div>
					</div>
				</div> <!-- end of block -->
			</div>
		</div>
		
		<div class="form-mod">
            <div class="clear"></div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<label>Transaction Owner</label>
						<div class="radio-container">
							<select id="searchCriteria">
								<option value=""><bean:message key="label.addLeg.select" /></option>
								<c:forEach var="eachSearch" items="${staticdata:getSearchCriteria(pageContext)}">
								<option value='<c:out value="${eachSearch.ID}"></c:out>'>${eachSearch.name}</option>
							</c:forEach>
							</select> 
							<input type="text" style="margin-top:-10px;" id="searchText">
							<a class="btn conditional-btn" type="submit" style="margin-top:-10px;" id="lookupUserInfo">Lookup</a>
							<html:hidden name="searchResultsForm" property="firstName" styleId="firstNameId"/>
							<html:hidden name="searchResultsForm" property="lastName" styleId="lastNameId"/>
							<html:hidden name="searchResultsForm" property="ssoId" styleId="ssoId"/>
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
							<td><input type="radio" value="${eachSearchUserInfo.SSOID}" name="optionsRadios"  onclick="javascript:selectUser(this);" ></td>	
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
				<div class="span5 left ">
					<div class="form-row">
						<label>Priority</label>
						<html:select name="searchResultsForm" property="priority" styleClass="width: 100px;" styleId="priorityID" >
						<html:option value="">Select...</html:option>
						<html:option value="1">High</html:option>
						<html:option value="2">Medium</html:option>
						<html:option value="3">Low</html:option>
						</html:select>
					</div>
				</div> <!-- end of block -->     
				<div class="span5 right">
					<div class="form-row">
						<label>Deal ID</label>
						<span id="dealIdErrorBar">&nbsp;</span>
						<html:text name="searchResultsForm" property="dealId" styleId="dealId"/>
					</div>
				</div> <!-- end of block -->
					               
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
					<div style="float: left;">
					<label>Original Currency</label>
					<html:select name="searchResultsForm" property="originalCurrency" styleClass="width: 100px;" styleId="dealCategoryID">	
					<html:option value="">Select...</html:option>
					<html:optionsCollection name="com.ge.icfp.MasterData" property="dealCurrencies" value="id" label="name"/>
					</html:select>
					</div>
					<div style="float: right;">
					<label>Amount</label>
					<input type="text" class="span1" name="amountFrom"> To 
					<input type="text" class="span1" name="amountTo">
					</div>
					</div>
				</div><!-- end of block -->
					
				<div class="span5 right">
					<div class="form-row">
					<label>Deal Category<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
					<html:select name="searchResultsForm" property="dealCategory" styleClass="width: 100px;" styleId="dealCategoryID" size="5" multiple="true">
					<html:option value="">Select...</html:option>
					<html:optionsCollection name="com.ge.icfp.StaticData" property="dealCategories" value="ID" label="name"/>
					</html:select>
					</div>
				</div> <!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<label>USD Equivalent</label>
						<html:text name="searchResultsForm" styleClass="span1" property="usdEquivalentFrom"/> To 
						<html:text name="searchResultsForm" styleClass="span1" property="usdEquivalentTo"/>                           
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<label>Deal Name</label>
						<html:text name="searchResultsForm" property="dealName" styleId="dealName"/>
					</div>
				</div> 
				
			</div>   
			<div class="row">
				<div class="span5 left">
					<div class="form-row">
						<label>Request State</label>
                        <html:multibox name="searchResultsForm" property="requestState" value="1"/> InProgress <br>
                        <html:multibox name="searchResultsForm" property="requestState" value="2"/> Draft <br>
                        <html:multibox name="searchResultsForm" property="requestState" value="3"/> Close <br>
                        <html:multibox name="searchResultsForm" property="requestState" value="4"/> Withdrawn <br>
                        <html:multibox name="searchResultsForm" property="requestState" value="5"/> Rejected <br>
                        <html:multibox name="searchResultsForm" property="requestState" value="6"/> Expired
					</div>
				</div> <!-- end of block -->
					
				<div class="span5 right">
					<div class="form-row">
						<label>Deal with Derivatives</label>
                        <label class="radio">
                        <html:radio name="searchResultsForm" property="dealWithDerivatives" value="1">Yes</html:radio>
                        </label>
                        <label class="radio">
                        <html:radio name="searchResultsForm" property="dealWithDerivatives" value="0">No</html:radio>
                        </label> 
					</div>
				</div> <!-- end of block -->
			</div>                              
				
		</div><!-- end of form form-mod -->
		
		<div class="form-mod">
			<h2 class="span12 collapsible">Region and Business Segment</h2>
			<div class="row">
				<div class="span5">
				<label>Use Ctrl (or Cmd) on your keyboard to select multiple items</label>
					<div class="form-row">
						<label>Region<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
						<html:select name="searchResultsForm" property="region" styleClass="width: 100px;" styleId="regionID" size="4" multiple="true">
						<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
						<html:optionsCollection name="com.ge.icfp.StaticData" property="regionResponsibility" value="ID" label="name"/>
						</html:select>
					</div>
				</div> <!-- end of block -->
				<div class="span5 right" style="margin-top: 20px;">
					<div class="form-row">
						<label>Business Segment<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
						<html:select name="searchResultsForm" property="businessSegment" styleClass="width: 100px;" styleId="businessSegmentID" size="5" multiple="true">
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
		</div>

    
       
		<div class="form-mod">
			<h2 class="span12 collapsible">Date Range</h2>
			<div class="row">
					<div class="span6">
						<div class="form-row">
							<label>Value Date</label>
                            <div class="left">
                                <html:text name="searchResultsForm" property="valueDtFrom" styleClass="span2 searchdatepicker-field" maxlength="10"   />
                                <span class="help-block clear">MM/DD/YYYY</span>
                            </div> 
                            <div class="left" style="margin-left:15px; margin-right:10px; margin-top: 10px;">To</div> 
                            <div class="left">
                                <html:text name="searchResultsForm" property="valueDtTo" styleClass="span2 searchdatepicker-field" maxlength="10"   />
                                <span class="help-block clear">MM/DD/YYYY</span>
                            </div>
						</div>
					</div> <!-- end of block -->
                    
					<div class="span6 right ">
						<div class="form-row">
                        	<!-- <span class="required">*</span> -->
							<label>Request Date</label>
                            <div class="left">
                                <html:text name="searchResultsForm" property="requestDtFrom" styleClass="span2 searchdatepicker-field" maxlength="10" />
                                <span class="help-block clear">MM/DD/YYYY</span>
                            </div> 
                            <div class="left" style="margin-left:15px; margin-right:10px; margin-top: 10px;">To</div> 
                            <div class="left">
                                <html:text name="searchResultsForm" property="requestDtTo" styleClass="span2 searchdatepicker-field" maxlength="10" />
                                <span class="help-block clear">MM/DD/YYYY</span>
                            </div>
						</div>
					</div> <!-- end of block -->
				</div>
				<div class="row">
					<div class="span6">
						<div class="form-row">

							<label>Close Date</label>
                            <div class="left">
                                <html:text name="searchResultsForm" property="closeDtFrom" styleClass="span2 searchdatepicker-field" maxlength="10" />
                                <span class="help-block clear">MM/DD/YYYY</span>
                            </div> 
                            <div class="left" style="margin-left:15px; margin-right:10px; margin-top: 10px;">To</div>
                            <div class="left">
                                <html:text name="searchResultsForm" property="closeDtTo" styleClass="span2 searchdatepicker-field" maxlength="10" />
                                <span class="help-block clear">MM/DD/YYYY</span>
                            </div>
                            
						</div>
					</div> <!-- end of block -->
					                    
				</div>

				
		</div><!-- end of form form-mod -->
		
		<div class="form-mod">
			<h2 class="span12 collapsible collapsed">Lender/Provider/Purchaser</h2>
			<div class="row">
				<div class="span5 left ">
					<div class="form-row">
					<label>Legal Entity Name</label>
		            <html:text name="searchResultsForm" property="lender.LEName" styleId="dealId"/>
	            	</div>
	            </div>
	            <div class="span5 right">
					<div class="form-row">
					<label>Principal Entity</label>
	                <label class="radio">
	                	<input type="radio" value="1" name="lender.princplEntityFlag">Yes
	                </label>
	                <label class="radio">
	                	<input type="radio" value="0" name="lender.princplEntityFlag">No
	                </label> 
					</div>
				</div> <!-- end of block -->
            </div>
            
            <div class="row">
			<div class="span5 left">
				<div class="form-row">
					<label>Regulated Entity</label>
                    <label class="radio">
                        <input type="radio" value="1" name="lender.regulatedEntityFlag">Yes
                    </label>
                    <label class="radio">
                        <input type="radio" value="0" name="lender.regulatedEntityFlag">No
                    </label> 
				</div>
			</div> <!-- end of block -->
            <div class="span5 right">
				<div class="form-row">
					<label>Capital or Industrial</label>
                    <label class="radio">
                        <input type="radio" value="1" name="lender.capitalIndustrial">Capital
                    </label>
                    <label class="radio">
                        <input type="radio" value="2" name="lender.capitalIndustrial">Industrial
                    </label> 
				</div>
			</div> <!-- end of block -->
            
            </div>
            
            <div class="row">
			<div class="span5 left ">
				<div class="form-row">
				<label>Management Entity</label>
            	<html:text name="searchResultsForm" property="lender.MEName" styleId="dealId"/>
            	</div>
            </div>
            <div class="span5 right ">
				<div class="form-row">
				<label>Funding Company/Holding Company/Operationg Company<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
				<html:select name="searchResultsForm" property="lender.fundHoldOperationId" styleClass="width: 100px;" styleId="selectedFunCompany" size="5" multiple="true">
					<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
					<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
 				</html:select>  
				</div>
			</div>
            </div>
            
            <div class="row">
			<div class="span5 left ">
				<div class="form-row">
					<label>CDR</label>
            	<html:text name="searchResultsForm" property="lender.CDRCd" styleId="dealId"/>
            	</div>
            </div>
            </div>

            <div class="row">
			<div class="span5 left ">
				<div class="form-row">
					<label>Country<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
				 	<html:select name="searchResultsForm" property="lender.country" styleClass="width: 100px;" styleId="selectedFunCompany" size="5" multiple="true">
						<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
						<html:optionsCollection name="com.ge.icfp.MasterData" property="countries" value="name" label="name"/>	
 				</html:select>  
				</div>
            </div>
            </div>
        </div>
		
		<div class="form-mod">
			<h2 class="span12 collapsible collapsed">Borrower/Recipent/Issuer</h2>
			<div class="row">
				<div class="span5 left ">
					<div class="form-row">
					<label>Legal Entity Name</label>
		            <html:text name="searchResultsForm" property="borrower.LEName" styleId="dealId"/>
	            	</div>
	            </div>
	            <div class="span5 right">
					<div class="form-row">
					<label>Principal Entity</label>
	                <label class="radio">
	                	<input type="radio" value="1" name="borrower.princplEntityFlag">Yes
	                </label>
	                <label class="radio">
	                	<input type="radio" value="0" name="borrower.princplEntityFlag">No
	                </label> 
					</div>
				</div> <!-- end of block -->
            </div>
            
            <div class="row">
			<div class="span5 left">
				<div class="form-row">
					<label>Regulated Entity</label>
                    <label class="radio">
                        <input type="radio" value="1" name="borrower.regulatedEntityFlag">Yes
                    </label>
                    <label class="radio">
                        <input type="radio" value="0" name="borrower.regulatedEntityFlag">No
                    </label> 
				</div>
			</div> <!-- end of block -->
            <div class="span5 right">
				<div class="form-row">
					<label>Capital or Industrial</label>
                    <label class="radio">
                        <input type="radio" value="1" name="borrower.capitalIndustrial">Capital
                    </label>
                    <label class="radio">
                        <input type="radio" value="2" name="borrower.capitalIndustrial">Industrial
                    </label> 
				</div>
			</div> <!-- end of block -->
            
            </div>
            
            <div class="row">
			<div class="span5 left ">
				<div class="form-row">
				<label>Management Entity</label>
            	<html:text name="searchResultsForm" property="borrower.MEName" styleId="dealId"/>
            	</div>
            </div>
            <div class="span5 right ">
				<div class="form-row">
				<label>Funding Company/Holding Company/Operationg Company<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
				<html:select name="searchResultsForm" property="borrower.fundHoldOperationId" styleClass="width: 100px;" styleId="selectedFunCompany" size="5" multiple="true">
					<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
					<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
 				</html:select>  
				</div>
			</div>
            </div>
            
            <div class="row">
			<div class="span5 left ">
				<div class="form-row">
					<label>CDR</label>
            	<html:text name="searchResultsForm" property="borrower.CDRCd" styleId="dealId"/>
            	</div>
            </div>
            </div>

            <div class="row">
			<div class="span5 left ">
				<div class="form-row">
					<label>Country<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
				 	<html:select name="searchResultsForm" property="borrower.country" styleClass="width: 100px;" styleId="selectedFunCompany" size="5" multiple="true">
						<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
						<html:optionsCollection name="com.ge.icfp.MasterData" property="countries" value="name" label="name"/>	
 				</html:select>  
				</div>
            </div>
            </div>
        </div>
		
		<div class="form-mod">
			<h2 class="span12 collapsible collapsed">Cash Pool Participant</h2>
			<div class="row">
				<div class="span5 left ">
					<div class="form-row">
					<label>Legal Entity Name</label>
		            <html:text name="searchResultsForm" property="cashPoolParticipant.LEName" styleId="dealId"/>
	            	</div>
	            </div>
	            <div class="span5 right">
					<div class="form-row">
					<label>Principal Entity</label>
	                <label class="radio">
	                	<input type="radio" value="1" name="cashPoolParticipant.princplEntityFlag">Yes
	                </label>
	                <label class="radio">
	                	<input type="radio" value="0" name="cashPoolParticipant.princplEntityFlag">No
	                </label> 
					</div>
				</div> <!-- end of block -->
            </div>
            
            <div class="row">
			<div class="span5 left">
				<div class="form-row">
					<label>Regulated Entity</label>
                    <label class="radio">
                        <input type="radio" value="1" name="cashPoolParticipant.regulatedEntityFlag">Yes
                    </label>
                    <label class="radio">
                        <input type="radio" value="0" name="cashPoolParticipant.regulatedEntityFlag">No
                    </label> 
				</div>
			</div> <!-- end of block -->
            <div class="span5 right">
				<div class="form-row">
					<label>Capital or Industrial</label>
                    <label class="radio">
                        <input type="radio" value="1" name="cashPoolParticipant.capitalIndustrial">Capital
                    </label>
                    <label class="radio">
                        <input type="radio" value="2" name="cashPoolParticipant.capitalIndustrial">Industrial
                    </label> 
				</div>
			</div> <!-- end of block -->
            
            </div>
            
            <div class="row">
			<div class="span5 left ">
				<div class="form-row">
				<label>Management Entity</label>
            	<html:text name="searchResultsForm" property="cashPoolParticipant.MEName" styleId="dealId"/>
            	</div>
            </div>
            <div class="span5 right ">
				<div class="form-row">
				<label>Funding Company/Holding Company/Operationg Company<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
				<html:select name="searchResultsForm" property="cashPoolParticipant.fundHoldOperationId" styleClass="width: 100px;" styleId="selectedFunCompany" size="5" multiple="true">
					<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
					<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
 				</html:select>  
				</div>
			</div>
            </div>
            
            <div class="row">
			<div class="span5 left ">
				<div class="form-row">
					<label>CDR</label>
            	<html:text name="searchResultsForm" property="cashPoolParticipant.CDRCd" styleId="dealId"/>
            	</div>
            </div>
            </div>

            <div class="row">
			<div class="span5 left ">
				<div class="form-row">
					<label>Country<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
				 	<html:select name="searchResultsForm" property="cashPoolParticipant.country" styleClass="width: 100px;" styleId="selectedFunCompany" size="5" multiple="true">
						<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
						<html:optionsCollection name="com.ge.icfp.MasterData" property="countries" value="name" label="name"/>	
 				</html:select>  
				</div>
            </div>
            </div>
        </div>
		
		<div class="form-mod">
			<h2 class="span12 collapsible collapsed">Cash Pool Leader</h2>
			<div class="row">
				<div class="span5 left ">
					<div class="form-row">
					<label>Legal Entity Name</label>
		            <html:text name="searchResultsForm" property="cashPoolLeader.LEName" styleId="dealId"/>
	            	</div>
	            </div>
	            <div class="span5 right">
					<div class="form-row">
					<label>Principal Entity</label>
	                <label class="radio">
	                	<input type="radio" value="1" name="cashPoolLeader.princplEntityFlag">Yes
	                </label>
	                <label class="radio">
	                	<input type="radio" value="0" name="cashPoolLeader.princplEntityFlag">No
	                </label> 
					</div>
				</div> <!-- end of block -->
            </div>
            
            <div class="row">
			<div class="span5 left">
				<div class="form-row">
					<label>Regulated Entity</label>
                    <label class="radio">
                        <input type="radio" value="1" name="cashPoolLeader.regulatedEntityFlag">Yes
                    </label>
                    <label class="radio">
                        <input type="radio" value="0" name="cashPoolLeader.regulatedEntityFlag">No
                    </label> 
				</div>
			</div> <!-- end of block -->
            <div class="span5 right">
				<div class="form-row">
					<label>Capital or Industrial</label>
                    <label class="radio">
                        <input type="radio" value="1" name="cashPoolLeader.capitalIndustrial">Capital
                    </label>
                    <label class="radio">
                        <input type="radio" value="2" name="cashPoolLeader.capitalIndustrial">Industrial
                    </label> 
				</div>
			</div> <!-- end of block -->
            
            </div>
            
            <div class="row">
			<div class="span5 left ">
				<div class="form-row">
				<label>Management Entity</label>
            	<html:text name="searchResultsForm" property="cashPoolLeader.MEName" styleId="dealId"/>
            	</div>
            </div>
            <div class="span5 right ">
				<div class="form-row">
				<label>Funding Company/Holding Company/Operationg Company<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
				<html:select name="searchResultsForm" property="cashPoolLeader.fundHoldOperationId" styleClass="width: 100px;" styleId="selectedFunCompany" size="5" multiple="true">
					<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
					<html:optionsCollection name="com.ge.icfp.StaticData" property="fundingCompany" value="ID" label="name"/>	
 				</html:select>  
				</div>
			</div>
            </div>
            
            <div class="row">
			<div class="span5 left ">
				<div class="form-row">
					<label>CDR</label>
            	<html:text name="searchResultsForm" property="cashPoolLeader.CDRCd" styleId="dealId"/>
            	</div>
            </div>
            </div>

            <div class="row">
			<div class="span5 left ">
				<div class="form-row">
					<label>Country<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
				 	<html:select name="searchResultsForm" property="cashPoolLeader.country" styleClass="width: 100px;" styleId="selectedFunCompany" size="5" multiple="true">
						<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
						<html:optionsCollection name="com.ge.icfp.MasterData" property="countries" value="name" label="name"/>	
 					</html:select>  
				</div>
            </div>
            </div>	
       	</div>
       
        
	<div class="form-mod">

			<h2 class="span12 collapsible collapsed">Cash Pool Details</h2>
			
			<div class="row">
				<div class="span5 left ">
					<div class="form-row">
						<label>Bank Name<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
					 	<html:select name="searchResultsForm" property="cashPoolDetailsBankName" styleClass="width: 100px;" styleId="selectedFunCompany" size="5" multiple="true">
						<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
						<html:optionsCollection name="com.ge.icfp.MasterData" property="bankInformations" value="key" label="value"/>	
						</html:select>
					</div>
				</div>
							
				<div class="span5 right ">
						<div class="form-row">
							<label>Cash Pool Country<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
						 	<html:select name="searchResultsForm" property="cashPoolDetailsCountry" styleClass="width: 100px;" styleId="selectedFunCompany" size="5" multiple="true">
							<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
							<html:optionsCollection name="com.ge.icfp.MasterData" property="countries" value="name" label="name"/>	
							</html:select> 
						</div>
					</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span5 left">
					<div class="form-row">
						<label>Cash Pool Region<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
						<html:select name="searchResultsForm" property="cashPoolDetailsRegion" styleClass="width: 100px;" styleId="selectedFunCompany" size="5" multiple="true">
						<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
						<html:optionsCollection name="com.ge.icfp.MasterData" property="regions" value="name" label="name"/>	
						</html:select>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<label>Cash Pool Currency<span class="ttip info" title="Use Ctrl (or Cmd) on your keyboard to select multiple items"></span></label>
						<html:select name="searchResultsForm" property="cashPoolDetailsCurrency" styleClass="width: 100px;" styleId="selectedFunCompany" size="5" multiple="true">
						<html:option value=""><bean:message key="label.addLeg.select" /></html:option>
						<html:optionsCollection name="com.ge.icfp.MasterData" property="dealCurrencies" value="id" label="name"/>	
						</html:select>
					</div>
				</div><!-- end of block -->
				
			</div>
			
		</div> 
        
        <p>&nbsp;</p>
        
		<div class="span12 right btn-container">
			<a href="#" class="btn right btn-success" id="searchAction">Search</a>
			<a href="#" class="btn-link right cancel" id="clearForm">Clear Form</a>                  
		</div>


		</html:form>
   <hr>
    </div>
	<%@include file="../common/footerSection.jsp" %>
	
</body>
</html>