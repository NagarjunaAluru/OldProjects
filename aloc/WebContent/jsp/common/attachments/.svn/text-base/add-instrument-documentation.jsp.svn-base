<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- <td><a href="#" class="delete-tr"><img src="img/delete.gif"></a></td> -->	
<td>--</td>
<td>
	<label><s:text name="label.request.attachDocument"/></label>
	<s:file name="requestDetailsBO.attachmentBOList[%{#parameters['newInstrDocAttachmentIndex']}].uploadFiles" class="input-file-attach span4" theme="aloc" />
</td>
<td>	
	<s:textarea class="resize: none; overflow-y: hidden;" name="requestDetailsBO.attachmentBOList[%{#parameters['newInstrDocAttachmentIndex']}].attachmentDesc" rows="1" onKeyPress="return imposeMaxLength(this, 99);"/>
     <div class="clear"></div>
    <div class="counter">100</div> <!-- fix positions -->
    <div class="counterTxt"><p class="guidance"><s:text name="label.request.limitis100Characters"/></p></div>
</td> 