<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/others/siteSel.js"></script>
<dl>
	<dt></dt>
	<dd style="width: 500px !important;">
		<s:select id="availableSites" list="availableSitesList"
			listKey="siteId" listValue="siteName" name="rightSelSites"
			multiple="true" cssClass="multi0select" />
	</dd>
</dl>
