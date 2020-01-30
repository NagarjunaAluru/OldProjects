<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	   	 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="/jsp/common/includeCommonScripts.jsp" %>
		<title><s:text name="label.swiftMessageMonitoring.pagaeTitle"/></title>
		<script src="${pageContext.request.contextPath}/js/others/swiftMessageMonitoring.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	</head>
	<s:url action="treasuryAdminPortal.action" namespace="/int/admin" var="cancelBtnlURL"/>
	<body>
	<div class="container main">
		
		<jsp:include page="/jsp/common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		
		<div class="row ErrorDiv hide">
			<div class="span12">
				<div class="errorbox">
					<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
						<div class="errorContent">
						<p><span class="delError"></span></p>
						</div>
				</div>
			</div>
		</div>
						
		<div id="swiftMainContent" class="form-mod">
		<h1 class="page-title span12"><s:text name="label.swiftMessageMonitoring.pagaeTitle"/></h1>
		<p class="span12 left clear dashdesc"></p>
		<hr class="page-title-hr">
		<jsp:include page="swiftBasicSearch.jsp" />
		
		<div class="row" id="hideLessthan10">
			<div class="span3">
			<p id="itemsPerPage"> <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items</p>
			</div>
			<div class="span2 right">
			Show&nbsp;&nbsp;
			<select style="width:60px!important;" class="pagination-rows">
				<option>10</option>
				<option>20</option>
				<option>30</option>
				<option>40</option>
				<option>50</option>
			</select>&nbsp;&nbsp;results
			</div>
		</div>
		
		<table class="table table-striped table-bordered sortable paginate" id="swiftconetent">
		<colgroup width="30"></colgroup>
		<thead>
            <tr id="column_head">
                <th colspan="1"><s:text name="label.swiftMessageMonitoring.actions"/></th>
                <th colspan="1"><s:text name="label.swiftMessageMonitoring.alocRecordNumber"/></th>
                <th colspan="1"><s:text name="label.swiftMessageMonitoring.subMessageType"/></th>
                <th colspan="1"><s:text name="label.suretynamemgmt.tableHeader.status"/></th> 
                <th colspan="1"><s:text name="label.swiftMessageMonitoring.dateAndTime"/></th>
                <th colspan="1"><s:text name="label.swiftMessageMonitoring.direction"/></th>
                <th colspan="1"><s:text name="label.swiftMessageMonitoring.messageSequenceGroup"/></th>
                <th colspan="1"><s:text name="label.swiftMessageMonitoring.instrument"/></th>
            </tr>
        </thead>
        <tbody>
          <s:if test="%{swiftDashBoard.swiftMonitorings.isEmpty()}">
          	<tr class="shown">
               <td colspan="8" style="text-align:center;color:blue; size:40px;">
        			<s:text name="label.standardFormatMgmt.display"/>
     		   </td>
          	</tr>
          </s:if>
          <s:else>
        	<s:iterator value="swiftDashBoard.swiftMonitorings">
	            <tr class="shown">
	                <td class="span2">
	                <c:choose>
	                	<c:when test="${status eq 'NACK'}">
	                		<a href="#" class="btn-secondary lookup conditional-btn" id="resend"><s:text name="label.swiftMessageMonitoring.reSend"/></a>
	                		<img alt="Loading..." class="swiftResendProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
	                	</c:when>
	                	<c:otherwise>
	                		-
	                	</c:otherwise>
	                </c:choose>	
	                </td>
	                <td>
	                <s:url action="openRequest.action" var="openRequestURL" namespace="/int" escapeAmp="false" encode="true">
	             		<s:param name="requestId"><s:property value="ALOCRecordNo"/></s:param>
	               		<s:param name="dashboardViewType"><s:text name="label.request.param.allRequests" /></s:param>
	               		<s:param name="stage"></s:param>
	               		<s:param name="stageName"></s:param>
               		</s:url>
               		<s:hidden name="requestId" value="%{ALOCRecordNo}" cssClass="requestId"/>
               		<s:hidden name="amendmentId" value="%{amendmentId}" cssClass="amendmentId"/>
               		<s:if test="%{amendmentId != null}">
               			<a href='<s:property value='#openRequestURL'/>'><s:property value="amendmentId"/></a>
               		</s:if>
               		<s:else>
               			<a href='<s:property value='#openRequestURL'/>'><s:property value="ALOCRecordId"/></a>
               		</s:else>
	                </td>
	                <td><s:property value="subMessageType"/></td>
	                <td><span class="red"><s:property value="status"/></span></td>
	                <td><s:property value="dateTime"/></td>			
	                <td><s:property value="direction"/></td>
	                <td><s:property value="messageSequenceGroup"/></td>
	                <td><s:iterator value="instruments"><s:property /><br/></s:iterator></td>
	            </tr>
           </s:iterator>
           </s:else>
        </tbody>
        </table>
		<div class="clear"></div>
			<div style="height:50px;"></div>    
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
		      
		</div>
		<div class="clear"></div>
		 <div class="highlighted">
               <a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.common.cancel"></s:text></a> 
         </div>
	</div>
	
	<%@include  file="/jsp/common/footerSection.jsp" %>
	<jsp:include page="../admin/treasuryAdminExitPopup.jsp" />	
	</body>
</html>