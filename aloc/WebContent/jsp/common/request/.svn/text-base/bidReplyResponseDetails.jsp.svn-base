<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

 <div class="form-mod">
	<div class="acc_container7"> 
	
	<p class="required-fields"><s:text name="label.common.siteAdmin.allFieldsAreRequired" /></p>
		
             <div class="row smallrow">
				    <div class="span2">
					    <div class="form-row">
						    <label><s:text name="label.request.dateBidMemoCreated" /></label>
					    </div>
				    </div>
					<div class="span4">
						<p class="padding40"><s:date name="requestDetails.bidmemoDetails.dateBidMemoCreated" format="dd MMM yyyy HH:mm aa zzz"/></p>
					</div>
					 <div class="span3" style="margin-right: -60px;">
					    <div class="form-row">
						    <label><s:text name="label.request.sbBidResponseRequiredC" /></label>
					    </div>
				    </div>
					<div class="span3">
						<div class="form-row">
						<p class="padding40"><s:date name="requestDetails.bidmemoDetails.expirationDateTime" format="dd MMM yyyy"/> <s:property value="hours"/>:<s:property value="minutes"/> <s:property value="period"/> <s:date name="requestDetails.bidmemoDetails.expirationDateTime" format=" zzz"/></p>
						</div>
					</div>
			</div> <!-- end of block -->
				
			 <p><s:text name="label.request.bidMemoInfo1"/></p>
             <p><s:text name="label.request.bidMemoInfo2"/>  </p> 
             <p>&nbsp;</p>
				
				<div class="row">
				    <div class="span5">
					    <div class="form-row">
						    <label><s:text name="label.request.bidReplyExpirationDate" /></label>
						    <s:textfield name="requestDetails.bidReplyDetails.bidExpirationDate" theme="aloc" cssClass="date"></s:textfield>
						    <p>DD MMM YYYY</p>
					    </div>
				    </div>
				</div> <!-- end of block -->
				<div class="row">
						<div class="span5">
							<div class="form-row">
								<label> <s:text name="label.request.bidReplyExpirationTime"></s:text> 
								</label> 
								<s:textfield name="bidHours" maxlength="2"
											cssClass="span1c bigInt" 
										/> : <s:textfield name="bidMinutes" 
											cssClass="span1c bigInt" maxlength="2"
										/> 
								<s:select headerKey="" key="" list="#{'AM':'AM','PM':'PM'}" cssClass="span1c"  cssStyle="margin-bottom:0px; width:50px!important;"
									id="selectPeriod" name="bidPeriod" />
													
								 EST
								<p>&nbsp; &nbsp; HH&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
									&nbsp;MM</p>
							<span style="color:red"><s:fielderror>
								<s:param>bidHours</s:param>
								<s:param>bidMinutes</s:param>
							</s:fielderror></span>
							</div>
						</div>
					</div>
				
  </div>
 </div>
