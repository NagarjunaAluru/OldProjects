<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:if test="hasActionMessages()">
	<div class="row">
		<div class="span12">
			<div class="errorbox">
				<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
				<div class="errorContent"><p><s:actionmessage/></p></div>
			</div>
		</div>
	</div>
</s:if>
		<s:else>
			<s:if test="%{comBidReplies.currentWinningBank.winningBankName!=null && comBidReplies.currentWinningBank.winningBankName!=''}">
				<h3><s:text name="label.request.winner" /> - <s:property value="comBidReplies.currentWinningBank.winningBankName" /></h3>
			
			         <div class="row smallrow">
                        <div class="span2">
                            <div class="form-row">
                                <label><s:text name="label.request.issuingBankBranch" />:</label>
                            </div>
                        </div><!-- end of block -->
                        <div class="span10 left">
                            <div class="form-row">
                               <s:if test="%{comBidReplies.currentWinningBank.issuingBankBranch != '' && comBidReplies.currentWinningBank.issuingBankBranch != null}">
							 	<p><s:property value="comBidReplies.currentWinningBank.issuingBankBranch" /><br />
                                <s:iterator value="comBidReplies.currentWinningBank.addressDtls.address">
                                	<s:property /><br />
                                </s:iterator>
                                <s:property value="comBidReplies.currentWinningBank.addressDtls.city"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="comBidReplies.currentWinningBank.addressDtls.stateProvince"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <s:property value="comBidReplies.currentWinningBank.addressDtls.ZIPPostalCode"/><br />
                                <s:property value="comBidReplies.currentWinningBank.addressDtls.country"/></p>
							 </s:if>
							 <s:else>
								 <s:text name="label.request.hypen"/>
							 </s:else>
                            </div>
                        </div>
                    </div>
                    
				<div class="row">
                        <div class="span2">
                            <div class="form-row">
                                <label><s:text name="label.amendment.bankRefNo" /></label>
                            </div>
                        </div><!-- end of block -->
                        <div class="span10 left">
                            <div class="form-row">
                               <s:if test="%{comBidReplies.currentWinningBank.bankReferenceNumber != '' && comBidReplies.currentWinningBank.bankReferenceNumber != null}">
							 	<s:property value="comBidReplies.currentWinningBank.bankReferenceNumber" />
							 </s:if>
							 <s:else>
								 <s:text name="label.request.hypen"/>
							 </s:else>
                            </div>
                        </div>
                    </div>     
				<div class="span5 left">
                        <div class="row smallrow">
                            <h4><s:text name="label.request.allInCommissions" /></h4>
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.allInRatePerAnnumArrears" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.currentWinningBank.allinComissions.allinCommissionId == 1 }">
								 		<s:property value="comBidReplies.currentWinningBank.allinComissions.allinCommissionValueString" />
									 </s:if>
									 <s:else>
									 	<s:text name="label.request.hypen"/>
								 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.allInRatePerAnnumInAdvance" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.currentWinningBank.allinComissions.allinCommissionId ==2}">
							 		 	<s:property value="comBidReplies.currentWinningBank.allinComissions.allinCommissionValueString" />
									 </s:if>
									 <s:else>
								 		 <s:text name="label.request.hypen"/>
							 		 </s:else>
                                    </div>
                                </div>
                            </div>                             
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.flatFeePerAnnumInAdvance" />:</label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.currentWinningBank.allinComissions.allinCommissionId ==3}">
							 		 	<s:property value="comBidReplies.currentWinningBank.allinComissions.allinCommissionValueString" />
							 		 	</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.flatFeeLifeInAdvance" />:</label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.currentWinningBank.allinComissions.allinCommissionId ==4}">
							 		 	<s:property value="comBidReplies.currentWinningBank.allinComissions.allinCommissionValueString" />
							 		 	</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.amendmentTransactionFee" /><br>
                                        <s:text name="label.request.feesForAmendment" />:</label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.currentWinningBank.allinComissions.amendmentTransactionFee != '' && comBidReplies.currentWinningBank.allinComissions.amendmentTransactionFee != null}">
							 		 		<s:property value="comBidReplies.currentWinningBank.allinComissions.amendmentTransactionFee" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>                                                                              
                        </div>
                    </div>
                    <div class="span5 right">
                        <div class="row smallrow">
                            <h4><s:text name="label.request.localCommissions" /></h4>
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.allInRatePerAnnumArrears" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.currentWinningBank.localComissions.localCommissionId ==1}">
								 		<s:property value="comBidReplies.currentWinningBank.localComissions.localCommissionValueString" />
									 </s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.allInRatePerAnnumInAdvance" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                       <s:if test="%{comBidReplies.currentWinningBank.localComissions.localCommissionId ==2}">
								 		<s:property value="comBidReplies.currentWinningBank.localComissions.localCommissionValueString" />
									 </s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>                             
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.flatFeePerAnnumInAdvance" />:</label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.currentWinningBank.localComissions.localCommissionId ==3}">
								 		<s:property value="comBidReplies.currentWinningBank.localComissions.localCommissionValueString" />
									 </s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.flatFeeLifeInAdvance" />:</label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.currentWinningBank.localComissions.localCommissionId ==4}">
								 		<s:property value="comBidReplies.currentWinningBank.localComissions.localCommissionValueString" />
									 </s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.amendmentTransactionFee" /> <br>
                                        <s:text name="label.request.feesForAmendment" />:</label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.currentWinningBank.localComissions.localAmendmentTransactionFee != '' && comBidReplies.currentWinningBank.localComissions.localAmendmentTransactionFee != null}">
							 		 		<s:property value="comBidReplies.currentWinningBank.localComissions.localAmendmentTransactionFee" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>                            
                        </div>
                    </div>
                    <div class="row">
                    	<div class="span12">
                    <div class="span5 left">
                        <div class="row smallrow">
                            <h4><s:text name="label.request.oneTimeFees" /></h4>
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.vatTaxes" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                       <s:if test="%{comBidReplies.currentWinningBank.onetimeFees.vatTaxes != '' && comBidReplies.currentWinningBank.onetimeFees.vatTaxes != null}">
							 		 		<s:property value="comBidReplies.currentWinningBank.onetimeFees.vatTaxesString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.stampTaxes" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.currentWinningBank.onetimeFees.stampTaxes != '' && comBidReplies.currentWinningBank.onetimeFees.stampTaxes != null}">
							 		 		<s:property value="comBidReplies.currentWinningBank.onetimeFees.stampTaxesString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>                             
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.incidentAdminFee" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.currentWinningBank.onetimeFees.incidentalAdminFee != '' && comBidReplies.currentWinningBank.onetimeFees.incidentalAdminFee != null}">
							 		 		<s:property value="comBidReplies.currentWinningBank.onetimeFees.incidentalAdminFeeString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.otherC" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                       <s:if test="%{comBidReplies.currentWinningBank.onetimeFees.other != '' && comBidReplies.currentWinningBank.onetimeFees.other != null}">
							 		 		<s:property value="comBidReplies.currentWinningBank.onetimeFees.otherString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div> 
                        </div>
                    </div>
                    </div>
                    </div>
                    </s:if>
                    
            <div class="clear"></div>
                    
			<s:if test="%{comBidReplies.participantBanks.size > 0}">
				<s:iterator value="comBidReplies.participantBanks" var="winningBank" status="winningBankStat">
				<s:set var="winBankIndex" value="%{#winningBankStat.index}" />
				<h3><s:text name="label.request.participant" /> <s:property value="comBidReplies.participantBanks[#winningBankStat.index].participantBankName" /></h3>
                    <div class="row smallrow">
                        <div class="span2">
                            <div class="form-row">
                                <label><s:text name="label.request.issuingBankBranch" />:</label>
                            </div>
                        </div><!-- end of block -->
                        <div class="span10 left">
                            <div class="form-row">
                                <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].issuingBankBranch != '' && comBidReplies.participantBanks[#winningBankStat.index].issuingBankBranch != null}">
							 		<p><s:property value="comBidReplies.participantBanks[#winningBankStat.index].issuingBankBranch" /><br />
                                <s:iterator var="addressDtlsItr" value="comBidReplies.participantBanks[#winningBankStat.index].addressDtls.address">
                                	<c:if test="${addressDtlsItr != null && addressDtlsItr != ''}">
                                	<s:property value="addressDtlsItr" /><br />
                                	</c:if>
                                </s:iterator>
                                <s:property value="comBidReplies.participantBanks[#winningBankStat.index].addressDtls.city"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="comBidReplies.participantBanks[#winningBankStat.index].addressDtls.stateProvince"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <s:property value="comBidReplies.participantBanks[#winningBankStat.index].addressDtls.ZIPPostalCode"/><br />
                                <s:property value="comBidReplies.participantBanks[#winningBankStat.index].addressDtls.country"/></p>
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span2">
                            <div class="form-row">
                                <label><s:text name="label.amendment.bankRefNo" /></label>
                            </div>
                        </div><!-- end of block -->
                        <div class="span10 left">
                            <div class="form-row">
                               <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].bankReferenceNumber != '' && comBidReplies.participantBanks[#winningBankStat.index].bankReferenceNumber != null}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].bankReferenceNumber" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                            </div>
                        </div>
                    </div>
                    <div class="span5 left">
                        <div class="row smallrow">
                            <h4><s:text name="label.request.allInCommissions" /></h4>
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.allInRatePerAnnumArrears" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].allinComissions.allinCommissionId ==1}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].allinComissions.allinCommissionValueString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.allInRatePerAnnumInAdvance" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].allinComissions.allinCommissionId ==2}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].allinComissions.allinCommissionValueString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>                             
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.flatFeePerAnnumInAdvance" />:</label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].allinComissions.allinCommissionId ==3}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].allinComissions.allinCommissionValueString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.flatFeeLifeInAdvance" />:</label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].allinComissions.allinCommissionId ==4}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].allinComissions.allinCommissionValueString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.amendmentTransactionFee" /><br>
                                        <s:text name="label.request.feesForAmendment" />:</label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].allinComissions.amendmentTransactionFee != '' && comBidReplies.participantBanks[#winningBankStat.index].allinComissions.amendmentTransactionFee != null}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].allinComissions.amendmentTransactionFee" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>                                                                              
                                                
                        </div>
                    </div>
                    <div class="span5 right">
                        <div class="row smallrow">
                            <h4><s:text name="label.request.localCommissions" /></h4>

                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                       <label><s:text name="label.request.allInRatePerAnnumArrears" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].localComissions.localCommissionId==1}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].localComissions.localCommissionValueString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.allInRatePerAnnumInAdvance" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].localComissions.localCommissionId==2}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].localComissions.localCommissionValueString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>                             
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.flatFeePerAnnumInAdvance" />:</label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].localComissions.localCommissionId==3}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].localComissions.localCommissionValueString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.flatFeeLifeInAdvance" />:</label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].localComissions.localCommissionId==4}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].localComissions.localCommissionValueString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.amendmentTransactionFee" /> <br>
                                        <s:text name="label.request.feesForAmendment" />:</label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].localComissions.localAmendmentTransactionFee != '' && comBidReplies.participantBanks[#winningBankStat.index].localComissions.localAmendmentTransactionFee != null}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].localComissions.localAmendmentTransactionFee" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>                            
                            
                        </div>
                    </div>
                    <div class="span5 left">
                        <div class="row smallrow">
                            <h4><s:text name="label.request.oneTimeFees" /></h4>

                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.vatTaxes" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].onetimeFees.vatTaxes != '' && comBidReplies.participantBanks[#winningBankStat.index].onetimeFees.vatTaxes != null}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].onetimeFees.vatTaxesString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                            
                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.stampTaxes" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                       <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].onetimeFees.stampTaxes != '' && comBidReplies.participantBanks[#winningBankStat.index].onetimeFees.stampTaxes != null}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].onetimeFees.stampTaxesString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>                             

                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.incidentAdminFee" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].onetimeFees.incidentalAdminFee != '' && comBidReplies.participantBanks[#winningBankStat.index].onetimeFees.incidentalAdminFee != null}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].onetimeFees.incidentalAdminFeeString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  

                            <div class="row smallrow">
                                <div class="span3">
                                    <div class="form-row">
                                        <label><s:text name="label.request.otherC" /></label>
                                    </div>
                                </div><!-- end of block -->
                                <div class="span2 left">
                                    <div class="form-row">
                                        <s:if test="%{comBidReplies.participantBanks[#winningBankStat.index].onetimeFees.other != '' && comBidReplies.participantBanks[#winningBankStat.index].onetimeFees.other != null}">
							 		 		<s:property value="comBidReplies.participantBanks[#winningBankStat.index].onetimeFees.otherString" />
										</s:if>
										<s:else>
								 			<s:text name="label.request.hypen"/>
							 		 	</s:else>
                                    </div>
                                </div>
                            </div>  
                        </div>
                    </div>
			<div class="clear"></div>
			</s:iterator>
		</s:if>
		
		<s:if test="%{(comBidReplies.currentWinningBank.winningBankName==null || comBidReplies.currentWinningBank.winningBankName=='') && comBidReplies.participantBanks.size == 0}">
			<div class="row highlighted">
				<div class="span12">
				    <p><s:text name="label.request.comBidRepliesDesc"/> <s:property value="requestDetails.alocRecordId"/></p>
				</div>
			</div>
		</s:if>
		
	</s:else>
		
		