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
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/MsgHeader.xsd}Msg_Header" minOccurs="0"/>
 *         &lt;element name="Request_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd}AmendmentDetails" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderDetails.xsd}RiderDetails" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/RequestStatusDetails.xsd}RequestStatusDetails" minOccurs="0"/>
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
    "msgHeader",
    "requestId",
    "amendmentDetails",
    "riderDetails",
    "requestStatusDetails"
})
@XmlRootElement(name = "GetAmendmentRiders", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/GetAmendmentRiders.xsd")
public class GetAmendmentRiders
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Msg_Header", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/MsgHeader.xsd")
    protected MsgHeader msgHeader;
    @XmlElement(name = "Request_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/GetAmendmentRiders.xsd")
    protected BigInteger requestId;
    @XmlElement(name = "AmendmentDetails", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd")
    protected List<AmendmentDetails> amendmentDetails;
    @XmlElement(name = "RiderDetails", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RiderDetails.xsd")
    protected List<RiderDetails> riderDetails;
    @XmlElement(name = "RequestStatusDetails", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/RequestStatusDetails.xsd")
    protected RequestStatusDetails requestStatusDetails;

    /**
     * Gets the value of the msgHeader property.
     * 
     * @return
     *     possible object is
     *     {@link MsgHeader }
     *     
     */
    public MsgHeader getMsgHeader() {
        return msgHeader;
    }

    /**
     * Sets the value of the msgHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgHeader }
     *     
     */
    public void setMsgHeader(MsgHeader value) {
        this.msgHeader = value;
    }

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRequestId(BigInteger value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the amendmentDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the amendmentDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmendmentDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmendmentDetails }
     * 
     * 
     */
    public List<AmendmentDetails> getAmendmentDetails() {
        if (amendmentDetails == null) {
            amendmentDetails = new ArrayList<AmendmentDetails>();
        }
        return this.amendmentDetails;
    }

    /**
     * Gets the value of the riderDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the riderDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRiderDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RiderDetails }
     * 
     * 
     */
    public List<RiderDetails> getRiderDetails() {
        if (riderDetails == null) {
            riderDetails = new ArrayList<RiderDetails>();
        }
        return this.riderDetails;
    }

    /**
     * Gets the value of the requestStatusDetails property.
     * 
     * @return
     *     possible object is
     *     {@link RequestStatusDetails }
     *     
     */
    public RequestStatusDetails getRequestStatusDetails() {
        return requestStatusDetails;
    }

    /**
     * Sets the value of the requestStatusDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestStatusDetails }
     *     
     */
    public void setRequestStatusDetails(RequestStatusDetails value) {
        this.requestStatusDetails = value;
    }

    public GetAmendmentRiders withMsgHeader(MsgHeader value) {
        setMsgHeader(value);
        return this;
    }

    public GetAmendmentRiders withRequestId(BigInteger value) {
        setRequestId(value);
        return this;
    }

    public GetAmendmentRiders withAmendmentDetails(AmendmentDetails... values) {
        if (values!= null) {
            for (AmendmentDetails value: values) {
                getAmendmentDetails().add(value);
            }
        }
        return this;
    }

    public GetAmendmentRiders withAmendmentDetails(Collection<AmendmentDetails> values) {
        if (values!= null) {
            getAmendmentDetails().addAll(values);
        }
        return this;
    }

    public GetAmendmentRiders withRiderDetails(RiderDetails... values) {
        if (values!= null) {
            for (RiderDetails value: values) {
                getRiderDetails().add(value);
            }
        }
        return this;
    }

    public GetAmendmentRiders withRiderDetails(Collection<RiderDetails> values) {
        if (values!= null) {
            getRiderDetails().addAll(values);
        }
        return this;
    }

    public GetAmendmentRiders withRequestStatusDetails(RequestStatusDetails value) {
        setRequestStatusDetails(value);
        return this;
    }

    /**
     * Sets the value of the amendmentDetails property.
     * 
     * @param amendmentDetails
     *     allowed object is
     *     {@link AmendmentDetails }
     *     
     */
    public void setAmendmentDetails(List<AmendmentDetails> amendmentDetails) {
        this.amendmentDetails = amendmentDetails;
    }

    /**
     * Sets the value of the riderDetails property.
     * 
     * @param riderDetails
     *     allowed object is
     *     {@link RiderDetails }
     *     
     */
    public void setRiderDetails(List<RiderDetails> riderDetails) {
        this.riderDetails = riderDetails;
    }

}