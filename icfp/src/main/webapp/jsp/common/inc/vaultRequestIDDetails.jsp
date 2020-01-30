<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
	<!-- Modals start -->
			<div class="modal-header">
				<a class="close" href="javascript:closeVaultRequestScreenIDModal()">X</a>
				<h3>Select Vault Request ID<span></span></h3>
			</div>
			 <input type="hidden" id="vaultDetailsID" value="false">
			<div class="modal-body" id="reaffirmApproversId">
		<!-- 	<div>
				<h4>Select the correct Vault Request ID below.<span></span></h4>
			</div> -->
			<!-- 	<div class="leader-search-results" id="leader-search-results">  -->
			<div>
				<div class="row" >
					
					<div class="span12">
					
				
						<label>Results  </label>
					<!-- 	<span  class="help-block error" id="vaultcashpoolSelect" >Please select Cash Pool </span>  -->
					<div id="vaultRequestPoolID">
							<input type="hidden" id="sizeofPoolID" name="sizeofPool" value="${requestScope.sizeOfDetails}"/>
							<input type="hidden" id="partlegoldid" name="partlegold" value="${requestScope.partlegoldid}"/>
							<input type="hidden" id="poollegoldid" name="poollegold" value="${requestScope.poollegoldid}"/>
						
						<table class="table table-striped table-bordered no-bottom" >
							<thead>
							  <tr>
								<th rowspan="2" style="width:10px;">Select</th>
								<th rowspan="2">Vault Request ID</th>
								<th colspan="2" class="nosort">Participant</th>
								<th colspan="2" class="nosort">Pool Leader</th>
								<!-- <th>Cash Pool Name</th> -->
								<th rowspan="2">Pool Region</th>
								<th rowspan="2">Pool Country</th>
								<th rowspan="2">Pool Currency</th>
							  </tr>
							  <tr>
							    <th>CDR</th>
							    <th>Legal Entity GOLD ID</th>
							    <th>CDR</th>
							    <th>Legal Entity GOLD ID</th>
							  </tr>
							</thead>
							<tbody>
							
							
							<logic:present name="vaultDetails" scope="request" >
								<logic:iterate id="vaultInfo" name="vaultDetails" scope="request" indexId="i">
									<tr>
									<td><input type="radio" name="cashPoolOptions" id="optionsRadiosID" onclick="changeFlag()" value="${vaultInfo.poolLeader.LEGoldID}"></td>
									 	<td>${vaultInfo.vaultRequestID}</td>
										<td>${vaultInfo.participant.CDR}</td>
										<td>${vaultInfo.participant.LEGoldID}</td>
										<td>${vaultInfo.poolLeader.CDR}</td>
										<td>${vaultInfo.poolLeader.LEGoldID}</td> 
										<td>${vaultInfo.poolRegion}</td>
										<td>${vaultInfo.poolCountry}</td>
										<td>${vaultInfo.poolCurrency}</td> 
										
									</tr>
								</logic:iterate>
							</logic:present>
							</tbody>
						</table>
						</div>
					</div>
				</div>
			</div>
				
			</div>
			<div class="modal-footer">
				<a href="#" class="btn right btn-success" id="reaffirmationId" onclick="javascript:getVaultPoolDetails();">Save Selection</a>
				<a href="javascript:closeVaultRequestScreenIDModal()" class="btn-link right cancel">Close window</a>
			</div>
