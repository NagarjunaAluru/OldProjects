<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
<td>
	<div class="form-row">
		<input name="debtTerms" type="text" class="span2 requestDebt-equity" maxlength="20">
	</div>
</td>
<td>
	<div class="form-row">
		<select name="shareTypeId" class="span2 requestDebt-equity">
			<option value="">Select..</option>
			<c:forEach items="${applicationScope['com.ge.icfp.StaticData'].shareTypes}" var="option">
				<option value="${option.ID}">${option.name}</option>
			</c:forEach>
		</select>
	</div>
</td>
<td>
	<div class="form-row">
		<input name="numberOfShares" type="text" class="span2 requestDebt-noOfShares"  maxlength="9">
	</div>
</td><td>
	<div class="form-row">
		<input name="shareValue" type="text" class="span2 requestDebt-sharevalue" maxlength="9">
		<input name="sharePrfId" type="hidden" value="">
	</div>
</td>