<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<c:if test="${param.includeScripts != false}">
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@include file="../../common/includeSectionCommonScripts.jsp" %>
</head>
<body>
</c:if>

<s:url id="applySectionURL" action="applySection"/>
<s:url id="editSectionURL" action="editSection"/>
<s:url id="cancelSectionURL" action="cancelSection"/>
<s:set name="isEdit" value="editMode"/>
<s:hidden name="currentSectionId" id="currentSectionId"/>
<c:choose>
	
	
	<c:when test="${param.sectionId eq 'request.section.riderPrincipal'}">
		<div class="acc_container" id="principalSection">
			<s:form id="principalForm">
			<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.rider.riderRequestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editbtn">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						replaceTarget="true"
						targets="principalSection" href="%{editSectionURL}"
						onErrorTopics="multipleTabsProblem"
					/>
					</p>
				</s:if>
				<div class="clear"></div>
				<div class="row">
                    <div class="span6">
                    	<div class="form-row">
						<h2 id="instrumentDetails" class="acc acc_active">
							<a href="javascript:;"><s:text
									name="label.request.sbSectionPrincipal" />
							</a>
						</h2><hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/suretyRider/riderPrincipal.jsp" >
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<c:if test="${requestDetails.rider.principal.changeFlag eq 'Y'}">
					<div class="span5 left">
						<div class="form-row">
							<h2 class="acc acc_active"><a href="javascript:;">Previous</a></h2><hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/suretyRider/riderPrincipal.jsp" >
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div>
					</c:if>
				</div>
				<div class="clear"></div>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
					<div class="row highlighted">
						<div class="span12">
						<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
							targets="principalSection" href="%{applySectionURL}"
						/>
						<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
							formIds="principalForm" onErrorTopics="multipleTabsProblem"
							targets="principalSection" href="%{cancelSectionURL}">
							<s:text name="label.request.common.undochanges" />
						</sj:a>
						</div>
						</div>
					</div>
				</s:if>
			</s:form>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.riderObligee'}">
		<div class="acc_container" id="obligeeSection">
			<s:form id="obligeeForm">
			<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.rider.riderRequestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editbtn">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="obligeeSection" href="%{editSectionURL}"
							/>
					</p>
				</s:if>
				<div class="clear"></div>
				<div class="row">
                    <div class="span6">
                    	<div class="form-row">
						<h2 id="instrumentDetails" class="acc acc_active">
							<a href="javascript:;"><s:text
									name="label.request.sbSectionObligee" />
							</a>
						</h2><hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/suretyRider/riderObligee.jsp" >
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<c:if test="${requestDetails.rider.obligee.addressDtls.changeFlag eq 'Y'}">
					<div class="span5 left">
						<div class="form-row">
							<h2 class="acc acc_active"><a href="javascript:;">Previous</a></h2><hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/suretyRider/riderObligee.jsp" >
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div>
					</c:if>
				</div>
				<div class="clear"></div>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
							targets="obligeeSection" href="%{applySectionURL}"
						/>
						<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
							formIds="obligeeForm" onErrorTopics="multipleTabsProblem"
							targets="obligeeSection" href="%{cancelSectionURL}">
							<s:text name="label.request.common.undochanges" />
						</sj:a>
						</div>
				</s:if>
			</s:form>
		</div>
	</c:when>
	
 	<c:when test="${param.sectionId eq 'request.section.riderExpirationDates'}">
		<div class="acc_container" id="expirationDatesSection">
			<s:form id="expirationDatesForm">
			<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.rider.riderRequestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editbtn">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="expirationDatesSection" href="%{editSectionURL}"
						/>
					</p>
				</s:if>
				<div class="clear"></div>
				<div class="row">
                    <div class="span6">
                    	<div class="form-row">
						<h2 id="instrumentDetails" class="acc acc_active">
							<a href="javascript:;"><s:text
									name="label.request.bglocSectionName.14" />
							</a>
						</h2><hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/suretyRider/riderExpiratinDate.jsp" >
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<c:if test="${requestDetails.rider.expiryDate.changeFlag eq 'Y'}">
							<h2 class="acc acc_active"><a href="javascript:;">Previous</a></h2><hr class="h2-hr">
							</c:if>
							<c:if test="${requestDetails.rider.expiryDate.changeFlag ne 'Y'}">
							<h2 class="acc acc_active"><a href="javascript:;"></a></h2><hr class="h2-hr">
							</c:if>
						</div>
						<jsp:include page="/jsp/common/request/suretyRider/riderExpiratinDate.jsp" >
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div>
				</div>
				<div class="clear"></div>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
					<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
							targets="expirationDatesSection" href="%{applySectionURL}"
						/>
						<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
							formIds="expirationDatesForm" onErrorTopics="multipleTabsProblem"
							targets="expirationDatesSection" href="%{cancelSectionURL}">
							<s:text name="label.request.common.undochanges" />
						</sj:a>
					</div>
				</s:if>
			</s:form>
		</div>
	</c:when>	
	<c:when test="${param.sectionId eq 'request.section.riderBondInformation'}">
		<div class="acc_container" id="bondInformationSection">
			<s:form id="bondInformationForm">
			<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.rider.riderRequestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editbtn">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="bondInformationSection" href="%{editSectionURL}"
							/>
					</p>
				</s:if>
				<div class="clear"></div>
				<div class="row">
                    <div class="span12">
                    	<div class="form-row">
						<h2 id="instrumentDetails" class="acc acc_active">
							<a href="javascript:;"><s:text
									name="label.request.sbSectionBondInformation" />
							</a>
						</h2><hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/suretyRider/riderBondInformation.jsp" />
					</div>
				</div>
				<div class="clear"></div>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
					<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
							targets="bondInformationSection" href="%{applySectionURL}"
						/>
						<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
							formIds="bondInformationForm" onErrorTopics="multipleTabsProblem"
							targets="bondInformationSection" href="%{cancelSectionURL}">
							<s:text name="label.request.common.undochanges" />
						</sj:a>
					</div>
				</s:if>
			</s:form>
		</div>
	</c:when>
	
	
	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div class="acc_container" id="attachmentsSection">
			<s:form id="attachmentsForm" namespace="/int/requestor" action="validateDocLOCRequestForm">
			<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.rider.riderRequestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editbtn">
					<sj:submit 
						key="label.request.Edit"
						cssClass="btn-secondary right" 
						replaceTarget="true"
						targets="attachmentsSection"
						href="%{editSectionURL}" 
						onErrorTopics="multipleTabsProblem"
						/>
					</p>
				</s:if>	
				<h2 id="attachments" class="section_flip">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.9" />
					</a>
				</h2><hr class="h2-hr">
				<div id="attachmentsPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/attachments.jsp" />
				</div>		
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">	
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
						replaceTarget="true"
						targets="attachmentsSection"
						href="%{applySectionURL}" 
						onErrorTopics="multipleTabsProblem"
						/>
					<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="attachmentsForm"
						targets="attachmentsSection" 
						href="%{cancelSectionURL}" 
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel"/>
					</sj:a>
				</div>
				</s:if>	
			</s:form> 
		</div>		
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.riderDeliveryInstructions'}">
		<div class="acc_container" id="deliveryInstructionsSection">
			<s:form id="deliveryInstructionsForm">
			<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.rider.riderRequestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editbtn">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="deliveryInstructionsSection" href="%{editSectionURL}"
						/>
					</p>
				</s:if>
				<div class="clear"></div>
				<div class="row">
                    <div class="span6">
                    	<div class="form-row">
						<h2 id="instrumentDetails" class="acc acc_active">
							<a href="javascript:;"><s:text
									name="label.request.sbSectionDeliveryInstructions" />
							</a>
						</h2><hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/suretyRider/riderDeliveryInstructions.jsp">	
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<c:if test="${requestDetails.rider.deliveryInstructions.changeFlag eq 'Y'}">
					<div class="span6 left">
						<div class="form-row">
							<h2 class="acc acc_active"><a href="javascript:;">Previous</a></h2><hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/suretyRider/riderDeliveryInstructions.jsp">
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div>
					</c:if>
				</div>
				<div class="clear"></div>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
					<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
							targets="deliveryInstructionsSection" href="%{applySectionURL}"
						/>
						<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
							formIds="deliveryInstructionsForm" onErrorTopics="multipleTabsProblem"
							targets="deliveryInstructionsSection" href="%{cancelSectionURL}">
							<s:text name="label.request.common.undochanges" />
						</sj:a>
					</div>
				</s:if>
			</s:form>
		</div>
	</c:when>
	
</c:choose>
<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>