/**
 * 
 */
package com.ge.aloc;

/**
 * @author arijit.biswas
 *
 */
public enum CloseTransactionOptionEnum {
	ISSUERREFERENCENUMBER("issuerReferenceNumber"),
	BONDREFERENCENUMBER("bondReferenceNumber"),
	BANKREFERENCENUMBER("bankReferenceNumber"),
	ALOCRECNO("alocRecNo");

	/**
	 * This method returns CloseTransactionOption based on name.
	 * 
	 * @param name
	 * @return
	 */
	public static CloseTransactionOptionEnum fromName(String name){
		for(CloseTransactionOptionEnum closeTransactionOptionEnum : values()){
			if(closeTransactionOptionEnum.getName().equalsIgnoreCase(name)){
				return closeTransactionOptionEnum;
			}
		}
		return null;
	}
	/**
	 * 
	 */
	private String name;

	/**
	 * constructor to create instance object.
	 * @param name
	 */
	private CloseTransactionOptionEnum(String name) {
		this.setName(name);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
