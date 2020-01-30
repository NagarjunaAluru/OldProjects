<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="form-mod" id="issuingBankDiv">
	   		<h2 id="issuingBankSectionFlip" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.issBankDetails"/></a>
			</h2><hr class="h2-hr">
			<div id="issuingBankSectionFlipPanel" class="section_panel">
				<div class="row">
		<div class="span44">
			<div class="form-row">
				<label><s:text name="label.request.issuingBankSelectFlag" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<c:choose>
                		<c:when test="${requestDetails.issuingBankSelectionFlag == 'Y'}">
                			<s:text name="label.advanceSearch.yes" />
                		</c:when>
                		<c:when test="${requestDetails.issuingBankSelectionFlag == 'N'}">
                			<s:text name="label.advanceSearch.no" />
                		</c:when>
                		<c:otherwise>
                			-
                		</c:otherwise>
                	</c:choose>
				</p>
			</div>
		</div>
</div>

<div class="row">
		<div class="span44">
			<div class="form-row">
				<label><s:text name="label.request.selectedIssBank" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<c:out
						value="${requestDetails.treasurySelectedBankName}" />
				</p>
			</div>
		</div>
</div>
				
			     
			</div>
	   </div>

