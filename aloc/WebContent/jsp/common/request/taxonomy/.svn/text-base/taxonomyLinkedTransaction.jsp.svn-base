<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:if test="hasActionMessages()">
	<div class="row">
		<div class="span12">
			<div class="errorbox">
				<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
				<div class="errorContent"><p><s:actionmessage/></p></div>
			</div>
		</div>
	</div>
</s:if>

<s:if test="%{requestDetailsList.size>0}">
		<div class="row">
				<div class="span12">
				<h3><s:text name="label.request.linkedTransactions"/>
				    <p><b><s:text name="label.request.note"/></b><s:text name="label.request.linkedTransactionNote"/></p>
				</h3>
				<table id="tableeLinks" class="table table-striped table-bordered paginate">
             <colgroup width="110"></colgroup>
                <thead>
                  <tr>
	                   <th><s:label key="label.linkTo.dateLinked" cssStyle="color:#FFFFFF;"/></th>
	                   <th><s:label key="label.linkTo.alocRecordNumber" cssStyle="color:#FFFFFF;"/></th>
	                   <th><s:label key="label.linkTo.instrumentType" cssStyle="color:#FFFFFF;"/></th>
	                   <th><s:label key="label.linkTo.currencyCode" cssStyle="color:#FFFFFF;"/></th>
	                   <th><s:label key="label.linkTo.instrumentAmount" cssStyle="color:#FFFFFF;"/></th>
	                   <th><s:label key="label.linkTo.reqNameAndSSo" cssStyle="color:#FFFFFF;"/></th>
	                   <th><s:label key="label.linkTo.appOrPrnName" cssStyle="color:#FFFFFF;"/></th>  
	                   <th><s:label key="label.linkTo.benOrObligeeName" cssStyle="color:#FFFFFF;"/></th>
                  </tr>
                </thead>
                <tbody>
                <s:iterator value="requestDetailsList" status="stat">
	             <tr class="shown">
	             		<td><s:property value="lastSaveTime" /></td>
                        <td><s:if test="%{alocRecordId==null}">-</s:if><s:else><s:property value="alocRecordId"/></s:else></td>
                        <td><s:if test="%{instrumentType==null}">-</s:if><s:else><s:property value="instrumentType"/></s:else></td>
                        <td>
                        	<s:if test="%{instrumentTypeId == 1 || instrumentTypeId == 2}">
                        		<s:property value="instrumentDetails.instrumentCurrencyId" />
                        	</s:if>
                        	<s:if test="%{instrumentTypeId == 3}">
                        		<s:property value="bondInfo.bondCurrencyCd" />
                        	</s:if>
                        	<s:if test="%{instrumentTypeId == 4}">
                        		<s:property value="transactionDetails.docLCCurId" />
                        	</s:if>
                        </td>
                        <td>
                        	<s:if test="%{instrumentTypeId == 1 || instrumentTypeId == 2}">
                        		<s:property value="instrumentDetails.instrumentAmt" />
                        	</s:if>
                        	<s:if test="%{instrumentTypeId == 3}">
                        		<s:property value="bondInfo.bondAmount" />
                        	</s:if>
                        	<s:if test="%{instrumentTypeId == 4}">
                        		<s:property value="transactionDetails.docLCAmt" />
                        	</s:if>
                        </td>
                        <td> 
                       		<s:property value="requestorLName" />,<br />
                       		<s:property value="requestorFName" />
                        	<br/><s:property value="requestorSSO" />
                        </td>
                        <td>
							<s:if test="%{instrumentTypeId == 1 || instrumentTypeId == 2 || instrumentTypeId == 4}">
                        		<s:property value="transactionParties.tpApplicantDetails.addressDtls.name" />
                        	</s:if>
                        	<s:if test="%{instrumentTypeId == 3}">
                        		<s:property value="principal.addressDtls.name" />
                        	</s:if>
						</td>
                        <td>
                        	<s:if test="%{instrumentTypeId == 1 || instrumentTypeId == 2}">
                        		<p><s:property value="transactionParties.customer.addressDtls.name"/></p>
                        	</s:if>
                        	<s:if test="%{instrumentTypeId == 3}">
                        		<s:property value="obligee.addressDtls.name"/>
                        	</s:if>
                        	<s:if test="%{instrumentTypeId == 4}">
                        		<s:property value="beneficiaryDetails.addressDtls.name"/>
                        	</s:if>
						</td>
                    </tr>
                    </s:iterator>                                                                                          
                </tbody>
              </table>
				</div>
			</div>
</s:if>
<s:else>
	<div class="row highlighted">
		<div class="span12">
	   	 	<p><s:text name="label.request.linkedTransactionDesc"/></p>
		</div>
	</div>
</s:else>
