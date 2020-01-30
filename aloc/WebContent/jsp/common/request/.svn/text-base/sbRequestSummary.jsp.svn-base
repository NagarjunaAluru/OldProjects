 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <!-- REQUEST SUMMARY -->
	<div id="requestSummary" style="width: 100%;">
    	<div class="leftColRS">
        	<p><strong><s:text name="label.request.requestSummary"/></strong> - <s:text name="label.request.alocRecNo"/> <strong>
        			<c:out value="${requestDetails.alocRecordId}"/>
        	</strong></p>
        </div>
		<div class="clear"></div>
        
        <div class="singleBoxRS">
            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.requestor"/></label>
                    <c:out value="${requestDetails.requestSummary.requestor.lastName}"/>, <c:out value="${requestDetails.requestSummary.requestor.firstName}"/> <br>
                    <c:out value="${requestDetails.requestSummary.requestor.ssoId}"/><br>
                </div>          
            </div>
		</div><!-- leftBox ends here -->
        
        
        <div class="singleBoxRS">
            <div class="row smallrow">
                <div class="span2">
                     <label><s:text name="label.request.alocRecNo"/></label>
        			 	<c:out value="${requestDetails.alocRecordId}"/>
                </div>          
            </div>
        </div><!-- midBox ends here -->
         <s:if test="%{requestDetails.rider.riderRequestId != null}"> 
        <div class="singleBoxRS">
            <div class="row smallrow">
                <div class="span2">
                    <label><s:text name="label.request.riderSequenceNumber"/></label>
						<p><c:out value="${requestDetails.rider.riderRequestId}"/> </p>
                </div>        
            </div>
        </div><!-- rightBox ends here -->
        </s:if>

        <div class="singleBoxRS">
            <div class="row smallrow">
                <div class="span3"> 
                <label><s:text name="label.request.bondTypeSubType"/></label>
							<c:out value="${requestDetails.bondDetails.bondType}"/> - <br>
							<c:out value="${requestDetails.bondDetails.bondSubType}"/>
                </div>        
            </div>
        </div><!-- rightBox ends here -->
                
        <div class="clear"></div>
    </div><!-- requestSummary ends here -->   