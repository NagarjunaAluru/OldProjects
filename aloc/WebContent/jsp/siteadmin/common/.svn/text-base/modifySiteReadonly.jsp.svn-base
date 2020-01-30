<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
		
                
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<label><s:label key="label.siteAdmin.siteIdC" /></label>
					</div>
           		</div>
				<div class="span5 left">
					<div class="form-row">
						<p><s:property value="siteAdmin.siteId"/></p>
					</div>
           		</div>
           	</div>
           	<div class="row txtCnt">
		         <div class="span12">
			         <div class="form-row">
			         	<s:textfield name="siteAdmin.siteName"
			               tooltip="%{getText('label.siteAdmin.tooltip.siteName')}"
						   id="siteName" 
						   key="label.siteAdmin.siteName" 
						   theme="aloc"
						   cssClass="autosze50"
						   maxlength="50"
						/>	
	                 <div class="clear"></div>
	                 <div class="counter"><s:text name="label.common.siteAdmin.fifty" /></div> <!-- fix positions -->
	                 <div class="counterTxt"><p class="guidance"><s:text name="label.common.siteAdmin.charLeftFifty" /></p></div>
	                 
	                 <div class="errorMsg">
	 	             <img alt="Loading..." id="siteNameProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
			                            	
			         <img src="${pageContext.request.contextPath}/img/yes.png" title="Model Enabled" id="matched"
					 style="vertical-align: middle;display:none;" />
					 <img src="${pageContext.request.contextPath}/img/no.png" title="Model Disabled" id="unMatched"
					 style="vertical-align: middle;display:none;"/>
					<span class="siteNameStr"></span>
			        </div>
			        </div>
		       </div>
		    </div>
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<label><s:label key="label.siteAdmin.sitePrefixC" /></label>
					</div>
           		</div>
				<div class="span5 left">
					<div class="form-row">
						<p><s:property value="siteAdmin.sitePrefix"/></p>
					</div>
           		</div>
           	</div>
			<div class="row txtCnt">
                <div class="span12"> 
                <div class="form-row autosize-container">
					<s:textarea name="siteAdmin.description"
						cols="50" 
						rows="2" 
						id="description" 
						theme="aloc" 
						key="label.common.siteAdmin.description" 
						cssClass="autosze50 messageinput" 
						onKeyPress="return imposeMaxLength(this, 49);"
					/>
									
	                <div class="clear"></div>
	                <div class="counter"><s:text name="label.common.siteAdmin.fifty" /></div> <!-- fix positions -->
	                <div class="counterTxt"><p class="guidance"><s:text name="label.common.siteAdmin.charLeftFifty" /></p></div>
                </div>
                </div>
            </div>
            <s:hidden name="siteAdmin.siteType.siteTypeId" id="siteType"/>
            <s:hidden name="siteAdmin.sitePrefix" id="sitePrefix"/>
            
            
                    
