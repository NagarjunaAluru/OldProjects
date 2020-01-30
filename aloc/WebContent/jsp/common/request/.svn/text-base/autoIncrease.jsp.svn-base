<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set name="autoIncDecCount"
	value="%{#parameters['newIncrementIndex']}" />

<td>
 <a href="javascript:void(0);" class="delete-autoIncDec delete-tr-hide" title="Delete this Auto Increase/Decrease Row">Delete Auto Inc/Dec Row</a> 	
</td>
<td>
	<div class="form-row" style="padding-right: 40px;">
		<s:radio theme="aloc" id="noticePeriodFlag1" cssClass="radio"
			name="requestDetails.instrumentDetails.autoIncDecs[%{#autoIncDecCount}].autoIncIndicator"
			list="#{'increase':'Increase','decrease':'Decrease'}"
			value="%{requestDetails.instrumentDetails.autoIncDecs[%{#autoIncDecCount}].autoIncIndicator}" />
	</div>
</td>
<td>
	<div class="form-row">
		<s:textfield
			name="requestDetails.instrumentDetails.autoIncDecs[%{#autoIncDecCount}].autoIncAmt"
			id="autoIncAmt1" theme="aloc" cssClass="bigDecimal"/>
	</div>
</td>
<td>
	<div class="form-row">
		<s:textfield
			name="requestDetails.instrumentDetails.autoIncDecs[%{#autoIncDecCount}].autoIncDt"
			cssClass="date" id="autoIncDt1" theme="aloc" />
			<p><s:text name="label.request.dateFormat" /></p>
		<s:hidden cssClass="autoIncDecOpcode" name="requestDetails.instrumentDetails.autoIncDecs[%{#autoIncDecCount}].opCode" value="INSERT"/> 
	</div>
</td>

<script
	src="${pageContext.request.contextPath}/js/others/jquery-zdate.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/site.js"
	type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/common/site.css"
	rel="stylesheet">
 <script>
 /*
	* Deletes  Auto Inc/Dec
	*/
	$('.delete-autoIncDec').each(function() {
		if(!$(this).attr('deleteAutoIncDecRows')) {
		$(this).click(function() {
			var showIndex = parseInt($('#showIndex').val());
			var incDecRow = $(this).parent().parent();
			$('#showIndex').val(showIndex - 1);
			if($('#showIndex').val() < 10 && $('#showIndex').val() !=""){
				$('#autoaddLinkDiv').show();
			}
			$(incDecRow).find('.autoIncDecOpcode').val('DELETE');
			$(incDecRow).addClass('deleted');
			$(incDecRow).hide();
			});
		$(this).attr('deleteAutoIncDecRows', true);
		}
	});
</script> 