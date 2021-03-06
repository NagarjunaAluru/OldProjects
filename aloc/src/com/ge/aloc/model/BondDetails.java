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
 *         &lt;element name="Op_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bond_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bond_Type_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Sub_Bond_Type_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Bond_Sub_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "bondType",
    "bondTypeId",
    "subBondTypeId",
    "bondSubType",
    "comments",
    "requiresEdits",
    "sendBackNotes"
})
@XmlRootElement(name = "BondDetails", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BondDetails.xsd")
public class BondDetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Op_Code", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BondDetails.xsd")
    protected String opCode;
    @XmlElement(name = "Bond_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BondDetails.xsd")
    protected String bondType;
    @XmlElement(name = "Bond_Type_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BondDetails.xsd")
    protected BigInteger bondTypeId;
    @XmlElement(name = "Sub_Bond_Type_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BondDetails.xsd")
    protected BigInteger subBondTypeId;
    @XmlElement(name = "Bond_Sub_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BondDetails.xsd")
    protected String bondSubType;
    @XmlElement(name = "Comments", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BondDetails.xsd")
    protected String comments;
    @XmlElement(name = "Requires_Edits", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BondDetails.xsd")
    protected Boolean requiresEdits;
    @XmlElement(name = "Send_Back_Notes", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BondDetails.xsd")
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
     * Gets the value of the bondType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBondType() {
        return bondType;
    }

    /**
     * Sets the value of the bondType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBondType(String value) {
        this.bondType = value;
    }

    /**
     * Gets the value of the bondTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBondTypeId() {
        return bondTypeId;
    }

    /**
     * Sets the value of the bondTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBondTypeId(BigInteger value) {
        this.bondTypeId = value;
    }

    /**
     * Gets the value of the subBondTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSubBondTypeId() {
        return subBondTypeId;
    }

    /**
     * Sets the value of the subBondTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSubBondTypeId(BigInteger value) {
        this.subBondTypeId = value;
    }

    /**
     * Gets the value of the bondSubType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBondSubType() {
        return bondSubType;
    }

    /**
     * Sets the value of the bondSubType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBondSubType(String value) {
        this.bondSubType = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
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

    public BondDetails withOpCode(String value) {
        setOpCode(value);
        return this;
    }

    public BondDetails withBondType(String value) {
        setBondType(value);
        return this;
    }

    public BondDetails withBondTypeId(BigInteger value) {
        setBondTypeId(value);
        return this;
    }

    public BondDetails withSubBondTypeId(BigInteger value) {
        setSubBondTypeId(value);
        return this;
    }

    public BondDetails withBondSubType(String value) {
        setBondSubType(value);
        return this;
    }

    public BondDetails withComments(String value) {
        setComments(value);
        return this;
    }

    public BondDetails withRequiresEdits(Boolean value) {
        setRequiresEdits(value);
        return this;
    }

    public BondDetails withSendBackNotes(String value) {
        setSendBackNotes(value);
        return this;
    }

}
