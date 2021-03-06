//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.06 at 01:04:51 PM IST 
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
 *         &lt;element name="ALOC_Record_Number" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Aloc_Record_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amendment_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Site_Prefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Issuing_Bank_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bank_Reference_Num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer_Beneficiary_Address" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd}AddressDtls" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Instrument_Currency_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Payment_Currency_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Payment_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Issuance_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Expiration_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Bank_Site_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Initiater_Contact_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Period_Start_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Period_End_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Foreign_Fees" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="US_Fees" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Other_Fees" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Total_Fees" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BUC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LE_Gold_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LE_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GE_Contact_Person_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QuarterOfYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="US_Expiration_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="US_Period_Start_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="US_Period_End_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Foreign_Period_Start_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Foreign_Period_End_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Other_Period_Start_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Other_Period_End_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
    "alocRecordNumber",
    "alocRecordId",
    "amendmentId",
    "sitePrefix",
    "issuingBankName",
    "bankReferenceNum",
    "customerBeneficiaryAddress",
    "instrumentCurrencyCode",
    "paymentCurrencyCode",
    "paymentDate",
    "issuanceDate",
    "expirationDate",
    "bankSiteName",
    "initiaterContactName",
    "instrumentAmount",
    "periodStartDate",
    "periodEndDate",
    "foreignFees",
    "usFees",
    "otherFees",
    "totalFees",
    "buc",
    "adn",
    "leGoldID",
    "leName",
    "geContactPersonName",
    "quarterOfYear",
    "usExpirationDate",
    "usPeriodStartDate",
    "usPeriodEndDate",
    "foreignPeriodStartDate",
    "foreignPeriodEndDate",
    "otherPeriodStartDate",
    "otherPeriodEndDate"
})
@XmlRootElement(name = "InvoiceDetails", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
public class InvoiceDetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ALOC_Record_Number", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected BigInteger alocRecordNumber;
    @XmlElement(name = "Aloc_Record_Id", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String alocRecordId;
    @XmlElement(name = "Amendment_Id", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String amendmentId;
    @XmlElement(name = "Site_Prefix", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String sitePrefix;
    @XmlElement(name = "Issuing_Bank_Name", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String issuingBankName;
    @XmlElement(name = "Bank_Reference_Num", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String bankReferenceNum;
    @XmlElement(name = "Customer_Beneficiary_Address", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected InvoiceDetails.CustomerBeneficiaryAddress customerBeneficiaryAddress;
    @XmlElement(name = "Instrument_Currency_Code", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String instrumentCurrencyCode;
    @XmlElement(name = "Payment_Currency_Code", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String paymentCurrencyCode;
    @XmlElement(name = "Payment_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar paymentDate;
    @XmlElement(name = "Issuance_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar issuanceDate;
    @XmlElement(name = "Expiration_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar expirationDate;
    @XmlElement(name = "Bank_Site_Name", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String bankSiteName;
    @XmlElement(name = "Initiater_Contact_Name", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String initiaterContactName;
    @XmlElement(name = "Instrument_Amount", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected BigDecimal instrumentAmount;
    @XmlElement(name = "Period_Start_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar periodStartDate;
    @XmlElement(name = "Period_End_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar periodEndDate;
    @XmlElement(name = "Foreign_Fees", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected BigDecimal foreignFees;
    @XmlElement(name = "US_Fees", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected BigDecimal usFees;
    @XmlElement(name = "Other_Fees", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected BigDecimal otherFees;
    @XmlElement(name = "Total_Fees", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected BigDecimal totalFees;
    @XmlElement(name = "BUC", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String buc;
    @XmlElement(name = "ADN", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String adn;
    @XmlElement(name = "LE_Gold_ID", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String leGoldID;
    @XmlElement(name = "LE_Name", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String leName;
    @XmlElement(name = "GE_Contact_Person_Name", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String geContactPersonName;
    @XmlElement(name = "QuarterOfYear", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd")
    protected String quarterOfYear;
    @XmlElement(name = "US_Expiration_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar usExpirationDate;
    @XmlElement(name = "US_Period_Start_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar usPeriodStartDate;
    @XmlElement(name = "US_Period_End_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar usPeriodEndDate;
    @XmlElement(name = "Foreign_Period_Start_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar foreignPeriodStartDate;
    @XmlElement(name = "Foreign_Period_End_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar foreignPeriodEndDate;
    @XmlElement(name = "Other_Period_Start_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar otherPeriodStartDate;
    @XmlElement(name = "Other_Period_End_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/InvoiceDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar otherPeriodEndDate;

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
     * Gets the value of the issuingBankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuingBankName() {
        return issuingBankName;
    }

    /**
     * Sets the value of the issuingBankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuingBankName(String value) {
        this.issuingBankName = value;
    }

    /**
     * Gets the value of the bankReferenceNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankReferenceNum() {
        return bankReferenceNum;
    }

    /**
     * Sets the value of the bankReferenceNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankReferenceNum(String value) {
        this.bankReferenceNum = value;
    }

    /**
     * Gets the value of the customerBeneficiaryAddress property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceDetails.CustomerBeneficiaryAddress }
     *     
     */
    public InvoiceDetails.CustomerBeneficiaryAddress getCustomerBeneficiaryAddress() {
        return customerBeneficiaryAddress;
    }

    /**
     * Sets the value of the customerBeneficiaryAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceDetails.CustomerBeneficiaryAddress }
     *     
     */
    public void setCustomerBeneficiaryAddress(InvoiceDetails.CustomerBeneficiaryAddress value) {
        this.customerBeneficiaryAddress = value;
    }

    /**
     * Gets the value of the instrumentCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrumentCurrencyCode() {
        return instrumentCurrencyCode;
    }

    /**
     * Sets the value of the instrumentCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrumentCurrencyCode(String value) {
        this.instrumentCurrencyCode = value;
    }

    /**
     * Gets the value of the paymentCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentCurrencyCode() {
        return paymentCurrencyCode;
    }

    /**
     * Sets the value of the paymentCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentCurrencyCode(String value) {
        this.paymentCurrencyCode = value;
    }

    /**
     * Gets the value of the paymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the value of the paymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDate(Calendar value) {
        this.paymentDate = value;
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
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getExpirationDate() {
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
    public void setExpirationDate(Calendar value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the bankSiteName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankSiteName() {
        return bankSiteName;
    }

    /**
     * Sets the value of the bankSiteName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankSiteName(String value) {
        this.bankSiteName = value;
    }

    /**
     * Gets the value of the initiaterContactName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitiaterContactName() {
        return initiaterContactName;
    }

    /**
     * Sets the value of the initiaterContactName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitiaterContactName(String value) {
        this.initiaterContactName = value;
    }

    /**
     * Gets the value of the instrumentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInstrumentAmount() {
        return instrumentAmount;
    }

    /**
     * Sets the value of the instrumentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInstrumentAmount(BigDecimal value) {
        this.instrumentAmount = value;
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
     * Gets the value of the foreignFees property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getForeignFees() {
        return foreignFees;
    }

    /**
     * Sets the value of the foreignFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setForeignFees(BigDecimal value) {
        this.foreignFees = value;
    }

    /**
     * Gets the value of the usFees property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUSFees() {
        return usFees;
    }

    /**
     * Sets the value of the usFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUSFees(BigDecimal value) {
        this.usFees = value;
    }

    /**
     * Gets the value of the otherFees property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOtherFees() {
        return otherFees;
    }

    /**
     * Sets the value of the otherFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOtherFees(BigDecimal value) {
        this.otherFees = value;
    }

    /**
     * Gets the value of the totalFees property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalFees() {
        return totalFees;
    }

    /**
     * Sets the value of the totalFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalFees(BigDecimal value) {
        this.totalFees = value;
    }

    /**
     * Gets the value of the buc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUC() {
        return buc;
    }

    /**
     * Sets the value of the buc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUC(String value) {
        this.buc = value;
    }

    /**
     * Gets the value of the adn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADN() {
        return adn;
    }

    /**
     * Sets the value of the adn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADN(String value) {
        this.adn = value;
    }

    /**
     * Gets the value of the leGoldID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLEGoldID() {
        return leGoldID;
    }

    /**
     * Sets the value of the leGoldID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLEGoldID(String value) {
        this.leGoldID = value;
    }

    /**
     * Gets the value of the leName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLEName() {
        return leName;
    }

    /**
     * Sets the value of the leName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLEName(String value) {
        this.leName = value;
    }

    /**
     * Gets the value of the geContactPersonName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGEContactPersonName() {
        return geContactPersonName;
    }

    /**
     * Sets the value of the geContactPersonName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGEContactPersonName(String value) {
        this.geContactPersonName = value;
    }

    /**
     * Gets the value of the quarterOfYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuarterOfYear() {
        return quarterOfYear;
    }

    /**
     * Sets the value of the quarterOfYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuarterOfYear(String value) {
        this.quarterOfYear = value;
    }

    /**
     * Gets the value of the usExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getUSExpirationDate() {
        return usExpirationDate;
    }

    /**
     * Sets the value of the usExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSExpirationDate(Calendar value) {
        this.usExpirationDate = value;
    }

    /**
     * Gets the value of the usPeriodStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getUSPeriodStartDate() {
        return usPeriodStartDate;
    }

    /**
     * Sets the value of the usPeriodStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSPeriodStartDate(Calendar value) {
        this.usPeriodStartDate = value;
    }

    /**
     * Gets the value of the usPeriodEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getUSPeriodEndDate() {
        return usPeriodEndDate;
    }

    /**
     * Sets the value of the usPeriodEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSPeriodEndDate(Calendar value) {
        this.usPeriodEndDate = value;
    }

    /**
     * Gets the value of the foreignPeriodStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getForeignPeriodStartDate() {
        return foreignPeriodStartDate;
    }

    /**
     * Sets the value of the foreignPeriodStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignPeriodStartDate(Calendar value) {
        this.foreignPeriodStartDate = value;
    }

    /**
     * Gets the value of the foreignPeriodEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getForeignPeriodEndDate() {
        return foreignPeriodEndDate;
    }

    /**
     * Sets the value of the foreignPeriodEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignPeriodEndDate(Calendar value) {
        this.foreignPeriodEndDate = value;
    }

    /**
     * Gets the value of the otherPeriodStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getOtherPeriodStartDate() {
        return otherPeriodStartDate;
    }

    /**
     * Sets the value of the otherPeriodStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherPeriodStartDate(Calendar value) {
        this.otherPeriodStartDate = value;
    }

    /**
     * Gets the value of the otherPeriodEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getOtherPeriodEndDate() {
        return otherPeriodEndDate;
    }

    /**
     * Sets the value of the otherPeriodEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherPeriodEndDate(Calendar value) {
        this.otherPeriodEndDate = value;
    }

    public InvoiceDetails withALOCRecordNumber(BigInteger value) {
        setALOCRecordNumber(value);
        return this;
    }

    public InvoiceDetails withAlocRecordId(String value) {
        setAlocRecordId(value);
        return this;
    }

    public InvoiceDetails withAmendmentId(String value) {
        setAmendmentId(value);
        return this;
    }

    public InvoiceDetails withSitePrefix(String value) {
        setSitePrefix(value);
        return this;
    }

    public InvoiceDetails withIssuingBankName(String value) {
        setIssuingBankName(value);
        return this;
    }

    public InvoiceDetails withBankReferenceNum(String value) {
        setBankReferenceNum(value);
        return this;
    }

    public InvoiceDetails withCustomerBeneficiaryAddress(InvoiceDetails.CustomerBeneficiaryAddress value) {
        setCustomerBeneficiaryAddress(value);
        return this;
    }

    public InvoiceDetails withInstrumentCurrencyCode(String value) {
        setInstrumentCurrencyCode(value);
        return this;
    }

    public InvoiceDetails withPaymentCurrencyCode(String value) {
        setPaymentCurrencyCode(value);
        return this;
    }

    public InvoiceDetails withPaymentDate(Calendar value) {
        setPaymentDate(value);
        return this;
    }

    public InvoiceDetails withIssuanceDate(Calendar value) {
        setIssuanceDate(value);
        return this;
    }

    public InvoiceDetails withExpirationDate(Calendar value) {
        setExpirationDate(value);
        return this;
    }

    public InvoiceDetails withBankSiteName(String value) {
        setBankSiteName(value);
        return this;
    }

    public InvoiceDetails withInitiaterContactName(String value) {
        setInitiaterContactName(value);
        return this;
    }

    public InvoiceDetails withInstrumentAmount(BigDecimal value) {
        setInstrumentAmount(value);
        return this;
    }

    public InvoiceDetails withPeriodStartDate(Calendar value) {
        setPeriodStartDate(value);
        return this;
    }

    public InvoiceDetails withPeriodEndDate(Calendar value) {
        setPeriodEndDate(value);
        return this;
    }

    public InvoiceDetails withForeignFees(BigDecimal value) {
        setForeignFees(value);
        return this;
    }

    public InvoiceDetails withUSFees(BigDecimal value) {
        setUSFees(value);
        return this;
    }

    public InvoiceDetails withOtherFees(BigDecimal value) {
        setOtherFees(value);
        return this;
    }

    public InvoiceDetails withTotalFees(BigDecimal value) {
        setTotalFees(value);
        return this;
    }

    public InvoiceDetails withBUC(String value) {
        setBUC(value);
        return this;
    }

    public InvoiceDetails withADN(String value) {
        setADN(value);
        return this;
    }

    public InvoiceDetails withLEGoldID(String value) {
        setLEGoldID(value);
        return this;
    }

    public InvoiceDetails withLEName(String value) {
        setLEName(value);
        return this;
    }

    public InvoiceDetails withGEContactPersonName(String value) {
        setGEContactPersonName(value);
        return this;
    }

    public InvoiceDetails withQuarterOfYear(String value) {
        setQuarterOfYear(value);
        return this;
    }

    public InvoiceDetails withUSExpirationDate(Calendar value) {
        setUSExpirationDate(value);
        return this;
    }

    public InvoiceDetails withUSPeriodStartDate(Calendar value) {
        setUSPeriodStartDate(value);
        return this;
    }

    public InvoiceDetails withUSPeriodEndDate(Calendar value) {
        setUSPeriodEndDate(value);
        return this;
    }

    public InvoiceDetails withForeignPeriodStartDate(Calendar value) {
        setForeignPeriodStartDate(value);
        return this;
    }

    public InvoiceDetails withForeignPeriodEndDate(Calendar value) {
        setForeignPeriodEndDate(value);
        return this;
    }

    public InvoiceDetails withOtherPeriodStartDate(Calendar value) {
        setOtherPeriodStartDate(value);
        return this;
    }

    public InvoiceDetails withOtherPeriodEndDate(Calendar value) {
        setOtherPeriodEndDate(value);
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
     *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd}AddressDtls" minOccurs="0"/>
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
        "addressDtls"
    })
    public static class CustomerBeneficiaryAddress
        extends JAXBObjectSecureSerializer
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        @XmlElement(name = "AddressDtls", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
        protected AddressDtls addressDtls;

        /**
         * Gets the value of the addressDtls property.
         * 
         * @return
         *     possible object is
         *     {@link AddressDtls }
         *     
         */
        public AddressDtls getAddressDtls() {
            return addressDtls;
        }

        /**
         * Sets the value of the addressDtls property.
         * 
         * @param value
         *     allowed object is
         *     {@link AddressDtls }
         *     
         */
        public void setAddressDtls(AddressDtls value) {
            this.addressDtls = value;
        }

        public InvoiceDetails.CustomerBeneficiaryAddress withAddressDtls(AddressDtls value) {
            setAddressDtls(value);
            return this;
        }

    }

}
