<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script	type="text/javascript">
$(document).ready(function() {
	modelSort();
});
</script>

<div id="searchSort">
   	<div class="leftColSort">
       	<p id="itemsPerPage">
       	    <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items
			<a class="btn-secondary resetDefaultOrdering" href="javascript:;"><s:text name="label.dashboard.resetDefaultOrdering"/></a>       	    
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
<table class="table table-striped table-bordered paginate sortable" id="tableModel">
		<thead>
            <tr id="column_head">
                <td><s:text name="label.dashboard.tableHeader.modelAction"/></td>
                <th><s:text name="label.dashboard.tableHeader.status"/></th>
                <th><s:text name="label.dashboard.tableHeader.siteName"/></th>
                <th><s:text name="label.dashboard.tableHeader.modelName"/></th>
                <th><s:text name="label.dashboard.tableHeader.applicantPrincipal"/></th>
                <th><s:text name="label.dashboard.tableHeader.beneficiaryObligee"/></th>     
                <th><s:text name="label.dashboard.tableHeader.creator"/></th>
                <th><s:text name="label.dashboard.tableHeader.lastDateUsed"/></th>
            </tr>
        </thead>
        
        <tbody>
        	<s:if test="%{searchResult.models == null || searchResult.models.requestDetails.isEmpty()}">
        		<tr class="shown noRecord">
       	 			<td colspan="9" style="text-align:center;color:blue; size:40px;"><s:text name="label.dashboard.bundle.display"/></td>
    			</tr>
        	</s:if>
        	<s:else>
        	<s:iterator value="searchResult.models.requestDetails" status="stat">
            <tr class="shown">
                <td>
	            <s:url action="enableModel" namespace="/int/dashboard" var="enableModelURL">
  		   	        <s:param name="requestId">${requestId}</s:param>         	
                </s:url>  
                <s:url action="disableModel" namespace="/int/dashboard" var="disableModelURL">
                	<s:param name="requestId">${requestId}</s:param>         	
                </s:url>
                   <s:url action="createModelRequest.action" namespace="/int/requestor" var="newRequestURL" escapeAmp="false" encode="true">
						<s:param name="requestId">${requestId}</s:param>
						<s:param name="modelId">${modelId}</s:param>
				</s:url> 
				<s:url action="openModelRequest" namespace="/int/requestor" var="openModelURL">
	                 	<s:param name="requestId">${requestId}</s:param>         	
	            </s:url>
                <ul id="nav">
                    <li><a href="javascript:;"><img src="${pageContext.request.contextPath}/img/dropDownArrow.png" border="0"></a>
                        <div class="subs">
                        <div>
                            <ul>
                                <li>
                                    <ul>
                                     <c:choose>
	     								<c:when test="${msgHeader.auditCreator eq requestorSSO}" >
	     								 <c:if test="${modelStatus eq 'DISABLE'}">
                                        	<li><a href="<s:property value="#enableModelURL"/>"><s:text name="label.dashboard.model.enableModel" /></a></li>
                                        </c:if>
                                        <c:if test="${modelStatus eq 'ENABLE'}">
                                       		<li><a href="<s:property value="#disableModelURL"/>"><s:text name="label.dashboard.model.disableModel"/></a></li>
                                        </c:if>
	     								</c:when>
	     								<c:otherwise>
                                    	<hwfs:checkComponentPermission name="ModelAccess" domainName="BusinessAccess">
                                        <c:if test="${modelStatus eq 'DISABLE'}">
                                        	<li><a href="<s:property value="#enableModelURL"/>"><s:text name="label.dashboard.model.enableModel" /></a></li>
                                        </c:if>
                                        <c:if test="${modelStatus eq 'ENABLE'}">
                                       		<li><a href="<s:property value="#disableModelURL"/>"><s:text name="label.dashboard.model.disableModel"/></a></li>
                                        </c:if>
                                    	</hwfs:checkComponentPermission>
                                   		</c:otherwise>
                                    </c:choose>
                                    	<c:if test="${modelStatus eq 'ENABLE'}">
                                    	 <hwfs:checkComponentPermission name="CreateRequestAmendmentRiderView" domainName="BusinessAccess">
                                       		<li><a class="newRequest" href="<s:property value="#newRequestURL" />"><s:text name="label.dashboard.model.createRequest"/></a></li>
                                        </hwfs:checkComponentPermission>
                                        </c:if>
                                   <c:choose>
	     								<c:when test="${msgHeader.auditCreator eq requestorSSO}" >
	     								<c:if test="${modelStatus eq 'ENABLE'}">
	                                        	<li><a class="modifyModel" href="<s:property value="#openModelURL" />" ><s:text name="label.dashboard.model.editModel"/></a></li>
	                                    </c:if>
	     								</c:when>
	     								<c:otherwise>
	     								 <hwfs:checkComponentPermission name="ModelAccess" domainName="BusinessAccess">
	                                        <c:if test="${modelStatus eq 'ENABLE'}">
	                                        	<li><a class="modifyModel" href="<s:property value="#openModelURL" />" ><s:text name="label.dashboard.model.editModel"/></a></li>
	                                        </c:if>
	                                	</hwfs:checkComponentPermission>
	     								</c:otherwise>
                                   </c:choose>
	                                <c:choose>
	     								<c:when test="${msgHeader.auditCreator eq requestorSSO}" >
	     									<li><a href="#" id="<s:property value="requestId"/>_<s:property value="modelName"/>"	data-toggle="modal" class="deleteModel"><s:text name="label.dashboard.model.deleteModel"/></a></li>
	     								</c:when>
	     								<c:otherwise>
	     								<hwfs:checkComponentPermission name="ModelAccess" domainName="BusinessAccess">
											<li><a href="#" id="<s:property value="requestId"/>_<s:property value="modelName"/>"	data-toggle="modal" class="deleteModel"><s:text name="label.dashboard.model.deleteModel"/></a></li>
										</hwfs:checkComponentPermission>
	     								</c:otherwise>
	     							</c:choose>	                                
                                    </ul>
                                </li>
                             </ul>
                        </div>
                        </div>
                    </li>
                </ul>            
                
                </td>
                <td>
                <c:choose>
	     			<c:when test="${modelStatus eq 'ENABLE'}">
	     				Enabled</c:when>
	     			<c:otherwise>
	     			    Disabled</c:otherwise></c:choose>
	     			</td>
                <td>${not empty siteName ? siteName : '-'}</td>
                <td>
                 <s:url action="displayModelRequest" namespace="/int/requestor" var="displayModelURL">
                	<s:param name="requestId"><s:property value="requestId"/></s:param>         	
                </s:url>
                <a class="displayModel" href="<s:property value="#displayModelURL"/>">${not empty modelName ? modelName : '-'}</a></td>
                
                <td>
                	<c:choose>
                		<c:when test="${not empty applicantDetails.addressDtls.name}">
                			<c:out value="${applicantDetails.addressDtls.name}"/><br />
                		</c:when>
                		<c:when test="${not empty principal.addressDtls.name}">
                			<c:out value="${principal.addressDtls.name}"/>
                		</c:when>
                		<c:when test="${not empty transactionParties.tpApplicantDetails.addressDtls.name}">
                			<c:out value="${transactionParties.tpApplicantDetails.addressDtls.name}"/>
                		</c:when>
                		<c:otherwise>
                			-
                		</c:otherwise>
                	</c:choose>
                </td>                          
                <td>
                	<c:choose>
                		<c:when test="${not empty beneficiaryDetails.addressDtls.name}">
                			<c:out value="${beneficiaryDetails.addressDtls.name}"/>
                		</c:when>
                		<c:when test="${not empty obligee.addressDtls.name}">
                			<c:out value="${obligee.addressDtls.name}"/>
                		</c:when>
                		<c:when test="${not empty transactionParties.customer.addressDtls.name}">
                			<c:out value="${transactionParties.customer.addressDtls.name}"/>
                		</c:when>
                		<c:otherwise>
                			-
                		</c:otherwise>
                	</c:choose>
                </td>                   
                <td>
                	<c:choose>
                		<c:when test="${not empty requestorLName or not empty requestorFName or not empty requestorSSO}">
                			<c:out value="${requestorLName}"/> <c:out value="${requestorFName}"/><br><c:out value="${requestorSSO}"/>
                		</c:when>
                		<c:otherwise>
                			-
                		</c:otherwise>
                	</c:choose>
                </td>
                <td>
                	<c:choose>
                		<c:when test="${not empty modelUsedDate}">
                			<s:date name="modelUsedDate" format="dd MMM yyyy"/>
                		</c:when>
                		<c:otherwise>
                			-
                		</c:otherwise>
                	</c:choose>
               </td>
            </tr>
            </s:iterator>
            </s:else>
        </tbody>
    </table>
	<div class="clear"></div>
	<div id="searchSort">
   	 <div class="leftColSort">
		<p id="itemsPerPage1"> <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items</p>
			<p id="noItemsFound1">
    		0 items found
		</p>
	 </div>
	</div>
	<div style="height:10px;"></div>