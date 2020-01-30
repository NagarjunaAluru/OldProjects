<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<div class="row smallrow">
<div class="span12">
	<nav> 
	     <ul>
	       <c:if test="${requestDetails.bidOrOptFlag eq 'Y'}"> 
		        <s:if test="%{requestDetails.bundleDetails.bundleId!= null && requestDetails.bundleDetails.bundleId!=''}">
		          <c:if test="${requestDetails.instrumentTypeId eq '3'}">
	                  <li class="navLi" style="width: 150px;"><a class="navLink awardsub" href="#tab1" data-toggle="modal"  onclick="popUpSelectWinner('<s:property value="requestDetails.requestId"/>','<s:property value="requestDetails.bundleDetails.bundleId"/>','<s:property value="requestDetails.instrumentTypeId"/>','<s:property value="requestDetails.bidReplyID"/>','<s:property value="requestDetails.feesDetails.surityName"/>','<s:property value="requestDetails.sitePrefix"/>','')" style="width: 159px;"><s:text name="label.request.awardTosurety"></s:text></a></li>
	              </c:if>
	              <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2'||requestDetails.instrumentTypeId eq '4'}">
	                <li class="navLi" style="width: 150px;"><a class="navLink awardsub" href="#tab1" data-toggle="modal"  onclick="popUpSelectWinner('<s:property value="requestDetails.requestId"/>','<s:property value="requestDetails.bundleDetails.bundleId"/>','<s:property value="requestDetails.instrumentTypeId"/>','<s:property value="requestDetails.bidReplyID"/>','<s:property value="requestDetails.winningBankDetails.winnerDetails.winningBankName"/>','<s:property value="requestDetails.sitePrefix"/>','<s:property value="transmissionPlatform"/>')" style="width: 159px;"><s:text name="label.request.awardTobank"></s:text></a></li>
			      </c:if>
			   </s:if>
			  <s:else>
			     <c:if test="${requestDetails.instrumentTypeId eq '3'}">
			             <li class="navLi" style="width: 150px;"><a class="navLink awardsub" href="#tab1" data-toggle="modal"  onclick="popUpSelectWinner('<s:property value="requestDetails.requestId"/>','','<s:property value="requestDetails.instrumentTypeId"/>','<s:property value="requestDetails.bidReplyID"/>','<s:property value="requestDetails.feesDetails.surityName"/>','<s:property value="requestDetails.sitePrefix"/>','')" style="width: 159px;"><s:text name="label.request.awardTosurety"></s:text></a></li>
			     </c:if>
			     <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2'||requestDetails.instrumentTypeId eq '4'}">
                         <li class="navLi" style="width: 150px;"><a class="navLink awardsub" href="#tab1" data-toggle="modal"  onclick="popUpSelectWinner('<s:property value="requestDetails.requestId"/>','','<s:property value="requestDetails.instrumentTypeId"/>','<s:property value="requestDetails.bidReplyID"/>','<s:property value="requestDetails.winningBankDetails.winnerDetails.winningBankName"/>','<s:property value="requestDetails.sitePrefix"/>','<s:property value="transmissionPlatform"/>')" style="width: 159px;"><s:text name="label.request.awardTobank"></s:text></a></li>  
                 </c:if>			 
			  </s:else>		
			     <c:if test="${requestDetails.instrumentTypeId eq '3'}">
			             <li id="li2" class="navLi" style="width: 150px;"><a class="navLink" id="nav-awardprepare" href="#tab2" style="width: 154px;"><s:text name="label.request.returnTosurety"></s:text></a></li>
			     </c:if>
			     <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2'||requestDetails.instrumentTypeId eq '4'}">
                         <li id="li2" class="navLi" style="width: 150px;"><a class="navLink" id="nav-awardprepare" href="#tab2" style="width: 154px;"><s:text name="label.request.returnTobank"></s:text></a></li>  
                 </c:if>	
		   </c:if>
		   <li id="li3" class="navLi" style="width: 100px;"><a href="#reasonForSendBackId" class="navLink" id="bidAwardSendback"><s:text name="label.request.common.sendBack"/></a> </li>
		   
			<li class="last"><a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.exitRequest"/></a>  </li>
	    </ul>
	</nav>
<c:if test="${requestDetails.bidOrOptFlag eq 'Y'}"> 
	<div class="tab" id="tab2" style="padding:10px; background:#fff; border:Solid 3px #ccd7e5;">
			<div class="row">
				<div class="span11e btn-container">
					<div class="form-row">
					<div>
					<label><s:text name="label.request.reasonForReturn" /></label>
					<s:textarea cssClass="autosize messageinput" id="bidAwardBankEditId" name="requestDetails.actionDetails.reasonForOptingOut" col="50" rows="2" onkeypress="return imposeMaxLength(this, 399);" theme="aloc"/>	
	                <div class="clear"></div>
	                <div class="counter" id="bidAwardBankEditCounter">400</div> <!-- fix positions -->
	                <div class="counterTxt"><p class="guidance"><s:text name="label.request.characters" /></p></div>
	               </div> 	
	               <div class="span5">
					   <br/>
						<span class="optOutval-error hide" style="color:red"></span>
				  </div>
	                <p class="clear">&nbsp;</p>    
	               <s:submit key="label.request.Submit" name="returnReason" onclick="submitAction(14)"cssClass="btn"/>                      
	                <a class="nav-hide" href="#tab5"><s:text name="label.request.common.cancel"/></a>
	                <s:hidden name="hours" value="%{hours}"></s:hidden>
					<s:hidden name="minutes" value="%{minutes}"></s:hidden>
					<s:hidden name="period" value="%{period}"></s:hidden>
					</div>
				</div>
			</div>
	</div>
</c:if>

<div class="tab" id="reasonForSendBackId" style="padding:10px; background:#fff; border:Solid 3px #ccd7e5;">
	<div class="row">
	<div class="span11e btn-container">
		<div class="form-row">
			<div>
				<label><s:text name="label.request.Sendbacknotes" /></label>
				<s:textarea cssClass="autosize messageinput" id="bidAwardSendBackId" name="requestDetails.actionDetails.reasonForRejection" col="50" rows="2" onkeypress="return imposeMaxLength(this, 399);" theme="aloc"/>	
	            <div class="clear"></div>
	            <div class="counter" id="bidAwardsendBackCounter">400</div> <!-- fix positions -->
	            <div class="counterTxt"><p class="guidance"><s:text name="label.request.characters" /></p></div>
	       </div> 	
	       <div class="span5">
				<br/>
				<span class="optOutval-error hide" style="color:red"></span>
		   </div>
	       <p class="clear">&nbsp;</p> 
	       		<s:submit key="label.request.common.sendBack" cssClass="btn" onclick="javascript:sendBackBidAward(3);" cssStyle="margin-left: 10px !important;">
				</s:submit>  
		</div>
	</div>
</div>
</div>
  </div>
</div>
		
	