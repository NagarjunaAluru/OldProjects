<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<fmt:setLocale value="en-US"/>
<%	String servletContextUrl = request.getContextPath();%>

<script> var servletContextUrl = '<%=servletContextUrl%>';</script>
		
		<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		
		<jsp:include page="originalViewUsdTransaction.jsp" />
		<jsp:include page="originalViewLenderBorrower.jsp" />
              
        <div class="form-mod">
			<h2 class="span12">Problem Statement</h2>
			<div class="row">
                <div class="span5">
                    <div class="form-row">
                        <span class="required">*</span>
                        <div class="form-row autosize-container1">
                            <label>&nbsp;</label>
                            <div class="char-count" style="margin-left:-10px;">1000</div>
                            <textarea class="xlarge autosize1 messageinput" tabindex="3" rows="1" onblur="scriptInjection(this);">
                            ${day2legSummaryVO.problemStatement}</textarea>
                        </div>
                    </div>
                </div> <!-- end of block -->
            </div>
		</div><!-- end of form form-mod -->
        


		<div class="form-mod">
			<h2 class="span12">Correction Needed</h2>
			<div class="row">
					<div class="span5">
						<div class="form-row ">
							<span class="required">*</span>
                            <div class="form-row autosize-container1">
                                <label>&nbsp;</label>
                                <div class="char-count" style="margin-left:-10px;">1000</div>
                                  <textarea class="xlarge autosize1 messageinput" tabindex="3" rows="1" onblur="scriptInjection(this);">
                                  ${day2legSummaryVO.correctionNeededComments}
                                  </textarea>
	                          </div>
						</div>
					</div> <!-- end of block -->
				</div>
			<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
                            <label>Action Needed By</label>
                            <input type="text" class="span3" disabled="disabled" value="${day2legSummaryVO.actionNeededByDt}"/>
                        	<span class="help-block clear">MM/DD/YYYY</span>	
						</div>
					</div> <!-- end of block -->
				</div>				
		</div><!-- end of form form-mod -->
		
				
				  <!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
			<jsp:param name="legIndex" value="${legNumber}" />
			<jsp:param name="mode" value="edit" />
		</jsp:include>  
		<!-- end uploads -->
	 <a class="btn-link right cancel"  onclick="history.back();">Cancel</a>
