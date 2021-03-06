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
 *         &lt;element name="Group_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="First_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Last_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Decision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Action_Dt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSO_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "groupName",
    "firstName",
    "lastName",
    "decision",
    "comments",
    "actionDt",
    "ssoid"
})
@XmlRootElement(name = "Action_Log", namespace = "http://treasury.ge.com/schemas/ICFP/ActionLog.xsd")
public class ActionLog
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Group_Name", namespace = "http://treasury.ge.com/schemas/ICFP/ActionLog.xsd")
    protected String groupName;
    @XmlElement(name = "First_Name", namespace = "http://treasury.ge.com/schemas/ICFP/ActionLog.xsd")
    protected String firstName;
    @XmlElement(name = "Last_Name", namespace = "http://treasury.ge.com/schemas/ICFP/ActionLog.xsd")
    protected String lastName;
    @XmlElement(name = "Decision", namespace = "http://treasury.ge.com/schemas/ICFP/ActionLog.xsd")
    protected String decision;
    @XmlElement(name = "Comments", namespace = "http://treasury.ge.com/schemas/ICFP/ActionLog.xsd")
    protected String comments;
    @XmlElement(name = "Action_Dt", namespace = "http://treasury.ge.com/schemas/ICFP/ActionLog.xsd")
    protected String actionDt;
    @XmlElement(name = "SSO_ID", namespace = "http://treasury.ge.com/schemas/ICFP/ActionLog.xsd")
    protected String ssoid;

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
     * Gets the value of the decision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecision() {
        return decision;
    }

    /**
     * Sets the value of the decision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecision(String value) {
        this.decision = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the actionDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionDt() {
        return actionDt;
    }

    /**
     * Sets the value of the actionDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionDt(String value) {
        this.actionDt = value;
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

    public ActionLog withGroupName(String value) {
        setGroupName(value);
        return this;
    }

    public ActionLog withFirstName(String value) {
        setFirstName(value);
        return this;
    }

    public ActionLog withLastName(String value) {
        setLastName(value);
        return this;
    }

    public ActionLog withDecision(String value) {
        setDecision(value);
        return this;
    }

    public ActionLog withComments(String value) {
        setComments(value);
        return this;
    }

    public ActionLog withActionDt(String value) {
        setActionDt(value);
        return this;
    }

    public ActionLog withSSOID(String value) {
        setSSOID(value);
        return this;
    }

}
