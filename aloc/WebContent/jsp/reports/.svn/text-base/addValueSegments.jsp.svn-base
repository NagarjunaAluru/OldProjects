<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <td height="1" class="noPadding">
<div class="row span12" >					
		<div class="span3a">
			<label>&nbsp;</label>
			<select class="valueSegmentSelection">
				<option>Select...</option>
				<option value="gt">Greater than</option>
				<option value="lt">Less than</option>
				<option value="re">Range</option>
			</select>
		</div>
		<div class="span3a gtlt">
			<label>&nbsp;</label>
			<input type="text" />
		</div>
		<div class="span3a gtlt">
			<label>&nbsp;</label>
			To&nbsp;<input type="text" />
		</div>
		<div class="span3a hide range">
			<label>&nbsp;</label>
			<input type="text" />
		</div>
</div>					
</td>
<script type="text/javascript">
$(document).ready(function() {
	$(".valueSegmentSelection").off("change").on("change",function(){
		var segmentVal= $(this).val(); 
		if(segmentVal == 're'){
			$(this).closest('.row').find('div.range').show();
			$(this).closest('.row').find('div.gtlt').hide();
		}else{
			$(this).closest('.row').find('div.range').hide();
			$(this).closest('.row').find('div.gtlt').show();
		}
	});
});
</script>