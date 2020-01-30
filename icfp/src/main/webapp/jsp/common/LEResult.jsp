<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<fmt:setLocale value="en-US"/>
<%@page import="com.google.gson.Gson" %>
<%@ page errorPage="error.jsp" %>
<t:common/>
<script src="${context}/js/common/LEResult.js" type="text/javascript"></script>

<div id="results">
<c:set var="resultsSize" value="${fn:length( requestScope.results ) }" />
 <div class="row">
	<div  class="span2 left">
	    <label>Results : ${resultsSize}</label>
	 </div> 
  </div>
 <div class="row" style="margin-left:-1px;">
	  <p class="left clear"><bean:message key="label.moreRecords.message" /></p>
 </div>
<div style="height:350px; overflow:auto">
<input type="hidden" name="recordCount" id="leRecordCountID" value="${leRecordCount}"/>
 <input type="hidden" name="prevPageNumber" id="lePrevPageStart"  value="${lePrevPageNumber}"/>
 <input type="hidden" name="nextPageNumber" id="leNextPageStart"  value="${leNextPageNumber}"/>
 <input type="hidden" name="forType" id="forTypeID"  value="${forType}"/>
 <input type="hidden" name="query" id="queryID"  value="${query}"/>
<table class="table table-striped table-bordered le">
<thead>
<tr><th></th>
<th>Legal Entity name</th>
<th>CDR code</th>
<th>Legal Entity GOLD ID</th>
<th>Country</th>
<th>Capital or Industrial</th>
</tr>
</thead>
<tbody>
<c:forEach var="i" items="${requestScope.results}">
<tr>
<td><input type="radio" name="selectEntity" class="selectEntity"
 value='<%=new Gson().toJson( pageContext.getAttribute("i") )%>'/></td>
<td>${i.LEName}</td>
<td>${i.CDRCd}</td>
<td>${i.LEGoldId}</td>
<td>${i.country}</td>
<td>${i.capitalIndustrial}</td>
</tr>
</c:forEach>
</tbody>
</table>
<div class="row span4 right" id="pageDivID">
		    <div style="width:280px;border:0px solid red;margin-top:10px;">
			   <div style="width:120px;border:0px solid red;" class="left">
		             <a type="submit"  id="lePreviousID" href="#" onclick="getNextLE('prev')" class="btn-link left leader-search"><img src="${context}/images/prevBtn.gif"></a>
		         </div>
				 <div style="width:120px;text-align:right;border:0px solid red;" class="right">
		             <a type="submit"  id="leNextID"     href="#" onclick="getNextLE('next')" class="btn-link left leader-search"><img src="${context}/images/nextBtn.gif"></a>
		         </div>
			  <div class="clear"></div>
         </div>
</div>
</div>