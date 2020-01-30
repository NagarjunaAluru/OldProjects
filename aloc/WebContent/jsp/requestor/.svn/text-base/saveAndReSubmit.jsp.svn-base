<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input type="hidden" name="actionType" id="actionTypeId">
<s:url action="cancel.action" namespace="/int/requestor" var="cancelBtnlURL" />
<div class="row">
	<div class="span12">
		<nav>
				<ul>
					<li id="li1" class="selected navLi"><a class="navLink" href="#tab1"	id="nav-reSave"> 					
							<s:text name="label.request.common.save" />
						</a>
					</li>
					<li id="li2" class="navLi"><a class="navLink" id="nav-reSubmit" href="#tab2">						
							<s:text name="label.request.common.reSubmitRequest" />
						</a></li>
					<li class="last"><a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal">
						<s:text	name="label.request.exitRequest" /></a>
					</li>
				</ul>
			</nav>
		<div class="tab" id="tab2" style="padding:10px;	background:#fff; border:Solid 3px #ccd7e5;">	
					<div class="row approversErrorDiv" style="display: none;">
            		<div class="span11">
               		 <div class="errorbox">
                			<div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
								<div class="errorContent">
	                				<p id="approversError"></p>
               					</div>
               		</div>
           	 		</div>
       			</div>		
					<c:if test="${requestDetails.sendbackbyBuApprover eq 'Y' or requestDetails.businessReApprovalFlag ne 'N'}">
						<jsp:include page="/jsp/common/request/buDelegation.jsp" />
					</c:if>
				    <p class="clear">&nbsp;</p>  
					<s:submit key="label.request.Submit" onclick="submitAction(32)" cssClass="btn"/>
					<a class="nav-hide" href="<s:property value="#cancelBtnlURL" />"><s:text name="label.request.common.cancel"/></a>
		</div>
	</div>
</div>

