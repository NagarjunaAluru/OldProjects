<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common/>

<div class="form-mod">
	<h2 class="span12 collapsible">Transaction Summary</h2>
	<div class="clear"></div>
		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
			<div class="row ">
				<div class="span5">
					<div class="form-row">
						<p>
							<b>Deal ID</b><br />
							${sessionScope.deal.uniqueId}
						</p>
					</div>
				</div>
				<!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p style="word-wrap:break-word;">
							<b>Deal Name</b>
						<br />
							${sessionScope.deal.dealName}
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p>
							<b>Deal Category</b><br />
							${sessionScope.deal.dealCategory}
						</p>
					</div>
				</div>
				<!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p>
							<b>Leg ID</b><br />
							${legSummaryVO.legSeqId}
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
</div>
<!-- end of form form-mod -->
