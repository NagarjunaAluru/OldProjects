<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>

<h2 class="span12">Payer</h2>
<div class="clear"></div>
<div class="row highlighted">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>CDR code</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.CDRCd">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.CDRCd">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.lenderEntity.CDRCd" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p>
				<b>Legal Entity GOLD ID</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.LEGoldId">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.LEGoldId">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.lenderEntity.LEGoldId" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>
<div class="row">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>Legal Entity name</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.LEName">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.LEName">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.lenderEntity.LEName" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p>
				<b>Country</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.country">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.country">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.lenderEntity.country" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>
<div class="row highlighted">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>Is Payer a regulated Entity?</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.regulatedEntityFlag">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.regulatedEntityFlag">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.lenderEntity.regulatedEntityFlag" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p>
				<b>Is Payer a principal Entity?</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.princplEntityFlag">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.princplEntityFlag">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.lenderEntity.princplEntityFlag" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>

<div class="row">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>Management Entity</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.MEName">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.MEName">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.lenderEntity.MEName" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p>
				<b>Capital or Industrial</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.capitalIndustrial">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.capitalIndustrial">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.lenderEntity.capitalIndustrial" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>

<div class="row highlighted">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>Treasury Code</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.lenderTCodeEntity.treasuryCode">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.lenderTCodeEntity.treasuryCode">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.lenderTCodeEntity.treasuryCode" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p>
				<b>Business Segment</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.businessSegment">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.businessSegment">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.lenderEntity.businessSegment" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>

<div class="row">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>Fund Co./Hold Co./Op Co.</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.fundHoldOperationId">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.lenderEntity.fundHoldOperationId">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.lenderEntity.fundHoldOperationId" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>


<h2 class="span12">Receiver</h2>
<div class="clear"></div>
<div class="row highlighted">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>CDR code</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.CDRCd">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.CDRCd">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.borrowerEntity.CDRCd" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p>
				<b>Legal Entity GOLD ID</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.LEGoldId">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.LEGoldId">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.borrowerEntity.LEGoldId" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>
<div class="row">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>Legal Entity name</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.LEName">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.LEName">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.borrowerEntity.LEName" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p>
				<b>Country</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.country">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.country">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.borrowerEntity.country" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>
<div class="row highlighted">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>Is Receiver a regulated Entity?</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.regulatedEntityFlag">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.regulatedEntityFlag">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.borrowerEntity.regulatedEntityFlag" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p>
				<b>Is Receiver a principal Entity?</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.princplEntityFlag">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.princplEntityFlag">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.borrowerEntity.princplEntityFlag" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>

<div class="row">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>Management Entity</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.MEName">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.MEName">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.borrowerEntity.MEName" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p>
				<b>Capital or Industrial</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.capitalIndustrial">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.capitalIndustrial">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.borrowerEntity.capitalIndustrial" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>

<div class="row highlighted">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>Treasury Code</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.borrowerTCodeEntity.treasuryCode">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.borrowerTCodeEntity.treasuryCode">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.borrowerTCodeEntity.treasuryCode" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
	<div class="span5 right">
		<div class="form-row">
			<p>
				<b>Business Segment</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.businessSegment">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.businessSegment">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.borrowerEntity.businessSegment" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>

<div class="row">
	<div class="span5">
		<div class="form-row">
			<p>
				<b>Fund Co./Hold Co./Op Co.</b>
			</p>
			<logic:empty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.fundHoldOperationId">
				<p>-</p>
			</logic:empty>
			<logic:notEmpty name="ICFPLegRequestForm"
				property="legSummary.borrowerEntity.fundHoldOperationId">
				<p>
					<bean:write name="ICFPLegRequestForm"
						property="legSummary.borrowerEntity.fundHoldOperationId" />
				</p>
			</logic:notEmpty>
		</div>
	</div>
	<!-- end of block -->
</div>

