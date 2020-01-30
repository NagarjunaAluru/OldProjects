//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.11 at 05:56:00 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
 *         &lt;element name="Applicant_Principal_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Beneficiary_Obligee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Beneficiary_Obligee_Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Purpose" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Gold_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GE_Applicant_Reference1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Beneficiary_Reference1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Countryof_Issuance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="In_Bundle_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="In_GB_App_Princ_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="In_GB_Ben_Oblig_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="In_GB_Ben_Oblig_Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="In_GB_Inst_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="In_GB_Inst_Purp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="In_GB_Gold_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="In_GB_Site_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="In_GB_GE_App_Ref1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="In_GB_Ben_Ref1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="In_GB_Country_Of_Issue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="In_GB_Bundle_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="In_Aging_Months" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Aging_User_SSO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Incremental_Num_Of_Months" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ALOC_Record" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Site_ID" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Applicant_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Issuer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Beneficiary_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bene_Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Issuance_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Expiration_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigEcon_Expiration_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Max_Aging_Months" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "applicantPrincipalName",
    "beneficiaryObligee",
    "beneficiaryObligeeCountry",
    "instrumentType",
    "instrumentPurpose",
    "goldID",
    "geApplicantReference1",
    "beneficiaryReference1",
    "countryofIssuance",
    "inBundleId",
    "inGBAppPrincName",
    "inGBBenObligName",
    "inGBBenObligCountry",
    "inGBInstType",
    "inGBInstPurp",
    "inGBGoldId",
    "inGBSiteCode",
    "inGBGEAppRef1",
    "inGBBenRef1",
    "inGBCountryOfIssue",
    "inGBBundleId",
    "inAgingMonths",
    "agingUserSSO",
    "incrementalNumOfMonths",
    "alocRecord",
    "siteIDs",
    "applicantName",
    "issuer",
    "beneficiaryName",
    "beneCountry",
    "issuanceDate",
    "instrumentAmount",
    "instrumentCurrency",
    "expirationDate",
    "origEconExpirationDate",
    "maxAgingMonths",
    "requestorName",
    "requestorSso"
})
@XmlRootElement(name = "AgingDetails", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
public class AgingDetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Applicant_Principal_Name", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String applicantPrincipalName;
    @XmlElement(name = "Beneficiary_Obligee", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String beneficiaryObligee;
    @XmlElement(name = "Beneficiary_Obligee_Country", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String beneficiaryObligeeCountry;
    @XmlElement(name = "Instrument_Type", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String instrumentType;
    @XmlElement(name = "Instrument_Purpose", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String instrumentPurpose;
    @XmlElement(name = "Gold_ID", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String goldID;
    @XmlElement(name = "GE_Applicant_Reference1", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String geApplicantReference1;
    @XmlElement(name = "Beneficiary_Reference1", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String beneficiaryReference1;
    @XmlElement(name = "Countryof_Issuance", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String countryofIssuance;
    @XmlElement(name = "In_Bundle_Id", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String inBundleId;
    @XmlElement(name = "In_GB_App_Princ_Name", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String inGBAppPrincName;
    @XmlElement(name = "In_GB_Ben_Oblig_Name", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String inGBBenObligName;
    @XmlElement(name = "In_GB_Ben_Oblig_Country", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String inGBBenObligCountry;
    @XmlElement(name = "In_GB_Inst_Type", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String inGBInstType;
    @XmlElement(name = "In_GB_Inst_Purp", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String inGBInstPurp;
    @XmlElement(name = "In_GB_Gold_Id", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String inGBGoldId;
    @XmlElement(name = "In_GB_Site_Code", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String inGBSiteCode;
    @XmlElement(name = "In_GB_GE_App_Ref1", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String inGBGEAppRef1;
    @XmlElement(name = "In_GB_Ben_Ref1", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String inGBBenRef1;
    @XmlElement(name = "In_GB_Country_Of_Issue", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String inGBCountryOfIssue;
    @XmlElement(name = "In_GB_Bundle_Id", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String inGBBundleId;
    @XmlElement(name = "In_Aging_Months", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String inAgingMonths;
    @XmlElement(name = "Aging_User_SSO", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String agingUserSSO;
    @XmlElement(name = "Incremental_Num_Of_Months", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String incrementalNumOfMonths;
    @XmlElement(name = "ALOC_Record", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String alocRecord;
    @XmlElement(name = "Site_ID", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected List<String> siteIDs;
    @XmlElement(name = "Applicant_Name", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String applicantName;
    @XmlElement(name = "Issuer", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String issuer;
    @XmlElement(name = "Beneficiary_Name", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String beneficiaryName;
    @XmlElement(name = "Bene_Country", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String beneCountry;
    @XmlElement(name = "Issuance_Date", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String issuanceDate;
    @XmlElement(name = "Instrument_Amount", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String instrumentAmount;
    @XmlElement(name = "Instrument_Currency", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String instrumentCurrency;
    @XmlElement(name = "Expiration_Date", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String expirationDate;
    @XmlElement(name = "OrigEcon_Expiration_Date", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String origEconExpirationDate;
    @XmlElement(name = "Max_Aging_Months", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String maxAgingMonths;
    @XmlElement(name = "Requestor_Name", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String requestorName;
    @XmlElement(name = "Requestor_Sso", namespace = "http://treasury.ge.com/schemas/ALOC/Reports/AgingDetails.xsd")
    protected String requestorSso;

    /**
     * Gets the value of the applicantPrincipalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicantPrincipalName() {
        return applicantPrincipalName;
    }

    /**
     * Sets the value of the applicantPrincipalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicantPrincipalName(String value) {
        this.applicantPrincipalName = value;
    }

    /**
     * Gets the value of the beneficiaryObligee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryObligee() {
        return beneficiaryObligee;
    }

    /**
     * Sets the value of the beneficiaryObligee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryObligee(String value) {
        this.beneficiaryObligee = value;
    }

    /**
     * Gets the value of the beneficiaryObligeeCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryObligeeCountry() {
        return beneficiaryObligeeCountry;
    }

    /**
     * Sets the value of the beneficiaryObligeeCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryObligeeCountry(String value) {
        this.beneficiaryObligeeCountry = value;
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
     * Gets the value of the goldID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoldID() {
        return goldID;
    }

    /**
     * Sets the value of the goldID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoldID(String value) {
        this.goldID = value;
    }

    /**
     * Gets the value of the geApplicantReference1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGEApplicantReference1() {
        return geApplicantReference1;
    }

    /**
     * Sets the value of the geApplicantReference1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGEApplicantReference1(String value) {
        this.geApplicantReference1 = value;
    }

    /**
     * Gets the value of the beneficiaryReference1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryReference1() {
        return beneficiaryReference1;
    }

    /**
     * Sets the value of the beneficiaryReference1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryReference1(String value) {
        this.beneficiaryReference1 = value;
    }

    /**
     * Gets the value of the countryofIssuance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryofIssuance() {
        return countryofIssuance;
    }

    /**
     * Sets the value of the countryofIssuance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryofIssuance(String value) {
        this.countryofIssuance = value;
    }

    /**
     * Gets the value of the inBundleId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInBundleId() {
        return inBundleId;
    }

    /**
     * Sets the value of the inBundleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInBundleId(String value) {
        this.inBundleId = value;
    }

    /**
     * Gets the value of the inGBAppPrincName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInGBAppPrincName() {
        return inGBAppPrincName;
    }

    /**
     * Sets the value of the inGBAppPrincName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInGBAppPrincName(String value) {
        this.inGBAppPrincName = value;
    }

    /**
     * Gets the value of the inGBBenObligName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInGBBenObligName() {
        return inGBBenObligName;
    }

    /**
     * Sets the value of the inGBBenObligName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInGBBenObligName(String value) {
        this.inGBBenObligName = value;
    }

    /**
     * Gets the value of the inGBBenObligCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInGBBenObligCountry() {
        return inGBBenObligCountry;
    }

    /**
     * Sets the value of the inGBBenObligCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInGBBenObligCountry(String value) {
        this.inGBBenObligCountry = value;
    }

    /**
     * Gets the value of the inGBInstType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInGBInstType() {
        return inGBInstType;
    }

    /**
     * Sets the value of the inGBInstType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInGBInstType(String value) {
        this.inGBInstType = value;
    }

    /**
     * Gets the value of the inGBInstPurp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInGBInstPurp() {
        return inGBInstPurp;
    }

    /**
     * Sets the value of the inGBInstPurp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInGBInstPurp(String value) {
        this.inGBInstPurp = value;
    }

    /**
     * Gets the value of the inGBGoldId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInGBGoldId() {
        return inGBGoldId;
    }

    /**
     * Sets the value of the inGBGoldId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInGBGoldId(String value) {
        this.inGBGoldId = value;
    }

    /**
     * Gets the value of the inGBSiteCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInGBSiteCode() {
        return inGBSiteCode;
    }

    /**
     * Sets the value of the inGBSiteCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInGBSiteCode(String value) {
        this.inGBSiteCode = value;
    }

    /**
     * Gets the value of the inGBGEAppRef1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInGBGEAppRef1() {
        return inGBGEAppRef1;
    }

    /**
     * Sets the value of the inGBGEAppRef1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInGBGEAppRef1(String value) {
        this.inGBGEAppRef1 = value;
    }

    /**
     * Gets the value of the inGBBenRef1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInGBBenRef1() {
        return inGBBenRef1;
    }

    /**
     * Sets the value of the inGBBenRef1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInGBBenRef1(String value) {
        this.inGBBenRef1 = value;
    }

    /**
     * Gets the value of the inGBCountryOfIssue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInGBCountryOfIssue() {
        return inGBCountryOfIssue;
    }

    /**
     * Sets the value of the inGBCountryOfIssue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInGBCountryOfIssue(String value) {
        this.inGBCountryOfIssue = value;
    }

    /**
     * Gets the value of the inGBBundleId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInGBBundleId() {
        return inGBBundleId;
    }

    /**
     * Sets the value of the inGBBundleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInGBBundleId(String value) {
        this.inGBBundleId = value;
    }

    /**
     * Gets the value of the inAgingMonths property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInAgingMonths() {
        return inAgingMonths;
    }

    /**
     * Sets the value of the inAgingMonths property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInAgingMonths(String value) {
        this.inAgingMonths = value;
    }

    /**
     * Gets the value of the agingUserSSO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgingUserSSO() {
        return agingUserSSO;
    }

    /**
     * Sets the value of the agingUserSSO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgingUserSSO(String value) {
        this.agingUserSSO = value;
    }

    /**
     * Gets the value of the incrementalNumOfMonths property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncrementalNumOfMonths() {
        return incrementalNumOfMonths;
    }

    /**
     * Sets the value of the incrementalNumOfMonths property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncrementalNumOfMonths(String value) {
        this.incrementalNumOfMonths = value;
    }

    /**
     * Gets the value of the alocRecord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getALOCRecord() {
        return alocRecord;
    }

    /**
     * Sets the value of the alocRecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setALOCRecord(String value) {
        this.alocRecord = value;
    }

    /**
     * Gets the value of the siteIDs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the siteIDs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSiteIDs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSiteIDs() {
        if (siteIDs == null) {
            siteIDs = new ArrayList<String>();
        }
        return this.siteIDs;
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
     * Gets the value of the issuer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * Sets the value of the issuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuer(String value) {
        this.issuer = value;
    }

    /**
     * Gets the value of the beneficiaryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    /**
     * Sets the value of the beneficiaryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryName(String value) {
        this.beneficiaryName = value;
    }

    /**
     * Gets the value of the beneCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneCountry() {
        return beneCountry;
    }

    /**
     * Sets the value of the beneCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneCountry(String value) {
        this.beneCountry = value;
    }

    /**
     * Gets the value of the issuanceDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuanceDate() {
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
    public void setIssuanceDate(String value) {
        this.issuanceDate = value;
    }

    /**
     * Gets the value of the instrumentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrumentAmount() {
        return instrumentAmount;
    }

    /**
     * Sets the value of the instrumentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrumentAmount(String value) {
        this.instrumentAmount = value;
    }

    /**
     * Gets the value of the instrumentCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrumentCurrency() {
        return instrumentCurrency;
    }

    /**
     * Sets the value of the instrumentCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrumentCurrency(String value) {
        this.instrumentCurrency = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpirationDate(String value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the origEconExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigEconExpirationDate() {
        return origEconExpirationDate;
    }

    /**
     * Sets the value of the origEconExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigEconExpirationDate(String value) {
        this.origEconExpirationDate = value;
    }

    /**
     * Gets the value of the maxAgingMonths property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxAgingMonths() {
        return maxAgingMonths;
    }

    /**
     * Sets the value of the maxAgingMonths property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxAgingMonths(String value) {
        this.maxAgingMonths = value;
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

    public AgingDetails withApplicantPrincipalName(String value) {
        setApplicantPrincipalName(value);
        return this;
    }

    public AgingDetails withBeneficiaryObligee(String value) {
        setBeneficiaryObligee(value);
        return this;
    }

    public AgingDetails withBeneficiaryObligeeCountry(String value) {
        setBeneficiaryObligeeCountry(value);
        return this;
    }

    public AgingDetails withInstrumentType(String value) {
        setInstrumentType(value);
        return this;
    }

    public AgingDetails withInstrumentPurpose(String value) {
        setInstrumentPurpose(value);
        return this;
    }

    public AgingDetails withGoldID(String value) {
        setGoldID(value);
        return this;
    }

    public AgingDetails withGEApplicantReference1(String value) {
        setGEApplicantReference1(value);
        return this;
    }

    public AgingDetails withBeneficiaryReference1(String value) {
        setBeneficiaryReference1(value);
        return this;
    }

    public AgingDetails withCountryofIssuance(String value) {
        setCountryofIssuance(value);
        return this;
    }

    public AgingDetails withInBundleId(String value) {
        setInBundleId(value);
        return this;
    }

    public AgingDetails withInGBAppPrincName(String value) {
        setInGBAppPrincName(value);
        return this;
    }

    public AgingDetails withInGBBenObligName(String value) {
        setInGBBenObligName(value);
        return this;
    }

    public AgingDetails withInGBBenObligCountry(String value) {
        setInGBBenObligCountry(value);
        return this;
    }

    public AgingDetails withInGBInstType(String value) {
        setInGBInstType(value);
        return this;
    }

    public AgingDetails withInGBInstPurp(String value) {
        setInGBInstPurp(value);
        return this;
    }

    public AgingDetails withInGBGoldId(String value) {
        setInGBGoldId(value);
        return this;
    }

    public AgingDetails withInGBSiteCode(String value) {
        setInGBSiteCode(value);
        return this;
    }

    public AgingDetails withInGBGEAppRef1(String value) {
        setInGBGEAppRef1(value);
        return this;
    }

    public AgingDetails withInGBBenRef1(String value) {
        setInGBBenRef1(value);
        return this;
    }

    public AgingDetails withInGBCountryOfIssue(String value) {
        setInGBCountryOfIssue(value);
        return this;
    }

    public AgingDetails withInGBBundleId(String value) {
        setInGBBundleId(value);
        return this;
    }

    public AgingDetails withInAgingMonths(String value) {
        setInAgingMonths(value);
        return this;
    }

    public AgingDetails withAgingUserSSO(String value) {
        setAgingUserSSO(value);
        return this;
    }

    public AgingDetails withIncrementalNumOfMonths(String value) {
        setIncrementalNumOfMonths(value);
        return this;
    }

    public AgingDetails withALOCRecord(String value) {
        setALOCRecord(value);
        return this;
    }

    public AgingDetails withSiteIDs(String... values) {
        if (values!= null) {
            for (String value: values) {
                getSiteIDs().add(value);
            }
        }
        return this;
    }

    public AgingDetails withSiteIDs(Collection<String> values) {
        if (values!= null) {
            getSiteIDs().addAll(values);
        }
        return this;
    }

    public AgingDetails withApplicantName(String value) {
        setApplicantName(value);
        return this;
    }

    public AgingDetails withIssuer(String value) {
        setIssuer(value);
        return this;
    }

    public AgingDetails withBeneficiaryName(String value) {
        setBeneficiaryName(value);
        return this;
    }

    public AgingDetails withBeneCountry(String value) {
        setBeneCountry(value);
        return this;
    }

    public AgingDetails withIssuanceDate(String value) {
        setIssuanceDate(value);
        return this;
    }

    public AgingDetails withInstrumentAmount(String value) {
        setInstrumentAmount(value);
        return this;
    }

    public AgingDetails withInstrumentCurrency(String value) {
        setInstrumentCurrency(value);
        return this;
    }

    public AgingDetails withExpirationDate(String value) {
        setExpirationDate(value);
        return this;
    }

    public AgingDetails withOrigEconExpirationDate(String value) {
        setOrigEconExpirationDate(value);
        return this;
    }

    public AgingDetails withMaxAgingMonths(String value) {
        setMaxAgingMonths(value);
        return this;
    }

    public AgingDetails withRequestorName(String value) {
        setRequestorName(value);
        return this;
    }

    public AgingDetails withRequestorSso(String value) {
        setRequestorSso(value);
        return this;
    }

    /**
     * Sets the value of the siteIDs property.
     * 
     * @param siteIDs
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteIDs(List<String> siteIDs) {
        this.siteIDs = siteIDs;
    }

}
