<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.polenamemgmt.screenName" /></title>
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../common/includeCommonScripts.jsp"%>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css"
	type="text/css" rel="stylesheet" />
<!-- Multiselect -->
	<link type="text/css" href="${pageContext.request.contextPath}/css/others/jquery-ui-1.7.1.custom.css" rel="stylesheet" />
	<link type="text/css" href="${pageContext.request.contextPath}/css/others/ui.multiselect.css" rel="stylesheet" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-ui-1.8.custom.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.localisation-min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.tmpl.1.1.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.blockUI.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/ui.multiselect.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/poleNameMgmt.js"></script>
</head>
<body>
	<div class="container main">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage">
            <h1 class="page-title span12">
				<s:text name="label.polenamemgmt.screenName" />
			</h1>
				
				<p class="span12 left clear dashdesc"><s:text name="label.optionalInstructionSentence.poleManagement" />
        			<span class="required-fields-para3"><s:text name="label.common.siteAdmin.allFieldsAreRequired" /></span>
        		</p>
				<hr class="page-title-hr">
		   <div class="clear"></div>
		   
		   <div class="row">
					<div class="span12" id="poleNameDiv">
						<s:if test="%{poleNameManagements == null || poleNameManagements.isEmpty}">
							<div class="siteMsg"><s:text name="label.polenamemgmt.noPoleNames" />
								<a href="javascript:;" id="addFirstPole"><s:text  name="label.polenamemgmt.addPoleNames"/></a>
							</div>
							<table id="poleNamesTable" class="table table-striped table-bordered no-bottom paginate">
							<thead>
								<tr id="column_head">
										<th width="5%"><s:text name="label.polenamemgmt.tableHeader.action" /></th>
										<th width="15%"><s:text name="label.polenamemgmt.tableHeader.status" /></th>
										<th width="80%"><s:text	name="label.polenamemgmt.tableHeader.poleName" /></th>
								</tr>
							</thead>
							<tbody  id="addNewTbodyId">
							</tbody>
							</table>
						</s:if>
						<s:else>
							<table id="poleNamesTable" class="table table-striped table-bordered no-bottom paginate">
							<thead>
								<tr id="column_head">
										<th width="5%"><s:text name="label.polenamemgmt.tableHeader.action" /></th>
										<th width="15%"><s:text name="label.polenamemgmt.tableHeader.status" /></th>
										<th width="80%"><s:text	name="label.polenamemgmt.tableHeader.poleName" /></th>
								</tr>
							</thead>
							<tbody>
				        		<c:forEach var="poleNameList" items="${sessionScope.PoleNameList}" varStatus="poleStat">
									<tr class="shown curRowVal">
										<td><img class="actionImg editPoleName" src="${pageContext.request.contextPath}/img/edit-leg.gif"  alt="${poleStat.index}_${poleNameList.key}">
											<img alt="Loading..." class="editPoleProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
										</td>
										<td class="poleStatus">${poleNameList.value.poleStatus}</td>
										<td class="poleName">${poleNameList.value.poleName}</td>
										<td class="hide poleId"> <s:property value="poleId" /></td>
										<td class="hide poleErrorId"> <s:property value="%{errorPole}"/></td>
									</tr>
								</c:forEach>
								</tbody>
						  </table>
					</s:else>
					<s:hidden id="newPoleIndexId" name="newPoleIndex" value="%{poleNameManagements.size}" />
				</div>
			</div>
				<s:if test="%{poleNameManagements != null || !poleNameManagements.isEmpty}">
					<div class="row">
						<div class="span12">
							<a href="javascript:;" class="left addNewPoleName add"><s:text  name="label.polenamemgmt.additionalPoleNames"/></a>
							<img alt="Loading..." class="addNewPoleProcess indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="margin-top: 0px;">
						</div>
					</div>
				</s:if>
 		</div>	
 		
 		<s:if test="%{(poleNameManagements != null || !poleNameManagements.isEmpty) && poleNameManagements.size > 50}">
		<div class="clear"></div>
		<div style="height:50px;"></div>    
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
	     <div class="clear"></div>
		      <div class="highlighted">
                <a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.common.cancel"></s:text></a> 
            </div>	
	</div>
	<!-- wrapper ends here -->
	<%@include file="../common/footerSection.jsp"%>	
	<jsp:include page="../admin/treasuryAdminExitPopup.jsp" />	
</body>
</html>
	