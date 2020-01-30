<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="stage" required="true" rtexprvalue="true" %>

<c:choose>
<c:when test="${stage eq 'SOCASHMG'}">cashManagement/cashManagement</c:when>
<c:when test="${stage eq 'SOTRESTX'}">treasuryTax/treasuryTax</c:when>
<c:when test="${stage eq 'SOCOUNTX'}">countryTax/countryTax</c:when>
<c:when test="${stage eq 'SOTLEGAL'}">treasuryLegal/treasuryLegal</c:when>
<c:when test="${stage eq 'SOTPRICE'}">transferPricing/transferPricing</c:when>
<c:when test="${stage eq 'SOMIDOFF'}">middleOffice/middleOffice</c:when>
<c:when test="${stage eq 'SOFRTOFF'}">frontoffice/fourBlocker</c:when>
<c:when test="${stage eq 'FOOFFICE'}">frontoffice/fourBlocker</c:when>
<c:when test="${stage eq 'RISKREVW'}">riskUnderwriting/riskUnderwriting</c:when>
<c:when test="${stage eq 'IDAGEAG'}">idagEag/idagEag</c:when>
<c:when test="${stage eq 'IDAGREVW'}">idagEag/idagEag</c:when>
<c:when test="${stage eq 'TESGREVW'}">tesg/tesg</c:when>
<c:when test="${stage eq 'CERTFYFO'}">transactionCapture/transactionCaptureFOCMFourBlocker</c:when>
<c:when test="${stage eq 'CERTFYCM'}">transactionCapture/transactionCaptureFOCMFourBlocker</c:when>
<c:when test="${stage eq 'TCCERTIFY'}">transactionCapture/transactionCaptureFOCMFourBlocker</c:when>
<c:when test="${stage eq 'ADDAPPRV'}">transactionCapture/transactionCaptureARFourBlocker</c:when>
<c:when test="${stage eq 'APPOVEFO'}">transactionCapture/transactionCaptureManagerFourBlocker</c:when>
<c:when test="${stage eq 'APPOVECM'}">transactionCapture/transactionCaptureManagerFourBlocker</c:when>
<c:when test="${stage eq 'CLOSEREQ'}">transactionCapture/transactionCaptureMOFourBlocker</c:when>
<c:when test="${stage eq 'REREQUST'}">fundingRequest/newFundingRequest</c:when>
<c:when test="${stage eq 'BUASIA'}">equityBusinessCFO</c:when>
<c:when test="${stage eq 'BUCLLAME'}">equityBusinessCFO</c:when>
<c:when test="${stage eq 'BUCAPHQO'}">equityBusinessCFO</c:when>
<c:when test="${stage eq 'BUCOMMRE'}">equityBusinessCFO</c:when>
<c:when test="${stage eq 'BUEMEA'}">equityBusinessCFO</c:when>
<c:when test="${stage eq 'BURETFIN'}">equityBusinessCFO</c:when>
<c:when test="${stage eq 'BURESOP'}">equityBusinessCFO</c:when>
<c:when test="${stage eq 'BUGECAS'}">equityBusinessCFO</c:when>
<c:when test="${stage eq 'BUEMRG'}">equityBusinessCFO</c:when>
<c:when test="${stage eq 'BUTREAS'}">equityBusinessCFO</c:when>
<c:when test="${stage eq 'BUEFS'}">equityBusinessCFO</c:when>
<c:when test="${stage eq 'BAASIA'}">equityBusinessApprover</c:when>
<c:when test="${stage eq 'BACAPHQO'}">equityBusinessApprover</c:when>
<c:when test="${stage eq 'BACLLAME'}">equityBusinessApprover</c:when>
<c:when test="${stage eq 'BACOMMRE'}">equityBusinessApprover</c:when>
<c:when test="${stage eq 'BAEFS'}">equityBusinessApprover</c:when>
<c:when test="${stage eq 'BAEMEA'}">equityBusinessApprover</c:when>
<c:when test="${stage eq 'BAEMRG'}">equityBusinessApprover</c:when>
<c:when test="${stage eq 'BAGECAS'}">equityBusinessApprover</c:when>
<c:when test="${stage eq 'BARESOP'}">equityBusinessApprover</c:when>
<c:when test="${stage eq 'BARETFIN'}">equityBusinessApprover</c:when>
<c:when test="${stage eq 'BATREAS'}">equityBusinessApprover</c:when>
<c:when test="${stage eq 'PLERIVEW'}">pipelineReview/pipelineReviewDeal</c:when>
</c:choose>