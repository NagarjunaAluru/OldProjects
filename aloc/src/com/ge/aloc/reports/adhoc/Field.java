//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.31 at 07:29:27 AM IST 
//


package com.ge.aloc.reports.adhoc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ge.aloc.InstrumentType;


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
 *         &lt;element name="operators" type="{http:///treasury.ge.com/schemas/ALOC/adhoc-report-field-config}operator" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="instrumentIds" default="1 2 3 4 5 6">
 *         &lt;simpleType>
 *           &lt;list itemType="{http:///treasury.ge.com/schemas/ALOC/adhoc-report-field-config}instrumentId" />
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "operators"
})
@XmlRootElement(name = "field")
public class Field {

    @XmlElement(required = true)
    protected List<Operator> operators;
    
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    
    @XmlAttribute
    protected String name;
    
    @XmlAttribute 
    protected List<Integer> instrumentIds;
    
    @XmlAttribute
    protected DataType dataType;
    
    @XmlTransient
    protected String sectionId;
    
    @XmlTransient
    protected Set<InstrumentType> instrumentTypes;

    /**
     * Gets the value of the operators property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operators property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperators().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Operator }
     * 
     * 
     */
    public List<Operator> getOperators() {
        if (operators == null) {
            operators = new ArrayList<Operator>();
        }
        return this.operators;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the instrumentIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instrumentIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstrumentIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
	public List<Integer> getInstrumentIds() {
		if(instrumentIds == null) {
			instrumentIds = new ArrayList<Integer>() {
				private static final long serialVersionUID = 1894326071815122255L;

				{
					for(InstrumentType instrType : InstrumentType.values()) {
						add(instrType.getId());
					}
				}
			};
		}
		return instrumentIds;
	}
    
    /**
	 * @return the sectionId
	 */
	public String getSectionId() {
		return sectionId;
	}

	/**
	 * @param sectionId the sectionId to set
	 */
	protected void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	
	/**
	 * 
	 * @return instrument Type
	 */
	public Set<InstrumentType> getInstrumentTypes() {
        return this.instrumentTypes;
    }
	

	/**
	 * @return the dataType
	 */
	public DataType getDataType() {
		if(dataType == null) {
			dataType = DataType.STRING;
		}
		return dataType;
	}

	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	/**
     * Method to get Instruments
     * @param instrumentTypes
     * @return
     */
    protected boolean isAllowedForAnyOneInstrument(Collection<InstrumentType> instrumentTypes) {
    	return getMatchedInstruments(instrumentTypes).size() > 0;
    }
    
    /**
     * Method to get Matched instruments
     * @param instrumentTypes
     * @return
     */
    protected Set<InstrumentType> getMatchedInstruments(Collection<InstrumentType> instrumentTypes) {
    	Set<InstrumentType> result = new TreeSet<InstrumentType>();
    	Set<InstrumentType> instrumentTypesToCheck = getInstrumentTypes();
    	for(InstrumentType instrumentType : instrumentTypes) {
    		if(instrumentTypesToCheck.contains(instrumentType)) {
    			result.add(instrumentType);
    		}
    	}
    	return result;
    }
    
    /**
     * Method to check Pattern
     * @param name
     * @return
     */
    protected boolean isMatchedByName(Pattern pattern) {
    	return pattern.matcher(this.name).matches();
    }
	
    /**
     * Method to get Instrument Id's
     */
    protected void init() {
        instrumentTypes = new TreeSet<InstrumentType>();
        for(Integer instrId : getInstrumentIds()) {
        	instrumentTypes.add(InstrumentType.fromId(instrId));
        }
    }

}  
  