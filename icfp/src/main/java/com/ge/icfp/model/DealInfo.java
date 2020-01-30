//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.08 at 07:56:29 PM IST 
//


package com.ge.icfp.model;

import java.io.Serializable;
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
 *         &lt;element name="IDAG_Change_Flag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Material_Flag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IDAG_Change_Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "idagChangeFlag",
    "materialFlag",
    "idagChangeComments"
})
@XmlRootElement(name = "Deal_Info", namespace = "http://treasury.ge.com/schemas/ICFP/TransactionCapture.xsd")
public class DealInfo
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "IDAG_Change_Flag", namespace = "http://treasury.ge.com/schemas/ICFP/TransactionCapture.xsd")
    protected Boolean idagChangeFlag;
    @XmlElement(name = "Material_Flag", namespace = "http://treasury.ge.com/schemas/ICFP/TransactionCapture.xsd")
    protected Boolean materialFlag;
    @XmlElement(name = "IDAG_Change_Comments", namespace = "http://treasury.ge.com/schemas/ICFP/TransactionCapture.xsd")
    protected String idagChangeComments;

    /**
     * Gets the value of the idagChangeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIDAGChangeFlag() {
        return idagChangeFlag;
    }

    /**
     * Sets the value of the idagChangeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIDAGChangeFlag(Boolean value) {
        this.idagChangeFlag = value;
    }

    /**
     * Gets the value of the materialFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMaterialFlag() {
        return materialFlag;
    }

    /**
     * Sets the value of the materialFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMaterialFlag(Boolean value) {
        this.materialFlag = value;
    }

    /**
     * Gets the value of the idagChangeComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDAGChangeComments() {
        return idagChangeComments;
    }

    /**
     * Sets the value of the idagChangeComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDAGChangeComments(String value) {
        this.idagChangeComments = value;
    }

    public DealInfo withIDAGChangeFlag(Boolean value) {
        setIDAGChangeFlag(value);
        return this;
    }

    public DealInfo withMaterialFlag(Boolean value) {
        setMaterialFlag(value);
        return this;
    }

    public DealInfo withIDAGChangeComments(String value) {
        setIDAGChangeComments(value);
        return this;
    }

}
