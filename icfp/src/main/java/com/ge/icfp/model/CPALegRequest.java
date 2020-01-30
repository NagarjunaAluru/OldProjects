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
import javax.xml.datatype.XMLGregorianCalendar;
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
 *         &lt;element name="Ru_Amended_Tcl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tcl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Change_Type_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Non_Standard_Agreements_Flag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Transaction_Captured_In_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Change_Type_Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Request_Dt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Withholding_Tax_Applicable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Delete_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd}CPA_Summary" minOccurs="0"/>
 *         &lt;element name="Subordinated_Debt" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ICFP/RateInformation.xsd}Rate_Information" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ICFP/DayTwoOperations}Day_Two_Operations" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ICFP/TPLegRequest.xsd}TP_Leg_Request" minOccurs="0"/>
 *         &lt;element name="Cross_Border_Flag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "ruAmendedTcl",
    "tcl",
    "amt",
    "changeTypeId",
    "nonStandardAgreementsFlag",
    "transactionCapturedInId",
    "changeTypeComments",
    "comments",
    "requestDt",
    "withholdingTaxApplicable",
    "deleteFlag",
    "cpaSummary",
    "subordinatedDebt",
    "rateInformation",
    "dayTwoOperations",
    "tpLegRequest",
    "crossBorderFlag"
})
@XmlRootElement(name = "CPA_Leg_Request", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
public class CPALegRequest
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Ru_Amended_Tcl", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected String ruAmendedTcl;
    @XmlElement(name = "Tcl", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected String tcl;
    @XmlElement(name = "Amt", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected String amt;
    @XmlElement(name = "Change_Type_Id", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected Integer changeTypeId;
    @XmlElement(name = "Non_Standard_Agreements_Flag", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected Boolean nonStandardAgreementsFlag;
    @XmlElement(name = "Transaction_Captured_In_Id", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected String transactionCapturedInId;
    @XmlElement(name = "Change_Type_Comments", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected String changeTypeComments;
    @XmlElement(name = "Comments", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected String comments;
    @XmlElement(name = "Request_Dt", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected XMLGregorianCalendar requestDt;
    @XmlElement(name = "Withholding_Tax_Applicable", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected String withholdingTaxApplicable;
    @XmlElement(name = "Delete_Flag", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected String deleteFlag;
    @XmlElement(name = "CPA_Summary", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected CPASummary cpaSummary;
    @XmlElement(name = "Subordinated_Debt", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected Boolean subordinatedDebt;
    @XmlElement(name = "Rate_Information", namespace = "http://treasury.ge.com/schemas/ICFP/RateInformation.xsd")
    protected RateInformation rateInformation;
    @XmlElement(name = "Day_Two_Operations", namespace = "http://treasury.ge.com/schemas/ICFP/DayTwoOperations")
    protected DayTwoOperations dayTwoOperations;
    @XmlElement(name = "TP_Leg_Request", namespace = "http://treasury.ge.com/schemas/ICFP/TPLegRequest.xsd")
    protected TPLegRequest tpLegRequest;
    @XmlElement(name = "Cross_Border_Flag", namespace = "http://treasury.ge.com/schemas/ICFP/CPALegRequest.xsd")
    protected Boolean crossBorderFlag;

    /**
     * Gets the value of the ruAmendedTcl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuAmendedTcl() {
        return ruAmendedTcl;
    }

    /**
     * Sets the value of the ruAmendedTcl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuAmendedTcl(String value) {
        this.ruAmendedTcl = value;
    }

    /**
     * Gets the value of the tcl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTcl() {
        return tcl;
    }

    /**
     * Sets the value of the tcl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTcl(String value) {
        this.tcl = value;
    }

    /**
     * Gets the value of the amt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmt() {
        return amt;
    }

    /**
     * Sets the value of the amt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmt(String value) {
        this.amt = value;
    }

    /**
     * Gets the value of the changeTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getChangeTypeId() {
        return changeTypeId;
    }

    /**
     * Sets the value of the changeTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setChangeTypeId(Integer value) {
        this.changeTypeId = value;
    }

    /**
     * Gets the value of the nonStandardAgreementsFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNonStandardAgreementsFlag() {
        return nonStandardAgreementsFlag;
    }

    /**
     * Sets the value of the nonStandardAgreementsFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNonStandardAgreementsFlag(Boolean value) {
        this.nonStandardAgreementsFlag = value;
    }

    /**
     * Gets the value of the transactionCapturedInId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionCapturedInId() {
        return transactionCapturedInId;
    }

    /**
     * Sets the value of the transactionCapturedInId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionCapturedInId(String value) {
        this.transactionCapturedInId = value;
    }

    /**
     * Gets the value of the changeTypeComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeTypeComments() {
        return changeTypeComments;
    }

    /**
     * Sets the value of the changeTypeComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeTypeComments(String value) {
        this.changeTypeComments = value;
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
     * Gets the value of the requestDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestDt() {
        return requestDt;
    }

    /**
     * Sets the value of the requestDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestDt(XMLGregorianCalendar value) {
        this.requestDt = value;
    }

    /**
     * Gets the value of the withholdingTaxApplicable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWithholdingTaxApplicable() {
        return withholdingTaxApplicable;
    }

    /**
     * Sets the value of the withholdingTaxApplicable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWithholdingTaxApplicable(String value) {
        this.withholdingTaxApplicable = value;
    }

    /**
     * Gets the value of the deleteFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * Sets the value of the deleteFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeleteFlag(String value) {
        this.deleteFlag = value;
    }

    /**
     * Gets the value of the cpaSummary property.
     * 
     * @return
     *     possible object is
     *     {@link CPASummary }
     *     
     */
    public CPASummary getCPASummary() {
        return cpaSummary;
    }

    /**
     * Sets the value of the cpaSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link CPASummary }
     *     
     */
    public void setCPASummary(CPASummary value) {
        this.cpaSummary = value;
    }

    /**
     * Gets the value of the subordinatedDebt property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSubordinatedDebt() {
        return subordinatedDebt;
    }

    /**
     * Sets the value of the subordinatedDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSubordinatedDebt(Boolean value) {
        this.subordinatedDebt = value;
    }

    /**
     * Gets the value of the rateInformation property.
     * 
     * @return
     *     possible object is
     *     {@link RateInformation }
     *     
     */
    public RateInformation getRateInformation() {
        return rateInformation;
    }

    /**
     * Sets the value of the rateInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateInformation }
     *     
     */
    public void setRateInformation(RateInformation value) {
        this.rateInformation = value;
    }

    /**
     * Gets the value of the dayTwoOperations property.
     * 
     * @return
     *     possible object is
     *     {@link DayTwoOperations }
     *     
     */
    public DayTwoOperations getDayTwoOperations() {
        return dayTwoOperations;
    }

    /**
     * Sets the value of the dayTwoOperations property.
     * 
     * @param value
     *     allowed object is
     *     {@link DayTwoOperations }
     *     
     */
    public void setDayTwoOperations(DayTwoOperations value) {
        this.dayTwoOperations = value;
    }

    /**
     * Gets the value of the tpLegRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TPLegRequest }
     *     
     */
    public TPLegRequest getTPLegRequest() {
        return tpLegRequest;
    }

    /**
     * Sets the value of the tpLegRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPLegRequest }
     *     
     */
    public void setTPLegRequest(TPLegRequest value) {
        this.tpLegRequest = value;
    }

    /**
     * Gets the value of the crossBorderFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCrossBorderFlag() {
        return crossBorderFlag;
    }

    /**
     * Sets the value of the crossBorderFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCrossBorderFlag(Boolean value) {
        this.crossBorderFlag = value;
    }

    public CPALegRequest withRuAmendedTcl(String value) {
        setRuAmendedTcl(value);
        return this;
    }

    public CPALegRequest withTcl(String value) {
        setTcl(value);
        return this;
    }

    public CPALegRequest withAmt(String value) {
        setAmt(value);
        return this;
    }

    public CPALegRequest withChangeTypeId(Integer value) {
        setChangeTypeId(value);
        return this;
    }

    public CPALegRequest withNonStandardAgreementsFlag(Boolean value) {
        setNonStandardAgreementsFlag(value);
        return this;
    }

    public CPALegRequest withTransactionCapturedInId(String value) {
        setTransactionCapturedInId(value);
        return this;
    }

    public CPALegRequest withChangeTypeComments(String value) {
        setChangeTypeComments(value);
        return this;
    }

    public CPALegRequest withComments(String value) {
        setComments(value);
        return this;
    }

    public CPALegRequest withRequestDt(XMLGregorianCalendar value) {
        setRequestDt(value);
        return this;
    }

    public CPALegRequest withWithholdingTaxApplicable(String value) {
        setWithholdingTaxApplicable(value);
        return this;
    }

    public CPALegRequest withDeleteFlag(String value) {
        setDeleteFlag(value);
        return this;
    }

    public CPALegRequest withCPASummary(CPASummary value) {
        setCPASummary(value);
        return this;
    }

    public CPALegRequest withSubordinatedDebt(Boolean value) {
        setSubordinatedDebt(value);
        return this;
    }

    public CPALegRequest withRateInformation(RateInformation value) {
        setRateInformation(value);
        return this;
    }

    public CPALegRequest withDayTwoOperations(DayTwoOperations value) {
        setDayTwoOperations(value);
        return this;
    }

    public CPALegRequest withTPLegRequest(TPLegRequest value) {
        setTPLegRequest(value);
        return this;
    }

    public CPALegRequest withCrossBorderFlag(Boolean value) {
        setCrossBorderFlag(value);
        return this;
    }

}