function changeValue(obj, status){
	$(obj).parents("tr").find("input:hidden").val(status);
} 