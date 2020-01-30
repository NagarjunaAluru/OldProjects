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
import javax.xml.bind.annotation.XmlType;
import com.hydus.wff.core.security.JAXBObjectSecureSerializer;


/**
 * <p>Java class for Sale_Purchase_Info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Sale_Purchase_Info">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ICFP/SalePurchase.xsd}Sale_Purchase" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sale_Purchase_Info", namespace = "http://treasury.ge.com/schemas/ICFP/SalePurchase.xsd", propOrder = {
    "salePurchases"
})
public class SalePurchaseInfo
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Sale_Purchase", namespace = "http://treasury.ge.com/schemas/ICFP/SalePurchase.xsd")
    protected List<SalePurchase> salePurchases;

    /**
     * Gets the value of the salePurchases property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the salePurchases property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSalePurchases().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SalePurchase }
     * 
     * 
     */
    public List<SalePurchase> getSalePurchases() {
        if (salePurchases == null) {
            salePurchases = new ArrayList<SalePurchase>();
        }
        return this.salePurchases;
    }

    public SalePurchaseInfo withSalePurchases(SalePurchase... values) {
        if (values!= null) {
            for (SalePurchase value: values) {
                getSalePurchases().add(value);
            }
        }
        return this;
    }

    public SalePurchaseInfo withSalePurchases(Collection<SalePurchase> values) {
        if (values!= null) {
            getSalePurchases().addAll(values);
        }
        return this;
    }

    /**
     * Sets the value of the salePurchases property.
     * 
     * @param salePurchases
     *     allowed object is
     *     {@link SalePurchase }
     *     
     */
    public void setSalePurchases(List<SalePurchase> salePurchases) {
        this.salePurchases = salePurchases;
    }

}
