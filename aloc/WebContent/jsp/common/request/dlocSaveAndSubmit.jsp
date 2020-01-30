<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<input type="hidden" name="requestDetails.prepareForBundle" id="prepareForBundleId">
<input type="hidden" name="actionType" id="actionTypeId">
<div class="row">
	<div class="span12">
		<input type="button" value="<s:text name="label.request.saveAsDraft"/>" class="btn-secondary" id="dloc-draft"/>
		<c:if test="${requestDetails.WFDetails.WFStage ne 'REQEST'}">
			<input type="button" value="<s:text name="label.request.prepareForBundling"/>" data-dropdown="#dropdown-1" class="bottombtn btn-secondary" id="dloc-prepare" />
			<input type="button" value="<s:text name="label.request.submitRequest"/>" class="btn-secondary" id="dloc-submit" />
		</c:if>
		<c:if test="${requestDetails.WFDetails.WFStage eq 'REQEST'}">
			<input type="button" value="Re-Submit" class="btn-secondary" id="dloc-ReSubmit" />
		</c:if>
		<a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.exitRequest"/></a>
		
		<div id="dropdown-1" class="dropdownNew dropdown-tip" style="margin-left:0px; margin-top:-1px;">
		    <div class="dropdown-panel">
			    <div class="row smallrow">
			        <div class="span6 btn-container">
			            <div class="form-row">
			            	<a href="javascript:;"><s:submit key="label.request.addToBundle" onclick="setBundleFlag(1)" cssClass="btn-primary"/></a>
							<s:url action="cancel.action" namespace="/int/requestor" var="cancelBtnlURL" />
						 	<a class="nav-hide btn-tertiary" ><s:text name="label.request.common.cancel"/></a>                 
			            </div>
			        </div>
			    </div>
		    </div>
		</div>
		
	</div>
</div>