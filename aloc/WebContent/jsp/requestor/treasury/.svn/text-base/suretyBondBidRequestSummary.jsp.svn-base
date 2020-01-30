<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="requestSummary">
    	<div class="leftColRS">
        	<p><strong><s:text name="label.request.requestSummary"/></strong> - <s:text name="label.request.alocRecNo"/>&nbsp;&nbsp;<strong><s:property value="requestDetails.alocRecordId"/></strong></p>
        </div>
		<div class="clear"></div>
        
        <div class="singleBoxRS">
            <div class="row smallrow">
                <div class="span2">
                    <s:iterator value="%{#attr['com.ge.aloc.StaticDataFactory'].addressDetails}">
								<b><s:property value="name"/></b><br/>
								<s:iterator value="address">
									<s:property/>
								</s:iterator><br/>
								<s:property value="city"/>, 
								<s:property value="stateProvinceCd"/>&nbsp;&nbsp;
								<s:property value="ZIPPostalCode"/><br/>			
					</s:iterator>
                </div>         
            </div>
                        
		</div><!-- leftBox ends here -->
        
        <div class="singleBoxRS">
 
            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.alocReferenceNumber"/></label>
                    <p><s:property value="requestDetails.alocRecordId" /></p>
                </div>          
            </div>
 
        </div><!-- midBox ends here -->
                
        <div class="singleBidBoxRS">
            <div class="row smallrow">
                <div class="span3">
                    <label><s:text name="label.request.bondTypeSubType"/></label>
                    <p><s:property value="requestDetails.bondDetails.bondType" /></p>
					<p><s:property value="requestDetails.bondDetails.bondSubType" /></p>
                </div>           
            </div>         
        </div><!-- rightBox ends here -->
 
         <div class="singleBoxRS">
            <div class="row smallrow">
                <div class="span3">
                    <label><s:text name="label.request.bondCurrencyAndAmount"/></label>
                    <p> <c:if test="${requestDetails.bondDetails.bondTypeId eq '1' || requestDetails.bondDetails.bondTypeId eq '3' || requestDetails.bondDetails.bondTypeId eq '5'}">
                         <s:property value="requestDetails.bondInfo.currencyCd" /></c:if>
                         <c:if test="${requestDetails.bondDetails.bondTypeId eq '2'}">
                          <s:property value="requestDetails.bondInfo.performanceBondCurrencyCd" />
                         </c:if>
                         <c:if test="${requestDetails.bondDetails.bondTypeId eq '4'}">
                                <s:property value="requestDetails.bondInfo.bondCurrencyCd" />
                         </c:if>
                        &nbsp;-&nbsp;
						<c:if test="${requestDetails.bondDetails.bondTypeId eq '1'}"><s:property value="requestDetails.bondInfo.bondAmount"/></c:if>
						<c:if test="${requestDetails.bondDetails.bondTypeId eq '2'}"><s:property value="requestDetails.bondInfo.performanceBondAmt"/></c:if>
						<c:if test="${requestDetails.bondDetails.bondTypeId eq '3'}"><s:property value="requestDetails.bondInfo.bondAmount"/></c:if>
						<c:if test="${requestDetails.bondDetails.bondTypeId eq '4'}"><s:property value="requestDetails.bondInfo.courtBondAmt"/></c:if>
						<c:if test="${requestDetails.bondDetails.bondTypeId eq '5'}"><s:property value="requestDetails.bondInfo.bondAmount"/></c:if>
					</p>
                </div>           
            </div>         
            
        </div><!-- rightBox ends here -->
        <div class="clear"></div>
 
         <div class="singleBoxRS">
            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.approximateUSDequivalent"/></label>
                    <p><c:if test="${requestDetails.bondDetails.bondTypeId eq '1'}"><s:property value="requestDetails.bondInfo.USEquivalentBondAmt"/></c:if>
					   <c:if test="${requestDetails.bondDetails.bondTypeId eq '2'}"><s:property value="requestDetails.bondInfo.USDPerformanceBondAmt"/></c:if>
					   <c:if test="${requestDetails.bondDetails.bondTypeId eq '3'}"><s:property value="requestDetails.bondInfo.USEquivalentBondAmt"/></c:if>
					   <c:if test="${requestDetails.bondDetails.bondTypeId eq '4'}"><s:property value="requestDetails.bondInfo.USDCourtBondAmt"/></c:if>
					   <c:if test="${requestDetails.bondDetails.bondTypeId eq '5'}"><s:property value="requestDetails.bondInfo.USEquivalentBondAmt"/></c:if>
					</p>
                </div>           
            </div>         
            
        </div><!-- rightBox ends here -->
                
         <div class="singleBoxRS">
            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.ProjectDescription"/></label>
                    <p  style="word-wrap:break-word;"><s:property value="requestDetails.bondInfo.exactProjDesc"/></p>
                </div>           
            </div>         
            
        </div><!-- rightBox ends here -->
 
         <div class="singleBoxRS">
            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.expirationDateofBond"/></label>
                    <p><s:property value="requestDetails.bondInfo.expirationDt" /></p>
                </div>           
            </div>         
            
        </div><!-- rightBox ends here -->              
               
        <div class="clear"></div>
    </div><!-- requestSummary ends here -->
