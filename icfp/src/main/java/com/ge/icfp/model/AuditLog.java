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
 *         &lt;element name="Field_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Old_Value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="New_Value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Audit_Creator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Audit_Created_Dt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Leg_Seq_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "fieldName",
    "oldValue",
    "newValue",
    "auditCreator",
    "auditCreatedDt",
    "author",
    "legSeqId"
})
@XmlRootElement(name = "Audit_Log", namespace = "http://treasury.ge.com/schemas/ICFP/AuditLog.xsd")
public class AuditLog
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Field_Name", namespace = "http://treasury.ge.com/schemas/ICFP/AuditLog.xsd")
    protected String fieldName;
    @XmlElement(name = "Old_Value", namespace = "http://treasury.ge.com/schemas/ICFP/AuditLog.xsd")
    protected String oldValue;
    @XmlElement(name = "New_Value", namespace = "http://treasury.ge.com/schemas/ICFP/AuditLog.xsd")
    protected String newValue;
    @XmlElement(name = "Audit_Creator", namespace = "http://treasury.ge.com/schemas/ICFP/AuditLog.xsd")
    protected String auditCreator;
    @XmlElement(name = "Audit_Created_Dt", namespace = "http://treasury.ge.com/schemas/ICFP/AuditLog.xsd")
    protected String auditCreatedDt;
    @XmlElement(name = "Author", namespace = "http://treasury.ge.com/schemas/ICFP/AuditLog.xsd")
    protected String author;
    @XmlElement(name = "Leg_Seq_Id", namespace = "http://treasury.ge.com/schemas/ICFP/AuditLog.xsd")
    protected Integer legSeqId;

    /**
     * Gets the value of the fieldName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Sets the value of the fieldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldName(String value) {
        this.fieldName = value;
    }

    /**
     * Gets the value of the oldValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * Sets the value of the oldValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldValue(String value) {
        this.oldValue = value;
    }

    /**
     * Gets the value of the newValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * Sets the value of the newValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewValue(String value) {
        this.newValue = value;
    }

    /**
     * Gets the value of the auditCreator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditCreator() {
        return auditCreator;
    }

    /**
     * Sets the value of the auditCreator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditCreator(String value) {
        this.auditCreator = value;
    }

    /**
     * Gets the value of the auditCreatedDt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditCreatedDt() {
        return auditCreatedDt;
    }

    /**
     * Sets the value of the auditCreatedDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditCreatedDt(String value) {
        this.auditCreatedDt = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the legSeqId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLegSeqId() {
        return legSeqId;
    }

    /**
     * Sets the value of the legSeqId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLegSeqId(Integer value) {
        this.legSeqId = value;
    }

    public AuditLog withFieldName(String value) {
        setFieldName(value);
        return this;
    }

    public AuditLog withOldValue(String value) {
        setOldValue(value);
        return this;
    }

    public AuditLog withNewValue(String value) {
        setNewValue(value);
        return this;
    }

    public AuditLog withAuditCreator(String value) {
        setAuditCreator(value);
        return this;
    }

    public AuditLog withAuditCreatedDt(String value) {
        setAuditCreatedDt(value);
        return this;
    }

    public AuditLog withAuthor(String value) {
        setAuthor(value);
        return this;
    }

    public AuditLog withLegSeqId(Integer value) {
        setLegSeqId(value);
        return this;
    }

}