<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

		<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
		  <c:if test="${param.nameAndAddressOnly != true}">
			<div class="row">
					<div class="span2bc">
						<div class="form-row">
							<label><s:text name="label.request.isTriPartyRequest" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:if test="requestDetails.transactionParties.triPartyRequestFlag == true">
                                <s:text  name="label.request.common.yes"/>
                                </s:if>
                                <s:elseif test="requestDetails.transactionParties.triPartyRequestFlag == false">
                                <s:text  name="label.request.common.no"/>
                                </s:elseif></p>
						</div>
					</div>
			</div>
			<div class="row">
					<div class="span2bc">
						<div class="form-row">
							<label><s:text name="label.request.triPartyPrivateLabel" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:if test="requestDetails.transactionParties.privateLabelFlag == true">
                                <s:text  name="label.request.common.yes"/>
                                </s:if>
                                <s:elseif test="requestDetails.transactionParties.privateLabelFlag == false">
                                <s:text  name="label.request.common.no"/>
                                </s:elseif></p>
						</div>
					</div><!-- end of block -->
			</div>
		</c:if>
	</c:if>
<c:if test="${param.verify eq 'bidAward'}">
	
			<div class="row smallrow">
                <div class="span2">
                    <div class="form-row">
                        <label> <s:text  name="label.request.instrumentPurpose"/></label>
                    </div>
                </div>
                <div class="span5 left">
                    <div class="form-row">
                        <p><s:property value="requestDetails.transactionParties.instrumentPurpose" /></p>
                    </div>
                </div><!-- end of block -->
           </div>
          <c:if test="${requestDetails.transactionParties.instrumentPurpose eq 'Other'}">
           <div class="row smallrow">
                <div class="span2">
                    <div class="form-row"><label> <s:text  name="label.request.otherC"/></label></div>
                </div>
                <div class="span5 left">
	                 <div class="form-row">
		                <s:if test="%{requestDetails.transactionParties.instrumentPurposeOther != null && requestDetails.transactionParties.instrumentPurposeOther!=''}">   
			                 <p><s:property value="requestDetails.transactionParties.instrumentPurposeOther" /></p>     
		                </s:if>
		                <s:else><p> -</p> </s:else>
                     </div>  
                </div>
           </div>      
		</c:if>
	  <s:if test="requestDetails.transactionParties.triPartyRequestFlag == true">
		<h3>
			<s:text name="label.request.triPartyApplicant" />
		</h3>
		<div class="row">
			<div class="span12">
				<div class="row" style="margin-bottom: 0px;">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.triPartyname" /></label>
						</div>
					</div>
					<div class="span3 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.transactionParties.triPartyApplicant.name" /> <br />
								<s:iterator
									value="requestDetails.transactionParties.triPartyApplicant.address">
									<s:property />
									<br />
								</s:iterator>
	
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.city" />
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.stateProvince" />
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.ZIPPostalCode" />
								<br />
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.country" />
							</p>
						</div>
					</div>
				</div>
	
			</div>
		</div>
	</s:if>
	
	<h3>
			<s:text name="label.request.applicant" />
   </h3>

		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.applicantnameAdrs" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.name" />
						<br />
						<s:iterator
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address">
							<s:property />
							<br />
						</s:iterator>
	
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.city" />
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" />
						<br />
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.country" />
					</p>
				</div>
			</div>
		</div>
	
	    <h3>
			<s:text name="label.request.customer" />
		</h3>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.custnameAdrs" /></label>
				</div>
			</div>
			<div class="span5">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.name" />
						<br />
						<s:iterator
							value="requestDetails.transactionParties.customer.addressDtls.address">
							<s:property />
							<br />
						</s:iterator>
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.city" />
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.stateProvince" />
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode" />
						<br />
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.country" />
					</p>
				</div>
			</div>
		</div>
		
</c:if>	
<c:if test="${param.verify ne 'bidAward'}">	
		<h3>
			<s:text name="label.request.applicant" />
		</h3>

		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.nameAndAddress" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.name" />
						<br />
						<s:iterator
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address">
							<s:property />
							<br />
						</s:iterator>
	
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.city" />
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" />
						<br />
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.country" />
					</p>
				</div>
			</div>
		</div>
	
	<s:if test="requestDetails.transactionParties.triPartyRequestFlag == true">
		<h3>
			<s:text name="label.request.triPartyApplicant" />
		</h3>
		<div class="row">
			<div class="span12">
				<div class="row" style="margin-bottom: 0px;">
					<div class="span1a">
						<div class="form-row">
							<label><s:text name="label.request.nameAndAddress" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.name" />
								<br />
								<s:iterator
									value="requestDetails.transactionParties.triPartyApplicant.address">
									<s:property />
									<br />
								</s:iterator>
	
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.city" />
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.stateProvince" />
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.ZIPPostalCode" />
								<br />
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.country" />
							</p>
						</div>
					</div>
				</div>
	
			</div>
		</div>
	</s:if>
	
	<h3>
			<s:text name="label.request.customer" />
		</h3>
		<div class="row">
			<div class="span2a">
				<div class="form-row">
					<label><s:text name="label.request.nameAndAddress" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.name" />
						<br />
						<s:iterator
							value="requestDetails.transactionParties.customer.addressDtls.address">
							<s:property />
							<br />
						</s:iterator>
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.city" />
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.stateProvince" />
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode" />
						<br />
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.country" />
					</p>
				</div>
			</div>
		</div>
		
</c:if>	
		
