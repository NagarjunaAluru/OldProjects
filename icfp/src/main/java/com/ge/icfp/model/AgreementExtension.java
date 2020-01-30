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
 *         &lt;element name="AmendmentMaturity_Dt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Deal_CCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Orig_LegalAgreement_Attached_Flag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "amendmentMaturityDt",
    "dealCCY",
    "origLegalAgreementAttachedFlag"
})
@XmlRootElement(name = "Agreement_Extension", namespace = "http://treasury.ge.com/schemas/ICFP/AgreementExtension.xsd")
public class AgreementExtension
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "AmendmentMaturity_Dt", namespace = "http://treasury.ge.com/schemas/ICFP/AgreementExtension.xsd")
    protected XMLGregorianCalendar amendmentMaturityDt;
    @XmlElement(name = "Deal_CCY", namespace = "http://treasury.ge.com/schemas/ICFP/AgreementExtension.xsd")
    protected String dealCCY;
    @XmlElement(name = "Orig_LegalAgreement_Attached_Flag", namespace = "http://treasury.ge.com/schemas/ICFP/AgreementExtension.xsd")
    protected Boolean origLegalAgreementAttachedFlag;

    /**
     * Gets the value of the amendmentMaturityDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAmendmentMaturityDt() {
        return amendmentMaturityDt;
    }

    /**
     * Sets the value of the amendmentMaturityDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAmendmentMaturityDt(XMLGregorianCalendar value) {
        this.amendmentMaturityDt = value;
    }

    /**
     * Gets the value of the dealCCY property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDealCCY() {
        return dealCCY;
    }

    /**
     * Sets the value of the dealCCY property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDealCCY(String value) {
        this.dealCCY = value;
    }

    /**
     * Gets the value of the origLegalAgreementAttachedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOrigLegalAgreementAttachedFlag() {
        return origLegalAgreementAttachedFlag;
    }

    /**
     * Sets the value of the origLegalAgreementAttachedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOrigLegalAgreementAttachedFlag(Boolean value) {
        this.origLegalAgreementAttachedFlag = value;
    }

    public AgreementExtension withAmendmentMaturityDt(XMLGregorianCalendar value) {
        setAmendmentMaturityDt(value);
        return this;
    }

    public AgreementExtension withDealCCY(String value) {
        setDealCCY(value);
        return this;
    }

    public AgreementExtension withOrigLegalAgreementAttachedFlag(Boolean value) {
        setOrigLegalAgreementAttachedFlag(value);
        return this;
    }

}