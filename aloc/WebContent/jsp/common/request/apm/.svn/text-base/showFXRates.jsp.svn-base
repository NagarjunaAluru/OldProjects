<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

 <link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/css/common/site.css" type="text/css" rel="stylesheet" />
  <script src="${pageContext.request.contextPath}/js/requestor/apm.js" type="text/javascript"></script>
  

<div id="payment">
					<div class="span12">
						<div class="row">
							<div class="span12">
								<h3><s:text name="label.request.results" /> <span class="right"><a href="javascript:;" onclick="printContent('printFXRates')"><img src="${pageContext.request.contextPath}/img/print.gif" border="0" /></a></span></h3>	
								<p><s:property value="apmDetails.FXRateHistoryAndCurrencySetup.FXRateHistory.getFXRates.size"/>  <s:text name="label.request.fxRatesHaveBeenDownloadedForTheFollowingPeriod" /> - <span class="FXperiod"></span></p>
								<hr class="hr3" />	
							<div class="row">
							<div class="span6 left active" id="printFXRates">
								<div id="searchSort">
								   	<div class="leftColSort" style="width: 150px;">
								       	<p id="itemsPerPage">
								       		Showing <span id="start"></span> - <span id="end"></span> of <span id="total"></span> results
								       	</p>
								       	<p id="noItemsFound">
								    		0 items found
										</p>
								    </div>
								    <div class="rightColSort" style="width: 150px;">
								         	Show&nbsp;&nbsp;
										<select class="pagination-rows">
										<option>10</option>
										<option selected="selected">20</option>
										<option>30</option>
										<option>40</option>
										<option>50</option>
										</select>&nbsp;&nbsp;results
								    </div>
									<div class="clear"></div>
								</div>
								<table class="table table-striped table-bordered sortable no-bottom active paginate" >
									<thead>
										<tr>
											<th colspan="1"><span style="font-weight: bold;"><s:text name="label.request.currencyCode" /></span> </th>
											<th colspan="1"><span style="font-weight: bold;"><s:text name="label.request.fxRate" /> </span></th>
											<th colspan="1"><span style="font-weight: bold;"><s:text name="label.request.fxRateSource" /></span> </th>
											<th colspan="1"><span style="font-weight: bold;"><s:text name="label.request.fxRateDate" /></span> </th>
										</tr>
									</thead>
									<tbody>	
									<s:if test="%{apmDetails.FXRateHistoryAndCurrencySetup.FXRateHistory.getFXRates.isEmpty()}">
						        		<tr class="shown noRecord">
						       	 			<td colspan="4" style="text-align:center;color:blue; size:40px;">Nothing to Display</td>
						    			</tr>
						        	</s:if>
									 <s:iterator value="apmDetails.FXRateHistoryAndCurrencySetup.FXRateHistory.getFXRates">	
										<tr class="shown">
											<td><s:property value="currencyCode"/></td>
											<td><s:property value="FXRate"/></td>
											<td><s:property value="FXRateSource"/></td>
											<td><s:property value="FXRateDate"/></td>
										</tr>
										</s:iterator>
									</tbody>
								</table>
								<div class="clear"></div>
									<p>&nbsp;</p>
									<div id="searchSort">
									   	<div class="leftColSort">
											<p id="itemsPerPage1">Showing <span id="start"></span> - <span id="end"></span> of <span id="total"></span> results</p>
											<p id="noItemsFound1">
									    		0 items found
											</p>
										</div>
									</div>
									<p>&nbsp;</p>
							</div>
						</div>
								<br />
								<s:url id="downloadURL" action="downloadResultExport" namespace="/int/apm">
								<s:param name="feePeriodId"><s:property value="apmDetails.FXRateHistoryAndCurrencySetup.FXRateHistory.feePeriodDetails[0].APMConfigID"/></s:param>
								</s:url>
								<hwfs:checkComponentPermission name="RateHistoryView" domainName="BusinessAccess">
									<s:a href="%{downloadURL}"
										cssClass="dwnbtn btn-secondary" >
									<s:text name="label.request.downloadFXRates"/>
									</s:a>
								</hwfs:checkComponentPermission>
							
								  <div class="clear"></div>
							     <div class="row" id="hideLessthan10">
											<!-- pagination pagination-right -->
										       <div class="span right">
										       	<div class="pagenavi left">	
										       			       		
										       	</div>
										    	<div class="span3 jump-page">
													Jump to
													<input type="text" class="span1 manual">
													<a class="btn btn-success-blue" type="submit">Go</a>
												</div>
											</div>
								 </div> 
								 <input type='hidden' id='current_page' />
								  <script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>  
								  
								
							</div>
						</div>
						
					</div>
				</div>