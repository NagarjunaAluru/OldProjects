<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:set name="isEditMode" value="editMode"/>
	  <s:if test="%{#isEditMode==true}">
	  <script type="text/javascript">
				$(document).ready(function() {
					showSubBondOnload();
				});
			</script>
	  	<div id="suretyBondDetailsForm">
				<c:if test="${empty requestDetails.siteName}">
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<c:if test="${empty requestDetails.siteSelection.selectedSites}">
							<s:select headerKey="" key="label.request.site"  headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].userSpecificSitesList}"
								listKey="ID" listValue="name" name="siteId" id="selectedSiteId" theme="aloc"
								cssClass="mandatory"/>
							</c:if>
							<c:if test="${not empty requestDetails.siteSelection.selectedSites}">
							<s:select headerKey="" key="label.request.site"  headerValue="Select..." list="requestDetails.siteSelection.selectedSites"
								listKey="siteId" listValue="siteName" name="siteId" id="selectedSiteId" theme="aloc"
								cssClass="mandatory"/>
							</c:if>
							
								<s:hidden name="requestDetails.siteId" value="%{requestDetails.siteId}" id="reqsiteID"></s:hidden>
								<s:hidden name="selectedSite" value="%{siteId}" id="selectedSite"></s:hidden>
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${requestDetails.WFDetails.WFStage ne 'REQEST'}">
				<c:if test="${not empty requestDetails.siteName}">
	     		<div class="row">
					<div class="span12">
						<div class="form-row">
							<p style="padding: 2px 0;" class="defaultFontSize">
								<b><s:text name="label.request.selectedSite"/></b> 
							<span style="padding-left: 40px;"><s:property value="requestDetails.siteName"/></span>
							</p>
							<s:hidden name="siteId" value="%{requestDetails.siteId}"></s:hidden>
						</div>
					</div>
				</div>
			</c:if>
			</c:if>
				<a name="first"></a>
                <s:hidden name="abc" value="%{requestDetails.bondDetails.subBondTypeId}" id="selectSubBondIdDet" />
				<div class="row">
					<div class="span12">
						<div class="form-row">
								<s:select headerKey="" key="label.request.bondType" list="%{#attr['com.ge.aloc.StaticDataFactory'].bondTypes}" headerValue="Select..."
									listKey="ID" listValue="name" id="selectBond" name="requestDetails.bondDetails.bondTypeId" theme="aloc" 
									cssClass="mandatory"/>
								<img alt="Loading..." id="bondprocess" src="${pageContext.request.contextPath}/img/loading.gif" class="indicator">
						</div>
						<s:hidden name="requestDetails.bondDetails.bondType" id="bondType" value="%{requestDetails.bondDetails.bondType}"/>
						<a href="#" id="bondClick"></a>
					</div>
				</div>
				<div class="row bondTypeErrorShow" style="display: none;">
            		<div class="span12">
                		<div class="errorbox">
                			<div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
								<div class="errorContent">
	                				<p id="bondTypeError"></p>
               					 </div>
               				 </div>
           			 </div>
       			 </div>
				<div class="row hide" id="bondSubtype">
					<div class="span12">
						<div class="form-row">
							<s:select  list="#{}" key="label.request.bondSubtype"
								listKey="ID" listValue="name" id="selectSubBond" name="requestDetails.bondDetails.subBondTypeId"
								 theme="aloc">
					 		</s:select>
						</div>
							<s:hidden name="requestDetails.bondDetails.bondSubType" id="bondSubType" value="%{requestDetails.bondDetails.bondSubType}"/>
					</div><!-- end of block -->
				</div>
		</div>
		<h3 id="principalHeader">
			<s:text name="label.request.sbSectionPrincipal"/>
		</h3><hr class="hr3">
		<jsp:include page="../../common/request/principalDetails.jsp" >
			<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
		</jsp:include>
		<h3 id="obligeeHeader">
			<s:text name="label.request.sbSectionObligee"/> 
		</h3><hr class="hr3">
		<jsp:include page="../../common/request/obligeeDetails.jsp" >
			<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
		</jsp:include>
		
		<!-- end of required count block -->
		 <script type="text/javascript">
					refreshSectionCount("bondDetailsPanel");
			</script>
	  </s:if>
	 <s:elseif test="%{#isEditMode==false}">
		 <c:if test="${param.verify ne 'suretybidAward'}">
			<div class="row">
					<div class="span2">
						<div class="form-row">
							<label><s:text name="label.request.bondType"/> :</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.bondDetails.bondType}"/></p>
							<s:hidden name="requestDetails.bondDetails.bondTypeId" id="selectBond" value="%{requestDetails.bondDetails.bondTypeId}"/>
						</div>
					</div>
		  </div>
		 
				<c:if test="${requestDetails.bondDetails.bondTypeId eq '2' || requestDetails.bondDetails.bondTypeId eq '3' || requestDetails.bondDetails.bondTypeId eq '4'}">
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<label><s:text name="label.request.bondSubtype"/> :</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.bondDetails.bondSubType}"/></p>
						</div>
					</div><!-- end of block -->
				</div>
				</c:if>
			<h3 id="principalHeader">
			<s:text name="label.request.sbSectionPrincipal"/>
		</h3><hr class="hr3">
		<jsp:include page="../../common/request/principalDetails.jsp" >
			<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
		</jsp:include>
		<h3 id="obligeeHeader">
			<s:text name="label.request.sbSectionObligee"/> 
		</h3><hr class="hr3">
		<jsp:include page="../../common/request/obligeeDetails.jsp" >
			<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
		</jsp:include>
		</c:if>		
		 <c:if test="${param.verify eq 'suretybidAward'}">
		       <div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.bondCurrency"/> :</label>
						</div>
					</div>
					<div class="span5 left subdiv">
						<div class="form-row suretybondCurrency">
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '1'}"><p class="padding40 bondCurrency"><c:out value="${requestDetails.bondInfo.currencyName}"/></p></c:if>
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '2'}"><p class="padding40 bondCurrency"><c:out value="${requestDetails.bondInfo.performanceBondCurrencyName}"/></p></c:if>
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '3'}"><p class="padding40 bondCurrency"><c:out value="${requestDetails.bondInfo.currencyName}"/></p></c:if>
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '4'}"><p class="padding40 bondCurrency"><c:out value="${requestDetails.bondInfo.bondCurrency}"/></p></c:if>
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '5'}"><p class="padding40 bondCurrency"><c:out value="${requestDetails.bondInfo.currencyName}"/></p></c:if>
						  
						</div>
					</div>
		     </div>
		     <div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.bondAmount"/> :</label>
						</div>
					</div>
					<div class="span5 left suretyAmountDiv">
						<div class="form-row bondamountDiv">
							 <c:if test="${requestDetails.bondDetails.bondTypeId eq '1'}"><p class="padding40 bondAmount"><s:property value="requestDetails.bondInfo.bondAmount"/></p></c:if>
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '2'}"><p class="padding40 bondAmount"><s:property value="requestDetails.bondInfo.performanceBondAmt"/></p></c:if>
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '3'}"><p class="padding40 bondAmount"><s:property value="requestDetails.bondInfo.bondAmount"/></p></c:if>
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '4'}"><p class="padding40 bondAmount"><s:property value="requestDetails.bondInfo.courtBondAmt"/></p></c:if>
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '5'}"><p class="padding40 bondAmount"><s:property value="requestDetails.bondInfo.bondAmount"/></p></c:if>
						 
						</div>
					</div>
		     </div>
		      <div class="row">
				<div class="span4">
					<div class="form-row">
						<p id="amountinWords"></p>
					</div>
				</div>
			</div>
		     <div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.approxuSDAmount"/></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '1'}"><p class="padding40"><s:property value="requestDetails.bondInfo.USEquivalentBondAmt"/></p></c:if>
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '2'}"><p class="padding40"><s:property value="requestDetails.bondInfo.USDPerformanceBondAmt"/></p></c:if>
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '3'}"><p class="padding40"><s:property value="requestDetails.bondInfo.USEquivalentBondAmt"/></p></c:if>
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '4'}"><p class="padding40"><s:property value="requestDetails.bondInfo.USDCourtBondAmt"/></p></c:if>
						   <c:if test="${requestDetails.bondDetails.bondTypeId eq '5'}"><p class="padding40"><s:property value="requestDetails.bondInfo.USEquivalentBondAmt"/></p></c:if>
						 
						</div>
					</div>
		     </div>
		     <div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.amendment.currExpDate"/></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
						   <p class="padding40"><s:property value="requestDetails.bondInfo.expirationDt"/></p>
						 
						</div>
					</div>
		     </div>
		 
		 </c:if>
</s:elseif>