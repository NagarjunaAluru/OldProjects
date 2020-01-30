<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				<a href="#" class="right popupClose">X</a>
				<h2><s:text name="label.dashboard.link.linkId" /> : &nbsp;<s:property value="linkId"/></h2>
				<hr class="h2-hr">
				 <table class="table table-striped table-bordered linkTransactionTable">
				       <thead>
				                  <tr id="column_head" style="display: table-row;">
				                    <th class="bgtr"><s:text name="label.dashboard.link.actions"/> </th>
				                    <th class="bgtr"><s:text name="label.dashboard.tableHeader.alocRecordNo"/> </th>
				                    <th class="bgtr"><s:text name="label.dashboard.tableHeader.instrumentType"/>  </th>
				                    <th class="bgtr"><s:text name="label.advanceSearch.field.bankReferenceNumber"/> </th>				                   
				                  </tr>
				        </thead>								       				               
				         <tbody>
				          <s:iterator value="requestDetailsList">	
								<c:set var="rowIdValue" value=""></c:set>
					        	<c:choose>
						        	<c:when test="${instrumentTypeId eq '4'}">
						        		<c:set var="rowIdValue" value="docRow"></c:set>
						        	</c:when>
						        	<c:when test="${instrumentTypeId eq '3' or instrumentTypeId eq '6'}">
						        		<c:choose>
						        			<c:when test="${bondDetails.bondTypeId eq '1'}">
						        				<c:set var="rowIdValue" value="bidsRow"></c:set>
						        			</c:when>
						        			<c:otherwise>
						        				<c:choose>
						        					<c:when test="${bondDetails.bondTypeId eq '2' and (bondDetails.subBondTypeId != null && bondDetails.subBondTypeId eq '4')}">
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
									<td width="10%" id="${rowIdValue}">				
									<s:url action="unLinkTransaction.action" namespace="/int/linkto" var="unLinkRequestURL" >
                						<s:param name="requestId"><s:property value="requestId"/></s:param>
                					</s:url>
                						<a href='<s:property value='#unLinkRequestURL'/>'><s:text name="label.dashboard.link.unlink"/></a>
									</td>
									<td width="10%"><s:property value="alocRecordId"/></td>
									<td width="10%"><s:property value="instrumentType"/></td>
									<td width="10%">
									<c:choose>
										<c:when test="${not empty bankRefNumber}">
											<s:property value="bankRefNumber"/>
										</c:when>
										<c:otherwise>
												-
										</c:otherwise>
									</c:choose>
									</td>												
								</tr>	
							</s:iterator>		
						</tbody>				
					</table><br>	
					
					<script type="text/javascript">
					$(document).ready(function(){
						$(".linkTransactionTable tbody tr:odd").addClass("odd");
						$(".linkTransactionTable tbody tr:even").addClass("even");
					});
					</script>