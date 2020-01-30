<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>				
	       <p class="left clear dashdesc" style="width:100%;"><s:text name="label.dashboard.bundle.approvalRecords"/></p>				
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
					                			<s:date name="instrumentDetails.expiryDt" format="MMM dd, yyyy"/><br />
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
				