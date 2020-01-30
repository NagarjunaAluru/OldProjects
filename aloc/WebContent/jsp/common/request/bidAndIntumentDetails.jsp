<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${param.includeScripts != false}">
	<%@include file="../../common/includeCommonScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/js/requestor/bidMemo.js" type="text/javascript"></script>
</c:if>

<div id="saveBidDetDiv">
			    <!-- Bid Memo Details -->
			   <div class="form-mod">
			   		<h2 id="bidMemoDetails" class="section_flip">
						<a href="javascript:;"><s:text name="label.request.bidResponseReqBy"/></a>
					</h2><hr class="h2-hr">
					<div id="bidMemoDetailsPanel" class="section_panel">
					      <jsp:include page="/jsp/requestor/treasury/bgAndLocBidMemoSection.jsp">
							<jsp:param name="sectionId"  value="request.section.bidMemoDetails" />
							<jsp:param name="includeScripts" value="false" />
						  </jsp:include>
						
					</div>
			   </div>
			   
			   <div class="clear"></div>
			   
			   <!-- delivery Instructions -->
			   <div class="form-mod" >
			   		<h2 id="additionalInstrumentDetails" class="section_flip">
						<a href="javascript:;"><s:text name="label.request.specialInstructions"/></a>
					</h2><hr class="h2-hr">
					<div id="additionalInstrumentDetailsPanel" class="section_panel">
					      <jsp:include page="/jsp/requestor/treasury/bgAndLocBidMemoSection.jsp">
							<jsp:param name="sectionId"  value="request.section.additionalInstrumentDetails" />
							<jsp:param name="includeScripts" value="false" />
						  </jsp:include>
					</div>
			   </div>
			   
			   <div class="clear"></div>
			   
	   		   <!-- Pricing Details -->
	   		   <div id="pricingDetailsDiv" class="hide">
				   <div class="form-mod">
				   		<h2 id="pricingDetails" class="section_flip">
							<a href="javascript:;"><s:text name="label.request.pricingDetails"/></a>
						</h2><hr class="h2-hr">
						<div id="pricingDetailsPanel" class="section_panel">
						      <jsp:include page="/jsp/requestor/treasury/bgAndLocBidMemoSection.jsp">
								<jsp:param name="sectionId"  value="request.section.pricingDetails" />
								<jsp:param name="includeScripts" value="false" />
								<jsp:param name="bidMemo" value="false" />
							  </jsp:include>
						</div>
				   </div>
			   </div>
			   
			    <div class="clear"></div>
			    
			   <!-- Additional Instrument Details -->
			   
			   <div class="row highlighted" id="BidMemoRowDiv">
					<div class="span12">
			   			<input type="hidden" name="actionType" id="actionType" value="${actionType}"/>	
			   			
						<s:submit key="label.request.saveAndSelectBanks" cssClass="btn-primary" action="createBid" onclick="javascript:saveSelectBanksBidMemo();">
						</s:submit>
						
						<input type="button" class="btn-primary" value="Send back" style="margin-left: 10px !important;" onclick="javascript:showSendBackNotes();" />
									
						<s:submit key="label.request.saveAndExit" cssClass="btn-primary" action="saveAndExitBid" onclick="javascript:saveBidMemo();" cssStyle="margin-left: 10px !important;">
						</s:submit>
									  
						<s:url id="readysystemCancel" action="cancel" />
							<s:a href="%{readysystemCancel}" key="label.request.common.cancel" cssClass="btn-tertiary cancel">
						<s:text name="label.request.common.cancel"></s:text>
						</s:a>
						  
					    <img alt="Loading..." id="saveAndSelectBanksProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				    </div>	
						  
				</div>
			     <s:set name="errorShow" value="errorShow"/>
                <s:hidden name="errorShow"  value="%{errorShow}" id="errorShow"/> 
			   
</div>