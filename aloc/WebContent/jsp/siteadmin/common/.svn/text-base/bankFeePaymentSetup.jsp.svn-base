<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
	
            <span class="required-fields fourth"><s:text  name="label.common.siteAdmin.allFieldsAreRequired"/></span>
           
            <div class="row">
				<div class="span12">
				<div class="form-row">
                	<sj:autocompleter key="label.siteAdmin.paymentCurrency" id="selectedCurrency" 
					list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}" 
					name="siteAdmin.bankFeePaymentSetup.bankPayments[0].paymentCurrency" cssClass="span3" 
					listKey="currencyCode" listValue="currencyName"
					onChangeTopics="getCurrencyAutocompleterName" parentTheme="aloc"
					/>
					<s:hidden name="siteAdmin.bankFeePaymentSetup.bankPayments[0].paymentCurrencyName" 
							id="paymentCurrency" cssClass="autoCompleterName"></s:hidden>
                </div>
                </div>
            </div>
            
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="siteAdmin.bankFeePaymentSetup.bankModelCode" 
							id="bankModelCode" 
							key="label.siteAdmin.modelCode" 
							theme="aloc"
							maxlength="50"
							/>
					</div>                
				</div>                
			</div>             
