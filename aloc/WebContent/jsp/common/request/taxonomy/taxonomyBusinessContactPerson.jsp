<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


	<c:choose>
	 <c:when test="${param.page eq 'Taxonomy'}">
	  <s:if test="%{requestDetails.WFDetails.WFStage == 'REQEST' && requestDetails.buContactPerson.requiresEdits}">
			<div class="row">
				<div class="span12">
					<div class="errorbox">
						<div class="noteHead">
							<p class="noteicon">
								<s:text name="label.common.alert" />
							</p>
						</div>
						<div class="noteContent">
							<p>
								<s:property value="requestDetails.buContactPerson.sendBackNotes" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>
		
		<c:if test="${not empty requestDetails.siteName}">
     		<div class="row">
				<div class="span12">
					<div class="form-row">
						<p style="padding: 2px 0;">
							<b><s:text name="label.request.selectedSite"/></b> 
							<span style="padding-left: 40px;"><s:property value="requestDetails.siteName"/></span>
							<s:hidden name="requestDetails.transactionParties.siteName" value="%{requestDetails.siteName}"></s:hidden>
							<s:hidden name="siteId" value="%{requestDetails.siteId}"></s:hidden>
						</p>
					</div>
				</div>
			</div>
		</c:if>
	
		<div class="row">
			<div class="span12">
				<div class="form-row" style="padding-top:5px;padding-left: 20px; margin-bottom: 0px;">
					<c:if test="${empty requestDetails.buContactPerson  or empty requestDetails.buContactPerson.buRequestors}">
						<c:set var="bucontactRefIndex" value="0"></c:set>
					</c:if>
					<c:if test="${not empty requestDetails.buContactPerson.buRequestors}">
						<c:set var="bucontactRefIndex" value="${fn:length(requestDetails.buContactPerson.buRequestors)}"></c:set>
						<c:if test="${bucontactRefIndex gt 0}">
							<c:set var="bucontactRefIndex" value="${bucontactRefIndex - 1}"></c:set>
						</c:if>
					</c:if>
					<input type="hidden" id="buContactPersonFieldAddIndexId" name="buContactPersonFieldAddIndex" 
					class="referenceIndex" value="${bucontactRefIndex}">
					<input type="hidden" name="sectionName" class="sectionName" value="buContactPerson">
                   	<table style="border: 0; width: 100%;" id="additionalBUContactRef" class="additionalTable">
                   		<tbody>
                       	<tr>
                       		<td height="1" class="noPadding">
                       		
								<!-- lookup1 started -->                       		
                             	<c:if test="${empty requestDetails.buContactPerson.buRequestors[0].name}">
									<c:set var="businessClass" value="conditional-row"/>
									<c:set var="businessClearStyle" value="display: none;"/>
								</c:if>
								<c:if test="${not empty requestDetails.buContactPerson.buRequestors[0].name}">
									<c:set var="businessClass" value=""/>
									<c:set var="businessClearStyle" value="display: inline;"/>	
									<s:set var="requestornameSelected" value="%{'Yes'}"></s:set>
								</c:if>
								<div class="row">
									<div class="form-row">
										<div class="span4 left" style="width:240px;">
											<s:textfield name="businessContactPerson" 
												 key="label.request.contactName" 
												 theme="aloc" cssClass="span3 lookup-filterValue buLookUp"
												 id="businessContactPersonId"/>
											<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
											<div><p><s:text name="label.request.partialLastName" /></p></div>
											<span class="lookup-error hide" style="color: #AE2C2C;"></span>
										</div>
										<div class="span2 left">
											<label>&nbsp;</label>
											<s:url action="BusinessContactPersonLookup" namespace="/int" id="getBusinessContactPersonURL">
												<s:param name="lookUpNumber" value="1"></s:param>
											</s:url>
											<a class="btn-secondary lookup" href="<s:property value="#getBusinessContactPersonURL"/>" ><s:text name="label.request.common.lookup"/></a>
											<img alt="Loading..." id="bcpIndicator"	class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display: none">
										</div>
									</div>
								</div>
								
								<div class="${businessClass}" id="businessShow">
										<s:hidden name="businessContactPersonSelection" id="businessSelectionId" value="%{#requestornameSelected}" cssClass="reqBuLookup"></s:hidden>
											<div class="row smallrow">
												<div class="span7" style="padding-left: 20px;">
												    <div class="row smallrow">
														<div class="span2 left">
															<div class="form-row">
																<s:label key="label.request.names" id=""/>
															</div>
														</div>
														<div class="span5 left">
															<div class="form-row">
																<p>
																	<s:property value="requestDetails.buContactPerson.buRequestors[0].name" />-SSO<<s:property value="requestDetails.buContactPerson.buRequestors[0].ssoId"/>> 
																</p>
																<s:hidden name="requestDetails.buContactPerson.buRequestors[0].name"
																	id="bcpName" cssClass="name"></s:hidden>
															</div>
														</div>
													</div>
													<div class="row smallrow">
														<div class="span2 left">
															<div class="form-row">
																<s:label key="label.request.phone" />
															</div>
														</div>
														<div class="span2 left">
															<div class="form-row">
																<p>
																	<s:property value="requestDetails.buContactPerson.buRequestors[0].phoneNumber" />
																</p>
																<s:hidden name="requestDetails.buContactPerson.buRequestors[0].phoneNumber"
																	id="phoneNumber" cssClass="phone"></s:hidden>
															</div>
														</div>
													</div>
													<div class="row smallrow">
														<div class="span2 left">
															<div class="form-row">
																<s:label key="label.request.email" />
															</div>
														</div>
														<div class="span2 left">
															<div class="form-row">
																<p>
																	<s:property value="requestDetails.buContactPerson.buRequestors[0].emailAddr" />
																</p>
																<s:hidden name="requestDetails.buContactPerson.buRequestors[0].emailAddr"
																	id="emailAddr" cssClass="email"></s:hidden>
																<s:hidden name="requestDetails.buContactPerson.buRequestors[0].ssoId" id="tpApplicantBCPSSO" />	
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>	
								<!-- lookup1 ended -->
		
                            </td>
						</tr>
                        <c:if test="${not empty requestDetails.buContactPerson.buRequestors and bucontactRefIndex >= 1}">
                        <c:forEach items="${requestDetails.buContactPerson.buRequestors}" begin="1" varStatus="statIndex">
                        <tr class="optional2">
                           	<td height="1" class="noPadding">
                           	<c:if test="${statIndex.count eq 1}">
                           	
                           	<!-- lookup2 started -->
					   		<c:if test="${empty requestDetails.buContactPerson.buRequestors[1].name}">
								<c:set var="businessClass1" value="conditional-row"/>
								<c:set var="businessClearStyle1" value="display: none;"/>
							</c:if>
							<c:if test="${not empty requestDetails.buContactPerson.buRequestors[1].name}">
								<c:set var="businessClass1" value=""/>
								<c:set var="businessClearStyle1" value="display: inline;"/>	
								<s:set var="requestornameSelected1" value="%{'Yes'}"></s:set>
							</c:if>
						      
						    <div class="row">
									<div class="form-row">
										<div class="span4 left" style="width:240px;">
											<s:label key="label.request.contactName2" cssClass="optional"></s:label>
											<s:textfield required="false" theme="aloc" cssClass="span3 lookup-filterValue referenceTextValue" id="businessContactPersonId2"/>
											<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
											<span class="lookup-error hide" style="color: #AE2C2C;"></span>
										</div>	
										<div class="span2 left" style="width:240px;">
											<label>&nbsp;</label>
											<s:url action="BusinessContactPersonLookup" namespace="/int"	id="getBusinessContactPersonURL">
												<s:param name="lookUpNumber" value="2"></s:param>
											</s:url>
											<a class="btn-secondary lookup" href="<s:property value="#getBusinessContactPersonURL"/>" ><s:text name="label.request.common.lookup"/></a>
											<img alt="Loading..." id="bcpIndicator2"	class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display: none">
												&nbsp;&nbsp;&nbsp;<a href="javascript:;" class="deleteBCP-ce" >Remove Contact name</a> 
										</div>
									</div>
							</div>
							<div class="${businessClass1}" id="businessShow1">
								<s:hidden name="businessSelection1" id="businessSelectionId1" value="%{#requestornameSelected1}" cssClass="businessSelection"></s:hidden>
									<div class="row smallrow">
										<div class="span7" style="padding-left: 20px;">
										    <div class="row smallrow">
												<div class="span2 left">
													<div class="form-row">
														<s:label key="label.request.names" />
													</div>
												</div>
												<div class="span5 left">
													<div class="form-row">
														<p>
															<s:property value="requestDetails.buContactPerson.buRequestors[1].name" />-SSO< <s:property value="requestDetails.buContactPerson.buRequestors[1].ssoId"/>>
														</p>
														<s:hidden name="requestDetails.buContactPerson.buRequestors[1].name"
															id="bcpName1" cssClass="name"></s:hidden>
													</div>
												</div>
											</div>
											<div class="row smallrow">
												<div class="span2 left">
													<div class="form-row">
														<s:label key="label.request.phone" />
													</div>
												</div>
												<div class="span2 left">
													<div class="form-row">
														<p>
															<s:property value="requestDetails.buContactPerson.buRequestors[1].phoneNumber" />
														</p>
														<s:hidden name="requestDetails.buContactPerson.buRequestors[1].phoneNumber"
															id="phoneNumber1" cssClass="phone"></s:hidden>
													</div>
												</div>
											</div>
											<div class="row smallrow">
												<div class="span2 left">
													<div class="form-row">
														<s:label key="label.request.email" />
													</div>
												</div>
												<div class="span2 left">
													<div class="form-row">
														<p>
															<s:property value="requestDetails.buContactPerson.buRequestors[1].emailAddr" />
														</p>
														<s:hidden name="requestDetails.buContactPerson.buRequestors[1].emailAddr"
															id="emailAddr1" cssClass="email"></s:hidden>
														<s:hidden name="requestDetails.buContactPerson.buRequestors[1].ssoId" id="tpApplicantBCPSSO1" cssClass="ssoId"></s:hidden>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>	

							</c:if>
							<c:if test="${statIndex.count eq 2}">
							
							<!-- lookup3 started -->
				      		<c:if test="${empty requestDetails.buContactPerson.buRequestors[2].name}">
								<c:set var="businessClass2" value="conditional-row"/>
								<c:set var="businessClearStyle2" value="display: none;"/>
							</c:if>
							<c:if test="${not empty requestDetails.buContactPerson.buRequestors[2].name}">
								<c:set var="businessClass2" value=""/>
								<c:set var="businessClearStyle2" value="display: inline;"/>	
								<s:set var="requestornameSelected2" value="%{'Yes'}"></s:set>
							</c:if>
							     
						     <div class="row">
									<div class="form-row">
										<div class="span4 left" style="width:240px;">
											<s:label key="label.request.contactName3" cssClass="optional"></s:label>
											<s:textfield required="false" theme="aloc" cssClass="span3 lookup-filterValue referenceTextValue" id="businessContactPersonId3"/>
											<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
											<span class="lookup-error hide" style="color: #AE2C2C;"></span>
										</div>	
										<div class="span2 left" style="width:240px;">
											<label>&nbsp;</label>
											<s:url action="BusinessContactPersonLookup" namespace="/int"	id="getBusinessContactPersonURL">
												<s:param name="lookUpNumber" value="3"></s:param>
											</s:url>
											<a class="btn-secondary lookup" href="<s:property value="#getBusinessContactPersonURL"/>" ><s:text name="label.request.common.lookup"/></a>
											<img alt="Loading..." id="bcpIndicator2"	class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display: none">
												&nbsp;&nbsp;&nbsp;<a href="javascript:;" class="deleteBCP-ce" >Remove Contact name</a>  
										</div>
									</div>
								</div>
								<div class="${businessClass2}" id="businessShow2">
									<s:hidden name="businessSelection2" id="businessSelectionId2" value="%{#requestornameSelected2}" cssClass="businessSelection"></s:hidden>
										<div class="row smallrow">
											<div class="span7" style="padding-left: 20px;">
											    <div class="row smallrow">
													<div class="span2 left">
														<div class="form-row">
															<s:label key="label.request.names" />
														</div>
													</div>
													<div class="span5 left">
														<div class="form-row">
															<p>
																<s:property value="requestDetails.buContactPerson.buRequestors[2].name" />-SSO< <s:property value="requestDetails.buContactPerson.buRequestors[2].ssoId"/>>
															</p>
															<s:hidden name="requestDetails.buContactPerson.buRequestors[2].name"
																id="bcpName2" cssClass="name"></s:hidden>
														</div>
													</div>
												</div>
												<div class="row smallrow">
													<div class="span2 left">
														<div class="form-row">
															<s:label key="label.request.phone" />
														</div>
													</div>
													<div class="span2 left">
														<div class="form-row">
															<p>
																<s:property value="requestDetails.buContactPerson.buRequestors[2].phoneNumber" />
															</p>
															<s:hidden name="requestDetails.buContactPerson.buRequestors[2].phoneNumber"
																id="phoneNumber2" cssClass="phone"></s:hidden>
														</div>
													</div>
												</div>
												<div class="row smallrow">
													<div class="span2 left">
														<div class="form-row">
															<s:label key="label.request.email" />
														</div>
													</div>
													<div class="span2 left">
														<div class="form-row">
															<p>
																<s:property value="requestDetails.buContactPerson.buRequestors[2].emailAddr" />
															</p>
															<s:hidden name="requestDetails.buContactPerson.buRequestors[2].emailAddr"
																id="emailAddr2" cssClass="email"></s:hidden>
															<s:hidden name="requestDetails.buContactPerson.buRequestors[2].ssoId" id="tpApplicantBCPSSO2" cssClass="ssoId"></s:hidden>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>	
					      	<!-- lookup3 ended -->
					      	   
								</c:if>
                           	</td>
                        </tr>
                        </c:forEach>
                        </c:if>
						</tbody>
					</table>
                       <a href="javascript:;" class="add-exception" id="addadditionalBUContactRef" 
                       style="display: ${bucontactRefIndex < 2 ? 'block' : 'none'}; margin-top: -10px;margin-left: -20px;"><s:text  name="label.request.addContactPerson"/></a>
					
				</div>
			</div><!-- end of block -->
		</div>
		</c:when>
		
		<c:otherwise>
            <s:iterator value="requestDetails.buContactPerson.buRequestors" status="stat">	
				<div class="row">
	               <div class="span3b">
						<div class="form-row">
							<label><s:text name="label.request.contactName" />&nbsp;<s:property value="#stat.count" />:</label>
						</div>
			        </div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><s:property value="name"/></p>
							<p class="padding40"><s:property value="phoneNumber"/></p>
							<p class="padding40"><s:property value="emailAddr"/></p>
						</div>
			        </div>
			    </div>	
		    </s:iterator>
		    <c:if test="${requestDetails.WFDetails.WFStage eq 'REQEST'}">
		    <s:if test="%{requestDetails.buContactPerson.requiresEdits}">
					<div class="row">
						<div class="span3b">
							<div class="form-row">
								<label> <s:text name="label.request.Sendbacknotes" /> :
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<s:property
										value="requestDetails.buContactPerson.sendBackNotes" />
								</p>
							</div>
						</div>

					</div>
					</s:if>	 
				</c:if>   
		</c:otherwise>
	</c:choose>