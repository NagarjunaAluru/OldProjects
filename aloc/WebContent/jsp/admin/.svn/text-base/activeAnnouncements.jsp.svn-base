<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.userannouncementmgmt.pageTitle" /></title>
<link href="${pageContext.request.contextPath}/css/others/toggle.css" rel="stylesheet">
<%@include file="../common/includeCommonScripts.jsp" %> 
<link href="${pageContext.request.contextPath}/css/common/user-announcement-mgmt.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/admin/treasuryAdminManagement.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
</head>
<s:url action="treasuryAdminPortal.action" namespace="/int/admin" var="cancelBtnlURL"/>
<body>
<div class="container main">
	<jsp:include page="../common/headerSection.jsp">
		<jsp:param name="createReqPopup" value="Yes"></jsp:param>
	</jsp:include>
	<h1 class="page-title span12"><s:text name="label.activeAnnouncements.activeAnnouncements"/></h1>
	<hr class="page-title-hr">
	<div class="form-mod">
		<div class="clear"></div>
		<table class="table table-striped table-bordered sortable no-bottom paginate" id="tableAnnouncements">
        	<colgroup width="40"></colgroup>
            <colgroup width="40"></colgroup>
            <colgroup width="350"></colgroup>
            <colgroup width="50"></colgroup>
            <colgroup width="100"></colgroup>
            <colgroup width="120"></colgroup>
            <colgroup width="100"></colgroup>
            <colgroup width="100"></colgroup>
	        <thead>
	        	<tr>
		        	<th colspan="2" class="header"><s:text name="label.swiftMessageMonitoring.actions"/></th>
		            <th colspan="1" class="header"><s:text name="label.userannouncementmgmt.messageContent"/></th>
		            <th class="header"><s:text name="label.activeAnnouncements.attachments"/></th>
					<th class="header"><s:text name="label.request.siteSelection" /></th>
		            <th class="header"><s:text name="label.userannouncementmgmt.roleSelection"/></th>
		            <th class="header"><s:text name="label.userannouncementmgmt.startDate"/></th>
					<th class="header"><s:text name="label.userannouncementmgmt.endDate"/></th> 
			    </tr>
			</thead>
	        <tbody>	       
	        <s:iterator value="activeUserAnnouncement.activeAnnouncement.activeAnnoucements" status="activeAtmtsStatus">
		    	<tr>
			    	<td>
			    		<p>
				    		<a href='javascript:void(0)' onclick="javascript:deleteUserannouncement(<s:property value="userAnnouncementId"/>)" class="deleteuser"><img src='${pageContext.request.contextPath}/img/delete.gif'></a>					
						</p>																 	
			    	</td>
					<td>
						<s:url action="loadUserAnnouncement.action" var="openUserAnnouncementURL" namespace="/int/admin" escapeAmp="false" encode="true">
							<s:param name="userAnnouncementId" value="userAnnouncementId"></s:param>
						</s:url>
						<p><a href="<s:property value='#openUserAnnouncementURL'/>" class="edit-leg"><img src='${pageContext.request.contextPath}/img/edit-leg.gif'></a></p>
					</td>
					<td style="word-wrap: break-word;"><div style="width: 155px; overflow: auto;"><s:property value="messageContent" escape="false"/></div></td>
					<td><p>
					<s:if test="%{attachments != null && attachments.size> 0}">
					 <s:iterator value="attachments" status="atmtsStatus">																				
							<p>																								
								<s:if test="%{geFileId !=0}">																																	
									<s:url id="fileDownload" action="downloadAttachment.action" namespace="/int/admin">
										<s:param name="geLibFileId"><s:property value="geFileId"/></s:param>
										<s:param name="activeAnnouncementIndex"><s:property value="#activeAtmtsStatus.index"/></s:param>
					   					<s:param name="announcementType">activeAnnouncements</s:param>														
									</s:url>																									
										<s:a href="%{fileDownload}"><s:property value="attachmentOriginalName" /></s:a>		
								</s:if>																																		
							</p>							
						</s:iterator>	
					</s:if>				
					</p></td>
					<td><s:iterator value="actSiteSelections"><s:property value="siteTypeName"/><br/></s:iterator></td>
					<td><s:iterator value="actRoleSelections"><s:property value="roleName"/><br/></s:iterator></td>					
					<td><p><s:date name="startDate" format="MMM dd, yyyy"/></p></td>
					<td><p><s:date name="endDate" format="MMM dd, yyyy"/></p></td>
				</tr> 
				</s:iterator>		
			</tbody>
		</table>
		<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
		
	</div>
	
	<div class="row" id="hideLessthan10">
		<div class="span right">
			<div class="pagenavi left">	
		    </div>
			<div class="span3 jump-page">
					 Jump to
					<input type="text" class="span1 manual">
					<a class="btn btn-success-blue" type="submit">Go</a>
			</div>
		</div>
  	</div>
		  <input type='hidden' id='current_page' />
		  <script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
		  
	<div class="row">
        <div class="span12 btn-container">
            <div class="form-row">
                <a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.common.cancel"></s:text></a> 
            </div>
        </div>
    </div>
    
</div>
<%@include file="../common/footerSection.jsp"%>
<jsp:include page="../admin/treasuryAdminExitPopup.jsp" />
</body>
<div class="modal hide fade" id="deleteRequestModal">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.userannouncementmgmt.deleteUserannouncement" /><span></span></h3>
		</div>
		<div class="modal-body">		
		<s:form id="deleteUserAnnouncementForm" action="deleteAnnouncement" namespace="/int/admin" >
			<s:hidden name="userAnnouncementId" id="activeUserAnnouncementId"/> 				 
			<p><s:text name="label.userannouncementmgmt.deleteUserannouncementAlert" /> </p>
          	<p><s:text name="label.userannouncementmgmt.userAnnouncementId" />&nbsp; <span id="deleteUserAnnouncementId"></span></p>
          	<h3><s:text name="label.userannouncementmgmt.actionUndone" /></h3>		           
		</s:form>
		</div>
		<div class="modal-footer">
			<sj:submit formIds="deleteUserAnnouncementForm" value="Delete" cssClass="left btn-primary" />			
			<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.dashboard.bundle.cancel"/></a>
		</div>
	</div>
</html>