//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
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
 *         &lt;element name="Op_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="APM_Config_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Payment_Period_Start_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Payment_Period_End_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FXRate_Revalue_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Payment_Period_Cutoff_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Min_Payment_Amount_USD" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Day_Count" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="IBS_File" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WebCash_File" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Run_Completion_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="First_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Last_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Equivalent_USD_Value" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/Attachments.xsd}Attachment" maxOccurs="unbounded" minOccurs="0"/>
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
    "apmConfigID",
    "paymentPeriodStartDate",
    "paymentPeriodEndDate",
    "fxRateRevalueDate",
    "paymentPeriodCutoffDate",
    "minPaymentAmountUSD",
    "dayCount",
    "ibsFile",
    "webCashFile",
    "runCompletionDate",
    "firstName",
    "lastName",
    "equivalentUSDValue",
    "attachments"
})
@XmlRootElement(name = "PaymentPeriodDetails", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd")
public class PaymentPeriodDetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Op_Code", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd")
    protected String opCode;
    @XmlElement(name = "APM_Config_ID", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd")
    protected BigInteger apmConfigID;
    @XmlElement(name = "Payment_Period_Start_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar paymentPeriodStartDate;
    @XmlElement(name = "Payment_Period_End_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar paymentPeriodEndDate;
    @XmlElement(name = "FXRate_Revalue_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar fxRateRevalueDate;
    @XmlElement(name = "Payment_Period_Cutoff_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar paymentPeriodCutoffDate;
    @XmlElement(name = "Min_Payment_Amount_USD", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd")
    protected BigDecimal minPaymentAmountUSD;
    @XmlElement(name = "Day_Count", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd")
    protected BigInteger dayCount;
    @XmlElement(name = "IBS_File", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd")
    protected String ibsFile;
    @XmlElement(name = "WebCash_File", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd")
    protected String webCashFile;
    @XmlElement(name = "Run_Completion_Date", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar runCompletionDate;
    @XmlElement(name = "First_Name", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd")
    protected String firstName;
    @XmlElement(name = "Last_Name", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd")
    protected String lastName;
    @XmlElement(name = "Equivalent_USD_Value", namespace = "http://treasury.ge.com/schemas/ALOC/APM/PaymentPeriodDetails.xsd")
    protected BigDecimal equivalentUSDValue;
    @XmlElement(name = "Attachment", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Attachments.xsd")
    protected List<Attachment> attachments;

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
     * Gets the value of the paymentPeriodStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getPaymentPeriodStartDate() {
        return paymentPeriodStartDate;
    }

    /**
     * Sets the value of the paymentPeriodStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentPeriodStartDate(Calendar value) {
        this.paymentPeriodStartDate = value;
    }

    /**
     * Gets the value of the paymentPeriodEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getPaymentPeriodEndDate() {
        return paymentPeriodEndDate;
    }

    /**
     * Sets the value of the paymentPeriodEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentPeriodEndDate(Calendar value) {
        this.paymentPeriodEndDate = value;
    }

    /**
     * Gets the value of the fxRateRevalueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getFXRateRevalueDate() {
        return fxRateRevalueDate;
    }

    /**
     * Sets the value of the fxRateRevalueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFXRateRevalueDate(Calendar value) {
        this.fxRateRevalueDate = value;
    }

    /**
     * Gets the value of the paymentPeriodCutoffDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getPaymentPeriodCutoffDate() {
        return paymentPeriodCutoffDate;
    }

    /**
     * Sets the value of the paymentPeriodCutoffDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentPeriodCutoffDate(Calendar value) {
        this.paymentPeriodCutoffDate = value;
    }

    /**
     * Gets the value of the minPaymentAmountUSD property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinPaymentAmountUSD() {
        return minPaymentAmountUSD;
    }

    /**
     * Sets the value of the minPaymentAmountUSD property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinPaymentAmountUSD(BigDecimal value) {
        this.minPaymentAmountUSD = value;
    }

    /**
     * Gets the value of the dayCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDayCount() {
        return dayCount;
    }

    /**
     * Sets the value of the dayCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDayCount(BigInteger value) {
        this.dayCount = value;
    }

    /**
     * Gets the value of the ibsFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBSFile() {
        return ibsFile;
    }

    /**
     * Sets the value of the ibsFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBSFile(String value) {
        this.ibsFile = value;
    }

    /**
     * Gets the value of the webCashFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebCashFile() {
        return webCashFile;
    }

    /**
     * Sets the value of the webCashFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebCashFile(String value) {
        this.webCashFile = value;
    }

    /**
     * Gets the value of the runCompletionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getRunCompletionDate() {
        return runCompletionDate;
    }

    /**
     * Sets the value of the runCompletionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRunCompletionDate(Calendar value) {
        this.runCompletionDate = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the equivalentUSDValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEquivalentUSDValue() {
        return equivalentUSDValue;
    }

    /**
     * Sets the value of the equivalentUSDValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEquivalentUSDValue(BigDecimal value) {
        this.equivalentUSDValue = value;
    }

    /**
     * Gets the value of the attachments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attachment }
     * 
     * 
     */
    public List<Attachment> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<Attachment>();
        }
        return this.attachments;
    }

    public PaymentPeriodDetails withOpCode(String value) {
        setOpCode(value);
        return this;
    }

    public PaymentPeriodDetails withAPMConfigID(BigInteger value) {
        setAPMConfigID(value);
        return this;
    }

    public PaymentPeriodDetails withPaymentPeriodStartDate(Calendar value) {
        setPaymentPeriodStartDate(value);
        return this;
    }

    public PaymentPeriodDetails withPaymentPeriodEndDate(Calendar value) {
        setPaymentPeriodEndDate(value);
        return this;
    }

    public PaymentPeriodDetails withFXRateRevalueDate(Calendar value) {
        setFXRateRevalueDate(value);
        return this;
    }

    public PaymentPeriodDetails withPaymentPeriodCutoffDate(Calendar value) {
        setPaymentPeriodCutoffDate(value);
        return this;
    }

    public PaymentPeriodDetails withMinPaymentAmountUSD(BigDecimal value) {
        setMinPaymentAmountUSD(value);
        return this;
    }

    public PaymentPeriodDetails withDayCount(BigInteger value) {
        setDayCount(value);
        return this;
    }

    public PaymentPeriodDetails withIBSFile(String value) {
        setIBSFile(value);
        return this;
    }

    public PaymentPeriodDetails withWebCashFile(String value) {
        setWebCashFile(value);
        return this;
    }

    public PaymentPeriodDetails withRunCompletionDate(Calendar value) {
        setRunCompletionDate(value);
        return this;
    }

    public PaymentPeriodDetails withFirstName(String value) {
        setFirstName(value);
        return this;
    }

    public PaymentPeriodDetails withLastName(String value) {
        setLastName(value);
        return this;
    }

    public PaymentPeriodDetails withEquivalentUSDValue(BigDecimal value) {
        setEquivalentUSDValue(value);
        return this;
    }

    public PaymentPeriodDetails withAttachments(Attachment... values) {
        if (values!= null) {
            for (Attachment value: values) {
                getAttachments().add(value);
            }
        }
        return this;
    }

    public PaymentPeriodDetails withAttachments(Collection<Attachment> values) {
        if (values!= null) {
            getAttachments().addAll(values);
        }
        return this;
    }

    /**
     * Sets the value of the attachments property.
     * 
     * @param attachments
     *     allowed object is
     *     {@link Attachment }
     *     
     */
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

}
