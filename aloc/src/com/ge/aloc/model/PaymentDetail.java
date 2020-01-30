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
 *         &lt;element name="Op_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Payment_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ALOC_Record_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bank_Reference_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GE_Applicant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tri_Party_Applicant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Beneficiary_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Payment_Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Payment_Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Payment_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="USD_Payment_Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="US_Fee_Total" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Foreign_Fee_Total" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Period_Fee_Credits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Period_Amendment_Fees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Other_Fees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="One_Time_Fees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Model_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "opCode",
    "paymentId",
    "alocRecordNumber",
    "bankReferenceNumber",
    "geApplicant",
    "triPartyApplicant",
    "beneficiaryName",
    "paymentCurrency",
    "paymentAmount",
    "paymentDate",
    "usdPaymentAmount",
    "usFeeTotal",
    "foreignFeeTotal",
    "periodFeeCredits",
    "periodAmendmentFees",
    "otherFees",
    "oneTimeFees",
    "modelID"
})
@XmlRootElement(name = "Payment_Detail", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
public class PaymentDetail
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Op_Code", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String opCode;
    @XmlElement(name = "Payment_Id", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String paymentId;
    @XmlElement(name = "ALOC_Record_Number", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String alocRecordNumber;
    @XmlElement(name = "Bank_Reference_Number", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String bankReferenceNumber;
    @XmlElement(name = "GE_Applicant", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String geApplicant;
    @XmlElement(name = "Tri_Party_Applicant", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String triPartyApplicant;
    @XmlElement(name = "Beneficiary_Name", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String beneficiaryName;
    @XmlElement(name = "Payment_Currency", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String paymentCurrency;
    @XmlElement(name = "Payment_Amount", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String paymentAmount;
    @XmlElement(name = "Payment_Date", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String paymentDate;
    @XmlElement(name = "USD_Payment_Amount", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String usdPaymentAmount;
    @XmlElement(name = "US_Fee_Total", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String usFeeTotal;
    @XmlElement(name = "Foreign_Fee_Total", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String foreignFeeTotal;
    @XmlElement(name = "Period_Fee_Credits", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String periodFeeCredits;
    @XmlElement(name = "Period_Amendment_Fees", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String periodAmendmentFees;
    @XmlElement(name = "Other_Fees", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String otherFees;
    @XmlElement(name = "One_Time_Fees", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String oneTimeFees;
    @XmlElement(name = "Model_ID", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/PaymentDetail.xsd")
    protected String modelID;

    /**
     * Gets the value of the opCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpCode() {
        return opCode;
    }

    /**
     * Sets the value of the opCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpCode(String value) {
        this.opCode = value;
    }

    /**
     * Gets the value of the paymentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Sets the value of the paymentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentId(String value) {
        this.paymentId = value;
    }

    /**
     * Gets the value of the alocRecordNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getALOCRecordNumber() {
        return alocRecordNumber;
    }

    /**
     * Sets the value of the alocRecordNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setALOCRecordNumber(String value) {
        this.alocRecordNumber = value;
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
     * Gets the value of the geApplicant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGEApplicant() {
        return geApplicant;
    }

    /**
     * Sets the value of the geApplicant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGEApplicant(String value) {
        this.geApplicant = value;
    }

    /**
     * Gets the value of the triPartyApplicant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTriPartyApplicant() {
        return triPartyApplicant;
    }

    /**
     * Sets the value of the triPartyApplicant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTriPartyApplicant(String value) {
        this.triPartyApplicant = value;
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
     * Gets the value of the paymentCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    /**
     * Sets the value of the paymentCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentCurrency(String value) {
        this.paymentCurrency = value;
    }

    /**
     * Gets the value of the paymentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Sets the value of the paymentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentAmount(String value) {
        this.paymentAmount = value;
    }

    /**
     * Gets the value of the paymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDate() {
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
    public void setPaymentDate(String value) {
        this.paymentDate = value;
    }

    /**
     * Gets the value of the usdPaymentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSDPaymentAmount() {
        return usdPaymentAmount;
    }

    /**
     * Sets the value of the usdPaymentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSDPaymentAmount(String value) {
        this.usdPaymentAmount = value;
    }

    /**
     * Gets the value of the usFeeTotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSFeeTotal() {
        return usFeeTotal;
    }

    /**
     * Sets the value of the usFeeTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSFeeTotal(String value) {
        this.usFeeTotal = value;
    }

    /**
     * Gets the value of the foreignFeeTotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignFeeTotal() {
        return foreignFeeTotal;
    }

    /**
     * Sets the value of the foreignFeeTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignFeeTotal(String value) {
        this.foreignFeeTotal = value;
    }

    /**
     * Gets the value of the periodFeeCredits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodFeeCredits() {
        return periodFeeCredits;
    }

    /**
     * Sets the value of the periodFeeCredits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodFeeCredits(String value) {
        this.periodFeeCredits = value;
    }

    /**
     * Gets the value of the periodAmendmentFees property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodAmendmentFees() {
        return periodAmendmentFees;
    }

    /**
     * Sets the value of the periodAmendmentFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodAmendmentFees(String value) {
        this.periodAmendmentFees = value;
    }

    /**
     * Gets the value of the otherFees property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherFees() {
        return otherFees;
    }

    /**
     * Sets the value of the otherFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherFees(String value) {
        this.otherFees = value;
    }

    /**
     * Gets the value of the oneTimeFees property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOneTimeFees() {
        return oneTimeFees;
    }

    /**
     * Sets the value of the oneTimeFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOneTimeFees(String value) {
        this.oneTimeFees = value;
    }

    /**
     * Gets the value of the modelID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelID() {
        return modelID;
    }

    /**
     * Sets the value of the modelID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelID(String value) {
        this.modelID = value;
    }

    public PaymentDetail withOpCode(String value) {
        setOpCode(value);
        return this;
    }

    public PaymentDetail withPaymentId(String value) {
        setPaymentId(value);
        return this;
    }

    public PaymentDetail withALOCRecordNumber(String value) {
        setALOCRecordNumber(value);
        return this;
    }

    public PaymentDetail withBankReferenceNumber(String value) {
        setBankReferenceNumber(value);
        return this;
    }

    public PaymentDetail withGEApplicant(String value) {
        setGEApplicant(value);
        return this;
    }

    public PaymentDetail withTriPartyApplicant(String value) {
        setTriPartyApplicant(value);
        return this;
    }

    public PaymentDetail withBeneficiaryName(String value) {
        setBeneficiaryName(value);
        return this;
    }

    public PaymentDetail withPaymentCurrency(String value) {
        setPaymentCurrency(value);
        return this;
    }

    public PaymentDetail withPaymentAmount(String value) {
        setPaymentAmount(value);
        return this;
    }

    public PaymentDetail withPaymentDate(String value) {
        setPaymentDate(value);
        return this;
    }

    public PaymentDetail withUSDPaymentAmount(String value) {
        setUSDPaymentAmount(value);
        return this;
    }

    public PaymentDetail withUSFeeTotal(String value) {
        setUSFeeTotal(value);
        return this;
    }

    public PaymentDetail withForeignFeeTotal(String value) {
        setForeignFeeTotal(value);
        return this;
    }

    public PaymentDetail withPeriodFeeCredits(String value) {
        setPeriodFeeCredits(value);
        return this;
    }

    public PaymentDetail withPeriodAmendmentFees(String value) {
        setPeriodAmendmentFees(value);
        return this;
    }

    public PaymentDetail withOtherFees(String value) {
        setOtherFees(value);
        return this;
    }

    public PaymentDetail withOneTimeFees(String value) {
        setOneTimeFees(value);
        return this;
    }

    public PaymentDetail withModelID(String value) {
        setModelID(value);
        return this;
    }

}