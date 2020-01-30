<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty requestDetails.issuingBankDetails.bankName or (empty bankSelection or (not empty bankSelection and bankSelection eq 'New'))}">
	        <c:set var="bankNameClass" value="display: none;"/>
	         <c:set var="bankNameClearStyle" value="display: none;"/>
    	</c:if>
		<c:if test="${not empty requestDetails.issuingBankDetails.bankName or (not empty bankSelection and bankSelection eq 'Selected')}">
			<c:set var="bankNameClass" value="display: block;"/>
			<c:set var="bankNameClearStyle" value="display: inline;"/>
		</c:if>
<c:if test="${param.page ne 'BGBidAward'}">
		<p class="required-fields"> <s:text name="label.request.common.allFieldsRequiredUnlessSpecified"/> </p>
		<div class="row">
			<div class="span2">
				<div class="form-row">
					<label>
						<s:text name="label.request.biddingBankName"></s:text>:
					</label>
				</div>
			</div>
			<div class="span9">
				<div class="form-row" style="margin-left: -60px;">
						<c:out value="${bankLookupName}"></c:out>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="span2">
				<div class="form-row">
					<label>
						<s:text name="Country of issuance"></s:text>:
					</label>
				</div>
			</div>
			<div class="span9">
				<div class="form-row" style="margin-left: 0px;">
						<s:property value="bankCountry"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-row">
                <div class="span3">
					<s:textfield name="bankLookupName" 
						id="issuingBankNameId" 
						key="label.common.siteAdmin.bankName" 
						theme="aloc"
						cssClass="span3 lookup-filterValue"
					/>	
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
				<div class="span3">
					<sj:autocompleter id="bankCountryCodeId" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
							name="bankCountryCd" cssClass="span2 bankCountryCode" listKey="countryCode" listValue="countryName" 
							parentTheme="aloc" onChangeTopics="getAutocompleterName" key="label.request.common.country"/>
					<s:hidden name="bankCountry" id="bankCountryNameId" cssClass="autoCompleterName"></s:hidden>	
				</div>
				<div class="span2">
					<s:textfield name="bankCity" cssStyle="width: 132px;" id="bankCity" key="label.request.common.city" cssClass="bankCityName" theme="aloc" />
				</div>
				<div class="span1">
					<label>&nbsp;</label>
					<s:url action="BankDetailsLookup" namespace="/int" var="getBankNameURL" escapeAmp="false">
					</s:url>
					<a class="btn-secondary lookup" href="<s:property value="#getBankNameURL"/>" ><s:text name="label.request.common.lookup"/></a>&nbsp;
	            </div>
                <div class="span1">
                   	<label>&nbsp;</label>
                   	<img alt="Loading..." id="bankIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px">
                </div>
	         </div>
		</div>
		
		<!-- end of block -->
		 <div id="bankDetails" class="conditional-row hide" style="${bankNameClass}">
                	<s:hidden name="bankSelection" id="bankSelectionId"></s:hidden>
                	<%-- <s:hidden name="siteAdmin.bankDetails.bankMDMId" id="bMDMId"></s:hidden> --%>
                	<s:hidden name="requestDetails.issuingBankDetails.bankName" id="bankName"></s:hidden>
                	<s:hidden name="requestDetails.issuingBankDetails.addressDtls.address[0]" id="bankAddress1"></s:hidden>
                	<s:hidden name="requestDetails.issuingBankDetails.addressDtls.address[1]" id="bankAddress2"></s:hidden>
                	<s:hidden name="requestDetails.issuingBankDetails.addressDtls.city" id="bankAddressCity"></s:hidden>
                	<s:hidden name="requestDetails.issuingBankDetails.addressDtls.stateProvince" id="bankAddressState"></s:hidden>
                	<s:hidden name="requestDetails.issuingBankDetails.addressDtls.ZIPPostalCode" id="bankAddressZip"></s:hidden>
                	<s:hidden name="requestDetails.issuingBankDetails.addressDtls.country" id="bankAddressCountry"></s:hidden>
                	<s:hidden name="requestDetails.issuingBankDetails.BIC" id="bankBicCode"></s:hidden>
                    <div class="row">
                        <div class="span7">
                        	<div class="row firstrow">
                            <div class="form-row span4">
                                <p><s:property value="requestDetails.issuingBankDetails.bankName"/><br />
                                <s:iterator value="requestDetails.issuingBankDetails.addressDtls.address">
                                	<s:property /><br />
                                </s:iterator>
                                <s:property value="requestDetails.issuingBankDetails.addressDtls.city"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="requestDetails.issuingBankDetails.addressDtls.stateProvince"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <s:property value="requestDetails.issuingBankDetails.addressDtls.ZIPPostalCode"/><br />
                                <s:property value="requestDetails.issuingBankDetails.addressDtls.country"/></p>

                            </div>
                            </div>
                            <div class="row lastrow">
			                    <div class="span2c">
			                        <label><s:label key="label.common.siteAdmin.bankIdentifierCodeC" /></label>
			                    </div>
			                    <div class="span4">
			                        <p><s:property value="requestDetails.issuingBankDetails.BIC"/></p>
			                    </div>
			                </div> 
                    	</div>
                    </div>
           </div>
			
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<label>
							<s:text name="label.request.ExpirationDate"></s:text>:
						</label>
					</div>
				</div>
				<div class="span9">
					<div class="form-row" style="margin-left: -60px;">
							<s:property value="requestDetails.instrumentDetails.expiryDt" />
					</div>
				</div>
			</div>
		
			<div class="row">
				<div class="span2a">
					<div class="form-row">
						<s:textfield name="requestDetails.issuingBankDetails.USExpirationDate" 
								cssClass="date" 
								id="usExpirationDate" 
								key="label.request.usExpirationDate" 
								theme="aloc"/>
					</div>
				</div>
			</div><br>
		
		<div class="row highlighted lastrow">
			<div class="span12">
				<div class="form-row">
					<p style="padding: 10px;">
						<s:text name="label.request.issuingBankInfo1"/><br /> 
						<s:text name="label.request.issuingBankInfo2"/> <br /> <br /> 
						<s:text name="label.request.issuingBankInfo3"/> <br /> <br />
						<s:text name="label.request.issuingBankInfo4"/><br />
						<s:text name="label.request.issuingBankInfo5"/><br />
						<s:text name="label.request.issuingBankInfo6"/>
					</p>
				</div>
			</div>
		</div>
</c:if>
<c:if test="${param.page eq 'BGBidAward'}">
	  <div class="row">
			<div class="span3b">
				<div class="form-row">
					<label>
						<s:text name="label.request.bankBranch"></s:text>:
					</label>
				</div>
			</div>
			<div class="span5 left">
                        	<div class="row firstrow">
                            <div class="form-row span4">
                                <p><s:property value="requestDetails.issuingBankDetails.bankName"/><br />
                                <s:iterator value="requestDetails.issuingBankDetails.addressDtls.address">
                                	<s:property /><br />
                                </s:iterator>
                                <s:property value="requestDetails.issuingBankDetails.addressDtls.city"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="requestDetails.issuingBankDetails.addressDtls.stateProvince"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <s:property value="requestDetails.issuingBankDetails.addressDtls.ZIPPostalCode"/><br />
                                <s:property value="requestDetails.issuingBankDetails.addressDtls.country"/></p>

                            </div>
                            </div>
			</div>
		</div>
		<div class="row">
			<div class="span3b">
				<div class="form-row">
					<label>
						<s:text name="label.common.siteAdmin.bankIdentifierCodeC"></s:text>
					</label>
				</div>
			</div>
			<div class="span5 left">
					<div class="form-row">
							<s:property value="requestDetails.issuingBankDetails.BIC"/>
					</div>
				</div>
		</div>
		
			<div class="row">
				<div class="span3b">
					<div class="form-row">
						<label><s:text name="label.request.ExpirationDate" />:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
							<s:property value="requestDetails.instrumentDetails.expiryDt"/>
					</div>
				</div>
          </div>
			
			<div class="row">
				<div class="span3b">
					<div class="form-row">
						<label><s:text name="label.request.usExpirationDate" />:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						    <s:property value="requestDetails.issuingBankDetails.USExpirationDate"/>
					</div>
				</div>
          </div>
</c:if>