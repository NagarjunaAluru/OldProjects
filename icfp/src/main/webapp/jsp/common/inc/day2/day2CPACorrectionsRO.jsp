<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>

<c:set var="day2legSummaryVO"
	value="${deal:fetchDay2LegSummary(1, pageContext.request)}"
	scope="page" />

<div class="form-mod">
			<h2 class="span12">Problem Statement</h2>
			<div class="row highlighted">
                <div class="span5">
                    <div class="form-row">
                        
                        <div class="form-row autosize-container">
                            <label>&nbsp;</label>
                            <c:if test="${not empty day2legSummaryVO.problemStatement}">${day2legSummaryVO.problemStatement}</c:if>
                        </div>
                    </div>
                </div> <!-- end of block -->
            </div>
		</div><!-- end of form form-mod -->



<div class="form-mod">
	<h2 class="span12">Correction Needed</h2>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row ">

				<div class="form-row autosize-container">
					<label>&nbsp;</label>
					<c:if test="${not empty day2legSummaryVO.correctionNeededComments}">${day2legSummaryVO.correctionNeededComments}</c:if>
				</div>
			</div>
		</div>
		<!-- end of block -->

		<div class="span5 right">
			<div class="form-row">
				<label>Action Needed By</label>
				<c:if test="${not empty day2legSummaryVO.actionNeededByDt}">${day2legSummaryVO.actionNeededByDt}</c:if>
			</div>
		</div>
		<!-- end of block -->
	</div>
</div>


<!-- end of form form-mod -->


