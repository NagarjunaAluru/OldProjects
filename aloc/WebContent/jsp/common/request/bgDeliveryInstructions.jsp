<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<div class="form-mod">
	<h2 class="acc_trigger8">
		<a href="javascript:;">Delivery Instructions</a>
	</h2><hr class="h2-hr">
	<div class="acc_container8">

		<p class="required-fields">All fields required unless specified</p>
		
		<jsp:include page="deliveryInstructions.jsp"></jsp:include>
		<div class="row highlighted">
			<div class="span12">
				<div class="form-row">
					<label>Is the delivery or pick up by</label> <input
						class="radio" type="radio" value="option1" name="optionsRadios">Applicant<br />
					<input type="radio" value="option1" name="optionsRadios">Beneficiary<br />
					<input type="radio" value="option1" name="optionsRadios">Other
					party
				</div>

			</div>
		</div>
		<div class="row highlighted lastrow">
			<div class="span12 btn-container">
				<div class="form-row">
					<a href="javascript:;" class="btn btn-success" id="acc_ninth">
						Save and continue to attachments...</a> <a href="javascript:;"
						class="btn" style="margin-left: 20px;">Save draft...</a> <a
						href="javascript:;" class="btn-tertiary cancel">Cancel</a>
				</div>
			</div>
			<!-- end of block -->
		</div>
		<!-- end of form form-mod -->

	</div>
	<!-- end of form form-mod -->
</div>