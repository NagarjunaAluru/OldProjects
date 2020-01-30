<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${param.includeScripts != false}">
	<%@include file="../../common/includeCommonScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/js/requestor/bidMemo.js" type="text/javascript"></script>
</c:if>

<div id="saveBidDiv">
			<h2 id="bidMemoDetails" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.dLocBidMemoSection"/></a>
			</h2><hr class="h2-hr">
			<div id="bidMemoDetailsPanel" class="section_panel">
			
					<div id="bidMemoDetailsSection">
							<jsp:include page="/jsp/common/request/bidMemoCreationDetails.jsp" />
							<input type="hidden" name= "sectionId" value="${param.sectionId}" />
					</div>
					
					<div class="clear"></div>
					
					<div class="row highlighted lastrow"  id="BidMemoRowDiv">
						<div class="span12">
							<div class="btn-container">
								<div class="form-row" style="margin-left:0px;">
									<input type="hidden" name="actionType" id="actionType" value="${actionType}"/>	
									
									<s:submit key="label.request.saveAndSelectBanks" cssClass="btn-primary" action="dLocCreateBid" onclick="javascript:saveSelectBanksBidMemo();">
									</s:submit>
									<input type="button" class="btn-primary" value="Send back" style="margin-left: 10px !important;" onclick="javascript:showSendBackNotes();" />
									<s:submit key="label.request.saveAndExit" cssClass="btn-primary" action="saveAndExitBid" onclick="javascript:saveBidMemo();" cssStyle="margin-left: 10px !important;">
									</s:submit>
									
									<s:url id="readysystemCancel" action="cancel" />
									<s:a href="%{readysystemCancel}" key="label.request.common.cancel" cssClass="btn-tertiary cancel">
										<s:text name="label.request.common.cancel"></s:text>
									</s:a>
													  
									<img alt="Loading..." id="saveAndSelectBanksProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
									
									<s:set name="errorShow" value="errorShow"/>
						            <s:hidden name="errorShow"  value="%{errorShow}" id="errorShow"/> 
			           			</div>
			           		</div>
		            	</div>
		            </div>
		</div>
</div>			