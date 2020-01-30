<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

			<p class="required-fields sixth"><s:text  name="label.common.siteAdmin.allFieldsAreRequired"/></p>
            <div class="row">
                <div class="span3a">
                    <div class="form-row">
                    	<s:radio theme="aloc" cssClass="radio"
							name="siteAdmin.bankSWIFTConfiguration.SWIFTEnabled" 
							key="label.siteAdmin.swiftEnabled" 
							tooltip="%{getText('label.siteAdmin.tooltip.swiftEnabled')}" 
							list="#{'true':'Yes','false':'No'}"
							value="%{siteAdmin.bankSWIFTConfiguration.SWIFTEnabled}"
							id="swiftEnabled" 
						/>
                    </div>
                </div>
            </div>    

            <div class="row hide" id="verify">
                <div class="span12">
                    <div class="form-row">
                        <s:checkbox name="siteAdmin.bankSWIFTConfiguration.isFileActEnabled" cssClass="checkbox" key="label.siteAdmin.verifyThatBankisFileActEnabled" tooltip="%{getText('label.siteAdmin.tooltip.fileActEnabled')}" id="fileActEnabled" theme="aloc-TransactionParties" fieldValue="true">
                        	</s:checkbox>
                    </div>
                </div>
            </div>
				
			<div class="row hide" id="bankSwiftDiv">		
				<span style="color: #990000;"><s:fielderror>
				<s:param>siteAdmin.bankSWIFTConfiguration</s:param>
				</s:fielderror></span>

                <div class="span12">
                
                 <table class="table table-striped table-bordered" id="bankswiftTbl">
                 <colgroup width="460"></colgroup>
                 <colgroup width="50"></colgroup>
                 <colgroup width="50"></colgroup>
                 <colgroup width="240"></colgroup>
                    <thead>
                      <tr>
                         <th rowspan="2" style="verticel-align:top;"><s:label theme="aloc" key="label.siteAdmin.type" cssStyle="color:#FFFFFF;" tooltip="%{getText('label.siteAdmin.tooltip.swiftType')}"/></th>
                        <th colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><s:text  name="label.siteAdmin.messageTypeSupported" /></b></th>
                        <th rowspan="2" colspan="1" width="150px"><s:label  key="label.siteAdmin.messageDirection" cssStyle="color:#FFFFFF;" /></th>
                      </tr>
                      <tr>
                        <th colspan="1" width="80px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><s:text name="label.common.siteAdmin.yes" /></b></th>
                        <th colspan="1" width="80px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><s:text name="label.common.siteAdmin.no" /></b></th>
                      </tr>
                    </thead>
                    <tbody>

              			  <s:iterator value="%{#attr['com.ge.aloc.StaticDataFactory'].swiftMessageTypes}" status="statData">
              			  	<tr>
              			  		<td><s:property value="name"/>
                					<s:hidden cssClass="msgType" name="siteAdmin.bankSWIFTConfiguration.bankSwifts[%{#statData.index}].messageTypeId" value="%{ID}"/>
              			  		</td>
	                            <td>
	                            	<s:radio theme="aloc" cssClass="messageSupport_Yes radio"
										name="siteAdmin.bankSWIFTConfiguration.bankSwifts[%{#statData.index}].messageSupport" 
										list="#{'true':'Yes'}"
										id="messageSupport1" 
									/>
	                            <td>
	                            	<s:radio theme="aloc" cssClass="messageSupport_No radio"
										name="siteAdmin.bankSWIFTConfiguration.bankSwifts[%{#statData.index}].messageSupport"
										list="#{'false':'No'}" 
										id="messageSupport2" 
									/>
	                            <td>
	                              <s:set var="msgDirID" value="%{ID}" />
	                              <c:choose>
	                              <c:when test="${msgDirID == 1 || msgDirID == 6}">
	                              <s:select list="#{'Inbound':'Inbound','Outbound':'OutBound', 'Bi-Directional':'Bi-Directional'}" 
										id="messageDirection" 
										name="siteAdmin.bankSWIFTConfiguration.bankSwifts[%{#statData.index}].messageDirection"
										theme="aloc"
										style="display:none"
										cssClass="messageDirClass"
										headerKey=""
										headerValue="Select..."
									/>
	                              </c:when>
	                              <c:when test="${msgDirID == 2 || msgDirID == 4 || msgDirID == 7 || msgDirID == 9}">
	                              <s:select list="#{'Outbound':'OutBound'}" 
										id="messageDirection" 
										name="siteAdmin.bankSWIFTConfiguration.bankSwifts[%{#statData.index}].messageDirection"
										theme="aloc"
										style="display:none"
										cssClass="messageDirClass"
										readOnly="true"
									/>
	                              </c:when>
	                              <c:when test="${msgDirID == 3 || msgDirID == 5 || msgDirID == 8 || msgDirID == 10}">
	                              <s:select list="#{'Inbound':'Inbound'}" 
										id="messageDirection" 
										name="siteAdmin.bankSWIFTConfiguration.bankSwifts[%{#statData.index}].messageDirection"
										theme="aloc"
										style="display:none"
										cssClass="messageDirClass"
										readOnly="true"
									/>
	                              </c:when>
	                              </c:choose>
								</td>
	                         </tr>
              			  </s:iterator>
                     </tbody>
                  </table> 
                                
                </div>
             </div> 
