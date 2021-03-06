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
 *         &lt;element name="IN_AS_OF_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GE_BUSINESS_GROUP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GCFO_RECORD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LE_CODE_GOLD_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FACILITY_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FACILITY_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FACILITY_CURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BUSINESS_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BUSINESS_SSO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PURPOSE_OF_CREDIT_FACILITY_REMARKS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FACILITY_START_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FACILITY_END_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SUPPORTED_ENTITY_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BANKS_PARENT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "inasofdate",
    "gebusinessgroup",
    "gcforecord",
    "lecodegoldid",
    "lename",
    "facilitytype",
    "facilityamount",
    "facilitycurrency",
    "businessname",
    "businesssso",
    "purposeofcreditfacilityremarks",
    "facilitystartdate",
    "facilityenddate",
    "supportedentityname",
    "banksparentname"
})
@XmlRootElement(name = "GCFODetails", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
public class GCFODetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "IN_AS_OF_DATE", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String inasofdate;
    @XmlElement(name = "GE_BUSINESS_GROUP", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String gebusinessgroup;
    @XmlElement(name = "GCFO_RECORD", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String gcforecord;
    @XmlElement(name = "LE_CODE_GOLD_ID", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String lecodegoldid;
    @XmlElement(name = "LE_NAME", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String lename;
    @XmlElement(name = "FACILITY_TYPE", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String facilitytype;
    @XmlElement(name = "FACILITY_AMOUNT", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String facilityamount;
    @XmlElement(name = "FACILITY_CURRENCY", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String facilitycurrency;
    @XmlElement(name = "BUSINESS_NAME", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String businessname;
    @XmlElement(name = "BUSINESS_SSO", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String businesssso;
    @XmlElement(name = "PURPOSE_OF_CREDIT_FACILITY_REMARKS", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String purposeofcreditfacilityremarks;
    @XmlElement(name = "FACILITY_START_DATE", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String facilitystartdate;
    @XmlElement(name = "FACILITY_END_DATE", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String facilityenddate;
    @XmlElement(name = "SUPPORTED_ENTITY_NAME", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String supportedentityname;
    @XmlElement(name = "BANKS_PARENT_NAME", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/GCFODetails.xsd")
    protected String banksparentname;

    /**
     * Gets the value of the inasofdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINASOFDATE() {
        return inasofdate;
    }

    /**
     * Sets the value of the inasofdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINASOFDATE(String value) {
        this.inasofdate = value;
    }

    /**
     * Gets the value of the gebusinessgroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGEBUSINESSGROUP() {
        return gebusinessgroup;
    }

    /**
     * Sets the value of the gebusinessgroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGEBUSINESSGROUP(String value) {
        this.gebusinessgroup = value;
    }

    /**
     * Gets the value of the gcforecord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGCFORECORD() {
        return gcforecord;
    }

    /**
     * Sets the value of the gcforecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGCFORECORD(String value) {
        this.gcforecord = value;
    }

    /**
     * Gets the value of the lecodegoldid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLECODEGOLDID() {
        return lecodegoldid;
    }

    /**
     * Sets the value of the lecodegoldid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLECODEGOLDID(String value) {
        this.lecodegoldid = value;
    }

    /**
     * Gets the value of the lename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLENAME() {
        return lename;
    }

    /**
     * Sets the value of the lename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLENAME(String value) {
        this.lename = value;
    }

    /**
     * Gets the value of the facilitytype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFACILITYTYPE() {
        return facilitytype;
    }

    /**
     * Sets the value of the facilitytype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFACILITYTYPE(String value) {
        this.facilitytype = value;
    }

    /**
     * Gets the value of the facilityamount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFACILITYAMOUNT() {
        return facilityamount;
    }

    /**
     * Sets the value of the facilityamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFACILITYAMOUNT(String value) {
        this.facilityamount = value;
    }

    /**
     * Gets the value of the facilitycurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFACILITYCURRENCY() {
        return facilitycurrency;
    }

    /**
     * Sets the value of the facilitycurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFACILITYCURRENCY(String value) {
        this.facilitycurrency = value;
    }

    /**
     * Gets the value of the businessname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUSINESSNAME() {
        return businessname;
    }

    /**
     * Sets the value of the businessname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUSINESSNAME(String value) {
        this.businessname = value;
    }

    /**
     * Gets the value of the businesssso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUSINESSSSO() {
        return businesssso;
    }

    /**
     * Sets the value of the businesssso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUSINESSSSO(String value) {
        this.businesssso = value;
    }

    /**
     * Gets the value of the purposeofcreditfacilityremarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPURPOSEOFCREDITFACILITYREMARKS() {
        return purposeofcreditfacilityremarks;
    }

    /**
     * Sets the value of the purposeofcreditfacilityremarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPURPOSEOFCREDITFACILITYREMARKS(String value) {
        this.purposeofcreditfacilityremarks = value;
    }

    /**
     * Gets the value of the facilitystartdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFACILITYSTARTDATE() {
        return facilitystartdate;
    }

    /**
     * Sets the value of the facilitystartdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFACILITYSTARTDATE(String value) {
        this.facilitystartdate = value;
    }

    /**
     * Gets the value of the facilityenddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFACILITYENDDATE() {
        return facilityenddate;
    }

    /**
     * Sets the value of the facilityenddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFACILITYENDDATE(String value) {
        this.facilityenddate = value;
    }

    /**
     * Gets the value of the supportedentityname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUPPORTEDENTITYNAME() {
        return supportedentityname;
    }

    /**
     * Sets the value of the supportedentityname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUPPORTEDENTITYNAME(String value) {
        this.supportedentityname = value;
    }

    /**
     * Gets the value of the banksparentname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBANKSPARENTNAME() {
        return banksparentname;
    }

    /**
     * Sets the value of the banksparentname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBANKSPARENTNAME(String value) {
        this.banksparentname = value;
    }

    public GCFODetails withINASOFDATE(String value) {
        setINASOFDATE(value);
        return this;
    }

    public GCFODetails withGEBUSINESSGROUP(String value) {
        setGEBUSINESSGROUP(value);
        return this;
    }

    public GCFODetails withGCFORECORD(String value) {
        setGCFORECORD(value);
        return this;
    }

    public GCFODetails withLECODEGOLDID(String value) {
        setLECODEGOLDID(value);
        return this;
    }

    public GCFODetails withLENAME(String value) {
        setLENAME(value);
        return this;
    }

    public GCFODetails withFACILITYTYPE(String value) {
        setFACILITYTYPE(value);
        return this;
    }

    public GCFODetails withFACILITYAMOUNT(String value) {
        setFACILITYAMOUNT(value);
        return this;
    }

    public GCFODetails withFACILITYCURRENCY(String value) {
        setFACILITYCURRENCY(value);
        return this;
    }

    public GCFODetails withBUSINESSNAME(String value) {
        setBUSINESSNAME(value);
        return this;
    }

    public GCFODetails withBUSINESSSSO(String value) {
        setBUSINESSSSO(value);
        return this;
    }

    public GCFODetails withPURPOSEOFCREDITFACILITYREMARKS(String value) {
        setPURPOSEOFCREDITFACILITYREMARKS(value);
        return this;
    }

    public GCFODetails withFACILITYSTARTDATE(String value) {
        setFACILITYSTARTDATE(value);
        return this;
    }

    public GCFODetails withFACILITYENDDATE(String value) {
        setFACILITYENDDATE(value);
        return this;
    }

    public GCFODetails withSUPPORTEDENTITYNAME(String value) {
        setSUPPORTEDENTITYNAME(value);
        return this;
    }

    public GCFODetails withBANKSPARENTNAME(String value) {
        setBANKSPARENTNAME(value);
        return this;
    }

}
