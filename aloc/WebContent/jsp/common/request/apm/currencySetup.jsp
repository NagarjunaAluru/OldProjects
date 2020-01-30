<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath}/js/requestor/apmCurrencySetup.js" type="text/javascript"></script>

	<div class="row">
		<div class="span12" id="curSetupDiv">
			<table class="table table-striped table-bordered no-bottom paginate" id="curSetupTable">
				<thead>
				<tr>
					<th colspan="1" style="width:50px;"></th>
					<th colspan="1" ><s:text name="label.request.currency" /> </th>
					<th colspan="1" ><s:text name="label.request.rateDirection" /><span class="ttip info" data-original-title="<s:text name="label.apm.tooltip.rateDirection"/>"></span></th>
					<th colspan="1" ><s:text name="label.request.tickerSymbol" /><span class="ttip info" data-original-title="<s:text name="label.apm.tooltip.tickerSymbol"/>"></span></th>
					<th colspan="1"><s:text name="label.request.decimalPrecision" /> </th>
					<th colspan="1" ><s:text name="label.request.apmPaymentCurrency" /> </th>
					<th colspan="1" class="optional"><s:text name="label.request.bucOptional" /> <span class="ttip info" data-original-title=""></span></th>
					<th colspan="1" class="optional"><s:text name="label.request.adnOptional" /> </th>
				</tr>
				</thead>
				<tbody>
				
				 <s:if test="%{apmDetails.FXRateHistoryAndCurrencySetup!=null && apmDetails.FXRateHistoryAndCurrencySetup.currencySetups != null && apmDetails.FXRateHistoryAndCurrencySetup.currencySetups.size > 0}">
		        	<s:iterator value="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups" status="curStat">
			            <tr class="shown curRowVal">
			                <td class=""><img class="actionImg editCurSetup" src="${pageContext.request.contextPath}/img/edit-leg.gif"  alt="<s:property value="#curStat.index"/>">&nbsp;&nbsp;&nbsp;
			                	<a href="#deleteCurrency" class="delCurSetup"><img src='${pageContext.request.contextPath}/img/delete.gif'/>
			                	<img alt="Loading..." class="editCurProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;"></a></td>
			                <td>
			                	<c:out value="${currencyName}"/>
			                </td>
			                <td class="rateDirection"><c:if test="${empty rateDirection}">-</c:if><c:if test="${not empty rateDirection}"><c:out value="${rateDirection}" /></c:if></td>
			                <td class="tickerSymbol"><c:if test="${empty tickerSymbol}">-</c:if><c:if test="${not empty tickerSymbol}"><c:out value="${tickerSymbol}" /></c:if></td>
			                <td class="decimalPrecision"><c:if test="${empty decimalPrecision}">-</c:if><c:if test="${not empty decimalPrecision}"><c:out value="${decimalPrecision}" /></c:if></td>
			                <td class=apmPaymentCurrencyFlag><c:if test="${empty APMPaymentCurrencyFlag}">-</c:if><c:if test="${not empty APMPaymentCurrencyFlag}"><c:out value="${APMPaymentCurrencyFlag}" /></c:if></td>
			                <td class="BUC"><c:if test="${empty BUC}">-</c:if><c:if test="${not empty BUC}"><c:out value="${BUC}" /></c:if></td>
			                <td class="ADN"><c:if test="${empty ADN}">-</c:if><c:if test="${not empty ADN}"><c:out value="${ADN}" /></c:if></td>
               				<td class="hide currencyConfigId"> <c:out value="${currencyConfigId}" /></td>
               				<td class="hide curIndex"> <s:property value="#curStat.index"/></td>
               				<td class="hide currName"> <c:out value="${currencyName}"/></td>
               				<td class="hide currencyCode"> <c:out value="${currencyCode}"/></td>
               				<td class="hide currSetupErrorId"> <c:out value="${errorShow}"/></td>
			           </tr>
		           </s:iterator>
		         </s:if>
				 				
				</tbody>
			</table>		
		</div>
	</div>
	<s:hidden cssClass="curSetupSize" name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups.size" id="curSetupSize"/>
	<div class="row">
		<div class="span12">
			<a href="javascript:;" class="addNewCurrency add"><s:text name="label.request.addNewCurrency" />
				<img alt="Loading..." class="addNewCurProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
			</a>
		</div>
	</div>
	
	 <s:if test="%{apmDetails.FXRateHistoryAndCurrencySetup.currencySetups != null && apmDetails.FXRateHistoryAndCurrencySetup.currencySetups.size > 50}">
		<div class="clear"></div>
			<div style="height:50px;"></div>    
			<div class="row">
				<div class="span right">
					<div class="pagenavi left">	
				    </div>
					<div class="span3 jump-page">
							 <s:text name="label.request.jumpTo" />
							<input type="text" class="span1 manual">
							<a class="btn btn-success-blue" type="submit"><s:text name="label.request.go" /></a>
					</div>
				</div>
		  </div>
		  <input type='hidden' id='current_page' />
		  <script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
	  </s:if>
			
	  <jsp:include page="/jsp/common/request/apm/currencySetupDelPopups.jsp" />
	