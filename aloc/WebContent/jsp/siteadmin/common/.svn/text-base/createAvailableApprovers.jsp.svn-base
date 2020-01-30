<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

      <s:if test="(availbleApprovers != null)">
      	<div class="row">
	            <div class="span12">
	                	<label><s:text  name="label.siteAdmin.availableApprovers"/></label>
	                	<s:text  name="label.siteAdmin.availableApproversNote"/>
	                     <table class="table table-striped table-bordered" id="businessSelectedApprovers">
	                        <thead>
	                          <tr>
	                            <th colspan="4"><s:text  name="label.common.siteAdmin.name"/></th>
	                          </tr>
	                        </thead>
	                        <tbody>
	                            <tr>
	                                <td> 
	                                	<label class="checkbox">
	                                		<s:checkboxlist name="businessSelectedApprovers" list="availbleApprovers" listValue="lastName" listKey="userSso">
	                                		</s:checkboxlist>
	                                	</label>
	                                </td>
	                            </tr> 
	                         </tbody>
	                      </table> 
	                    
	                     </div>
	            </div>
	            
	             <s:url action="selectBusinessSiteApprovers" id="addSelectedApproversURL" >
	             <s:param name="siteType">create</s:param>
	             </s:url>
                 <sj:a href="%{addSelectedApproversURL}" formIds="createDelegateConfigForm" cssClass="left btn-primary" indicator="selectedProcess"
                 targets="SelectedApp" onBeforeTopics="addApproversGroup" onCompleteTopics="unselectSiteApprovers" replaceTarget="true"><s:text  name="label.common.siteAdmin.add"/></sj:a>
                    	
                 <img alt="Loading..." id="selectedProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">          
	               
            </s:if>
            <br/>
<br/>