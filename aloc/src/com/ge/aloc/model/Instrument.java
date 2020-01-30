//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
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
 *         &lt;element name="Instr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instr_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Instrument_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OpCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "instr",
    "instrId",
    "instrumentFlag",
    "opCode"
})
@XmlRootElement(name = "Instrument", namespace = "http://treasury.ge.com/schemas/ALOC/SiteAdmin/DelegationConfiguration.xsd")
public class Instrument
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Instr", namespace = "http://treasury.ge.com/schemas/ALOC/SiteAdmin/DelegationConfiguration.xsd")
    protected String instr;
    @XmlElement(name = "Instr_Id", namespace = "http://treasury.ge.com/schemas/ALOC/SiteAdmin/DelegationConfiguration.xsd")
    protected Integer instrId;
    @XmlElement(name = "Instrument_Flag", namespace = "http://treasury.ge.com/schemas/ALOC/SiteAdmin/DelegationConfiguration.xsd")
    protected String instrumentFlag;
    @XmlElement(name = "OpCode", namespace = "http://treasury.ge.com/schemas/ALOC/SiteAdmin/DelegationConfiguration.xsd")
    protected String opCode;

    /**
     * Gets the value of the instr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstr() {
        return instr;
    }

    /**
     * Sets the value of the instr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstr(String value) {
        this.instr = value;
    }

    /**
     * Gets the value of the instrId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInstrId() {
        return instrId;
    }

    /**
     * Sets the value of the instrId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInstrId(Integer value) {
        this.instrId = value;
    }

    /**
     * Gets the value of the instrumentFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrumentFlag() {
        return instrumentFlag;
    }

    /**
     * Sets the value of the instrumentFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrumentFlag(String value) {
        this.instrumentFlag = value;
    }

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

    public Instrument withInstr(String value) {
        setInstr(value);
        return this;
    }

    public Instrument withInstrId(Integer value) {
        setInstrId(value);
        return this;
    }

    public Instrument withInstrumentFlag(String value) {
        setInstrumentFlag(value);
        return this;
    }

    public Instrument withOpCode(String value) {
        setOpCode(value);
        return this;
    }

}
