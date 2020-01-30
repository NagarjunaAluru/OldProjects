<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<s:head />

		<div class="acc_container11"> 
			<p class="span12 left clear dashdesc"><s:text name="label.request.bankSelectionTransDesc" /></p>
			
			<div class="row"></div>
			 <div style="color: red" id="bankDetValidate">
				<s:fielderror>
					<s:param>rightBankRecords</s:param>
				</s:fielderror>
			</div>
			
			<div class="row">
			<div class="span12" id="bankDiv">
				<dl>
					<dt></dt>
					<dd style="width: 500px !important;">
						<s:select id="availableBanks"
							list="requestDetails.bankDetails"
							listKey="siteName" listValue="siteName"
							name="rightBankRecords"
							multiple="true" cssClass="multi0select" />
					</dd>
			   </dl>	 
		    </div>
			</div>
			<c:set var="stageName" value="${requestDetails.WFDetails.WFStage}"></c:set>
			<c:if test="${stageName == 'EVLREPLY'}" > 
			<div class="row">
				<div class="span12">
					<s:radio theme="aloc" cssClass="radio" name="requestDetails.retainBidReply" 
						key="label.request.previousBidRepliesFlag" id="previousBidRepliesFlag" list="#{'Y':'Yes','N':'No'}"  />
				</div>
			</div>
			</c:if>
			<c:if test="${stageName == 'NEWMEMO'}" >
				<s:hidden name="requestDetails.retainBidReply" value="N" />
			</c:if>
	   </div>
