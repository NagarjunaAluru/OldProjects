<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
	
	<td>
   		 <a href="javascript:void(0);" class="delete-paymentSchedules delete-tr-hide" title="Delete this payment">Delete Payment</a> 
                		
    </td> 
	<td><s:textfield
			name="requestDetails.paymentScheduleDetails.additionalPayments[%{#parameters['newAdditionalPaymentsIndex']}].estAmt"
			theme="aloc" cssClass="span3 bigDecimal" maxlength="21" /></td>
	<td><s:textfield
			name="requestDetails.paymentScheduleDetails.additionalPayments[%{#parameters['newAdditionalPaymentsIndex']}].estMonths"
			theme="aloc" cssClass="span3 estimatedMonths bigInt" maxlength="3"/></td>
	<td><s:textfield
			name="requestDetails.paymentScheduleDetails.additionalPayments[%{#parameters['newAdditionalPaymentsIndex']}].estDt"
			theme="aloc" cssClass="span2 date" />
		<s:hidden cssClass="paymentOpcode" name="requestDetails.paymentScheduleDetails.additionalPayments[%{#parameters['newAdditionalPaymentsIndex']}].opCode" value="INSERT"/>       
   		<s:hidden cssClass="paymentId" name="requestDetails.paymentScheduleDetails.additionalPayments[%{#parameters['newAdditionalPaymentsIndex']}].estPayId" />
   		</td>
   		
    <script>
	$('.date').each(function() {
		// This checking is requrired to avoid multiple registrations; zdate-plugin checking of 'data' is not working.
		if(!$(this).attr('zdateRegistered')) {
			$(this).zdate({
				format: 'd M Y',
				offset:  [20, 25],
				first_day_of_week: '0'
			});
			$(this).attr('zdateRegistered', 'true');
			
			$(this).on('blur', function() {
				formatDate(this, 'd M Y');
			});
		}
	});
	/*
	* Deletes Payment Schedule
	*/
	$('.delete-paymentSchedules').each(function() {
		if(!$(this).attr('deletePaymentRows')) {
		$(this).click(function() {
			var showIndex = parseInt($('#showIndex').val());
			$('#showIndex').val(showIndex - 1);
			if($('#showIndex').val() < 10 && $('#showIndex').val() !=""){
				$('#addPayment').show();
			}
			var paymentRow = $(this).parent().parent();
			$(paymentRow).find('.paymentOpcode').val('DELETE');
			$(paymentRow).addClass('deleted');
			$(paymentRow).hide();
			});
		$(this).attr('deletePaymentRows', true);
		}
	});
	$('.estimatedMonths').off('change').on('change',function(){
		var issueDate = new Date($('#paymentScheduleIssueDate').val());
		var monthsToAdd = parseInt($(this).val());
		issueDate.setMonth(issueDate.getMonth()+monthsToAdd);
		var estPayDate = issueDate.toDateString().split(' ')[2] + ' '+issueDate.toDateString().split(' ')[1] + ' '+issueDate.toDateString().split(' ')[3];
		$(this).closest('td').next().find('.date').val(estPayDate);
	});
</script> 


