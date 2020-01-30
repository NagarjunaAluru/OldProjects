<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<div class="display-row">
			<h2 class="span12">Participant</h2>
            <div class="clear"></div>
			<div class="row highlighted">        		
                <div class="span5">
                    <div class="form-row">
                        <p><b>CDR code</b></p>
                        <p>${CPALegSummary.participant.CDRCd}</p>
                    </div>
                </div><!-- end of block -->
                <div class="span5 right">
                    <div class="form-row">
                        <p><b>Legal Entity GOLD ID</b></p>
                        <p>${CPALegSummary.participant.LEGoldId}</p>
                    </div>
                </div><!-- end of block -->
            </div>
            <div class="row">
                <div class="span5">
                    <div class="form-row">
                        <p><b>Legal Entity name</b></p>
                        <p>${CPALegSummary.participant.LEName}</p>
                    </div>
                </div><!-- end of block -->
                <div class="span5 right">
                    <div class="form-row">
                        <p><b>Country</b></p>
                        <p>${CPALegSummary.participant.country}</p>
                    </div>
                </div><!-- end of block -->
            </div>
            <div class="row highlighted">
                <div class="span5">
                    <div class="form-row">
                        <p><b>Is Participant a regulated Entity?</b></p>
                        <p>${CPALegSummary.participantRegulatedEntity}</p>
                    </div>
                </div><!-- end of block -->
                <div class="span5 right">
                    <div class="form-row">
                        <p><b>Is Participant a principal Entity?</b></p>
                        <p>${CPALegSummary.participantPrincipalEntity}</p>
                    </div>
                </div><!-- end of block -->
            </div>

            <div class="row">
                <div class="span5">
                    <div class="form-row">
                        <p><b>Management Entity</b></p>
                        <p>${CPALegSummary.participant.MEName}</p>
                    </div>
                </div><!-- end of block -->
                <div class="span5 right">
                    <div class="form-row">
                        <p><b>Capital or Industrial</b></p>
                        <p>${CPALegSummary.participant.capitalIndustrial}</p>
                    </div>
                </div><!-- end of block -->
            </div>

            <div class="row highlighted">
                <div class="span5">
                    <div class="form-row">
                        <p><b>Treasury Code</b></p>
                        <p><c:if test="${empty CPALegSummary.participant.treasuryCode}">
						--
					</c:if>
					<c:if test="${not empty CPALegSummary.participant.treasuryCode}">
						${CPALegSummary.participant.treasuryCode}
					</c:if></p>
                    </div>
                </div><!-- end of block -->
                <div class="span5 right">
                    <div class="form-row">
                        <p><b>Business Segment</b></p>
                        <p><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.businessSegment" /></p>
                    </div>
                </div><!-- end of block -->
            </div>
            
            <div class="row">
                <div class="span5">
                    <div class="form-row">
                        <p><b>Fund Co./Hold Co./Op Co.</b></p>
                        <p><bean:write name="cpaLegRequestForm" property="cpaSummary.participantEntity.fundHoldOperationId" /></p>
                    </div>
                </div><!-- end of block -->
            </div>            


		</div><!-- display role ends here -->