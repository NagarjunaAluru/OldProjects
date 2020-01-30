//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.08 at 07:56:29 PM IST 
//


package com.ge.icfp.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.hydus.wff.core.security.JAXBObjectSecureSerializer;


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
 *         &lt;element name="T_Owner_FName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="T_Owner_LName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="T_Owner_Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Security_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Derivatives" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cross_Border" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Equity_Infusion_Dividends" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Impairment_History" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PrudentiallyRegulated_LegalEntity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Impairment_Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Principal_LegalEntity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Subordinated_Debt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FinancialStatement_Flag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Latest_Date_Of_FinancialStatement" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="NonStandard_Legal_Agreement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "tOwnerFName",
    "tOwnerLName",
    "tOwnerTitle",
    "securityType",
    "derivatives",
    "crossBorder",
    "equityInfusionDividends",
    "impairmentHistory",
    "prudentiallyRegulatedLegalEntity",
    "impairmentComments",
    "principalLegalEntity",
    "subordinatedDebt",
    "financialStatementFlag",
    "latestDateOfFinancialStatement",
    "nonStandardLegalAgreement"
})
@XmlRootElement(name = "T_Summary_Owner")
public class TSummaryOwner
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "T_Owner_FName")
    protected String tOwnerFName;
    @XmlElement(name = "T_Owner_LName")
    protected String tOwnerLName;
    @XmlElement(name = "T_Owner_Title")
    protected String tOwnerTitle;
    @XmlElement(name = "Security_Type")
    protected String securityType;
    @XmlElement(name = "Derivatives")
    protected String derivatives;
    @XmlElement(name = "Cross_Border")
    protected Boolean crossBorder;
    @XmlElement(name = "Equity_Infusion_Dividends")
    protected String equityInfusionDividends;
    @XmlElement(name = "Impairment_History")
    protected Boolean impairmentHistory;
    @XmlElement(name = "PrudentiallyRegulated_LegalEntity")
    protected String prudentiallyRegulatedLegalEntity;
    @XmlElement(name = "Impairment_Comments")
    protected String impairmentComments;
    @XmlElement(name = "Principal_LegalEntity")
    protected String principalLegalEntity;
    @XmlElement(name = "Subordinated_Debt")
    protected String subordinatedDebt;
    @XmlElement(name = "FinancialStatement_Flag")
    protected Boolean financialStatementFlag;
    @XmlElement(name = "Latest_Date_Of_FinancialStatement")
    protected XMLGregorianCalendar latestDateOfFinancialStatement;
    @XmlElement(name = "NonStandard_Legal_Agreement")
    protected String nonStandardLegalAgreement;

    /**
     * Gets the value of the tOwnerFName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOwnerFName() {
        return tOwnerFName;
    }

    /**
     * Sets the value of the tOwnerFName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOwnerFName(String value) {
        this.tOwnerFName = value;
    }

    /**
     * Gets the value of the tOwnerLName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOwnerLName() {
        return tOwnerLName;
    }

    /**
     * Sets the value of the tOwnerLName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOwnerLName(String value) {
        this.tOwnerLName = value;
    }

    /**
     * Gets the value of the tOwnerTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOwnerTitle() {
        return tOwnerTitle;
    }

    /**
     * Sets the value of the tOwnerTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOwnerTitle(String value) {
        this.tOwnerTitle = value;
    }

    /**
     * Gets the value of the securityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityType() {
        return securityType;
    }

    /**
     * Sets the value of the securityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityType(String value) {
        this.securityType = value;
    }

    /**
     * Gets the value of the derivatives property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDerivatives() {
        return derivatives;
    }

    /**
     * Sets the value of the derivatives property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDerivatives(String value) {
        this.derivatives = value;
    }

    /**
     * Gets the value of the crossBorder property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCrossBorder() {
        return crossBorder;
    }

    /**
     * Sets the value of the crossBorder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCrossBorder(Boolean value) {
        this.crossBorder = value;
    }

    /**
     * Gets the value of the equityInfusionDividends property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquityInfusionDividends() {
        return equityInfusionDividends;
    }

    /**
     * Sets the value of the equityInfusionDividends property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquityInfusionDividends(String value) {
        this.equityInfusionDividends = value;
    }

    /**
     * Gets the value of the impairmentHistory property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isImpairmentHistory() {
        return impairmentHistory;
    }

    /**
     * Sets the value of the impairmentHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setImpairmentHistory(Boolean value) {
        this.impairmentHistory = value;
    }

    /**
     * Gets the value of the prudentiallyRegulatedLegalEntity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrudentiallyRegulatedLegalEntity() {
        return prudentiallyRegulatedLegalEntity;
    }

    /**
     * Sets the value of the prudentiallyRegulatedLegalEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrudentiallyRegulatedLegalEntity(String value) {
        this.prudentiallyRegulatedLegalEntity = value;
    }

    /**
     * Gets the value of the impairmentComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImpairmentComments() {
        return impairmentComments;
    }

    /**
     * Sets the value of the impairmentComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImpairmentComments(String value) {
        this.impairmentComments = value;
    }

    /**
     * Gets the value of the principalLegalEntity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrincipalLegalEntity() {
        return principalLegalEntity;
    }

    /**
     * Sets the value of the principalLegalEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipalLegalEntity(String value) {
        this.principalLegalEntity = value;
    }

    /**
     * Gets the value of the subordinatedDebt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubordinatedDebt() {
        return subordinatedDebt;
    }

    /**
     * Sets the value of the subordinatedDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubordinatedDebt(String value) {
        this.subordinatedDebt = value;
    }

    /**
     * Gets the value of the financialStatementFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFinancialStatementFlag() {
        return financialStatementFlag;
    }

    /**
     * Sets the value of the financialStatementFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFinancialStatementFlag(Boolean value) {
        this.financialStatementFlag = value;
    }

    /**
     * Gets the value of the latestDateOfFinancialStatement property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLatestDateOfFinancialStatement() {
        return latestDateOfFinancialStatement;
    }

    /**
     * Sets the value of the latestDateOfFinancialStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLatestDateOfFinancialStatement(XMLGregorianCalendar value) {
        this.latestDateOfFinancialStatement = value;
    }

    /**
     * Gets the value of the nonStandardLegalAgreement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonStandardLegalAgreement() {
        return nonStandardLegalAgreement;
    }

    /**
     * Sets the value of the nonStandardLegalAgreement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonStandardLegalAgreement(String value) {
        this.nonStandardLegalAgreement = value;
    }

    public TSummaryOwner withTOwnerFName(String value) {
        setTOwnerFName(value);
        return this;
    }

    public TSummaryOwner withTOwnerLName(String value) {
        setTOwnerLName(value);
        return this;
    }

    public TSummaryOwner withTOwnerTitle(String value) {
        setTOwnerTitle(value);
        return this;
    }

    public TSummaryOwner withSecurityType(String value) {
        setSecurityType(value);
        return this;
    }

    public TSummaryOwner withDerivatives(String value) {
        setDerivatives(value);
        return this;
    }

    public TSummaryOwner withCrossBorder(Boolean value) {
        setCrossBorder(value);
        return this;
    }

    public TSummaryOwner withEquityInfusionDividends(String value) {
        setEquityInfusionDividends(value);
        return this;
    }

    public TSummaryOwner withImpairmentHistory(Boolean value) {
        setImpairmentHistory(value);
        return this;
    }

    public TSummaryOwner withPrudentiallyRegulatedLegalEntity(String value) {
        setPrudentiallyRegulatedLegalEntity(value);
        return this;
    }

    public TSummaryOwner withImpairmentComments(String value) {
        setImpairmentComments(value);
        return this;
    }

    public TSummaryOwner withPrincipalLegalEntity(String value) {
        setPrincipalLegalEntity(value);
        return this;
    }

    public TSummaryOwner withSubordinatedDebt(String value) {
        setSubordinatedDebt(value);
        return this;
    }

    public TSummaryOwner withFinancialStatementFlag(Boolean value) {
        setFinancialStatementFlag(value);
        return this;
    }

    public TSummaryOwner withLatestDateOfFinancialStatement(XMLGregorianCalendar value) {
        setLatestDateOfFinancialStatement(value);
        return this;
    }

    public TSummaryOwner withNonStandardLegalAgreement(String value) {
        setNonStandardLegalAgreement(value);
        return this;
    }

}
