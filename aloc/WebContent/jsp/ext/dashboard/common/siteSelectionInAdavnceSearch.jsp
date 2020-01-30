<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<link type="text/css" href="${pageContext.request.contextPath}/ext/public/css/others/jquery-ui-1.7.1.custom.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/ext/public/css/others/ui.multiselect.css" rel="stylesheet" />
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/plugins/jquery-ui-1.8.custom.min.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/plugins/jquery.tmpl.1.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/plugins/jquery.blockUI.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/plugins/ui.multiselect.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/others/siteSel.js"></script>

		<dl>
				<dt></dt>
				<dd>
					<s:select id="availableSites"
						list="childSitesList"
						listKey="ID" listValue="name"
						name="selSites"
						multiple="true" cssClass="multi0select" />
				</dd>
			</dl>
			
		