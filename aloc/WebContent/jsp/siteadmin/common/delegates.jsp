<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

<div id="delegatesSection">
	<s:form id="createDelegateConfigForm">
            	<c:if test="${param.includeScripts != false}">
                 
                 	  <%@include file="../../common/siteIncludeScripts.jsp" %>
			    	  <script type="text/javascript" src="${pageContext.request.contextPath}/js/siteAdmin/businessSiteAdmin.js"></script>
                </c:if>
                 
            <div class="row delegatesShow">
            	<div class="span12">
                     <s:select
      				 name="delegates"
      				 headerKey="" headerValue="Select..."
   					 list="SiteAdmin.delegationConfiguration.approvalGroupConfiguration.groups"
      		 		 listKey="groupId"
       				 listValue="groupName"
      				 required="true"
      				 value="%{SiteAdmin.delegationConfiguration.approvalGroupConfiguration.groups.{groupName}}"
      				 id="approverGroups"
      				 key="label.siteAdmin.approverGroups"
      				 tooltip="%{getText('label.businessAdmin.tooltip.approverGroups')}"
      				 theme="aloc"
					/> 
					 <img alt="Loading..." id="groupProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
                </div>
            </div>
            <span class="bussApproverSave-error hide" style="color: #AE2C2C;"></span>
            <span class="bussApproverAdd-error hide" style="color: #AE2C2C;"></span>
			<span class="bussApproverRemove-error hide" style="color: #AE2C2C;"></span>

            
		<div class="row hide" id="approversDivId">
            <div class="span12">
			<div class="row curDelErrorDiv hide">
				<div class="span12">
					<div class="errorbox">
						<div class="errorHead">
							<p class="erroricon">
								<s:text name="label.eas.common.error" />
							</p>
						</div>
						<div class="errorContent">
							<p>
								<span class="curDelError"></span>
							</p>
						</div>
					</div>
				</div>
			</div>

			<jsp:include page="/jsp/siteadmin/common/currentDelegates.jsp">
				<jsp:param value="true" name="busAdmin"/>
			</jsp:include>
               <hwfs:isUserInRole role="SiteAdmin">
				   <a href="javascript:;" class="left btn-primary saveDelApprovers"><s:text  name="label.common.siteAdmin.save"/></a>
		           <a href="#" class="btn-tertiary cancel clearEntries" ><s:text name="label.request.common.cancel"></s:text></a>
	           </hwfs:isUserInRole>
               <img alt="Loading..." id="saveProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
    		<div class="savedel"></div>
            </div>
         </div>
         </s:form>
	</div>
