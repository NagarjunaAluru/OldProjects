//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.05 at 05:52:19 PM IST 
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
 *         &lt;element name="Request_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Amendment_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Site_Prefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Applicant" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://treasury.ge.com/schemas/ALOC/UserDetails.xsd}UserDetails" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Winning_Bank_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bank_Reference_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FTRN_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Aloc_Record_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "requestId",
    "amendmentId",
    "sitePrefix",
    "applicant",
    "winningBankName",
    "bankReferenceNumber",
    "ftrnNumber",
    "alocRecordId"
})
@XmlRootElement(name = "FeeRequestSummary", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeeRequestSummary.xsd")
public class FeeRequestSummary
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Request_Id", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeeRequestSummary.xsd")
    protected BigInteger requestId;
    @XmlElement(name = "Amendment_Id", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeeRequestSummary.xsd")
    protected String amendmentId;
    @XmlElement(name = "Site_Prefix", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeeRequestSummary.xsd")
    protected String sitePrefix;
    @XmlElement(name = "Applicant", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeeRequestSummary.xsd")
    protected FeeRequestSummary.Applicant applicant;
    @XmlElement(name = "Winning_Bank_Name", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeeRequestSummary.xsd")
    protected String winningBankName;
    @XmlElement(name = "Bank_Reference_Number", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeeRequestSummary.xsd")
    protected String bankReferenceNumber;
    @XmlElement(name = "FTRN_Number", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeeRequestSummary.xsd")
    protected String ftrnNumber;
    @XmlElement(name = "Aloc_Record_Id", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeeRequestSummary.xsd")
    protected String alocRecordId;

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRequestId(BigInteger value) {
        this.requestId = value;
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
     * Gets the value of the applicant property.
     * 
     * @return
     *     possible object is
     *     {@link FeeRequestSummary.Applicant }
     *     
     */
    public FeeRequestSummary.Applicant getApplicant() {
        return applicant;
    }

    /**
     * Sets the value of the applicant property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeeRequestSummary.Applicant }
     *     
     */
    public void setApplicant(FeeRequestSummary.Applicant value) {
        this.applicant = value;
    }

    /**
     * Gets the value of the winningBankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWinningBankName() {
        return winningBankName;
    }

    /**
     * Sets the value of the winningBankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWinningBankName(String value) {
        this.winningBankName = value;
    }

    /**
     * Gets the value of the bankReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankReferenceNumber() {
        return bankReferenceNumber;
    }

    /**
     * Sets the value of the bankReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankReferenceNumber(String value) {
        this.bankReferenceNumber = value;
    }

    /**
     * Gets the value of the ftrnNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFTRNNumber() {
        return ftrnNumber;
    }

    /**
     * Sets the value of the ftrnNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFTRNNumber(String value) {
        this.ftrnNumber = value;
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

    public FeeRequestSummary withRequestId(BigInteger value) {
        setRequestId(value);
        return this;
    }

    public FeeRequestSummary withAmendmentId(String value) {
        setAmendmentId(value);
        return this;
    }

    public FeeRequestSummary withSitePrefix(String value) {
        setSitePrefix(value);
        return this;
    }

    public FeeRequestSummary withApplicant(FeeRequestSummary.Applicant value) {
        setApplicant(value);
        return this;
    }

    public FeeRequestSummary withWinningBankName(String value) {
        setWinningBankName(value);
        return this;
    }

    public FeeRequestSummary withBankReferenceNumber(String value) {
        setBankReferenceNumber(value);
        return this;
    }

    public FeeRequestSummary withFTRNNumber(String value) {
        setFTRNNumber(value);
        return this;
    }

    public FeeRequestSummary withAlocRecordId(String value) {
        setAlocRecordId(value);
        return this;
    }


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
     *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/UserDetails.xsd}UserDetails" minOccurs="0"/>
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
        "userDetails"
    })
    public static class Applicant
        extends JAXBObjectSecureSerializer
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        @XmlElement(name = "UserDetails", namespace = "http://treasury.ge.com/schemas/ALOC/UserDetails.xsd")
        protected UserDetails userDetails;

        /**
         * Gets the value of the userDetails property.
         * 
         * @return
         *     possible object is
         *     {@link UserDetails }
         *     
         */
        public UserDetails getUserDetails() {
            return userDetails;
        }

        /**
         * Sets the value of the userDetails property.
         * 
         * @param value
         *     allowed object is
         *     {@link UserDetails }
         *     
         */
        public void setUserDetails(UserDetails value) {
            this.userDetails = value;
        }

        public FeeRequestSummary.Applicant withUserDetails(UserDetails value) {
            setUserDetails(value);
            return this;
        }

    }

}
