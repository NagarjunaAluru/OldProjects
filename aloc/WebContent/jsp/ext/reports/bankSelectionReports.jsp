<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<dl>
	<dt></dt>
	<dd style="width: 500px !important;">
		<s:select id="availableBanks" list="bankDetailsList" listKey="siteId"
			listValue="bankCode" name="rightSelBanks" multiple="true"
			cssClass="multi0select" />
	</dd>
</dl>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/ext/public/js/others/bankSel.js"></script>
