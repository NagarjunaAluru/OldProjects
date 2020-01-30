//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
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
 *         &lt;element name="BankNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Issuing_Bank_Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bank_Reference_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Opt_Out_Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/ALOC/Resources/Schemas/RequestDetails/PreAgreedPricingDetails.xsd}PreAgreedPricingDetails" minOccurs="0"/>
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
    "bankNames",
    "issuingBankBranch",
    "bankReferenceNumber",
    "optOutReason",
    "preAgreedPricingDetails"
})
@XmlRootElement(name = "CompetingBankDetails", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/WinningBankDetails.xsd")
public class CompetingBankDetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "BankNames", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/WinningBankDetails.xsd")
    protected String bankNames;
    @XmlElement(name = "Issuing_Bank_Branch", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/WinningBankDetails.xsd")
    protected String issuingBankBranch;
    @XmlElement(name = "Bank_Reference_Number", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/WinningBankDetails.xsd")
    protected String bankReferenceNumber;
    @XmlElement(name = "Opt_Out_Reason", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/WinningBankDetails.xsd")
    protected String optOutReason;
    @XmlElement(name = "PreAgreedPricingDetails", namespace = "http://www.tibco.com/schemas/ALOC/Resources/Schemas/RequestDetails/PreAgreedPricingDetails.xsd")
    protected PreAgreedPricingDetails preAgreedPricingDetails;

    /**
     * Gets the value of the bankNames property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankNames() {
        return bankNames;
    }

    /**
     * Sets the value of the bankNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankNames(String value) {
        this.bankNames = value;
    }

    /**
     * Gets the value of the issuingBankBranch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuingBankBranch() {
        return issuingBankBranch;
    }

    /**
     * Sets the value of the issuingBankBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuingBankBranch(String value) {
        this.issuingBankBranch = value;
    }

    /**
     * Gets the value of the bankReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankReferenceNumber() {
        return bankReferenceNumber;
    }

    /**
     * Sets the value of the bankReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankReferenceNumber(String value) {
        this.bankReferenceNumber = value;
    }

    /**
     * Gets the value of the optOutReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptOutReason() {
        return optOutReason;
    }

    /**
     * Sets the value of the optOutReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptOutReason(String value) {
        this.optOutReason = value;
    }

    /**
     * Gets the value of the preAgreedPricingDetails property.
     * 
     * @return
     *     possible object is
     *     {@link PreAgreedPricingDetails }
     *     
     */
    public PreAgreedPricingDetails getPreAgreedPricingDetails() {
        return preAgreedPricingDetails;
    }

    /**
     * Sets the value of the preAgreedPricingDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreAgreedPricingDetails }
     *     
     */
    public void setPreAgreedPricingDetails(PreAgreedPricingDetails value) {
        this.preAgreedPricingDetails = value;
    }

    public CompetingBankDetails withBankNames(String value) {
        setBankNames(value);
        return this;
    }

    public CompetingBankDetails withIssuingBankBranch(String value) {
        setIssuingBankBranch(value);
        return this;
    }

    public CompetingBankDetails withBankReferenceNumber(String value) {
        setBankReferenceNumber(value);
        return this;
    }

    public CompetingBankDetails withOptOutReason(String value) {
        setOptOutReason(value);
        return this;
    }

    public CompetingBankDetails withPreAgreedPricingDetails(PreAgreedPricingDetails value) {
        setPreAgreedPricingDetails(value);
        return this;
    }

}