//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.15 at 06:36:30 PM IST 
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
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/MsgHeader.xsd}Msg_Header" minOccurs="0"/>
 *         &lt;element name="Request_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Format_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Format_value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Purpus_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Bond_Type_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Sub_Bond_Type_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
    "msgHeader",
    "requestId",
    "formatName",
    "formatValue",
    "instrumentPurpusId",
    "bondTypeId",
    "subBondTypeId"
})
@XmlRootElement(name = "FormatTemplate", namespace = "http://treasury.ge.com/schemas/ALOC/Resources/Schemas/RequestDetails/FormatTemplate.xsd")
public class FormatTemplate
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Msg_Header", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/MsgHeader.xsd")
    protected MsgHeader msgHeader;
    @XmlElement(name = "Request_Id", namespace = "http://treasury.ge.com/schemas/ALOC/Resources/Schemas/RequestDetails/FormatTemplate.xsd")
    protected String requestId;
    @XmlElement(name = "Format_Name", namespace = "http://treasury.ge.com/schemas/ALOC/Resources/Schemas/RequestDetails/FormatTemplate.xsd")
    protected String formatName;
    @XmlElement(name = "Format_value", namespace = "http://treasury.ge.com/schemas/ALOC/Resources/Schemas/RequestDetails/FormatTemplate.xsd")
    protected String formatValue;
    @XmlElement(name = "Instrument_Purpus_Id", namespace = "http://treasury.ge.com/schemas/ALOC/Resources/Schemas/RequestDetails/FormatTemplate.xsd")
    protected BigInteger instrumentPurpusId;
    @XmlElement(name = "Bond_Type_Id", namespace = "http://treasury.ge.com/schemas/ALOC/Resources/Schemas/RequestDetails/FormatTemplate.xsd")
    protected BigInteger bondTypeId;
    @XmlElement(name = "Sub_Bond_Type_Id", namespace = "http://treasury.ge.com/schemas/ALOC/Resources/Schemas/RequestDetails/FormatTemplate.xsd")
    protected BigInteger subBondTypeId;

    /**
     * Gets the value of the msgHeader property.
     * 
     * @return
     *     possible object is
     *     {@link MsgHeader }
     *     
     */
    public MsgHeader getMsgHeader() {
        return msgHeader;
    }

    /**
     * Sets the value of the msgHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgHeader }
     *     
     */
    public void setMsgHeader(MsgHeader value) {
        this.msgHeader = value;
    }

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the formatName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatName() {
        return formatName;
    }

    /**
     * Sets the value of the formatName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatName(String value) {
        this.formatName = value;
    }

    /**
     * Gets the value of the formatValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatValue() {
        return formatValue;
    }

    /**
     * Sets the value of the formatValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatValue(String value) {
        this.formatValue = value;
    }

    /**
     * Gets the value of the instrumentPurpusId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInstrumentPurpusId() {
        return instrumentPurpusId;
    }

    /**
     * Sets the value of the instrumentPurpusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInstrumentPurpusId(BigInteger value) {
        this.instrumentPurpusId = value;
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

    public FormatTemplate withMsgHeader(MsgHeader value) {
        setMsgHeader(value);
        return this;
    }

    public FormatTemplate withRequestId(String value) {
        setRequestId(value);
        return this;
    }

    public FormatTemplate withFormatName(String value) {
        setFormatName(value);
        return this;
    }

    public FormatTemplate withFormatValue(String value) {
        setFormatValue(value);
        return this;
    }

    public FormatTemplate withInstrumentPurpusId(BigInteger value) {
        setInstrumentPurpusId(value);
        return this;
    }

    public FormatTemplate withBondTypeId(BigInteger value) {
        setBondTypeId(value);
        return this;
    }

    public FormatTemplate withSubBondTypeId(BigInteger value) {
        setSubBondTypeId(value);
        return this;
    }

}