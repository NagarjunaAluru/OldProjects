<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/js/common/section.js" type="text/javascript"></script>
<script	type="text/javascript">
$(document).ready(function() {
	tableParser();
	basicSearchInDashboard();
	advanceSearchInDashboard();
	if (window.PIE) {
        $('.modal-header,.boxHead,.errorHead,.errorContent,#infoMsg,#siteMsg,.defaultViewMsg,.btn,.nav-tabs > li > a').each(function() {
            PIE.attach(this);
        });
    }	
});
</script>

		<s:url action="getGlanceDetails.action" namespace="/int/dashboard"	var="openbidsURLs">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.1"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/int/dashboard"	var="openperformanceURL">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.2"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/int/dashboard"	var="openApaymentURL">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.3"/><s:text name="label.dashboard.glanceInfo.8"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/int/dashboard"	var="openfinancialURL">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.4"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/int/dashboard"	var="opendocURL">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.5"/><s:text name="label.dashboard.glanceInfo.7"/></s:param>
		</s:url>
		
		<s:url action="getGlanceDetails.action" namespace="/int/dashboard"	var="openbidGlanceURLs" escapeAmp="false" encode="true">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.1"/></s:param>
		 <s:param name="glancecount"><s:text name="label.dashboard.glancecount"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/int/dashboard"	var="openperformanceGlanceURL" escapeAmp="false" encode="true">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.2"/></s:param>
		  <s:param name="glancecount"><s:text name="label.dashboard.glancecount"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/int/dashboard"	var="openApaymentGlanceURL" escapeAmp="false" encode="true">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.3"/><s:text name="label.dashboard.glanceInfo.8"/></s:param>
		  <s:param name="glancecount"><s:text name="label.dashboard.glancecount"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/int/dashboard"	var="openfinanciaGlancelURL" escapeAmp="false" encode="true">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.4"/></s:param>
		  <s:param name="glancecount"><s:text name="label.dashboard.glancecount"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/int/dashboard"	var="opendocGlanceURL" escapeAmp="false" encode="true">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.5"/><s:text name="label.dashboard.glanceInfo.7"/></s:param>
		  <s:param name="glancecount"><s:text name="label.dashboard.glancecount"/></s:param>
		</s:url>
		<c:if test="${not empty sessionScope.successMsg}" >
		<div id="siteMsg">
            <div class="sucessMsg">
            	<a href="javascript:;" class="right successclose" style="margin-right:5px;">X</a>Success
            </div>
            <div class="sucessContent"><s:property value="#session.successMsg" /></div>
        </div>
        </c:if>
        
        <c:if test="${not empty errorMsg}">
		 		<div class="row" id="errorMsg">
						<div class="span12">
							<div class="errorbox">
								<div class="errorHead">
									<p class="erroricon">Error</p>
								</div>
								<div class="errorContent">
									<p>
										<s:property value="errorMsg" />
									</p>
									<p>&nbsp;</p>
								</div>
							</div>
					 </div>
				</div>	
		</c:if>
		
		<div class="row">
			<div class="span12">
				<div id="expandViewError" class="expandViewError" style="display: none;">
					<div class="errorbox">
						<div class="errorHead">
							<a href="#" class="right errorClose" style="margin-right:5px;">X</a>
							<img src='${pageContext.request.contextPath}/img/error.png' style="padding-left: 5px;"/>
							<p class="erroricon" style="margin-top: -45px;"><s:text name="label.common.error"/></p>
						</div>
						<div class="errorContent"></div>
					</div>
				</div>
			</div>
		</div>
        
        <div class="defaultViewMsg hide">
			<div class="defaultViewSuccessMsg hide">
		    	<a href="#" class="right successclose">X</a>
		        <img src='${pageContext.request.contextPath}/img/succ.png' align="middle" style="margin-left:-30px;" /><span style="padding-left:5px;">
		        <s:text name="label.dashboard.defaultViewSuccess"/></span>
		    </div>
		    <div class="defaultSucessContent">
		 		<span class="defaultViewTextSuccess hide"></span>
		    </div>
		</div>
        
        <div style=color:red;>
      		<s:actionmessage/>      				
   		</div>
	   <div id="glance">
        	<div class="up" id="atAGlanceArrow" style="float: left;"></div><h3 id="atAGlance"><s:text name="label.dashboard.atAGlance"/></h3>
        	<c:set var="perfRetOthers" value="${searchResult.glanceDetails.performanceCount + searchResult.glanceDetails.retentionCount + searchResult.glanceDetails.otherCount}"></c:set>
        	<c:set var="perfRetOthersRevision" value="${searchResult.glanceDetails.performacnceReturnRevisionsCount + searchResult.glanceDetails.retentionReturnRevisionsCount + searchResult.glanceDetails.otherReturnForRevisionsCount}"></c:set>
             <div class="boxGlance"> 
            
                 <div class="bids">
                     <div class="colorBids"></div>
                     <div class="contentBids">
                          <div class="txtBids"><c:if test="${empty searchResult.glanceDetails.bidsCount}">0</c:if><s:property value="searchResult.glanceDetails.bidsCount"/></div> 
                           <a href="<s:property value="openbidsURLs" />"><font color="black"> <s:text name="label.dashboard.glanceInfo.1"/></font> </a> 
                           <p> 
                           			<c:if test="${empty searchResult.glanceDetails.bidReturnRevisionsCount}">0</c:if><s:property value="searchResult.glanceDetails.bidReturnRevisionsCount"/>  
                           			<a href="<s:property value="openbidGlanceURLs" />"><font color="black"><s:text name="label.dashboard.glanceInfo.6"/></font>
                           		</a>
                           	</p>
                      </div>
                  </div>
                 
            </div>
           <div class="boxGlance">
              
               <div class="performance">
                 <div class="colorPerformance"></div>
                 <div class="contentPerformance">
                    <span class="txtPerformance"><c:out value="${perfRetOthers}"></c:out> </span> 
                     <a href="<s:property value="openperformanceURL" />" style="font-weight: normal;"> <font color="black"><s:text name="label.dashboard.glanceInfo.2"/></font> </a>  
                     <p><c:out value="${perfRetOthersRevision}"></c:out>
                     	<a href="<s:property value="openperformanceGlanceURL" />"> <font color="black"><s:text name="label.dashboard.glanceInfo.6"/></font></a></p>
                  </div>
               </div>
           </div>
           <div class="boxGlance">
               
             <div class="apayment">
                <div class="colorApayment"></div>
                 <div class="contentApayment">
                    <span class="txtApayment">
                        <c:if test="${empty searchResult.glanceDetails.advancePaymentCount}">0</c:if><s:property value="searchResult.glanceDetails.advancePaymentCount"/></span> 
                       <a href="<s:property value="openApaymentURL" />"><font color="black"><s:text name="label.dashboard.glanceInfo.3"/><br/>  <s:text name="label.dashboard.glanceInfo.8"/> </font> </a> 
                        <p><c:if test="${empty searchResult.glanceDetails.advPaymentReturnRevisionsCount}">0</c:if><s:property value="searchResult.glanceDetails.advPaymentReturnRevisionsCount"/> 
                           <a href="<s:property value="openApaymentGlanceURL" />"><font color="black"><s:text name="label.dashboard.glanceInfo.6"/></font></a>
                        </p>
                 </div>
               </div>
          </div>
            <div class="boxGlance"> 
                 
               <div class="financial">
                  <div class="colorFinancial"></div>
                  <div class="contentFinancial">
	                  <span class="txtFinancial"><c:if test="${empty searchResult.glanceDetails.financialCount}">0</c:if><s:property value="searchResult.glanceDetails.financialCount"/></span> 
	                  <a href="<s:property value="openfinancialURL" />"> <font color="black"> <s:text name="label.dashboard.glanceInfo.4"/> </font>  </a>
	                  <p><c:if test="${empty searchResult.glanceDetails.finacialReturnRevisionsCount}">0</c:if><s:property value="searchResult.glanceDetails.finacialReturnRevisionsCount"/> 
	                     <a href="<s:property value="openfinanciaGlancelURL" />"><font color="black"><s:text name="label.dashboard.glanceInfo.6"/></font></a>
	                  </p>
                 </div>
             </div>
            </div>
           <div class="boxGlance">
                 
               <div class="doc">
                 <div class="colorDOC"></div>
                 <div class="contentDOC">
                   <span class="txtDOC">
                       <c:if test="${empty searchResult.glanceDetails.docLcConfirmationCount}">0</c:if><s:property value="searchResult.glanceDetails.docLcConfirmationCount"/></span> 
                        <a href="<s:property value="opendocURL" />"> <font color="black"> <s:text name="label.dashboard.glanceInfo.5"/><br/> <s:text name="label.dashboard.glanceInfo.7"/></font>  </a>  
                        <p><c:if test="${empty searchResult.glanceDetails.docLcReturnRevisionsCount}">0</c:if><s:property value="searchResult.glanceDetails.docLcReturnRevisionsCount"/>
                              <a href="<s:property value="opendocGlanceURL" />"> <font color="black"><s:text name="label.dashboard.glanceInfo.6"/></font></a>
                        </p>
                 </div>
               </div>
           </div>
             <div class="clear"></div>	
        </div>
        
        <div class="form-mod">
        <c:set var="isTreasury" value="N"/>
        <hwfs:checkComponentPermission name="DefaultViewTreasuryAccess" domainName="BusinessAccess">
        <c:set var="isTreasury" value="Y"/>
        <div id="defaultTreasuryView"> <s:text name="label.dashboard.defaultView" />
        	<s:select id="defaultView" list="#{'MYTRANSACTIONS':'My Transactions','ALLREQUESTS':'All Requests'}" 
        		cssStyle="width:150px!important;" name="results.defaultView">
        	</s:select>
        	<img alt="Loading..." id="defaultViewIndicatorId" class="defaultViewIndicator" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px">
        </div>
        </hwfs:checkComponentPermission>
        <c:if test="${isTreasury =='N'}">
	        <hwfs:checkComponentPermission name="DefaultViewReqAccess" domainName="BusinessAccess">
	        <div id="defaultReqView"> <s:text name="label.dashboard.defaultView" />
	        	<s:select id="defaultView" list="#{'MYTRANSACTIONS':'My Transactions','ALLREQUESTS':'All Requests'}" 
	        		cssStyle="width:150px!important;" name="searchResult.defaultView">
	        	</s:select>
	        	<img alt="Loading..." id="defaultViewIndicatorId" class="defaultViewIndicator" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px">
	        </div>
	        </hwfs:checkComponentPermission>
        </c:if>
        
        	<c:choose>
        		<c:when test="${dashboardViewType eq 'MYTRANSACTIONS'}">
        			<c:set var="myTranLIClass" value="active"></c:set>
        			<c:set var="myTranTab" value="active in"></c:set>
        			
        		</c:when>
        		<c:when test="${dashboardViewType eq 'ALLREQUESTS'}">
        			<c:set var="allReqLIClass" value="active"></c:set>
        			<c:set var="allReqTab" value="active in"></c:set>
        			
        		</c:when>
        		<c:when test="${dashboardViewType eq 'DRAFTS'}">
        			<c:set var="draftLIClass" value="active"></c:set>
        			<c:set var="draftTab" value="active in"></c:set>
        			
        		</c:when>
        		<c:when test="${dashboardViewType eq 'MODEL'}">
        			<c:set var="modelLIClass" value="active"></c:set>
        			<c:set var="modelTab" value="active in"></c:set>
        			
        		</c:when>
        		<c:when test="${dashboardViewType eq 'BUNDLES'}">
        			<c:set var="bundleLIClass" value="active"></c:set>
        			<c:set var="bundleTab" value="active in"></c:set>
        			
        		</c:when>
        		<c:when test="${dashboardViewType eq 'TREASURYBIDPROCESS'}">
        			<c:set var="bidTreasuryLIClass" value="active"></c:set>
        			<c:set var="bidTreasuryTab" value="active in"></c:set>
        			
        		</c:when>
        		<c:when test="${dashboardViewType eq 'BANKBIDPROCESS'}">
        			<c:set var="bidBankLIClass" value="active"></c:set>
        			<c:set var="bankBidProcessLIClass" value="active"></c:set>
        			<c:set var="bidBankTab" value="active in"></c:set>
        			<c:set var="bankBidProcessTab" value="active in"></c:set>
        		</c:when>  
        		<c:when test="${dashboardViewType eq 'TREASURYBANKPENDINGINCE'}">
        			<c:set var="bidBankLIClass" value="active"></c:set>
        			<c:set var="bankPendingIssLIClass" value="active"></c:set>
        			<c:set var="bidBankTab" value="active in"></c:set>
        			<c:set var="bankPendingIssTab" value="active in"></c:set>
        		</c:when>  
        		<c:when test="${dashboardViewType eq 'TREASURYBANKHIST'}">
        			<c:set var="bidBankLIClass" value="active"></c:set>
        			<c:set var="bankHistoricalTransLIClass" value="active"></c:set>
        			<c:set var="bidBankTab" value="active in"></c:set>
        			<c:set var="bankHistoricTransTab" value="active in"></c:set>
        		</c:when>         		
        		<c:when test="${dashboardViewType eq 'TREASURYBROKERBIDPROCESS'}">
        			<c:set var="brokerLIClass" value="active"></c:set>
        			<c:set var="brokerBidProcessLIClass" value="active"></c:set>
        			<c:set var="brokerTab" value="active in"></c:set>
        			<c:set var="brokerBidProcessTab" value="active in"></c:set>
        		</c:when>  
        		<c:when test="${dashboardViewType eq 'TREASURYBROKERPENDINGINCE'}">
        			<c:set var="brokerLIClass" value="active"></c:set>
        			<c:set var="brokerPendingIssLIClass" value="active"></c:set>
        			<c:set var="brokerTab" value="active in"></c:set>
        			<c:set var="brokerPendingIssTab" value="active in"></c:set>
        		</c:when>  
        		<c:when test="${dashboardViewType eq 'TREASURYBROKERHIST'}">
        			<c:set var="brokerLIClass" value="active"></c:set>
        			<c:set var="brokerHistoricalTransLIClass" value="active"></c:set>
        			<c:set var="brokerTab" value="active in"></c:set>
        			<c:set var="brokerHistoricTransTab" value="active in"></c:set>
        		</c:when>   
        	</c:choose>
        	
        	<c:if test="${not empty requestDetails.comments}" >
               <h5 style=color:green;><s:property value="requestDetails.comments" /></h5>	
            </c:if>            
        	
        	<s:url action="displayMyTransactionDashboard.action" 
					namespace="/int/dashboard"
					var="myTransactionDashboardURL" />
			<s:url action="displayAllRequestDashboard.action" 
					namespace="/int/dashboard"
					var="allRequestDashboardURL" />
			<s:url action="displayDraftDashboard.action" 
					namespace="/int/dashboard"
					var="draftDashboardURL" />
			<s:url action="displayModelDashboard.action" 
					namespace="/int/dashboard"
					var="modelDashboardURL" />
			<s:url action="displayBundleDashboard.action" 
					namespace="/int/dashboard"
					var="bundleDashboardURL" />
			<s:url action="displayBidTreasuryDashboard.action" 
					namespace="/int/dashboard"
					var="bidTreasuryDashboardURL" />
			<s:url action="displayBankBidProcessDashboard.action" 
					namespace="/int/dashboard"
					var="bankBidProcessDashboardURL" />
			<s:url action="displayBankPendingIssDashboard.action" 
					namespace="/int/dashboard"
					var="bankPendingIssDashboardURL" />
			<s:url action="displayBankHistTransDashboard.action" 
					namespace="/int/dashboard"
					var="bankHistoricalTransDashboardURL" />
			<s:url action="displayBrokerBidProcessDashboard.action" 
					namespace="/int/dashboard"
					var="brokerBidProcessDashboardURL" />
			<s:url action="displayBrokerPendingIssDashboard.action" 
					namespace="/int/dashboard"
					var="brokerPendingIssDashboardURL" />
			<s:url action="displayBrokerHistTransDashboard.action" 
					namespace="/int/dashboard"
					var="brokerHistoricalTransDashboardURL" />		
			
			<ul class="nav nav-tabs tabs" >
				<hwfs:checkComponentPermission name="MyTransactionsDashBoardAccess" domainName="BusinessAccess">
				<li class="${myTranLIClass}">
					<a href="<s:property value="#myTransactionDashboardURL" />"><s:text name="label.dashboard.tab.myTransaction" /> 
					<s:property value="searchResult.dashBoardTabsCount.myTransCount"/> </a>
				</li>
				</hwfs:checkComponentPermission>
				<hwfs:checkComponentPermission name="BidProcessTreasuryDashBoardAccess" domainName="BusinessAccess">
                <li class="${bidTreasuryLIClass}">
                	<a href="<s:property value="#bidTreasuryDashboardURL" />"><s:text name="label.dashboard.tab.bidProcessTreasury" /> 
                	<s:property value="searchResult.dashBoardTabsCount.treasBidProcCount"/></a>
                </li>
                </hwfs:checkComponentPermission>
				<hwfs:checkComponentPermission name="AllRequestsDashBoardAccess" domainName="BusinessAccess">
				<li class="${allReqLIClass}">
					<a href="<s:property value="#allRequestDashboardURL" />"><s:text name="label.dashboard.tab.allRequest" /> 
					<s:property value="searchResult.dashBoardTabsCount.allRequestsCount"/></a>
				</li>
				</hwfs:checkComponentPermission>
				<hwfs:checkComponentPermission name="DraftDashBoardAccess" domainName="BusinessAccess">
                <li class="${draftLIClass}">
                	<a href="<s:property value="#draftDashboardURL" />"><s:text name="label.dashboard.tab.draft" /> 
                	<s:property value="searchResult.dashBoardTabsCount.draftsCount"/></a>
                </li>
                </hwfs:checkComponentPermission>
                 <hwfs:checkComponentPermission name="BidProcessTreasuryDashBoardAccess" domainName="BusinessAccess">
                <li class="${bidBankLIClass}">
                	<a href="<s:property value="#bankBidProcessDashboardURL" />"><s:text name="label.dashboard.tab.bidProcessBank" /></a>
                </li>
                </hwfs:checkComponentPermission>
                 <hwfs:checkComponentPermission name="BidProcessTreasuryDashBoardAccess" domainName="BusinessAccess">
                <li class="${brokerLIClass}">
                	<a href="<s:property value="#brokerBidProcessDashboardURL" />"><s:text name="label.dashboard.tab.bidProcessBroker" /></a>
                </li>
                </hwfs:checkComponentPermission>
                <hwfs:checkComponentPermission name="ModelDashBoardAccess" domainName="BusinessAccess">
                <li class="${modelLIClass}">
                	<a href="<s:property value="#modelDashboardURL" />"><s:text name="label.dashboard.tab.model" /> 
                	<s:property value="searchResult.dashBoardTabsCount.modelsCount"/></a>
                </li>
                </hwfs:checkComponentPermission>               
                <hwfs:checkComponentPermission name="BundleDashBoardAccess" domainName="BusinessAccess">
                <li class="${bundleLIClass}">
                	<a href="<s:property value="#bundleDashboardURL" />"><s:text name="label.dashboard.tab.bundles" /> 
                	<s:property value="searchResult.dashBoardTabsCount.bundlesCount"/></a>
                </li>
                </hwfs:checkComponentPermission>
			</ul>					        	
        	<div class="tab-content" id="myDashboardTabContent">
        		<hwfs:checkComponentPermission name="MyTransactionsDashBoardAccess" domainName="BusinessAccess">
        		<div id="MyTransactionDiv" class="tab-pane fade ${myTranTab}">
        			<c:if test="${dashboardViewType eq 'MYTRANSACTIONS'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="MyTransaction"></jsp:param>
					</jsp:include>
					<jsp:include page="common/MyTransSearchResult.jsp"/>
					</c:if>
        		</div>
        		</hwfs:checkComponentPermission>
        		<hwfs:checkComponentPermission name="AllRequestsDashBoardAccess" domainName="BusinessAccess">
        		<div id="AllRequestDiv" class="tab-pane fade ${allReqTab}">
        			<c:if test="${dashboardViewType eq 'ALLREQUESTS'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="AllRequest"></jsp:param>
					</jsp:include>
					<jsp:include page="common/AllReqSearchResult.jsp"/>
					</c:if>
        		</div>
        		</hwfs:checkComponentPermission>
        		<hwfs:checkComponentPermission name="DraftDashBoardAccess" domainName="BusinessAccess">
        		<div id="DraftDiv" class="tab-pane fade ${draftTab}">
        			<c:if test="${dashboardViewType eq 'DRAFTS'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="Draft"></jsp:param>
					</jsp:include>
					<jsp:include page="common/DraftSearchResult.jsp"/>
					</c:if>
        		</div>
        		</hwfs:checkComponentPermission>
        		<hwfs:checkComponentPermission name="ModelDashBoardAccess" domainName="BusinessAccess">
        		<div id="ModelDiv" class="tab-pane fade ${modelTab}">
        			<c:if test="${dashboardViewType eq 'MODEL'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="Model"></jsp:param>
					</jsp:include>
					<jsp:include page="common/ModelSearchResult.jsp"/>
					</c:if>
        		</div>
        		</hwfs:checkComponentPermission>
        		<hwfs:checkComponentPermission name="BidProcessTreasuryDashBoardAccess" domainName="BusinessAccess">
        		<div id="BidTreasuryDiv" class="tab-pane fade ${bidTreasuryTab}">
        			<c:if test="${dashboardViewType eq 'TREASURYBIDPROCESS'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="BidProcessTreasury"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BidTreasurySearchResult.jsp"/>
					</c:if>
        		</div>
        		</hwfs:checkComponentPermission>
        		<hwfs:checkComponentPermission name="BidProcessTreasuryDashBoardAccess" domainName="BusinessAccess">
        		<div id="BidBankDiv" class="tab-pane fade ${bidBankTab}">
        			<ul class="nav nav-tabs tabs uppercase" >
						<li class="${bankBidProcessLIClass}">
							<a href="<s:property value="#bankBidProcessDashboardURL" />"><s:text name="label.dashboard.tab.bidProcessTreasury" />
							<s:property value="searchResult.dashBoardTabsCount.bankBidProcCount"/></a>
						</li>
						<li class="${bankPendingIssLIClass}">
							<a href="<s:property value="#bankPendingIssDashboardURL" />"><s:text name="label.dashboard.tab.pendingIssuance" />
							<s:property value="searchResult.dashBoardTabsCount.bankPendingIssuanceCount"/></a>
						</li>
		                <li class="${bankHistoricalTransLIClass}">
		                	<a href="<s:property value="#bankHistoricalTransDashboardURL" />"><s:text name="label.dashboard.tab.historicalTrans" />
		                	<s:property value="searchResult.dashBoardTabsCount.bankHistTransCount"/></a>
		                </li>
					</ul>
					<div style="height:8px;"></div>
					<c:if test="${dashboardViewType eq 'BANKBIDPROCESS'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="BidProcessBank"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BidBankSearchResult.jsp"/>
					</c:if>
					<c:if test="${dashboardViewType eq 'TREASURYBANKPENDINGINCE'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="BankPendingInce"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BankIssuancePenSearchResult.jsp"/>
					</c:if>
					<c:if test="${dashboardViewType eq 'TREASURYBANKHIST'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="BankHistoricTrans"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BankHistoricTransSearchResult.jsp"/>
					</c:if>
        		</div>
        		</hwfs:checkComponentPermission>
        		<hwfs:checkComponentPermission name="BidProcessTreasuryDashBoardAccess" domainName="BusinessAccess">
        		<div id="BidBrokerDiv" class="tab-pane fade ${brokerTab}">
        			<ul class="nav nav-tabs tabs uppercase" >
						<li class="${brokerBidProcessLIClass}">
							<a href="<s:property value="#brokerBidProcessDashboardURL" />"><s:text name="label.dashboard.tab.bidProcessTreasury" />
							<s:property value="searchResult.dashBoardTabsCount.brokerBidProcCount"/></a>
						</li>
						<li class="${brokerPendingIssLIClass}">
							<a href="<s:property value="#brokerPendingIssDashboardURL" />"><s:text name="label.dashboard.tab.pendingIssuance" />
							<s:property value="searchResult.dashBoardTabsCount.brokerPendingIssuanceCount"/></a>
						</li>
		                <li class="${brokerHistoricalTransLIClass}">
		                	<a href="<s:property value="#brokerHistoricalTransDashboardURL" />"><s:text name="label.dashboard.tab.historicalTrans" />
		                	<s:property value="searchResult.dashBoardTabsCount.brokerHistTransCount"/></a>
		                </li>
					</ul>
					<div style="height:8px;"></div>
					<c:if test="${dashboardViewType eq 'TREASURYBROKERBIDPROCESS'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="BidProcessBroker"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BidBankSearchResult.jsp"/>
					</c:if>
					<c:if test="${dashboardViewType eq 'TREASURYBROKERPENDINGINCE'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="BrokerPendingInce"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BrokerIssuancePenSearchResult.jsp"/>
					</c:if>
					<c:if test="${dashboardViewType eq 'TREASURYBROKERHIST'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="BrokerHistoricTrans"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BankHistoricTransSearchResult.jsp"/>
					</c:if>
        		</div>
        		</hwfs:checkComponentPermission>
        		<hwfs:checkComponentPermission name="BundleDashBoardAccess" domainName="BusinessAccess">
        		<div id="BundleDiv" class="tab-pane fade ${bundleTab}">
        			<c:if test="${dashboardViewType eq 'BUNDLES'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="Bundle"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BundleSearchResult.jsp"/>
					</c:if>
        		</div>
        		</hwfs:checkComponentPermission>
        	</div>
			<div class="row"  id="hideLessthan10">
				<!-- pagination pagination-right -->
			       <div class="span right">
			       	<div class="pagenavi left">
			       		
			       	</div>
			    	<div class="span3 jump-page">
						Jump to
						<input type="text" class="span1 manual">
						<a class="btn btn-success-blue" type="submit">Go</a>
						<a class="btn-goto-FirstPage hide"></a>
					</div>
				</div>
			</div>
        	<input type='hidden' id='current_page' />
        	<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
        </div>
        
<div class="clear"></div>
<div style="height:10px;"></div>
