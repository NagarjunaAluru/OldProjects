 <%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common/>
 
 <div class="form-mod">
			<h2 class="span12">Project Summary</h2>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b>Transaction owner</b><br>
							<bean:write name="dealRequestForm" property="transOwnerSsoId"/></p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right highlighted">
				<div class="form-row"></br></br>
				</div>
				</div>
			</div>
			<div class="row ">
				<div class="span5">
					<div class="form-row">
						<p><b>Deal ID</b><br>
						<bean:write name="dealRequestForm" property="uniqueId" /></p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>Deal name</b><br>
						<bean:write name="dealRequestForm" property="dealName" /></p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b>Deal rationale</b><br>
							<bean:write name="dealRequestForm" property="dealRationale" /></p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>Deal Category</b><br>
						<bean:write name="dealRequestForm" property="dealCategory" /></p>
					</div>
				</div><!-- end of block -->
			</div>
        </div>