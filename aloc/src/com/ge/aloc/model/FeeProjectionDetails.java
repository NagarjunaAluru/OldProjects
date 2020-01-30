//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.15 at 11:16:56 AM IST 
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
 *         &lt;element name="IN_CUNTRY_ISSUANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IN_BENE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IN_ISSUER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IN_APPL_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IN_BUNDLE_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IN_MOR_RATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IN_NUM_MONTHS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ALOCRECORDNUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BANKREFNUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="USDEQUIVALENTAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CURRENCYOFINSTRUMENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISSUEDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXPIRYDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MONTH_RANGE_1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MONTH_RANGE_2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MONTH_RANGE_3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MONTH_RANGE_4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IN_SITE_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Requestor_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Requestor_Sso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "incuntryissuance",
    "inbenename",
    "inissuerid",
    "inapplname",
    "inbundleid",
    "inmorrate",
    "innummonths",
    "alocrecordnum",
    "bankrefnum",
    "usdequivalentamt",
    "currencyofinstrument",
    "issuedate",
    "expirydate",
    "monthrange1",
    "monthrange2",
    "monthrange3",
    "monthrange4",
    "insiteid",
    "requestorName",
    "requestorSso"
})
@XmlRootElement(name = "FeeProjectionDetails", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
public class FeeProjectionDetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "IN_CUNTRY_ISSUANCE", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String incuntryissuance;
    @XmlElement(name = "IN_BENE_NAME", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String inbenename;
    @XmlElement(name = "IN_ISSUER_ID", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String inissuerid;
    @XmlElement(name = "IN_APPL_NAME", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String inapplname;
    @XmlElement(name = "IN_BUNDLE_ID", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String inbundleid;
    @XmlElement(name = "IN_MOR_RATE", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String inmorrate;
    @XmlElement(name = "IN_NUM_MONTHS", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String innummonths;
    @XmlElement(name = "ALOCRECORDNUM", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String alocrecordnum;
    @XmlElement(name = "BANKREFNUM", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String bankrefnum;
    @XmlElement(name = "USDEQUIVALENTAMT", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String usdequivalentamt;
    @XmlElement(name = "CURRENCYOFINSTRUMENT", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String currencyofinstrument;
    @XmlElement(name = "ISSUEDATE", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String issuedate;
    @XmlElement(name = "EXPIRYDATE", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String expirydate;
    @XmlElement(name = "MONTH_RANGE_1", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String monthrange1;
    @XmlElement(name = "MONTH_RANGE_2", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String monthrange2;
    @XmlElement(name = "MONTH_RANGE_3", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String monthrange3;
    @XmlElement(name = "MONTH_RANGE_4", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String monthrange4;
    @XmlElement(name = "IN_SITE_ID", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String insiteid;
    @XmlElement(name = "Requestor_Name", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String requestorName;
    @XmlElement(name = "Requestor_Sso", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/FeeProjectionDetails.xsd")
    protected String requestorSso;

    /**
     * Gets the value of the incuntryissuance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINCUNTRYISSUANCE() {
        return incuntryissuance;
    }

    /**
     * Sets the value of the incuntryissuance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINCUNTRYISSUANCE(String value) {
        this.incuntryissuance = value;
    }

    /**
     * Gets the value of the inbenename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINBENENAME() {
        return inbenename;
    }

    /**
     * Sets the value of the inbenename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINBENENAME(String value) {
        this.inbenename = value;
    }

    /**
     * Gets the value of the inissuerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINISSUERID() {
        return inissuerid;
    }

    /**
     * Sets the value of the inissuerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINISSUERID(String value) {
        this.inissuerid = value;
    }

    /**
     * Gets the value of the inapplname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINAPPLNAME() {
        return inapplname;
    }

    /**
     * Sets the value of the inapplname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINAPPLNAME(String value) {
        this.inapplname = value;
    }

    /**
     * Gets the value of the inbundleid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINBUNDLEID() {
        return inbundleid;
    }

    /**
     * Sets the value of the inbundleid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINBUNDLEID(String value) {
        this.inbundleid = value;
    }

    /**
     * Gets the value of the inmorrate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINMORRATE() {
        return inmorrate;
    }

    /**
     * Sets the value of the inmorrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINMORRATE(String value) {
        this.inmorrate = value;
    }

    /**
     * Gets the value of the innummonths property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINNUMMONTHS() {
        return innummonths;
    }

    /**
     * Sets the value of the innummonths property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINNUMMONTHS(String value) {
        this.innummonths = value;
    }

    /**
     * Gets the value of the alocrecordnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getALOCRECORDNUM() {
        return alocrecordnum;
    }

    /**
     * Sets the value of the alocrecordnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setALOCRECORDNUM(String value) {
        this.alocrecordnum = value;
    }

    /**
     * Gets the value of the bankrefnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBANKREFNUM() {
        return bankrefnum;
    }

    /**
     * Sets the value of the bankrefnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBANKREFNUM(String value) {
        this.bankrefnum = value;
    }

    /**
     * Gets the value of the usdequivalentamt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSDEQUIVALENTAMT() {
        return usdequivalentamt;
    }

    /**
     * Sets the value of the usdequivalentamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSDEQUIVALENTAMT(String value) {
        this.usdequivalentamt = value;
    }

    /**
     * Gets the value of the currencyofinstrument property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCURRENCYOFINSTRUMENT() {
        return currencyofinstrument;
    }

    /**
     * Sets the value of the currencyofinstrument property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCURRENCYOFINSTRUMENT(String value) {
        this.currencyofinstrument = value;
    }

    /**
     * Gets the value of the issuedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISSUEDATE() {
        return issuedate;
    }

    /**
     * Sets the value of the issuedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISSUEDATE(String value) {
        this.issuedate = value;
    }

    /**
     * Gets the value of the expirydate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXPIRYDATE() {
        return expirydate;
    }

    /**
     * Sets the value of the expirydate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXPIRYDATE(String value) {
        this.expirydate = value;
    }

    /**
     * Gets the value of the monthrange1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMONTHRANGE1() {
        return monthrange1;
    }

    /**
     * Sets the value of the monthrange1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMONTHRANGE1(String value) {
        this.monthrange1 = value;
    }

    /**
     * Gets the value of the monthrange2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMONTHRANGE2() {
        return monthrange2;
    }

    /**
     * Sets the value of the monthrange2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMONTHRANGE2(String value) {
        this.monthrange2 = value;
    }

    /**
     * Gets the value of the monthrange3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMONTHRANGE3() {
        return monthrange3;
    }

    /**
     * Sets the value of the monthrange3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMONTHRANGE3(String value) {
        this.monthrange3 = value;
    }

    /**
     * Gets the value of the monthrange4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMONTHRANGE4() {
        return monthrange4;
    }

    /**
     * Sets the value of the monthrange4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMONTHRANGE4(String value) {
        this.monthrange4 = value;
    }

    /**
     * Gets the value of the insiteid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSITEID() {
        return insiteid;
    }

    /**
     * Sets the value of the insiteid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSITEID(String value) {
        this.insiteid = value;
    }

    /**
     * Gets the value of the requestorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestorName() {
        return requestorName;
    }

    /**
     * Sets the value of the requestorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestorName(String value) {
        this.requestorName = value;
    }

    /**
     * Gets the value of the requestorSso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestorSso() {
        return requestorSso;
    }

    /**
     * Sets the value of the requestorSso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestorSso(String value) {
        this.requestorSso = value;
    }

    public FeeProjectionDetails withINCUNTRYISSUANCE(String value) {
        setINCUNTRYISSUANCE(value);
        return this;
    }

    public FeeProjectionDetails withINBENENAME(String value) {
        setINBENENAME(value);
        return this;
    }

    public FeeProjectionDetails withINISSUERID(String value) {
        setINISSUERID(value);
        return this;
    }

    public FeeProjectionDetails withINAPPLNAME(String value) {
        setINAPPLNAME(value);
        return this;
    }

    public FeeProjectionDetails withINBUNDLEID(String value) {
        setINBUNDLEID(value);
        return this;
    }

    public FeeProjectionDetails withINMORRATE(String value) {
        setINMORRATE(value);
        return this;
    }

    public FeeProjectionDetails withINNUMMONTHS(String value) {
        setINNUMMONTHS(value);
        return this;
    }

    public FeeProjectionDetails withALOCRECORDNUM(String value) {
        setALOCRECORDNUM(value);
        return this;
    }

    public FeeProjectionDetails withBANKREFNUM(String value) {
        setBANKREFNUM(value);
        return this;
    }

    public FeeProjectionDetails withUSDEQUIVALENTAMT(String value) {
        setUSDEQUIVALENTAMT(value);
        return this;
    }

    public FeeProjectionDetails withCURRENCYOFINSTRUMENT(String value) {
        setCURRENCYOFINSTRUMENT(value);
        return this;
    }

    public FeeProjectionDetails withISSUEDATE(String value) {
        setISSUEDATE(value);
        return this;
    }

    public FeeProjectionDetails withEXPIRYDATE(String value) {
        setEXPIRYDATE(value);
        return this;
    }

    public FeeProjectionDetails withMONTHRANGE1(String value) {
        setMONTHRANGE1(value);
        return this;
    }

    public FeeProjectionDetails withMONTHRANGE2(String value) {
        setMONTHRANGE2(value);
        return this;
    }

    public FeeProjectionDetails withMONTHRANGE3(String value) {
        setMONTHRANGE3(value);
        return this;
    }

    public FeeProjectionDetails withMONTHRANGE4(String value) {
        setMONTHRANGE4(value);
        return this;
    }

    public FeeProjectionDetails withINSITEID(String value) {
        setINSITEID(value);
        return this;
    }

    public FeeProjectionDetails withRequestorName(String value) {
        setRequestorName(value);
        return this;
    }

    public FeeProjectionDetails withRequestorSso(String value) {
        setRequestorSso(value);
        return this;
    }

}
