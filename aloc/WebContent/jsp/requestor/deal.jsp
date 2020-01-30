<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome</title>
<link href="${pageContext.request.contextPath}/css/jquery/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/common/site.css" rel="stylesheet" />
<s:head/>
</head>
<body>
	<s:form name="dealForm" action="/requestor/saveAsDraft.action" method="post">
	<table width="100%" height="100%">
			<tr valign="top">
				<td width="35%">
				
					<%-- Inner Table for Display --%>
					<table width="192" height="132" align="right" class="tmiwflogin-body">
					
						<tr class="header">
							<td height="23" colspan="2">
								<div align="center" class="tmiwflogin-head">
								<!-- New Deal ID: ${deal.dealSeqId} -->
								</div>
							</td>
						</tr>

						<tr>
							<td width="100" height="20" valign="bottom">
								<s:label  key="label.request.uniqueId"/>
							</td> 
							<td width="117" valign="bottom">
								<s:textfield name="creditRequest.uniqueId" disabled="true" />
							</td>
						</tr>
						
						<tr>
							<td width="100" height="20" valign="bottom">
								<s:label  key="label.request.dealSeqId"/>
							</td> 
							<td width="117" valign="bottom">
							 	<s:textfield name="creditRequest.dealSeqId" disabled="true" />
							</td>
						</tr>

						<tr>
							<td width="100" height="20" valign="bottom">
								<s:label  key="label.request.dealName"/>
							</td> 
							<td width="117" valign="bottom">
							 	<s:textfield name="creditRequest.dealName" />
							</td>
						</tr>

						<tr>
							<td width="100" height="20" valign="bottom">
								<s:label key="label.request.dealRationale" />
							</td>
							<td width="117" valign="bottom">
								 <s:textarea name="creditRequest.dealRationale" cols="40" rows="10" id="dealRationale"></s:textarea>
							</td>
						</tr>
						<tr>
							<td width="100" height="20" valign="bottom">
								<s:label key="label.request.securityCategoryId" />
							</td> 
							<td width="117" valign="bottom">
							 		<%-- <s:checkboxlist name="creditRequest.securityCategoryId" list="%{#attr['com.ge.aloc.StaticData'].securityTypes}" listKey="uId"  listValue="name"/> --%>
							</td>
						</tr>
						
						
						<tr>
							<td width="100" height="20" valign="bottom">
								<s:label key="label.request.impairmentHistory" />
							</td> 
							<td width="117" valign="bottom">
								<s:radio name="creditRequest.impairmentHistoryFlag" list="#{'true':'Yes','false':'No'}"  value="%{creditRequest.impairmentHistoryFlag}" />
							</td>
						</tr>
						
						<tr>
							<td width="100" height="20" valign="bottom">
								<s:label key="label.request.responsibleRegion" />
							</td> 
							<td width="117" valign="bottom">
								<s:select headerKey="-1" headerValue="Select Region" list="%{#attr['com.ge.aloc.StaticData'].regionResponsibility}" name="creditRequest.responsibleRegionId" listKey="uId" listValue="name" />
						</tr>

						<tr>
							<td height="30" colspan="2">
								<div align="center">
									<s:submit key="label.request.saveAsDraft" value="saveAsDraft"/>
								</div>
							</td>
						</tr>

						<tr>
							<td colspan="2" class="tmiwflogin-error"></td>
						</tr>
					</table>
					
					</td>
				<td width="6%">&nbsp;</td>
				<td width="68%"><br></td>
			</tr>
		</table>
	</s:form>

</body>
</html>
