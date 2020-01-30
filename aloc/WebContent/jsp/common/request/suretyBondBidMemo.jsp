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
		<div class="form-mod" id="suretyBidDetails">
				<h2 id="bidMemoDetails" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bidResponseReqBy"/></a>
				</h2><hr class="h2-hr">
				<div id="bidMemoDetailsPanel" class="section_panel">
			      <div id="bidMemoDetailsSection">
					<jsp:include page="/jsp/common/request/bidMemoCreationDetails.jsp" >
						<jsp:param name="suretyBond" value="true" />
					</jsp:include>
				  </div>
				</div>
				 
				<h2 id="comments" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.comments"/></a>
				</h2><hr class="h2-hr">
				<div id="commentsPanel" class="section_panel acc_container2">
					<div id="commentsSection">
					<s:textarea name="requestDetails.comments" 
								id="bidMemoComments" 
								rows="2" cols="50"
								required="false"
								cssClass="autosize3 messageinput"
								key="label.request.transferFeesComments" 
								theme="aloc"
								onkeypress="return imposeMaxLength(this, 299);"
							/>
							
						<div class="clear"></div>
						<div class="counter"><s:text  name="label.request.threeHundred"/></div> <!-- fix positions -->
                        <div class="counterTxt"><p class="guidance"><s:text  name="label.request.textSize"/></p></div>
					</div>
				</div>
				
				<h2 id="principal" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.principal"/></a>
				</h2><hr class="h2-hr">
				<div id="principalPanel" class="section_panel acc_container3">
					<div id="principalSection">
						<div class="row">
							<div class="span1a">
								<div class="form-row">
									<label><s:text name="label.request.sbNameAndAddress"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<s:property value="requestDetails.principal.addressDtls.name"/><br />
										<s:iterator value="requestDetails.principal.addressDtls.address">
										<s:property/><br />
										</s:iterator>
										<s:property value="requestDetails.principal.addressDtls.city"/>&nbsp;&nbsp;<s:property value="requestDetails.principal.addressDtls.stateProvince"/>&nbsp;&nbsp;&nbsp;<s:property value="requestDetails.principal.addressDtls.ZIPPostalCode"/>&nbsp;&nbsp;<br />
										<s:property value="requestDetails.principal.addressDtls.country"/>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<h2 id="obligee" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.obligee"/></a>
				</h2><hr class="h2-hr">
				<div id="obligeePanel" class="section_panel">
					<div id="obligeeSection">
						<div class="row">
							<div class="span1a">
								<div class="form-row">
									<label><s:text name="label.request.nameAndAddress"/></label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<s:property value="requestDetails.obligee.addressDtls.name"/><br />
										<s:iterator value="requestDetails.obligee.addressDtls.address">
										<s:property/><br />
										</s:iterator>
										<s:property value="requestDetails.obligee.addressDtls.city"/>&nbsp;&nbsp;<s:property value="requestDetails.obligee.addressDtls.stateProvince"/>&nbsp;&nbsp;&nbsp;<s:property value="requestDetails.obligee.addressDtls.ZIPPostalCode"/>&nbsp;&nbsp;<br />
										<s:property value="requestDetails.obligee.addressDtls.country"/>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="clear"> </div>
				<!-- Audit Log and Transaction History  -->
				<jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp"/>	            
				
			 </div>	  
			
			<div class="clear"></div>	
			<p>&nbsp;</p>  
                    
        	<div class="row highlighted"  id="BidMemoRowDiv">
	            <div class="span12">
	            	<input type="hidden" name="actionType" id="actionType" value="${actionType}"/>	
					
					<s:submit key="label.request.saveAndSelectSurety" cssClass="btn-primary" action="suretyCreateBid" onclick="javascript:saveSelectBanksBidMemo();">
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