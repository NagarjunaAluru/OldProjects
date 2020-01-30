//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.08 at 05:55:46 PM IST 
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
 *         &lt;element name="Approver_Level" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Approver_Sso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Approver_First_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Approver_Last_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Action_Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Group_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "approverLevel",
    "approverSso",
    "approverFirstName",
    "approverLastName",
    "actionStatus",
    "groupName"
})
@XmlRootElement(name = "Bu_Approver", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BuDelegation.xsd")
public class BuApprover
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Approver_Level", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BuDelegation.xsd")
    protected BigInteger approverLevel;
    @XmlElement(name = "Approver_Sso", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BuDelegation.xsd")
    protected String approverSso;
    @XmlElement(name = "Approver_First_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BuDelegation.xsd")
    protected String approverFirstName;
    @XmlElement(name = "Approver_Last_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BuDelegation.xsd")
    protected String approverLastName;
    @XmlElement(name = "Action_Status", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BuDelegation.xsd")
    protected String actionStatus;
    @XmlElement(name = "Group_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/BuDelegation.xsd")
    protected String groupName;

    /**
     * Gets the value of the approverLevel property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getApproverLevel() {
        return approverLevel;
    }

    /**
     * Sets the value of the approverLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setApproverLevel(BigInteger value) {
        this.approverLevel = value;
    }

    /**
     * Gets the value of the approverSso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproverSso() {
        return approverSso;
    }

    /**
     * Sets the value of the approverSso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproverSso(String value) {
        this.approverSso = value;
    }

    /**
     * Gets the value of the approverFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproverFirstName() {
        return approverFirstName;
    }

    /**
     * Sets the value of the approverFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproverFirstName(String value) {
        this.approverFirstName = value;
    }

    /**
     * Gets the value of the approverLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproverLastName() {
        return approverLastName;
    }

    /**
     * Sets the value of the approverLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproverLastName(String value) {
        this.approverLastName = value;
    }

    /**
     * Gets the value of the actionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionStatus() {
        return actionStatus;
    }

    /**
     * Sets the value of the actionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionStatus(String value) {
        this.actionStatus = value;
    }

    /**
     * Gets the value of the groupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the value of the groupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    public BuApprover withApproverLevel(BigInteger value) {
        setApproverLevel(value);
        return this;
    }

    public BuApprover withApproverSso(String value) {
        setApproverSso(value);
        return this;
    }

    public BuApprover withApproverFirstName(String value) {
        setApproverFirstName(value);
        return this;
    }

    public BuApprover withApproverLastName(String value) {
        setApproverLastName(value);
        return this;
    }

    public BuApprover withActionStatus(String value) {
        setActionStatus(value);
        return this;
    }

    public BuApprover withGroupName(String value) {
        setGroupName(value);
        return this;
    }

}