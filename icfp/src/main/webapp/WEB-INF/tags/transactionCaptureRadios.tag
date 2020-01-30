<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@attribute name="index" required="true" rtexprvalue="true" %>
<%@attribute name="view" required="false" rtexprvalue="true" %>
<%@attribute name="closingCheckListMap" required="true" rtexprvalue="true" type="java.util.Map" %>
<%@attribute name="certificateList" required="true" rtexprvalue="true" type="java.util.List" %>
<%@attribute name="showError" required="false" rtexprvalue="true" %>

<c:set var="certificate" value="${certificateList}"/>
<c:set var="closingCheckList" value="${closingCheckListMap[certificate[index].ID]}" />

<c:choose>
	<c:when test="${view eq 'readOnly'}">
		<td>
			<c:choose>
				<c:when test="${fn:trim(closingCheckList.certFlag) eq '1'}">Yes</c:when>
				<c:when test="${fn:trim(closingCheckList.certFlag) eq '2'}">No</c:when>
				<c:otherwise>NA</c:otherwise>
			</c:choose>
		</td>
		<td>${certificate[index].name}</td>
		<td>${not empty closingCheckList.comments ? closingCheckList.comments : '-'}</td>
	</c:when>
	<c:otherwise>	
		<c:set var="commentsMandatory" value="false"/>
		<c:choose>
			<c:when test="${fn:trim(closingCheckList.certFlag) eq '1'}">
				<c:set var="yesSelected" value="checked=\'checked\'"/>
				<c:set var="commentsMandatory" value="false"/>
			</c:when>
			<c:when test="${fn:trim(closingCheckList.certFlag) eq '2'}">
				<c:set var="noSelected" value="checked='\checked'"/>
				<c:set var="commentsMandatory" value="true"/>
			</c:when>
			<c:when test="${fn:trim(closingCheckList.certFlag) eq '3'}">
				<c:set var="naSelected" value="checked='checked'"/>
				<c:set var="commentsMandatory" value="true"/>
			</c:when>
		</c:choose>
		<td style="width: 85px;">
			<c:if test="${showError}">
				<span class="req-error" style="border-left: #ae2c2c 5px solid;">error</span>
			</c:if>	
			<input type="radio" name="closingCheckLists[${index}].certFlag" value="1" 
				onclick="javascript:hideComments(${index});javascript:checkCheckList();" 
				${yesSelected}/> 
		</td>
		<td style="width: 85px;">
			
			<input type="radio" name="closingCheckLists[${index}].certFlag" value="2" onclick="javascript:showComments(${index});javascript:unCheckCheckList();" ${noSelected}/> 				
			
		</td>
		<td style="width: 84px;">
			<input type="radio" name="closingCheckLists[${index}].certFlag" value="3" onclick="javascript:showComments(${index});javascript:checkCheckList();" ${naSelected}/> 			
		</td>
		<td style="width: 300px;">
			${certificate[index].name}<input type="hidden" name="closingCheckLists[${index}].certListId" value="${certificate[index].ID}">
		</td>
		<td>&nbsp;
			<span id="comment${index}" class="required" style="display: ${commentsMandatory ? 'block' : 'none'};">*</span>
			<input type="text" name="closingCheckLists[${index}].comments" style="text-align: left;" value="${closingCheckList.comments}">
		</td>
	</c:otherwise>
</c:choose>