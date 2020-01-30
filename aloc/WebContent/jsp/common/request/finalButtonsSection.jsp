<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <html>
<head>
<%@include file="../../common/includeCommonScripts.jsp"%>
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/common/site.css" type="text/css" rel="stylesheet" />
</head>

<body> --%>
<!-- <div class="container main"> -->
<div class="row">
	<div class="span12">
		<nav>
			<ul>
				<li><a id="nav-save" href="#tab1" ><s:text name="label.request.saveAsDraft"/></a></li>
				<li id="li2"><a id="nav-prepare" href="#tab2"><s:text name="label.request.prepareForBundling"/></a></li>
				<li id="li3"><a id="nav-submit" href="#tab3"><s:text name="label.amendment.submitRequest"/></a></li>
				<li id="li4"><a id="nav-model" href="#tab4"><s:text name="label.request.modelOnly"/></a></li>
				<li class="last"><a id="nav-exit" href="#tab5"><s:text name="label.request.exitRequest"/></a></li>
			</ul>
		</nav>

		<!--<section class="tab" id="tab1">

</section>-->

		<section class="tab" id="tab2" >
			<div class="row">
				<div class="span12 btn-container">
					<div class="form-row">
						<jsp:include page="../../common/request/buDelegation.jsp"/>
						<a href="javascript:;" class="btn"><s:text name="label.request.addToBundle"/></a>
						<a href="javascript:;" class="btn-tertiary cancel"><s:text name="label.request.common.cancel"/></a>
					</div>
				</div>
			</div>
		</section>

		<section class="tab" id="tab3" >
			<div class="row">
				<div class="span12 btn-container">
					<div class="form-row">
						<jsp:include page="../../common/request/buDelegation.jsp"/>
						<a href="javascript:;" class="btn"><s:text name="label.request.Submit"/></a> <a
							href="javascript:;" class="btn-tertiary cancel"><s:text name="label.request.common.cancel"/></a>
					</div>
				</div>
			</div>
		</section>

		<section class="tab" id="tab4" >

			<div class="row">
				<div class="span12">
					<input type="checkbox" id="savemodel" /><s:text name="label.request.saveAsModel"/><span class="ttip info"
						data-original-title="This is an tooltip with more information"></span>
				</div>
			</div>
			<div class="row hide" id="ModelShow">
				<div class="span12">
					<label><s:text name="label.request.modelName"/></label> <input type="text" />
				</div>
			</div>
			<div class="row">
				<div class="span12 btn-container">
					<div class="form-row">
						<a href="javascript:;" class="btn"><s:text name="label.request.Submit"/></a> <a
							href="javascript:;" class="btn-tertiary cancel"><s:text name="label.request.common.cancel"/></a>
					</div>
				</div>
			</div>
		</section>
	</div>
<!-- </div> -->
</div>
<!-- </body>
</html> -->