//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 *         &lt;element name="Line_Item_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VAT_Taxes" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Stamp_Taxes" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Incidental" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Other" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="One_Time" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="VAT_Taxes_String" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Stamp_Taxes_String" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Incidental_String" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Other_String" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="One_Time_String" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "lineItemType",
    "vatTaxes",
    "stampTaxes",
    "incidental",
    "other",
    "oneTime",
    "vatTaxesString",
    "stampTaxesString",
    "incidentalString",
    "otherString",
    "oneTimeString"
})
@XmlRootElement(name = "OtherFee", namespace = "http://treasury.ge.com/schemas/ALOC/APM/OtherFee.xsd")
public class OtherFee
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Line_Item_Type", namespace = "http://treasury.ge.com/schemas/ALOC/APM/OtherFee.xsd")
    protected String lineItemType;
    @XmlElement(name = "VAT_Taxes", namespace = "http://treasury.ge.com/schemas/ALOC/APM/OtherFee.xsd")
    protected BigDecimal vatTaxes;
    @XmlElement(name = "Stamp_Taxes", namespace = "http://treasury.ge.com/schemas/ALOC/APM/OtherFee.xsd")
    protected BigDecimal stampTaxes;
    @XmlElement(name = "Incidental", namespace = "http://treasury.ge.com/schemas/ALOC/APM/OtherFee.xsd")
    protected BigDecimal incidental;
    @XmlElement(name = "Other", namespace = "http://treasury.ge.com/schemas/ALOC/APM/OtherFee.xsd")
    protected BigDecimal other;
    @XmlElement(name = "One_Time", namespace = "http://treasury.ge.com/schemas/ALOC/APM/OtherFee.xsd")
    protected BigDecimal oneTime;
    @XmlElement(name = "VAT_Taxes_String", namespace = "http://treasury.ge.com/schemas/ALOC/APM/OtherFee.xsd")
    protected String vatTaxesString;
    @XmlElement(name = "Stamp_Taxes_String", namespace = "http://treasury.ge.com/schemas/ALOC/APM/OtherFee.xsd")
    protected String stampTaxesString;
    @XmlElement(name = "Incidental_String", namespace = "http://treasury.ge.com/schemas/ALOC/APM/OtherFee.xsd")
    protected String incidentalString;
    @XmlElement(name = "Other_String", namespace = "http://treasury.ge.com/schemas/ALOC/APM/OtherFee.xsd")
    protected String otherString;
    @XmlElement(name = "One_Time_String", namespace = "http://treasury.ge.com/schemas/ALOC/APM/OtherFee.xsd")
    protected String oneTimeString;

    /**
     * Gets the value of the lineItemType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineItemType() {
        return lineItemType;
    }

    /**
     * Sets the value of the lineItemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineItemType(String value) {
        this.lineItemType = value;
    }

    /**
     * Gets the value of the vatTaxes property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVATTaxes() {
        return vatTaxes;
    }

    /**
     * Sets the value of the vatTaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVATTaxes(BigDecimal value) {
        this.vatTaxes = value;
    }

    /**
     * Gets the value of the stampTaxes property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStampTaxes() {
        return stampTaxes;
    }

    /**
     * Sets the value of the stampTaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStampTaxes(BigDecimal value) {
        this.stampTaxes = value;
    }

    /**
     * Gets the value of the incidental property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIncidental() {
        return incidental;
    }

    /**
     * Sets the value of the incidental property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIncidental(BigDecimal value) {
        this.incidental = value;
    }

    /**
     * Gets the value of the other property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOther() {
        return other;
    }

    /**
     * Sets the value of the other property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOther(BigDecimal value) {
        this.other = value;
    }

    /**
     * Gets the value of the oneTime property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOneTime() {
        return oneTime;
    }

    /**
     * Sets the value of the oneTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOneTime(BigDecimal value) {
        this.oneTime = value;
    }

    /**
     * Gets the value of the vatTaxesString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVATTaxesString() {
        return vatTaxesString;
    }

    /**
     * Sets the value of the vatTaxesString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVATTaxesString(String value) {
        this.vatTaxesString = value;
    }

    /**
     * Gets the value of the stampTaxesString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStampTaxesString() {
        return stampTaxesString;
    }

    /**
     * Sets the value of the stampTaxesString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStampTaxesString(String value) {
        this.stampTaxesString = value;
    }

    /**
     * Gets the value of the incidentalString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncidentalString() {
        return incidentalString;
    }

    /**
     * Sets the value of the incidentalString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncidentalString(String value) {
        this.incidentalString = value;
    }

    /**
     * Gets the value of the otherString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherString() {
        return otherString;
    }

    /**
     * Sets the value of the otherString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherString(String value) {
        this.otherString = value;
    }

    /**
     * Gets the value of the oneTimeString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOneTimeString() {
        return oneTimeString;
    }

    /**
     * Sets the value of the oneTimeString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOneTimeString(String value) {
        this.oneTimeString = value;
    }

    public OtherFee withLineItemType(String value) {
        setLineItemType(value);
        return this;
    }

    public OtherFee withVATTaxes(BigDecimal value) {
        setVATTaxes(value);
        return this;
    }

    public OtherFee withStampTaxes(BigDecimal value) {
        setStampTaxes(value);
        return this;
    }

    public OtherFee withIncidental(BigDecimal value) {
        setIncidental(value);
        return this;
    }

    public OtherFee withOther(BigDecimal value) {
        setOther(value);
        return this;
    }

    public OtherFee withOneTime(BigDecimal value) {
        setOneTime(value);
        return this;
    }

    public OtherFee withVATTaxesString(String value) {
        setVATTaxesString(value);
        return this;
    }

    public OtherFee withStampTaxesString(String value) {
        setStampTaxesString(value);
        return this;
    }

    public OtherFee withIncidentalString(String value) {
        setIncidentalString(value);
        return this;
    }

    public OtherFee withOtherString(String value) {
        setOtherString(value);
        return this;
    }

    public OtherFee withOneTimeString(String value) {
        setOneTimeString(value);
        return this;
    }

}
