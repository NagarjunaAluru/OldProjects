<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<link type="text/css" href="${pageContext.request.contextPath}/css/others/jquery-ui-1.7.1.custom.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/css/others/ui.multiselect.css" rel="stylesheet" />
<c:if test="${param.busAdmin == true}">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-ui-1.8.custom.min.js"></script>
</c:if>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.tmpl.1.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.blockUI.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/ui.multiselect.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/siteAdmin/curDel.js"></script> 

      <div id="SelectedApp">
      
            <s:if test="(availbleApprovers !=null)">
            <dl>
				<dt></dt>
				<dd>
					<s:select id="availableApp"
						list="availbleApprovers"
						listKey="userSso" listValue="lastName"
						name="oldSelApprovers"
						multiple="true" cssClass="multi0select" />
				</dd>
			</dl>
           </s:if>
		</div> <br/>
			