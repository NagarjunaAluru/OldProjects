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
 *         &lt;element name="Op_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="US_Issuance_Flag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Credit_Issuance_Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Credit_Issuance_Country_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Credit_req_Cnfm_Flag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Credit_Cnfm_Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Credit_Cnfm_Country_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Credit_Req_Advise_Flag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Credit_Advise_Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Credit_Advise_Country_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Requires_Edits" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Send_Back_Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "opCode",
    "usIssuanceFlag",
    "creditIssuanceCountry",
    "creditIssuanceCountryId",
    "creditReqCnfmFlag",
    "creditCnfmCountry",
    "creditCnfmCountryId",
    "creditReqAdviseFlag",
    "creditAdviseCountry",
    "creditAdviseCountryId",
    "requiresEdits",
    "sendBackNotes"
})
@XmlRootElement(name = "SBLC")
public class SBLC
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Op_Code")
    protected String opCode;
    @XmlElement(name = "US_Issuance_Flag")
    protected Boolean usIssuanceFlag;
    @XmlElement(name = "Credit_Issuance_Country")
    protected String creditIssuanceCountry;
    @XmlElement(name = "Credit_Issuance_Country_Id")
    protected String creditIssuanceCountryId;
    @XmlElement(name = "Credit_req_Cnfm_Flag")
    protected Boolean creditReqCnfmFlag;
    @XmlElement(name = "Credit_Cnfm_Country")
    protected String creditCnfmCountry;
    @XmlElement(name = "Credit_Cnfm_Country_Id")
    protected String creditCnfmCountryId;
    @XmlElement(name = "Credit_Req_Advise_Flag")
    protected Boolean creditReqAdviseFlag;
    @XmlElement(name = "Credit_Advise_Country")
    protected String creditAdviseCountry;
    @XmlElement(name = "Credit_Advise_Country_Id")
    protected String creditAdviseCountryId;
    @XmlElement(name = "Requires_Edits")
    protected Boolean requiresEdits;
    @XmlElement(name = "Send_Back_Notes")
    protected String sendBackNotes;

    /**
     * Gets the value of the opCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpCode() {
        return opCode;
    }

    /**
     * Sets the value of the opCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpCode(String value) {
        this.opCode = value;
    }

    /**
     * Gets the value of the usIssuanceFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUSIssuanceFlag() {
        return usIssuanceFlag;
    }

    /**
     * Sets the value of the usIssuanceFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUSIssuanceFlag(Boolean value) {
        this.usIssuanceFlag = value;
    }

    /**
     * Gets the value of the creditIssuanceCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditIssuanceCountry() {
        return creditIssuanceCountry;
    }

    /**
     * Sets the value of the creditIssuanceCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditIssuanceCountry(String value) {
        this.creditIssuanceCountry = value;
    }

    /**
     * Gets the value of the creditIssuanceCountryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditIssuanceCountryId() {
        return creditIssuanceCountryId;
    }

    /**
     * Sets the value of the creditIssuanceCountryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditIssuanceCountryId(String value) {
        this.creditIssuanceCountryId = value;
    }

    /**
     * Gets the value of the creditReqCnfmFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCreditReqCnfmFlag() {
        return creditReqCnfmFlag;
    }

    /**
     * Sets the value of the creditReqCnfmFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCreditReqCnfmFlag(Boolean value) {
        this.creditReqCnfmFlag = value;
    }

    /**
     * Gets the value of the creditCnfmCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCnfmCountry() {
        return creditCnfmCountry;
    }

    /**
     * Sets the value of the creditCnfmCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCnfmCountry(String value) {
        this.creditCnfmCountry = value;
    }

    /**
     * Gets the value of the creditCnfmCountryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCnfmCountryId() {
        return creditCnfmCountryId;
    }

    /**
     * Sets the value of the creditCnfmCountryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCnfmCountryId(String value) {
        this.creditCnfmCountryId = value;
    }

    /**
     * Gets the value of the creditReqAdviseFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCreditReqAdviseFlag() {
        return creditReqAdviseFlag;
    }

    /**
     * Sets the value of the creditReqAdviseFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCreditReqAdviseFlag(Boolean value) {
        this.creditReqAdviseFlag = value;
    }

    /**
     * Gets the value of the creditAdviseCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditAdviseCountry() {
        return creditAdviseCountry;
    }

    /**
     * Sets the value of the creditAdviseCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditAdviseCountry(String value) {
        this.creditAdviseCountry = value;
    }

    /**
     * Gets the value of the creditAdviseCountryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditAdviseCountryId() {
        return creditAdviseCountryId;
    }

    /**
     * Sets the value of the creditAdviseCountryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditAdviseCountryId(String value) {
        this.creditAdviseCountryId = value;
    }

    /**
     * Gets the value of the requiresEdits property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequiresEdits() {
        return requiresEdits;
    }

    /**
     * Sets the value of the requiresEdits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequiresEdits(Boolean value) {
        this.requiresEdits = value;
    }

    /**
     * Gets the value of the sendBackNotes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendBackNotes() {
        return sendBackNotes;
    }

    /**
     * Sets the value of the sendBackNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendBackNotes(String value) {
        this.sendBackNotes = value;
    }

    public SBLC withOpCode(String value) {
        setOpCode(value);
        return this;
    }

    public SBLC withUSIssuanceFlag(Boolean value) {
        setUSIssuanceFlag(value);
        return this;
    }

    public SBLC withCreditIssuanceCountry(String value) {
        setCreditIssuanceCountry(value);
        return this;
    }

    public SBLC withCreditIssuanceCountryId(String value) {
        setCreditIssuanceCountryId(value);
        return this;
    }

    public SBLC withCreditReqCnfmFlag(Boolean value) {
        setCreditReqCnfmFlag(value);
        return this;
    }

    public SBLC withCreditCnfmCountry(String value) {
        setCreditCnfmCountry(value);
        return this;
    }

    public SBLC withCreditCnfmCountryId(String value) {
        setCreditCnfmCountryId(value);
        return this;
    }

    public SBLC withCreditReqAdviseFlag(Boolean value) {
        setCreditReqAdviseFlag(value);
        return this;
    }

    public SBLC withCreditAdviseCountry(String value) {
        setCreditAdviseCountry(value);
        return this;
    }

    public SBLC withCreditAdviseCountryId(String value) {
        setCreditAdviseCountryId(value);
        return this;
    }

    public SBLC withRequiresEdits(Boolean value) {
        setRequiresEdits(value);
        return this;
    }

    public SBLC withSendBackNotes(String value) {
        setSendBackNotes(value);
        return this;
    }

}