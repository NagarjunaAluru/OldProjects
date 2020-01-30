<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>`
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="span12">
		<h3>
			<s:text name="label.request.instrumentDocumentText" />
			<p>
				<s:text name="label.request.copyAndPaste" />
			</p>
		</h3>

		<div class="row lastrow">
			<div class="span12">
				<%-- <s:textarea class="autosize10 messageinput span12" name="textarea2"
					cols="50" rows="3" onkeypress="return imposeMaxLegnth(this, 9999);" /> --%>
				<textarea class="autosize10 messageinput span12" name="textarea2" col="50" rows="3" id="copyAndPasteId"></textarea>
				<div class="clear"></div>
				<div class="counter">10000</div>
				<!-- fix positions -->
				<div class="counterTxt" style="padding-left: 20px;">
					<p class="guidance">
						<s:text name="label.request.charactersLeft" />
					</p>
				</div>
			</div>
		</div>
	</div>
</div>
