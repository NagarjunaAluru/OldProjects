<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<p class="required-fields"><s:text name="label.request.common.requiredFieldsUnlessSpecified" /></p>
			
			<c:if test="${param.suretyBond == true}">
				<div class="row">
					<div class="span8">
					    <div class="form-row">
							<s:text name="label.request.bidTimeFrameDesc" />
						</div>
					</div>
				</div>
			</c:if>
             <div class="row">
				    <div class="span2">
					    <div class="form-row">
						    <label><s:text name="label.request.dateBidMemoCreated" /></label>
					    </div>
				    </div>
					<div class="span5">
						<p class="padding40">
						<c:set var="now" value="<%=new java.util.Date()%>" />
						<s:if test="%{requestDetails.bidmemoDetails.dateBidMemoCreated !=null}">
							<s:property value="requestDetails.bidmemoDetails.dateBidMemoCreated" />
						</s:if>
						<s:else>
							<fmt:formatDate pattern="dd MMM yyyy" value="${now}" />
						</s:else>
						</p>
					</div>
				</div> <!-- end of block -->
				
				
				<div class="row">
				    <div class="span12">
					    <div class="form-row">
						    <label><s:text name="label.request.expirationDate" /></label>
						    <s:textfield name="requestDetails.bidmemoDetails.expirationDateTime" theme="aloc" cssClass="date" id="expTime"></s:textfield>
						    <p class="guidance">DD MMM YYYY</p>
					    </div>
				    </div>
				</div> <!-- end of block -->
				<div class="row">
						<div class="span5">
							<div class="form-row">
								<label> <s:text name="label.request.ExpirationTime"></s:text> 
								</label> 
								<s:textfield name="hours" maxlength="2"
											cssClass="span1c bigInt" id="expHours"
										/> : <s:textfield name="minutes" maxlength="2"
											cssClass="span1c bigInt" id="expMins"
										/> 
								<s:select headerKey="" key="" list="#{'AM':'AM','PM':'PM'}" cssClass="span1c"  cssStyle="margin-bottom:0px; width:50px!important;"
									id="selectPeriod" name="period" />
													
								 EST
								<p class="guidance">&nbsp; &nbsp; HH&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
									&nbsp;MM</p>
							<span style="color:red"><s:fielderror>
								<s:param>hours</s:param>
								<s:param>minutes</s:param>
							</s:fielderror></span>
							</div>
						</div>
					</div>
					<s:hidden name="requestDetails.bidmemoDetails.selectBankFlag"  id="selectBankFlag" />
					<s:hidden name="requestDetails.instrumentTypeId" id="instrumentTypeId" />
									
					