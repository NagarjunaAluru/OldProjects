//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.31 at 04:13:42 PM IST 
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
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.hydus.hwf.jaxb.adapters.XMLDatetimeAsCalendarAdapter;
import com.hydus.hwf.security.JAXBObjectSecureSerializer;


/**
 * <p>Java class for Amendment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Amendment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Op_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Request_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Bank_Reference_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amendment_Request_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amendment_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Type_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Trigger_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/TransactionParties.xsd}TransactionParties" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd}AmendmentInstrumentAmountCurr" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/ExpiryDate.xsd}ExpiryDate" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/DeliveryInstructions.xsd}DeliveryInstructions" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/Attachments.xsd}Attachment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InfoTransPlatFormSelection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Other_Changes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AMD_Workflow_Amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/ALOCCommon.xsd}ActionDetails" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/AuditLog.xsd}Audit_Log" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/ActionLog.xsd}ActionLog" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Auto_INC_DEC_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Old_Instrument_Type_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Amendment", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd", propOrder = {
    "opCode",
    "requestId",
    "bankReferenceNumber",
    "amendmentRequestId",
    "amendmentType",
    "instrumentType",
    "instrumentTypeId",
    "triggerType",
    "transactionParties",
    "amendmentInstrumentAmountCurr",
    "expiryDate",
    "deliveryInstructions",
    "attachments",
    "infoTransPlatFormSelection",
    "otherChanges",
    "amdWorkflowAmt",
    "actionDetails",
    "auditLogs",
    "actionLogs",
    "autoINCDECDate",
    "oldInstrumentTypeId"
})
public class Amendment
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Op_Code", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd")
    protected String opCode;
    @XmlElement(name = "Request_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd")
    protected BigInteger requestId;
    @XmlElement(name = "Bank_Reference_Number", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd")
    protected String bankReferenceNumber;
    @XmlElement(name = "Amendment_Request_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd")
    protected String amendmentRequestId;
    @XmlElement(name = "Amendment_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd")
    protected String amendmentType;
    @XmlElement(name = "Instrument_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd")
    protected String instrumentType;
    @XmlElement(name = "Instrument_Type_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd")
    protected String instrumentTypeId;
    @XmlElement(name = "Trigger_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd")
    protected String triggerType;
    @XmlElement(name = "TransactionParties", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/TransactionParties.xsd")
    protected TransactionParties transactionParties;
    @XmlElement(name = "AmendmentInstrumentAmountCurr", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
    protected AmendmentInstrumentAmountCurr amendmentInstrumentAmountCurr;
    @XmlElement(name = "ExpiryDate", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/ExpiryDate.xsd")
    protected ExpiryDate expiryDate;
    @XmlElement(name = "DeliveryInstructions", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DeliveryInstructions.xsd")
    protected DeliveryInstructions deliveryInstructions;
    @XmlElement(name = "Attachment", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Attachments.xsd")
    protected List<Attachment> attachments;
    @XmlElement(name = "InfoTransPlatFormSelection", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd")
    protected String infoTransPlatFormSelection;
    @XmlElement(name = "Other_Changes", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd")
    protected String otherChanges;
    @XmlElement(name = "AMD_Workflow_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd")
    protected BigDecimal amdWorkflowAmt;
    @XmlElement(name = "ActionDetails", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/ALOCCommon.xsd")
    protected ActionDetails actionDetails;
    @XmlElement(name = "Audit_Log", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AuditLog.xsd")
    protected List<AuditLog> auditLogs;
    @XmlElement(name = "ActionLog", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/ActionLog.xsd")
    protected List<ActionLog> actionLogs;
    @XmlElement(name = "Auto_INC_DEC_Date", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar autoINCDECDate;
    @XmlElement(name = "Old_Instrument_Type_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Amendment.xsd")
    protected Integer oldInstrumentTypeId;

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
     * Gets the value of the amendmentRequestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmendmentRequestId() {
        return amendmentRequestId;
    }

    /**
     * Sets the value of the amendmentRequestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmendmentRequestId(String value) {
        this.amendmentRequestId = value;
    }

    /**
     * Gets the value of the amendmentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmendmentType() {
        return amendmentType;
    }

    /**
     * Sets the value of the amendmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmendmentType(String value) {
        this.amendmentType = value;
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
     * Gets the value of the instrumentTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrumentTypeId() {
        return instrumentTypeId;
    }

    /**
     * Sets the value of the instrumentTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrumentTypeId(String value) {
        this.instrumentTypeId = value;
    }

    /**
     * Gets the value of the triggerType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTriggerType() {
        return triggerType;
    }

    /**
     * Sets the value of the triggerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTriggerType(String value) {
        this.triggerType = value;
    }

    /**
     * Gets the value of the transactionParties property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionParties }
     *     
     */
    public TransactionParties getTransactionParties() {
        return transactionParties;
    }

    /**
     * Sets the value of the transactionParties property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionParties }
     *     
     */
    public void setTransactionParties(TransactionParties value) {
        this.transactionParties = value;
    }

    /**
     * Gets the value of the amendmentInstrumentAmountCurr property.
     * 
     * @return
     *     possible object is
     *     {@link AmendmentInstrumentAmountCurr }
     *     
     */
    public AmendmentInstrumentAmountCurr getAmendmentInstrumentAmountCurr() {
        return amendmentInstrumentAmountCurr;
    }

    /**
     * Sets the value of the amendmentInstrumentAmountCurr property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentInstrumentAmountCurr }
     *     
     */
    public void setAmendmentInstrumentAmountCurr(AmendmentInstrumentAmountCurr value) {
        this.amendmentInstrumentAmountCurr = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link ExpiryDate }
     *     
     */
    public ExpiryDate getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpiryDate }
     *     
     */
    public void setExpiryDate(ExpiryDate value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the deliveryInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryInstructions }
     *     
     */
    public DeliveryInstructions getDeliveryInstructions() {
        return deliveryInstructions;
    }

    /**
     * Sets the value of the deliveryInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryInstructions }
     *     
     */
    public void setDeliveryInstructions(DeliveryInstructions value) {
        this.deliveryInstructions = value;
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

    /**
     * Gets the value of the infoTransPlatFormSelection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoTransPlatFormSelection() {
        return infoTransPlatFormSelection;
    }

    /**
     * Sets the value of the infoTransPlatFormSelection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoTransPlatFormSelection(String value) {
        this.infoTransPlatFormSelection = value;
    }

    /**
     * Gets the value of the otherChanges property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherChanges() {
        return otherChanges;
    }

    /**
     * Sets the value of the otherChanges property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherChanges(String value) {
        this.otherChanges = value;
    }

    /**
     * Gets the value of the amdWorkflowAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAMDWorkflowAmt() {
        return amdWorkflowAmt;
    }

    /**
     * Sets the value of the amdWorkflowAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAMDWorkflowAmt(BigDecimal value) {
        this.amdWorkflowAmt = value;
    }

    /**
     * Gets the value of the actionDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ActionDetails }
     *     
     */
    public ActionDetails getActionDetails() {
        return actionDetails;
    }

    /**
     * Sets the value of the actionDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionDetails }
     *     
     */
    public void setActionDetails(ActionDetails value) {
        this.actionDetails = value;
    }

    /**
     * Gets the value of the auditLogs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the auditLogs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuditLogs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuditLog }
     * 
     * 
     */
    public List<AuditLog> getAuditLogs() {
        if (auditLogs == null) {
            auditLogs = new ArrayList<AuditLog>();
        }
        return this.auditLogs;
    }

    /**
     * Gets the value of the actionLogs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actionLogs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActionLogs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActionLog }
     * 
     * 
     */
    public List<ActionLog> getActionLogs() {
        if (actionLogs == null) {
            actionLogs = new ArrayList<ActionLog>();
        }
        return this.actionLogs;
    }

    /**
     * Gets the value of the autoINCDECDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getAutoINCDECDate() {
        return autoINCDECDate;
    }

    /**
     * Sets the value of the autoINCDECDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoINCDECDate(Calendar value) {
        this.autoINCDECDate = value;
    }

    /**
     * Gets the value of the oldInstrumentTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOldInstrumentTypeId() {
        return oldInstrumentTypeId;
    }

    /**
     * Sets the value of the oldInstrumentTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOldInstrumentTypeId(Integer value) {
        this.oldInstrumentTypeId = value;
    }

    public Amendment withOpCode(String value) {
        setOpCode(value);
        return this;
    }

    public Amendment withRequestId(BigInteger value) {
        setRequestId(value);
        return this;
    }

    public Amendment withBankReferenceNumber(String value) {
        setBankReferenceNumber(value);
        return this;
    }

    public Amendment withAmendmentRequestId(String value) {
        setAmendmentRequestId(value);
        return this;
    }

    public Amendment withAmendmentType(String value) {
        setAmendmentType(value);
        return this;
    }

    public Amendment withInstrumentType(String value) {
        setInstrumentType(value);
        return this;
    }

    public Amendment withInstrumentTypeId(String value) {
        setInstrumentTypeId(value);
        return this;
    }

    public Amendment withTriggerType(String value) {
        setTriggerType(value);
        return this;
    }

    public Amendment withTransactionParties(TransactionParties value) {
        setTransactionParties(value);
        return this;
    }

    public Amendment withAmendmentInstrumentAmountCurr(AmendmentInstrumentAmountCurr value) {
        setAmendmentInstrumentAmountCurr(value);
        return this;
    }

    public Amendment withExpiryDate(ExpiryDate value) {
        setExpiryDate(value);
        return this;
    }

    public Amendment withDeliveryInstructions(DeliveryInstructions value) {
        setDeliveryInstructions(value);
        return this;
    }

    public Amendment withAttachments(Attachment... values) {
        if (values!= null) {
            for (Attachment value: values) {
                getAttachments().add(value);
            }
        }
        return this;
    }

    public Amendment withAttachments(Collection<Attachment> values) {
        if (values!= null) {
            getAttachments().addAll(values);
        }
        return this;
    }

    public Amendment withInfoTransPlatFormSelection(String value) {
        setInfoTransPlatFormSelection(value);
        return this;
    }

    public Amendment withOtherChanges(String value) {
        setOtherChanges(value);
        return this;
    }

    public Amendment withAMDWorkflowAmt(BigDecimal value) {
        setAMDWorkflowAmt(value);
        return this;
    }

    public Amendment withActionDetails(ActionDetails value) {
        setActionDetails(value);
        return this;
    }

    public Amendment withAuditLogs(AuditLog... values) {
        if (values!= null) {
            for (AuditLog value: values) {
                getAuditLogs().add(value);
            }
        }
        return this;
    }

    public Amendment withAuditLogs(Collection<AuditLog> values) {
        if (values!= null) {
            getAuditLogs().addAll(values);
        }
        return this;
    }

    public Amendment withActionLogs(ActionLog... values) {
        if (values!= null) {
            for (ActionLog value: values) {
                getActionLogs().add(value);
            }
        }
        return this;
    }

    public Amendment withActionLogs(Collection<ActionLog> values) {
        if (values!= null) {
            getActionLogs().addAll(values);
        }
        return this;
    }

    public Amendment withAutoINCDECDate(Calendar value) {
        setAutoINCDECDate(value);
        return this;
    }

    public Amendment withOldInstrumentTypeId(Integer value) {
        setOldInstrumentTypeId(value);
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

    /**
     * Sets the value of the auditLogs property.
     * 
     * @param auditLogs
     *     allowed object is
     *     {@link AuditLog }
     *     
     */
    public void setAuditLogs(List<AuditLog> auditLogs) {
        this.auditLogs = auditLogs;
    }

    /**
     * Sets the value of the actionLogs property.
     * 
     * @param actionLogs
     *     allowed object is
     *     {@link ActionLog }
     *     
     */
    public void setActionLogs(List<ActionLog> actionLogs) {
        this.actionLogs = actionLogs;
    }

}
