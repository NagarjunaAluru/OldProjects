<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

					<div class="span12">
		                <label><s:label  key="label.siteAdmin.selectedApprovers"/></label>
						 <table class="table table-striped table-bordered" id="selectedApprovers">
							<thead>
							  <tr>
								<th><s:text  name="label.common.siteAdmin.name"/></th>
							  </tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<label class="checkbox">
											<s:checkboxlist name="groupApproverIds" list="selectedApprovers"  />
										</label>
									</td>
								</tr>                                                                                                 
							 </tbody>
						  </table> 
						   
						   <s:url action="saveGroupApprovers" id="addSelApprovers" />
	                       <sj:a href="%{addSelApprovers}" formIds="createDelegateConfigForm" cssClass="left btn-primary"
	                    	targets="createDelegateConfigSection" replaceTarget="true" indicator="saveSeleApp" onAfterValidationTopics="onAfterDeleg">Add Selected Approvers</sj:a>
						   
						   <s:url action="removeFromSelectedApproversList" id="remApprovers" />
	                       <sj:a href="%{remApprovers}" formIds="createDelegateConfigForm" cssClass="left btn-primary" indicator="remProcess"
	                    	targets="selectedApp" replaceTarget="true"><s:text  name="label.common.siteAdmin.remove"/></sj:a>
	                    	
	                    	<img alt="Loading..." id="remProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
	                    	<img alt="Loading..." id="saveSeleApp" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
	                    	
	                </div>

			
