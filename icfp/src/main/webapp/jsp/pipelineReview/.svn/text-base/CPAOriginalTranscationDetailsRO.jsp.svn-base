<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
	<c:set var="CPALegSummary" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
<div class="display-row">
			<h2 class="span12">Details</h2>
            <div class="clear"></div>
			<div class="row highlighted">
               <div class="span5">
                    <div class="form-row">
                        <p><b>Product Type</b></p>
                        <p><c:choose>
          					<c:when test="${empty CPALegSummary.product}">
								<label>-</label>
							</c:when>
							<c:otherwise>
								<label>${CPALegSummary.product}</label>
							</c:otherwise>
						</c:choose>	
                       
                        </p>
                    </div>
                </div>
                 <!-- end of block -->
                <div class="span5 right">
                    <div class="form-row">
                        <p><b><bean:message key="cpafundingRequest.VaultRequestID" /></b></p>
                        <p>
                        <c:choose>
          					<c:when test="${empty sessionScope.deal.vaultId}">
								<label>-</label>
							</c:when>
							<c:otherwise>
								<label>${sessionScope.deal.vaultId}</label>
							</c:otherwise>
						</c:choose>	
                        </p>
                    </div>
                </div> <!-- end of block -->
			</div>
            
		</div><!-- form mode ends here -->
        
