<%@ taglib prefix="s" uri="/struts-tags"%>
<s:url action="treasuryAdminPortal.action" namespace="/int/admin" var="cancelBtnlURL"/>
<!-- EXIT REQUEST POPUP WINDOW -->
<div class="modalSite hide fade" id="clearEntries">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.treasuryAdminPortal.cancel"/><span></span></h3>
		</div>
		<div class="modal-body">
		<form>
		<p><b><s:text name="label.request.popUpMsg"/></b><br>
		<s:text name="label.request.popUpsubMsg"/>
		</p>
		</form>
		</div>
		<div class="modal-footer">
		    <a href="<s:property value="#cancelBtnlURL" />" class="btn left"><s:text name="label.treasuryAdminPortal.continue"/></a>
		    <a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.treasuryAdminPortal.cancel"/></a>
		</div>
</div>