<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.suretynamemgmt.screenName" /></title>
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../common/includeCommonScripts.jsp"%>
<script
	src="${pageContext.request.contextPath}/js/admin/suretyNameMgmt.js"
	type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css"
	type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="container main">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>		
		 <!-- WARNING MESSAGE -->
        <div class="row hide">
            <div class="span12">
                <div class="warning">
                <p><b><s:text name="label.suretynamemgmt.warningLabel" /></b></p>
                <p><s:text name="label.suretynamemgmt.warningMessage" /></p>
                </div>
            </div>
        </div>

		<!-- <div id="mainPage"> -->
            <h1 class="page-title span12"><s:text name="label.suretynamemgmt.screenName" /></h1>
            <p class="span12 left clear dashdesc"><s:text name="label.optionalInstructionSentence.suretynamemgmt" /></p>	
            <hr class="page-title-hr">	
            <p class="required-fields-para2" style="margin-top: -35px!important;"><s:text name="label.common.siteAdmin.allFieldsAreRequired" /></p>
   	    <div class="form-mod">
        <div class="row">
        <div class="span12"> 
        <div class="row">
        
        <br>
			<div class="span12" id="suretyNameDiv">
				<s:if test="%{suretyList.suretyMasters.isEmpty}">
					<div class="siteMsg"><s:text name="label.suretynamemgmt.noSuretyNames" />
						<a href="javascript:;" id="addFirstSurety"><s:text  name="label.suretynamemgmt.addSuretyNames"/></a>
					</div>
					<table id="suretyNamesTable" class="hide table table-striped table-bordered no-bottom paginate">
					<thead>
						<tr>
								<th width="5%"><s:text name="label.suretynamemgmt.tableHeader.action" /></th>
								<th width="10%"><s:text name="label.suretynamemgmt.tableHeader.status" /></th>
								<th><s:text	name="label.suretynamemgmt.tableHeader.suretyName" /></th>
						</tr>
					</thead>
					<tbody  id="addNewTbodyId">
					</tbody>
					</table>
				</s:if>
				<s:else>
					<table id="suretyNamesTable" class="table table-striped table-bordered no-bottom paginate">
					<thead>
						<tr>
								<th width="5%"><s:text name="label.suretynamemgmt.tableHeader.action" /></th>
								<th width="10%"><s:text name="label.suretynamemgmt.tableHeader.status" /></th>
								<th><s:text	name="label.suretynamemgmt.tableHeader.suretyName" /></th>
						</tr>
					</thead>
					<tbody>
		        		<s:iterator value="suretyList.suretyMasters" status="suretyStat">
							<tr class="shown curRowVal">
								<td><img class="actionImg editSuretyName" src="${pageContext.request.contextPath}/img/edit-leg.gif"  alt="<s:property value="#suretyStat.index"/>">
								<img alt="Loading..." class="editSuretyProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
								</td>
								<td class="suretyStatus">
									<s:if test="%{suretyStatus}">
        								<s:text name="label.suretynamemgmt.enabled" />
        							</s:if>
        							<s:else>
        								<s:text name="label.suretynamemgmt.disabled" />
        							</s:else>
								</td>
								<td class="suretyName" style="word-wrap: break-word;">
								<div style="width: 600px; overflow: auto;"><s:property value="suretyName"/></div></td>
								<td class="hide suretyId"> <s:property value="suretyId" /></td>
								<td class="hide suretyErrorId"> <s:property value="%{errorSurety}"/></td>
							</tr>
						</s:iterator>
						</tbody>
				  </table>
			</s:else>
			<s:hidden id="newSuretyIndexId" name="newSuretyIndex" value="%{suretyList.suretyMasters.size}" />
		</div>
	</div>
 </div>	
 
 			<s:url action="treasuryAdminPortal.action" namespace="/int/admin" var="treasuryAdminPortalURL" />	
        	 <div class="row">
				<div class="span12">
				<div class="hide" id="addNewSuretyDiv" style="margin-left:15px;">
					<a href="javascript:;" class="left addNewSuretyName add"><s:text  name="label.suretynamemgmt.addSuretyNames"/></a>
					<img alt="Loading..." class="addNewSuretyProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
				</div>
	        </div>  
 	
 <s:if test="%{(suretyList != null || !suretyList.suretyMasters.isEmpty) && suretyList.suretyMasters.size > 50}">
	<div class="clear"></div>
    <div class="row">
				<!-- pagination pagination-right -->
			       <div class="span right">
			       	<div class="pagenavi left">	
			       			       		
			       	</div>
			    	<div class="span3 jump-page">
						<s:text name="label.jumpTo"/>
						<input type="text" class="span1 manual">
						<a class="btn btn-success-blue" type="submit"><s:text name="label.go"/></a>
					</div>
				</div>
			</div>
        	<input type='hidden' id='current_page' />
        	<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
   </s:if>
	 </div>
	 <div class="clear"></div> 
            <div class="highlighted">
                <a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.common.cancel"></s:text></a> 
            </div>
				</div>
				</div>	 
	<!-- wrapper ends here -->
	<%@include file="../common/footerSection.jsp"%>	
	<jsp:include page="../admin/treasuryAdminExitPopup.jsp" />	
		
	<!-- DELETE SURETY NAME POPUP WINDOW -->
	<div class="modal hide fade" id="deleteSuretyModal">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.suretynamemgmt.header.deleteSurety" /><span></span></h3>
		</div>
		<div class="modal-body">
				<p><s:text name="label.suretynamemgmt.body.deleteSurety" /> </p>
				<s:hidden id="suretyId" name="suretyId" />
	           	<p><s:text name="label.suretynamemgmt.tableHeader.suretyName" /> <s:textfield cssClass="noModelBorders" id="suretyName" name="suretyName" /></p>
	           	<h3><s:text name="label.suretynamemgmt.body.actionUndone" /></h3>
		</div>
		<div class="modal-footer">
		    <a href="javascript:;" id="deleteSuretyNameRow" data-dismiss="modal" class="left btn-primary">Delete</a>
			<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.treasuryAdminPortal.cancel"/></a>
		</div>
	</div>	
	
	 <div class="modal hide fade" id="deleteSuretySizeOneModal">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3><s:text name="label.request.unabletoDelete" /><span></span></h3>
			</div>
			<div class="modal-body">
			<form>
			<p><s:text name="label.suretynamemgmt.body.oneSurety" /> </p>
			</form>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.closeWindow" /> </a>
			</div>
	</div> 
   </body>
</html>
	