//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.05 at 05:52:19 PM IST 
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
 *         &lt;element name="Bank_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bank_MDM_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Request_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Site_Prefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bank_Reference_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BUC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BUC_ADN_Error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fee_Calc_Period_Start_Dt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Fee_Calc_Period_End_Dt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Payment_Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="USD_Equival" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Payment_Amount_String" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="USD_Equival_String" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Period_Amendments" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Total_Amendments" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
    "bankName",
    "bankMDMId",
    "requestId",
    "sitePrefix",
    "bankReferenceNumber",
    "buc",
    "adn",
    "bucadnError",
    "feeCalcPeriodStartDt",
    "feeCalcPeriodEndDt",
    "paymentAmount",
    "usdEquival",
    "paymentAmountString",
    "usdEquivalString",
    "periodAmendments",
    "totalAmendments",
    "alocRecordId"
})
@XmlRootElement(name = "RequestFeeDetails", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
public class RequestFeeDetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Bank_Name", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected String bankName;
    @XmlElement(name = "Bank_MDM_Id", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected String bankMDMId;
    @XmlElement(name = "Request_Id", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected BigInteger requestId;
    @XmlElement(name = "Site_Prefix", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected String sitePrefix;
    @XmlElement(name = "Bank_Reference_Number", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected String bankReferenceNumber;
    @XmlElement(name = "BUC", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected String buc;
    @XmlElement(name = "ADN", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected String adn;
    @XmlElement(name = "BUC_ADN_Error", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected String bucadnError;
    @XmlElement(name = "Fee_Calc_Period_Start_Dt", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar feeCalcPeriodStartDt;
    @XmlElement(name = "Fee_Calc_Period_End_Dt", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar feeCalcPeriodEndDt;
    @XmlElement(name = "Payment_Amount", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected BigDecimal paymentAmount;
    @XmlElement(name = "USD_Equival", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected BigDecimal usdEquival;
    @XmlElement(name = "Payment_Amount_String", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected String paymentAmountString;
    @XmlElement(name = "USD_Equival_String", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected String usdEquivalString;
    @XmlElement(name = "Period_Amendments", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected BigInteger periodAmendments;
    @XmlElement(name = "Total_Amendments", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected BigInteger totalAmendments;
    @XmlElement(name = "Aloc_Record_Id", namespace = "http://treasury.ge.com/schemas/ALOC/APM/RequestFeeDetails.xsd")
    protected String alocRecordId;

    /**
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * Gets the value of the bankMDMId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankMDMId() {
        return bankMDMId;
    }

    /**
     * Sets the value of the bankMDMId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankMDMId(String value) {
        this.bankMDMId = value;
    }

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
     * Gets the value of the bucadnError property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUCADNError() {
        return bucadnError;
    }

    /**
     * Sets the value of the bucadnError property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUCADNError(String value) {
        this.bucadnError = value;
    }

    /**
     * Gets the value of the feeCalcPeriodStartDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getFeeCalcPeriodStartDt() {
        return feeCalcPeriodStartDt;
    }

    /**
     * Sets the value of the feeCalcPeriodStartDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCalcPeriodStartDt(Calendar value) {
        this.feeCalcPeriodStartDt = value;
    }

    /**
     * Gets the value of the feeCalcPeriodEndDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getFeeCalcPeriodEndDt() {
        return feeCalcPeriodEndDt;
    }

    /**
     * Sets the value of the feeCalcPeriodEndDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeCalcPeriodEndDt(Calendar value) {
        this.feeCalcPeriodEndDt = value;
    }

    /**
     * Gets the value of the paymentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Sets the value of the paymentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPaymentAmount(BigDecimal value) {
        this.paymentAmount = value;
    }

    /**
     * Gets the value of the usdEquival property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUSDEquival() {
        return usdEquival;
    }

    /**
     * Sets the value of the usdEquival property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUSDEquival(BigDecimal value) {
        this.usdEquival = value;
    }

    /**
     * Gets the value of the paymentAmountString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentAmountString() {
        return paymentAmountString;
    }

    /**
     * Sets the value of the paymentAmountString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentAmountString(String value) {
        this.paymentAmountString = value;
    }

    /**
     * Gets the value of the usdEquivalString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSDEquivalString() {
        return usdEquivalString;
    }

    /**
     * Sets the value of the usdEquivalString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSDEquivalString(String value) {
        this.usdEquivalString = value;
    }

    /**
     * Gets the value of the periodAmendments property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPeriodAmendments() {
        return periodAmendments;
    }

    /**
     * Sets the value of the periodAmendments property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPeriodAmendments(BigInteger value) {
        this.periodAmendments = value;
    }

    /**
     * Gets the value of the totalAmendments property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalAmendments() {
        return totalAmendments;
    }

    /**
     * Sets the value of the totalAmendments property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalAmendments(BigInteger value) {
        this.totalAmendments = value;
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

    public RequestFeeDetails withBankName(String value) {
        setBankName(value);
        return this;
    }

    public RequestFeeDetails withBankMDMId(String value) {
        setBankMDMId(value);
        return this;
    }

    public RequestFeeDetails withRequestId(BigInteger value) {
        setRequestId(value);
        return this;
    }

    public RequestFeeDetails withSitePrefix(String value) {
        setSitePrefix(value);
        return this;
    }

    public RequestFeeDetails withBankReferenceNumber(String value) {
        setBankReferenceNumber(value);
        return this;
    }

    public RequestFeeDetails withBUC(String value) {
        setBUC(value);
        return this;
    }

    public RequestFeeDetails withADN(String value) {
        setADN(value);
        return this;
    }

    public RequestFeeDetails withBUCADNError(String value) {
        setBUCADNError(value);
        return this;
    }

    public RequestFeeDetails withFeeCalcPeriodStartDt(Calendar value) {
        setFeeCalcPeriodStartDt(value);
        return this;
    }

    public RequestFeeDetails withFeeCalcPeriodEndDt(Calendar value) {
        setFeeCalcPeriodEndDt(value);
        return this;
    }

    public RequestFeeDetails withPaymentAmount(BigDecimal value) {
        setPaymentAmount(value);
        return this;
    }

    public RequestFeeDetails withUSDEquival(BigDecimal value) {
        setUSDEquival(value);
        return this;
    }

    public RequestFeeDetails withPaymentAmountString(String value) {
        setPaymentAmountString(value);
        return this;
    }

    public RequestFeeDetails withUSDEquivalString(String value) {
        setUSDEquivalString(value);
        return this;
    }

    public RequestFeeDetails withPeriodAmendments(BigInteger value) {
        setPeriodAmendments(value);
        return this;
    }

    public RequestFeeDetails withTotalAmendments(BigInteger value) {
        setTotalAmendments(value);
        return this;
    }

    public RequestFeeDetails withAlocRecordId(String value) {
        setAlocRecordId(value);
        return this;
    }

}