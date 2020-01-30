<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.standardFormatMgmt.standardFormatTitle" /></title>
<%@include file="../common/includeCommonScripts.jsp" %> 
<script src="${pageContext.request.contextPath}/js/admin/treasuryAdminManagement.js" type="text/javascript"></script>	
</head>  
 <body>      	  
   <div class="container main" id="standardFormatMgmtDiv">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>	
		<h1 class="page-title span12">
			<s:text name="label.standardFormatMgmt.standardFormatHeader" />
		</h1>
		<p class="span12 left clear dashdesc">
			<s:text name="label.standardFormatMgmt.standardFormatSubHeader" />			
		</p>	
		
		<hr class="page-title-hr">			
 			<div style="color:red;"> 					
					<s:actionerror/>				      				
			</div>
		<span class="required-fields-para2" style="margin-top: -35px!important;"><s:text name="label.standardFormatMgmt.allFieldsRequiredUnlessSpecified" /></span>
	<br>		
  		<s:form id="standardFormatMgmtFormId" namespace="/int/admin" action="standardFormatManagement"> 
		<s:hidden id="subBondTypeHiddenVal" value="%{standardFormatMaster.standardFormatSubBondTypeId}"/>
		<s:hidden name="standardFormatMaster.standardFormatId" value="%{standardFormatMaster.standardFormatId}"/>
		<s:hidden name="standardFormatMaster.standardFormatName" value="%{standardFormatMaster.standardFormatName}"/>  				
		<s:hidden id="validationSuccessId"  name="standardFormatMaster.saveCode" value="%{standardFormatMaster.saveCode}"/>		   		 
	<div class="form-mod">
 <!--        <div class="row">
        <div class="span12"> -->
                		        		
			<div class="row">      
					<div class="span12">
						<div class="form-row">
							<label><s:text name="label.standardFormatMgmt.instrumentType" /><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.instrumentType"/>"></span></label>
							<s:select style="margin-bottom:0px; width:225px;" headerKey="-1" tooltip=""
								headerValue="Select..."
								list="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentTypeList}"
								listKey="ID" listValue="name" id="standardFormatInstrumentType"
								name="standardFormatMaster.standardFormatInstrumentTypeId"  theme="aloc"/>
							 <img alt="Loading..." id="standardFormatProcess0" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
							 <span id="intstrumentTypeErrorId" class="hide standardFormatError"><s:text name="label.standardFormatMgmt.error.instrumentTypeId" /></span>	
						</div>
					</div>
			</div>		
			<div class="hide row" id="standardFormatInstrumentPurposeDiv">
				<div class="span12">
					<div class="form-row">
						<label><s:text name="label.request.Instrumentpurpose" /><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.instrumentPurpose"/>"></span></label>						
						<s:select theme="aloc" name="standardFormatMaster.standardFormatPurpusId"
							list="%{#attr['com.ge.aloc.StaticDataFactory'].standardInstrumentPurposeList}"
							headerKey="" headerValue="Select..." listKey="ID"
							listValue="name" id="instrumentPurposeId"
							/> 
						 <img alt="Loading..." id="standardFormatProcess1" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">	
						 <span id="intstrumentPurposeErrorId" class="hide standardFormatError"><s:text name="label.standardFormatMgmt.error.instrumentPurpose" /></span>	
					</div>
				</div>
			</div>
			<div class="hide row" id="standardFormatBondTypeDiv">
					<div class="span12">
						<div class="form-row">							
						<label><s:text name="label.request.bondType" /><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.bondType"/>"></span></label>
							<s:select style="margin-bottom:0px;" headerKey=""								
								list="%{#attr['com.ge.aloc.StaticDataFactory'].adminBondTypes}"
								headerValue="Select..." listKey="ID" listValue="name"
								id="standardFormatBondType" name="standardFormatMaster.standardFormatBondTypeId" theme="aloc" />
							<img alt="Loading..." id="standardFormatProcess2" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
							<span id="bondTypeErrorId" class="hide standardFormatError"><s:text name="label.standardFormatMgmt.error.bondType" /></span>		
						</div>
					</div> 
			</div>
			<div class="hide row" id="standardFormatSubBondTypeDiv">
					<div class="span12"> 
						<div class="form-row">	
							<label><s:text name="label.request.bondSubtype" /><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.subBondType"/>"></span></label>						
							<s:select style="margin-bottom:0px;" list="#{}"
								listKey="ID" listValue="name" id="standardFormatSubBondType" 
								name="standardFormatMaster.standardFormatSubBondTypeId" theme="aloc">
					 		</s:select>		
							<img alt="Loading..." id="standardFormatProcess3" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
							<span id="subBondTypeErrorId" class="hide standardFormatError"><s:text name="label.standardFormatMgmt.error.subBondType" /></span>							 							
						</div>
					</div>
			</div>          
<!--           </div>      
          </div> -->
          </div>			           						 
      <div class="hide row smallrow" id="standardFormatMgmtBodyDiv">  						
					<div class="span8">
						<div class="form-row">
							<label><s:text name="label.standardFormatMgmt.geStandardFormat" /></label>
						</div>
					</div>
					<div class="span200 right">
						<div class="row highlighted">						
								<div class="form-row ">
									<label >Last update <s:date name="standardFormatMaster.lastModifiedDt" format="MMM dd, yyyy - HH:mm aa zzz"/></label>
								</div>
						</div>
					</div>		   
		<div class="clear"></div>     		
           <div id="geStandardFormat" >
                	<div class="leftBox">  
							<s:textarea            				
				               		id="geStandardFormatId" 
				               		cssClass="mceEditor"
				               		cssStyle="width:525px; height: 500px;"
				               		name="standardFormatMaster.standardFormatFormat"               							               		
				               		value="%{standardFormatMaster.standardFormatFormat}"  theme="aloc"
				               		 />             		                			
							<script >
								registerCommonTinyMCE();		                		
							</script>													    
                    </div>                           
                    <div class="rightBox">
                    		<h3><s:text name="label.standardFormatMgmt.bookMarkInsert" /></h3>
							<p><s:text name="label.standardFormatMgmt.bookMarkInstruction" /></p>
							<br>
							<div class="span12">
                            <div class="row">
                                <div class="rounded">1</div> <s:text name="label.standardFormatMgmt.bookMarkInstruction1" />
                            </div>
	                        </div>
	                        <div class="span12">
	                            <div class="row">
	                                <div class="rounded">2 </div> <s:text name="label.standardFormatMgmt.bookMarkInstruction2" />
	                            </div>
	                        </div>   
                     										
								<s:if test="%{standardFormatMaster.bookMarkMasterCollection.bookMarkMasters.size >0}"> 							  					
									<s:iterator value="standardFormatMaster.bookMarkMasterCollection.bookMarkMasters" status="bookMarksStatus">																								  																							
										<s:if test="#bookMarksStatus.odd == true">									
											<div class="row">
								        		  <div class="span190">  
												     <a href="javascript:insertLabelTag('<s:property value="bookMarkName"/>')" class="btn btn1 span140"><s:property value="bookMarkName"/></a>
												  </div>											  
						        		</s:if>
						        		<s:else>
						        					<div class="span190 right">
														<a href="javascript:insertLabelTag('<s:property value="bookMarkName"/>')" class="btn btn1 span140"><s:property value="bookMarkName"/></a>
													</div>
												 </div>	
						        		</s:else>						        		
						        		<s:if test="%{#bookMarksStatus.last == true && #bookMarksStatus.odd == true}">
						        			</div>	
						        		</s:if>
									</s:iterator>
								</s:if>							
                    </div>                    
                    <div class="clear"></div>
            </div>
 <!-- geStandardFormat Ends here -->
	<div class="form-mod" id="auditLogDiv">
		<h2 id="auditLog" class=" acc_trigger1 acc_blue section_flip">
			<a href="javascript:;"><s:text name="label.standardFormatMgmt.auditLog" /> - 
					<s:if test="%{standardFormatMaster.formatAuditTrailCollection.formatAuditTrails.size >0}">  
					<s:property value="standardFormatMaster.formatAuditTrailCollection.formatAuditTrails.size"/>
					</s:if>
					<s:else>
					<s:property value="0"/>
					</s:else> 
					</a>
		</h2><hr class="h2-hr">
		<div class="acc_container1" id="auditLogPanel">
			<div class="row">
				<div class="span12">
					<table class="table table-striped sortable table-bordered " id="stdFormatauditLog">
						<thead>	
							<tr>
								<th class="headerSortUp">
									<s:label key="label.standardFormatMgmt.date" cssStyle="color:#FFFFFF;" />
								</th>
								<th>
									<s:label key="label.standardFormatMgmt.action" cssStyle="color:#FFFFFF;" />
								</th>
								<th>
									<s:label key="label.standardFormatMgmt.oldFormat" cssStyle="color:#FFFFFF;" />
								</th>
								<th>
									<s:label key="label.standardFormatMgmt.updateFormat" cssStyle="color:#FFFFFF;" />
								</th>
							</tr> 
						</thead>
						<tbody>
							<s:if test="%{standardFormatMaster.formatAuditTrailCollection.formatAuditTrails == null || standardFormatMaster.formatAuditTrailCollection.formatAuditTrails.isEmpty()}">
								<tr class="shown">
									<td colspan="4" style="text-align: center; color: blue; size: 40px;"><s:text name="label.standardFormatMgmt.display" /></td>
								</tr>
							</s:if>							
							<s:else>								
								<c:if test="${standardFormatMaster.standardFormatInstrumentTypeId eq '1'}">								
									<c:set var="instrumentTypeName" value="BG" /> 
								</c:if>
								<c:if test="${standardFormatMaster.standardFormatInstrumentTypeId eq '2'}">
									<c:set var="instrumentTypeName" value="SBLC" /> 
								</c:if>
								<c:if test="${standardFormatMaster.standardFormatInstrumentTypeId eq '3'}">
									<c:set var="instrumentTypeName" value="SURETY" /> 
								</c:if>
								<c:if test="${standardFormatMaster.standardFormatInstrumentTypeId eq '4'}">
									<c:set var="instrumentTypeName" value="DocLC" /> 
								</c:if>												
								<s:iterator value="standardFormatMaster.formatAuditTrailCollection.formatAuditTrails" status="stat">
								<s:url id="formatAuditTrailFileDownload" action="downloadFormat.action" namespace="/int/admin">
										<s:param name="auditTrailId" value="formatAuditTrailId" />
										<s:param name="typeId" value="standardFormatMaster.standardFormatInstrumentTypeId" />
										<s:param name="standardFormatMaster.standardFormatId" value="formatId" />
										
								  </s:url>											
									<tr class="shown" width="100%">
										<td width="20%"><s:date name="auditModifiedDt" format="MMM dd, yyyy - HH:mm aa zzz"/></td>
										<td width="20%">&#60;<s:property value="lastName" />,&#62; &#60;<s:property value="firstName" />&#62;</td>
										<td  width="30%"> 										
											<s:if test="#stat.first == true">											
												<s:property value="-----" />
											</s:if>
											<s:else> 
											<s:url id="formatAuditTrailOldFileDownload" action="downloadFormat.action"
												namespace="/int/admin">
												<s:param name="auditTrailId" value="oldFormatAuditTrailId" />
												<s:param name="typeId" value="standardFormatMaster.standardFormatInstrumentTypeId" />
												<s:param name="standardFormatMaster.standardFormatId" value="formatId" />												
								  			</s:url>								  			
												&#60;<s:a href="%{formatAuditTrailFileDownload}">OldGE_<c:out value="${instrumentTypeName}"/>_<s:date name="auditModifiedDt" format="MMM dd, yyyy - HH:mm"/>&#62;</s:a>																			
											</s:else>
										</td>
										<td width="30%">
											<s:if test="#stat.first == true">											
												&#60;<s:a href="%{formatAuditTrailFileDownload}">UpdatedGe_<c:out value="${instrumentTypeName}"/>_<s:date name="auditModifiedDt" format="MMM dd, yyyy - HH:mm"/>&#62;</s:a>
											</s:if>
											<s:else>
												<s:a href="%{formatAuditTrailOldFileDownload}">&#60;UpdatedGe_<c:out value="${instrumentTypeName}"/>_<s:date name="oldFormatVal" format="MMM dd, yyyy - HH:mm"/>&#62;</s:a>
											</s:else>
										 </td>
									</tr>																
									<s:set var="oldFormatVal" value="auditModifiedDt" /> 
									<s:set var="oldFormatAuditTrailId" value="formatAuditTrailId" />
								</s:iterator>
							</s:else>
						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>
		<div class="clear"></div>
	        <div class="highlighted" style="margin-left:-2px;padding:5px;">
						<sj:submit key="label.treasuryAdminPortal.save" cssClass="btn-primary"></sj:submit>
						<a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.common.cancel"></s:text></a>                
	        </div>
	    <div class="clear"></div> 
      </div>  	 
      
      </s:form>         
  </div>  	
</body>
 <div class="clear"></div>
		<div class="modal hide fade" id="standardFormatModel">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			 <h3><s:text name="label.standardFormatMgmt.standardFormatHeader"/></h3>		
		</div>
		<div class="modal-body">
			<s:form id="submitStandardFormatMgmtFormId" action="submitStandardFormatManagement" namespace="/int/admin" escapeAmp="false" encode="true" >										
				<p><s:text name="label.standardFormatMgmt.continueWithSaveMessage"/></p>	
			</s:form>			
		</div>				
		 <div class="clear"></div>
		<div class="modal-footer">	
				<sj:submit formIds="submitStandardFormatMgmtFormId" value="continue with save"  cssClass="btn left" />				
				<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.standardFormatMgmt.returnToScreenOptions"/></a>																					                      
		</div>
	</div>
  <div id="footerDiv">
	<%@include file="../common/footerSection.jsp"%>
	<jsp:include page="../admin/treasuryAdminExitPopup.jsp" />
</div>	
</html>