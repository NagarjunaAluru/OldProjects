//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.17 at 01:00:56 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 *         &lt;element name="Last_Action_Dt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ALOC_Record_Number" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Aloc_Record_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Currency_Cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Instrument_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pending_Action_By" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Requestor_SSO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Approver_SSO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Applicant_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Principal_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tri_Party_Applicant_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Beneficiary_NAme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Obligee_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Designated_For_Bundling" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Date_Received" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Bundle_id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Link_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Instrument_Purpose" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Purpose_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Amendment_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Rider_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bond_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bond_Type_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Sub_Bond_Type_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Bond_Sub_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Issuance_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bank_Ref_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Surety_Ref_Num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country_Of_Issuance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Issuance_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Site_Prefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Inc_Dec_Amt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/WFDetails.xsd}WFDetails" minOccurs="0"/>
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
    "lastActionDt",
    "alocRecordNumber",
    "alocRecordId",
    "instrumentType",
    "currencyCd",
    "instrumentAmt",
    "instrumentID",
    "state",
    "pendingActionBy",
    "requestorSSO",
    "approverSSO",
    "applicantName",
    "principalName",
    "triPartyApplicantName",
    "beneficiaryNAme",
    "obligeeName",
    "designatedForBundling",
    "dateReceived",
    "bundleId",
    "linkId",
    "instrumentPurpose",
    "instrumentPurposeId",
    "amendmentId",
    "riderId",
    "bondType",
    "bondTypeId",
    "subBondTypeId",
    "bondSubType",
    "issuanceNumber",
    "bankRefNumber",
    "suretyRefNum",
    "countryOfIssuance",
    "issuanceDate",
    "sitePrefix",
    "incDecAmt",
    "wfDetails"
})
@XmlRootElement(name = "DashBoard", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
public class DashBoard
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Last_Action_Dt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar lastActionDt;
    @XmlElement(name = "ALOC_Record_Number", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected BigInteger alocRecordNumber;
    @XmlElement(name = "Aloc_Record_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String alocRecordId;
    @XmlElement(name = "Instrument_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String instrumentType;
    @XmlElement(name = "Currency_Cd", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String currencyCd;
    @XmlElement(name = "Instrument_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected BigDecimal instrumentAmt;
    @XmlElement(name = "Instrument_ID", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected BigInteger instrumentID;
    @XmlElement(name = "State", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String state;
    @XmlElement(name = "Pending_Action_By", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String pendingActionBy;
    @XmlElement(name = "Requestor_SSO", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String requestorSSO;
    @XmlElement(name = "Approver_SSO", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String approverSSO;
    @XmlElement(name = "Applicant_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String applicantName;
    @XmlElement(name = "Principal_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String principalName;
    @XmlElement(name = "Tri_Party_Applicant_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String triPartyApplicantName;
    @XmlElement(name = "Beneficiary_NAme", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String beneficiaryNAme;
    @XmlElement(name = "Obligee_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String obligeeName;
    @XmlElement(name = "Designated_For_Bundling", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String designatedForBundling;
    @XmlElement(name = "Date_Received", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar dateReceived;
    @XmlElement(name = "Bundle_id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected BigInteger bundleId;
    @XmlElement(name = "Link_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected BigInteger linkId;
    @XmlElement(name = "Instrument_Purpose", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String instrumentPurpose;
    @XmlElement(name = "Instrument_Purpose_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected BigInteger instrumentPurposeId;
    @XmlElement(name = "Amendment_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String amendmentId;
    @XmlElement(name = "Rider_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String riderId;
    @XmlElement(name = "Bond_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String bondType;
    @XmlElement(name = "Bond_Type_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected BigInteger bondTypeId;
    @XmlElement(name = "Sub_Bond_Type_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected BigInteger subBondTypeId;
    @XmlElement(name = "Bond_Sub_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String bondSubType;
    @XmlElement(name = "Issuance_Number", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String issuanceNumber;
    @XmlElement(name = "Bank_Ref_Number", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String bankRefNumber;
    @XmlElement(name = "Surety_Ref_Num", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String suretyRefNum;
    @XmlElement(name = "Country_Of_Issuance", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String countryOfIssuance;
    @XmlElement(name = "Issuance_Date", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar issuanceDate;
    @XmlElement(name = "Site_Prefix", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String sitePrefix;
    @XmlElement(name = "Inc_Dec_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DashBoard.xsd")
    protected String incDecAmt;
    @XmlElement(name = "WFDetails", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/WFDetails.xsd")
    protected WFDetails wfDetails;

    /**
     * Gets the value of the lastActionDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getLastActionDt() {
        return lastActionDt;
    }

    /**
     * Sets the value of the lastActionDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastActionDt(Calendar value) {
        this.lastActionDt = value;
    }

    /**
     * Gets the value of the alocRecordNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getALOCRecordNumber() {
        return alocRecordNumber;
    }

    /**
     * Sets the value of the alocRecordNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setALOCRecordNumber(BigInteger value) {
        this.alocRecordNumber = value;
    }

    /**
     * Gets the value of the alocRecordId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlocRecordId() {
        return alocRecordId;
    }

    /**
     * Sets the value of the alocRecordId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlocRecordId(String value) {
        this.alocRecordId = value;
    }

    /**
     * Gets the value of the instrumentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrumentType() {
        return instrumentType;
    }

    /**
     * Sets the value of the instrumentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrumentType(String value) {
        this.instrumentType = value;
    }

    /**
     * Gets the value of the currencyCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCd() {
        return currencyCd;
    }

    /**
     * Sets the value of the currencyCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCd(String value) {
        this.currencyCd = value;
    }

    /**
     * Gets the value of the instrumentAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInstrumentAmt() {
        return instrumentAmt;
    }

    /**
     * Sets the value of the instrumentAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInstrumentAmt(BigDecimal value) {
        this.instrumentAmt = value;
    }

    /**
     * Gets the value of the instrumentID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInstrumentID() {
        return instrumentID;
    }

    /**
     * Sets the value of the instrumentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInstrumentID(BigInteger value) {
        this.instrumentID = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the pendingActionBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPendingActionBy() {
        return pendingActionBy;
    }

    /**
     * Sets the value of the pendingActionBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPendingActionBy(String value) {
        this.pendingActionBy = value;
    }

    /**
     * Gets the value of the requestorSSO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestorSSO() {
        return requestorSSO;
    }

    /**
     * Sets the value of the requestorSSO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestorSSO(String value) {
        this.requestorSSO = value;
    }

    /**
     * Gets the value of the approverSSO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproverSSO() {
        return approverSSO;
    }

    /**
     * Sets the value of the approverSSO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproverSSO(String value) {
        this.approverSSO = value;
    }

    /**
     * Gets the value of the applicantName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicantName() {
        return applicantName;
    }

    /**
     * Sets the value of the applicantName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicantName(String value) {
        this.applicantName = value;
    }

    /**
     * Gets the value of the principalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrincipalName() {
        return principalName;
    }

    /**
     * Sets the value of the principalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipalName(String value) {
        this.principalName = value;
    }

    /**
     * Gets the value of the triPartyApplicantName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTriPartyApplicantName() {
        return triPartyApplicantName;
    }

    /**
     * Sets the value of the triPartyApplicantName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTriPartyApplicantName(String value) {
        this.triPartyApplicantName = value;
    }

    /**
     * Gets the value of the beneficiaryNAme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryNAme() {
        return beneficiaryNAme;
    }

    /**
     * Sets the value of the beneficiaryNAme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryNAme(String value) {
        this.beneficiaryNAme = value;
    }

    /**
     * Gets the value of the obligeeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObligeeName() {
        return obligeeName;
    }

    /**
     * Sets the value of the obligeeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObligeeName(String value) {
        this.obligeeName = value;
    }

    /**
     * Gets the value of the designatedForBundling property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesignatedForBundling() {
        return designatedForBundling;
    }

    /**
     * Sets the value of the designatedForBundling property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesignatedForBundling(String value) {
        this.designatedForBundling = value;
    }

    /**
     * Gets the value of the dateReceived property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getDateReceived() {
        return dateReceived;
    }

    /**
     * Sets the value of the dateReceived property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateReceived(Calendar value) {
        this.dateReceived = value;
    }

    /**
     * Gets the value of the bundleId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBundleId() {
        return bundleId;
    }

    /**
     * Sets the value of the bundleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBundleId(BigInteger value) {
        this.bundleId = value;
    }

    /**
     * Gets the value of the linkId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLinkId() {
        return linkId;
    }

    /**
     * Sets the value of the linkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLinkId(BigInteger value) {
        this.linkId = value;
    }

    /**
     * Gets the value of the instrumentPurpose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrumentPurpose() {
        return instrumentPurpose;
    }

    /**
     * Sets the value of the instrumentPurpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrumentPurpose(String value) {
        this.instrumentPurpose = value;
    }

    /**
     * Gets the value of the instrumentPurposeId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInstrumentPurposeId() {
        return instrumentPurposeId;
    }

    /**
     * Sets the value of the instrumentPurposeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInstrumentPurposeId(BigInteger value) {
        this.instrumentPurposeId = value;
    }

    /**
     * Gets the value of the amendmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmendmentId() {
        return amendmentId;
    }

    /**
     * Sets the value of the amendmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmendmentId(String value) {
        this.amendmentId = value;
    }

    /**
     * Gets the value of the riderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRiderId() {
        return riderId;
    }

    /**
     * Sets the value of the riderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRiderId(String value) {
        this.riderId = value;
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
     * Gets the value of the issuanceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuanceNumber() {
        return issuanceNumber;
    }

    /**
     * Sets the value of the issuanceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuanceNumber(String value) {
        this.issuanceNumber = value;
    }

    /**
     * Gets the value of the bankRefNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankRefNumber() {
        return bankRefNumber;
    }

    /**
     * Sets the value of the bankRefNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankRefNumber(String value) {
        this.bankRefNumber = value;
    }

    /**
     * Gets the value of the suretyRefNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuretyRefNum() {
        return suretyRefNum;
    }

    /**
     * Sets the value of the suretyRefNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuretyRefNum(String value) {
        this.suretyRefNum = value;
    }

    /**
     * Gets the value of the countryOfIssuance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfIssuance() {
        return countryOfIssuance;
    }

    /**
     * Sets the value of the countryOfIssuance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfIssuance(String value) {
        this.countryOfIssuance = value;
    }

    /**
     * Gets the value of the issuanceDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getIssuanceDate() {
        return issuanceDate;
    }

    /**
     * Sets the value of the issuanceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuanceDate(Calendar value) {
        this.issuanceDate = value;
    }

    /**
     * Gets the value of the sitePrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSitePrefix() {
        return sitePrefix;
    }

    /**
     * Sets the value of the sitePrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSitePrefix(String value) {
        this.sitePrefix = value;
    }

    /**
     * Gets the value of the incDecAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncDecAmt() {
        return incDecAmt;
    }

    /**
     * Sets the value of the incDecAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncDecAmt(String value) {
        this.incDecAmt = value;
    }

    /**
     * Gets the value of the wfDetails property.
     * 
     * @return
     *     possible object is
     *     {@link WFDetails }
     *     
     */
    public WFDetails getWFDetails() {
        return wfDetails;
    }

    /**
     * Sets the value of the wfDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link WFDetails }
     *     
     */
    public void setWFDetails(WFDetails value) {
        this.wfDetails = value;
    }

    public DashBoard withLastActionDt(Calendar value) {
        setLastActionDt(value);
        return this;
    }

    public DashBoard withALOCRecordNumber(BigInteger value) {
        setALOCRecordNumber(value);
        return this;
    }

    public DashBoard withAlocRecordId(String value) {
        setAlocRecordId(value);
        return this;
    }

    public DashBoard withInstrumentType(String value) {
        setInstrumentType(value);
        return this;
    }

    public DashBoard withCurrencyCd(String value) {
        setCurrencyCd(value);
        return this;
    }

    public DashBoard withInstrumentAmt(BigDecimal value) {
        setInstrumentAmt(value);
        return this;
    }

    public DashBoard withInstrumentID(BigInteger value) {
        setInstrumentID(value);
        return this;
    }

    public DashBoard withState(String value) {
        setState(value);
        return this;
    }

    public DashBoard withPendingActionBy(String value) {
        setPendingActionBy(value);
        return this;
    }

    public DashBoard withRequestorSSO(String value) {
        setRequestorSSO(value);
        return this;
    }

    public DashBoard withApproverSSO(String value) {
        setApproverSSO(value);
        return this;
    }

    public DashBoard withApplicantName(String value) {
        setApplicantName(value);
        return this;
    }

    public DashBoard withPrincipalName(String value) {
        setPrincipalName(value);
        return this;
    }

    public DashBoard withTriPartyApplicantName(String value) {
        setTriPartyApplicantName(value);
        return this;
    }

    public DashBoard withBeneficiaryNAme(String value) {
        setBeneficiaryNAme(value);
        return this;
    }

    public DashBoard withObligeeName(String value) {
        setObligeeName(value);
        return this;
    }

    public DashBoard withDesignatedForBundling(String value) {
        setDesignatedForBundling(value);
        return this;
    }

    public DashBoard withDateReceived(Calendar value) {
        setDateReceived(value);
        return this;
    }

    public DashBoard withBundleId(BigInteger value) {
        setBundleId(value);
        return this;
    }

    public DashBoard withLinkId(BigInteger value) {
        setLinkId(value);
        return this;
    }

    public DashBoard withInstrumentPurpose(String value) {
        setInstrumentPurpose(value);
        return this;
    }

    public DashBoard withInstrumentPurposeId(BigInteger value) {
        setInstrumentPurposeId(value);
        return this;
    }

    public DashBoard withAmendmentId(String value) {
        setAmendmentId(value);
        return this;
    }

    public DashBoard withRiderId(String value) {
        setRiderId(value);
        return this;
    }

    public DashBoard withBondType(String value) {
        setBondType(value);
        return this;
    }

    public DashBoard withBondTypeId(BigInteger value) {
        setBondTypeId(value);
        return this;
    }

    public DashBoard withSubBondTypeId(BigInteger value) {
        setSubBondTypeId(value);
        return this;
    }

    public DashBoard withBondSubType(String value) {
        setBondSubType(value);
        return this;
    }

    public DashBoard withIssuanceNumber(String value) {
        setIssuanceNumber(value);
        return this;
    }

    public DashBoard withBankRefNumber(String value) {
        setBankRefNumber(value);
        return this;
    }

    public DashBoard withSuretyRefNum(String value) {
        setSuretyRefNum(value);
        return this;
    }

    public DashBoard withCountryOfIssuance(String value) {
        setCountryOfIssuance(value);
        return this;
    }

    public DashBoard withIssuanceDate(Calendar value) {
        setIssuanceDate(value);
        return this;
    }

    public DashBoard withSitePrefix(String value) {
        setSitePrefix(value);
        return this;
    }

    public DashBoard withIncDecAmt(String value) {
        setIncDecAmt(value);
        return this;
    }

    public DashBoard withWFDetails(WFDetails value) {
        setWFDetails(value);
        return this;
    }

}