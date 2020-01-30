<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		

<div class="row">      
		<div class="span12" id="blockBUCNameDiv">
		<div id="searchSort">
								   	<div class="leftColSort">
								       	<p id="itemsPerPage">
								       	    <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items
								       	</p>
								       	<p id="noItemsFound">
								    		0 items found
										</p>
								    </div>
								    <div class="rightColSort">
								         	Show&nbsp;&nbsp;
										<select class="pagination-rows">
										<option>10</option>
										<option>20</option>
										<option>30</option>
										<option>40</option>
										<option>50</option>
										</select>&nbsp;&nbsp;results
								    </div>
					                <div class="clear"></div>
		 </div>		
				<table id="blockBUCNamesTable" class="table table-striped table-bordered no-bottom paginate">
				<colgroup width="30"></colgroup>				
					<thead>
						  <tr>
								<th><s:text name="label.blockbucmgmt.action" /></th>
								<th><s:text name="label.blockbucmgmt.businessUnitCode" /></th>
								<th><s:text name="label.blockbucmgmt.accountingdistributionnumber" /></th>
								<th><s:text name="label.blockbucmgmt.notes" /></th>
								<th><s:text	name="label.blockbucmgmt.dateBlocked" /></th>
								<th><s:text	name="label.blockbucmgmt.blockedBy" /></th>
						  </tr>
						</thead>						
					<tbody id="addNewTbodyId">
					<s:if test="%{businessUnitCodeList.businessUnitCodes == null || businessUnitCodeList.businessUnitCodes.isEmpty}">
						<tr class="shown noRecord">
							<td colspan="6" style="text-align:center;color:blue; size:40px;"><s:text name="label.blockbucmgmt.noBlockedBUCs" /></td>
						</tr>
					</s:if>
					<s:else>
			        		<s:iterator value="businessUnitCodeList.businessUnitCodes" status="blockBUCStat">
								<tr class="shown">
									<td class="BUC">
										<a href="javascript:;" class="btn-tertiary cancel" onclick="javascript:popUpUnBlockSelectedBUC('<s:property value="BUC"/>','<s:property value="ADN"/>')" 
											id="unblockBUCId" data-toggle="modal">
											<s:text	name="label.blockbucmgmt.unblock"/>
										</a>
									</td>
									<td class="buc"><s:property value="BUC" /></td>
									<td class="adn"><s:property value="ADN" /></td>
									<td style="word-wrap: break-word;"><div style="width: 300px; overflow: auto;"><s:property value="notes" /></div></td>
									<td style="width: 70px;"><s:property value="dateBlocked" /></td>
									<td class="BlockedBy"><s:property value="blockedByFirstNm" />,<s:property value="blockedByLastNm" />-<s:property value="blockedBySso" /></td>
								</tr>
							</s:iterator>
				  </s:else>
          </tbody>
	 </table>
</div>
</div>

<div id="searchSort">
	   	<div class="leftColSort">
			<p id="itemsPerPage1"> <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items</p>
			<p id="noItemsFound1">
    			0 items found
			</p>
		</div>
</div>
 <div class="clear"></div>
   <!-- PAGE NAVIGATION STARTS HERE -->
	      <div class="row">
	          <div class="span right">
	          	<div class="pagenavi left">
	          	
	              </div>
	              <div class="right">
	               Jump to
				<input type="text" class="span1 manual">
				<a class="btn btn-success-blue" type="submit">Go</a>
	              </div>
	          </div>
	      </div>
	      <input type='hidden' id='current_page' />
	      <script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
	<!-- PAGE NAVIGATION ENDS HERE -->
		  <div class="clear"></div>
				 