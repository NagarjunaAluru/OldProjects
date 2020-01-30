<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/js/requestor/apm.js" type="text/javascript"></script>
                    <span class="FXRate-error hide" style="color: #AE2C2C;"></span>
                      <div class="row apmErrorDiv hide">
							<div class="span12">
								<div class="errorbox">
									<div class="errorHead"><p class="erroricon">Error</p></div>
										<div class="errorContent">
										<p><span class="curApmError"></span></p>
										</div>
								</div>
							</div>
						</div>
                   <s:label key="label.request.narrowPaymentPeriod" />
                  
	            <div class="row">
					
					<div class="span2">
					        <s:textfield name="fromyear" id="fxrateFromyear" cssClass="dateyearOnly"/>
                     </div> 
                     <div class="span1cd">
					      TO 
                     </div> 
                     <div class="span2">
                            <s:textfield name="toyear" id="fxrateToyear" cssClass="dateyearOnly"/>         
                      </div>
                      <div class="span1">
					      <img alt="Loading..." id="periodProcessImgOne" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
                     </div>
                      
				</div>
				<div class="row">
					 <div id="includeFxPeriod" class="span5">
					    <jsp:include page="/jsp/common/request/apm/fxRateperiodSelect.jsp" />
					</div>
				</div>
				
				<div id="includeFxRate" class="row"></div>  
				
				