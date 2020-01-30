<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

<s:form id="unBlockBUCForm" action="unBlockBUC" namespace="/int/admin">
        <p><s:text name="label.blockbucmgmt.unblock.bucadn"/></p>
		<p><b><s:text name="label.blockbucmgmt.buc"/></b> : <s:property value="unBlockbucVal"/></p>
		<s:hidden id="bucValId" name="businessUnitCode.BUC" value="%{unBlockbucVal}" />
		<p><b><s:text name="label.blockbucmgmt.adn"/></b> : <s:property value="unBlockadnVal"/></p>
		<s:hidden id="adnValId" name="businessUnitCode.ADN" value="%{unBlockadnVal}" />
</s:form>