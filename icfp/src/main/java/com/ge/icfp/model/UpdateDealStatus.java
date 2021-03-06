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
 * <p>Java class for UpdateDealStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateDealStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ICFP/UpdateDealStatus.xsd}UpdateStatus" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateDealStatus", propOrder = {
    "updateStatuses"
})
public class UpdateDealStatus
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "UpdateStatus")
    protected List<UpdateStatus> updateStatuses;

    /**
     * Gets the value of the updateStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the updateStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpdateStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpdateStatus }
     * 
     * 
     */
    public List<UpdateStatus> getUpdateStatuses() {
        if (updateStatuses == null) {
            updateStatuses = new ArrayList<UpdateStatus>();
        }
        return this.updateStatuses;
    }

    public UpdateDealStatus withUpdateStatuses(UpdateStatus... values) {
        if (values!= null) {
            for (UpdateStatus value: values) {
                getUpdateStatuses().add(value);
            }
        }
        return this;
    }

    public UpdateDealStatus withUpdateStatuses(Collection<UpdateStatus> values) {
        if (values!= null) {
            getUpdateStatuses().addAll(values);
        }
        return this;
    }

    /**
     * Sets the value of the updateStatuses property.
     * 
     * @param updateStatuses
     *     allowed object is
     *     {@link UpdateStatus }
     *     
     */
    public void setUpdateStatuses(List<UpdateStatus> updateStatuses) {
        this.updateStatuses = updateStatuses;
    }

}
