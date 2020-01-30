<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<td height="1" class="noPadding"><s:textfield name="goldId"
		cssClass="span3 lookup-filterValue" id="leGoldId" theme="aloc" /> <s:url
		action="LegalEntityLookup" namespace="/int" var="getLegalEntityURL"
		escapeAmp="false" encode="true">
		<s:param name="pageNumber">1</s:param>
		<s:param name="escoListIndex">
			<s:property value="%{#parameters['goldIdVal']}" />
		</s:param>
	</s:url> <a class="btn-secondary lookup" href='<s:property value="#getLegalEntityURL"/>'>
		<s:text name="label.request.common.lookup" />
</a> <img alt="Loading..." id="leIndicator" class="indicator"
	src="${pageContext.request.contextPath}/img/loading.gif"
	style="height: 20px; display: none" />
	<div class="clear"></div>
	<div class="conditional-row" id='goldidShow<s:property value="%{#parameters['goldIdVal']}"/>'
		style="display: none;">
		<div class="span7">
			<div class="row" style="margin-left: 0px;">
			<div class="span2 left">
				<div class="form-row">
					<s:label key="label.request.common.legalEntityNameC" />
				</div>
			</div>
			<!-- end of block -->
			<div class="span10 right">
				<div class="form-row">
					<p>
						<s:property value="" />
					</p>
					<s:hidden name="leName" id="tpApplicantLEName%{#parameters['goldIdVal']}"
						cssClass="LEName" />
				</div>
			</div>
		</div>
			<div class="row" style="margin-left: 0px;">
			<div class="span2 left">
				<div class="form-row">
					<s:label key="label.request.common.legalEntityGOLDIdC" />
				</div>
			</div>
			<div class="span10 right">
				<div class="form-row">
					<p>
						<s:property value="goldId" />
					</p>
					<s:hidden name="reportsDetails.eCSODetails[0].iNGOLDIDS"
						id="tpApplicantLEGoldID%{#parameters['goldIdVal']}"
						cssClass="LEGoldID" />
				</div>
				<!-- end of block -->
			</div>
			
		</div>
		
		</div>
		
	</div></td>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/reports/addLegalEntity.js"></script>