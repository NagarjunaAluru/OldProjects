<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal hide fade" id="inputsCompletedModalID">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			      <h3>Inputs completed for Request</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to Submit Financing Request?</b><br>  </p>
			</div>
		</div>
		<div class="modal-footer">
		        <a href="#" class="btn right btn-success" onclick="inputsCompleted()">Yes, submit the request</a>
			    <a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
	</div>