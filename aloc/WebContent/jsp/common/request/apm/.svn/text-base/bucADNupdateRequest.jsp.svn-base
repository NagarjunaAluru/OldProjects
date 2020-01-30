<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
	<%@include file="../../../common/includeCommonScripts.jsp" %>
	<title><s:text name="label.request.bucAdnUpdate"/></title>
	<script src="${pageContext.request.contextPath}/js/requestor/apm.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div class="container main">
		<jsp:include page="../../../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage">
		<h1 class="page-title span12">
		<s:text name="label.request.bucAdnUpdate"></s:text></h1>
		<p class="span12 left clear dashdesc"><s:text name="label.request.bucAdnUpdateDesc" /> 
		</p>
		<hr class="page-title-hr">
	<s:url action="getFeePaymentRunCalculateFees.action" namespace="/int/apm" var="paymentRunAdminURL" />	
    <div class="row">
		<div class="span12">
			<a href="<s:property value="#paymentRunAdminURL" />" class="btn-tertiary cancel"><s:text name="label.request.apm.bucadn.paymentRun" /></a>
		</div>
	</div>  
	<s:form id="bucadnUpdatesFormId" namespace="/int/apm" action="updateBUCADNDetails" >	 
	<span class="bucadnupdate-error hide" style="color: red;"></span>	
     <div id="bucadnUpdatesDiv">
     <div class="row">
		 <div class="span12">
				<s:label key="label.request.tableHeader.buc" theme="aloc"/>
				<s:textfield name="updatedBUCVal" id="updatedBUCId" maxlength="6" />
				<div style="color: red;" id="bucUpdateValidate">
					<s:fielderror fieldName="updatedBUCVal"></s:fielderror>
                </div>
		 </div>
	</div>
	<div class="row">     
	     <div class="span12">
				<s:label key="label.request.tableHeader.adn" theme="aloc"/>
				<s:textfield name="updatedADNVal" id="updatedADNId" maxlength="23" />
				<img src="${pageContext.request.contextPath}/img/loading.gif" style="padding:10px 0 0 10px; height: 20px; display:none;" 
						id="bucadnLoading"/>
				<img src="${pageContext.request.contextPath}/img/yes.png" title="Model Enabled" id="matched"
						style="vertical-align: middle; margin-left: 10px;display:none;" /> 
				<img src="${pageContext.request.contextPath}/img/no.png" title="Model Disabled" id="unMatched"
					    style="vertical-align: middle; margin-left: 10px;display:none;" />
			    <div style="color: red;" id="adnUpdateValidate">
					<s:fielderror fieldName="updatedADNVal"></s:fielderror>
                </div> 
		 </div>
	</div>
	
	 <div class="row"></div>
			 <div style="color: red;" id="bucadnUpdateValidate">
				<s:fielderror fieldName="bucAdnList"></s:fielderror>
             </div>
	  
	 <table class="table table-striped table-bordered paginate" id="bucadnUpdates">
		<colgroup width="20"></colgroup>
        <colgroup width="80"></colgroup>
        <colgroup width="80"></colgroup>
        <colgroup width="80"></colgroup>
        <colgroup width="120"></colgroup>
        <colgroup width="120"></colgroup>
        <colgroup width="120"></colgroup>
		<thead>
            <tr id="column_head">
                <th><s:checkbox name="checkName" id="checkallBucAdnUpdate"/></th>
                <th><s:text name="label.request.alocRecNo"/></th>
                <th><s:text name="label.request.tableHeader.buc"/></th>
                <th><s:text name="label.request.tableHeader.adn"/></th> 
                <th><s:text name="label.request.tableHeader.ibsNotification"/></th>
                <th><s:text name="label.request.tableHeader.chargeCode"/></th>    
                <th><s:text name="label.request.tableHeader.geRequestorName"/></th>
            </tr>
        </thead>
        <tbody>
        <s:if test="%{bucAdnList != null && bucAdnList.size > 0}">
        	<s:iterator value="bucAdnList" status="bucAdnItrStatus">
            <tr class="shown">
                <td><s:checkbox name="bucAdnList[%{#bucAdnItrStatus.index}].updateFlag" cssClass="checkBucAdnUpdate" theme="aloc"/></td>
                <td><s:if test="%{requestId==null}">-</s:if><s:else><s:property value="requestId"/><s:property value="sitePrefix"/></s:else></td>
                <td><s:if test="%{BUC==null}">-</s:if><s:else><s:property value="BUC"/></s:else></td>
                <td><s:if test="%{ADN==null}">-</s:if><s:else><s:property value="ADN"/></s:else></td>
                <td><s:if test="%{IBSErrorNotification==null}">-</s:if><s:else><s:property value="IBSErrorNotification"/></s:else></td>
                <td><s:if test="%{chargeCodeContact==null}">-</s:if><s:else><s:property value="chargeCodeContact"/></s:else></td>
                <td><s:if test="%{GERequestor.userDetails.lastName==null && GERequestor.userDetails.firstName==null}">-</s:if><s:else>
                <s:property value="GERequestor.userDetails.lastName"/>,<s:property value="GERequestor.userDetails.firstName"/></s:else></td>
                <td class="hide"><s:textfield name="bucAdnList[%{#bucAdnItrStatus.index}].requestId"/></td>
                <td class="hide"><s:textfield name="bucAdnList[%{#bucAdnItrStatus.index}].BUC"/></td>
                <td class="hide"><s:textfield name="bucAdnList[%{#bucAdnItrStatus.index}].ADN"/></td>
           </tr>
        </s:iterator>
            </s:if>
			<s:else>
				<tr class="shown">
       	 			<td colspan="7" style="text-align:center;color:blue; size:40px;"><s:text name="label.dashboard.bundle.display"/></td>
    			</tr>
	    	</s:else>
        </tbody>
    </table>
    </div>  
     
     <div class="clear"></div>
	 <div style="height:50px;"></div>   
     <s:if test="%{bucAdnList != null && bucAdnList.size > 50}">
	    
	    <div class="row">
	    	<div class="span4">
				<s:submit key="label.request.apm.bucadn.save" cssClass="left btn-primary"/>
				<s:a href="%{paymentRunAdminURL}" cssClass="btn-tertiary cancel" ><s:text name="label.request.common.cancel"/></s:a>
			</div>
	        <div class="span8 right">
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
       <s:else>
        <s:if test="%{bucAdnList != null && bucAdnList.size > 0}">
	       	 <div class="form-mod" id="submitDiv">
			<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:submit key="label.request.apm.bucadn.save" cssClass="left btn-primary"/>
					<s:a href="%{paymentRunAdminURL}" cssClass="btn-tertiary cancel" >
						<s:text name="label.request.common.cancel"/>
				    </s:a>
				</div>
			</div>
		   </div>
	      </div>	
      </s:if>
       </s:else>
        	
      <div class="row">
		<div class="span12">
			<a href="<s:property value="#paymentRunAdminURL" />" class="btn-tertiary cancel"><s:text name="label.request.apm.bucadn.paymentRun" /></a>
		</div>
	  </div>  
	</s:form> 
	</div>
 </div>
	<%@include file="../../../common/footerSection.jsp"%>
</body>
</html>