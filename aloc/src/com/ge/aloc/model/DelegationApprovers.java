//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd}DelegationGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ALOC_Request_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Approval_Level_Required" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd}ApproverLevel" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Instrument_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "delegationGroups",
    "alocRequestId",
    "approvalLevelRequired",
    "approverLevels",
    "instrumentType"
})
@XmlRootElement(name = "DelegationApprovers", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd")
public class DelegationApprovers
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "DelegationGroup", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd")
    protected List<DelegationGroup> delegationGroups;
    @XmlElement(name = "ALOC_Request_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd")
    protected BigInteger alocRequestId;
    @XmlElement(name = "Approval_Level_Required", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd")
    protected Integer approvalLevelRequired;
    @XmlElement(name = "ApproverLevel", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd")
    protected List<ApproverLevel> approverLevels;
    @XmlElement(name = "Instrument_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/DelegationApprovers.xsd")
    protected String instrumentType;

    /**
     * Gets the value of the delegationGroups property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the delegationGroups property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDelegationGroups().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DelegationGroup }
     * 
     * 
     */
    public List<DelegationGroup> getDelegationGroups() {
        if (delegationGroups == null) {
            delegationGroups = new ArrayList<DelegationGroup>();
        }
        return this.delegationGroups;
    }

    /**
     * Gets the value of the alocRequestId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getALOCRequestId() {
        return alocRequestId;
    }

    /**
     * Sets the value of the alocRequestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setALOCRequestId(BigInteger value) {
        this.alocRequestId = value;
    }

    /**
     * Gets the value of the approvalLevelRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getApprovalLevelRequired() {
        return approvalLevelRequired;
    }

    /**
     * Sets the value of the approvalLevelRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setApprovalLevelRequired(Integer value) {
        this.approvalLevelRequired = value;
    }

    /**
     * Gets the value of the approverLevels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the approverLevels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApproverLevels().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApproverLevel }
     * 
     * 
     */
    public List<ApproverLevel> getApproverLevels() {
        if (approverLevels == null) {
            approverLevels = new ArrayList<ApproverLevel>();
        }
        return this.approverLevels;
    }

    /**
     * Gets the value of the instrumentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrumentType() {
        return instrumentType;
    }

    /**
     * Sets the value of the instrumentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrumentType(String value) {
        this.instrumentType = value;
    }

    public DelegationApprovers withDelegationGroups(DelegationGroup... values) {
        if (values!= null) {
            for (DelegationGroup value: values) {
                getDelegationGroups().add(value);
            }
        }
        return this;
    }

    public DelegationApprovers withDelegationGroups(Collection<DelegationGroup> values) {
        if (values!= null) {
            getDelegationGroups().addAll(values);
        }
        return this;
    }

    public DelegationApprovers withALOCRequestId(BigInteger value) {
        setALOCRequestId(value);
        return this;
    }

    public DelegationApprovers withApprovalLevelRequired(Integer value) {
        setApprovalLevelRequired(value);
        return this;
    }

    public DelegationApprovers withApproverLevels(ApproverLevel... values) {
        if (values!= null) {
            for (ApproverLevel value: values) {
                getApproverLevels().add(value);
            }
        }
        return this;
    }

    public DelegationApprovers withApproverLevels(Collection<ApproverLevel> values) {
        if (values!= null) {
            getApproverLevels().addAll(values);
        }
        return this;
    }

    public DelegationApprovers withInstrumentType(String value) {
        setInstrumentType(value);
        return this;
    }

    /**
     * Sets the value of the delegationGroups property.
     * 
     * @param delegationGroups
     *     allowed object is
     *     {@link DelegationGroup }
     *     
     */
    public void setDelegationGroups(List<DelegationGroup> delegationGroups) {
        this.delegationGroups = delegationGroups;
    }

    /**
     * Sets the value of the approverLevels property.
     * 
     * @param approverLevels
     *     allowed object is
     *     {@link ApproverLevel }
     *     
     */
    public void setApproverLevels(List<ApproverLevel> approverLevels) {
        this.approverLevels = approverLevels;
    }

}