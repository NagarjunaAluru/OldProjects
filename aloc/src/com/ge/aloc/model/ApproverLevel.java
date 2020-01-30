//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.hydus.hwf.jaxb.adapters.XMLDatetimeAsCalendarAdapter;
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
 *         &lt;element name="First_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Last_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sso_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Level_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Approved_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
    "firstName",
    "lastName",
    "ssoId",
    "levelId",
    "approvedDate"
})
@XmlRootElement(name = "ApproverLevel", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd")
public class ApproverLevel
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "First_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd")
    protected String firstName;
    @XmlElement(name = "Last_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd")
    protected String lastName;
    @XmlElement(name = "Sso_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd")
    protected String ssoId;
    @XmlElement(name = "Level_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd")
    protected Integer levelId;
    @XmlElement(name = "Approved_Date", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar approvedDate;

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the ssoId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsoId() {
        return ssoId;
    }

    /**
     * Sets the value of the ssoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsoId(String value) {
        this.ssoId = value;
    }

    /**
     * Gets the value of the levelId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLevelId() {
        return levelId;
    }

    /**
     * Sets the value of the levelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLevelId(Integer value) {
        this.levelId = value;
    }

    /**
     * Gets the value of the approvedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getApprovedDate() {
        return approvedDate;
    }

    /**
     * Sets the value of the approvedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovedDate(Calendar value) {
        this.approvedDate = value;
    }

    public ApproverLevel withFirstName(String value) {
        setFirstName(value);
        return this;
    }

    public ApproverLevel withLastName(String value) {
        setLastName(value);
        return this;
    }

    public ApproverLevel withSsoId(String value) {
        setSsoId(value);
        return this;
    }

    public ApproverLevel withLevelId(Integer value) {
        setLevelId(value);
        return this;
    }

    public ApproverLevel withApprovedDate(Calendar value) {
        setApprovedDate(value);
        return this;
    }

}