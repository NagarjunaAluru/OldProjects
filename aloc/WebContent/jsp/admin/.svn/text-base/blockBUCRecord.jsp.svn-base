<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@include file="../common/includeCommonScripts.jsp"%>
<script
	src="${pageContext.request.contextPath}/js/admin/blockBUCMgmt.js"
	type="text/javascript"></script>
		 
		 <div class="row smallrow">
		 	<div style="color: red;" id="bucADnExistsError">
				 <s:actionerror/>
		     </div>
                <div class="span2">
					<s:textfield name="businessUnitCode.BUC" 
				            	 id="searchBUCTextId" 
								 key="label.blockbucmgmt.buc" 
								 maxlength="6" 
								cssClass="span2" 
								theme= "aloc" />
						</div>
						<div class="span1">
							<label>&nbsp;</label>
							<a href="javascript:;" class="btn-secondary validateBUC"><s:text name="label.blockbucmgmt.search"/></a>&nbsp;
	                    </div>
	                    <div class="span1">
                        	<label>&nbsp;</label>
                        	<img alt="Loading..." id="bucValidateIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
							style="height: 20px; display:none">
							<span class="bucvalidate-error hide" style="color:red"></span>
                        </div>
			</div>
		
		<div class="row smallrow">
			<div class="span1">
				<s:label key="label.blockbucmgmt.buc"/>
			</div>
			<div class="span1" id="blockBUCValDiv">
				<s:property value=""/>
			</div>
		</div>
		
		<div class="row">
			<div class="span4">
				<div class="radio-container">
	                     <s:radio cssClass="radio"
											name="blockBUCSelectedVal"
											key="label.blockbucmgmt.likeTo"
										    theme="aloc"
											id="blockBUCSelectedId"
											list="#{'BUC':'Block entire BUC','BUCADN':'Block individual ADNs'}"
											value="%{blockBUCSelectedVal}" />
											</div>
			</div>
		</div>
		<div class="clear">&nbsp;</div>
		<div class="hide highlighted" id="BUCShow">
		<div class="row ">
				<div class="span3">
					<div id="blockNewBUCValDiv">
					 <p> <s:text name="label.blockbucmgmt.thisBUC"/> 
					    <s:text name="label.blockbucmgmt.willBlock"/></p>
					</div>
				</div>
		  </div>
		  
		  <div class="row txtCnt">
			<div class="form-row">
				<div class="span5">
				    <s:label key="label.blockbucmgmt.reason"/>
					<s:textarea name="businessUnitCode.notes" id="bucBlockReason" 
					            theme="aloc" cssClass="autosize150 messageinput"col="50" rows="2"
					            onKeyPress="return imposeMaxLength(this, 149);" ></s:textarea>
						<div class="clear"></div>
	                	<div class="counter">150</div> 
	                	<div class="counterTxt"><p class="guidance">characters remaining</p></div>
						<div class="clear"></div>			
				</div>
			    </div>	
			</div>
		</div>
		<div class="clear"></div>
		<div class="hide highlighted" id="ADNShow">
		<div class="row">
                <div class="span3">
					<s:textfield name="businessUnitCode.ADN" 
				            	 id="searchADNTextId" 
								 key="label.blockbucmgmt.accountingdistributionnumber" 
								 maxlength="23" theme= "aloc" />
					<span class="bucadnvalidate-error hide" style="color:red"></span>			 
				</div>
				<div class="span1">
					   <label>&nbsp;</label>
					   <a href="javascript:;" class="btn-secondary validateBUCADN"><s:text name="label.blockbucmgmt.search"/></a>
	            </div>
	            <div class="span1">
					   <label>&nbsp;</label>
					   <img alt="Loading..." id="bucadnValidateIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
							style="height: 20px; display:none">		
	            </div>
		</div>
		<div class="row">
			<div class="span1">
				<s:label key="label.blockbucmgmt.adn"/>
			</div>
			<div class="span1" id="blockADNValDiv">
					<s:property value=""/>
			</div>
		</div>
		
		<div class="row txtCnt">
			<div class="span5">
				<s:label key="label.blockbucmgmt.reason"/>
				<s:textarea name="reasonForBlock" id="adnBlockReason" 
					            theme="aloc" cssClass="autosize150 messageinput"col="50" rows="2"
					            onKeyPress="return imposeMaxLength(this, 149);" ></s:textarea>
						<div class="clear"></div>
	                	<div class="counter">150</div> 
	                	<div class="counterTxt"><p class="guidance"><s:text name="label.blockbucmgmt.textareaLength"/></div>
						<div class="clear"></div>	
			</div>
		</div>
		</div>
		<s:hidden id="blockBUCHiddenId" name="blockBUCHiddenId" value="%{blockBUCSelectedVal}" />
