//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.hydus.hwf.security.JAXBObjectSecureSerializer;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reimbursement_Agreement_id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Reimbursement_Agreement_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Agreement_Enabled_Disabled" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Agreement_Text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Deafult_Agreement" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Deafult_Agreement_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "reimbursementAgreementId",
    "reimbursementAgreementName",
    "agreementEnabledDisabled",
    "agreementText",
    "deafultAgreement",
    "deafultAgreementType"
})
@XmlRootElement(name = "ReimbursementAgreement", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/Reimbursement.xsd")
public class ReimbursementAgreement
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Reimbursement_Agreement_id", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/Reimbursement.xsd")
    protected BigInteger reimbursementAgreementId;
    @XmlElement(name = "Reimbursement_Agreement_Name", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/Reimbursement.xsd")
    protected String reimbursementAgreementName;
    @XmlElement(name = "Agreement_Enabled_Disabled", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/Reimbursement.xsd")
    protected String agreementEnabledDisabled;
    @XmlElement(name = "Agreement_Text", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/Reimbursement.xsd")
    protected String agreementText;
    @XmlElement(name = "Deafult_Agreement", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/Reimbursement.xsd")
    protected Boolean deafultAgreement;
    @XmlElement(name = "Deafult_Agreement_Type", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/Reimbursement.xsd")
    protected String deafultAgreementType;

    /**
     * Gets the value of the reimbursementAgreementId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getReimbursementAgreementId() {
        return reimbursementAgreementId;
    }

    /**
     * Sets the value of the reimbursementAgreementId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setReimbursementAgreementId(BigInteger value) {
        this.reimbursementAgreementId = value;
    }

    /**
     * Gets the value of the reimbursementAgreementName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReimbursementAgreementName() {
        return reimbursementAgreementName;
    }

    /**
     * Sets the value of the reimbursementAgreementName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReimbursementAgreementName(String value) {
        this.reimbursementAgreementName = value;
    }

    /**
     * Gets the value of the agreementEnabledDisabled property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgreementEnabledDisabled() {
        return agreementEnabledDisabled;
    }

    /**
     * Sets the value of the agreementEnabledDisabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgreementEnabledDisabled(String value) {
        this.agreementEnabledDisabled = value;
    }

    /**
     * Gets the value of the agreementText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgreementText() {
        return agreementText;
    }

    /**
     * Sets the value of the agreementText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgreementText(String value) {
        this.agreementText = value;
    }

    /**
     * Gets the value of the deafultAgreement property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeafultAgreement() {
        return deafultAgreement;
    }

    /**
     * Sets the value of the deafultAgreement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeafultAgreement(Boolean value) {
        this.deafultAgreement = value;
    }

    /**
     * Gets the value of the deafultAgreementType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeafultAgreementType() {
        return deafultAgreementType;
    }

    /**
     * Sets the value of the deafultAgreementType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeafultAgreementType(String value) {
        this.deafultAgreementType = value;
    }

    public ReimbursementAgreement withReimbursementAgreementId(BigInteger value) {
        setReimbursementAgreementId(value);
        return this;
    }

    public ReimbursementAgreement withReimbursementAgreementName(String value) {
        setReimbursementAgreementName(value);
        return this;
    }

    public ReimbursementAgreement withAgreementEnabledDisabled(String value) {
        setAgreementEnabledDisabled(value);
        return this;
    }

    public ReimbursementAgreement withAgreementText(String value) {
        setAgreementText(value);
        return this;
    }

    public ReimbursementAgreement withDeafultAgreement(Boolean value) {
        setDeafultAgreement(value);
        return this;
    }

    public ReimbursementAgreement withDeafultAgreementType(String value) {
        setDeafultAgreementType(value);
        return this;
    }

}
