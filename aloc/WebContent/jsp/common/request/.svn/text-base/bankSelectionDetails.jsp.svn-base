<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="bankSelectionDiv">

	<c:if test="${param.includeScripts != false}">
		<%@include file="../../common/includeCommonScripts.jsp" %>
		<script src="${pageContext.request.contextPath}/js/requestor/bidMemo.js" type="text/javascript"></script>
	</c:if>

	<!-- Bank Selection Details -->
	<div class="form-mod">
		<h2 id="bankSelection" class="section_flip" style="display:none;">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.12"/></a>
		</h2><hr class="h2-hr">
		<div id="bankSelectionPanel" class="section_panel">
			<jsp:include page="/jsp/requestor/treasury/bgAndLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.bankSelection" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
				  
			<div class="clear"></div>
				  
			<div class="row">
				<s:if test="%{!(requestDetails.pendingBundleRequestCount == 0 || requestDetails.pendingBundleRequestCount == 1)}">
					<div class="span12">
						<div class="row">
							<div class="span5 wbg">
								<p><s:text name="label.request.dLocBidmemoFinalbidDesc" /></p>
							</div>
						</div>
					</div>
				</s:if>
			<div class="clear">&nbsp;</div>
			
			<div class="row highlighted">
				<div class="span12">
				<c:set var="stageName" value="${requestDetails.WFDetails.WFStage}"></c:set>
					 <c:if test="${param.suretBond != true }">
						 <s:if test="%{requestDetails.pendingBundleRequestCount == 0}">
							 <c:choose>
							 	<c:when test="${stageName == 'EVLREPLY'}" >
							 		<s:submit key="label.request.submitBidMemo" cssClass="btn-primary" action="bankSelectionSave" onclick="javascript:saveBankSelection(33);">
								    </s:submit>
							 	</c:when>
							 	<c:otherwise>
							 		<s:submit key="label.request.submitBidMemo" cssClass="btn-primary" action="bankSelectionSave" onclick="javascript:saveBankSelection(2);">
								    </s:submit>
							 	</c:otherwise>
							 </c:choose>
						 </s:if>
						 <s:else>
						 	<s:submit key="label.request.saveAndGotoNextOrSubmit" cssClass="btn-primary" 
						 	action="bankSelectionSave" onclick="javascript:saveBankSelection(12);" cssStyle="margin-left: 10px !important;">
						 	</s:submit>
						 </s:else>
					 </c:if>
					 <c:if test="${param.suretBond == true }">
					 	<c:choose>
							 	<c:when test="${stageName == 'EVLREPLY'}" >
							 		<s:submit key="label.request.submitBidMemo" cssClass="btn-primary" action="bankSelectionSave" onclick="javascript:saveBankSelection(33);">
								    </s:submit>
							 	</c:when>
							 	<c:otherwise>
							 		<s:submit key="label.request.submitBidMemo" cssClass="btn-primary" action="bankSelectionSave" onclick="javascript:saveBankSelection(2);">
								    </s:submit>
							 	</c:otherwise>
						</c:choose>
					 </c:if>
					<c:choose>
						<c:when test="${stageName == 'EVLREPLY'}" > 
						</c:when>
						<c:otherwise>
							<input type="button" class="btn-primary" value="Send back" style="margin-left: 10px !important;" onclick="javascript:showSendBackNotes();" />
							<s:submit key="label.request.saveAndExit" cssClass="btn-primary" 
							action="saveAndExitBid" onclick="javascript:saveBankSelection(1);" cssStyle="margin-left: 10px !important;">
					</s:submit>	
						</c:otherwise>
					</c:choose>
					   		
					<s:url id="readysystemCancel" action="cancel" />
					<s:a href="%{readysystemCancel}" key="label.request.common.cancel" cssClass="btn-tertiary cancel">
					<s:text name="label.request.common.cancel"></s:text></s:a> 
						
					<img alt="Loading..." id="submitBidProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
			</div>
		</div>		
	</div>
</div>
</div>

<div class="row hide" id="reasonForSendBackId">
	<div class="span11e btn-container">
		<div class="form-row">
			<div>
				<label><s:text name="label.request.Sendbacknotes" /></label>
				<s:textarea cssClass="autosize messageinput" name="requestDetails.actionDetails.reasonForRejection" col="50" rows="2" onkeypress="return imposeMaxLength(this, 399);" theme="aloc"/>	
	            <div class="clear"></div>
	            <div class="counter">400</div> <!-- fix positions -->
	            <div class="counterTxt"><p class="guidance"><s:text name="label.request.characters" /></p></div>
	       </div> 	
	       <div class="span5">
				<br/>
				<span class="optOutval-error hide" style="color:red"></span>
		   </div>
	       <p class="clear">&nbsp;</p> 
	       <div class="row highlighted">
	       		<s:submit key="label.request.common.sendBack" cssClass="btn-primary" action="sendBackBid" onclick="javascript:sendBackBidMemo();" cssStyle="margin-left: 10px !important;">
				</s:submit>  
		   </div>                      
		</div>
	</div>
</div>