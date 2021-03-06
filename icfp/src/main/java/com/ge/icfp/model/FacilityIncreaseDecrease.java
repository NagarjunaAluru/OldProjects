//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.08 at 07:56:29 PM IST 
//


package com.ge.icfp.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.hydus.wff.core.security.JAXBObjectSecureSerializer;


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
 *         &lt;element name="Facility_Type_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Facility_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Currency_Facility_Amt" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Currency_USD_Equivalent_Amt" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Amended_Facility_Amt" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Amended_USD_Equivalent_Amt" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Facility_Inc_Dec_Amt" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Facility_Inc_Dec_USD_Equivalent_Amt" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
    "facilityTypeId",
    "facilityType",
    "currencyFacilityAmt",
    "currencyUSDEquivalentAmt",
    "amendedFacilityAmt",
    "amendedUSDEquivalentAmt",
    "facilityIncDecAmt",
    "facilityIncDecUSDEquivalentAmt"
})
@XmlRootElement(name = "Facility_Increase_Decrease", namespace = "http://treasury.ge.com/schemas/ICFP/FacilityIncreaseDecrease.xsd")
public class FacilityIncreaseDecrease
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Facility_Type_Id", namespace = "http://treasury.ge.com/schemas/ICFP/FacilityIncreaseDecrease.xsd")
    protected Integer facilityTypeId;
    @XmlElement(name = "Facility_Type", namespace = "http://treasury.ge.com/schemas/ICFP/FacilityIncreaseDecrease.xsd")
    protected String facilityType;
    @XmlElement(name = "Currency_Facility_Amt", namespace = "http://treasury.ge.com/schemas/ICFP/FacilityIncreaseDecrease.xsd")
    protected Double currencyFacilityAmt;
    @XmlElement(name = "Currency_USD_Equivalent_Amt", namespace = "http://treasury.ge.com/schemas/ICFP/FacilityIncreaseDecrease.xsd")
    protected Double currencyUSDEquivalentAmt;
    @XmlElement(name = "Amended_Facility_Amt", namespace = "http://treasury.ge.com/schemas/ICFP/FacilityIncreaseDecrease.xsd")
    protected Double amendedFacilityAmt;
    @XmlElement(name = "Amended_USD_Equivalent_Amt", namespace = "http://treasury.ge.com/schemas/ICFP/FacilityIncreaseDecrease.xsd")
    protected Double amendedUSDEquivalentAmt;
    @XmlElement(name = "Facility_Inc_Dec_Amt", namespace = "http://treasury.ge.com/schemas/ICFP/FacilityIncreaseDecrease.xsd")
    protected Double facilityIncDecAmt;
    @XmlElement(name = "Facility_Inc_Dec_USD_Equivalent_Amt", namespace = "http://treasury.ge.com/schemas/ICFP/FacilityIncreaseDecrease.xsd")
    protected Double facilityIncDecUSDEquivalentAmt;

    /**
     * Gets the value of the facilityTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFacilityTypeId() {
        return facilityTypeId;
    }

    /**
     * Sets the value of the facilityTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFacilityTypeId(Integer value) {
        this.facilityTypeId = value;
    }

    /**
     * Gets the value of the facilityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityType() {
        return facilityType;
    }

    /**
     * Sets the value of the facilityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityType(String value) {
        this.facilityType = value;
    }

    /**
     * Gets the value of the currencyFacilityAmt property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCurrencyFacilityAmt() {
        return currencyFacilityAmt;
    }

    /**
     * Sets the value of the currencyFacilityAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCurrencyFacilityAmt(Double value) {
        this.currencyFacilityAmt = value;
    }

    /**
     * Gets the value of the currencyUSDEquivalentAmt property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCurrencyUSDEquivalentAmt() {
        return currencyUSDEquivalentAmt;
    }

    /**
     * Sets the value of the currencyUSDEquivalentAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCurrencyUSDEquivalentAmt(Double value) {
        this.currencyUSDEquivalentAmt = value;
    }

    /**
     * Gets the value of the amendedFacilityAmt property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAmendedFacilityAmt() {
        return amendedFacilityAmt;
    }

    /**
     * Sets the value of the amendedFacilityAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAmendedFacilityAmt(Double value) {
        this.amendedFacilityAmt = value;
    }

    /**
     * Gets the value of the amendedUSDEquivalentAmt property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAmendedUSDEquivalentAmt() {
        return amendedUSDEquivalentAmt;
    }

    /**
     * Sets the value of the amendedUSDEquivalentAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAmendedUSDEquivalentAmt(Double value) {
        this.amendedUSDEquivalentAmt = value;
    }

    /**
     * Gets the value of the facilityIncDecAmt property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFacilityIncDecAmt() {
        return facilityIncDecAmt;
    }

    /**
     * Sets the value of the facilityIncDecAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFacilityIncDecAmt(Double value) {
        this.facilityIncDecAmt = value;
    }

    /**
     * Gets the value of the facilityIncDecUSDEquivalentAmt property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFacilityIncDecUSDEquivalentAmt() {
        return facilityIncDecUSDEquivalentAmt;
    }

    /**
     * Sets the value of the facilityIncDecUSDEquivalentAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFacilityIncDecUSDEquivalentAmt(Double value) {
        this.facilityIncDecUSDEquivalentAmt = value;
    }

    public FacilityIncreaseDecrease withFacilityTypeId(Integer value) {
        setFacilityTypeId(value);
        return this;
    }

    public FacilityIncreaseDecrease withFacilityType(String value) {
        setFacilityType(value);
        return this;
    }

    public FacilityIncreaseDecrease withCurrencyFacilityAmt(Double value) {
        setCurrencyFacilityAmt(value);
        return this;
    }

    public FacilityIncreaseDecrease withCurrencyUSDEquivalentAmt(Double value) {
        setCurrencyUSDEquivalentAmt(value);
        return this;
    }

    public FacilityIncreaseDecrease withAmendedFacilityAmt(Double value) {
        setAmendedFacilityAmt(value);
        return this;
    }

    public FacilityIncreaseDecrease withAmendedUSDEquivalentAmt(Double value) {
        setAmendedUSDEquivalentAmt(value);
        return this;
    }

    public FacilityIncreaseDecrease withFacilityIncDecAmt(Double value) {
        setFacilityIncDecAmt(value);
        return this;
    }

    public FacilityIncreaseDecrease withFacilityIncDecUSDEquivalentAmt(Double value) {
        setFacilityIncDecUSDEquivalentAmt(value);
        return this;
    }

}
