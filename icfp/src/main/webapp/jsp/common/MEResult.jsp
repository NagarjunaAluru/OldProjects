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
<script src="${context}/js/common/MEResult.js" type="text/javascript"></script>
<div class="row">

<div class="span2">
<div class="form-row">
	<label>Business Segment</label>
	<select class="bs-filter span2" id="bSegmentID">
		<option value="">Select...</option>
		<option value="CLL Americas">CLL Americas</option>
		<option value="Capital HQ/Other">Capital HQ/Other</option>
		<option value="Asia">Asia</option>
		<option value="Treasury">Treasury</option>
		<option value="EMEA">EMEA</option>
		<option value="GECAS">GECAS</option>
		<option value="EMRG">EMRG</option>
		<option value="Retail Finance">Retail Finance</option>
		<option value="Restructure Op.">Restructure Op.</option>
		<option value="EFS">EFS</option>
		<option value="Commercial Real Estate">Commercial Real Estate</option>
	</select>
</div>
</div>

<div class="span4">
<div class="form-row">
	<label>Management Entity</label>
	<p>Begin with <input type="text" class="me-entity span2" id="mEntityID"  style="text-transform:uppercase"/></p>
</div>
</div>

<div class="span2">
<div class="form-row">
	<label>Legal Entity</label>
	<p class="le-goldid"></p>
	<input type="hidden" name="leGold"  id="leGoldID" value="${leGoldID }" />
</div>

</div>
<div class="row">
	<div class="span4 right">
		<a href="#" class="btn right btn-success searchme">Search</a>
	</div>

</div>



<div id="results">
<input type="hidden" name="recordCount" id="meRecordCountID" value="${meRecordCount}"/>
 <input type="hidden" name="prevPageNumber" id="mePrevPageStart"  value="${mePrevPageNumber}"/>
 <input type="hidden" name="nextPageNumber" id="meNextPageStart"  value="${meNextPageNumber}"/>
<c:set var="resultsSize" value="${fn:length( requestScope.results) }" />
  <div class="row">
		<div class="span2 left">
	    	<label>Results : ${resultsSize}</label>
	 	</div> 	
	 
  </div>
  <div class="row">
  	<div class="span6 left">
	    	<p class="left clear"><bean:message key="label.moreRecords.message" /></p>
	</div>
  </div>
  
<div style="height:250px; overflow:auto">
<table class="table table-striped table-bordered me">
<thead>
<tr><th></th>
<th>Management Entity code</th>
<th>Management Entity Name</th>
<th>Business Segment</th>
</tr>
</thead>
<tbody>
<c:forEach var="i" items="${requestScope.results}">
<tr>
<td><input type="radio" name="selectMEEntity" class="selectEntity" 
	value='<%=new Gson().toJson( pageContext.getAttribute("i") )%>'/></td>
<td>${i.meGoldId}</td>
<td>${i.MEName}</td>
<td>${i.businessSegment}</td>
</tr>
</c:forEach>
</tbody>
</table>
<div class="row span4 right" id="pageDivID">
		    <div style="width:280px;border:0px solid red;margin-top:10px;">
			   <div style="width:120px;border:0px solid red;" class="left">
		             <a type="submit"  id="mePreviousID" href="#" onclick="getNextME('prev')" class="leader-search"><img src="${context}/images/prevBtn.gif"></a>
		         </div>
				 <div style="width:120px;text-align:right;border:0px solid red;" class="right">
		             <a type="submit"  id="meNextID"     href="#" onclick="getNextME('next')" class="leader-search"><img src="${context}/images/nextBtn.gif"></a>
		         </div>
			  <div class="clear"></div>
         </div>
</div>

</div>   
	

</div>