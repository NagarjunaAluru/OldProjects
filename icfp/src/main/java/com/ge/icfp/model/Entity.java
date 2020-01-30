//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.12 at 08:22:03 PM IST 
//


package com.ge.icfp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.hydus.wff.core.security.JAXBObjectSecureSerializer;


/**
 * <p>Java class for EntityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EntityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LE_Gold_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LE_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LE_Category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CDR_Cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ME_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bank_Treasury_Cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Treasury_Code" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BankInformation" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Treasury_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Bank_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Legal_Entity_Seq_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country_Cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Le_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Le_Type_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Me_Gold_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Le_Category_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Princpl_Entity_Flag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Regulated_Entity_Flag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Entity_Setup_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Capital_Industrial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Business_Segment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fund_Hold_Operation_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Fund_Hold_Operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntityType", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd", propOrder = {
    "leGoldId",
    "leName",
    "leCategory",
    "cdrCd",
    "meName",
    "bankTreasuryCd",
    "treasuryCodes",
    "bankInformations",
    "legalEntitySeqId",
    "country",
    "countryCd",
    "leType",
    "leTypeId",
    "meGoldId",
    "leCategoryId",
    "princplEntityFlag",
    "regulatedEntityFlag",
    "entitySetupFlag",
    "capitalIndustrial",
    "businessSegment",
    "fundHoldOperationId",
    "fundHoldOperation"
})
@XmlRootElement(name = "Entity", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
public class Entity
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "LE_Gold_Id", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String leGoldId;
    @XmlElement(name = "LE_Name", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String leName;
    @XmlElement(name = "LE_Category", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String leCategory;
    @XmlElement(name = "CDR_Cd", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String cdrCd;
    @XmlElement(name = "ME_Name", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String meName;
    @XmlElement(name = "Bank_Treasury_Cd", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String bankTreasuryCd;
    @XmlElement(name = "Treasury_Code", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected List<String> treasuryCodes;
    @XmlElement(name = "BankInformation", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected List<Entity.BankInformation> bankInformations;
    @XmlElement(name = "Legal_Entity_Seq_Id", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected Integer legalEntitySeqId;
    @XmlElement(name = "Country", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String country;
    @XmlElement(name = "Country_Cd", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String countryCd;
    @XmlElement(name = "Le_Type", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String leType;
    @XmlElement(name = "Le_Type_Id", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected Integer leTypeId;
    @XmlElement(name = "Me_Gold_Id", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String meGoldId;
    @XmlElement(name = "Le_Category_Id", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected Integer leCategoryId;
    @XmlElement(name = "Princpl_Entity_Flag", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected Boolean princplEntityFlag;
    @XmlElement(name = "Regulated_Entity_Flag", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected Boolean regulatedEntityFlag;
    @XmlElement(name = "Entity_Setup_Flag", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String entitySetupFlag;
    @XmlElement(name = "Capital_Industrial", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String capitalIndustrial;
    @XmlElement(name = "Business_Segment", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String businessSegment;
    @XmlElement(name = "Fund_Hold_Operation_Id", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected Integer fundHoldOperationId;
    @XmlElement(name = "Fund_Hold_Operation", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
    protected String fundHoldOperation;

    /**
     * Gets the value of the leGoldId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLEGoldId() {
        return leGoldId;
    }

    /**
     * Sets the value of the leGoldId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLEGoldId(String value) {
        this.leGoldId = value;
    }

    /**
     * Gets the value of the leName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLEName() {
        return leName;
    }

    /**
     * Sets the value of the leName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLEName(String value) {
        this.leName = value;
    }

    /**
     * Gets the value of the leCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLECategory() {
        return leCategory;
    }

    /**
     * Sets the value of the leCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLECategory(String value) {
        this.leCategory = value;
    }

    /**
     * Gets the value of the cdrCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDRCd() {
        return cdrCd;
    }

    /**
     * Sets the value of the cdrCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDRCd(String value) {
        this.cdrCd = value;
    }

    /**
     * Gets the value of the meName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMEName() {
        return meName;
    }

    /**
     * Sets the value of the meName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMEName(String value) {
        this.meName = value;
    }

    /**
     * Gets the value of the bankTreasuryCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankTreasuryCd() {
        return bankTreasuryCd;
    }

    /**
     * Sets the value of the bankTreasuryCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankTreasuryCd(String value) {
        this.bankTreasuryCd = value;
    }

    /**
     * Gets the value of the treasuryCodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the treasuryCodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTreasuryCodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTreasuryCodes() {
        if (treasuryCodes == null) {
            treasuryCodes = new ArrayList<String>();
        }
        return this.treasuryCodes;
    }

    /**
     * Gets the value of the bankInformations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bankInformations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBankInformations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Entity.BankInformation }
     * 
     * 
     */
    public List<Entity.BankInformation> getBankInformations() {
        if (bankInformations == null) {
            bankInformations = new ArrayList<Entity.BankInformation>();
        }
        return this.bankInformations;
    }

    /**
     * Gets the value of the legalEntitySeqId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLegalEntitySeqId() {
        return legalEntitySeqId;
    }

    /**
     * Sets the value of the legalEntitySeqId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLegalEntitySeqId(Integer value) {
        this.legalEntitySeqId = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the countryCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCd() {
        return countryCd;
    }

    /**
     * Sets the value of the countryCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCd(String value) {
        this.countryCd = value;
    }

    /**
     * Gets the value of the leType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeType() {
        return leType;
    }

    /**
     * Sets the value of the leType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeType(String value) {
        this.leType = value;
    }

    /**
     * Gets the value of the leTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLeTypeId() {
        return leTypeId;
    }

    /**
     * Sets the value of the leTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLeTypeId(Integer value) {
        this.leTypeId = value;
    }

    /**
     * Gets the value of the meGoldId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeGoldId() {
        return meGoldId;
    }

    /**
     * Sets the value of the meGoldId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeGoldId(String value) {
        this.meGoldId = value;
    }

    /**
     * Gets the value of the leCategoryId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLeCategoryId() {
        return leCategoryId;
    }

    /**
     * Sets the value of the leCategoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLeCategoryId(Integer value) {
        this.leCategoryId = value;
    }

    /**
     * Gets the value of the princplEntityFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPrincplEntityFlag() {
        return princplEntityFlag;
    }

    /**
     * Sets the value of the princplEntityFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPrincplEntityFlag(Boolean value) {
        this.princplEntityFlag = value;
    }

    /**
     * Gets the value of the regulatedEntityFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRegulatedEntityFlag() {
        return regulatedEntityFlag;
    }

    /**
     * Sets the value of the regulatedEntityFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRegulatedEntityFlag(Boolean value) {
        this.regulatedEntityFlag = value;
    }

    /**
     * Gets the value of the entitySetupFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntitySetupFlag() {
        return entitySetupFlag;
    }

    /**
     * Sets the value of the entitySetupFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntitySetupFlag(String value) {
        this.entitySetupFlag = value;
    }

    /**
     * Gets the value of the capitalIndustrial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapitalIndustrial() {
        return capitalIndustrial;
    }

    /**
     * Sets the value of the capitalIndustrial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapitalIndustrial(String value) {
        this.capitalIndustrial = value;
    }

    /**
     * Gets the value of the businessSegment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessSegment() {
        return businessSegment;
    }

    /**
     * Sets the value of the businessSegment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessSegment(String value) {
        this.businessSegment = value;
    }

    /**
     * Gets the value of the fundHoldOperationId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFundHoldOperationId() {
        return fundHoldOperationId;
    }

    /**
     * Sets the value of the fundHoldOperationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFundHoldOperationId(Integer value) {
        this.fundHoldOperationId = value;
    }

    /**
     * Gets the value of the fundHoldOperation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundHoldOperation() {
        return fundHoldOperation;
    }

    /**
     * Sets the value of the fundHoldOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundHoldOperation(String value) {
        this.fundHoldOperation = value;
    }

    public Entity withLEGoldId(String value) {
        setLEGoldId(value);
        return this;
    }

    public Entity withLEName(String value) {
        setLEName(value);
        return this;
    }

    public Entity withLECategory(String value) {
        setLECategory(value);
        return this;
    }

    public Entity withCDRCd(String value) {
        setCDRCd(value);
        return this;
    }

    public Entity withMEName(String value) {
        setMEName(value);
        return this;
    }

    public Entity withBankTreasuryCd(String value) {
        setBankTreasuryCd(value);
        return this;
    }

    public Entity withTreasuryCodes(String... values) {
        if (values!= null) {
            for (String value: values) {
                getTreasuryCodes().add(value);
            }
        }
        return this;
    }

    public Entity withTreasuryCodes(Collection<String> values) {
        if (values!= null) {
            getTreasuryCodes().addAll(values);
        }
        return this;
    }

    public Entity withBankInformations(Entity.BankInformation... values) {
        if (values!= null) {
            for (Entity.BankInformation value: values) {
                getBankInformations().add(value);
            }
        }
        return this;
    }

    public Entity withBankInformations(Collection<Entity.BankInformation> values) {
        if (values!= null) {
            getBankInformations().addAll(values);
        }
        return this;
    }

    public Entity withLegalEntitySeqId(Integer value) {
        setLegalEntitySeqId(value);
        return this;
    }

    public Entity withCountry(String value) {
        setCountry(value);
        return this;
    }

    public Entity withCountryCd(String value) {
        setCountryCd(value);
        return this;
    }

    public Entity withLeType(String value) {
        setLeType(value);
        return this;
    }

    public Entity withLeTypeId(Integer value) {
        setLeTypeId(value);
        return this;
    }

    public Entity withMeGoldId(String value) {
        setMeGoldId(value);
        return this;
    }

    public Entity withLeCategoryId(Integer value) {
        setLeCategoryId(value);
        return this;
    }

    public Entity withPrincplEntityFlag(Boolean value) {
        setPrincplEntityFlag(value);
        return this;
    }

    public Entity withRegulatedEntityFlag(Boolean value) {
        setRegulatedEntityFlag(value);
        return this;
    }

    public Entity withEntitySetupFlag(String value) {
        setEntitySetupFlag(value);
        return this;
    }

    public Entity withCapitalIndustrial(String value) {
        setCapitalIndustrial(value);
        return this;
    }

    public Entity withBusinessSegment(String value) {
        setBusinessSegment(value);
        return this;
    }

    public Entity withFundHoldOperationId(Integer value) {
        setFundHoldOperationId(value);
        return this;
    }

    public Entity withFundHoldOperation(String value) {
        setFundHoldOperation(value);
        return this;
    }

    /**
     * Sets the value of the treasuryCodes property.
     * 
     * @param treasuryCodes
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTreasuryCodes(List<String> treasuryCodes) {
        this.treasuryCodes = treasuryCodes;
    }

    /**
     * Sets the value of the bankInformations property.
     * 
     * @param bankInformations
     *     allowed object is
     *     {@link Entity.BankInformation }
     *     
     */
    public void setBankInformations(List<Entity.BankInformation> bankInformations) {
        this.bankInformations = bankInformations;
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
     *         &lt;element name="Treasury_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Bank_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "treasuryCode",
        "bankName"
    })
    public static class BankInformation
        extends JAXBObjectSecureSerializer
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        @XmlElement(name = "Treasury_Code", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
        protected String treasuryCode;
        @XmlElement(name = "Bank_Name", namespace = "http://treasury.ge.com/schemas/ICFP/EntityInformation.xsd")
        protected String bankName;

        /**
         * Gets the value of the treasuryCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTreasuryCode() {
            return treasuryCode;
        }

        /**
         * Sets the value of the treasuryCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTreasuryCode(String value) {
            this.treasuryCode = value;
        }

        /**
         * Gets the value of the bankName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBankName() {
            return bankName;
        }

        /**
         * Sets the value of the bankName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBankName(String value) {
            this.bankName = value;
        }

        public Entity.BankInformation withTreasuryCode(String value) {
            setTreasuryCode(value);
            return this;
        }

        public Entity.BankInformation withBankName(String value) {
            setBankName(value);
            return this;
        }

    }

}
