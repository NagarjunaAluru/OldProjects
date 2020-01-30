		<div class="span12 right btn-container">
			<div class="span3 right submit-box">
				<div class="form-row">
					
					<div class="radio-container">
						
						<label class="radio">
							<input type="radio" value="affirm" name="submitDealFB">
							Affirm
						</label>

						<label class="radio">
							<input type="radio" class="make-modal" value="sendBack" name="submitDealFB">
							Send back
						</label>
						<input type="hidden" name="actionId" id="actionID" >
						<input type="hidden" name="forwardPage" id="forwardPageId"> 
						<input type="hidden" name="roleId" value="5">
						<input type="hidden" name="approveReject" id="approveReject">
						<input type="hidden" name="WFId" value="${param.WFId}">
						<input type="hidden" name="WFStage" value="${param.WFStage}">
						<input type="hidden" name="queueName" value="${param.queueName}">
						<!-- <label class="radio">
							<input type="radio" class="assignReviewer" value="assignAReviewer" name="optionsRadios">
							Assign a reviewer...
						</label> -->
					</div>
				</div>
				<div id="actionButton">
				<a class="btn btn-success btn-large" id="submit" href="#" style="width: 190px;">Submit</a>
				</div>
			</div>
			<div style="margin-top: 90px; float: right;">
				<a class="btn right save-btn single" id="saveAction" href="#" >Save</a>
				<a class="btn-link right cancel" id="cancel" href="#" style="margin-top: 10px;">Cancel</a>
				</div>
			</div>
		<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel Exception Request</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="${context}/homePage.do" class="btn right btn-success">Yes, cancel the request</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
	</div>