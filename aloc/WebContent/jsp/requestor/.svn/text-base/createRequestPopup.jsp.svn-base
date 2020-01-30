<!---pyt  Create Request Div -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/requestor/createRequestPopup.js">

</script>
<div class="hide" id="request">
	<div class="reqdropdown">
	<s:form name="createRequestForm" action="/int/requestor/createRequest.action" method="post">
		<a href="#" class="btn-tertiary right reqclose">X</a>
		<h3><s:text name="label.createRequest.heading"/></h3>
		<ol>
			<li><s:label key="label.createRequest.headingList.1" cssStyle="font-weight: normal"/></li>
			<li><s:label key="label.createRequest.headingList.2" cssStyle="font-weight: normal"/></li>
			<li><s:label key="label.createRequest.headingList.3" cssStyle="font-weight: normal"/></li>
		</ol>
		<div>
		<p class="siteError hide" style="color: #990000;"><s:text name="label.request.pleaseSelectASite"/></p>
		<s:select headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].userSpecificSitesList}" 
		listKey="ID" listValue="name" name="siteId" id="selectSite"/>
		</div>
		<br/>
		
		<s:hidden name="notSureAboutInstrument" id="notSureAboutInstrumentID" value="false"/>
		<!-- Vertical Tabs -->
		<ul class="nav nav-tabs tabs">
			<li id="navTabLi1" class="active"><a data-toggle="tab" href="#1" id="navTab1"><s:text name="label.createRequest.navigationTab.1"/></a></li>
			<li id="navTabLi2"><a data-toggle="tab" href="#2" id="navTab2"><s:text name="label.createRequest.navigationTab.2"/></a></li>
		</ul>
		<div class="tab-content" id="myTabContent" style="width: 400px;">
			<div id="1" class="tab-pane fade active in">
				<div>
				<p class="instrumentError hide" style="color: #990000;"><s:text name="label.request.pleaseSelectAnInstrument"/></p>
				<s:select headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentTypeList}" 
				listKey="ID" listValue="name" id="selectInstrument" name="selectedInstrumentType"/>
				</div>
				<br/>
				<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest" id=""/>
			</div>

			<div id="2" class="tab-pane fade">
				<p><s:label key="label.createRequest.notSure.paragraph" cssStyle="font-weight: normal"/></p>

				<s:label key="label.createRequest.notSure.label"/>
				<div class="radio-container" id="ins">
					<s:radio theme="aloc" cssClass="radio" id="instrumentIssuedRegion"
					name="instrumentIssuedRegion" 
					list="#{'insideUS':'Inside U.S.','outsideUS':'Outside U.S.'}"  
					value="%{instrumentIssuedRegion}" />
					
				</div>

				<div class="hide" id="inside">
					<p><s:label key="label.createRequest.insideUS" cssStyle="font-weight: normal"/></p>
					<p>
						<br />
					</p>
					<s:label key="label.createRequest.rules"></s:label>
					<div class="radio-container" id="gov">
						<s:radio theme="aloc" cssClass="radio" id="instrumentGoverningRules"
						name="instrumentGoverningRules" 
						list="#{'practice':'Uniform Customs and Practice (UCP) - or - <br /> International Standby Practices (ISP)','guarantee':'Uniform Rules for Demand Guarantees (URDG)'}"  
						value="%{instrumentGoverningRules}" />
						
					</div>
					<div class="hide label-container" id="ucp">
						<p>
							<s:label key="label.createRequest.ucpisp" cssStyle="font-weight: normal"/>
						</p>
						<p>
							<br />
						</p>
						<p>
							<b><s:label key="label.createRequest.selectedRequest.1" /></b>
						</p>
						<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest" />
					</div>
					<div class="hide label-container" id="urdg">
						<p><s:label key="label.createRequest.urdg" cssStyle="font-weight: normal"/></p>
						<p>
							<br />
						</p>
						<p>
							<b><s:label key="label.createRequest.selectedRequest.2"/></b>
						</p>
						<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest" />
					</div>
				</div>
				<div class="hide" id="outside">
					<p><s:label key="label.createRequest.outsideUS" cssStyle="font-weight: normal"/></p>
					<div>
						<s:label key="label.createRequest.rules"></s:label>
						<div class="radio-container" id="govern">
							<s:radio theme="aloc" cssClass="radio" id="instrumentGoverningRules"
							name="instrumentGoverningRules" 
							list="#{'customs':'Uniform Customs and Practice (UCP) - or - <br /> International Standby Practices (ISP)','demand':'Uniform Rules for Demand Guarantees (URDG)','unknown':'Other/Unknown'}"  
							value="%{instrumentGoverningRules}" />
						
						</div>
					</div>
					<div class="hide label-container" id="customUcp">
						<p>
							<s:label key="label.createRequest.ucpisp" cssStyle="font-weight: normal"/>
						</p>

						<s:label key="label.createRequest.customUcp"></s:label>
						<div class="radio-container" id="local">
							<s:radio theme="aloc" cssClass="radio" id="customs_subjectToLocalCountryLaws"
							name="subjectToLocalCountryLaws" 
							list="#{'yes':'Yes','no':'No'}"  
							value="%{subjectToLocalCountryLaws}" />
						
						</div>

						<div class="hide label-container" id="localYes">
							<s:label key="label.common.yes" cssStyle="font-weight: normal" />
							
							<s:label key="label.createRequest.customUcp.localYesNo"></s:label>
							<div class="radio-container" id="refer">
								<s:radio theme="aloc" cssClass="radio" id="customs_yes_textFormatRefer"
								name="textFormatRefer" 
								list="#{'sloc':'Standby Letter of Credit','bg':'Bank Guarantee'}"  
								value="%{textFormatRefer}" />
							
							</div>

							<div class="hide label-container" id="standbyLoc">
								<s:label key="label.createRequest.sloc" cssStyle="font-weight: normal"/>
								<p>
									<br />
								</p>
								<p>
									<b><s:label key="label.createRequest.selectedRequest.1" /></b>
								</p>
								<p>
									<br />
								</p>
								<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest" />
							</div>
							<div class="hide label-container" id="bankg">
								<s:label key="label.createRequest.bg" cssStyle="font-weight: normal"/>
								<p>
									<br />
								</p>
								<p>
									<b><s:label key="label.createRequest.selectedRequest.2" /></b>
								</p>
								<p>
									<br />
								</p>
								<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest" />
							</div>
						</div>
						<div class="hide label-container" id="localNo">
							<s:label key="label.common.no" cssStyle="font-weight: normal"></s:label>

							<s:label key="label.createRequest.customUcp.localYesNo"></s:label>
							<div class="radio-container" id="formatRefer">
								<s:radio theme="aloc" cssClass="radio" id="customs_no_textFormatRefer"
								name="textFormatRefer" 
								list="#{'sloc':'Standby Letter of Credit','bg':'Bank Guarantee'}"  
								value="%{textFormatRefer}" />
								
							</div>

							<div class="hide label-container" id="standby1">
								<s:label key="label.createRequest.sloc" cssStyle="font-weight: normal"/>
								<p>
									<br />
								</p>
								<p>
									<b><s:label key="label.createRequest.selectedRequest.1" /></b>
								</p>
								<p>
									<br />
								</p>
								<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest" />
							</div>
							<div class="hide label-container" id="bank1">
								<s:label key="label.createRequest.bg" cssStyle="font-weight: normal"/>
								<p>
									<br />
								</p>
								<p>
									<b><s:label key="label.createRequest.selectedRequest.2" /></b>
								</p>
								<p>
									<br />
								</p>
								<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest" />
							</div>
						</div>
					</div>
					<div class="hide label-container" id="demandUrdg">
						<s:label key="label.createRequest.urdg" cssStyle="font-weight: normal"/>

						<s:label key="label.createRequest.demandUrdg.localYesNo"/>
						<div class="radio-container" id="localaws">
							<s:radio theme="aloc" cssClass="radio" id="demand_subjectToLocalCountryLaws"
							name="subjectToLocalCountryLaws" 
							list="#{'yes':'Yes','no':'No'}"  
							value="%{subjectToLocalCountryLaws}" />
							
						</div>

						<div class="hide label-container" id="localawsYes">
							<s:label key="label.common.yes" cssStyle="font-weight: normal"></s:label>
							<p>
								<br />
							</p>
							<p>
								<b><s:label key="label.createRequest.selectedRequest.2" /></b>
							</p>
							<p>
								<br />
							</p>
							<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest" />
						</div>
						<div class="hide label-container" id="localawsNo">
							<s:label key="label.common.no" cssStyle="font-weight: normal"></s:label>
							<s:label key="label.createRequest.customUcp.localYesNo"></s:label>
							<div class="radio-container" id="formatRef">
								<s:radio theme="aloc" cssClass="radio" id="demand_no_textFormatRefer"
								name="textFormatRefer" 
								list="#{'sloc':'Standby Letter of Credit','bg':'Bank Guarantee'}"  
								value="%{textFormatRefer}" />
								
							</div>

							<div class="hide label-container" id="standby2">
								<s:label key="label.createRequest.sloc" cssStyle="font-weight: normal"/>
								<p>
									<br />
								</p>
								<p>
									<b><s:label key="label.createRequest.selectedRequest.1" /></b>
								</p>
								<p>
									<br />
								</p>
								<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest" />
							</div>
							<div class="hide label-container" id="bank2">
								<s:label key="label.createRequest.bg" cssStyle="font-weight: normal"/>
								<p>
									<br />
								</p>
								<p>
									<b><s:label key="label.createRequest.selectedRequest.2" /></b>
								</p>
								<p>
									<br />
								</p>
								<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest"/>
							</div>
						</div>
					</div>
					<div class="hide label-container" id="unk">
						<s:label key="label.createRequest.other" cssStyle="font-weight: normal"/>

						<s:label key="label.createRequest.customUcp"></s:label>
						<div class="radio-container" id="lcl">
							<s:radio theme="aloc" cssClass="radio" id="unknown_subjectToLocalCountryLaws"
							name="subjectToLocalCountryLaws" 
							list="#{'yes':'Yes','no':'No'}"  
							value="%{subjectToLocalCountryLaws}" />
							
						</div>

						<div class="hide label-container" id="lclYes">
							<s:label key="label.common.yes" cssStyle="font-weight: normal"></s:label>
							<s:label key="label.createRequest.customUcp.localYesNo"></s:label>
							<div class="radio-container" id="forrefer">
								<s:radio theme="aloc" cssClass="radio" id="unknown_yes_textFormatRefer"
								name="textFormatRefer" 
								list="#{'sloc':'Standby Letter of Credit','bg':'Bank Guarantee'}"  
								value="%{textFormatRefer}" />
							</div>

							<div class="hide label-container" id="standbyLetoc">
								<s:label key="label.createRequest.sloc" cssStyle="font-weight: normal"/>
								<p>
									<br />
								</p>
								<p>
									<b><s:label key="label.createRequest.selectedRequest.1" /></b>
								</p>
								<p>
									<br />
								</p>
								<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest" />
							</div>
							<div class="hide label-container" id="bankguar">
								<s:label key="label.createRequest.bg" cssStyle="font-weight: normal"/>
								<p>
									<br />
								</p>
								<p>
									<b><s:label key="label.createRequest.selectedRequest.2" /></b>
								</p>
								<p>
									<br />
								</p>
								<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest"/>
							</div>
						</div>
						<div class="hide label-container" id="lclNo">
							<s:label key="label.common.no" cssStyle="font-weight: normal"></s:label>

							<s:label key="label.createRequest.customUcp.localYesNo"></s:label>
							<div class="radio-container" id="formRefer">
								<s:radio theme="aloc" cssClass="radio" id="unknown_no_textFormatRefer"
								name="textFormatRefer" 
								list="#{'sloc':'Standby Letter of Credit','bg':'Bank Guarantee'}"  
								value="%{textFormatRefer}" />
								
							</div>

							<div class="hide label-container" id="standby3">
								<s:label key="label.createRequest.sloc" cssStyle="font-weight: normal"/>
								<p>
									<br />
								</p>
								<p>
									<b><s:label key="label.createRequest.selectedRequest.1" /></b>
								</p>
								<p>
									<br />
								</p>
								<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest"/>
							</div>
							<div class="hide label-container" id="bank3">
								<s:label key="label.createRequest.bg" cssStyle="font-weight: normal"/>
								<p>
									<br />
								</p>
								<p>
									<b><s:label key="label.createRequest.selectedRequest.2" /></b>
								</p>
								<p>
									<br />
								</p>
								<s:submit key="label.createRequest.button.create" cssClass="btn-secondary createRequest"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</s:form>
	</div>
</div>