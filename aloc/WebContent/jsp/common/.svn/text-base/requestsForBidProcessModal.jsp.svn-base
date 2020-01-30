<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		
<link href="${pageContext.request.contextPath}/css/common/dashboards.css" type="text/css" rel="stylesheet" />		
           
            <c:choose>
			  	<c:when test="${instrumentTypeId eq '1' || instrumentTypeId eq '2' || instrumentTypeId eq '4'}">
			  		<p><s:text name="label.dashboard.modal.body.selectedBank" /></p><br>
				    <p><b><s:text name="label.dashboard.modal.body.bank" /></b>&nbsp;<s:property value="issuingBankName"/>&nbsp;<s:text name="label.dashboard.modal.body.for" />
           			<s:if test="%{bundleId != null && bundleId != ''}"><s:property value="bundleId"/></s:if>
           			<s:else><s:property value="requestDetailsList[0].alocRecordId"/></s:else></p>  		
				</c:when>
				<c:otherwise>
					<p><s:text name="label.dashboard.modal.body.selectedSurety"/></p><br>
		            <p><b><s:text name="label.dashboard.modal.body.surety" /></b>&nbsp;<div style="word-wrap: break-word;"><s:property value="issuingBankName"/>&nbsp;<s:text name="label.dashboard.modal.body.for"/>&nbsp;<s:property value="requestDetailsList[0].alocRecordId"/></div></p>
				</c:otherwise>
		    </c:choose>
            <br>
				 <table class="table table-striped table-bordered">
				       <thead>
				                  <tr>				                   
				                    <th><s:text name="label.dashboard.bundle.alocRecordNumber"/></th>
				                     <th><s:text name="label.dashboard.bundle.instrumentType"/></th>				                    
				                    <th><s:text name="label.dashboard.bundle.instrumentCurrency"/></th>   
				                    <th><s:text name="label.dashboard.bundle.amount"/></th>				                                                               				                   
				                    <th><s:text name="label.dashboard.bundle.expirationDate"/></th> 				                    			                  
				                  </tr>
				        </thead>								       				               
				         <tbody>
				          <s:iterator value="requestDetailsList" status="stat">							          		         			        
						  <c:set var="rowIdValue" value=""></c:set>
				        	<c:choose>
					        	<c:when test="${instrumentTypeId eq '4'}">
					        		<c:set var="rowIdValue" value="docRow"></c:set>
					        	</c:when>
					        	<c:when test="${instrumentTypeId eq '3'}">
	        				<c:choose>
			        			<c:when test="${bondDetails.bondTypeId eq '1'}">
			        				<c:set var="rowIdValue" value="bidsRow"></c:set>
			        			</c:when>
			        			<c:otherwise>
			        				<c:choose>
			        					<c:when test="${bondDetails.bondTypeId eq '2' and bondDetails.subBondTypeId eq '4'}">
			        						<c:set var="rowIdValue" value="advanceRow"></c:set>
			        					</c:when>
			        					<c:otherwise>
			        						<c:set var="rowIdValue" value="perforRow"></c:set>
			        					</c:otherwise>
			        				</c:choose>
			        			</c:otherwise>
	        			</c:choose>
	        	</c:when>
					        	<c:otherwise>
						        	<c:choose>
						        		<c:when test="${transactionParties.instrumentPurposeId eq '1'}">
						        			<c:set var="rowIdValue" value="bidsRow"></c:set>
						        		</c:when>
						        		<c:when test="${transactionParties.instrumentPurposeId eq '12'}">
						        			<c:set var="rowIdValue" value="advanceRow"></c:set>
						        		</c:when>
						        		<c:when test="${transactionParties.instrumentPurposeId eq '13' or transactionParties.instrumentPurposeId eq '14' or transactionParties.instrumentPurposeId eq '16'}">
						        			<c:set var="rowIdValue" value="perforRow"></c:set>
						        		</c:when>
						        		<c:when test="${transactionParties.instrumentPurposeId eq '15'}">
						        			<c:set var="rowIdValue" value="financialRow"></c:set>
						        		</c:when>
						        	</c:choose>
					        	</c:otherwise>
				        	</c:choose>					        				          					        
								<tr class="shown">
									<td width="10%" id="${rowIdValue}"><s:property value="alocRecordId"/></td>
									<td width="10%"><s:property value="instrumentType"/></td>					
									<td width="10%">
										<c:choose>
						                		<c:when test="${not empty instrumentDetails.instrumentCurrencyId}">
						                			<s:property value="instrumentDetails.instrumentCurrencyId"/><br />
						                		</c:when>
						                		<c:when test="${not empty transactionDetails.docLCCurId}">
						                			<s:property value="transactionDetails.docLCCurId"/>
						                		</c:when>
						                		<c:otherwise>
						                			-
						                		</c:otherwise>
			                			</c:choose>					
                				  </td>
									<td width="10%">
										<c:choose>
					                		<c:when test="${not empty instrumentDetails.instrumentAmt}">
					                			<s:property value="instrumentDetails.instrumentAmt"/><br />
					                		</c:when>
					                		<c:when test="${not empty transactionDetails.docLCAmt}">
					                			<s:property value="transactionDetails.docLCAmt"/>
					                		</c:when>
					                		<c:otherwise>
					                			-
					                		</c:otherwise>
                					  </c:choose>	
									</td>									
									<td width="10%">
										<c:choose>
					                		<c:when test="${not empty instrumentDetails.expiryDt}">
					                			<s:date name="instrumentDetails.expiryDt" format="dd-MMM-yyyy"/>
					                		</c:when>
					                		<c:otherwise>
					                			-
					                		</c:otherwise>
                					  </c:choose>
                				  	</td>																					
								</tr>	
							</s:iterator>		
						</tbody>				
					</table>
					
			<c:if test="${instrumentTypeId eq '1' || instrumentTypeId eq '2'}"> 
			<span class="transmissionPlatformError" style="display: none;color: #AE2C2C;"><s:text name="label.dashboard.modal.body.transmissionPlatformError"/></span>
			<br>		
				<span style="font-size:18px;"><strong><s:text name="label.dashboard.modal.body.ITTransPlatform" /></strong></span>
	            <p><s:text name="label.dashboard.modal.body.sendToIssuingBank" /></p>
	            <p><s:text name="label.dashboard.modal.body.futureTransmission" /></p>	          	
	            <br>          	  
	            <div class="radio-container">
	                   <c:if test="${transmissionPlatform eq 'ALOC'}" >
	            			<s:radio cssClass="radio"
											name="transmissionPlatform"
										    theme="aloc"
											id="bidOptionID"
											list="#{'SWIFT':'SWIFT','ALOC':'ALOC'}"
											value="%{transmissionPlatform}" disabled="true"
											/>
							<s:hidden name="transmissionPlatform" value="%{transmissionPlatform}" id="transmissionPlatform"/>
	            		</c:if>
	            		 <c:if test="${transmissionPlatform eq 'SWIFT'}">
	                     <s:radio cssClass="radio"
											name="transmissionPlatform"
										    theme="aloc"
											id="bidOptionID"
											list="#{'SWIFT':'SWIFT','ALOC':'ALOC'}"
											value="%{transmissionPlatform}"
											/>
						</c:if> 
											
				</div>               
			</c:if>				