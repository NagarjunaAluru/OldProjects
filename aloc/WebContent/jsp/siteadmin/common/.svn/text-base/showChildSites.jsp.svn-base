<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

 <link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/css/common/site.css" type="text/css" rel="stylesheet" />
  
  <div id="childSitesDivs">
  				<c:if test="${empty siteAdmin.parentPrefix}">
			         <c:set var="modifyParent" value="hide"/>
		    	</c:if>
				<c:if test="${not empty siteAdmin.parentPrefix}">
					<c:set var="modifyParent" value=""/>
				</c:if>
				     
                <div class="row ${modifyParent}" id="pDescContentCreate" style="display:none;">
                    <div class="span12">
                        <div class="span1b">
                            <label><s:label key="label.common.siteAdmin.parentDescriptionC" /></label>  
                        </div>
                        <div class="span5" id="parentDesc">
                            <p class="padding40"><s:property value="parentDescription"/></p>
                            
                        </div>
                    </div>
                    <div class="span12">
                        <div class="span1b">
                            <label><s:label key="label.common.siteAdmin.parentPrefixC" /></label>
                        </div>
                        <div class="span5" id="parentPrefixDiv">
                            <p class="padding40"><s:property value="parentPrefix"/></p>
                            
                        </div>
                    </div>
                    <s:hidden name="siteAdmin.parentPrefix" value="%{parentPrefix}" id="parentPrefix"/>
                    <s:hidden name="siteAdmin.parentDescription" value="%{parentDescription}" id="parentDescription"/>
                    <s:hidden name="siteAdmin.parentSite.parentSiteName" id="parentSiteName"/>
                </div>
                
                <div class="row" id="childSites"  style="display:none;">
                <div class="span12">
						<div class="row">
							<div class="span8 left">
			                 	 <h2 class="page-title"><s:text name="label.siteAdmin.parentChildStructure" /> <a href="javascript:;" class="excel-ico"></a> <a href="javascript:;" class="print-ico"></a></h2><hr class="h2-hr">
			                 
				                 <table id="childTableId" class="table table-striped table-bordered">
				                 	<thead>
							          <tr>
							            <th><s:text name="label.siteAdmin.siteCode" /></th>
							            <th><s:text name="label.siteAdmin.siteNameC" /></th>
							            <th><s:text name="label.siteAdmin.designation" /></th>
							          </tr>
							        </thead>
							        <tbody>
									</tbody>
				                 </table>
	                		 </div>
	                	 </div>
	                 </div>
                 </div>
</div>