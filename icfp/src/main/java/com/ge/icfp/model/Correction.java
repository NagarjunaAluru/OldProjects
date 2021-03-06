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
 *         &lt;element name="Problem_Statement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Action_Needed_By_Dt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Correction_Needed_Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Debt_Equity_Other_Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "problemStatement",
    "actionNeededByDt",
    "correctionNeededComments",
    "debtEquityOtherComments"
})
@XmlRootElement(name = "Correction", namespace = "http://treasury.ge.com/schemas/ICFP/Correction.xsd")
public class Correction
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Problem_Statement", namespace = "http://treasury.ge.com/schemas/ICFP/Correction.xsd")
    protected String problemStatement;
    @XmlElement(name = "Action_Needed_By_Dt", namespace = "http://treasury.ge.com/schemas/ICFP/Correction.xsd")
    protected XMLGregorianCalendar actionNeededByDt;
    @XmlElement(name = "Correction_Needed_Comments", namespace = "http://treasury.ge.com/schemas/ICFP/Correction.xsd")
    protected String correctionNeededComments;
    @XmlElement(name = "Debt_Equity_Other_Comments", namespace = "http://treasury.ge.com/schemas/ICFP/Correction.xsd")
    protected String debtEquityOtherComments;

    /**
     * Gets the value of the problemStatement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProblemStatement() {
        return problemStatement;
    }

    /**
     * Sets the value of the problemStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProblemStatement(String value) {
        this.problemStatement = value;
    }

    /**
     * Gets the value of the actionNeededByDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActionNeededByDt() {
        return actionNeededByDt;
    }

    /**
     * Sets the value of the actionNeededByDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActionNeededByDt(XMLGregorianCalendar value) {
        this.actionNeededByDt = value;
    }

    /**
     * Gets the value of the correctionNeededComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrectionNeededComments() {
        return correctionNeededComments;
    }

    /**
     * Sets the value of the correctionNeededComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrectionNeededComments(String value) {
        this.correctionNeededComments = value;
    }

    /**
     * Gets the value of the debtEquityOtherComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDebtEquityOtherComments() {
        return debtEquityOtherComments;
    }

    /**
     * Sets the value of the debtEquityOtherComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebtEquityOtherComments(String value) {
        this.debtEquityOtherComments = value;
    }

    public Correction withProblemStatement(String value) {
        setProblemStatement(value);
        return this;
    }

    public Correction withActionNeededByDt(XMLGregorianCalendar value) {
        setActionNeededByDt(value);
        return this;
    }

    public Correction withCorrectionNeededComments(String value) {
        setCorrectionNeededComments(value);
        return this;
    }

    public Correction withDebtEquityOtherComments(String value) {
        setDebtEquityOtherComments(value);
        return this;
    }

}
