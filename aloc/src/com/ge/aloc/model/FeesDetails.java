//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 *         &lt;element name="Surity_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Surity_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Premium_Fees" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Charge_For_Rider" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Totoal_Premium" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Surety_Names" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Surety_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Surety_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "surityId",
    "surityName",
    "premiumFees",
    "chargeForRider",
    "totoalPremium",
    "suretyNames"
})
@XmlRootElement(name = "FeesDetails", namespace = "http://www.tibco.com/schemas/ALOC/Resources/Schemas/RequestDetails/FeesDetails.xsd")
public class FeesDetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Surity_Id", namespace = "http://www.tibco.com/schemas/ALOC/Resources/Schemas/RequestDetails/FeesDetails.xsd")
    protected BigInteger surityId;
    @XmlElement(name = "Surity_Name", namespace = "http://www.tibco.com/schemas/ALOC/Resources/Schemas/RequestDetails/FeesDetails.xsd")
    protected String surityName;
    @XmlElement(name = "Premium_Fees", namespace = "http://www.tibco.com/schemas/ALOC/Resources/Schemas/RequestDetails/FeesDetails.xsd")
    protected BigDecimal premiumFees;
    @XmlElement(name = "Charge_For_Rider", namespace = "http://www.tibco.com/schemas/ALOC/Resources/Schemas/RequestDetails/FeesDetails.xsd")
    protected BigDecimal chargeForRider;
    @XmlElement(name = "Totoal_Premium", namespace = "http://www.tibco.com/schemas/ALOC/Resources/Schemas/RequestDetails/FeesDetails.xsd")
    protected BigDecimal totoalPremium;
    @XmlElement(name = "Surety_Names", namespace = "http://www.tibco.com/schemas/ALOC/Resources/Schemas/RequestDetails/FeesDetails.xsd")
    protected List<FeesDetails.SuretyNames> suretyNames;

    /**
     * Gets the value of the surityId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSurityId() {
        return surityId;
    }

    /**
     * Sets the value of the surityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSurityId(BigInteger value) {
        this.surityId = value;
    }

    /**
     * Gets the value of the surityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurityName() {
        return surityName;
    }

    /**
     * Sets the value of the surityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurityName(String value) {
        this.surityName = value;
    }

    /**
     * Gets the value of the premiumFees property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPremiumFees() {
        return premiumFees;
    }

    /**
     * Sets the value of the premiumFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPremiumFees(BigDecimal value) {
        this.premiumFees = value;
    }

    /**
     * Gets the value of the chargeForRider property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChargeForRider() {
        return chargeForRider;
    }

    /**
     * Sets the value of the chargeForRider property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChargeForRider(BigDecimal value) {
        this.chargeForRider = value;
    }

    /**
     * Gets the value of the totoalPremium property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotoalPremium() {
        return totoalPremium;
    }

    /**
     * Sets the value of the totoalPremium property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotoalPremium(BigDecimal value) {
        this.totoalPremium = value;
    }

    /**
     * Gets the value of the suretyNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the suretyNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSuretyNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeesDetails.SuretyNames }
     * 
     * 
     */
    public List<FeesDetails.SuretyNames> getSuretyNames() {
        if (suretyNames == null) {
            suretyNames = new ArrayList<FeesDetails.SuretyNames>();
        }
        return this.suretyNames;
    }

    public FeesDetails withSurityId(BigInteger value) {
        setSurityId(value);
        return this;
    }

    public FeesDetails withSurityName(String value) {
        setSurityName(value);
        return this;
    }

    public FeesDetails withPremiumFees(BigDecimal value) {
        setPremiumFees(value);
        return this;
    }

    public FeesDetails withChargeForRider(BigDecimal value) {
        setChargeForRider(value);
        return this;
    }

    public FeesDetails withTotoalPremium(BigDecimal value) {
        setTotoalPremium(value);
        return this;
    }

    public FeesDetails withSuretyNames(FeesDetails.SuretyNames... values) {
        if (values!= null) {
            for (FeesDetails.SuretyNames value: values) {
                getSuretyNames().add(value);
            }
        }
        return this;
    }

    public FeesDetails withSuretyNames(Collection<FeesDetails.SuretyNames> values) {
        if (values!= null) {
            getSuretyNames().addAll(values);
        }
        return this;
    }

    /**
     * Sets the value of the suretyNames property.
     * 
     * @param suretyNames
     *     allowed object is
     *     {@link FeesDetails.SuretyNames }
     *     
     */
    public void setSuretyNames(List<FeesDetails.SuretyNames> suretyNames) {
        this.suretyNames = suretyNames;
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
     *         &lt;element name="Surety_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Surety_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "suretyId",
        "suretyName"
    })
    public static class SuretyNames
        extends JAXBObjectSecureSerializer
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        @XmlElement(name = "Surety_Id", namespace = "http://www.tibco.com/schemas/ALOC/Resources/Schemas/RequestDetails/FeesDetails.xsd")
        protected String suretyId;
        @XmlElement(name = "Surety_Name", namespace = "http://www.tibco.com/schemas/ALOC/Resources/Schemas/RequestDetails/FeesDetails.xsd")
        protected String suretyName;

        /**
         * Gets the value of the suretyId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSuretyId() {
            return suretyId;
        }

        /**
         * Sets the value of the suretyId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSuretyId(String value) {
            this.suretyId = value;
        }

        /**
         * Gets the value of the suretyName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSuretyName() {
            return suretyName;
        }

        /**
         * Sets the value of the suretyName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSuretyName(String value) {
            this.suretyName = value;
        }

        public FeesDetails.SuretyNames withSuretyId(String value) {
            setSuretyId(value);
            return this;
        }

        public FeesDetails.SuretyNames withSuretyName(String value) {
            setSuretyName(value);
            return this;
        }

    }

}