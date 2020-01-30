<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
						<s:label key="label.siteAdmin.businessAdminDelegationNote" />
                    	<table class="table table-striped table-bordered" id="siteSummaryTblId">
                        <colgroup width="100px"></colgroup>
                        <colgroup width="140px"></colgroup>
                        <colgroup width="100px"></colgroup>
                        <colgroup width="100px"></colgroup>
                        <colgroup width="100px"></colgroup>
                        <colgroup width="100px"></colgroup>
                        <colgroup width="100px"></colgroup>
                        <thead>
                          <tr>
                            <th><s:text  name="label.siteAdmin.instrument"/></th>
                            <th><s:text  name="label.siteAdmin.instrumentAmount"/></th>
                            <th><s:text  name="label.siteAdmin.notificationClause"/></th>
                            <th><s:text  name="label.siteAdmin.curePeriodIndicator"/></th>
                            <th><s:text  name="label.siteAdmin.geApprovalOfDraw"/></th>
                            <th><s:text  name="label.siteAdmin.approverGroupAssignment"/></th>
                          </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="siteAdmin.delegationConfiguration.delegationConfigs">
                            <tr>
                            	<td>
	                            	<s:iterator value="instruments">
	                                	<s:property value="instr"/><br/>
	                                </s:iterator>
                                </td>
                                <td>
	                                <s:if test="%{instrBaseAmt eq '.00'}">
	                                	0
	                                </s:if>
	                                <s:else>
	                                	<s:property value="instrBaseAmt"/>
	                                </s:else>
	                                	
	                                <br>To<br>
	                                
	                                <s:if test="%{instrEndAmt eq '.00'}">
	                                	0
	                                </s:if>
	                                <s:else>
	                                	<s:property value="instrEndAmt"/>
	                                </s:else>
	                                <br>
                                </td>
                                <td><s:property value="notificationCaluseFlag"/></td>
                                <td><s:property value="curePeriodIndicatorFlag"/></td> 
                                <td><s:property value="GEAppDrawFlag"/></td>
                                <td>
	                                <s:iterator value="groupAssignments">
	                                	<s:property value="groupName"/><br/>
	                                </s:iterator>
                                </td>
                            </tr> 
                            </s:iterator>
                         </tbody>
                      </table>
            
