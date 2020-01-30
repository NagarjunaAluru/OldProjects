//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.06 at 04:43:04 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
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
 *         &lt;element name="Request_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Amendment_Request_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User_SSO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="First_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Last_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Instrument_Curr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instrument_Curr_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Expiry_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Request_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Inc_Dec_Amt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "requestId",
    "amendmentRequestId",
    "userSSO",
    "firstName",
    "lastName",
    "instrumentAmt",
    "instrumentCurr",
    "instrumentCurrCode",
    "expiryDate",
    "requestDate",
    "incDecAmt"
})
@XmlRootElement(name = "AmendmentDetails", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd")
public class AmendmentDetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Request_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd")
    protected BigInteger requestId;
    @XmlElement(name = "Amendment_Request_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd")
    protected String amendmentRequestId;
    @XmlElement(name = "User_SSO", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd")
    protected String userSSO;
    @XmlElement(name = "First_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd")
    protected String firstName;
    @XmlElement(name = "Last_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd")
    protected String lastName;
    @XmlElement(name = "Instrument_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd")
    protected BigDecimal instrumentAmt;
    @XmlElement(name = "Instrument_Curr", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd")
    protected String instrumentCurr;
    @XmlElement(name = "Instrument_Curr_Code", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd")
    protected String instrumentCurrCode;
    @XmlElement(name = "Expiry_Date", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar expiryDate;
    @XmlElement(name = "Request_Date", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar requestDate;
    @XmlElement(name = "Inc_Dec_Amt", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AmendmentDetails.xsd")
    protected String incDecAmt;

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
     * Gets the value of the amendmentRequestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmendmentRequestId() {
        return amendmentRequestId;
    }

    /**
     * Sets the value of the amendmentRequestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmendmentRequestId(String value) {
        this.amendmentRequestId = value;
    }

    /**
     * Gets the value of the userSSO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserSSO() {
        return userSSO;
    }

    /**
     * Sets the value of the userSSO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserSSO(String value) {
        this.userSSO = value;
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
     * Gets the value of the instrumentAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInstrumentAmt() {
        return instrumentAmt;
    }

    /**
     * Sets the value of the instrumentAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInstrumentAmt(BigDecimal value) {
        this.instrumentAmt = value;
    }

    /**
     * Gets the value of the instrumentCurr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrumentCurr() {
        return instrumentCurr;
    }

    /**
     * Sets the value of the instrumentCurr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrumentCurr(String value) {
        this.instrumentCurr = value;
    }

    /**
     * Gets the value of the instrumentCurrCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrumentCurrCode() {
        return instrumentCurrCode;
    }

    /**
     * Sets the value of the instrumentCurrCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrumentCurrCode(String value) {
        this.instrumentCurrCode = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryDate(Calendar value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the requestDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the value of the requestDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestDate(Calendar value) {
        this.requestDate = value;
    }

    /**
     * Gets the value of the incDecAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncDecAmt() {
        return incDecAmt;
    }

    /**
     * Sets the value of the incDecAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncDecAmt(String value) {
        this.incDecAmt = value;
    }

    public AmendmentDetails withRequestId(BigInteger value) {
        setRequestId(value);
        return this;
    }

    public AmendmentDetails withAmendmentRequestId(String value) {
        setAmendmentRequestId(value);
        return this;
    }

    public AmendmentDetails withUserSSO(String value) {
        setUserSSO(value);
        return this;
    }

    public AmendmentDetails withFirstName(String value) {
        setFirstName(value);
        return this;
    }

    public AmendmentDetails withLastName(String value) {
        setLastName(value);
        return this;
    }

    public AmendmentDetails withInstrumentAmt(BigDecimal value) {
        setInstrumentAmt(value);
        return this;
    }

    public AmendmentDetails withInstrumentCurr(String value) {
        setInstrumentCurr(value);
        return this;
    }

    public AmendmentDetails withInstrumentCurrCode(String value) {
        setInstrumentCurrCode(value);
        return this;
    }

    public AmendmentDetails withExpiryDate(Calendar value) {
        setExpiryDate(value);
        return this;
    }

    public AmendmentDetails withRequestDate(Calendar value) {
        setRequestDate(value);
        return this;
    }

    public AmendmentDetails withIncDecAmt(String value) {
        setIncDecAmt(value);
        return this;
    }

}
