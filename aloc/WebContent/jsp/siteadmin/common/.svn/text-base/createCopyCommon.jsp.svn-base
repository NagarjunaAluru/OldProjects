<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

  	<p class="required-fields first"><s:text name="label.common.siteAdmin.allFieldsAreRequired" /></p>
  	
    <s:set name="siteIdCreate" value="editMode" />
    <s:hidden name="siteIdCreate" value="%{editMode}" id="editModeCon" />
    <s:hidden name="editMode" value="%{editMode}" id="editModeId" />
    <s:hidden name="parentSiteIdDet" value="%{siteAdmin.parentSite.parentSiteId}" id="parentSiteIdDet" />
    <s:hidden name="ignoreParentSites" value="%{ignoreParentSites}" cssClass="ignoreParentSites"/>
    
    <s:set name="modifySite" value="modifySite"/>
    <s:hidden name="modifySite"  value="%{modifySite}" id="modifySite"/>
    
    <s:set name="copySite" value="copySite"/>
    <s:hidden name="copySite"  value="%{copySite}" id="copySite"/>
            
    <s:if test="hasActionErrors()">
		<div class="row">
			<div class="span12">
				<div class="errorbox">
					<div class="errorHead">
						<p class="erroricon">
							<s:text name="label.eas.common.error" />
						</p>
					</div>
					<div class="errorContent">
						<p>
							<s:actionerror />
						</p>
					</div>
				</div>
			</div>
		</div>
	</s:if>
    
    <s:if test="hasActionMessages()">
      <div id="siteMsg">
      	<div class="sucessMsg">
          	<a href="javascript:;" class="right successclose" style="font-size: 20px; margin-right:5px;">X</a><s:text name="label.treasuryAdminPortal.success" />
          </div>
          <div class="sucessContent"><s:actionmessage/></div>
      </div>
     </s:if>
	
    <c:choose>
       	<c:when test="${modifySite eq true}">
       		<jsp:include page="/jsp/siteadmin/common/modifySiteReadonly.jsp"></jsp:include>
       	</c:when>
       	<c:otherwise>
       		<div class="row">
	            <div class="span12">
		            <div class="form-row">
						<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].siteTypes}" 
							listKey="ID" disabled="%{editMode}"
							listValue="name" 
							id="siteType" 
							name="siteAdmin.siteType.siteTypeId"
							headerKey=""
							headerValue="Select..."
							key="label.common.siteAdmin.siteType"
							theme="aloc"
						/>
						<img alt="Loading..." id="parentSiteProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
		            </div>   
	            </div>   
           	</div>
		</c:otherwise>
	</c:choose>
         
    <jsp:include page="/jsp/siteadmin/common/createSiteDetails.jsp">
		<jsp:param name="includeScripts" value="false" />
    </jsp:include>  	
    
    