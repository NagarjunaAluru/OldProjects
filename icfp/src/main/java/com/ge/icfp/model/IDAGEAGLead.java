//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.17 at 02:12:37 PM IST 
//


package com.ge.icfp.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="Group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSO_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Action_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Approved_SSO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Approved_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Action_Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Action" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "group",
    "ssoid",
    "name",
    "actionFlag",
    "approvedSSO",
    "approvedName",
    "actionDate",
    "action"
})
@XmlRootElement(name = "IDAGEAG_Lead", namespace = "http://treasury.ge.com/schemas/ICFP/IDAGEAGLead.xsd")
public class IDAGEAGLead
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Group", namespace = "http://treasury.ge.com/schemas/ICFP/IDAGEAGLead.xsd")
    protected String group;
    @XmlElement(name = "SSO_ID", namespace = "http://treasury.ge.com/schemas/ICFP/IDAGEAGLead.xsd")
    protected String ssoid;
    @XmlElement(name = "Name", namespace = "http://treasury.ge.com/schemas/ICFP/IDAGEAGLead.xsd")
    protected String name;
    @XmlElement(name = "Action_Flag", namespace = "http://treasury.ge.com/schemas/ICFP/IDAGEAGLead.xsd")
    protected String actionFlag;
    @XmlElement(name = "Approved_SSO", namespace = "http://treasury.ge.com/schemas/ICFP/IDAGEAGLead.xsd")
    protected String approvedSSO;
    @XmlElement(name = "Approved_Name", namespace = "http://treasury.ge.com/schemas/ICFP/IDAGEAGLead.xsd")
    protected String approvedName;
    @XmlElement(name = "Action_Date", namespace = "http://treasury.ge.com/schemas/ICFP/IDAGEAGLead.xsd")
    protected String actionDate;
    @XmlElement(name = "Action", namespace = "http://treasury.ge.com/schemas/ICFP/IDAGEAGLead.xsd")
    protected String action;

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroup(String value) {
        this.group = value;
    }

    /**
     * Gets the value of the ssoid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSOID() {
        return ssoid;
    }

    /**
     * Sets the value of the ssoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSOID(String value) {
        this.ssoid = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the actionFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionFlag() {
        return actionFlag;
    }

    /**
     * Sets the value of the actionFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionFlag(String value) {
        this.actionFlag = value;
    }

    /**
     * Gets the value of the approvedSSO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovedSSO() {
        return approvedSSO;
    }

    /**
     * Sets the value of the approvedSSO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovedSSO(String value) {
        this.approvedSSO = value;
    }

    /**
     * Gets the value of the approvedName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovedName() {
        return approvedName;
    }

    /**
     * Sets the value of the approvedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovedName(String value) {
        this.approvedName = value;
    }

    /**
     * Gets the value of the actionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionDate() {
        return actionDate;
    }

    /**
     * Sets the value of the actionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionDate(String value) {
        this.actionDate = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    public IDAGEAGLead withGroup(String value) {
        setGroup(value);
        return this;
    }

    public IDAGEAGLead withSSOID(String value) {
        setSSOID(value);
        return this;
    }

    public IDAGEAGLead withName(String value) {
        setName(value);
        return this;
    }

    public IDAGEAGLead withActionFlag(String value) {
        setActionFlag(value);
        return this;
    }

    public IDAGEAGLead withApprovedSSO(String value) {
        setApprovedSSO(value);
        return this;
    }

    public IDAGEAGLead withApprovedName(String value) {
        setApprovedName(value);
        return this;
    }

    public IDAGEAGLead withActionDate(String value) {
        setActionDate(value);
        return this;
    }

    public IDAGEAGLead withAction(String value) {
        setAction(value);
        return this;
    }

}
