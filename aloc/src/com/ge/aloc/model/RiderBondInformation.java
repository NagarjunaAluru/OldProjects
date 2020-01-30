//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.17 at 12:40:24 PM IST 
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
 *         &lt;element name="Original_Bond_Amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Current_Bond_Amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Revised_Bond_Amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amt_Of_Increase_Or_Decrease" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Original_Contract_Amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Revised_Contract_Amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Revised_USDEqui_Contract_Amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Validation_UsdAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
    "originalBondAmt",
    "currentBondAmt",
    "revisedBondAmt",
    "operation",
    "amtOfIncreaseOrDecrease",
    "originalContractAmt",
    "revisedContractAmt",
    "revisedUSDEquiContractAmt",
    "validationUsdAmount",
    "changeFlag"
})
@XmlRootElement(name = "RiderBondInformation", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderBondInformation.xsd")
public class RiderBondInformation
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Op_Code", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderBondInformation.xsd")
    protected String opCode;
    @XmlElement(name = "Original_Bond_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderBondInformation.xsd")
    protected BigDecimal originalBondAmt;
    @XmlElement(name = "Current_Bond_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderBondInformation.xsd")
    protected BigDecimal currentBondAmt;
    @XmlElement(name = "Revised_Bond_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderBondInformation.xsd")
    protected BigDecimal revisedBondAmt;
    @XmlElement(name = "Operation", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderBondInformation.xsd")
    protected String operation;
    @XmlElement(name = "Amt_Of_Increase_Or_Decrease", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderBondInformation.xsd")
    protected BigDecimal amtOfIncreaseOrDecrease;
    @XmlElement(name = "Original_Contract_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderBondInformation.xsd")
    protected BigDecimal originalContractAmt;
    @XmlElement(name = "Revised_Contract_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderBondInformation.xsd")
    protected BigDecimal revisedContractAmt;
    @XmlElement(name = "Revised_USDEqui_Contract_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderBondInformation.xsd")
    protected BigDecimal revisedUSDEquiContractAmt;
    @XmlElement(name = "Validation_UsdAmount", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderBondInformation.xsd")
    protected BigDecimal validationUsdAmount;
    @XmlElement(name = "Change_Flag", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderBondInformation.xsd")
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
     * Gets the value of the originalBondAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOriginalBondAmt() {
        return originalBondAmt;
    }

    /**
     * Sets the value of the originalBondAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOriginalBondAmt(BigDecimal value) {
        this.originalBondAmt = value;
    }

    /**
     * Gets the value of the currentBondAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurrentBondAmt() {
        return currentBondAmt;
    }

    /**
     * Sets the value of the currentBondAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurrentBondAmt(BigDecimal value) {
        this.currentBondAmt = value;
    }

    /**
     * Gets the value of the revisedBondAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRevisedBondAmt() {
        return revisedBondAmt;
    }

    /**
     * Sets the value of the revisedBondAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRevisedBondAmt(BigDecimal value) {
        this.revisedBondAmt = value;
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
     * Gets the value of the originalContractAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOriginalContractAmt() {
        return originalContractAmt;
    }

    /**
     * Sets the value of the originalContractAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOriginalContractAmt(BigDecimal value) {
        this.originalContractAmt = value;
    }

    /**
     * Gets the value of the revisedContractAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRevisedContractAmt() {
        return revisedContractAmt;
    }

    /**
     * Sets the value of the revisedContractAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRevisedContractAmt(BigDecimal value) {
        this.revisedContractAmt = value;
    }

    /**
     * Gets the value of the revisedUSDEquiContractAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRevisedUSDEquiContractAmt() {
        return revisedUSDEquiContractAmt;
    }

    /**
     * Sets the value of the revisedUSDEquiContractAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRevisedUSDEquiContractAmt(BigDecimal value) {
        this.revisedUSDEquiContractAmt = value;
    }

    /**
     * Gets the value of the validationUsdAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValidationUsdAmount() {
        return validationUsdAmount;
    }

    /**
     * Sets the value of the validationUsdAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValidationUsdAmount(BigDecimal value) {
        this.validationUsdAmount = value;
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

    public RiderBondInformation withOpCode(String value) {
        setOpCode(value);
        return this;
    }

    public RiderBondInformation withOriginalBondAmt(BigDecimal value) {
        setOriginalBondAmt(value);
        return this;
    }

    public RiderBondInformation withCurrentBondAmt(BigDecimal value) {
        setCurrentBondAmt(value);
        return this;
    }

    public RiderBondInformation withRevisedBondAmt(BigDecimal value) {
        setRevisedBondAmt(value);
        return this;
    }

    public RiderBondInformation withOperation(String value) {
        setOperation(value);
        return this;
    }

    public RiderBondInformation withAmtOfIncreaseOrDecrease(BigDecimal value) {
        setAmtOfIncreaseOrDecrease(value);
        return this;
    }

    public RiderBondInformation withOriginalContractAmt(BigDecimal value) {
        setOriginalContractAmt(value);
        return this;
    }

    public RiderBondInformation withRevisedContractAmt(BigDecimal value) {
        setRevisedContractAmt(value);
        return this;
    }

    public RiderBondInformation withRevisedUSDEquiContractAmt(BigDecimal value) {
        setRevisedUSDEquiContractAmt(value);
        return this;
    }

    public RiderBondInformation withValidationUsdAmount(BigDecimal value) {
        setValidationUsdAmount(value);
        return this;
    }

    public RiderBondInformation withChangeFlag(String value) {
        setChangeFlag(value);
        return this;
    }

}