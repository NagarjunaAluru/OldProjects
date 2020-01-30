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
 *         &lt;element name="Site_Type_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Site_Type_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "siteTypeId",
    "siteTypeName"
})
@XmlRootElement(name = "Act_Site_Selection", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/ActiveAnnouncement.xsd")
public class ActSiteSelection
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Site_Type_Id", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/ActiveAnnouncement.xsd")
    protected Integer siteTypeId;
    @XmlElement(name = "Site_Type_Name", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/ActiveAnnouncement.xsd")
    protected String siteTypeName;

    /**
     * Gets the value of the siteTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSiteTypeId() {
        return siteTypeId;
    }

    /**
     * Sets the value of the siteTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSiteTypeId(Integer value) {
        this.siteTypeId = value;
    }

    /**
     * Gets the value of the siteTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteTypeName() {
        return siteTypeName;
    }

    /**
     * Sets the value of the siteTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteTypeName(String value) {
        this.siteTypeName = value;
    }

    public ActSiteSelection withSiteTypeId(Integer value) {
        setSiteTypeId(value);
        return this;
    }

    public ActSiteSelection withSiteTypeName(String value) {
        setSiteTypeName(value);
        return this;
    }

}
