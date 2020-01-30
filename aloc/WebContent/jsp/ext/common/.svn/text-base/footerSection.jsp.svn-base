<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="footer">
	<div id="footer-menu">
		<div class="left-col-fm">
			<s:text name="label.header.geConfidential" />
		</div>
		<s:url action="contactUs.action" namespace="/ext" encode="true" var="contactUsURL"/>
		<s:url action="help.action" namespace="/ext" encode="true" var="helpURL"/>
		<div class="right-col-fm">
			<a href="<s:property value="#helpURL"/>"><s:text name="label.header.help" /></a> <b>|</b> 
			<a href='<s:property value="#contactUsURL"/>'><s:text name="label.header.contactUs" /></a>
		</div>
	</div>
	<div id="footer-credits">
		<div class="left-col-fc"></div>
		<div class="clear"></div>
	</div>
</div>