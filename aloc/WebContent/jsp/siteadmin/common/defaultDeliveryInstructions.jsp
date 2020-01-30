<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	   
<p class="required-fields second"><s:text  name="label.common.siteAdmin.allFieldsAreRequired"/></p>

<s:if test="hasActionMessages()">
	<div id="siteMsg" style="margin-top:0px!important;">
		<div class="sucessMsg">
	    	<a href="javascript:;" class="right successclose" style="font-size: 20px; margin-right:5px;">X</a><s:text name="label.treasuryAdminPortal.success" />
		</div>
	    <div class="sucessContent"><s:actionmessage/></div>
	</div>
</s:if>    
<div class="row">

	<div class="span12">
		<div class="form-row">
			<label class="optional"><s:text  name="label.siteAdmin.deliverytype"/></label>
				<s:radio theme="aloc" cssClass="radio"
					name="siteAdmin.deliveryInstructions.deliveryType" 
					list="#{'true':'In-person pick-up','false':'Physical delivery (via courier or certified post)'}"
					value="%{siteAdmin.deliveryInstructions.deliveryType}"
					id="deliveryType" 
				/>
			</div>
		</div>
	</div>
            
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="siteAdmin.deliveryInstructions.companyName" 
					id="companyName" 
					key="label.siteAdmin.companyNameOpt" 
					required="false"
					theme="aloc"
					maxlength="30"
				/>
			</div>
		</div>
	</div>
            
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="siteAdmin.deliveryInstructions.firstName" 
					id="firstNameOpt" 
					key="label.siteAdmin.firstNameOpt" 
					required="false"
					theme="aloc"
					maxlength="30"
				/>
				<p><i><s:text  name="label.siteAdmin.givenName"/></i></p>
			</div>                 
		</div>                 
	</div>                 
            
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="siteAdmin.deliveryInstructions.lastName" 
					id="lastNameOpt" 
					key="label.siteAdmin.lastNameOpt" 
					required="false"
					theme="aloc"
					maxlength="30"
				/>
				<p><i><s:text  name="label.siteAdmin.surName"/></i></p>
			</div>     
		</div>     
	</div>     
            
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="siteAdmin.deliveryInstructions.title" 
					id="titleOpt" 
					key="label.siteAdmin.titleOpt" 
					required="false"
					theme="aloc"
					maxlength="10"
				/>
			</div>   
		</div>   
	</div>   
            
	<div id="pDelivery" class="hide">
            
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="siteAdmin.deliveryInstructions.address1" 
					id="address1Opt" 
					key="label.siteAdmin.address1Opt" 
					required="false"
					theme="aloc"
					maxlength="50"
				/>
			</div>  
		</div>  
	</div>  
            
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="siteAdmin.deliveryInstructions.address2" 
					id="address2Opt" 
					key="label.siteAdmin.address2Opt" 
					required="false"
					theme="aloc"
					maxlength="50"
				/>
             </div>   
		</div>   
	</div>   
            
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="siteAdmin.deliveryInstructions.city" 
					id="cityOpt" 
					key="label.siteAdmin.cityOpt" 
					required="false"
					theme="aloc"
					maxlength="30"
				/>
			</div>  
		</div>  
	</div>  
            
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<label class="optional"><s:text  name="label.siteAdmin.stateProvinceOpt"/></label> 
					<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
						name="siteAdmin.deliveryInstructions.stateProvince"/>
			</div>
		</div>
	</div>    
            
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="siteAdmin.deliveryInstructions.ZIPPostalcode" 
						id="zipPostalcode" 
						key="label.siteAdmin.zipPostalCodeOpt" 
						required="false"
						theme="aloc"
						maxlength="12"
				/>
			</div>     
		</div>     
	</div>     
            
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<label class="optional"> <s:text  name="label.siteAdmin.countryOpt"/></label>
				<sj:autocompleter id="selectedCountry" 
					list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
					name="siteAdmin.deliveryInstructions.country" cssClass="span3" 
					listKey="countryCode" listValue="countryName" theme="aloc"
					onChangeTopics="getAutocompleterName"
					/>	
			</div>   
		</div>   
	</div>   
	
</div><!-- physical delivery ends here --->
            
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="siteAdmin.deliveryInstructions.phoneNo" 
				id="phoneNo" 
				key="label.siteAdmin.phoneNumberOpt" 
				required="false"
				theme="aloc"
				maxlength="20"
			/>
		</div>
	</div>
</div>    
            
<div class="row">
	<div class="span12">
		<div class="form-row ckeckBoxLabel">
			<label class="checkbox">
				<s:checkbox name="siteAdmin.deliveryInstructions.ecopyMyself"></s:checkbox>
			</label><s:text  name="label.siteAdmin.sendElectronicCopytoMyself"/>
			
			<label class="checkbox">
			    <s:checkbox name="siteAdmin.deliveryInstructions.ecopyOtherGEPerson" id="sendElectronicCopy"></s:checkbox>
			</label>   <s:text  name="label.siteAdmin.sendElectronicCopytoOthergeRecipient"/>              
		</div>
	</div>
</div>  
            
<c:if test="${empty siteAdmin.deliveryInstructions.recipient.recipientLastName}">
	<c:set var="recipientClass" value="display: none;"/>
	<c:set var="recipientClearStyle" value="display: none;"/>
</c:if>
<c:if test="${not empty siteAdmin.deliveryInstructions.recipient.recipientLastName}">
	<c:set var="recipientClass" value="display: block;"/>
	<c:set var="recipientClearStyle" value="display: inline;"/>
</c:if>       
            
<div class="row hide" id="Recipient">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="geRecipient" 
				id="geRecipient" 
				key="label.siteAdmin.recipientOpt" 
				theme="aloc"
				required="false"
				cssClass="span3 lookup-filterValue"
			/>
			<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
			<s:url action="GEReferenceLookup" namespace="/int" var="getRecipientURL" escapeAmp="false"></s:url>
			<a class="btn-secondary lookup" href="<s:property value="#getRecipientURL"/>" ><s:text name="label.common.siteAdmin.lookup"/></a>
			<img alt="Loading..." id="recipientIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 25px;width: 25px">
			<br />
			<div><p class="guidance"><s:text name="label.request.partialLastName" /></p></div>
			<span class="lookup-error hide" style="color: #AE2C2C;"></span>
		</div>
	</div>
</div>        
            	
<div class="conditional-row hide" id="recipientShow" style="${recipientClass}">
	<div class="row">
		<div class="span7">
		
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<label><s:text  name="label.siteAdmin.recipient" /></label>
					</div>
				</div>
				<div class="span4">	
					<div class="form-row">
						<p><s:property value="siteAdmin.deliveryInstructions.recipient.recipientLastName"/>, <s:property value="siteAdmin.deliveryInstructions.recipient.recipientFirstName"/> - <s:property value="siteAdmin.deliveryInstructions.recipient.recipientSsoId"/></p>
						<s:hidden name="siteAdmin.deliveryInstructions.recipient.recipientLastName" id="recipientLastName"></s:hidden>
						<s:hidden name="siteAdmin.deliveryInstructions.recipient.recipientFirstName" id="recipientFirstName"></s:hidden>
						<s:hidden name="siteAdmin.deliveryInstructions.recipient.recipientSsoId" id="recipientSsoId"></s:hidden>
					</div>
				</div><!-- end of block -->
			</div>
			
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<label><s:text  name="label.siteAdmin.recipientEmail"/></label>
					</div>
				</div><!-- end of block -->
				<div class="span4">
					<div class="form-row">
						<p><s:property value="siteAdmin.deliveryInstructions.recipient.recipientEmail"/></p>
						<s:hidden name="siteAdmin.deliveryInstructions.recipient.recipientEmail" id="recipientEmail"></s:hidden>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>         

<div class="row txtCnt">
	<div class="span12">
		<div class="form-row">
			<s:textarea name="siteAdmin.deliveryInstructions.specialInstructions" 
				id="specialInstructions" 
				rows="2" cols="50"
				cssClass="autosize messageinput"
				key="label.siteAdmin.specialInstructionsOpt" 
				required="false"
				theme="aloc"
				onkeypress="return imposeMaxLength(this, 399);"
			/>
           <div class="clear"></div>
           <div class="counter"><s:text  name="label.common.siteAdmin.fourHundred"/></div> <!-- fix positions -->
           <div class="counterTxt"><p class="guidance"><s:text  name="label.common.siteAdmin.limit400Characters"/></p></div>
		</div>
	</div>                                                                                                                                                 
</div>
 	
<s:hidden name="ignoreParentSites" value="%{ignoreParentSites}" cssClass="ignoreParentSites"/>