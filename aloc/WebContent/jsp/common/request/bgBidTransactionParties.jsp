<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
                        
            <div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.Instrumentpurpose"/>:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><s:property value="requestDetails.transactionParties.instrumentPurpose"/></p>
					</div>
				</div>
			</div>
            
            <c:if test="${requestDetails.transactionParties.instrumentPurposeId eq 16}">
	            <div class="row">
	                <div class="span44">
	                    <div class="form-row">
	                        <label><s:text name="label.request.other"/>:</label>
	                    </div>
	                </div>
	                <div class="span5 left">
	                    <div class="form-row">
	                        <p class="padding40"><s:property value="requestDetails.transactionParties.instrumentPurposeOther" /></p>
	                    </div>
	                </div><!-- end of block -->
	            </div> 
            </c:if>
            <c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
            <div class="row">
                <div class="span44">
                    <div class="form-row">
                        <label><s:text name="label.request.isTriPartyRequest" /> :</label>
                    </div>
                </div>
                <div class="span5 left">
                    <div class="form-row">
                        <p>
								<s:if test="requestDetails.transactionParties.triPartyRequestFlag == true">
                                	<p class="padding40"><s:text  name="label.request.common.yes"/></p>
                                </s:if>
                                <s:elseif test="requestDetails.transactionParties.triPartyRequestFlag == false">
                                	<p class="padding40"><s:text  name="label.request.common.no"/></p>
                                </s:elseif></p>
                    </div>
                </div><!-- end of block -->
            </div> 
           
            <div class="row">
                <div class="span44">
                    <div class="form-row">
                        <label><s:text name="label.request.triPartyPrivateLabel" /> :</label>
                    </div>
                </div>
                <div class="span5 left">
                    <div class="form-row">
                        <p>
								<s:if test="requestDetails.transactionParties.privateLabelFlag == true">
                                	<p class="padding40"><s:text  name="label.request.common.yes"/></p>
                                </s:if>
                                <s:elseif test="requestDetails.transactionParties.privateLabelFlag == false">
                                	<p class="padding40"><s:text  name="label.request.common.no"/></p>
                                </s:elseif></p>
                    </div>
                </div><!-- end of block -->
            </div>  
             </c:if>                                   
            <div class="clear"></div>

            <div class="row">
                <div class="span44">
                    <div class="form-row">
                        <label><s:text name="label.request.ProjectDescription" />:</label>
                    </div>
                </div>
                <div class="span5 left">
                    <div class="form-row">
                        <p class="padding40" style="word-wrap:break-word;"><s:property	value="requestDetails.projDescription.projDesc"/></p>
                    </div>
                </div><!-- end of block -->
            </div> 
            
                        
            <!-- SECOND SECTION STARTS HERE -->
            <h3><s:text name="label.request.additianalInfo" />:</h3>

            <jsp:include page="/jsp/common/request/projectDescription.jsp" >
           		 <jsp:param name="page" value="BGBidReply" />
			</jsp:include>
            
            <div class="row">
                <div class="span44">
                    <div class="form-row">
                        <label><s:text name="label.request.PercentageofvalueBid"/>:</label>
                    </div>
                </div><!-- end of block -->
                <div class="span5 left">
                    <div class="form-row">
                        <p class="padding40"><s:property value="requestDetails.instrumentDetails.percentValueOfBid" /></p>
                    </div>
                </div>
            </div>   
            <c:if test="${requestDetails.transactionParties.instrumentPurposeId eq '12' || requestDetails.transactionParties.instrumentPurposeId eq '14'}">
            <div class="row">
                <div class="span44">
                    <div class="form-row">
                        <label><s:text name="label.request.maxiPossibleExp"/>:</label>
                    </div>
                </div><!-- end of block -->
                <div class="span5 left">
                    <div class="form-row">
                        <p class="padding40"><s:property value="requestDetails.instrumentDetails.maxPossibleExpo" /></p>
                    </div>
                </div>
            </div>
            </c:if>
                            
	<div class="clear"></div>
