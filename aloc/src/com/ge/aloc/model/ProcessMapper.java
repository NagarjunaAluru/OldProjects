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
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/ProcessMapper.xsd}MappingInfo" maxOccurs="unbounded" minOccurs="0"/>
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
    "mappingInfos"
})
@XmlRootElement(name = "ProcessMapper", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/ProcessMapper.xsd")
public class ProcessMapper
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "MappingInfo", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/ProcessMapper.xsd")
    protected List<MappingInfo> mappingInfos;

    /**
     * Gets the value of the mappingInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mappingInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMappingInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MappingInfo }
     * 
     * 
     */
    public List<MappingInfo> getMappingInfos() {
        if (mappingInfos == null) {
            mappingInfos = new ArrayList<MappingInfo>();
        }
        return this.mappingInfos;
    }

    public ProcessMapper withMappingInfos(MappingInfo... values) {
        if (values!= null) {
            for (MappingInfo value: values) {
                getMappingInfos().add(value);
            }
        }
        return this;
    }

    public ProcessMapper withMappingInfos(Collection<MappingInfo> values) {
        if (values!= null) {
            getMappingInfos().addAll(values);
        }
        return this;
    }

    /**
     * Sets the value of the mappingInfos property.
     * 
     * @param mappingInfos
     *     allowed object is
     *     {@link MappingInfo }
     *     
     */
    public void setMappingInfos(List<MappingInfo> mappingInfos) {
        this.mappingInfos = mappingInfos;
    }

}
