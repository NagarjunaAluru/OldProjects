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
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ICFP/TransactionCapture.xsd}Deal_Info" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ICFP/TransactionCapture.xsd}Leg_Info" minOccurs="0"/>
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
    "comments",
    "dealInfo",
    "legInfo",
    "attachments"
})
@XmlRootElement(name = "Transaction_Capture", namespace = "http://treasury.ge.com/schemas/ICFP/TransactionCapture.xsd")
public class TransactionCapture
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Comments", namespace = "http://treasury.ge.com/schemas/ICFP/TransactionCapture.xsd")
    protected String comments;
    @XmlElement(name = "Deal_Info", namespace = "http://treasury.ge.com/schemas/ICFP/TransactionCapture.xsd")
    protected DealInfo dealInfo;
    @XmlElement(name = "Leg_Info", namespace = "http://treasury.ge.com/schemas/ICFP/TransactionCapture.xsd")
    protected LegInfo legInfo;
    @XmlElement(name = "Attachment", namespace = "http://treasury.ge.com/schemas/ICFP/Attachments.xsd")
    protected List<Attachment> attachments;

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
     * Gets the value of the dealInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DealInfo }
     *     
     */
    public DealInfo getDealInfo() {
        return dealInfo;
    }

    /**
     * Sets the value of the dealInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DealInfo }
     *     
     */
    public void setDealInfo(DealInfo value) {
        this.dealInfo = value;
    }

    /**
     * Gets the value of the legInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LegInfo }
     *     
     */
    public LegInfo getLegInfo() {
        return legInfo;
    }

    /**
     * Sets the value of the legInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegInfo }
     *     
     */
    public void setLegInfo(LegInfo value) {
        this.legInfo = value;
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

    public TransactionCapture withComments(String value) {
        setComments(value);
        return this;
    }

    public TransactionCapture withDealInfo(DealInfo value) {
        setDealInfo(value);
        return this;
    }

    public TransactionCapture withLegInfo(LegInfo value) {
        setLegInfo(value);
        return this;
    }

    public TransactionCapture withAttachments(Attachment... values) {
        if (values!= null) {
            for (Attachment value: values) {
                getAttachments().add(value);
            }
        }
        return this;
    }

    public TransactionCapture withAttachments(Collection<Attachment> values) {
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
