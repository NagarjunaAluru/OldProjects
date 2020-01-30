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
 *         &lt;element name="Adjustments" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Adjustments_Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
    "adjustments",
    "adjustmentsAmount"
})
@XmlRootElement(name = "Post_Bid_Reply_Fee_Adjustment", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/CurrentBankFess.xsd")
public class PostBidReplyFeeAdjustment
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Adjustments", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/CurrentBankFess.xsd")
    protected BigDecimal adjustments;
    @XmlElement(name = "Adjustments_Amount", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/CurrentBankFess.xsd")
    protected BigDecimal adjustmentsAmount;

    /**
     * Gets the value of the adjustments property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAdjustments() {
        return adjustments;
    }

    /**
     * Sets the value of the adjustments property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAdjustments(BigDecimal value) {
        this.adjustments = value;
    }

    /**
     * Gets the value of the adjustmentsAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAdjustmentsAmount() {
        return adjustmentsAmount;
    }

    /**
     * Sets the value of the adjustmentsAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAdjustmentsAmount(BigDecimal value) {
        this.adjustmentsAmount = value;
    }

    public PostBidReplyFeeAdjustment withAdjustments(BigDecimal value) {
        setAdjustments(value);
        return this;
    }

    public PostBidReplyFeeAdjustment withAdjustmentsAmount(BigDecimal value) {
        setAdjustmentsAmount(value);
        return this;
    }

}
