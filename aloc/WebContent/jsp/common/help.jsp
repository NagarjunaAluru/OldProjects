<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.help.pageTitle" /></title>
<%@include file="../common/includeCommonScripts.jsp"%>
<link href="${pageContext.request.contextPath}/css/others/help.css" rel="stylesheet">
</head>
<body>
	<div class="container main">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<h1 class="page-title span12"><s:text name="label.help.pageTitle" /></h1>
		<hr class="page-title-hr">		
  		<s:hidden name="errorShow" id="errorShowId" value="%{errorShow}"/>
		<div class="row hide" id="helpLevelErrorDivId">
			<div class="span12">
				<div class="errorbox">
					<div class="errorHead">
						<p class="erroricon">Error</p>
					</div>
					<div class="errorContent">
						<p>
							<s:fielderror/>
						</p>
						<p>&nbsp;</p>
					</div>
				</div>
			</div>
		</div>		
		<h2> <s:text name="label.help.overview" /> </h2>
		<hr class="h2-hr"/>
		<p style="margin-top: 5px;"> <s:text name="label.help.overview.para1" /> </p>
		<br />
		<p><s:text name="label.help.overview.para2" /></p>
		<br />
		<p><i><s:text name="label.help.overview.para3" /></i></p>			
		<div class="form-mod">
			<h2 id="fees" class="section_flip section_noToggle"><a href="javascript:;"><s:text name="label.help.subHeader.fees" /> </a></h2><hr class="h2-hr">
			<div id="feesPanel" class="section_panel">
		     <s:form id="downloadFeeHelpPDFFormId" action="downloadHelpPDF" namespace="/int">		     
				<div class="highlighted">
					<div class="form-mod smallrow">
						<div class="span5">
							<p><s:text name="label.help.selectToDownload" /></p>
						</div>
					</div>
					<div class="clear"></div>
					<div class="gbg">
						<div class="span2">
							<img src="${pageContext.request.contextPath}/img/pdf1.png" />
							<p>
								<input type="checkbox" name="downloadDocs" id="bankFeePaymentSchedule" value="BANKFEE" > <s:text name="label.help.helpFile.BFPS" />
							</p>
						</div>
						<div class="span2">
							<img src="${pageContext.request.contextPath}/img/pdf1.png" />
							<p>
								<input type="checkbox" name="downloadDocs" id="suretyBondFeePayment" value="SURETYBONDFEE"> <s:text name="label.help.helpFile.SBFP" />
							</p>
						</div>
						<div class="span2">
							<img src="${pageContext.request.contextPath}/img/pdf1.png" />
							<p>
								<input type="checkbox" name="downloadDocs" id="feeCalculationSample" value="FEESAMPLE"> <s:text name="label.help.helpFile.FCS" />
							</p>
						</div>
						<div class="clear"></div>
					</div>
					<div class="form-mod smallrow">
						<div class="span2">
						 	<s:submit key="label.request.Download" cssClass="btn-primary" />
							<!-- <a href="javascript:;" class="btn" >Download</a> -->
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<!-- highlighted ends here -->
				</s:form>
			</div>
		</div>
		<div class="clear"></div>
		<div class="form-mod">
			<h2 id="glossary" class="section_flip section_noToggle"><a href="javascript:;"><s:text name="label.help.subHeader.glossary" /></a></h2>
			<hr class="h2-hr">
			<div id="glossaryPanel" class="section_panel">
				 <s:form id="downloadFeeHelpPDFFormId" action="downloadHelpPDF" namespace="/int">				 
				<div class="highlighted">
					<div class="form-mod smallrow">
						<div class="span5">
							<p><s:text name="label.help.selectToDownload" /></p>
						</div>
					</div>
					<div class="clear"></div>
					<div class="gbg">
						<div class="span2">
							<img src="${pageContext.request.contextPath}/img/pdf1.png" />
							<p>
								<input type="checkbox" name="downloadDocs" id="glossary" value="GLOSSARY"> <s:text name="label.help.helpFile.Glossary" />
							</p>
						</div>
						<div class="span2">
							<img src="${pageContext.request.contextPath}/img/pdf1.png" />
							<p>
								<input type="checkbox" name="downloadDocs" id="policy" value="POLICY"> <s:text name="label.help.helpFile.Policy" />
							</p>
						</div>
						<div class="span2">
							<img src="${pageContext.request.contextPath}/img/pdf1.png" />
							<p>
								<input type="checkbox" name="downloadDocs" id="formatRedFlags" value="FORMATREDFLAG"> <s:text name="label.help.helpFile.FRF" />
							</p>
						</div>
						<div class="clear"></div>
					</div>
					<div class="form-mod smallrow">
						<div class="span2">
							<s:submit key="label.request.Download" cssClass="btn-primary" />
							<!-- <a href="javascript:;" class="btn">Download</a> -->
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<!-- highlighted ends here -->
				</s:form>
			</div>
		</div>
		<div class="clear"></div>
		<div class="form-mod">
			<h2 id="siteAdmin" class="section_flip section_noToggle"><a href="javascript:;"><s:text name="label.help.subHeader.siteAdmin" /></a></h2>
			<hr class="h2-hr">
			<div id="siteAdminPanel" class="section_panel">
			   <s:form id="downloadSiteAdminHelpPDFFormId" action="downloadHelpPDF" namespace="/int">				
				<div class="highlighted">
					<div class="form-mod smallrow">
						<div class="span5">
							<p><s:text name="label.help.selectToDownload" /></p>
						</div>
					</div>
					<div class="clear"></div>
					<div class="gbg">
						<div class="span2">
							<img src="${pageContext.request.contextPath}/img/pdf1.png" />
							<p>
								<input type="checkbox" name="downloadDocs" id="geSiteAdminsList" value="SITEADMINS"> <s:text name="label.help.helpFile.LGESA" />
							</p>
						</div>
						<div class="clear"></div>
					</div>
					<div class="form-mod smallrow">
						<div class="span2">
							<!-- <a href="javascript:;" class="btn">Download</a> -->
							<s:submit key="label.request.Download" cssClass="btn-primary" />
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<!-- highlighted ends here -->
				</s:form>
			</div>
		</div>
		<div class="clear"></div>
		<div class="form-mod">
			<h2 id="participatingBank" class="section_flip section_noToggle"><a href="javascript:;"><s:text name="label.help.subHeader.participatingBank" /></a></h2>
			<hr class="h2-hr">
			<div id="participatingBankPanel" class="section_panel">
				<s:form id="downloadPBanksHelpPDFFormId" action="downloadHelpPDF" namespace="/int"> 
				<div class="highlighted">
					<div class="form-mod smallrow">
						<div class="span5">
							<p><s:text name="label.help.selectToDownload" /></p>
						</div>
					</div>
					<div class="clear"></div>
					<div class="gbg">
						<div class="span2">
							<img src="${pageContext.request.contextPath}/img/pdf1.png" />
							<p>
								<input type="checkbox" name="downloadDocs" id="participatingBanks" value="PARTICIPATINGBANK"><s:text name="label.help.helpFile.PB" />
							</p>
						</div>
						<div class="span2">
							<img src="${pageContext.request.contextPath}/img/pdf1.png" />
							<p>
								<input type="checkbox" name="downloadDocs" id="banksForTPT" value="BANKFORTPT"><s:text name="label.help.helpFile.BAforTPT" />
							</p>
						</div>
						<div class="span2">
							<img src="${pageContext.request.contextPath}/img/pdf1.png" />
							<p>
								<input type="checkbox" name="downloadDocs" id="privateLabelBanks" value="PRIVATEBANK"><s:text name="label.help.helpFile.PLB" />
							</p>
						</div>
						<div class="clear"></div>
					</div>
					<div class="form-mod smallrow">
						<div class="span2">
							<s:submit key="label.request.Download" cssClass="btn-primary" />
							<!-- <a href="javascript:;" class="btn">Download</a> -->
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<!-- highlighted ends here -->
				</s:form>
			</div>
		</div>
		<div class="clear"></div>
		<div class="form-mod">
			<h2 id="tradeFinance" class="section_flip section_noToggle"><a href="javascript:;"><s:text name="label.help.subHeader.tradeFinance" /></a></h2>
			<hr class="h2-hr">
			<div id="tradeFinancePanel" class="section_panel">
				<div class="row">
					<div class="span5">
						<a href="http://in.treasury.corp.ge.com/pps/tibco/in_treasury" target="_blank"><s:text name="label.help.helpFile.TP" /></a><br /> 
						<a href="http://www.iccwbo.org/news/articles/2006/icc%E2%80%99s-new-rules-on-documentary-credits-now-available/" target="_blank"><s:text name="label.help.helpFile.intnlChamberOfCommerce" /></a><br /> 
					</div>
				</div>
			</div>
			<!-- end of form form-mod -->
		</div>
		<div class="clear"></div>
		<div class="form-mod">
			<h2 id="userManual" class="section_flip section_noToggle"><a href="javascript:;"><s:text name="label.help.subHeader.userManual" /></a></h2>
			<hr class="h2-hr">
			<div id="userManualPanel" class="section_panel">
			<s:form id="downloadUserManualHelpPDFFormId" action="downloadHelpPDF" namespace="/int">			
				<div class="highlighted">
					<div class="form-mod smallrow">
						<div class="span5">
							<p><s:text name="label.help.selectToDownload" /></p>
						</div>
					</div>
					<div class="clear"></div>
					<div class="gbg">
						<div class="span2">
							<img src="${pageContext.request.contextPath}/img/format.png" width="50px" height="59px" />
							<p>
								<input type="checkbox" name="downloadDocs" id="userManual" value="USERMANUAL"> <s:text name="label.help.helpFile.UM" />
							</p>
						</div>
						<div class="clear"></div>
					</div>
					<div class="form-mod smallrow">
						<div class="span2">
							<s:submit key="label.request.Download" cssClass="btn-primary" />
							<!-- <a href="javascript:;" class="btn">Download</a> -->
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<!-- highlighted ends here -->
				</s:form>
			</div>
		</div>
		<div class="clear"></div>
		<div class="form-mod">
			<h2 id="userRoles" class="section_flip section_noToggle"><a href="javascript:;"><s:text name="label.help.subHeader.userRoles" /></a></h2>
			<hr class="h2-hr">
			<div id="userRolesPanel" class="section_panel">
 			<s:form id="downloadUserRolesHelpPDFFormId" action="downloadHelpPDF" namespace="/int">	 			
				<div class="highlighted">
					<div class="form-mod smallrow">
						<div class="span5">
							<p><s:text name="label.help.selectToDownload" /></p>
						</div>
					</div>
					<div class="clear"></div>
					<div class="gbg">
						<div class="span2">
							<img src="${pageContext.request.contextPath}/img/pdf1.png" />
							<p>
								<input type="checkbox" name="downloadDocs" id="userRoles"  value="USERROLES"> <s:text name="label.help.helpFile.URR" />
							</p>
						</div>
						<div class="clear"></div>
					</div>
					<div class="form-mod smallrow">
						<div class="span2">
							<s:submit key="label.request.Download" cssClass="btn-primary" />
							<!-- <a href="javascript:;" class="btn">Download</a> -->
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<!-- highlighted ends here -->
				</s:form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<%@include file="../common/footerSection.jsp"%>
</body>
<script type="text/javascript">
$(document).ready(function(){ 
	$('.section_flip').each(function(){
		$(this).addClass('section_active');
	});
	$('.section_panel').each(function(){
		$(this).slideDown();
	});
});
var pagelevelerror = $('#errorShowId').val();
if(pagelevelerror!=undefined && pagelevelerror == 'true'){
	$('#helpLevelErrorDivId').show();
}
</script>
</html>