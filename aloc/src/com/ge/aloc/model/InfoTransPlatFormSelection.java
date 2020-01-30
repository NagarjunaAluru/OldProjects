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
 *         &lt;element name="SWIFT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ALOC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "swift",
    "aloc"
})
@XmlRootElement(name = "InfoTransPlatFormSelection", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/InfoTransPlatFormSelection.xsd")
public class InfoTransPlatFormSelection
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "SWIFT", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/InfoTransPlatFormSelection.xsd")
    protected String swift;
    @XmlElement(name = "ALOC", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/InfoTransPlatFormSelection.xsd")
    protected String aloc;

    /**
     * Gets the value of the swift property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSWIFT() {
        return swift;
    }

    /**
     * Sets the value of the swift property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSWIFT(String value) {
        this.swift = value;
    }

    /**
     * Gets the value of the aloc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getALOC() {
        return aloc;
    }

    /**
     * Sets the value of the aloc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setALOC(String value) {
        this.aloc = value;
    }

    public InfoTransPlatFormSelection withSWIFT(String value) {
        setSWIFT(value);
        return this;
    }

    public InfoTransPlatFormSelection withALOC(String value) {
        setALOC(value);
        return this;
    }

}
