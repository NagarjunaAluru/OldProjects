<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:set name="isEditMode" value="editMode"/>
	  <s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'  && #attr.isTaxonomy != true) && requestDetails.bondReqDtls.requiresEdits == true)}">
	  	<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.bondReqDtls.requiresEdits}">
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
								<c:out value="${requestDetails.bondReqDtls.sendBackNotes}" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>
	  	<div id="bondRequestorForm">
			<a name="fourth"></a>
			   <c:if test="${empty requestDetails.bondReqDtls.name}">
					<c:set var="BondRequestorClass" value="display: none;" />
					<c:set var="BondRequestorClearStyle" value="display: none;"/>
				</c:if>
				<c:if test="${not empty requestDetails.bondReqDtls.name}">
					<c:set var="BondRequestorClass" value="display: block;" />
					<s:set var="BondRequestorNameSelected" value="%{'Yes'}"></s:set>
					<c:set var="BondRequestorClearStyle" value="display: inline;"/>
				</c:if>
                <div class="row">
                	<div class="form-row">
				    	<div class="span3">
							<s:textfield name="bondReqName"  key="label.request.contactPerson" cssClass="span3 lookup-filterValue" id="businessContactPersonId" theme="aloc" required="false"/>
							<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
							<p class="guidance"><s:text name="label.request.partialLastName" /></p>
							<span class="lookup-error hide" style="color: #AE2C2C;"></span>
						</div>
						<div class="span1">
							<label>&nbsp;</label>
							<s:url action="BusinessContactPersonLookup" namespace="/int"	id="getContactPersonURL">
								<s:param name="lookUpNumber" value="1"></s:param>
							</s:url>
							<a class="btn-secondary lookup" href="<s:property value="#getContactPersonURL"/>" ><s:text name="label.request.common.lookup"/></a>
						</div>
						<div class="span5">
				        	<label>&nbsp;</label>
				            <img alt="Loading..." id="bcpIndicator"	class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display: none"> 
							<%-- <a class="btn-tertiary right clear-conditional-results"	id="BusinessClear" href="javascript:;" type="submit"  style="${BondRequestorClearStyle}">Clear results</a> --%>
						</div>
					</div>
			    </div> 
		
				<div class="conditional-row" id="BondRequestorShow" style="${BondRequestorClass}"> 
					<s:hidden name="bondReqNameSelection" id="BondReqNameSelectionID" value="%{#BondRequestorNameSelected}"></s:hidden>
					<div class="row">
						<div class="span12">
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<s:textfield name="requestDetails.bondReqDtls.name" id="bondReqName" key="label.request.name" 
							 readonly="true" theme="aloc" maxlength="100"></s:textfield>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<s:textfield name="requestDetails.bondReqDtls.emailAddress" id="emailAddr" key="label.request.emailAddress" 
							readonly="true" theme="aloc" maxlength="100"></s:textfield>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<s:textfield name="requestDetails.bondReqDtls.phoneNo" id="phoneNumber" key="label.request.phoneNumber"
							 theme="aloc" maxlength="20"></s:textfield>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<s:textfield name="requestDetails.bondReqDtls.faxNo" id="faxNumber" key="label.request.faxNumber"
							 theme="aloc" maxlength="20" required="false"></s:textfield>
							</div>
						</div>
					</div>
					<div class="row hide">						
							<s:textfield name="requestDetails.bondReqDtls.contactPerson" id="tpApplicantBCPSSO"></s:textfield>
					</div>
				</div>
			</div>
		</div>
	 </div><!-- end of required count block -->
	 <script type="text/javascript">
			refreshSectionCount("bondRequestorPanel");
		</script>
	</s:if>
	<s:elseif test="%{#isEditMode==false}">
					<div class="row">
						<div class="span2a">
							<div class="form-row">
								<label><s:text name="label.request.contactPerson" />:</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><c:out value="${requestDetails.bondReqDtls.name}"/></p>
								<p class="padding40"><c:out value="${requestDetails.bondReqDtls.emailAddress}"/></p>
								<p class="padding40"><c:out value="${requestDetails.bondReqDtls.phoneNo}"/></p>
								<p class="padding40"><c:out value="${requestDetails.bondReqDtls.faxNo}"/></p>
							</div>
						</div>
						<!-- end of block -->
					</div>
	</s:elseif>
