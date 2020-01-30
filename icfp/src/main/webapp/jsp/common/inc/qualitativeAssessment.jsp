<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
	<div class="form-mod">
			<h2 class="span12 collapsible"><bean:message key="heading.qualitativeAssessment"/></h2>
			<div class="clear"></div>
			<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable">
					<thead>
					  <tr>
					  	<th><bean:message key="columnHeader.qualitativeAssessment.legNo"/></th>
						<th><bean:message key="columnHeader.qualitativeAssessment.qualitativeFactors"/></th>
						<th><bean:message key="columnHeader.qualitativeAssessment.assessment"/></th>
						<th><bean:message key="columnHeader.qualitativeAssessment.owner"/></th>
						<th><bean:message key="columnHeader.qualitativeAssessment.rationale"/></th>
					  </tr>
					</thead>
					<tbody>
					<c:if test="${not empty param.factor}">
						<c:forEach var="eachLegDetails" items="${deal:fetchLegs(pageContext.request)}" >
							<c:forEach var="eachQualitativeFactor" items="${eachLegDetails.qualitativeFactorsList}">
								<c:forTokens items="${param.factor}" delims="," var="eachFactor">
		     					<c:if test="${eachQualitativeFactor.qualitativeFactor eq eachFactor}">
		     					<tr>
								<td>${eachLegDetails.legSeqId}</td>
								<td>${eachQualitativeFactor.qualitativeFactor}</td>
								<td>${eachQualitativeFactor.assessment}</td>
								<td>${eachQualitativeFactor.ownerSso}</td>
								<td>${eachQualitativeFactor.comment}</td>
							 	</tr>
							 	</c:if>
							 	</c:forTokens>
						 	</c:forEach>
					 	</c:forEach>
					 </c:if>
					 <c:if test="${empty param.factor}">
					 	<c:forEach var="eachLegDetails" items="${deal:fetchLegs(pageContext.request)}" >
							<c:forEach var="eachQualitativeFactor" items="${eachLegDetails.qualitativeFactorsList}">
								<c:if test="${not empty eachQualitativeFactor.assessment and eachQualitativeFactor.assessment ne 'Low'}">
		     					<tr>
								<td>${eachLegDetails.legSeqId}</td>
								<td>${eachQualitativeFactor.qualitativeFactor}</td>
								<td>${eachQualitativeFactor.assessment}</td>
								<td>${eachQualitativeFactor.ownerSso}</td>
								<td>${eachQualitativeFactor.comment}</td>
							 	</tr>
							 	</c:if>
						 	</c:forEach>
					 	</c:forEach>
					 </c:if>
					 </tbody>
				  </table>
				</div>
			</div> 
        </div> 