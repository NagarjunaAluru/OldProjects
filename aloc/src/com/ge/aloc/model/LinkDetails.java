//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.math.BigInteger;
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
 *         &lt;element name="Link_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Link_Request_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Linked_Request_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Aloc_Link_Request_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Aloc_Linked_Request_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "linkId",
    "linkRequestId",
    "linkedRequestId",
    "alocLinkRequestId",
    "alocLinkedRequestId"
})
@XmlRootElement(name = "LinkDetails")
public class LinkDetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Link_Id")
    protected BigInteger linkId;
    @XmlElement(name = "Link_Request_Id")
    protected BigInteger linkRequestId;
    @XmlElement(name = "Linked_Request_Id")
    protected BigInteger linkedRequestId;
    @XmlElement(name = "Aloc_Link_Request_Id")
    protected String alocLinkRequestId;
    @XmlElement(name = "Aloc_Linked_Request_Id")
    protected String alocLinkedRequestId;

    /**
     * Gets the value of the linkId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLinkId() {
        return linkId;
    }

    /**
     * Sets the value of the linkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLinkId(BigInteger value) {
        this.linkId = value;
    }

    /**
     * Gets the value of the linkRequestId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLinkRequestId() {
        return linkRequestId;
    }

    /**
     * Sets the value of the linkRequestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLinkRequestId(BigInteger value) {
        this.linkRequestId = value;
    }

    /**
     * Gets the value of the linkedRequestId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLinkedRequestId() {
        return linkedRequestId;
    }

    /**
     * Sets the value of the linkedRequestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLinkedRequestId(BigInteger value) {
        this.linkedRequestId = value;
    }

    /**
     * Gets the value of the alocLinkRequestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlocLinkRequestId() {
        return alocLinkRequestId;
    }

    /**
     * Sets the value of the alocLinkRequestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlocLinkRequestId(String value) {
        this.alocLinkRequestId = value;
    }

    /**
     * Gets the value of the alocLinkedRequestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlocLinkedRequestId() {
        return alocLinkedRequestId;
    }

    /**
     * Sets the value of the alocLinkedRequestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlocLinkedRequestId(String value) {
        this.alocLinkedRequestId = value;
    }

    public LinkDetails withLinkId(BigInteger value) {
        setLinkId(value);
        return this;
    }

    public LinkDetails withLinkRequestId(BigInteger value) {
        setLinkRequestId(value);
        return this;
    }

    public LinkDetails withLinkedRequestId(BigInteger value) {
        setLinkedRequestId(value);
        return this;
    }

    public LinkDetails withAlocLinkRequestId(String value) {
        setAlocLinkRequestId(value);
        return this;
    }

    public LinkDetails withAlocLinkedRequestId(String value) {
        setAlocLinkedRequestId(value);
        return this;
    }

}