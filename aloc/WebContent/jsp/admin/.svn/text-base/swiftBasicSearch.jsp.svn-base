<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:url action="searchSwiftMessageMonitoring.action" var="SwiftsearchURL" namespace="/int/admin" encode="true" escapeAmp="false"/>
<s:url action="basicSearchSwiftMessageMonitoring.action" var="SwiftbasicsearchURL" namespace="/int/admin" encode="true" escapeAmp="false"/>

<div class="row">
	<div class="span12">
		<div class="form-row" style="padding-left: 430px;">
			
			<s:text name="label.swiftMessageMonitoring.search.alocRecordNumber"/>
			<s:textfield name="searchCriteriaText" id="searchCriteriaText"
				onblur="this.value=(this.value=='') ? 'Search...' : this.value;"
				onfocus="this.value=(this.value=='Search...') ? '' : this.value;"
				value="Search...">
			</s:textfield>
			
			<a style="margin-left:10px;" class="btn-secondary lookup conditional-btn" href="<s:property value="#SwiftbasicsearchURL" />" id="basicSearch">
				<s:text name="label.dashboard.search"/>
			</a>
			
			<img alt="Loading..." id="searchIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
						style="height: 20px; display:none">
			<a href="javascript:;" class="advanceSearch"><s:text name="label.swiftMessageMonitoring.search.advancedSearch"/></a>
			
		</div>	
		<div class="hide filterMsg">
		<s:form name="SwiftSearchForm" id="SwiftSearchFormID">
			<h2 id="swiftAdvanceSearch" class="section_flip section_blue">
				<a href="javascript:;"><s:text name="label.swiftMessageMonitoring.search.advancedSearch"/></a>
			</h2><hr class="h2-hr">
       		<div id="swiftAdvanceSearchPanel" class="section_panel">

                <table id="tableModel" class="table table-striped table-bordered">
                <thead>
                    <tr>
                    	<td colspan="7"><s:text name="label.standardFormatMgmt.instrumentType"/></td>
                    </tr>
				</thead>
                <tbody>
                	<tr>
                        <td class="span2"><s:checkbox name="swiftMonitoring.instruments" fieldValue="Bank Guarantee" id="bgInstrument"/><s:text name="label.swiftMessageMonitoring.bankGuarantee"/></td>
                        <td class="span11"><s:checkbox name="swiftMonitoring.instruments" fieldValue="Standby Letter of Credit" id="slocInstrument"/><s:text name="label.swiftMessageMonitoring.standbyletterOfCredit"/></td>
                    </tr>
                </tbody>
                </table>
                
                
                <div class="row">
                	<div class="span2">
                        <label><s:text name="label.swiftMessageMonitoring.search.alocRecordNumber" /></label>
                        <s:textfield name="swiftMonitoring.ALOCRecordId" cssClass="span2" id="alocRecordNumber" theme="aloc"/>
                    </div>
                    
                    <div class="span2">
                        <label><s:text name="label.swiftMessageMonitoring.subMessageType" /></label>
                        <s:textfield name="swiftMonitoring.subMessageType" cssClass="span2" id="subMessageType" theme="aloc"/>
                    </div>
                    
                    <div class="span2">
                        <label><s:text name="label.suretynamemgmt.tableHeader.status" /></label>
                        <s:textfield name="swiftMonitoring.status" cssClass="span2" id="status" theme="aloc"/>
                    </div>

                    <div class="span2">
                        <label><s:text name="label.swiftMessageMonitoring.direction" /></label>
                        <s:textfield name="swiftMonitoring.direction" cssClass="span2" id="direction" theme="aloc"/>
                    </div>
					
					<div class="span3">
                        <label><s:text name="label.swiftMessageMonitoring.messageSequenceGroup"/></label>
                        <s:textfield name="swiftMonitoring.messageSequenceGroup" cssClass="span2" id="messageSequenceGroup" theme="aloc"/>
                    </div>
                                      
                    
                </div>
                
                <div class="row">
                	<div class="span12">
                		<label><s:text name="label.standardFormatMgmt.date"/></label>
                         <s:textfield name="swiftMonitoring.dateTime" cssClass="date" id="swiftdate" theme="aloc"/>
                         &nbsp;&nbsp;  to &nbsp;&nbsp;
                         <s:textfield name="swiftMonitoring.rangeDate" cssClass="date" id="swiftTodate" theme="aloc"/>
                         <a href="<s:property value="#SwiftsearchURL" />" class="btn-secondary lookup conditional-btn advanceSearchBtn">
							<s:text name="label.dashboard.search"/>
						 </a>
						<img alt="Loading..." id="advSearchIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
							style="height: 20px; display:none">
                    </div>

                </div>       
            </div>
            </s:form>
        </div>
	</div>
</div>
