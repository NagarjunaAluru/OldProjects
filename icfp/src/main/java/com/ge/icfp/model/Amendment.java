//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.08 at 07:56:29 PM IST 
//


package com.ge.icfp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
 *         &lt;element name="Amendment_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amendment_Details_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Amendment_Opcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amendment_Type_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Requested_Exception" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Rationale_For_Exception_Impact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Exception_Timeline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Exception_Timeline_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Rationale_For_Exception_Potential_Alternatives" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remediation_Timeline_Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remediation_Timeline_Timeframe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ICFP/Attachments.xsd}Attachment" maxOccurs="unbounded" minOccurs="0"/>
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
    "amendmentType",
    "amendmentDetailsId",
    "amendmentOpcode",
    "amendmentTypeId",
    "requestedException",
    "rationaleForExceptionImpact",
    "exceptionTimeline",
    "exceptionTimelineId",
    "rationaleForExceptionPotentialAlternatives",
    "remediationTimelineComments",
    "remediationTimelineTimeframe",
    "attachments"
})
@XmlRootElement(name = "Amendment", namespace = "http://treasury.ge.com/schemas/ICFP/Amendment.xsd")
public class Amendment
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Amendment_Type", namespace = "http://treasury.ge.com/schemas/ICFP/Amendment.xsd")
    protected String amendmentType;
    @XmlElement(name = "Amendment_Details_Id", namespace = "http://treasury.ge.com/schemas/ICFP/Amendment.xsd")
    protected Integer amendmentDetailsId;
    @XmlElement(name = "Amendment_Opcode", namespace = "http://treasury.ge.com/schemas/ICFP/Amendment.xsd")
    protected String amendmentOpcode;
    @XmlElement(name = "Amendment_Type_Id", namespace = "http://treasury.ge.com/schemas/ICFP/Amendment.xsd")
    protected Integer amendmentTypeId;
    @XmlElement(name = "Requested_Exception", namespace = "http://treasury.ge.com/schemas/ICFP/Amendment.xsd")
    protected String requestedException;
    @XmlElement(name = "Rationale_For_Exception_Impact", namespace = "http://treasury.ge.com/schemas/ICFP/Amendment.xsd")
    protected String rationaleForExceptionImpact;
    @XmlElement(name = "Exception_Timeline", namespace = "http://treasury.ge.com/schemas/ICFP/Amendment.xsd")
    protected String exceptionTimeline;
    @XmlElement(name = "Exception_Timeline_Id", namespace = "http://treasury.ge.com/schemas/ICFP/Amendment.xsd")
    protected Integer exceptionTimelineId;
    @XmlElement(name = "Rationale_For_Exception_Potential_Alternatives", namespace = "http://treasury.ge.com/schemas/ICFP/Amendment.xsd")
    protected String rationaleForExceptionPotentialAlternatives;
    @XmlElement(name = "Remediation_Timeline_Comments", namespace = "http://treasury.ge.com/schemas/ICFP/Amendment.xsd")
    protected String remediationTimelineComments;
    @XmlElement(name = "Remediation_Timeline_Timeframe", namespace = "http://treasury.ge.com/schemas/ICFP/Amendment.xsd")
    protected String remediationTimelineTimeframe;
    @XmlElement(name = "Attachment", namespace = "http://treasury.ge.com/schemas/ICFP/Attachments.xsd")
    protected List<Attachment> attachments;

    /**
     * Gets the value of the amendmentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmendmentType() {
        return amendmentType;
    }

    /**
     * Sets the value of the amendmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmendmentType(String value) {
        this.amendmentType = value;
    }

    /**
     * Gets the value of the amendmentDetailsId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAmendmentDetailsId() {
        return amendmentDetailsId;
    }

    /**
     * Sets the value of the amendmentDetailsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAmendmentDetailsId(Integer value) {
        this.amendmentDetailsId = value;
    }

    /**
     * Gets the value of the amendmentOpcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmendmentOpcode() {
        return amendmentOpcode;
    }

    /**
     * Sets the value of the amendmentOpcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmendmentOpcode(String value) {
        this.amendmentOpcode = value;
    }

    /**
     * Gets the value of the amendmentTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAmendmentTypeId() {
        return amendmentTypeId;
    }

    /**
     * Sets the value of the amendmentTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAmendmentTypeId(Integer value) {
        this.amendmentTypeId = value;
    }

    /**
     * Gets the value of the requestedException property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedException() {
        return requestedException;
    }

    /**
     * Sets the value of the requestedException property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedException(String value) {
        this.requestedException = value;
    }

    /**
     * Gets the value of the rationaleForExceptionImpact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRationaleForExceptionImpact() {
        return rationaleForExceptionImpact;
    }

    /**
     * Sets the value of the rationaleForExceptionImpact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRationaleForExceptionImpact(String value) {
        this.rationaleForExceptionImpact = value;
    }

    /**
     * Gets the value of the exceptionTimeline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionTimeline() {
        return exceptionTimeline;
    }

    /**
     * Sets the value of the exceptionTimeline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionTimeline(String value) {
        this.exceptionTimeline = value;
    }

    /**
     * Gets the value of the exceptionTimelineId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExceptionTimelineId() {
        return exceptionTimelineId;
    }

    /**
     * Sets the value of the exceptionTimelineId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExceptionTimelineId(Integer value) {
        this.exceptionTimelineId = value;
    }

    /**
     * Gets the value of the rationaleForExceptionPotentialAlternatives property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRationaleForExceptionPotentialAlternatives() {
        return rationaleForExceptionPotentialAlternatives;
    }

    /**
     * Sets the value of the rationaleForExceptionPotentialAlternatives property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRationaleForExceptionPotentialAlternatives(String value) {
        this.rationaleForExceptionPotentialAlternatives = value;
    }

    /**
     * Gets the value of the remediationTimelineComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemediationTimelineComments() {
        return remediationTimelineComments;
    }

    /**
     * Sets the value of the remediationTimelineComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemediationTimelineComments(String value) {
        this.remediationTimelineComments = value;
    }

    /**
     * Gets the value of the remediationTimelineTimeframe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemediationTimelineTimeframe() {
        return remediationTimelineTimeframe;
    }

    /**
     * Sets the value of the remediationTimelineTimeframe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemediationTimelineTimeframe(String value) {
        this.remediationTimelineTimeframe = value;
    }

    /**
     * Gets the value of the attachments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attachment }
     * 
     * 
     */
    public List<Attachment> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<Attachment>();
        }
        return this.attachments;
    }

    public Amendment withAmendmentType(String value) {
        setAmendmentType(value);
        return this;
    }

    public Amendment withAmendmentDetailsId(Integer value) {
        setAmendmentDetailsId(value);
        return this;
    }

    public Amendment withAmendmentOpcode(String value) {
        setAmendmentOpcode(value);
        return this;
    }

    public Amendment withAmendmentTypeId(Integer value) {
        setAmendmentTypeId(value);
        return this;
    }

    public Amendment withRequestedException(String value) {
        setRequestedException(value);
        return this;
    }

    public Amendment withRationaleForExceptionImpact(String value) {
        setRationaleForExceptionImpact(value);
        return this;
    }

    public Amendment withExceptionTimeline(String value) {
        setExceptionTimeline(value);
        return this;
    }

    public Amendment withExceptionTimelineId(Integer value) {
        setExceptionTimelineId(value);
        return this;
    }

    public Amendment withRationaleForExceptionPotentialAlternatives(String value) {
        setRationaleForExceptionPotentialAlternatives(value);
        return this;
    }

    public Amendment withRemediationTimelineComments(String value) {
        setRemediationTimelineComments(value);
        return this;
    }

    public Amendment withRemediationTimelineTimeframe(String value) {
        setRemediationTimelineTimeframe(value);
        return this;
    }

    public Amendment withAttachments(Attachment... values) {
        if (values!= null) {
            for (Attachment value: values) {
                getAttachments().add(value);
            }
        }
        return this;
    }

    public Amendment withAttachments(Collection<Attachment> values) {
        if (values!= null) {
            getAttachments().addAll(values);
        }
        return this;
    }

    /**
     * Sets the value of the attachments property.
     * 
     * @param attachments
     *     allowed object is
     *     {@link Attachment }
     *     
     */
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

}
