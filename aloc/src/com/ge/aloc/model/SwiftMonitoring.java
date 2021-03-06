//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 02:33:06 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
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
 *         &lt;element name="Actions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ALOC_RecordNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ALOC_Record_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amendment_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Type_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sub_MessageType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Date_Time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Range_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Direction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Message_Sequence_Group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/MsgHeader.xsd}Msg_Header" minOccurs="0"/>
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
    "actions",
    "alocRecordNo",
    "alocRecordId",
    "amendmentId",
    "instrumentTypeId",
    "subMessageType",
    "status",
    "dateTime",
    "rangeDate",
    "direction",
    "messageSequenceGroup",
    "instruments",
    "msgHeader"
})
@XmlRootElement(name = "SwiftMonitoring", namespace = "http://treasury.ge.com/schemas/ALOC/Swift/SwiftMonitoring.xsd")
public class SwiftMonitoring
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Actions", namespace = "http://treasury.ge.com/schemas/ALOC/Swift/SwiftMonitoring.xsd")
    protected String actions;
    @XmlElement(name = "ALOC_RecordNo", namespace = "http://treasury.ge.com/schemas/ALOC/Swift/SwiftMonitoring.xsd")
    protected Integer alocRecordNo;
    @XmlElement(name = "ALOC_Record_Id", namespace = "http://treasury.ge.com/schemas/ALOC/Swift/SwiftMonitoring.xsd")
    protected String alocRecordId;
    @XmlElement(name = "Amendment_Id", namespace = "http://treasury.ge.com/schemas/ALOC/Swift/SwiftMonitoring.xsd")
    protected String amendmentId;
    @XmlElement(name = "Instrument_Type_Id", namespace = "http://treasury.ge.com/schemas/ALOC/Swift/SwiftMonitoring.xsd")
    protected String instrumentTypeId;
    @XmlElement(name = "Sub_MessageType", namespace = "http://treasury.ge.com/schemas/ALOC/Swift/SwiftMonitoring.xsd")
    protected String subMessageType;
    @XmlElement(name = "Status", namespace = "http://treasury.ge.com/schemas/ALOC/Swift/SwiftMonitoring.xsd")
    protected String status;
    @XmlElement(name = "Date_Time", namespace = "http://treasury.ge.com/schemas/ALOC/Swift/SwiftMonitoring.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar dateTime;
    @XmlElement(name = "Range_Date", namespace = "http://treasury.ge.com/schemas/ALOC/Swift/SwiftMonitoring.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar rangeDate;
    @XmlElement(name = "Direction", namespace = "http://treasury.ge.com/schemas/ALOC/Swift/SwiftMonitoring.xsd")
    protected String direction;
    @XmlElement(name = "Message_Sequence_Group", namespace = "http://treasury.ge.com/schemas/ALOC/Swift/SwiftMonitoring.xsd")
    protected String messageSequenceGroup;
    @XmlElement(name = "Instrument", namespace = "http://treasury.ge.com/schemas/ALOC/Swift/SwiftMonitoring.xsd")
    protected List<String> instruments;
    @XmlElement(name = "Msg_Header", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/MsgHeader.xsd")
    protected MsgHeader msgHeader;

    /**
     * Gets the value of the actions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActions() {
        return actions;
    }

    /**
     * Sets the value of the actions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActions(String value) {
        this.actions = value;
    }

    /**
     * Gets the value of the alocRecordNo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getALOCRecordNo() {
        return alocRecordNo;
    }

    /**
     * Sets the value of the alocRecordNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setALOCRecordNo(Integer value) {
        this.alocRecordNo = value;
    }

    /**
     * Gets the value of the alocRecordId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getALOCRecordId() {
        return alocRecordId;
    }

    /**
     * Sets the value of the alocRecordId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setALOCRecordId(String value) {
        this.alocRecordId = value;
    }

    /**
     * Gets the value of the amendmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmendmentId() {
        return amendmentId;
    }

    /**
     * Sets the value of the amendmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmendmentId(String value) {
        this.amendmentId = value;
    }

    /**
     * Gets the value of the instrumentTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrumentTypeId() {
        return instrumentTypeId;
    }

    /**
     * Sets the value of the instrumentTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrumentTypeId(String value) {
        this.instrumentTypeId = value;
    }

    /**
     * Gets the value of the subMessageType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubMessageType() {
        return subMessageType;
    }

    /**
     * Sets the value of the subMessageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubMessageType(String value) {
        this.subMessageType = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateTime(Calendar value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the rangeDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getRangeDate() {
        return rangeDate;
    }

    /**
     * Sets the value of the rangeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRangeDate(Calendar value) {
        this.rangeDate = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirection(String value) {
        this.direction = value;
    }

    /**
     * Gets the value of the messageSequenceGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageSequenceGroup() {
        return messageSequenceGroup;
    }

    /**
     * Sets the value of the messageSequenceGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageSequenceGroup(String value) {
        this.messageSequenceGroup = value;
    }

    /**
     * Gets the value of the instruments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instruments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstruments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getInstruments() {
        if (instruments == null) {
            instruments = new ArrayList<String>();
        }
        return this.instruments;
    }

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

    public SwiftMonitoring withActions(String value) {
        setActions(value);
        return this;
    }

    public SwiftMonitoring withALOCRecordNo(Integer value) {
        setALOCRecordNo(value);
        return this;
    }

    public SwiftMonitoring withALOCRecordId(String value) {
        setALOCRecordId(value);
        return this;
    }

    public SwiftMonitoring withAmendmentId(String value) {
        setAmendmentId(value);
        return this;
    }

    public SwiftMonitoring withInstrumentTypeId(String value) {
        setInstrumentTypeId(value);
        return this;
    }

    public SwiftMonitoring withSubMessageType(String value) {
        setSubMessageType(value);
        return this;
    }

    public SwiftMonitoring withStatus(String value) {
        setStatus(value);
        return this;
    }

    public SwiftMonitoring withDateTime(Calendar value) {
        setDateTime(value);
        return this;
    }

    public SwiftMonitoring withRangeDate(Calendar value) {
        setRangeDate(value);
        return this;
    }

    public SwiftMonitoring withDirection(String value) {
        setDirection(value);
        return this;
    }

    public SwiftMonitoring withMessageSequenceGroup(String value) {
        setMessageSequenceGroup(value);
        return this;
    }

    public SwiftMonitoring withInstruments(String... values) {
        if (values!= null) {
            for (String value: values) {
                getInstruments().add(value);
            }
        }
        return this;
    }

    public SwiftMonitoring withInstruments(Collection<String> values) {
        if (values!= null) {
            getInstruments().addAll(values);
        }
        return this;
    }

    public SwiftMonitoring withMsgHeader(MsgHeader value) {
        setMsgHeader(value);
        return this;
    }

    /**
     * Sets the value of the instruments property.
     * 
     * @param instruments
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstruments(List<String> instruments) {
        this.instruments = instruments;
    }

}
