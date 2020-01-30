//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
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
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd}AddressDtls" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/ALOCCommon.xsd}Ref_Details" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Change_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "addressDtls",
    "refDetails",
    "changeFlag"
})
@XmlRootElement(name = "Customer", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/TransactionParties.xsd")
public class Customer
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "AddressDtls", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected AddressDtls addressDtls;
    @XmlElement(name = "Ref_Details", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/ALOCCommon.xsd")
    protected List<RefDetails> refDetails;
    @XmlElement(name = "Change_Flag", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/TransactionParties.xsd")
    protected String changeFlag;

    /**
     * Gets the value of the addressDtls property.
     * 
     * @return
     *     possible object is
     *     {@link AddressDtls }
     *     
     */
    public AddressDtls getAddressDtls() {
        return addressDtls;
    }

    /**
     * Sets the value of the addressDtls property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressDtls }
     *     
     */
    public void setAddressDtls(AddressDtls value) {
        this.addressDtls = value;
    }

    /**
     * Gets the value of the refDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefDetails }
     * 
     * 
     */
    public List<RefDetails> getRefDetails() {
        if (refDetails == null) {
            refDetails = new ArrayList<RefDetails>();
        }
        return this.refDetails;
    }

    /**
     * Gets the value of the changeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeFlag() {
        return changeFlag;
    }

    /**
     * Sets the value of the changeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeFlag(String value) {
        this.changeFlag = value;
    }

    public Customer withAddressDtls(AddressDtls value) {
        setAddressDtls(value);
        return this;
    }

    public Customer withRefDetails(RefDetails... values) {
        if (values!= null) {
            for (RefDetails value: values) {
                getRefDetails().add(value);
            }
        }
        return this;
    }

    public Customer withRefDetails(Collection<RefDetails> values) {
        if (values!= null) {
            getRefDetails().addAll(values);
        }
        return this;
    }

    public Customer withChangeFlag(String value) {
        setChangeFlag(value);
        return this;
    }

    /**
     * Sets the value of the refDetails property.
     * 
     * @param refDetails
     *     allowed object is
     *     {@link RefDetails }
     *     
     */
    public void setRefDetails(List<RefDetails> refDetails) {
        this.refDetails = refDetails;
    }

}
