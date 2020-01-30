<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${param.includeScripts != false}">
<script type="text/javascript">
$(document).ready(function() {
	instTrasactionOriginGoods();
	lcPaymentTermsSelect();
	dlocUSDShow();
	decCounter("projDesc", 300);
	decCounter("othPaymentDesc", 50);
	sendbackOnloadShow();
});
</script>
</c:if>
<s:set name="isEditMode" value="editMode"/>
	<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST' && #attr.isTaxonomy != true) && requestDetails.transactionDetails.requiresEdits)}">
		<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.transactionDetails.requiresEdits}">
						<div class="row">
							<div class="span12">
								<div class="errorbox">
									<div class="noteHead">
										<p class="noteicon">
											<s:text name="label.common.alert" />
										</p>
									</div>
									<div class="noteContent">
										<p>
											<s:property value="requestDetails.transactionDetails.sendBackNotes" />
										</p>
									</div>
								</div>
							</div>
						</div>
				 </s:if>
		
		<a name="fifth"></a>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<div class="txtCnt3"></div>
					<s:textarea name="requestDetails.transactionDetails.projectDesc" onkeypress="return imposeMaxLength(this, 299);"
					 theme="aloc" cols="50" rows="1" cssClass="autosize3 messageinput mandatory"
					 id="projDesc" key="label.request.projectDescriptionGoodsBeingSold"></s:textarea>
					<div class="clear"></div>
                     <div class="counter">300</div> <!-- fix positions -->
                     <div class="counterTxt"><p class="guidance"><s:text name="label.request.characters" /></p></div>
				</div>
			</div>
		</div>
		<!-- end of block -->
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<sj:autocompleter id="issuanceCountryCd" onChangeTopics="getAutocompleterName" 
					list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" key="label.request.CountryOfIssuance"
					name="requestDetails.transactionDetails.issuanceCountryCd" cssClass="span3" 
					listKey="countryCode" listValue="countryName" parentTheme="aloc"/>	
					<s:hidden name="requestDetails.transactionDetails.issuanceCountry" id="issuanceCountry" cssClass="autoCompleterName mandatory"></s:hidden>				 
			</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.transactionDetails.contranctAmt" maxlength="21"
					 theme="aloc" key="label.request.contractAmount" cssClass="span3 mandatory bigDecimal"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<sj:autocompleter id="contranctCurId" onChangeTopics="getCurrencyAutocompleterName" 
					list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}" key="label.request.contractCurrency"
					name="requestDetails.transactionDetails.contranctCurId" cssClass="span3" 
					listKey="currencyCode" listValue="currencyName" parentTheme="aloc"/>					   	
					<p class="guidance">
						<s:text name="label.request.searchForCurrency"/>
					</p>
					<s:hidden name="requestDetails.transactionDetails.contranctCur" id="bidCurrId" cssClass="autoCompleterName mandatory"></s:hidden>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<sj:autocompleter id="currenciesCd" key="label.request.documentaryLCcurrency"
					list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}" onChangeTopics="getCurrencyAutocompleterName,getUSDConversion" 
					name="requestDetails.transactionDetails.docLCCurId" cssClass="span3" 
					listKey="currencyCode" listValue="currencyName" parentTheme="aloc"/>
					
					<p class="guidance">
						<s:text name="label.request.searchForCurrency"/>
					</p>
					<s:hidden name="requestDetails.transactionDetails.docLCCur" id="currencies" cssClass="autoCompleterName mandatory"></s:hidden>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.transactionDetails.docLCAmt" theme="aloc" maxlength="21"
					key="label.request.DocumentaryLCamount" cssClass="currencyAmt mandatory bigDecimal" id="docLCAmt"/>
				</div>
			</div>
		</div>

		<div class="row" id="usdEquivalentDiv" style="display: none">
			<div class="span5 left">
				<div class="targetUsd form-row">
					<p style="padding: 5px;" id="intusdEquivalent" class="defaultFontSize">
						<b><s:text name="label.request.USDDocumentaryLCAmount" /></b> <span
							style="padding-left: 10px"> <s:property
								value="requestDetails.transactionDetails.USDEquivalent" /></span>
					<img alt="Loading..." id="bidUSDProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display: none; height: 20px; width: 20px;">
					</p>
					<s:hidden id="instUsdEquivalentAmount"
						name="requestDetails.transactionDetails.USDEquivalent"
						value="%{requestDetails.transactionDetails.USDEquivalent}"></s:hidden>
				</div>
			</div>
			<span style="color: red"><s:fielderror fieldName="requestDetails.transactionDetails.USDEquivalent"/></span>
			<!-- end of block -->
		</div>
		<div class="row usdEquivalentErrorDiv" style="display: none;">
            <div class="span12">
                <div class="errorbox">
                	<div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
						<div class="errorContent">
	                		<p id="usdEquivalentError"></p>
               			</div>
               	</div>
           	 </div>
       	</div>	
		<div class="row">
			<div class="span12">
				<div class="form-row" style="padding-top:5px;">
					<c:if test="${empty requestDetails.transactionDetails or empty requestDetails.transactionDetails.shipmentOrigins or empty requestDetails.transactionDetails.shipmentOrigins[0].countryCd}">
						<c:set var="countryRefIndex" value="0"></c:set>
					</c:if>
					<c:if test="${not empty requestDetails.transactionDetails.shipmentOrigins}">
						<c:set var="countryRefIndex" value="${fn:length(requestDetails.transactionDetails.shipmentOrigins)}"></c:set>
						<c:if test="${countryRefIndex gt 0}">
							<c:set var="countryRefIndex" value="${countryRefIndex - 1}"></c:set>
						</c:if>
					</c:if>
					<input type="hidden" id="shipOrgCtryFieldAddIndexId" name="shipOrgCtryFieldAddIndex" 
						class="referenceIndex" value="${countryRefIndex}">
					<input type="hidden" name="sectionName" class="sectionName" value="instShipCountry">
                    <table style="border: 0; width: 100%;" id="additionalCountryRef" class="additionalTable">
                    	<tr>
                        	<td height="1" class="noPadding">
								<sj:autocompleter id="shipCountryCd" key="label.request.shipmentOriginCountry"
								list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" onChangeTopics="getAutocompleterName1"
								name="requestDetails.transactionDetails.shipmentOrigins[0].countryCd" cssClass="span3" 
								listKey="countryCode" listValue="countryName" parentTheme="aloc" tooltip="%{getText('label.request.tooltip.originOfgoodsToolTipInfo')}"/>					   	
			                <s:hidden name="requestDetails.transactionDetails.shipmentOrigins[0].countyName" id="shipCountry" cssClass="autoCompleterName mandatory"></s:hidden>
                            </td>
						</tr>
                        <c:if test="${not empty requestDetails.transactionDetails.shipmentOrigins and countryRefIndex >= 1}">
                        <c:forEach items="${requestDetails.transactionDetails.shipmentOrigins}" begin="1" varStatus="statIndex">
                            <tr class="optional">
                            	<td height="1" style="padding:10px 0px 5px 0px;">
                            	<c:if test="${statIndex.count eq 1}">
						         <sj:autocompleter id="shipCountryCd1" onChangeTopics="getAutocompleterName1"
						         list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" key="label.request.shipmentOriginCountry2Optional"
						         name="requestDetails.transactionDetails.shipmentOrigins[1].countryCd" cssClass="referenceTextValue span3" 
						         listKey="countryCode" listValue="countryName" parentTheme="aloc" tooltip="%{getText('label.request.tooltip.originOfgoodsToolTipInfo')}"/>					   	
				       		  <s:hidden name="requestDetails.transactionDetails.shipmentOrigins[1].countyName" id="shipCountry1" cssClass="autoCompleterName"></s:hidden>
								</c:if>
								<c:if test="${statIndex.count eq 2}">
					              <sj:autocompleter id="shipCountryCd2" onChangeTopics="getAutocompleterName1"
					              list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" key="label.request.shipmentOriginCountry3Optional"
					              name="requestDetails.transactionDetails.shipmentOrigins[2].countryCd" cssClass="referenceTextValue span3" 
					              listKey="countryCode" listValue="countryName" parentTheme="aloc" tooltip="%{getText('label.request.tooltip.originOfgoodsToolTipInfo')}"/>					   	
					              <s:hidden name="requestDetails.transactionDetails.shipmentOrigins[2].countyName" id="shipCountry2" cssClass="autoCompleterName"></s:hidden>
								</c:if>
								&nbsp;<a href="javascript:;" class="delete-ce" >Remove Shipment origin country</a>
                            	</td>
                            </tr>
                           </c:forEach>
                         </c:if>
					</table>
					<div style="height: 8px;"></div>
                    <a href="javascript:;" class="add-exception" id="addadditionalCountryRef"
                    	style="display: ${countryRefIndex < 2 ? 'block' : 'none'}"><s:text  name="label.request.addOriginCountry"/></a>
				</div>
			</div><!-- end of block -->
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<sj:autocompleter id="shipmentDestCountryCd" key="label.request.shipmentDestinationCountry"
					list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" onChangeTopics="getAutocompleterName" 
					name="requestDetails.transactionDetails.shipmentDestCountryCd" cssClass="span3" 
					listKey="countryCode" listValue="countryName" parentTheme="aloc"/>	
					<s:hidden name="requestDetails.transactionDetails.shipmentDestCountry" id="shipmentDes" cssClass="autoCompleterName mandatory"></s:hidden>				   	
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="span11">
				<div class="form-row" style="padding-top:5px;">
					<c:if test="${empty requestDetails.transactionDetails or empty requestDetails.transactionDetails.goodsOrigins}">
						<c:set var="goodsRefIndex" value="0"></c:set>
					</c:if>
					<c:if test="${not empty requestDetails.transactionDetails.goodsOrigins}">
						<c:set var="goodsRefIndex" value="${fn:length(requestDetails.transactionDetails.goodsOrigins)}"></c:set>
						<c:if test="${goodsRefIndex gt 0}">
							<c:set var="goodsRefIndex" value="${goodsRefIndex - 1}"></c:set>
						</c:if>
					</c:if>
					<input type="hidden" id="originGoodsFieldAddIndexId" name="originGoodsFieldAddIndex" 
						class="referenceIndex" value="${goodsRefIndex}">
					<input type="hidden" name="sectionName" class="sectionName" value="instOriginGoods">
                    <table style="border: 0; width: 100%;" id="additionalGoodsRef" class="additionalTable">
                    	<tr>
                        	<td height="1" class="noPadding">
								<sj:autocompleter id="originOfGoodsCd" key="label.request.originOfGoods"
								list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
								name="requestDetails.transactionDetails.goodsOrigins[0].countryCd" cssClass="span3" 
								listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterNameAndUS" tooltip="%{getText('label.request.tooltip.originOfgoodsToolTipInfo')}"/>
							<s:hidden name="requestDetails.transactionDetails.goodsOrigins[0].countyName" id="originOfGoods" cssClass="autoCompleterName mandatory"></s:hidden>
                            </td>
						</tr>
                        <c:if test="${not empty requestDetails.transactionDetails.goodsOrigins and goodsRefIndex >= 1}">
                        <c:forEach items="${requestDetails.transactionDetails.goodsOrigins}" begin="1" varStatus="statIndex">
                            <tr class="optional">
                            	<td height="1" style="padding:10px 0px 5px 0px;">
                            	<c:if test="${statIndex.count eq 1}">
					            <sj:autocompleter id="originOfGoodsCd1" 
				              	list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" key="label.request.originOfGoods2Optional"
					            name="requestDetails.transactionDetails.goodsOrigins[1].countryCd" cssClass="referenceTextValue span3" 
					            listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterNameAndUS" tooltip="%{getText('label.request.tooltip.originOfgoodsToolTipInfo')}"/>
				      		            &nbsp;
					            <s:hidden name="requestDetails.transactionDetails.goodsOrigins[1].countyName" id="originOfGoods1" cssClass="autoCompleterName"></s:hidden>
								</c:if>
								<c:if test="${statIndex.count eq 2}">
					            <sj:autocompleter id="originOfGoodsCd2" key="label.request.originOfGoods3Optional"
					            list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
					            name="requestDetails.transactionDetails.goodsOrigins[2].countryCd" cssClass="referenceTextValue span3" 
					            listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterNameAndUS" tooltip="%{getText('label.request.tooltip.originOfgoodsToolTipInfo')}"/>
					           <s:hidden name="requestDetails.transactionDetails.goodsOrigins[2].countyName" id="originOfGoods2" cssClass="autoCompleterName"></s:hidden>
								</c:if>
								&nbsp;<a href="javascript:;" class="delete-ce" >Remove Origin of goods</a>
                            	</td>
                            </tr>
                           </c:forEach>
                         </c:if>
					</table>
					<div style="height: 8px;"></div>
                    <a href="javascript:;" class="add-exception" id="addadditionalGoodsRef"
                    	style="display: ${goodsRefIndex < 2 ? 'block' : 'none'}"><s:text  name="label.request.addOriginOfGoods"/></a>
				</div>
			</div><!-- end of block -->
		</div>
			<div class="row" id="usPercentID" style="display:none;">
			<div class="span12">
				<div class="form-row">
					<s:radio cssClass="radio countUsa" id="USContentPercent"
					key="label.request.PercentUSContent"
					name="requestDetails.transactionDetails.USContentPercent"
					theme="aloc" 
					list="#{'More than 50':'More than 50%','Less than 50':'Less than 50%'}" />
				</div>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<sj:autocompleter id="prefLocCountryCd" key="label.request.preferredLocation"
					list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" onChangeTopics="getAutocompleterName"
					name="requestDetails.transactionDetails.preferedLocCountryCd" cssClass="span3" 
					listKey="countryCode" listValue="countryName" parentTheme="aloc"/>					   	
                <s:hidden name="requestDetails.transactionDetails.preferedLocCountryName" id="prefLocCountry" cssClass="autoCompleterName"></s:hidden>
                </div>
			</div>
		</div>	
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:select headerKey="" headerValue="Select... " list="%{#attr['com.ge.aloc.StaticDataFactory'].lCPaymentTerms}" 
						name="requestDetails.transactionDetails.LCPaymentId" listKey="ID"
						listValue="name" cssClass="span3 mandatory" style="margin-bottom: 0px;"
						theme="aloc" id="lcPaymentTermsID" onchange="checkOther()" key="label.request.LCPaymentTerms"/>
				</div><br>
				<s:hidden name="requestDetails.transactionDetails.LCPaymentTerm" id="LCPaymentTerm" value="%{requestDetails.transactionDetails.LCPaymentTerm}"/> 
				<div class="hide" id="other">
					<div class="form-row">
						<div class="row lastrow">
							<div class="span12">
								<div class="txtCnt5"></div>
								<s:textarea name="requestDetails.transactionDetails.othPaymentDesc" 
									cols="50" rows="1" theme="aloc" id="othPaymentDesc" 
									key="label.request.OtherPaymentTermsDescription"
									cssClass="autosize5 messageinput" onkeypress="return imposeMaxLength(this, 49);"></s:textarea>
								<div class="clear"></div>
                     			<div class="counter">50</div> <!-- fix positions -->
                   			  <div class="counterTxt"><p class="guidance"><s:text name="label.request.characters" /></p></div>
							</div>
						</div>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div>
		<div class="row" id="conTypeID">
			<div class="span12">				
				<div class="form-row mandatory">
					<s:radio cssClass="radio"
					key="label.request.confirmationType"
					name="requestDetails.transactionDetails.confirmationType" 
					theme="aloc" 
					list="#{'Open':'Open','Silent':'Silent'}" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:select key="label.request.BankCharges" headerKey="" headerValue="Select... " list="%{#attr['com.ge.aloc.StaticDataFactory'].bankCharges}" 
						name="requestDetails.transactionDetails.bankChargesId" listKey="ID" listValue="name" cssClass="span3 mandatory" style="margin-bottom: 0px;" id="bankChargesId" theme="aloc"/>
				<s:hidden name="requestDetails.transactionDetails.bankChargesType" id="bankChargesType" value="%{requestDetails.transactionDetails.bankChargesType}"/> 
			   </div>
			</div>
		</div>
		<script type="text/javascript">
			refreshSectionCount('instrumentTransactionDetailsPanel');
		</script>
		</s:if>
		<s:elseif test="%{#isEditMode==false}">
                <div class="row">
				    <div class="span3b">
					    <div class="form-row">
						   <label> 
						   		<s:text name="label.request.ProjectDescription"/> :
						   </label>
					    </div>
				    </div>
					<div class="span5 left">
					    <div class="form-row">
                            <p class="padding40"><c:out value="${requestDetails.transactionDetails.projectDesc}"/></p>
					    </div>
				    </div>
			    </div> <!-- end of block -->
				<div class="row">
						<div class="span3b">
							<div class="form-row">
								<label><s:text name="label.request.countryOfIssuance"/></label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><c:out value="${requestDetails.transactionDetails.issuanceCountry}"/></p>
							</div>
						</div>
				</div>
				<div class="row">
						<div class="span3b">
							<div class="form-row">
								<label><s:text name="label.request.contractAmount"/> :</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><s:property value="requestDetails.transactionDetails.contranctAmt"/></p>
							</div>
						</div>
				</div>
				<div class="row">
						<div class="span3b">
							<div class="form-row">
								<label><s:text name="label.request.contractCurrency"/> :</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><c:out value="${requestDetails.transactionDetails.contranctCur}"/></p>
							</div>
						</div>
				</div>
				<div class="row">
						<div class="span3b">
							<div class="form-row">
								<label>
									<c:choose>
									<c:when test="${param.page eq 'BidReply'}">
										<s:text name="label.request.DocumentaryLCamount"/> :
									</c:when>
									<c:otherwise>
										<s:text name="label.request.documentaryLetterOfCreditAmount"/> :
									</c:otherwise>
								</c:choose>
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><s:property value="requestDetails.transactionDetails.docLCAmt"/></p>
							</div>
						</div>
				</div>
				<div class="row">
						<div class="span3b">
							<div class="form-row">
								<label>
									<c:choose>
									<c:when test="${param.page eq 'BidReply'}">
										<s:text name="label.request.documentaryLCcurrency"/> :
									</c:when>
									<c:otherwise>
										<s:text name="label.request.documentaryLetterOfCreditCurrency"/> :
									</c:otherwise>
								</c:choose>								
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><c:out value="${requestDetails.transactionDetails.docLCCur}"/></p>
							</div>
						</div>
				</div>
				
				<c:if test="${not empty requestDetails.transactionDetails.USDEquivalent}">
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label>
								<c:choose>
									<c:when test="${param.page eq 'BidReply'}">
										<s:text name="label.request.ApproximateUSDValue"/> :
									</c:when>
									<c:otherwise>
										<s:text name="label.request.uSDDocumentaryLetterOfCreditAmount"/> :
									</c:otherwise>
								</c:choose>	
							</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><s:property value="requestDetails.transactionDetails.USDEquivalent"/></p>
						</div>
					</div>
				</div>
				</c:if>
			
				<s:iterator value="requestDetails.transactionDetails.shipmentOrigins" status="orgCountry">		
					<div class="row">
						<div class="span3b">
							<div class="form-row">
								<label><s:text name="label.request.shipmentOriginCountry"/> &nbsp;<s:property value="%{#orgCountry.count}"/> :</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><c:out value="${countyName}"/></p>
							</div>
						</div>
					</div>		
				</s:iterator>
                <div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text name="label.request.shipmentDestinationCountry"/> :</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.transactionDetails.shipmentDestCountry}"/></p>
						</div>
					</div>
				</div>				
				<s:iterator value="requestDetails.transactionDetails.goodsOrigins" status="goodsOrg">
					<div class="row">
						<div class="span3b">
							<div class="form-row">
								<label><s:text name="label.request.originOfGoods"/> &nbsp;<s:property value="%{#goodsOrg.count}"/>:</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
									<p class="padding40"><c:out value="${countyName}"/></p>
							</div>
						</div>
					</div>
				</s:iterator>
				<c:if test="${not empty requestDetails.transactionDetails.USContentPercent}">
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text name="label.request.PercentUSContent"/> :</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.transactionDetails.USContentPercent}"/></p>
						</div>
					</div>
				</div>
				</c:if>					
				<c:if test="${param.page ne 'BidReply'}">
					<div class="row">
						<div class="span3b">
							<div class="form-row">
								<label>
									<s:text name="label.request.preferredLocation"/> :
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<c:out value="${requestDetails.transactionDetails.preferedLocCountryName}"/>
								</p>
							</div>
						</div>
					</div>
				</c:if>
					
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label>
								<c:choose>
									<c:when test="${param.page eq 'BidReply'}">
										<s:text name="label.request.Paymentterms"/> :
									</c:when>
									<c:otherwise>
										<s:text name="label.request.LCPaymentTerms"/> 
									</c:otherwise>
								</c:choose>
							</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.transactionDetails.LCPaymentTerm}"/></p>
						</div>
					</div>
				</div>	
				<s:if test="%{requestDetails.transactionDetails.LCPaymentTerm=='Other'}">	
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text name="label.request.OtherPaymentTermsDescription"/> :</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.transactionDetails.othPaymentDesc}"/></p>
						</div>
					</div>
				</div>	
				</s:if>	
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text name="label.request.confirmationType"/> :</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.transactionDetails.confirmationType}"/></p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text name="label.request.BankCharges"/> :</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.transactionDetails.bankChargesType}"/></p>
						</div>
					</div>
				</div>
		</s:elseif>
	