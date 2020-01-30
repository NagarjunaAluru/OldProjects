<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:set name="isEditMode" value="editMode"/>
	  <s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'  && #attr.isTaxonomy != true) && requestDetails.bondInfo.requiresEdits == true)}">
	  		<c:if test="${param.includeScripts != false}">
			<script type="text/javascript">
			$(document).ready(function() {
				suretyUSDShow();
				decCounter("exactProjDesc",300);
				decCounter("otherInfo",300);
				});
			</script>
			</c:if>
	  		<div id="suretyBondDetailsForm">  
		  	<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.bondInfo.requiresEdits }">
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
									<s:property value="requestDetails.bondInfo.sendBackNotes" />
								</p>
							</div>
						</div>
					</div>
				</div>
			</s:if>
	  	
				<a name="seventh"></a>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<sj:autocompleter id="issuanceCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" name="requestDetails.bondInfo.issuanceCountryCd" 
									key="label.request.CountryOfIssuance" cssClass="span3 mandatory" listKey="countryCode" listValue="countryName" parentTheme="aloc"
									onChangeTopics="getAutocompleterName"/>
								<s:hidden name="requestDetails.bondInfo.issuanceCountryName" id="issuanceCountryName" cssClass="autoCompleterName"></s:hidden>
							</div>
						</div>						
					</div>
                <div class="row">
                     <div class="span12">
						<div class="form-row">
						<div class="txtCnt3"></div>
							<s:textarea name="requestDetails.bondInfo.exactProjDesc" onkeypress="return imposeMaxLength(this, 299);"
							 key="label.request.ProjectDescription" cols="50" rows="1" 
							 cssClass="span4 autosize3 messageinput mandatory" theme="aloc"
							 tooltip="%{getText('label.request.tooltip.projectDescription')}" id="exactProjDesc"/>
							<div class="clear"></div>
                     		<div class="counter">300</div> 
                     		<div class="counterTxt"><p class="guidance"><s:text name="label.request.charactersLimit" /></p></div>
			            </div>
			        </div> <!-- end of block -->
			    </div> 
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<label class="optional"><s:text name="label.request.projectInvitationOrBidNoOpt" /></label>
							<s:textfield name="requestDetails.bondInfo.invitationOrBidNo" id="invitationOrBidNo11" theme="aloc" cssClass="bigInt" maxlength="38"/>			
						</div>
					</div>
			    </div> 
                <div class="row">
                    <div class="span12">
						<div class="form-row">
							<label class="optional"><s:text name="label.request.pcityOfObligationOptional" /></label>
							<s:textfield name="requestDetails.bondInfo.obligationCity" id="obligationCity" theme="aloc" maxlength="50"/>	
			            </div>
			        </div>
				</div> 
                <div class="row">
						<div class="span12">
							<div class="form-row">
								 <label class="optional"><s:text name="label.request.stateOfObligation"/> <s:text name="label.request.optional"/></label>
									<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
										name="requestDetails.bondInfo.obligationCountryOrState" id="obligationCountryOrState" />
							</div>
						</div>
					</div>              
 
                <div class="row">
                    <div class="span12">
						<div class="form-row">
							<s:textfield key="label.request.Biddate" name="requestDetails.bondInfo.bidDt" 
							id="bidDt" cssClass="span2 date mandatory" theme="aloc"/>
			            </div>
			        </div>
				</div> 
                <div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield key="label.request.estimatedStartDate"  name="requestDetails.bondInfo.estStartDt" 
							id="estStartDt" cssClass="span2 date mandatory" theme="aloc"/>
						</div>
					</div>
			    </div> 
                <div class="row">
                    <div class="span12">
						<div class="form-row">
							<s:textfield key="label.request.estimatedCompletionDate" name="requestDetails.bondInfo.estCompletionDt"
							 id="estCompletionDt" cssClass="span2 date mandatory" theme="aloc"/>
			            </div>
			        </div>
				</div> 
				  <div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield key="label.request.expirationDate"  name="requestDetails.bondInfo.expirationDt" 
							id="expirationDt" cssClass="span2 date mandatory" theme="aloc"/>
						</div>
					</div>
			    </div> 
			    <div class="row">
						<div class="span12">
							<div class="form-row">
								<sj:autocompleter  
									list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
									name="requestDetails.bondInfo.bidBondCurrencyCd" cssClass="span3 mandatory" key="label.request.estimatedCurrencyCode"
									listKey="currencyCode" listValue="currencyName" parentTheme="aloc" id="currencies1" onChangeTopics="getCurrencyAutocompleterName,getBondInfoUSDConversion" />
								<p class="guidance">
								<s:text name="label.request.searchForCurrency" />
								</p>								
									<s:hidden name="requestDetails.bondInfo.bidBondCurrencyName" id="estBondCurrencyName" cssClass="autoCompleterName"></s:hidden>
						</div>
						</div>
					</div>
                <div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield key="label.request.estimatedBidAmount" name="requestDetails.bondInfo.estBidAmount"
							 id="estBidAmount" theme="aloc" cssClass="estBidAmount mandatory bigDecimal" maxlength="21"/>
						</div>
					</div>
			    </div> 
			    <div class="row" id="estUsdEquivalentDiv" style="display: none">
						<div class="span5 left">
							<div class="targetUsd form-row">
								<p style="padding: 5px;" id="estusdEquivalent" class="defaultFontSize">
									<b><s:text name="label.request.usdEstimatedBidAmount"/> : </b>
									<span style="padding-left: 10px">
									<s:property	value="requestDetails.bondInfo.USDEstimatedBondAmt" /></span>
								<img alt="Loading..." id="estBidUSDProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display: none; height: 20px; width: 20px;">
								</p>
								<s:hidden id="estBondUsdEquivalentAmount"
									name="requestDetails.bondInfo.USDEstimatedBondAmt"
									value="%{requestDetails.bondInfo.USDEstimatedBondAmt}"></s:hidden>
							</div>
						</div>
						<span style="color: red"><s:fielderror fieldName="requestDetails.bondInfo.USDEstimatedBondAmt"/></span>
						<!-- end of block -->
					</div>
				<div class="row estUsdEquivalentErrorDiv" style="display: none;">
            		<div class="span12">
                		<div class="errorbox">
                			<div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
								<div class="errorContent">
	                				<p id="estUsdEquivalentError"></p>
               					 </div>
               				 </div>
           			 </div>
       			 </div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<sj:autocompleter  
									list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
									name="requestDetails.bondInfo.currencyCd" cssClass="span3 mandatory" key="label.request.currencyCode"
									listKey="currencyCode" listValue="currencyName" parentTheme="aloc" id="currencies" onChangeTopics="getCurrencyAutocompleterName,getUSDConversion" />
								<p class="guidance">
								<s:text name="label.request.searchForCurrency" />
								</p>								
									<s:hidden name="requestDetails.bondInfo.currencyName" id="bondCurrencyName" cssClass="autoCompleterName"></s:hidden>
						</div>
						</div>
					</div>
				<div class="row">
						<div class="span12">
							<div class="form-row">
								<s:textfield key="label.request.bidBondAmount" name="requestDetails.bondInfo.bondAmount" 
									id="bondAmount" cssClass="currencyAmt mandatory" theme="aloc" maxlength="21"/>
							</div>
						</div>
				</div>
					 <div class="row" id="usdEquivalentDiv" style="display: none">
						<div class="span5 left">
							<div class="targetUsd form-row">
								<p style="padding: 5px;" id="intusdEquivalent" class="defaultFontSize">
									<b><s:text name="label.request.usdBondAmount"/> : </b>
									<span style="padding-left: 10px">
									<s:property	value="requestDetails.bondInfo.USEquivalentBondAmt" /></span>
								<img alt="Loading..." id="bidUSDProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display: none; height: 20px; width: 20px;">
								</p>
								<s:hidden id="bondUsdEquivalentAmount"
									name="requestDetails.bondInfo.USEquivalentBondAmt"
									value="%{requestDetails.bondInfo.USEquivalentBondAmt}"></s:hidden>
							</div>
						</div>
						<span style="color: red"><s:fielderror fieldName="requestDetails.bondInfo.USEquivalentBondAmt"/></span>
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
						<div class="form-row">
						 	<s:textfield key="label.request.warrantyTermMonths" name="requestDetails.bondInfo.warrantyTerm"
						 		 theme="aloc" cssClass="span1 mandatory bigInt" maxlength="38"/>
						</div>
					</div>
				</div>
					<div class="row">
                    	<div class="span12">
							<div class="form-row">
								<s:textfield key="label.request.needByDate" name="requestDetails.bondInfo.needByDt" 
									id="needByDt" cssClass="span2 date mandatory" theme="aloc" 
									tooltip="%{getText('label.request.tooltip.needByDate')}"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<label class="optional"><s:text name="label.request.otherInformationOpt" /></label>
							<div class="txtCnt3"></div>
							<s:textarea name="requestDetails.bondInfo.otherInfo"  cols="50" rows="1" cssClass="xlarge autosize3 messageinput" onkeypress="return imposeMaxLength(this, 299);" id="otherInfo"/>
							<div class="clear"></div>
                     		<div class="counter">300</div> 
                     		<div class="counterTxt"><p class="guidance"><s:text name="label.request.charactersLimit" /></p></div>
							</div>
						</div>
					</div>
					<div class="row">
					 <div class="span12">
						<div class="form-row">
							<label class="optional"><s:text name="label.request.typeOfBondFormOpt"/>
							<span class="ttip info" data-original-title="This is an tooltip with more information"></span></label>
							<s:select headerKey="" list="#{'Default':'Default',' Custom Oblige Format':' Custom Oblige Format'}" headerValue="Select..."
								key="" id="selectBondId" name="requestDetails.bondInfo.bondFormType" />
						</div>
						</div>
					</div>
			</div><!-- end of required count block -->
			<script type="text/javascript">
				refreshSectionCount("bondInformationPanel");
			</script>
		</s:if>
		<s:elseif test="%{#isEditMode==false}">
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.CountryOfIssuance"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.issuanceCountryName}"/></p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
								<label><s:text name="label.request.ProjectDescription"/>:</label>
								</div>
							</div>
							<div class="span7 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.exactProjDesc}"/></p>
								</div>
							</div>
							<!-- end of block -->
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.projectInvitationOrBidNo"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.invitationOrBidNo}"/></p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.cityofObligation"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.obligationCity}"/></p>
								</div>
							</div>
							<!-- end of block -->
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.stateOfObligation"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.obligationCountryOrState}"/></p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.Biddate"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><s:property value="requestDetails.bondInfo.bidDt"/></p>
								</div>
							</div>
							<!-- end of block -->
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.estimatedStartDate"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><s:property value="requestDetails.bondInfo.estStartDt"/></p>
								</div>
							</div>
						</div>
						<div class="row ">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.estimatedCompletionDate"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><s:property value="requestDetails.bondInfo.estCompletionDt"/></p>
								</div>
							</div>
							<!-- end of block -->
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.expirationDate"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><s:property value="requestDetails.bondInfo.expirationDt"/></p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.estimatedCurrencyCode"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><s:property value="requestDetails.bondInfo.bidBondCurrencyName"/></p>
								</div>
							</div>
						</div>
						<div class="row ">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.estimatedBidAmount"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><s:property value="requestDetails.bondInfo.estBidAmount"/></p>
								</div>
							</div>
						</div>
						<div class="row ">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.usdEstimatedBidAmount"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><s:property value="requestDetails.bondInfo.USDEstimatedBondAmt"/></p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.currencyCode"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.currencyName}"/></p>
								</div>
							</div>
						</div>
				
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.bidBondAmount"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><s:property value="requestDetails.bondInfo.bondAmount"/></p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.usdBondAmount"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><s:property value="requestDetails.bondInfo.USEquivalentBondAmt"/></p>
									<s:hidden id="bondUsdEquivalentAmount" name="requestDetails.bondInfo.USEquivalentBondAmt"></s:hidden>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.warrantyTermMonths"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.warrantyTerm}"/></p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.needByDate"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><s:property value="requestDetails.bondInfo.needByDt"/></p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.otherInformation" />:</label>
								</div>
							</div>
							<div class="span7 left">
								<div class="form-row">
									<p class="padding40">
										<c:out value="${requestDetails.bondInfo.otherInfo}" />
									</p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.typeOfBondForm"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.bondFormType}"/></p>
								</div>
							</div>
						</div>
</s:elseif>