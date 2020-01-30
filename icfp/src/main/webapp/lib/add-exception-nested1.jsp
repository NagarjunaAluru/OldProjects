						<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
							<td rowspan="3">
							<script type="text/javascript">
							//This code works only if it served along with JSP, as it load as part
							//of AJAX call and having the JS seperate file is not getting loaded
							$(document).ready(function(){	
								$('.autosize').keyup(function() {
									var len = this.value.length;
									if (len >= 500) {
									this.value = this.value.substring(0, 500);
									}
								});
							function textareaCounter() {
								var maxchar = 0;
								if($(this).data('max')>=0){
									maxchar = $(this).data('max');
								}else{
									maxchar = 500;
								}
								var cnt = $(this).val().length;
								var remainingchar = maxchar - cnt;
								var counter = $(this).prev();
								var help = $(this).siblings('.help-block');
								counter.html(remainingchar);
								if(remainingchar > 0){
									counter.css('color', '#7FC47E');
									help.css('color', '#999999');
								}else{
									counter.html(0);
									counter.css('color', '#AE2C2C');
									help.css('color', '#AE2C2C');
								}
							}
							$('.autosize').bind('keyup', textareaCounter).trigger("keyup");
							});
							</script>
							<input type="hidden" name="exceptionIndex" value="${param.exceptionIndex}" />
							<a href="javascript:void(0);" id="deleteException" title="Delete this exception" class="deleteException-tr delete-tr">X</a>
							</td>
							<td>
								<div class="form-row autosize-container small">
									<span class="required">*</span>
									<label>Terms &amp; Conditions</label>
									<select  name="standardTermsConditionsId" class="span2 request-exp">
										<option value="">Select..</option>
										<c:forEach items="${applicationScope['com.ge.icfp.StaticData'].termsAndConditions}" var="option">
											<option value="${option.ID}">${option.name}</option>
										</c:forEach>
									</select>
								</div>
							</td>
							
							<td>
								<div class="form-row autosize-container small">
									<span class="required">*</span>
									<label>Exceptions</label>
									<div class="char-count">500</div>
									<textarea class="span4 autosize messageinput request-exp" name="requestedException" rows="4" onblur="scriptInjection(this);"></textarea>
								</div>
							</td>
							
							<td>
								<div class="form-row autosize-container small">
									<span class="required">*</span>
									<label>Impact</label>
									<div class="char-count">500</div> 
									<textarea class="span4 autosize messageinput request-exp" name="rationaleForExceptionImpact" rows="4" onblur="scriptInjection(this);"></textarea>
								</div>
								<div class="form-row autosize-container small">
									<label>Potential alternatives</label>
									<div class="char-count">500</div> 
									<textarea class="span4 autosize messageinput " name="rationaleForExceptionPotentialAlternatives" rows="4" onblur="scriptInjection(this);"></textarea>
								</div>
							</td>
							<td>	
								<div class="form-row autosize-container small">
									<span class="required">*</span>
									<label>Timeline</label>
									<div class="radio-container">
										<label class="radio">
										<input type="radio" name="exceptionTimelineId[${param.exceptionIndex}]" value="1" >
										Permanent
									</label>
									<label class="radio">
										<input type="radio" name="exceptionTimelineId[${param.exceptionIndex}]" value="2">
										Temporary
									</label>
									</div>
								</div>
							</td>
							
							<td>
								<div class="form-row autosize-container small">
									<span class="required">*</span>
									<label>Comments</label>
									<div class="char-count">500</div> 
									<textarea class="span4 autosize messageinput request-exp" name="remediationTimelineComments" rows="4" onblur="scriptInjection(this);"></textarea>
								</div>
								<div class="form-row timeframe">
                                   <span class="required">*</span>
                                   <label>Estimated Timeframe</label>
                                   <input type="text" name="remediationTimeline" class="left span16 requestdatepicker-field request-exp">
                                   <span class="help-block clear right">MM/DD/YYYY</span>
                                </div>
                                <script type="text/javascript">
                            	$('.requestdatepicker-field').datepicker({
                            		changeMonth: true,
                            		changeYear: true,
                            		showOn: "button",
                            		buttonImage: "calendar2.gif",
                            		buttonImageOnly: true
                                });
								</script>
							    </td>
