//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 *         &lt;element name="USFeeDetails" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://treasury.ge.com/schemas/ALOC/APM/FeeDetails.xsd}FeeDetails" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="US_Total_Amendment" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="US_Total_Payment" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="US_Total_Amendment_String" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="US_Total_Payment_String" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ForeignFeeDetails" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://treasury.ge.com/schemas/ALOC/APM/FeeDetails.xsd}FeeDetails" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Foreign_Total_Amendment" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Foreign_Total_Payment" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Foreign_Total_Amendment_String" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Foreign_Total_Payment_String" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "usFeeDetails",
    "usTotalAmendment",
    "usTotalPayment",
    "usTotalAmendmentString",
    "usTotalPaymentString",
    "foreignFeeDetails",
    "foreignTotalAmendment",
    "foreignTotalPayment",
    "foreignTotalAmendmentString",
    "foreignTotalPaymentString"
})
@XmlRootElement(name = "USForeignFee", namespace = "http://treasury.ge.com/schemas/ALOC/APM/USForeignFee.xsd")
public class USForeignFee
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "USFeeDetails", namespace = "http://treasury.ge.com/schemas/ALOC/APM/USForeignFee.xsd")
    protected USForeignFee.USFeeDetails usFeeDetails;
    @XmlElement(name = "US_Total_Amendment", namespace = "http://treasury.ge.com/schemas/ALOC/APM/USForeignFee.xsd")
    protected BigDecimal usTotalAmendment;
    @XmlElement(name = "US_Total_Payment", namespace = "http://treasury.ge.com/schemas/ALOC/APM/USForeignFee.xsd")
    protected BigDecimal usTotalPayment;
    @XmlElement(name = "US_Total_Amendment_String", namespace = "http://treasury.ge.com/schemas/ALOC/APM/USForeignFee.xsd")
    protected String usTotalAmendmentString;
    @XmlElement(name = "US_Total_Payment_String", namespace = "http://treasury.ge.com/schemas/ALOC/APM/USForeignFee.xsd")
    protected String usTotalPaymentString;
    @XmlElement(name = "ForeignFeeDetails", namespace = "http://treasury.ge.com/schemas/ALOC/APM/USForeignFee.xsd")
    protected USForeignFee.ForeignFeeDetails foreignFeeDetails;
    @XmlElement(name = "Foreign_Total_Amendment", namespace = "http://treasury.ge.com/schemas/ALOC/APM/USForeignFee.xsd")
    protected BigDecimal foreignTotalAmendment;
    @XmlElement(name = "Foreign_Total_Payment", namespace = "http://treasury.ge.com/schemas/ALOC/APM/USForeignFee.xsd")
    protected BigDecimal foreignTotalPayment;
    @XmlElement(name = "Foreign_Total_Amendment_String", namespace = "http://treasury.ge.com/schemas/ALOC/APM/USForeignFee.xsd")
    protected String foreignTotalAmendmentString;
    @XmlElement(name = "Foreign_Total_Payment_String", namespace = "http://treasury.ge.com/schemas/ALOC/APM/USForeignFee.xsd")
    protected String foreignTotalPaymentString;

    /**
     * Gets the value of the usFeeDetails property.
     * 
     * @return
     *     possible object is
     *     {@link USForeignFee.USFeeDetails }
     *     
     */
    public USForeignFee.USFeeDetails getUSFeeDetails() {
        return usFeeDetails;
    }

    /**
     * Sets the value of the usFeeDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link USForeignFee.USFeeDetails }
     *     
     */
    public void setUSFeeDetails(USForeignFee.USFeeDetails value) {
        this.usFeeDetails = value;
    }

    /**
     * Gets the value of the usTotalAmendment property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUSTotalAmendment() {
        return usTotalAmendment;
    }

    /**
     * Sets the value of the usTotalAmendment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUSTotalAmendment(BigDecimal value) {
        this.usTotalAmendment = value;
    }

    /**
     * Gets the value of the usTotalPayment property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUSTotalPayment() {
        return usTotalPayment;
    }

    /**
     * Sets the value of the usTotalPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUSTotalPayment(BigDecimal value) {
        this.usTotalPayment = value;
    }

    /**
     * Gets the value of the usTotalAmendmentString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSTotalAmendmentString() {
        return usTotalAmendmentString;
    }

    /**
     * Sets the value of the usTotalAmendmentString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSTotalAmendmentString(String value) {
        this.usTotalAmendmentString = value;
    }

    /**
     * Gets the value of the usTotalPaymentString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSTotalPaymentString() {
        return usTotalPaymentString;
    }

    /**
     * Sets the value of the usTotalPaymentString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSTotalPaymentString(String value) {
        this.usTotalPaymentString = value;
    }

    /**
     * Gets the value of the foreignFeeDetails property.
     * 
     * @return
     *     possible object is
     *     {@link USForeignFee.ForeignFeeDetails }
     *     
     */
    public USForeignFee.ForeignFeeDetails getForeignFeeDetails() {
        return foreignFeeDetails;
    }

    /**
     * Sets the value of the foreignFeeDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link USForeignFee.ForeignFeeDetails }
     *     
     */
    public void setForeignFeeDetails(USForeignFee.ForeignFeeDetails value) {
        this.foreignFeeDetails = value;
    }

    /**
     * Gets the value of the foreignTotalAmendment property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getForeignTotalAmendment() {
        return foreignTotalAmendment;
    }

    /**
     * Sets the value of the foreignTotalAmendment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setForeignTotalAmendment(BigDecimal value) {
        this.foreignTotalAmendment = value;
    }

    /**
     * Gets the value of the foreignTotalPayment property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getForeignTotalPayment() {
        return foreignTotalPayment;
    }

    /**
     * Sets the value of the foreignTotalPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setForeignTotalPayment(BigDecimal value) {
        this.foreignTotalPayment = value;
    }

    /**
     * Gets the value of the foreignTotalAmendmentString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignTotalAmendmentString() {
        return foreignTotalAmendmentString;
    }

    /**
     * Sets the value of the foreignTotalAmendmentString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignTotalAmendmentString(String value) {
        this.foreignTotalAmendmentString = value;
    }

    /**
     * Gets the value of the foreignTotalPaymentString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignTotalPaymentString() {
        return foreignTotalPaymentString;
    }

    /**
     * Sets the value of the foreignTotalPaymentString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignTotalPaymentString(String value) {
        this.foreignTotalPaymentString = value;
    }

    public USForeignFee withUSFeeDetails(USForeignFee.USFeeDetails value) {
        setUSFeeDetails(value);
        return this;
    }

    public USForeignFee withUSTotalAmendment(BigDecimal value) {
        setUSTotalAmendment(value);
        return this;
    }

    public USForeignFee withUSTotalPayment(BigDecimal value) {
        setUSTotalPayment(value);
        return this;
    }

    public USForeignFee withUSTotalAmendmentString(String value) {
        setUSTotalAmendmentString(value);
        return this;
    }

    public USForeignFee withUSTotalPaymentString(String value) {
        setUSTotalPaymentString(value);
        return this;
    }

    public USForeignFee withForeignFeeDetails(USForeignFee.ForeignFeeDetails value) {
        setForeignFeeDetails(value);
        return this;
    }

    public USForeignFee withForeignTotalAmendment(BigDecimal value) {
        setForeignTotalAmendment(value);
        return this;
    }

    public USForeignFee withForeignTotalPayment(BigDecimal value) {
        setForeignTotalPayment(value);
        return this;
    }

    public USForeignFee withForeignTotalAmendmentString(String value) {
        setForeignTotalAmendmentString(value);
        return this;
    }

    public USForeignFee withForeignTotalPaymentString(String value) {
        setForeignTotalPaymentString(value);
        return this;
    }


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
     *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/APM/FeeDetails.xsd}FeeDetails" maxOccurs="unbounded" minOccurs="0"/>
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
        "feeDetails"
    })
    public static class ForeignFeeDetails
        extends JAXBObjectSecureSerializer
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        @XmlElement(name = "FeeDetails", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeeDetails.xsd")
        protected List<FeeDetails> feeDetails;

        /**
         * Gets the value of the feeDetails property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the feeDetails property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFeeDetails().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FeeDetails }
         * 
         * 
         */
        public List<FeeDetails> getFeeDetails() {
            if (feeDetails == null) {
                feeDetails = new ArrayList<FeeDetails>();
            }
            return this.feeDetails;
        }

        public USForeignFee.ForeignFeeDetails withFeeDetails(FeeDetails... values) {
            if (values!= null) {
                for (FeeDetails value: values) {
                    getFeeDetails().add(value);
                }
            }
            return this;
        }

        public USForeignFee.ForeignFeeDetails withFeeDetails(Collection<FeeDetails> values) {
            if (values!= null) {
                getFeeDetails().addAll(values);
            }
            return this;
        }

        /**
         * Sets the value of the feeDetails property.
         * 
         * @param feeDetails
         *     allowed object is
         *     {@link FeeDetails }
         *     
         */
        public void setFeeDetails(List<FeeDetails> feeDetails) {
            this.feeDetails = feeDetails;
        }

    }


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
     *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/APM/FeeDetails.xsd}FeeDetails" maxOccurs="unbounded" minOccurs="0"/>
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
        "feeDetails"
    })
    public static class USFeeDetails
        extends JAXBObjectSecureSerializer
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        @XmlElement(name = "FeeDetails", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeeDetails.xsd")
        protected List<FeeDetails> feeDetails;

        /**
         * Gets the value of the feeDetails property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the feeDetails property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFeeDetails().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FeeDetails }
         * 
         * 
         */
        public List<FeeDetails> getFeeDetails() {
            if (feeDetails == null) {
                feeDetails = new ArrayList<FeeDetails>();
            }
            return this.feeDetails;
        }

        public USForeignFee.USFeeDetails withFeeDetails(FeeDetails... values) {
            if (values!= null) {
                for (FeeDetails value: values) {
                    getFeeDetails().add(value);
                }
            }
            return this;
        }

        public USForeignFee.USFeeDetails withFeeDetails(Collection<FeeDetails> values) {
            if (values!= null) {
                getFeeDetails().addAll(values);
            }
            return this;
        }

        /**
         * Sets the value of the feeDetails property.
         * 
         * @param feeDetails
         *     allowed object is
         *     {@link FeeDetails }
         *     
         */
        public void setFeeDetails(List<FeeDetails> feeDetails) {
            this.feeDetails = feeDetails;
        }

    }

}