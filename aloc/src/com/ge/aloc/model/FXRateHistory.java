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
 *         &lt;element name="OpCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="From_Year" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="To_Year" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/APM/FeePeriodDetails.xsd}FeePeriodDetails" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/APM/GetFXRates.xsd}GetFXRates" maxOccurs="unbounded" minOccurs="0"/>
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
    "opCode",
    "fromYears",
    "toYears",
    "feePeriodDetails",
    "getFXRates"
})
@XmlRootElement(name = "FXRateHistory", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FXRateHistory.xsd")
public class FXRateHistory
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "OpCode", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FXRateHistory.xsd")
    protected String opCode;
    @XmlElement(name = "From_Year", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FXRateHistory.xsd")
    protected List<BigInteger> fromYears;
    @XmlElement(name = "To_Year", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FXRateHistory.xsd")
    protected List<BigInteger> toYears;
    @XmlElement(name = "FeePeriodDetails", namespace = "http://treasury.ge.com/schemas/ALOC/APM/FeePeriodDetails.xsd")
    protected List<FeePeriodDetails> feePeriodDetails;
    @XmlElement(name = "GetFXRates", namespace = "http://treasury.ge.com/schemas/ALOC/APM/GetFXRates.xsd")
    protected List<GetFXRates> getFXRates;

    /**
     * Gets the value of the opCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpCode() {
        return opCode;
    }

    /**
     * Sets the value of the opCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpCode(String value) {
        this.opCode = value;
    }

    /**
     * Gets the value of the fromYears property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fromYears property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFromYears().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    public List<BigInteger> getFromYears() {
        if (fromYears == null) {
            fromYears = new ArrayList<BigInteger>();
        }
        return this.fromYears;
    }

    /**
     * Gets the value of the toYears property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the toYears property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getToYears().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    public List<BigInteger> getToYears() {
        if (toYears == null) {
            toYears = new ArrayList<BigInteger>();
        }
        return this.toYears;
    }

    /**
     * Gets the value of the feePeriodDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feePeriodDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeePeriodDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeePeriodDetails }
     * 
     * 
     */
    public List<FeePeriodDetails> getFeePeriodDetails() {
        if (feePeriodDetails == null) {
            feePeriodDetails = new ArrayList<FeePeriodDetails>();
        }
        return this.feePeriodDetails;
    }

    /**
     * Gets the value of the getFXRates property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getFXRates property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetFXRates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetFXRates }
     * 
     * 
     */
    public List<GetFXRates> getGetFXRates() {
        if (getFXRates == null) {
            getFXRates = new ArrayList<GetFXRates>();
        }
        return this.getFXRates;
    }

    public FXRateHistory withOpCode(String value) {
        setOpCode(value);
        return this;
    }

    public FXRateHistory withFromYears(BigInteger... values) {
        if (values!= null) {
            for (BigInteger value: values) {
                getFromYears().add(value);
            }
        }
        return this;
    }

    public FXRateHistory withFromYears(Collection<BigInteger> values) {
        if (values!= null) {
            getFromYears().addAll(values);
        }
        return this;
    }

    public FXRateHistory withToYears(BigInteger... values) {
        if (values!= null) {
            for (BigInteger value: values) {
                getToYears().add(value);
            }
        }
        return this;
    }

    public FXRateHistory withToYears(Collection<BigInteger> values) {
        if (values!= null) {
            getToYears().addAll(values);
        }
        return this;
    }

    public FXRateHistory withFeePeriodDetails(FeePeriodDetails... values) {
        if (values!= null) {
            for (FeePeriodDetails value: values) {
                getFeePeriodDetails().add(value);
            }
        }
        return this;
    }

    public FXRateHistory withFeePeriodDetails(Collection<FeePeriodDetails> values) {
        if (values!= null) {
            getFeePeriodDetails().addAll(values);
        }
        return this;
    }

    public FXRateHistory withGetFXRates(GetFXRates... values) {
        if (values!= null) {
            for (GetFXRates value: values) {
                getGetFXRates().add(value);
            }
        }
        return this;
    }

    public FXRateHistory withGetFXRates(Collection<GetFXRates> values) {
        if (values!= null) {
            getGetFXRates().addAll(values);
        }
        return this;
    }

    /**
     * Sets the value of the fromYears property.
     * 
     * @param fromYears
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFromYears(List<BigInteger> fromYears) {
        this.fromYears = fromYears;
    }

    /**
     * Sets the value of the toYears property.
     * 
     * @param toYears
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setToYears(List<BigInteger> toYears) {
        this.toYears = toYears;
    }

    /**
     * Sets the value of the feePeriodDetails property.
     * 
     * @param feePeriodDetails
     *     allowed object is
     *     {@link FeePeriodDetails }
     *     
     */
    public void setFeePeriodDetails(List<FeePeriodDetails> feePeriodDetails) {
        this.feePeriodDetails = feePeriodDetails;
    }

    /**
     * Sets the value of the getFXRates property.
     * 
     * @param getFXRates
     *     allowed object is
     *     {@link GetFXRates }
     *     
     */
    public void setGetFXRates(List<GetFXRates> getFXRates) {
        this.getFXRates = getFXRates;
    }

}