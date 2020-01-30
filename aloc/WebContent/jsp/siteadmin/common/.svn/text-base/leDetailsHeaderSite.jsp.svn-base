<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

	<div class="hide" id="LegalGoldCreate">
		<c:if test="${empty siteAdmin.leGoldId}">
			<c:set var="goldidClass" value="display: none;"/>
			<c:set var="goldidClearStyle" value="display: none;"/>
		</c:if>
		<c:if test="${not empty siteAdmin.leGoldId}">
			<c:set var="goldidClass" value="display: block;"/>
			<c:set var="goldidClearStyle" value="display: inline;"/>
		</c:if>
	             	
		<div class="row">
			<div class="form-row">
		    	<div class="span3">
		    	<s:label key="label.common.siteAdmin.legalEntityGOLDID" id="LEMandatoryId" />
		    	<s:label key="label.common.siteAdmin.optionalLEGOLDID" cssStyle="font-style:normal; font-weight:normal !important" id="LEOpionalId" />
	            	<s:textfield name="goldId" 
						id="leGoldId" theme="aloc"
						cssClass="span3 lookup-filterValue"
					/>
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>	
				</div>
				<div class="span1">
					<label>&nbsp;</label>
					<s:url action="LegalEntityLookup" namespace="/int" var="getLegalEntityURL" escapeAmp="false"></s:url>
					<a class="btn-secondary lookup" href="<s:property value="#getLegalEntityURL"/>" ><s:text name="label.common.siteAdmin.lookup"/></a>&nbsp;
				</div>
				<div class="span5">
		        	<label>&nbsp;</label>
		            <img alt="Loading..." id="leIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px">
				</div>
			</div>
		</div>
	                	
		<div class="hide conditional-row" id="goldidShow" style="${goldidClass}">
			<div class="row">
				<div class="span7">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label><s:label key="label.common.siteAdmin.legalEntityNameC" /></label>  
							</div>
						</div>
						<div class="span4 right">
							<div class="form-row">
								<p class="padding40"><s:property value="siteAdmin.leName"/></p>
								<s:hidden name="siteAdmin.leName" id="tpApplicantLEName"></s:hidden>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label><s:label key="label.common.siteAdmin.LEGOLDIDC" /></label>
							</div>
						</div>
						<div class="span4 right">
							<div class="form-row">
								<p class="padding40"><s:property value="siteAdmin.leGoldId"/></p>
		                        <s:hidden name="siteAdmin.leGoldId" id="tpApplicantLEGoldID"></s:hidden>
		                        <s:hidden name="siteAdmin.leMDMId" id="leMDMId"></s:hidden>
		                        <s:hidden name="goldIdSelection" id="goldIdSelectionId"></s:hidden>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div><!-- LegalGold ends here -->
                
	<div class="row hide" id="HeaderCreate">
		<div class="span12">
			<div class="radio-container derivativesConditional">
				<c:choose>
					<c:when test="${not empty modifySite and modifySite eq true}">
						<s:radio theme="aloc" cssClass="radio"
							name="siteAdmin.headerSiteOnly" 
							key="label.common.siteAdmin.headerSiteOnly" 
							tooltip="%{getText('label.siteAdmin.tooltip.headerSite')}" 
							list="#{'true':'Yes','false':'No'}"
							value="%{siteAdmin.headerSiteOnly}"
							id="headerSiteOnly"
							disabled="%{modifySite}" 
						/>
						<c:if test="${modifySite eq true}">
		                	<s:hidden name="siteAdmin.headerSiteOnly" id="headerSiteOnlyId" />
		                </c:if>
					</c:when>
                    <c:otherwise>
						<s:radio theme="aloc" cssClass="radio"
							name="siteAdmin.headerSiteOnly" 
							key="label.common.siteAdmin.headerSiteOnly" 
							tooltip="%{getText('label.siteAdmin.tooltip.headerSite')}" 
							list="#{'true':'Yes','false':'No'}"
							value="%{siteAdmin.headerSiteOnly}"
							id="headerSiteOnly"
							disabled="%{editMode}" 
						/>
						<c:if test="${editMode eq true}">
                			<s:hidden name="siteAdmin.headerSiteOnly" id="headerSiteOnlyId" />
                		</c:if>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
                
	<div class="hide" id="headerSiteCreate">
		<div class="row">
			<div class="span12">
				<s:textfield name="siteAdmin.groupEmailAddress" 
					tooltip="%{getText('label.siteAdmin.tooltip.groupEmailAddress')}"
					id="groupEmailAddress" 
					key="label.common.siteAdmin.groupEmailAddressOpt" 
					theme="aloc"
					required="false"
					maxlength="100"
				/>	
			</div>
		</div>                
	</div><!-- headerSite ends here -->
                
	<div class="row hide" style="margin-bottom:10px!important;" id="triPartyCreate">
		<div class="span5">
			<s:radio theme="aloc" cssClass="radio"
				name="siteAdmin.triPartyEnabled" 
				key="label.common.siteAdmin.isThisAtriPartyRequest" 
				tooltip="%{getText('label.siteAdmin.tooltip.triPartyRequest')}" 
				list="#{'true':'Yes','false':'No'}"
				value="%{siteAdmin.triPartyEnabled}"
				id="triPartyEnabled" 
			/>
		</div>
	</div><!-- is this a tri ends here -->
                    
	<div class="row hide" id="privateCreate">
		<div class="span5">
			<s:radio theme="aloc" cssClass="radio"
				name="siteAdmin.privateLabel" 
				key="label.common.siteAdmin.privateLabel" 
				tooltip="%{getText('label.siteAdmin.tooltip.privateLabel')}" 
				list="#{'true':'Yes','false':'No'}"
				value="%{siteAdmin.privateLabel}"
				id="privateLabel" 
			/>
		</div>
	</div>
	
	<div class="hide" id="buc" >
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="siteAdmin.IBS.BUCCode" theme="aloc" cssClass="span1 mandatory"
						key="label.request.buc" id="bussUnitCodeId" maxlength="6" required="false" />
				</div>
			</div>
			<!-- end of block -->
		</div>
	</div>
	
	<div class="hide" id="adn">
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="siteAdmin.IBS.ADNCode" theme="aloc" cssClass="mandatory"
						key="label.request.adn" maxlength="30" id="accDistNoId" required="false" />
				</div>
			</div>
			<!-- end of block -->
		</div>
	</div>
                    
	<div class="row hide" id="reqChkBox">
		<div class="span12">
			<div class="form-row">
				<s:checkbox name="siteAdmin.requestCheck" theme="aloc-TransactionParties" cssClass="checkbox" id="requestCheck" />
                <s:label key="label.siteAdmin.createReqCheck" cssClass="red"/>
			</div>
		</div>
	</div>