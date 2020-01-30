<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<br/> 
		   	
            <div class="row">	
				<div class="span14 left"><s:label  key="label.siteAdmin.siteIdC"/></div>
                <div class="span15 right"><s:property value="siteAdmin.siteId"/></div>
            </div>
            <div class="row">	
				<div class="span14 left"><s:label  key="label.siteAdmin.descriptionC"/></div>
                <div class="span15 right"><s:property value="siteAdmin.description"/></div>
            </div>  
            
            <div class="row">	
				<div class="span14 left"><s:label  key="label.siteAdmin.sitePrefixC"/></div>
                <div class="span15 right"><s:property value="siteAdmin.sitePrefix"/></div>
            </div>

            <div class="row">	
				<div class="span14 left"><s:label  key="label.siteAdmin.siteTypeC"/></div>
                <div class="span15 right"><s:property value="siteAdmin.siteType.siteTypeName"/></div>
            </div>

            <div class="row">	
				<div class="span14 left"><s:label  key="label.siteAdmin.parentSiteC"/></div>
                <div class="span15 right"><c:if test="${siteAdmin.parentSite.parentSiteName eq null}"> - </c:if>
                <s:property value="siteAdmin.parentSite.parentSiteName"/></div>
            </div>

            <div class="row">	
				<div class="span15 left"><s:label  key="label.common.siteAdmin.parentDescriptionC"/></div>
                <div class="span15 right"><c:if test="${siteAdmin.parentDescription eq null}"> - </c:if>
                <s:property value="siteAdmin.parentDescription"/></div>
            </div>

            <div class="row">	
				<div class="span14 left"><s:label  key="label.common.siteAdmin.parentPrefixC"/></div>
                <div class="span15 right"><c:if test="${siteAdmin.parentPrefix eq null}"> - </c:if>
                <s:property value="siteAdmin.parentPrefix"/></div>
            </div>                                                                      
            
			<s:if test="(siteAdmin.headerSiteOnly != null && siteAdmin.headerSiteOnly != true)">
            </s:if>
            <s:else>
	            <div class="row"><br/>	
					<s:url action="cancel.action" namespace="/int/siteadmin" var="cancelBtnURL"/>          
           			<div class="span14 left"><a href="<s:property value="#cancelBtnURL" />" class="btn-tertiary cancel" ><s:text name="label.request.common.cancel"></s:text></a></div>
	            </div>
            </s:else>
            