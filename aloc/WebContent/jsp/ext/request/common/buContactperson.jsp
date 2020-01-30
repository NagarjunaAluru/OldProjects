<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<td height="1" class="noPadding"><c:if
		test="${not empty param.buContactPersonFieldAddIndex}">
		<c:choose>
			<c:when test="${param.buContactPersonFieldAddIndex eq 1}">

				<c:if
					test="${empty requestDetails.buContactPerson.buRequestors[1].name}">
					<c:set var="businessClass1" value="conditional-row" />
					<c:set var="businessClearStyle1" value="display: none;" />
				</c:if>
				<c:if
					test="${not empty requestDetails.buContactPerson.buRequestors[1].name}">
					<c:set var="businessClass1" value="" />
					<c:set var="businessClearStyle1" value="display: inline;" />
					<s:set var="requestornameSelected1" value="%{'Yes'}" />
				</c:if>
				<div class="row">
					<div class="form-row">
						<div class="span4 left" style="width:240px;">
							<s:label key="label.request.contactName2" cssClass="optional" />
							<s:textfield required="false" theme="aloc"
								cssClass="span3 lookup-filterValue referenceTextValue" id="businessContactPersonId2"/>
							<span class="lookup-error hide" style="color: #AE2C2C;"></span>
						</div>
						<div class="span2 left" style="width:240px;">
							<label>&nbsp;</label>
							<s:url action="BusinessContactPersonLookup" namespace="/ext"
								id="getBusinessContactPersonURL">
								<s:param name="lookUpNumber" value="2" />
							</s:url>
							<a class="btn-secondary lookup"
								href='<s:property value="#getBusinessContactPersonURL"/>'><s:text
									name="label.request.common.lookup" /></a> <img alt="Loading..."
								id="bcpIndicator2" class="indicator"
								src="${pageContext.request.contextPath}/ext/public/img/loading.gif"
								style="height: 20px; display: none"> &nbsp;&nbsp;&nbsp;<a
								href="javascript:;" class="deleteBCP-ce">Remove Contact name</a> 
						</div>
					</div>
				</div>
				<div class="${businessClass1}" id="businessShow1">
					<s:hidden name="businessSelection1" id="businessSelectionId1"
						cssClass="businessSelection" value="%{#requestornameSelected1}" />
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
											<s:property
												value="requestDetails.buContactPerson.buRequestors[1].name" />
											-SSO<
											<s:property
												value="requestDetails.buContactPerson.buRequestors[1].ssoId" />
											>
										</p>
										<s:hidden
											name="requestDetails.buContactPerson.buRequestors[1].name"
											id="bcpName1" cssClass="name" />
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
											<s:property
												value="requestDetails.buContactPerson.buRequestors[1].phoneNumber" />
										</p>
										<s:hidden
											name="requestDetails.buContactPerson.buRequestors[1].phoneNumber"
											id="phoneNumber1" cssClass="phone" />
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
											<s:property
												value="requestDetails.buContactPerson.buRequestors[1].emailAddr" />
										</p>
										<s:hidden
											name="requestDetails.buContactPerson.buRequestors[1].emailAddr"
											id="emailAddr1" cssClass="email" />
										<s:hidden
											name="requestDetails.buContactPerson.buRequestors[1].ssoId"
											id="tpApplicantBCPSSO1" cssClass="ssoId" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</c:when>
			<c:when test="${param.buContactPersonFieldAddIndex eq 2}">


				<c:if
					test="${empty requestDetails.buContactPerson.buRequestors[2].name}">
					<c:set var="businessClass2" value="conditional-row" />
					<c:set var="businessClearStyle2" value="display: none;" />
				</c:if>
				<c:if
					test="${not empty requestDetails.buContactPerson.buRequestors[2].name}">
					<c:set var="businessClass2" value="" />
					<c:set var="businessClearStyle2" value="display: inline;" />
					<s:set var="requestornameSelected2" value="%{'Yes'}" />
				</c:if>

				<div class="row">
					<div class="form-row">
						<div class="span4 left" style="width:240px;">
							<s:label key="label.request.contactName3" cssClass="optional" />
							<s:textfield required="false" theme="aloc"
								cssClass="span3 lookup-filterValue referenceTextValue" id="businessContactPersonId3"/>
							<span class="lookup-error hide" style="color: #AE2C2C;"></span>
						</div>
						<div class="span2 left" style="width:240px;">
							<label>&nbsp;</label>
							<s:url action="BusinessContactPersonLookup" namespace="/ext"
								id="getBusinessContactPersonURL">
								<s:param name="lookUpNumber" value="3" />
							</s:url>
							<a class="btn-secondary lookup"
								href='<s:property value="#getBusinessContactPersonURL"/>'><s:text
									name="label.request.common.lookup" /></a> <img alt="Loading..."
								id="bcpIndicator2" class="indicator"
								src="${pageContext.request.contextPath}/ext/public/img/loading.gif"
								style="height: 20px; display: none"> &nbsp;&nbsp;&nbsp;<a
								href="javascript:;" class="deleteBCP-ce">Remove Contact name</a>
						</div>
					</div>
				</div>
				<div class="${businessClass2}" id="businessShow2">
					<s:hidden name="businessSelection2" id="businessSelectionId2"
						cssClass="businessSelection" value="%{#requestornameSelected2}" />
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
											<s:property
												value="requestDetails.buContactPerson.buRequestors[2].name" />
											-SSO<
											<s:property
												value="requestDetails.buContactPerson.buRequestors[2].ssoId" />
											>
										</p>
										<s:hidden
											name="requestDetails.buContactPerson.buRequestors[2].name"
											id="bcpName2" cssClass="name" />
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
											<s:property
												value="requestDetails.buContactPerson.buRequestors[2].phoneNumber" />
										</p>
										<s:hidden
											name="requestDetails.buContactPerson.buRequestors[2].phoneNumber"
											id="phoneNumber2" cssClass="phone" />
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
											<s:property
												value="requestDetails.buContactPerson.buRequestors[2].emailAddr" />
										</p>
										<s:hidden
											name="requestDetails.buContactPerson.buRequestors[2].emailAddr"
											id="emailAddr2" cssClass="email" />
										<s:hidden
											name="requestDetails.buContactPerson.buRequestors[2].ssoId"
											id="tpApplicantBCPSSO2" cssClass="ssoId" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:when>
		</c:choose>
	</c:if></td>
<script
	src="${pageContext.request.contextPath}/ext/public/js/ext/addBcpReference.js"
	type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/ext/buContactperson.js"></script>
