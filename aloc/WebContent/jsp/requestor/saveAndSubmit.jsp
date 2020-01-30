<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<input type="hidden" name="actionType" id="actionTypeId" value="${actionType}">
<s:hidden value="%{requestDetails.prepareForBundle}" name="requestDetails.prepareForBundle" id="prepareForBundleId"/>
<s:url action="cancel.action" namespace="/int/requestor" var="cancelBtnlURL" />
<div class="row">
	<div class="span12">
		<input type="button" value="<s:text name="label.request.saveAsDraft"/>" class="btn-secondary" id="nav-save"/>
		<c:if test="${requestDetails.instrumentTypeId != 3}">
			<input type="button" value="<s:text name="label.request.prepareForBundling"/>" data-dropdown="#dropdown-1" class="bottombtn btn-secondary" id="nav-prepare" />
		</c:if>
		<input type="button" value="<s:text name="label.request.submitRequest"/>" data-dropdown="#dropdown-2" class="bottombtn btn-secondary" id="nav-submit" />
		<input type="button" value="<s:text name="label.request.modelOnly"/>" data-dropdown="#dropdown-3" class="bottombtn btn-secondary" id="nav-model" />
		<a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.exitRequest"/></a>
		
		<c:if test="${requestDetails.instrumentTypeId != 3}">
		<div id="dropdown-1" class="dropdownNew dropdown-tip" style="margin-left:0px; margin-top:-1px;">
		    <div class="dropdown-panel">
		    	<div class="row approversErrorDiv" style="display: none;">
            		<div class="span5">
               		 <div class="errorbox">
                			<div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
								<div class="errorContent">
	                				<p id="approversError"></p>
               					</div>
               		</div>
           	 		</div>
       			</div>	
		    	<div class="row smallrow">
		        <div class="span6 btn-container">
		            <div class="form-row">
		            	<div class="tabDelegation" id="tabDelegation2">
		            	<c:if test="${param.actionType == 1}">
		            	<jsp:include page="/jsp/common/request/buDelegation.jsp"/>
		            	</c:if>
		                </div>
		                <p>&nbsp;</p>
						<s:submit key="label.request.addToBundle" onclick="setBundleFlag(1)" cssClass="btn-primary"/>
						<a class="nav-hide-review btn-tertiary" href="#tab5"><s:text name="label.request.common.cancel"/></a>                  
		            </div>
		        </div>
		    </div>
		    </div>
		</div>
		</c:if>
		<div id="dropdown-2" class="dropdownNew dropdown-tip" style="margin-left: 0px; margin-top: -1px; z-index: 1000">
			<div class="dropdown-panel">
				<div class="row smallrow">
					<div class="span6 btn-container">
						<div class="form-row">
					<div class=" row approversErrorDiv" style="display: none;">
            		<div class="span5">
               		 <div class="errorbox">
                			<div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
								<div class="errorContent">
	                				<p id="approversError"></p>
               					</div>
               		</div>
           	 		</div>
       			</div>	
							<div class="row smallrow">
								<div class="span12">
									<div class="form-row">
										<input type="checkbox" name="text" id="saveAsModel" />
										<s:text name="label.request.saveAsModel" />
										<span class="ttip info"	data-original-title="<s:text name="label.request.tooltip.saveAsAModelOptional"/>"></span>
										<input type="hidden" name="requestDetails.saveAsModel" id="saveasmodelId" value="${requestDetails.saveAsModel}" />
									</div>
								</div>
								<!-- end of block -->
							</div>

							<div class="row hide" id="SaveAsModelShow">
								<div class="span6">
									<div class="form-row">
										<c:if test="${param.actionType == 2}">
											<jsp:include page="/jsp/common/request/saveAsModel.jsp" />
										</c:if>
									</div>
								</div>
								<!-- end of block -->
							</div>

							<div class="tabDelegation" id="tabDelegation3">
								<c:if test="${param.actionType == 2}">
									<jsp:include page="/jsp/common/request/buDelegation.jsp" />
								</c:if>
							</div>

							<p>&nbsp;</p>

							<s:submit key="label.request.Submit" onclick="submitAction(2)" cssClass="btn-primary" />
							<a class="nav-hide-review btn-tertiary" href="#tab5"><s:text name="label.request.common.cancel" /></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		<div id="dropdown-3" class="dropdownNew dropdown-tip" style="margin-left:0px; margin-top:-1px;">
		    <div class="dropdown-panel">
		    	<div class="row" id="modelNameId">
					<div class="span6">
						<div class="form-row">
							<c:if test="${param.actionType == 7}">
								<jsp:include page="/jsp/common/request/saveAsModel.jsp" />
							</c:if>
						</div>
					</div>
					<!-- end of block -->
				</div>      
		
		        <p>&nbsp;</p>
				<s:submit key="label.request.Submit" onclick="submitAction(7)" cssClass="btn-primary"/>
				<a class="nav-hide-review btn-tertiary" href="#tab5"><s:text name="label.request.common.cancel"/></a>       
		    </div>
		</div>
	</div>
</div>
<!-- EXIT REQUEST POPUP WINDOW -->
<div class="modal hide fade" id="clearEntries">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.request.clearEntries"/> <span></span></h3>
		</div>
		<div class="modal-body">
		<p><b><s:text name="label.request.popUpMsg"/></b><br>
		<s:text name="label.request.popUpsubMsg"/>
		</p>
		</div>
		<div class="modal-footer">
		    <a href="<s:property value="#cancelBtnlURL" />" class="btn-secondary"><s:text name="label.request.popUpCancelYes"/></a>
			<a href="javascript:;" class="btn-tertiary cancel" data-dismiss="modal"><s:text name="label.request.popUpCancelNo"/></a>
		</div>
</div>
