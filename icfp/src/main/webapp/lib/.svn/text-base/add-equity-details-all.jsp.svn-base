<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
	<td>
		<div class="form-row">
			<span class="required">*</span>
			<select name="shareTypeId" class="span2 request-equity">
				<option value="">Select..</option>
				<c:forEach items="${applicationScope['com.ge.icfp.StaticData'].shareTypes}" var="option">
					<option value="${option.ID}">${option.name}</option>
				</c:forEach>
			</select>
		</div>
	</td>
	<td>
		<div class="form-row">
			<span class="required">*</span>
			<input name="numberOfShares" type="text" class="span2 request-noOfShares" maxlength="9">
		</div>
	</td><td>
		<div class="form-row">
			<span class="required">*</span>
			<input name="shareValue" type="text" class="span2 request-sharevalue" maxlength="9">
			<input name="sharePrfId" type="hidden" value="">
		</div>
	</td>

						  