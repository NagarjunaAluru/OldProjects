<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.google.gson.Gson" %>
<%@ page errorPage="error.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:common/>
<fmt:setLocale value="en-US"/>
<script src="${context}/js/common/TCodeResult.js" type="text/javascript"></script>

<div style="height:350px; overflow:auto" id="results">
 <label>Results: ${fn:length( requestScope.results ) }</label>
 <input type="hidden" name="recordCount" id="tcRecordCountID" value="${tcRecordCount}"/>
 <input type="hidden" name="prevPageNumber" id="tcPrevPageStart"  value="${tcPrevPageNumber}"/>
 <input type="hidden" name="nextPageNumber" id="tcNextPageStart"  value="${tcNextPageNumber}"/>
 <input type="hidden" name="leGold"  id="tcLEGoldID" value="${tcLEGoldID }" />
 
<table class="table table-striped table-bordered">

<thead>
<tr><th></th>
<th>TCode</th>
<th>Bank Name</th>
</tr>
</thead>
<tbody>
<c:forEach var="i" items="${requestScope.results}">
<tr>
<td><input type="radio" name="selectTcode" class="selectEntity" 
	value='<%=new Gson().toJson( pageContext.getAttribute("i") )%>'/></td>
<td>${i.treasuryCode} </td>
<td>${i.bankName}</td>
</tr>
</c:forEach>
</tbody>
</table>

<div class="row span4 right" id="pageDivID">
		   <div style="width:280px;border:0px solid red;margin-top:10px;">
			   <div style="width:120px;border:0px solid red;" class="left">
		             <a type="submit"  id="tcPreviousID" href="#" onclick="getNextTcodeList('prev')" class="btn-link left leader-search"><img src="${context}/images/prevBtn.gif"></a>
		          </div>
				 <div style="width:120px;text-align:right;border:0px solid red;" class="right">
		             <a type="submit"  id="tcNextID"     href="#" onclick="getNextTcodeList('next')" class="btn-link left leader-search"><img src="${context}/images/nextBtn.gif"></a>
		         </div>
			  <div class="clear"></div>
         </div>
  </div>