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
 *         &lt;element name="Drawdown_Notice_Attached_Flag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Drawdown_Value_Dt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Drawdown_Amt" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
    "drawdownNoticeAttachedFlag",
    "drawdownValueDt",
    "drawdownAmt"
})
@XmlRootElement(name = "DrawDown", namespace = "http://treasury.ge.com/schemas/ICFP/DrawDown.xsd")
public class DrawDown
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Drawdown_Notice_Attached_Flag", namespace = "http://treasury.ge.com/schemas/ICFP/DrawDown.xsd")
    protected Boolean drawdownNoticeAttachedFlag;
    @XmlElement(name = "Drawdown_Value_Dt", namespace = "http://treasury.ge.com/schemas/ICFP/DrawDown.xsd")
    protected XMLGregorianCalendar drawdownValueDt;
    @XmlElement(name = "Drawdown_Amt", namespace = "http://treasury.ge.com/schemas/ICFP/DrawDown.xsd")
    protected Double drawdownAmt;

    /**
     * Gets the value of the drawdownNoticeAttachedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDrawdownNoticeAttachedFlag() {
        return drawdownNoticeAttachedFlag;
    }

    /**
     * Sets the value of the drawdownNoticeAttachedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDrawdownNoticeAttachedFlag(Boolean value) {
        this.drawdownNoticeAttachedFlag = value;
    }

    /**
     * Gets the value of the drawdownValueDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDrawdownValueDt() {
        return drawdownValueDt;
    }

    /**
     * Sets the value of the drawdownValueDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDrawdownValueDt(XMLGregorianCalendar value) {
        this.drawdownValueDt = value;
    }

    /**
     * Gets the value of the drawdownAmt property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDrawdownAmt() {
        return drawdownAmt;
    }

    /**
     * Sets the value of the drawdownAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDrawdownAmt(Double value) {
        this.drawdownAmt = value;
    }

    public DrawDown withDrawdownNoticeAttachedFlag(Boolean value) {
        setDrawdownNoticeAttachedFlag(value);
        return this;
    }

    public DrawDown withDrawdownValueDt(XMLGregorianCalendar value) {
        setDrawdownValueDt(value);
        return this;
    }

    public DrawDown withDrawdownAmt(Double value) {
        setDrawdownAmt(value);
        return this;
    }

}