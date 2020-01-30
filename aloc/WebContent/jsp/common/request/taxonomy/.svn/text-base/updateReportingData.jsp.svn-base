<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${param.includeScripts != false}">
	<link href="css/bootstrap/bootstrap.css" rel="stylesheet">
	<%@include file="../../includeCommonScripts.jsp" %>
</c:if>
<c:if test="${not empty requestScope.successMsg}" >
		<div id="siteMsg">
            <div class="sucessMsg">
            	<a href="javascript:;" class="right successclose" style="margin-right:5px;">X</a>Success
            </div>
            <div class="sucessContent"><s:property value="#request.successMsg" /></div>
        </div>
  </c:if>
<s:if test="hasActionMessages()">
	<div class="row">
		<div class="span12">
			<div class="errorbox">
				<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
				<div class="errorContent"><p><s:actionmessage/></p></div>
			</div>
		</div>
	</div>
</s:if>
<s:if test="hasFieldErrors()">
	<div class="row">
		<div class="span12">
			<div class="errorbox">
				<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
				<div class="errorContent"><p><s:fielderror/></p></div>
			</div>
		</div>
	</div>
</s:if>
<c:if test="${updateReportingData.AMDExists eq 'Y' }">
<div class="row">
				<div class="span12">
					<div class="errorbox">
						<div class="noteHead">
							<p class="noteicon">
								<s:text name="label.common.alert" />
							</p>
						</div>
						<div class="noteContent">
							<p>
								<s:text name="label.request.updateReportingDataInfo"></s:text>
							</p>
						</div>
					</div>
				</div>
			</div>
	</c:if>
	<c:if test="${not empty updateReportingData}">
	   <h2><s:text name="label.request.updateReportingData" /></h2>     
		<div class="span12">
			<div class="row">
				<table class="table table-striped table-bordered sortable">
					<thead>
					</thead>
					<tbody>
						<tr class="odd">
							<td>
								<s:textfield name="updateReportingData.USExpirationDate"
								theme="aloc" key="label.request.usExpirationDate"
								cssClass="date"></s:textfield>
								<p class="guidance"><s:text name="label.request.dateFormat" /></p>
								<s:hidden name="updateReportingData.oldUSExpirationDate" value="%{updateReportingData.oldUSExpirationDate}"/>
							</td>
							<td>
								<s:textfield name="updateReportingData.foreignExpirationDate" 
								key="label.request.foreignExpirationDate"
								cssClass="date" theme="aloc"/>
								<p class="guidance"><s:text name="label.request.dateFormat" /></p>
								<s:hidden name="updateReportingData.oldForeignExpirationDate" value="%{updateReportingData.oldForeignExpirationDate}"></s:hidden>
							</td>
						</tr> 
						<tr>
							<td><c:if test="${updateReportingData.lastUSPaidDateFlag eq 'Y'}">
									<s:textfield name="updateReportingData.lastUSPaidDate" 
									key="label.request.lastUSPaidDate"
									cssClass="date" theme="aloc"/>
									<p class="guidance"><s:text name="label.request.dateFormat" /></p>
								</c:if>
								<c:if test="${updateReportingData.lastUSPaidDateFlag ne 'Y'}">
									<s:label key="label.request.lastUSPaidDate" />
									<c:if test="${not empty updateReportingData.lastUSPaidDate}">
										<s:property value="updateReportingData.lastUSPaidDate"/>
									</c:if>
									<c:if test="${empty updateReportingData.lastUSPaidDate}">
									-
									</c:if>
									<s:hidden name="updateReportingData.lastUSPaidDate"/>
								</c:if>
							</td>
							<td><c:if test="${updateReportingData.lastForeignPaidDateFlag eq 'Y'}">
									<s:textfield name="updateReportingData.lastForeignPaidDate" 
									key="label.request.lastForeignPaidDate"
									cssClass="date" theme="aloc"/>
									<p class="guidance"><s:text name="label.request.dateFormat" /></p>
								</c:if>
								<c:if test="${updateReportingData.lastForeignPaidDateFlag ne 'Y'}">
									<s:label key="label.request.lastForeignPaidDate" />
									<c:if test="${not empty updateReportingData.lastForeignPaidDate}">
										<s:property value="updateReportingData.lastForeignPaidDate"/>
									</c:if>
									<c:if test="${empty updateReportingData.lastForeignPaidDate}">
									-
									</c:if>
									<s:hidden name="updateReportingData.lastForeignPaidDate"/>
								</c:if>
							</td>
						</tr> 
						<tr class="odd">
							<td>
								<s:textfield name="updateReportingData.issuanceDate" 
								key="label.request.issuanceDate"
								cssClass="date" theme="aloc"/>
								<p class="guidance"><s:text name="label.request.dateFormat" /></p>
							</td>
							<td>
								<s:textfield name="updateReportingData.bankReferenceNumber" cssClass="span2"
								key="label.apm.bankRefNumber"
								maxlength="20"theme="aloc"
								/>
							</td>
						</tr> 
						<tr>
							<td class="span4 currencyRow"><div class="span3">
								
								<sj:autocompleter id="updateReportCurrencies" onChangeTopics="getUpdateReportAutocompleterName,getUpdateReportUSDConversion" 
									list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}" key="label.advanceSearch.addElement.country"
									name="updateReportingData.currencyCode" cssClass="span3 mandatory" 
									listKey="currencyCode" listValue="currencyName" parentTheme="aloc"/>
								<s:hidden name="updateReportingData.currencyName" cssClass="updateReportAutoCompleterName"/>
								</div>
								
								<div class="span3" style="margin-top: -42px; margin-left: 220px; margin-right: -300px;">
								<s:textfield name="updateReportingData.currencyAmount" cssClass="span2 bigDecimal updateReportAmount"
								key="label.request.osAmountinOriginalCurrency" 
								maxlength="20" theme="aloc"/>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." id="updateReportUSDProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display: none; height: 20px; width: 20px;">
								</div>
							</td>
							<td><s:text name="label.request.osAmountinUSDEquivalent"></s:text> <br>
								<div id="usdShow">
									<span id="updateReportUSDAmount"> </span>
									<s:hidden name="updateReportingData.USDCurrencyAmount" id="updateUSDVal"/>
								</div>
							</td>
						</tr> 
						<tr class="odd">
							<td colspan="2">
								<s:textarea name="updateReportingData.reasonForchange" id="reasonforChange" cssClass="autosize messageinput" 
								cssStyle="width:900px ;height:50px;" key="label.request.enterReasonForChange" 
								onkeypress="return imposeMaxLength(this, 399);" theme="aloc"/>
								<div class="clear"></div>
					            <div class="counter"><s:text  name="label.common.siteAdmin.fourHundred"/></div> <!-- fix positions -->
					            <div class="counterTxt"><p class="guidance"><s:text  name="label.common.siteAdmin.limit400Characters"/></p></div>
							</td>
							<s:hidden name="updateReportingData.AMDFlag"/>
						</tr>
					</tbody>
				</table>
				<!-- <div id="webcashPanel">
		<div class="row">
			<div class="span12"> -->
				<div class="form-row">
					<s:radio cssClass="radio" name="updateReportingData.webCashFlag"
						key="label.request.suppressWebcash" theme="aloc"
						id="webcashFlag"
						list="#{'Y':'Yes','N':'No'}"
						value="%{updateReportingData.webCashFlag}" />
				</div>
			<!-- </div>
		</div>
		end of block
	</div> -->
				
		<h2 id="updatereportingAuditlog" class="section_flip section_blue acc_trigger1">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.16"/></a>
		</h2><hr class="h2-hr">
		<div id="updatereportingAuditlogPanel" class="section_panel acc_container1">
			<jsp:include page="/jsp/common/request/taxonomy/updateReportingAuditLog.jsp" />
		</div>             
		<div class="clear"></div>,
				
			</div>
		</div>
	</c:if>
	