<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
   <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><s:text name="label.siteAdmin.treasuryAdmin" /></title>
    <meta name="description" content="">
    <meta name="author" content="">
    
    <% String contextUrl = request.getContextPath();  %>
	<script>
	 //Defining the global variable, so this variable can be used by other javascript library included in this JSP 
	  var contextURL = '<%=contextUrl%>';
	</script>

    <%@include file="../common/siteIncludeScripts.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/siteAdmin/siteAdminCreate.js"></script>
    <script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script>
</head>

<body>
	<div class="container main">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes" />
		</jsp:include>
		<div id="mainPage" style="width: 100%;">
			<h1 class="page-title span12"><s:text name="label.siteAdmin.siteAdmin" /></h1>
        	<p class="span12 left clear dashdesc"><s:text  name="label.optionalInstructionSentence.siteAdmin"/></p>
	        <hr class="page-title-hr">
	        <h2><s:text  name="label.siteAdmin.IWouldLikeTo"/></h2>
			<hr class="h2-hr">
			<div class="row">
            	<div class="span12">
					<s:label  key="label.siteAdmin.typeDescription"/>
                	<label class="radio">
	                    <input type="radio" value="option1" name="optionsRadios" id="CreateSiteRadioBut" checked>
	                    <s:text  name="label.siteAdmin.createANewSite"/>
	                    <img alt="Loading..." id="createSiteRadioProcess" align="absmiddle" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
                	</label>
	                <label class="radio">
	                    <input type="radio" value="option2" name="optionsRadios" id="CopySiteRadioBut">
	                    <s:text  name="label.siteAdmin.copyAnExistingSite"/>
	                    <img alt="Loading..." id="copySiteProcess" align="absmiddle" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
	                </label>
	                <label class="radio">
	                    <input type="radio" value="option3" name="optionsRadios" id="ModifySiteRadioBut">
	                    <s:text  name="label.siteAdmin.modifyAnExistingSite"/>
	                </label>                
				</div>
			</div>
        
	        <!-- Copy Site TOGGLE STARTS HERE -->
	        <div id="copy" style="display:none;">
	        	<div class="row" id="siteNameCopy">
		        	<jsp:include page="siteSection.jsp">
						<jsp:param name="sectionId"  value="site.section.copySelectBox" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
	        </div>
        
			<div id="modifySiteToggle" style="display:none;">
				<div id="modify" class="hide">
					<div class="row">
            			<div class="span12">
            				<div class="form-row">
				                <s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].siteTypes}" 
									listKey="ID" 
									listValue="name" 
									id="modifysiteTypes" 
									name="siteAdmin.siteType.siteTypeId"
									headerKey=""
									headerValue="Select..."
									key="label.siteAdmin.siteTypeToBeModified"
									theme="aloc"
								/>	
								<img alt="Loading..." id="modifySiteProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">		
            				</div>
            			</div>
        			</div>
        		</div>
        		<div id="siteIds" style="display:none;">
        			<jsp:include page="siteSection.jsp">
						<jsp:param name="sectionId"  value="site.section.modifySelectBox" />
						<jsp:param name="includeScripts" value="false" />
						<jsp:param value="Modify" name="crFlag"/>
					</jsp:include>
				</div>
			</div>
	        <div id="allSiteSections" > 
	       		<jsp:include page="/jsp/siteadmin/siteSectionsCommon.jsp" >
	       			<jsp:param name="includeScripts" value="false" />
	       		</jsp:include>
	        </div>
		            
			<p>&nbsp;</p>	
		</div>
		<div id="lookupDiv" style="width: 100%;"></div>
	</div><!-- wrapper ends here -->
	<%@include  file="../common/footerSection.jsp" %>
	<jsp:include page="../admin/treasuryAdminExitPopup.jsp" />
</body>
</html>