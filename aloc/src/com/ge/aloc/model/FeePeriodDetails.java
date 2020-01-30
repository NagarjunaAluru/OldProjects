//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.hydus.hwf.jaxb.adapters.XMLDatetimeAsCalendarAdapter;
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
 *         &lt;element name="APM_Config_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Period_Start_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Period_End_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Period_Cutt_Off_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
    "apmConfigID",
    "periodStartDate",
    "periodEndDate",
    "periodCuttOffDate"
})
@XmlRootElement(name = "FeePeriodDetails", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeePeriodDetails.xsd")
public class FeePeriodDetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "APM_Config_ID", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeePeriodDetails.xsd")
    protected BigInteger apmConfigID;
    @XmlElement(name = "Period_Start_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeePeriodDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar periodStartDate;
    @XmlElement(name = "Period_End_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeePeriodDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar periodEndDate;
    @XmlElement(name = "Period_Cutt_Off_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeePeriodDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar periodCuttOffDate;

    /**
     * Gets the value of the apmConfigID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAPMConfigID() {
        return apmConfigID;
    }

    /**
     * Sets the value of the apmConfigID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAPMConfigID(BigInteger value) {
        this.apmConfigID = value;
    }

    /**
     * Gets the value of the periodStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getPeriodStartDate() {
        return periodStartDate;
    }

    /**
     * Sets the value of the periodStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodStartDate(Calendar value) {
        this.periodStartDate = value;
    }

    /**
     * Gets the value of the periodEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getPeriodEndDate() {
        return periodEndDate;
    }

    /**
     * Sets the value of the periodEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodEndDate(Calendar value) {
        this.periodEndDate = value;
    }

    /**
     * Gets the value of the periodCuttOffDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getPeriodCuttOffDate() {
        return periodCuttOffDate;
    }

    /**
     * Sets the value of the periodCuttOffDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodCuttOffDate(Calendar value) {
        this.periodCuttOffDate = value;
    }

    public FeePeriodDetails withAPMConfigID(BigInteger value) {
        setAPMConfigID(value);
        return this;
    }

    public FeePeriodDetails withPeriodStartDate(Calendar value) {
        setPeriodStartDate(value);
        return this;
    }

    public FeePeriodDetails withPeriodEndDate(Calendar value) {
        setPeriodEndDate(value);
        return this;
    }

    public FeePeriodDetails withPeriodCuttOffDate(Calendar value) {
        setPeriodCuttOffDate(value);
        return this;
    }

}