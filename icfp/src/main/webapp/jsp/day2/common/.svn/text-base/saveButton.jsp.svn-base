<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="span12 btn-container" style="margin-left:-10px!important;">
	<c:if test="${sessionScope.section eq 'myTasks'}">
	<div class="span3 right" style="background-color: #D9EDF7;   border:1px solid #A6C2D6;padding:5px;">
		<div class="form-row" style="margin-bottom:15px;">
			<div id="saveRadioDiv" class="radio-container conditional-required">
				<c:if test="${requestScope.proceedtoNextLeg eq 'yes'}">
					<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'" id="reviewNextLegID">
						<input type="radio" name="saveAction" value="saveNextLeg" class="condition">
						Save and go to next Leg
					</label>
				</c:if>
				<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'">
					<input type="radio" name="saveAction" value="saveReturnDeal" class="condition">
					Save and return to deal
				</label>
			</div>
		</div>
		
		<input type="button" class="btn btn-success btn-large"
		 onclick="javascript:validateSubmit(${param.eventTypeId},'?command=saveAndReturnToDeal');"
		 value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" />
		
	</div>
	
	<c:choose>
		<c:when test="${requestScope.proceedtoNextLeg eq 'no'}">
			<input type="button" value="Save" class="btn right" style="margin-top: 85px;" onclick="javascript:saveAsDraft(this);">
			<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
		</c:when>
		<c:otherwise>
			<input type="button" value="Save" style="margin-top: 60px;" class="btn right" onclick="javascript:saveAsDraft(this);">
			<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:70px">Cancel</a>
		</c:otherwise>
	</c:choose>
	</c:if>
	<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
	<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
	</c:if>				
</div>