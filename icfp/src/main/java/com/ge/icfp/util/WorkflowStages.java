package com.ge.icfp.util;

public enum WorkflowStages {
	INITIATION(0, "Request Created"),
	PLERIVEW(1, "Pipeline Review"),
	RISKREVW(3, "Risk Review"),
	REVIEW(4, "BU_TAX,BU_CFO"),
	IDAGREVW(5, "IDAG"),
	IDAGEAG(6, "IDAG Lead"),
	TESGREVW(7, "TESG"),
	EBODREVW(8, " eBoard Room"),
	ADDAPPRV(10, "Additional Approvers"),
	SOFRTOFF(13, "S&U_Front Office"),
	SOMIDOFF(14, "S&U_Middle Office"),
	SOCASHMG(15, "S&U_Cash Management"),
	SOTPRICE(16, "S&U_Transfer Pricing"),
	SOTLEGAL(17, "S&U_Treasury Legal"),
	SOTRESTX(18, "S&U_Treasury Tax"),
	SOCOUNTX(19, "S&U_Jurisdictional/Regulatory Tax"),
	EXPAPPLI(20, "Transfer Pricing Expired"),
	CERTFYFO(21, "TC_Front Office"),
	CERTFYCM(22, "TC_Cash Management"),
	APPOVEFO(23, "OverideApproval_Front Office"),
	APPOVECM(24, "OverrideApproval_Cash Mangement"),
	CLOSEREQ(25, "TC_Middle Office"),
	Requester(26, "Requestor"),
	FOOFFICE(27, "S&U_Front Office"),
	REREQUST(28, "Requestor"),
	BUASIA(29, "BizCFO_Asia"),
	BUCLLAME(30, "BizCFO_CLL Americas"),
	BUCAPHQO(31, "BizCFO_Capital HQ/Other"),
	BUCOMMRE(32, "BizCFO_Commercial Real Estate"),
	BUEMEA(33, "BizCFO_EMEA"),
	BURETFIN(34, "BizCFO_Retail Finance"),
	BURESOP(35, "BizCFO_Restructure Op."),
	BUGECAS(36, "BizCFO_GECAS"),
	BUEMRG(37, "BizCFO_EMRG"),
	BUTREAS(38, "BizCFO_Treasury"),
	BUEFS(39, "BizCFO_EFS"),
	BAASIA(40, "BizApprover_Asia"),
	BACAPHQO(41, "BizApprover_Capital HQ/Other"),
	BACLLAME(42, "BizApprover_CLL Americas"),
	BACOMMRE(43, "BizApprover_Commercial Real Estate"),
	BAEFS(44, "BizApprover_EFS"),
	BAEMEA(45, "BizApprover_EMEA"),
	BAEMRG(46, "BizApprover_EMRG"),
	BAGECAS(47, "BizApprover_GECAS"),
	BARESOP(48, "BizApprover_Restructure Op."),
	BARETFIN(49, "BizApprover_Retail Finance"),
	BATREAS(50, "BizApprover_Treasury");
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static WorkflowStages fromId(int id) {
		for(WorkflowStages workflowStage: values()) {
			if(workflowStage.getId() == id) {
				return workflowStage;
			}
		}
		return null;
	}
	
	
	private int id;
	private String description;
	
	private WorkflowStages(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
}
	
	/*IDAG_Lead(6, "IDAG Lead"),
	TESG(7, "TESG Esclation"),
        TC_MO(25, "CLOSEREQ");
	
	private int id;
	
	private String name = null;
	
	private WorkflowStages(int id, String nameStr){
		this.id = id;
		this.name = nameStr;
	}
	
	public int getID(){
		return this.id;
	}
	
	
}*/
