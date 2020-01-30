<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<c:if test="${param.includeScripts != false}">
    <!--[if IE]>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/PIE.js"></script>
	<![endif]-->
     <script type="text/javascript">
		$(document).ready(function() {
			onloadTooltipsRoundedBut();
			autoTextarea();
			autoTextarea50();
			decCounter("siteName", 50);
			decCounter("description", 50);
		});
	</script>
</c:if>

<div id="createSiteDiv">  
	<c:choose>
	<c:when test="${modifySite eq true}">
	</c:when>
	<c:otherwise>
			<c:if test="${siteIdCreate eq true}">
            	<s:hidden name="siteAdmin.siteType.siteTypeId" id="siteTypeId" />
            </c:if>
         	<div class="row txtCnt">
            	<div class="span12">
               		<div class="form-row">
                    	<s:textfield name="siteAdmin.siteName"
                    	       	tooltip="%{getText('label.siteAdmin.tooltip.siteName')}"
								id="siteName" 
								key="label.siteAdmin.siteName" 
								theme="aloc"
								cssClass="autosze50"
								maxlength="50"
						/>	
                       <div class="clear"></div>
                       <div class="counter"><s:text name="label.common.siteAdmin.fifty" /></div> <!-- fix positions -->
                       <div class="counterTxt"><p class="guidance"><s:text name="label.common.siteAdmin.charLeftFifty" /></p></div>
                       
                       <div class="errorMsg">
	                       <img alt="Loading..." id="siteNameProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
	                       <img src="${pageContext.request.contextPath}/img/yes.png" title="Model Enabled" id="matched" style="vertical-align: middle;display:none;" />
						   <img src="${pageContext.request.contextPath}/img/no.png" title="Model Disabled" id="unMatched" style="vertical-align: middle;display:none;"/>
						   <span class="siteNameStr"></span>
                       </div>
             	   </div>
               </div>
           </div>
           <div class="row">
               <div class="span12">
               		<div class="form-row">
               			<s:textfield name="siteAdmin.sitePrefix" readonly="%{editMode}"
                   			tooltip="%{getText('label.siteAdmin.tooltip.sitePrefix')}"
							id="sitePrefix" 
							key="label.siteAdmin.sitePrefix" 
							theme="aloc"
							maxlength="6"
							cssClass="span1"
						/>
						<div class="clear"></div>
						<div class="errorMsgSmall">	
							<img alt="Loading..." id="sitePrefixProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
							<img src="${pageContext.request.contextPath}/img/yes.png" title="Model Enabled" id="prefixMatched" style="vertical-align: middle;display:none;" /> 
							<img src="${pageContext.request.contextPath}/img/no.png" title="Model Disabled" id="prefixUnMatched" style="vertical-align: middle;display:none;" />
							<span class="sitePrefixStr"></span>
	 					</div>
	 					<p style="padding-top:5px"><s:text name="label.common.siteAdmin.charlimitSix" /></p>
               		</div>
               </div>
           </div>
           <div class="row txtCnt">
               <div class="span12"> 
               		<div class="form-row autosize-container">
                   		<s:textarea name="siteAdmin.description"
							cols="50" 
							rows="2" 
							id="description" 
							theme="aloc" 
							key="label.common.siteAdmin.description" 
							cssClass="autosze50 messageinput"
							onKeyPress="return imposeMaxLength(this, 49);"
						/>
                       <div class="clear"></div>
                       <div class="counter"><s:text name="label.common.siteAdmin.fifty" /></div> <!-- fix positions -->
                       <div class="counterTxt"><p class="guidance"><s:text name="label.common.siteAdmin.charLeftFifty" /></p></div>
              		</div>
               </div>
           </div>
         </c:otherwise>
	</c:choose>     
    <div class="hide" id="parentSiteCreate">
          <div class="row">
              <div class="span12">
	               <div class="form-row">
	                   <label class="optional"><s:text name="label.common.siteAdmin.parentSite" /></label>
	                   <s:select list="#{}" 
							listKey="name" 
							listValue="name" 
							id="parentsites" 
							name="siteAdmin.parentSite.parentSiteId"
							required="false"
			 			/>
			  			<img alt="Loading..." id="parentSiteDescProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
              	   </div>                                            
              </div>                                            
          </div>
          <jsp:include page="/jsp/siteadmin/common/showChildSites.jsp" />
	</div><!-- parentSite ends here -->
            
	<c:if test="${empty siteAdmin.bankDetails.name or (empty bankSelection or (not empty bankSelection and bankSelection eq 'New'))}">
		<c:set var="bankNameClass" value="display: none;"/>
        <c:set var="bankNameClearStyle" value="display: none;"/>
  	</c:if>
	<c:if test="${not empty siteAdmin.bankDetails.name and ((not empty bankSelection and bankSelection eq 'Selected') or ((modifySite eq true or copySite eq true) and (empty bankSelection or bankSelection ne 'New')))}">
		<c:set var="bankNameClass" value="display: block;"/>
		<c:set var="bankNameClearStyle" value="display: inline;"/>
	</c:if>                

    <div id="BankNameCreate" class="hide conditional-row">
		<div class="row">
			<div class="form-row">
				<div class="span3">
					<s:textfield name="bankName" 
						id="issuingBankNameId" 
						key="label.common.siteAdmin.bankName" 
						theme="aloc"
						cssClass="span3 lookup-filterValue"
						tooltip="%{getText('label.siteAdmin.tooltip.bankLookup')}"
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
					<s:url action="BankDetailsLookup" namespace="/int" var="getBankNameURL" escapeAmp="false"></s:url>
					<a class="btn-secondary lookup" href="<s:property value="#getBankNameURL"/>" ><s:text name="label.common.siteAdmin.lookup"/></a>&nbsp;
	            </div>
                <div class="span1">
                   	<label>&nbsp;</label>
                   	<img alt="Loading..." id="leIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px">
                </div>
	         </div>
		</div>
            
		<div id="bankDetails" class="conditional-row hide" style="${bankNameClass}">
           	<s:hidden name="bankSelection" id="bankSelectionId"></s:hidden>
           	<s:hidden name="siteAdmin.bankDetails.bankMDMId" id="bMDMId"></s:hidden>
           	<s:hidden name="siteAdmin.bankDetails.name" id="bankName"></s:hidden>
           	<s:hidden name="siteAdmin.bankDetails.address[0]" id="bankAddress1"></s:hidden>
           	<s:hidden name="siteAdmin.bankDetails.address[1]" id="bankAddress2"></s:hidden>
           	<s:hidden name="siteAdmin.bankDetails.city" id="bankAddressCity"></s:hidden>
           	<s:hidden name="siteAdmin.bankDetails.stateProvince" id="bankAddressState"></s:hidden>
           	<s:hidden name="siteAdmin.bankDetails.ZIPPostalCode" id="bankAddressZip"></s:hidden>
           	<s:hidden name="siteAdmin.bankDetails.country" id="bankAddressCountry"></s:hidden>
           	<s:hidden name="siteAdmin.bankDetails.bankIdentifierCode" id="bankBicCode"></s:hidden>
           	<s:hidden name="siteAdmin.bankDetails.countryCd" id="bankCountryCode"></s:hidden>
            <div class="row">
				<div class="span7">
					<div class="row firstrow">
						<div class="form-row span4">
                              <p><s:property value="siteAdmin.bankDetails.name"/><br />
                              <s:iterator value="siteAdmin.bankDetails.address">
                              	<s:property /><br />
                              </s:iterator>
                              <s:property value="siteAdmin.bankDetails.city"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="siteAdmin.bankDetails.stateProvince"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <s:property value="siteAdmin.bankDetails.ZIPPostalCode"/><br />
                              <s:property value="siteAdmin.bankDetails.country"/></p>
						</div>
					</div>
                    <div class="row lastrow">
						<div class="span2c">
							<label><s:label key="label.common.siteAdmin.bankIdentifierCodeC" /></label>
		                </div>
			            <div class="span4">
			                <p><s:property value="siteAdmin.bankDetails.bankIdentifierCode"/></p>
			            </div>
	               	</div> 
				</div>
			</div>
		</div>
             
		<div id="bankBICOverride" class="conditional-row hide" style="${bankNameClass}">
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="siteAdmin.bankSWIFTConfiguration.bankIdentifierCodeAddress"
							id="bicCodeOverride" 
							key="label.siteAdmin.bankIdentifierCodeOverrideAddressOpt" 
							theme="aloc"
							maxlength="11"
							required="false"
					   	/>	
					</div>  
				</div>  
			</div>
		</div>
 	</div><!-- bank name ends here -->
             
	<s:hidden name="siteAdmin.siteId" value="%{siteAdmin.siteId}" id="siteId"/>
    <jsp:include page="/jsp/siteadmin/common/leDetailsHeaderSite.jsp"></jsp:include>
</div>