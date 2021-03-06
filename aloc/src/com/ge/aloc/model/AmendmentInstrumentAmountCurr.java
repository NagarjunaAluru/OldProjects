//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 *         &lt;element name="Original_Instrument_Amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Current_Instrument_Amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amt_Of_Increase_Or_Decrease" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Revised_Instrument_Amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Original_Instrument_Curr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Original_Instrument_Curr_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="New_Instrument_Curr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="New_Instrument_Curr_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Revised_USDEqui_Amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Change_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "originalInstrumentAmt",
    "currentInstrumentAmt",
    "operation",
    "amtOfIncreaseOrDecrease",
    "revisedInstrumentAmt",
    "originalInstrumentCurr",
    "originalInstrumentCurrCode",
    "newInstrumentCurr",
    "newInstrumentCurrCode",
    "revisedUSDEquiAmt",
    "changeFlag"
})
@XmlRootElement(name = "AmendmentInstrumentAmountCurr", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
public class AmendmentInstrumentAmountCurr
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Op_Code", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
    protected String opCode;
    @XmlElement(name = "Original_Instrument_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
    protected BigDecimal originalInstrumentAmt;
    @XmlElement(name = "Current_Instrument_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
    protected BigDecimal currentInstrumentAmt;
    @XmlElement(name = "Operation", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
    protected String operation;
    @XmlElement(name = "Amt_Of_Increase_Or_Decrease", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
    protected BigDecimal amtOfIncreaseOrDecrease;
    @XmlElement(name = "Revised_Instrument_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
    protected BigDecimal revisedInstrumentAmt;
    @XmlElement(name = "Original_Instrument_Curr", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
    protected String originalInstrumentCurr;
    @XmlElement(name = "Original_Instrument_Curr_Code", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
    protected String originalInstrumentCurrCode;
    @XmlElement(name = "New_Instrument_Curr", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
    protected String newInstrumentCurr;
    @XmlElement(name = "New_Instrument_Curr_Code", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
    protected String newInstrumentCurrCode;
    @XmlElement(name = "Revised_USDEqui_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
    protected BigDecimal revisedUSDEquiAmt;
    @XmlElement(name = "Change_Flag", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentInstrumentAmountCurr.xsd")
    protected String changeFlag;

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
     * Gets the value of the originalInstrumentAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOriginalInstrumentAmt() {
        return originalInstrumentAmt;
    }

    /**
     * Sets the value of the originalInstrumentAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOriginalInstrumentAmt(BigDecimal value) {
        this.originalInstrumentAmt = value;
    }

    /**
     * Gets the value of the currentInstrumentAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurrentInstrumentAmt() {
        return currentInstrumentAmt;
    }

    /**
     * Sets the value of the currentInstrumentAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurrentInstrumentAmt(BigDecimal value) {
        this.currentInstrumentAmt = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * Gets the value of the amtOfIncreaseOrDecrease property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmtOfIncreaseOrDecrease() {
        return amtOfIncreaseOrDecrease;
    }

    /**
     * Sets the value of the amtOfIncreaseOrDecrease property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmtOfIncreaseOrDecrease(BigDecimal value) {
        this.amtOfIncreaseOrDecrease = value;
    }

    /**
     * Gets the value of the revisedInstrumentAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRevisedInstrumentAmt() {
        return revisedInstrumentAmt;
    }

    /**
     * Sets the value of the revisedInstrumentAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRevisedInstrumentAmt(BigDecimal value) {
        this.revisedInstrumentAmt = value;
    }

    /**
     * Gets the value of the originalInstrumentCurr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalInstrumentCurr() {
        return originalInstrumentCurr;
    }

    /**
     * Sets the value of the originalInstrumentCurr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalInstrumentCurr(String value) {
        this.originalInstrumentCurr = value;
    }

    /**
     * Gets the value of the originalInstrumentCurrCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalInstrumentCurrCode() {
        return originalInstrumentCurrCode;
    }

    /**
     * Sets the value of the originalInstrumentCurrCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalInstrumentCurrCode(String value) {
        this.originalInstrumentCurrCode = value;
    }

    /**
     * Gets the value of the newInstrumentCurr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewInstrumentCurr() {
        return newInstrumentCurr;
    }

    /**
     * Sets the value of the newInstrumentCurr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewInstrumentCurr(String value) {
        this.newInstrumentCurr = value;
    }

    /**
     * Gets the value of the newInstrumentCurrCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewInstrumentCurrCode() {
        return newInstrumentCurrCode;
    }

    /**
     * Sets the value of the newInstrumentCurrCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewInstrumentCurrCode(String value) {
        this.newInstrumentCurrCode = value;
    }

    /**
     * Gets the value of the revisedUSDEquiAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRevisedUSDEquiAmt() {
        return revisedUSDEquiAmt;
    }

    /**
     * Sets the value of the revisedUSDEquiAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRevisedUSDEquiAmt(BigDecimal value) {
        this.revisedUSDEquiAmt = value;
    }

    /**
     * Gets the value of the changeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeFlag() {
        return changeFlag;
    }

    /**
     * Sets the value of the changeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeFlag(String value) {
        this.changeFlag = value;
    }

    public AmendmentInstrumentAmountCurr withOpCode(String value) {
        setOpCode(value);
        return this;
    }

    public AmendmentInstrumentAmountCurr withOriginalInstrumentAmt(BigDecimal value) {
        setOriginalInstrumentAmt(value);
        return this;
    }

    public AmendmentInstrumentAmountCurr withCurrentInstrumentAmt(BigDecimal value) {
        setCurrentInstrumentAmt(value);
        return this;
    }

    public AmendmentInstrumentAmountCurr withOperation(String value) {
        setOperation(value);
        return this;
    }

    public AmendmentInstrumentAmountCurr withAmtOfIncreaseOrDecrease(BigDecimal value) {
        setAmtOfIncreaseOrDecrease(value);
        return this;
    }

    public AmendmentInstrumentAmountCurr withRevisedInstrumentAmt(BigDecimal value) {
        setRevisedInstrumentAmt(value);
        return this;
    }

    public AmendmentInstrumentAmountCurr withOriginalInstrumentCurr(String value) {
        setOriginalInstrumentCurr(value);
        return this;
    }

    public AmendmentInstrumentAmountCurr withOriginalInstrumentCurrCode(String value) {
        setOriginalInstrumentCurrCode(value);
        return this;
    }

    public AmendmentInstrumentAmountCurr withNewInstrumentCurr(String value) {
        setNewInstrumentCurr(value);
        return this;
    }

    public AmendmentInstrumentAmountCurr withNewInstrumentCurrCode(String value) {
        setNewInstrumentCurrCode(value);
        return this;
    }

    public AmendmentInstrumentAmountCurr withRevisedUSDEquiAmt(BigDecimal value) {
        setRevisedUSDEquiAmt(value);
        return this;
    }

    public AmendmentInstrumentAmountCurr withChangeFlag(String value) {
        setChangeFlag(value);
        return this;
    }

}
