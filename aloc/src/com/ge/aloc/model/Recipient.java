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
 *         &lt;element name="Recipient_First_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Recipient_Last_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Recipient_Sso_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Recipient_Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "recipientFirstName",
    "recipientLastName",
    "recipientSsoId",
    "recipientEmail"
})
@XmlRootElement(name = "Recipient", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DeliveryInstructions.xsd")
public class Recipient
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Recipient_First_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DeliveryInstructions.xsd")
    protected String recipientFirstName;
    @XmlElement(name = "Recipient_Last_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DeliveryInstructions.xsd")
    protected String recipientLastName;
    @XmlElement(name = "Recipient_Sso_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DeliveryInstructions.xsd")
    protected String recipientSsoId;
    @XmlElement(name = "Recipient_Email", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DeliveryInstructions.xsd")
    protected String recipientEmail;

    /**
     * Gets the value of the recipientFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientFirstName() {
        return recipientFirstName;
    }

    /**
     * Sets the value of the recipientFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientFirstName(String value) {
        this.recipientFirstName = value;
    }

    /**
     * Gets the value of the recipientLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientLastName() {
        return recipientLastName;
    }

    /**
     * Sets the value of the recipientLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientLastName(String value) {
        this.recipientLastName = value;
    }

    /**
     * Gets the value of the recipientSsoId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientSsoId() {
        return recipientSsoId;
    }

    /**
     * Sets the value of the recipientSsoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientSsoId(String value) {
        this.recipientSsoId = value;
    }

    /**
     * Gets the value of the recipientEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientEmail() {
        return recipientEmail;
    }

    /**
     * Sets the value of the recipientEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientEmail(String value) {
        this.recipientEmail = value;
    }

    public Recipient withRecipientFirstName(String value) {
        setRecipientFirstName(value);
        return this;
    }

    public Recipient withRecipientLastName(String value) {
        setRecipientLastName(value);
        return this;
    }

    public Recipient withRecipientSsoId(String value) {
        setRecipientSsoId(value);
        return this;
    }

    public Recipient withRecipientEmail(String value) {
        setRecipientEmail(value);
        return this;
    }

}
