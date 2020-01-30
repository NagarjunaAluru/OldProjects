<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="form-mod">
			<s:set name="noOfLEs" value="bankDetailsList.size"/>
			<input type="hidden" value="${param.bankSiteType}" id="bankSiteType">
			<h1 class="page-title span12"> Bank Lookup Results - <s:property value="%{#noOfLEs}"/></h1>
			<p class="span12 left clear dashdesc">
			You search for: <s:property value="bankName"/>
			<s:hidden value="%{#parameters['scrollTopValue']}" id="scrollTopValueId" name="scrollTopValue"/>
			</p>
			<hr class="page-title-hr">
			<div class="clear"></div>
			<!-- If No Records Found from MDM when lookup from create request page. -->
	<!-- If No Records Found from MDM when lookup from create request page. -->
	<c:if test="${empty bankDetailsList}">
	<div class="row highlighted">
		<div class="span12">
			<p style="padding:5px;">No results found. Try a different Search.
		</div>
	</div>
	</c:if>
			<div class="row">
				<div class="span5">
					<div class="">
						<p><a href="javascript:;" onClick="javascript:returnToMainPage();">&#60; Return to Request Form</a></p>
					</div>
				</div>
			</div>
			<s:form id="bankAdvanceSearchForm" cssStyle="margin: 0px!important;">
	         <div class="row">
			 <div class="form-row">
				<div class="span3">
				    <label>Bank Name</label>
					<s:if test="%{readOnlyFlag == true}">
						<s:textfield name="bankName" cssClass="span3  lookup-filterValue" id="bankLookupName" readonly="true"/>
					</s:if>
					<s:else>
						<s:textfield name="bankName" cssClass="span3  lookup-filterValue" id="bankName" />
					</s:else>
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
				<div class="span3">
					<label>Country</label>
					<sj:autocompleter id="bankDetailCountryCodeId" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
							name="bankDetailCountryCd" cssClass="span2 bankDetailCountryCode" listKey="countryCode" listValue="countryName" 
							theme="aloc" onChangeTopics="getAutocompleterName"/>
					<s:hidden name="bankDetailCountry" id="bankDetailCountryNameId" cssClass="autoCompleterName"></s:hidden>
				</div>
				<div class="span2">
					<label>Bank city</label>
					<s:textfield name="bankCity" cssStyle="width: 140px;" id="bankCity"  cssClass="bankCityName" />
				</div>
				<div class="span1">
					<label>&nbsp;</label>
					<s:url action="BankDetailsLookup" namespace="/int" var="getBankDetailsURL" escapeAmp="false" encode="true">
							<s:param name="pageNumber">1</s:param>
							<s:param name="readOnlyFlag"><s:property value="readOnlyFlag"/></s:param>
						</s:url>
					<a class="btn-secondary lookup" href="<s:property value="#getBankDetailsURL"/>" ><s:text name="label.request.common.lookup"/></a>&nbsp;
	            </div>
                <div class="span1">
                   	<label>&nbsp;</label>
                   	<img alt="Loading..." id="bankIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px">
                </div>
                <div class="down left" id="arrow" style="margin-top: 25px;"></div>
						<p class="right" style="margin-right:10px; text-align:center; margin-top: 25px;">
							<a href="javascript:;" class="" id="advSear">Advanced Search</a>
				    	</p>
	         </div>
		</div>
			<div class="row highlighted hide" id="advSearShow">
				<div class="span12">
					<h5>Filter by:</h5><br />
					<p class="required-fields" style="margin-top: -30px; margin-left: 760px;">All fields required unless specified</p>
					<div class="row">
						<div class="span2">
							<label>Bank address (optional)</label>
							<s:textfield name="bankAddress" cssStyle="width: 140px;" id="bankAddress" />
						</div>
						<div class="span3">
							<label>Bank Identifier Code (BIC)</label>
							<s:textfield name="bankBIC" cssStyle="width: 140px;" id="bankBIC" />
						</div>
						<div class="span2" style="margin-top: 20px;">
							<s:url action="BankAdvanceSearchLookup" namespace="/int" var="bankAdvanceSearchURL" escapeAmp="false" encode="true">
								<s:param name="pageNumber">1</s:param>
							</s:url>
							<a class="btn-primary bankAdvanceSearchBtn" href="<s:property value="#bankAdvanceSearchURL" />" >
								<s:text name="label.dashboard.search"/>
							</a>
							<img alt="Loading..." id="advBankIndicator" class="indicator" 
							src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none">
						</div>
					</div>
				</div>
			</div>
			<s:hidden name="readOnlyFlag" id="readOnlyFlagId" value="%{readOnlyFlag}"></s:hidden>
			</s:form>
			<s:if test="#noOfLEs > 0">
			<div class="active">
				<div id="searchSort">
				   	<div class="leftColSort">
				       	<p id="itemsPerPage">
				       		Showing <span id="start"></span> - <span id="end"></span> of <span id="total"></span> results
				       	</p>
				    </div>
				    <div class="rightColSort">
				         	Show&nbsp;&nbsp;
						<select class="pagination-rows">
						<option>10</option>
						<option selected="selected">20</option>
						<option>30</option>
						<option>40</option>
						<option>50</option>
						</select>&nbsp;&nbsp;results
				    </div>
					<div class="clear"></div>
				</div>
				<table class="table table-striped table-bordered sortable no-bottom active paginate lookupTableRes">
	                <thead>
	                    <tr>
		                    <th colspan="1" width="50px">Action</th>
		                    <th colspan="1" width="100px">Bank Name</th>
							<th>Country</th>
							<th>City</th>
		                    <th>Address</th>
		                    <th>Bank Identifier Code (BIC)</th>
		                </tr>
	                </thead>
	                <tbody>
	                	<s:iterator value="bankDetailsList" status="stat">
		                <tr class="shown">
			                <td>
			               	 	<input type="button" class="btn-secondary bank" id="bankId<s:property value="#stat.index" />" value="Select">
			                </td>
							<td><p><s:property value="bankName"/></p></td>
							<td><p><s:property value="bankAddress.country"/></p></td>
							<td><p><s:property value="bankAddress.city"/></p></td>
							
							<td><p>
								<s:iterator value="bankAddress.address">
									<s:property/><br/>
								</s:iterator>
							</p></td>
							<td><p><s:property value="BICCode"/></p></td>
							<td style="display: none"><s:property value="bankAddress.address[0]"/></td>
							<td style="display: none"><s:property value="bankAddress.address[1]"/></td>
							<td style="display: none"><s:property value="bankAddress.stateProvince"/></td>
							<td style="display: none"><s:property value="bankAddress.ZIPPostalCode"/></td>
							<td style="display: none"><s:property value="bankMDMId"/></td>
							<td style="display: none"><s:property value="countryCd"/></td>
						</tr>
						</s:iterator>
					</tbody>
				</table>
				<div class="clear"></div>
				<div id="searchSort">
				   	<div class="leftColSort">
						<p id="itemsPerPage1">Showing <span id="start"></span> - <span id="end"></span> of <span id="total"></span> results</p>
					</div>
				</div>
				<div class="clear"></div>
				<div class="row" id="hideLessthan10">
					<input type='hidden' id='current_page' />
					<div class="span33 right" id="bankPageDivID">
				    	<c:if test="${previousPageStart gt 0 }">
				    	<s:if test="%{bankName != null}">
					    	<s:url action="BankDetailsLookup" namespace="/int" var="getPreviousBankURL" escapeAmp="false" encode="true">
					    		<s:param name="pageNumber"><s:property value="previousPageStart"/> </s:param>
					    		<s:param name="filterValue"><s:property value="bankName"/></s:param>
							</s:url>
							<a type="submit" id="previousID" href="<s:property value="#getPreviousBankURL"/>" class="btn btn-success left">&#60;Previous 100</a>
						</s:if>
						<s:else>
							<s:url action="BankAdvanceSearchLookup" namespace="/int" var="getPreviousBankURL" escapeAmp="false" encode="true">
					    		<s:param name="pageNumber"><s:property value="previousPageStart"/> </s:param>
							</s:url>
							<a type="submit" id="previousIDSearch" href="<s:property value="#getPreviousBankURL"/>" class="btn btn-success left">&#60;Previous 100</a>
						</s:else>
			           	
			           	</c:if>
			           	<c:if test="${recordCount ge 100 }">
			           	<s:if test="%{bankName != null}">
				           	<s:url action="BankDetailsLookup" namespace="/int" var="getNextBankURL" escapeAmp="false" encode="true">
					    		<s:param name="pageNumber"><s:property value="nextPageStart"/></s:param>
					    		<s:param name="filterValue"><s:property value="bankName"/></s:param>
							</s:url>
							<a type="submit" id="nextID" href="<s:property value="#getNextBankURL"/>" class="btn btn-success left">Next 100&#62;</a>
						</s:if>
						<s:else>
							<s:url action="BankAdvanceSearchLookup" namespace="/int" var="getNextBankURL" escapeAmp="false" encode="true">
					    		<s:param name="pageNumber"><s:property value="nextPageStart"/></s:param>
							</s:url>
							<a type="submit" id="nextIDSearch" href="<s:property value="#getNextBankURL"/>" class="btn btn-success left">Next 100&#62;</a>
						</s:else>
			           	
			           	</c:if>
			           	<img alt="Loading..." id="next100LEIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" >
			        </div>
	          		<div class="span right">
				       	<div class="pagenavi left">
				       		
				       	</div>
				    	<div class="span2bb jump-page">page: <input type="text" class="span1 manual">
							<a class="btn btn-success-blue" type="submit">Go</a>
						</div>
					</div>
	      		</div>
        		
			</div>
			<div class="row">
			<div class="span5">
				<div class="">
					<p><a href="javascript:;" onClick="javascript:returnToMainPage();">&#60; Return to Request Form</a></p>
				</div>
			</div>
			</div>
			</s:if>
			
	</div>
		