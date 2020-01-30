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
 * <p>Java class for Action_Details_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Action_Details_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Action_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Action_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reason_For_Rejection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reason_For_Opting_Out" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Action_Details_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/ALOCCommon.xsd", propOrder = {
    "actionId",
    "actionName",
    "comments",
    "reasonForRejection",
    "reasonForOptingOut"
})
@XmlRootElement(name = "ActionDetails", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/ALOCCommon.xsd")
public class ActionDetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Action_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/ALOCCommon.xsd")
    protected String actionId;
    @XmlElement(name = "Action_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/ALOCCommon.xsd")
    protected String actionName;
    @XmlElement(name = "Comments", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/ALOCCommon.xsd")
    protected String comments;
    @XmlElement(name = "Reason_For_Rejection", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/ALOCCommon.xsd")
    protected String reasonForRejection;
    @XmlElement(name = "Reason_For_Opting_Out", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/ALOCCommon.xsd")
    protected String reasonForOptingOut;

    /**
     * Gets the value of the actionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionId() {
        return actionId;
    }

    /**
     * Sets the value of the actionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionId(String value) {
        this.actionId = value;
    }

    /**
     * Gets the value of the actionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionName() {
        return actionName;
    }

    /**
     * Sets the value of the actionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionName(String value) {
        this.actionName = value;
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
     * Gets the value of the reasonForRejection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonForRejection() {
        return reasonForRejection;
    }

    /**
     * Sets the value of the reasonForRejection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonForRejection(String value) {
        this.reasonForRejection = value;
    }

    /**
     * Gets the value of the reasonForOptingOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonForOptingOut() {
        return reasonForOptingOut;
    }

    /**
     * Sets the value of the reasonForOptingOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonForOptingOut(String value) {
        this.reasonForOptingOut = value;
    }

    public ActionDetails withActionId(String value) {
        setActionId(value);
        return this;
    }

    public ActionDetails withActionName(String value) {
        setActionName(value);
        return this;
    }

    public ActionDetails withComments(String value) {
        setComments(value);
        return this;
    }

    public ActionDetails withReasonForRejection(String value) {
        setReasonForRejection(value);
        return this;
    }

    public ActionDetails withReasonForOptingOut(String value) {
        setReasonForOptingOut(value);
        return this;
    }

}