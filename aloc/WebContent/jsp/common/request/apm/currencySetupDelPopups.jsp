<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- DELETE POPUP WINDOW -->
	<div class="modal hide fade" id="deleteCurModal">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.request.deleteThisCurrency" /><span></span></h3>
		</div>
		<div class="modal-body" style="margin-top:-32px;">
				<p><s:text name="label.request.youAreAboutToDelete" /></p>
	           	<s:hidden id="configId" name="configId" />
	           	<p><s:textfield id="curCode" name="curCode" cssClass="noModelBorders"/></p>
	           	<p><s:textfield id="curName" name="curName" cssClass="noModelBorders"/></p>
	           	<h3><s:text name="label.suretynamemgmt.body.actionUndone" /></h3>
		</div>
		<div class="modal-footer">
				<a href="javascript:;" id="deleteCurSetRow" data-dismiss="modal" class="left btn-primary"><s:text name="label.request.deleteThisCurrency" /></a>
			<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.treasuryAdminPortal.cancel"/></a>
		</div>
	</div>
	
	 <div class="modal hide fade" id="delCurSizeOneModal">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3><s:text name="label.request.unabletoDelete" /> <span></span></h3>
			</div>
			<div class="modal-body" style="margin-top:-32px;">
			<form>
			<p><s:text name="label.request.currencyDeletePopupMsg" /> </p>
			</form>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.closeWindow" /> </a>
			</div>
	</div> 
	
	