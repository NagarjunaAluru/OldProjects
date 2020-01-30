$(document).ready(function() {
				if(!$('#tra-nav-save').attr('handlerPostAwardSave')) {
				$("#tra-nav-save").click(function(){
					$(this).addClass('tabactive');
					$('#li22').removeClass('liactive');
					$('#li23').removeClass('liactive');
					$("#tra-nav-award").removeClass('tabactive');
					$("#tra-nav-sendBack").removeClass('tabactive');
					$('#actionTypeId').val("1");
					$('form#postawardSubmitForm').submit();
				});
				$('#tra-nav-save').attr('handlerPostAwardSave', true);

				}
				$('form#postawardSubmitForm').submit(function() {
					return true;
				});
				
				if(!$('#tra-nav-award').attr('handlerPostAwardSubmit')) {
				$("#tra-nav-award").click(function(){
				    $(this).addClass('tabactive');
					   $('#li22').addClass('liactive');
					   $('#li23').removeClass('liactive');
					   $("#tra-nav-save").removeClass('tabactive');
					   $("#tra-nav-sendBack").removeClass('tabactive');
				});
				$('#tra-nav-award').attr('handlerPostAwardSubmit', true);
				}
				
				if(!$('#tra-nav-sendBack').attr('handlerPostAwardSendBack')) {
				$("#tra-nav-sendBack").click(function(){
				    $(this).addClass('tabactive');
					   $('#li23').addClass('liactive');
					   $('#li22').removeClass('liactive');
					   $("#tra-nav-save").removeClass('tabactive');
					   $("#tra-nav-award").removeClass('tabactive');
				});	
				$('#tra-nav-sendBack').attr('handlerPostAwardSendBack', true);
				}
				
				var postAwardMsgShow = $('#errorMsgShowPost').val();
				if(postAwardMsgShow!=undefined && postAwardMsgShow == 'true'){
					$('#postAwardErrorDiv').show();
					var actionId= $('#actionTypeId').val();
					var instrumentTypeId= $('#instrumentTypeId').val();
					if(actionId=='3'){
						if((instrumentTypeId==undefined) && (instrumentTypeId !="5" && instrumentTypeId !="6"))
						{
							$('#awardRadioOpt_true').attr("checked", true);
							$('#awardReviewEdit').show();
							$("#submitDiv").removeClass('hide');
							$("#tra-nav-award").parent('li').hide();
							$('#tra-nav-sendBack').addClass('tabactive');
							$('#li23').addClass('liactive');
							$('#tab3').show();
						}
						if((instrumentTypeId!=undefined) && (instrumentTypeId =="5" || instrumentTypeId =="6"))
						{
							$("#submitDiv").removeClass('hide');
							$('#tra-nav-sendBack').addClass('tabactive');
							$('#li23').addClass('liactive');
							$('#tab3').show();
						}
					}
				}
				
				if($('#awardRadioOpt_true').is(':checked')) {
					$('#awardReviewEdit').show();
					$('#restartBidProcess').hide();
					$('#postAwardComments').hide();
					$('#tdcomments').val('');
					}
				if ($('#awardRadioOpt_false').is(':checked')){
					$('#awardReviewEdit').hide();
					$("#submitDiv").removeClass('hide').addClass('hide');
					$('#restartBidProcess').show();
					$('#tdcomments').val('');
					$('#postAwardCounter').text('400');
					$('#postAwardComments').show();
					}
				$('#awardRadioOpt_true').click(function(){
					$('#awardReviewEdit').show();
					$('#restartBidProcess').hide();
					$("#readySystemCheckSection").show();
					$('#postAwardComments').hide();
					$('#tdcomments').val('');
				});
				$('#awardRadioOpt_false').click(function(){
					$('#awardReviewEdit').hide();
					$("#submitDiv").removeClass('hide').addClass('hide');
					$('#restartBidProcess').show();
					$('#tdcomments').val('');
					$('#postAwardCounter').text('400');
					$('#postAwardComments').show();
					$('#postAwardErrorDiv').hide();
				});
});
