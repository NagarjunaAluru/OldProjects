//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.29 at 03:37:27 PM IST 
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
 *         &lt;element name="Site_Id" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Aloc_Req_No" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="ALOC_Record_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="First_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Last_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Link_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Bundle_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Model_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instr_Purpose_Type" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bond_Sub_Type" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bond_Type" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="State_Province" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Business_Site_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Business_Site_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bond_SubBond" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Type_Bond" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Type_SubBond" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "siteIds",
    "alocReqNo",
    "alocRecordId",
    "firstName",
    "lastName",
    "linkId",
    "bundleId",
    "modelName",
    "instrPurposeTypes",
    "bondSubTypes",
    "bondTypes",
    "stateProvince",
    "businessSiteType",
    "businessSiteName",
    "bondSubBonds"
})
@XmlRootElement(name = "SearchReqDetails", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
public class SearchReqDetails
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Site_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected List<BigInteger> siteIds;
    @XmlElement(name = "Aloc_Req_No", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected BigInteger alocReqNo;
    @XmlElement(name = "ALOC_Record_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected String alocRecordId;
    @XmlElement(name = "First_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected String firstName;
    @XmlElement(name = "Last_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected String lastName;
    @XmlElement(name = "Link_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected BigInteger linkId;
    @XmlElement(name = "Bundle_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected BigInteger bundleId;
    @XmlElement(name = "Model_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected String modelName;
    @XmlElement(name = "Instr_Purpose_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected List<String> instrPurposeTypes;
    @XmlElement(name = "Bond_Sub_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected List<String> bondSubTypes;
    @XmlElement(name = "Bond_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected List<String> bondTypes;
    @XmlElement(name = "State_Province", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected String stateProvince;
    @XmlElement(name = "Business_Site_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected String businessSiteType;
    @XmlElement(name = "Business_Site_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected String businessSiteName;
    @XmlElement(name = "Bond_SubBond", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
    protected List<SearchReqDetails.BondSubBond> bondSubBonds;

    /**
     * Gets the value of the siteIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the siteIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSiteIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    public List<BigInteger> getSiteIds() {
        if (siteIds == null) {
            siteIds = new ArrayList<BigInteger>();
        }
        return this.siteIds;
    }

    /**
     * Gets the value of the alocReqNo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAlocReqNo() {
        return alocReqNo;
    }

    /**
     * Sets the value of the alocReqNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAlocReqNo(BigInteger value) {
        this.alocReqNo = value;
    }

    /**
     * Gets the value of the alocRecordId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getALOCRecordId() {
        return alocRecordId;
    }

    /**
     * Sets the value of the alocRecordId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setALOCRecordId(String value) {
        this.alocRecordId = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the linkId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLinkId() {
        return linkId;
    }

    /**
     * Sets the value of the linkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLinkId(BigInteger value) {
        this.linkId = value;
    }

    /**
     * Gets the value of the bundleId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBundleId() {
        return bundleId;
    }

    /**
     * Sets the value of the bundleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBundleId(BigInteger value) {
        this.bundleId = value;
    }

    /**
     * Gets the value of the modelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Sets the value of the modelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelName(String value) {
        this.modelName = value;
    }

    /**
     * Gets the value of the instrPurposeTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instrPurposeTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstrPurposeTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getInstrPurposeTypes() {
        if (instrPurposeTypes == null) {
            instrPurposeTypes = new ArrayList<String>();
        }
        return this.instrPurposeTypes;
    }

    /**
     * Gets the value of the bondSubTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bondSubTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBondSubTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBondSubTypes() {
        if (bondSubTypes == null) {
            bondSubTypes = new ArrayList<String>();
        }
        return this.bondSubTypes;
    }

    /**
     * Gets the value of the bondTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bondTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBondTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBondTypes() {
        if (bondTypes == null) {
            bondTypes = new ArrayList<String>();
        }
        return this.bondTypes;
    }

    /**
     * Gets the value of the stateProvince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateProvince() {
        return stateProvince;
    }

    /**
     * Sets the value of the stateProvince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateProvince(String value) {
        this.stateProvince = value;
    }

    /**
     * Gets the value of the businessSiteType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessSiteType() {
        return businessSiteType;
    }

    /**
     * Sets the value of the businessSiteType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessSiteType(String value) {
        this.businessSiteType = value;
    }

    /**
     * Gets the value of the businessSiteName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessSiteName() {
        return businessSiteName;
    }

    /**
     * Sets the value of the businessSiteName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessSiteName(String value) {
        this.businessSiteName = value;
    }

    /**
     * Gets the value of the bondSubBonds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bondSubBonds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBondSubBonds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchReqDetails.BondSubBond }
     * 
     * 
     */
    public List<SearchReqDetails.BondSubBond> getBondSubBonds() {
        if (bondSubBonds == null) {
            bondSubBonds = new ArrayList<SearchReqDetails.BondSubBond>();
        }
        return this.bondSubBonds;
    }

    public SearchReqDetails withSiteIds(BigInteger... values) {
        if (values!= null) {
            for (BigInteger value: values) {
                getSiteIds().add(value);
            }
        }
        return this;
    }

    public SearchReqDetails withSiteIds(Collection<BigInteger> values) {
        if (values!= null) {
            getSiteIds().addAll(values);
        }
        return this;
    }

    public SearchReqDetails withAlocReqNo(BigInteger value) {
        setAlocReqNo(value);
        return this;
    }

    public SearchReqDetails withALOCRecordId(String value) {
        setALOCRecordId(value);
        return this;
    }

    public SearchReqDetails withFirstName(String value) {
        setFirstName(value);
        return this;
    }

    public SearchReqDetails withLastName(String value) {
        setLastName(value);
        return this;
    }

    public SearchReqDetails withLinkId(BigInteger value) {
        setLinkId(value);
        return this;
    }

    public SearchReqDetails withBundleId(BigInteger value) {
        setBundleId(value);
        return this;
    }

    public SearchReqDetails withModelName(String value) {
        setModelName(value);
        return this;
    }

    public SearchReqDetails withInstrPurposeTypes(String... values) {
        if (values!= null) {
            for (String value: values) {
                getInstrPurposeTypes().add(value);
            }
        }
        return this;
    }

    public SearchReqDetails withInstrPurposeTypes(Collection<String> values) {
        if (values!= null) {
            getInstrPurposeTypes().addAll(values);
        }
        return this;
    }

    public SearchReqDetails withBondSubTypes(String... values) {
        if (values!= null) {
            for (String value: values) {
                getBondSubTypes().add(value);
            }
        }
        return this;
    }

    public SearchReqDetails withBondSubTypes(Collection<String> values) {
        if (values!= null) {
            getBondSubTypes().addAll(values);
        }
        return this;
    }

    public SearchReqDetails withBondTypes(String... values) {
        if (values!= null) {
            for (String value: values) {
                getBondTypes().add(value);
            }
        }
        return this;
    }

    public SearchReqDetails withBondTypes(Collection<String> values) {
        if (values!= null) {
            getBondTypes().addAll(values);
        }
        return this;
    }

    public SearchReqDetails withStateProvince(String value) {
        setStateProvince(value);
        return this;
    }

    public SearchReqDetails withBusinessSiteType(String value) {
        setBusinessSiteType(value);
        return this;
    }

    public SearchReqDetails withBusinessSiteName(String value) {
        setBusinessSiteName(value);
        return this;
    }

    public SearchReqDetails withBondSubBonds(SearchReqDetails.BondSubBond... values) {
        if (values!= null) {
            for (SearchReqDetails.BondSubBond value: values) {
                getBondSubBonds().add(value);
            }
        }
        return this;
    }

    public SearchReqDetails withBondSubBonds(Collection<SearchReqDetails.BondSubBond> values) {
        if (values!= null) {
            getBondSubBonds().addAll(values);
        }
        return this;
    }

    /**
     * Sets the value of the siteIds property.
     * 
     * @param siteIds
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSiteIds(List<BigInteger> siteIds) {
        this.siteIds = siteIds;
    }

    /**
     * Sets the value of the instrPurposeTypes property.
     * 
     * @param instrPurposeTypes
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrPurposeTypes(List<String> instrPurposeTypes) {
        this.instrPurposeTypes = instrPurposeTypes;
    }

    /**
     * Sets the value of the bondSubTypes property.
     * 
     * @param bondSubTypes
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBondSubTypes(List<String> bondSubTypes) {
        this.bondSubTypes = bondSubTypes;
    }

    /**
     * Sets the value of the bondTypes property.
     * 
     * @param bondTypes
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBondTypes(List<String> bondTypes) {
        this.bondTypes = bondTypes;
    }

    /**
     * Sets the value of the bondSubBonds property.
     * 
     * @param bondSubBonds
     *     allowed object is
     *     {@link SearchReqDetails.BondSubBond }
     *     
     */
    public void setBondSubBonds(List<SearchReqDetails.BondSubBond> bondSubBonds) {
        this.bondSubBonds = bondSubBonds;
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
     *         &lt;element name="Type_Bond" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Type_SubBond" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "typeBond",
        "typeSubBond"
    })
    public static class BondSubBond
        extends JAXBObjectSecureSerializer
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        @XmlElement(name = "Type_Bond", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
        protected String typeBond;
        @XmlElement(name = "Type_SubBond", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/SearchReqDetails.xsd")
        protected String typeSubBond;

        /**
         * Gets the value of the typeBond property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTypeBond() {
            return typeBond;
        }

        /**
         * Sets the value of the typeBond property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTypeBond(String value) {
            this.typeBond = value;
        }

        /**
         * Gets the value of the typeSubBond property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTypeSubBond() {
            return typeSubBond;
        }

        /**
         * Sets the value of the typeSubBond property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTypeSubBond(String value) {
            this.typeSubBond = value;
        }

        public SearchReqDetails.BondSubBond withTypeBond(String value) {
            setTypeBond(value);
            return this;
        }

        public SearchReqDetails.BondSubBond withTypeSubBond(String value) {
            setTypeSubBond(value);
            return this;
        }

    }

}
