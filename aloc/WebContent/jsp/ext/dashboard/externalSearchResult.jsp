<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/ext/public/js/common/section.js" type="text/javascript"></script>
<script	type="text/javascript">
$(document).ready(function() {
	tableParser();
	basicSearchInDashboard();
	advanceSearchInDashboard();
});
</script>
		<s:url action="getGlanceDetails.action" namespace="/ext/dashboard"	var="openbidURL">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.1"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/ext/dashboard"	var="openperformanceURL">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.2"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/ext/dashboard"	var="openApaymentURL">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.3"/><s:text name="label.dashboard.glanceInfo.8"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/ext/dashboard"	var="openfinancialURL">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.4"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/ext/dashboard"	var="opendocURL">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.5"/><s:text name="label.dashboard.glanceInfo.7"/></s:param>
		</s:url>
		
		<s:url action="getGlanceDetails.action" namespace="/ext/dashboard"	var="openbidGlanceURLs" escapeAmp="false" encode="true">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.1"/></s:param>
		 <s:param name="glancecount"><s:text name="label.dashboard.glancecount"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/ext/dashboard"	var="openperformanceGlanceURL" escapeAmp="false" encode="true">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.2"/></s:param>
		  <s:param name="glancecount"><s:text name="label.dashboard.glancecount"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/ext/dashboard"	var="openApaymentGlanceURL" escapeAmp="false" encode="true">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.3"/><s:text name="label.dashboard.glanceInfo.8"/></s:param>
		  <s:param name="glancecount"><s:text name="label.dashboard.glancecount"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/ext/dashboard"	var="openfinanciaGlancelURL" escapeAmp="false" encode="true">
		 <s:param name="glanceParam"><s:text name="label.dashboard.glanceInfo.4"/></s:param>
		  <s:param name="glancecount"><s:text name="label.dashboard.glancecount"/></s:param>
		</s:url>
		<s:url action="getGlanceDetails.action" namespace="/ext/dashboard"	var="opendocGlanceURL" escapeAmp="false" encode="true">
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
							<img src='${pageContext.request.contextPath}/ext/public/img/error.png' style="padding-left: 5px;"/>
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
		        <img src='${pageContext.request.contextPath}/ext/public/img/succ.png' align="middle" style="margin-left:-30px;" /><span style="padding-left:5px;">
		        <s:text name="label.dashboard.defaultViewSuccess"/></span>
		    </div>
		    <div class="defaultSucessContent">
		 		<span class="defaultViewTextSuccess hide"></span>
		    </div>
		</div>
			   
	   <div id="glance">
        	<div class="up" id="atAGlanceArrow" style="float: left;"></div><h3 id="atAGlance"><s:text name="label.dashboard.atAGlance"/></h3>
        	<c:set var="perfRetOthers" value="${searchResult.glanceDetails.performanceCount + searchResult.glanceDetails.retentionCount + searchResult.glanceDetails.otherCount}"></c:set>
        	<c:set var="perfRetOthersRevision" value="${searchResult.glanceDetails.performacnceReturnRevisionsCount + searchResult.glanceDetails.retentionReturnRevisionsCount + searchResult.glanceDetails.otherReturnForRevisionsCount}"></c:set>
        	<hwfs:checkComponentPermission name="BankDashBoardAccess" domainName="BusinessAccess"> 
             <div class="boxGlance"> 
            
                 <div class="bids">
                     <div class="colorBids"></div>
                     <div class="contentBids">
                          <div class="txtBids"><c:if test="${empty searchResult.glanceDetails.bidsCount}">0</c:if><s:property value="searchResult.glanceDetails.bidsCount"/></div> 
                           <a href="<s:property value="openbidsURLs" />"><font color="black"> <s:text name="label.dashboard.glanceInfo.1"/></font> </a> 
                           <p> 
                           			<c:if test="${empty searchResult.glanceDetails.bidReturnRevisionsCount}">0</c:if><s:property value="searchResult.glanceDetails.bidReturnRevisionsCount"/>  
                           			<a href="<s:property value="openbidGlanceURLs" />"><font color="black"><s:text name="label.dashboard.glanceInfo.bidReply"/></font>
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
                     	<a href="<s:property value="openperformanceGlanceURL" />"> <font color="black"><s:text name="label.dashboard.glanceInfo.bidReply"/></font></a></p>
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
                           <a href="<s:property value="openApaymentGlanceURL" />"><font color="black"><s:text name="label.dashboard.glanceInfo.bidReply"/></font></a>
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
	                     <a href="<s:property value="openfinanciaGlancelURL" />"><font color="black"><s:text name="label.dashboard.glanceInfo.bidReply"/></font></a>
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
                              <a href="<s:property value="opendocGlanceURL" />"> <font color="black"><s:text name="label.dashboard.glanceInfo.bidReply"/></font></a>
                        </p>
                 </div>
               </div>
           </div>
           </hwfs:checkComponentPermission>
           
           <hwfs:checkComponentPermission name="BrokerDashBoardAccess" domainName="BusinessAccess"> 
             <div class="brokerBoxGlance"> 
            
                 <div class="bids">
                     <div class="colorBids"></div>
                     <div class="contentBrokerBids">
                          <div class="txtBids"><c:if test="${empty searchResult.glanceDetails.bidsCount}">0</c:if><s:property value="searchResult.glanceDetails.bidsCount"/></div> 
                           <a href="<s:property value="openbidsURLs" />"><font color="black"> <s:text name="label.dashboard.glanceInfo.1"/></font> </a> 
                           <p> 
                           			<c:if test="${empty searchResult.glanceDetails.bidReturnRevisionsCount}">0</c:if><s:property value="searchResult.glanceDetails.bidReturnRevisionsCount"/>  
                           			<a href="<s:property value="openbidGlanceURLs" />"><font color="black"><s:text name="label.dashboard.glanceInfo.bidReply"/></font>
                           		</a>
                           	</p>
                      </div>
                  </div>
                 
            </div>
           <div class="brokerBoxGlance">
              
               <div class="performance">
                 <div class="colorPerformance"></div>
                 <div class="contentBrokerPerformance">
                    <span class="txtPerformance"><c:out value="${perfRetOthers}"></c:out> </span> 
                     <a href="<s:property value="openperformanceURL" />" style="font-weight: normal;"> <font color="black"><s:text name="label.dashboard.glanceInfo.2"/></font> </a>  
                     <p><c:out value="${perfRetOthersRevision}"></c:out>
                     	<a href="<s:property value="openperformanceGlanceURL" />"> <font color="black"><s:text name="label.dashboard.glanceInfo.bidReply"/></font></a></p>
                  </div>
               </div>
           </div>
           <div class="brokerBoxGlance">
               
             <div class="apayment">
                <div class="colorApayment"></div>
                 <div class="contentBrokerApayment">
                    <span class="txtApayment">
                        <c:if test="${empty searchResult.glanceDetails.advancePaymentCount}">0</c:if><s:property value="searchResult.glanceDetails.advancePaymentCount"/></span> 
                       <a href="<s:property value="openApaymentURL" />"><font color="black"><s:text name="label.dashboard.glanceInfo.3"/><br/>  <s:text name="label.dashboard.glanceInfo.8"/> </font> </a> 
                        <p><c:if test="${empty searchResult.glanceDetails.advPaymentReturnRevisionsCount}">0</c:if><s:property value="searchResult.glanceDetails.advPaymentReturnRevisionsCount"/> 
                           <a href="<s:property value="openApaymentGlanceURL" />"><font color="black"><s:text name="label.dashboard.glanceInfo.bidReply"/></font></a>
                        </p>
                 </div>
               </div>
          </div>
          </hwfs:checkComponentPermission>
          
          <div class="clear"></div>	
        </div>
       
        <hwfs:checkComponentPermission name="BankDashBoardAccess" domainName="BusinessAccess">
	        <div id="defaultReqView"> <s:text name="label.dashboard.defaultView" />
	        	<s:select id="defaultView" list="#{'BANKBIDPROCESS':'Bid Process','TREASURYBANKPENDINGINCE':'Pending Issuance','TREASURYBANKHIST':'Historical Transactions'}" 
	        		cssStyle="width:150px!important;" name="results.defaultView">
	        	</s:select>
	        	<img alt="Loading..." id="defaultViewIndicatorId" class="defaultViewIndicator" src="${pageContext.request.contextPath}/ext/public/img/loading.gif" style="display:none;height: 20px;width: 20px">
	        </div>
         </hwfs:checkComponentPermission>
        
          <hwfs:checkComponentPermission name="BrokerDashBoardAccess" domainName="BusinessAccess"> 
	        <div id="defaultReqView"> <s:text name="label.dashboard.defaultView" />
	        	<s:select id="defaultView" list="#{'TREASURYBROKERBIDPROCESS':'Bid Process','TREASURYBROKERPENDINGINCE':'Pending Issuance','TREASURYBROKERHIST':'Historical Transactions'}" 
	        		cssStyle="width:150px!important;" name="results.defaultView">
	        	</s:select>
	        	<img alt="Loading..." id="defaultViewIndicatorId" class="defaultViewIndicator" src="${pageContext.request.contextPath}/ext/public/img/loading.gif" style="display:none;height: 20px;width: 20px">
	        </div>
       </hwfs:checkComponentPermission>
        
        <div class="form-mod">
        	<c:choose>
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
        	
			<s:url action="displayBankBidProcessDashboard.action" 
					namespace="/ext/dashboard"
					var="bankBidProcessDashboardURL" />
			<s:url action="displayBankPendingIssDashboard.action" 
					namespace="/ext/dashboard"
					var="bankPendingIssDashboardURL" />
			<s:url action="displayBankHistTransDashboard.action" 
					namespace="/ext/dashboard"
					var="bankHistoricalTransDashboardURL" />
			<s:url action="displayBrokerBidProcessDashboard.action" 
					namespace="/ext/dashboard"
					var="brokerBidProcessDashboardURL" />
			<s:url action="displayBrokerPendingIssDashboard.action" 
					namespace="/ext/dashboard"
					var="brokerPendingIssDashboardURL" />
			<s:url action="displayBrokerHistTransDashboard.action" 
					namespace="/ext/dashboard"
					var="brokerHistoricalTransDashboardURL" />		
			
			<ul class="nav nav-tabs tabs uppercase" >
				<hwfs:checkComponentPermission name="BankDashBoardAccess" domainName="BusinessAccess"> 
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
		        </hwfs:checkComponentPermission>
                <hwfs:checkComponentPermission name="BrokerDashBoardAccess" domainName="BusinessAccess"> 
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
		        </hwfs:checkComponentPermission>
			</ul>					        	
        	<div class="tab-content" id="myDashboardTabContent">
        		<hwfs:checkComponentPermission name="BankDashBoardAccess" domainName="BusinessAccess">
        		<div id="BankBidProcessDiv" class="tab-pane fade ${bankBidProcessTab}">
        			<c:if test="${dashboardViewType eq 'BANKBIDPROCESS'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="BidProcessBank"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BidBankSearchResult.jsp"/>
					</c:if>
        		</div>
        		<div id="BankPendingIssDiv" class="tab-pane fade ${bankPendingIssTab}">
        			<c:if test="${dashboardViewType eq 'TREASURYBANKPENDINGINCE'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="BankPendingInce"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BankIssuancePenSearchResult.jsp"/>
					</c:if>
        		</div>
        		<div id="BankHistoricTransDiv" class="tab-pane fade ${bankHistoricTransTab}">
        			<c:if test="${dashboardViewType eq 'TREASURYBANKHIST'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="BankHistoricTrans"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BankHistoricTransSearchResult.jsp"/>
					</c:if>
        		</div>
        		</hwfs:checkComponentPermission>
        		<hwfs:checkComponentPermission name="BrokerDashBoardAccess" domainName="BusinessAccess">
        		<div id="BrokerBidProcessDiv" class="tab-pane fade ${brokerBidProcessTab}">
        			<c:if test="${dashboardViewType eq 'TREASURYBROKERBIDPROCESS'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="BidProcessBroker"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BidBankSearchResult.jsp"/>
					</c:if>
        		</div>
        		<div id="BrokerPendingIssDiv" class="tab-pane fade ${brokerPendingIssTab}">
        			<c:if test="${dashboardViewType eq 'TREASURYBROKERPENDINGINCE'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="BrokerPendingInce"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BrokerIssuancePenSearchResult.jsp"/>
					</c:if>
        		</div>
        		<div id="BrokerHistoricTransDiv" class="tab-pane fade ${brokerHistoricTransTab}">
        			<c:if test="${dashboardViewType eq 'TREASURYBROKERHIST'}">
        			<jsp:include page="common/basicSearchInDashboard.jsp">
						<jsp:param name="dashboardType" value="BrokerHistoricTrans"></jsp:param>
					</jsp:include>
					<jsp:include page="common/BankHistoricTransSearchResult.jsp"/>
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
        	<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/common/pagination.js"></script>
        </div>
        
<div class="clear"></div>
<div style="height:10px;"></div>
