<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="userInfo"  uri="hwf-userInformation" %>
<div class="row">
		<div class="span12">
			<nav>
				<ul>
					<li id="li77" class="navLi"><a class="navLink" href="#tab2" id="nave-save-template"><s:text name="label.report.saveTemplate"/></a></li>
					<li class="last"><a class="nav-hide btn-tertiary" href="#tab5"><s:text name="label.request.common.cancel" /></a></li>
					
				</ul>
			</nav>
				<div class="tab" id="tab2" style="padding:10px; background:#fff; border:Solid 3px #ccd7e5;">
					<div class="row">
						<div class="span11" id="reportId">
							<c:if test="${empty template}">
							<table>
								<tr>
								<td width="70%">
									<label><s:text name="label.report.reportTemplate"/></label>
									<c:set var="userName" value="${fn:split(userInfo:fullName('.','-'), '.')}" />
									<jsp:useBean id="date" class="java.util.Date"/>
									<s:set var="templateName"><fmt:formatDate pattern="yyyy-MM-dd" value="${date}" />.${userName[1]}.${userName[0]}</s:set>
									<s:textfield name="template.templateName" id="reportName" readonly="true" value="%{#templateName}"/>
								</td>
								<td>
									<span class="optOutval-error hide"><s:text name="label.report.reportNameMandatory"/></span>
								</td>
							</table>
							</c:if>
							<c:if test="${not empty template }">
								<table>
								<tr>
								<td width="70%">
									<label><s:text name="label.report.reportTemplate"/></label>
									<s:textfield name="template.templateName" id="reportName" value="%{template.templateName}" readonly="true" />
								</td>
							</table>
							</c:if>
						</div>
					</div>
					<div class="row">
						<div class="span11" id="descriptionId">
						<table>
							<tr>
							<td>
							<label><s:text name="label.report.description"/></label>
							<s:textarea name="template.description" onkeypress="return imposeMaxLength(this, 199);" theme="aloc" cssClass="autosize2 messageinput" id="templateDesc"/>
						 	<div class="clear"></div>
	                     	<div class="counter">200</div> <!-- fix positions -->
	                     	<div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize" /></p></div>
	                     	</td>
	                     	<td>
	                     	<span class="optOutval-error hide"><s:text name="label.report.descMandatory"/></span>
	                     	</td>
	                     </table>
						</div>
					</div>
					<div class="row">
						<div class="span4">
							<label><s:text name="label.report.publishingPermissions"/></label>
							<p><s:text name="label.report.publishingPermissionsSub"/></p>
							<s:checkbox name="template.bank"  cssClass="case1" id="BankPP"/><s:text name="label.report.bank"/><br/>
							<s:checkbox name="template.bussiness"  cssClass="case1" id="BusPP"/><s:text name="label.report.business"/><br/>
							<s:checkbox name="template.treasury" cssClass="case1" id="TresPP"/><s:text name="label.report.treasury"/>
						</div>
					</div>
			<div class="row hide" id="PublishBank">
				<div class="span2ab">
					<div class="form-row" style="width: 200px !important" id="bankSelection">
						<jsp:include page="/jsp/ext/reports/adhoc/adhocBankSelection.jsp" />
					</div>
				</div>
			</div>
			<div class="row hide" id="PublishBusiness">
				<div class="span2ab">
					<div class="form-row" style="width: 200px !important" id="siteSelection">
						<jsp:include page="/jsp/ext/reports/adhoc/adhocSiteSelection.jsp" />
					</div>
				</div>
			</div>
			<c:if test="${empty param.ownReport}">
			<div>&nbsp;</div>
			<div class="row highlighted">
				<div class="span12">
					<div class="form-row">
						<a class="btn-primary nav-template" href="javascript:;" ><s:text name="label.report.save"/></a>
						<a class="nav-hide btn-tertiary" href="#tab5"><s:text name="label.request.common.cancel" /></a>
						<img alt="Loading..." class="indicator" 
							src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; margin-top: -19px; display:none"/>
					</div>
				</div>
			</div>
			</c:if>
		</div>
	</div>
</div>
