//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.17 at 12:40:24 PM IST 
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
 * <p>Java class for AddressDtlsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressDtlsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Op_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Address_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address_Type_Id" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Contact_F_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Contact_L_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phone_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State_Province" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State_Province_Cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZIP_PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country_Cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Future_Use_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country_Of_Inc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country_Of_Inc_Cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State_Of_Inc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State_Of_Inc_Cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Requires_Edits" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Send_Back_Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Change_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BondReq_Contact_Person" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BondReq_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BondReq_Email_Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BondReq_Phone_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BondReq_Fax_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressDtlsType", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd", propOrder = {
    "opCode",
    "addressId",
    "addressType",
    "addressTypeId",
    "name",
    "contactFName",
    "contactLName",
    "phoneNumber",
    "address",
    "city",
    "stateProvince",
    "stateProvinceCd",
    "zipPostalCode",
    "country",
    "countryCd",
    "futureUseFlag",
    "countryOfInc",
    "countryOfIncCd",
    "stateOfInc",
    "stateOfIncCd",
    "comments",
    "requiresEdits",
    "sendBackNotes",
    "changeFlag",
    "bondReqContactPerson",
    "bondReqName",
    "bondReqEmailAddress",
    "bondReqPhoneNo",
    "bondReqFaxNo"
})
@XmlRootElement(name = "AddressDtls", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
public class AddressDtls
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Op_Code", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String opCode;
    @XmlElement(name = "Address_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected BigInteger addressId;
    @XmlElement(name = "Address_Type", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String addressType;
    @XmlElement(name = "Address_Type_Id", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected BigInteger addressTypeId;
    @XmlElement(name = "Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String name;
    @XmlElement(name = "Contact_F_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String contactFName;
    @XmlElement(name = "Contact_L_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String contactLName;
    @XmlElement(name = "Phone_Number", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String phoneNumber;
    @XmlElement(name = "Address", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected List<String> address;
    @XmlElement(name = "City", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String city;
    @XmlElement(name = "State_Province", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String stateProvince;
    @XmlElement(name = "State_Province_Cd", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String stateProvinceCd;
    @XmlElement(name = "ZIP_PostalCode", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String zipPostalCode;
    @XmlElement(name = "Country", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String country;
    @XmlElement(name = "Country_Cd", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String countryCd;
    @XmlElement(name = "Future_Use_Flag", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String futureUseFlag;
    @XmlElement(name = "Country_Of_Inc", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String countryOfInc;
    @XmlElement(name = "Country_Of_Inc_Cd", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String countryOfIncCd;
    @XmlElement(name = "State_Of_Inc", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String stateOfInc;
    @XmlElement(name = "State_Of_Inc_Cd", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String stateOfIncCd;
    @XmlElement(name = "Comments", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String comments;
    @XmlElement(name = "Requires_Edits", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected Boolean requiresEdits;
    @XmlElement(name = "Send_Back_Notes", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String sendBackNotes;
    @XmlElement(name = "Change_Flag", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String changeFlag;
    @XmlElement(name = "BondReq_Contact_Person", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String bondReqContactPerson;
    @XmlElement(name = "BondReq_Name", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String bondReqName;
    @XmlElement(name = "BondReq_Email_Address", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String bondReqEmailAddress;
    @XmlElement(name = "BondReq_Phone_No", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String bondReqPhoneNo;
    @XmlElement(name = "BondReq_Fax_No", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/AddressDetails.xsd")
    protected String bondReqFaxNo;

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

    /**
     * Gets the value of the addressId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAddressId() {
        return addressId;
    }

    /**
     * Sets the value of the addressId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAddressId(BigInteger value) {
        this.addressId = value;
    }

    /**
     * Gets the value of the addressType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * Sets the value of the addressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressType(String value) {
        this.addressType = value;
    }

    /**
     * Gets the value of the addressTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAddressTypeId() {
        return addressTypeId;
    }

    /**
     * Sets the value of the addressTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAddressTypeId(BigInteger value) {
        this.addressTypeId = value;
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
     * Gets the value of the contactFName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactFName() {
        return contactFName;
    }

    /**
     * Sets the value of the contactFName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactFName(String value) {
        this.contactFName = value;
    }

    /**
     * Gets the value of the contactLName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactLName() {
        return contactLName;
    }

    /**
     * Sets the value of the contactLName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactLName(String value) {
        this.contactLName = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAddress() {
        if (address == null) {
            address = new ArrayList<String>();
        }
        return this.address;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
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
     * Gets the value of the stateProvinceCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateProvinceCd() {
        return stateProvinceCd;
    }

    /**
     * Sets the value of the stateProvinceCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateProvinceCd(String value) {
        this.stateProvinceCd = value;
    }

    /**
     * Gets the value of the zipPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZIPPostalCode() {
        return zipPostalCode;
    }

    /**
     * Sets the value of the zipPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZIPPostalCode(String value) {
        this.zipPostalCode = value;
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
     * Gets the value of the futureUseFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFutureUseFlag() {
        return futureUseFlag;
    }

    /**
     * Sets the value of the futureUseFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFutureUseFlag(String value) {
        this.futureUseFlag = value;
    }

    /**
     * Gets the value of the countryOfInc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfInc() {
        return countryOfInc;
    }

    /**
     * Sets the value of the countryOfInc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfInc(String value) {
        this.countryOfInc = value;
    }

    /**
     * Gets the value of the countryOfIncCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfIncCd() {
        return countryOfIncCd;
    }

    /**
     * Sets the value of the countryOfIncCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfIncCd(String value) {
        this.countryOfIncCd = value;
    }

    /**
     * Gets the value of the stateOfInc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateOfInc() {
        return stateOfInc;
    }

    /**
     * Sets the value of the stateOfInc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateOfInc(String value) {
        this.stateOfInc = value;
    }

    /**
     * Gets the value of the stateOfIncCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateOfIncCd() {
        return stateOfIncCd;
    }

    /**
     * Sets the value of the stateOfIncCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateOfIncCd(String value) {
        this.stateOfIncCd = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the requiresEdits property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequiresEdits() {
        return requiresEdits;
    }

    /**
     * Sets the value of the requiresEdits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequiresEdits(Boolean value) {
        this.requiresEdits = value;
    }

    /**
     * Gets the value of the sendBackNotes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendBackNotes() {
        return sendBackNotes;
    }

    /**
     * Sets the value of the sendBackNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendBackNotes(String value) {
        this.sendBackNotes = value;
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

    /**
     * Gets the value of the bondReqContactPerson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBondReqContactPerson() {
        return bondReqContactPerson;
    }

    /**
     * Sets the value of the bondReqContactPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBondReqContactPerson(String value) {
        this.bondReqContactPerson = value;
    }

    /**
     * Gets the value of the bondReqName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBondReqName() {
        return bondReqName;
    }

    /**
     * Sets the value of the bondReqName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBondReqName(String value) {
        this.bondReqName = value;
    }

    /**
     * Gets the value of the bondReqEmailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBondReqEmailAddress() {
        return bondReqEmailAddress;
    }

    /**
     * Sets the value of the bondReqEmailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBondReqEmailAddress(String value) {
        this.bondReqEmailAddress = value;
    }

    /**
     * Gets the value of the bondReqPhoneNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBondReqPhoneNo() {
        return bondReqPhoneNo;
    }

    /**
     * Sets the value of the bondReqPhoneNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBondReqPhoneNo(String value) {
        this.bondReqPhoneNo = value;
    }

    /**
     * Gets the value of the bondReqFaxNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBondReqFaxNo() {
        return bondReqFaxNo;
    }

    /**
     * Sets the value of the bondReqFaxNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBondReqFaxNo(String value) {
        this.bondReqFaxNo = value;
    }

    public AddressDtls withOpCode(String value) {
        setOpCode(value);
        return this;
    }

    public AddressDtls withAddressId(BigInteger value) {
        setAddressId(value);
        return this;
    }

    public AddressDtls withAddressType(String value) {
        setAddressType(value);
        return this;
    }

    public AddressDtls withAddressTypeId(BigInteger value) {
        setAddressTypeId(value);
        return this;
    }

    public AddressDtls withName(String value) {
        setName(value);
        return this;
    }

    public AddressDtls withContactFName(String value) {
        setContactFName(value);
        return this;
    }

    public AddressDtls withContactLName(String value) {
        setContactLName(value);
        return this;
    }

    public AddressDtls withPhoneNumber(String value) {
        setPhoneNumber(value);
        return this;
    }

    public AddressDtls withAddress(String... values) {
        if (values!= null) {
            for (String value: values) {
                getAddress().add(value);
            }
        }
        return this;
    }

    public AddressDtls withAddress(Collection<String> values) {
        if (values!= null) {
            getAddress().addAll(values);
        }
        return this;
    }

    public AddressDtls withCity(String value) {
        setCity(value);
        return this;
    }

    public AddressDtls withStateProvince(String value) {
        setStateProvince(value);
        return this;
    }

    public AddressDtls withStateProvinceCd(String value) {
        setStateProvinceCd(value);
        return this;
    }

    public AddressDtls withZIPPostalCode(String value) {
        setZIPPostalCode(value);
        return this;
    }

    public AddressDtls withCountry(String value) {
        setCountry(value);
        return this;
    }

    public AddressDtls withCountryCd(String value) {
        setCountryCd(value);
        return this;
    }

    public AddressDtls withFutureUseFlag(String value) {
        setFutureUseFlag(value);
        return this;
    }

    public AddressDtls withCountryOfInc(String value) {
        setCountryOfInc(value);
        return this;
    }

    public AddressDtls withCountryOfIncCd(String value) {
        setCountryOfIncCd(value);
        return this;
    }

    public AddressDtls withStateOfInc(String value) {
        setStateOfInc(value);
        return this;
    }

    public AddressDtls withStateOfIncCd(String value) {
        setStateOfIncCd(value);
        return this;
    }

    public AddressDtls withComments(String value) {
        setComments(value);
        return this;
    }

    public AddressDtls withRequiresEdits(Boolean value) {
        setRequiresEdits(value);
        return this;
    }

    public AddressDtls withSendBackNotes(String value) {
        setSendBackNotes(value);
        return this;
    }

    public AddressDtls withChangeFlag(String value) {
        setChangeFlag(value);
        return this;
    }

    public AddressDtls withBondReqContactPerson(String value) {
        setBondReqContactPerson(value);
        return this;
    }

    public AddressDtls withBondReqName(String value) {
        setBondReqName(value);
        return this;
    }

    public AddressDtls withBondReqEmailAddress(String value) {
        setBondReqEmailAddress(value);
        return this;
    }

    public AddressDtls withBondReqPhoneNo(String value) {
        setBondReqPhoneNo(value);
        return this;
    }

    public AddressDtls withBondReqFaxNo(String value) {
        setBondReqFaxNo(value);
        return this;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param address
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(List<String> address) {
        this.address = address;
    }

}
