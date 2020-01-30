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
 *         &lt;element name="SSOID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PersonalTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StreetAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmployeeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BusinessUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="JobFunction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DirectPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Mobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DialCommPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OtherPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SupervisorSSOId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SupervisorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "ssoid",
    "personalTitle",
    "firstName",
    "lastName",
    "fullName",
    "displayName",
    "emailAddress",
    "title",
    "streetAddress",
    "city",
    "state",
    "country",
    "zipCode",
    "employeeType",
    "businessUnit",
    "department",
    "company",
    "jobFunction",
    "directPhone",
    "mobile",
    "dialCommPhone",
    "otherPhone",
    "supervisorSSOId",
    "supervisorName",
    "fax"
})
@XmlRootElement(name = "UserInformationResponse", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
public class UserInformationResponse
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "SSOID", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String ssoid;
    @XmlElement(name = "PersonalTitle", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String personalTitle;
    @XmlElement(name = "FirstName", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String firstName;
    @XmlElement(name = "LastName", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String lastName;
    @XmlElement(name = "FullName", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String fullName;
    @XmlElement(name = "DisplayName", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String displayName;
    @XmlElement(name = "EmailAddress", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String emailAddress;
    @XmlElement(name = "Title", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String title;
    @XmlElement(name = "StreetAddress", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String streetAddress;
    @XmlElement(name = "City", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String city;
    @XmlElement(name = "State", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String state;
    @XmlElement(name = "Country", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String country;
    @XmlElement(name = "ZipCode", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String zipCode;
    @XmlElement(name = "EmployeeType", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String employeeType;
    @XmlElement(name = "BusinessUnit", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String businessUnit;
    @XmlElement(name = "Department", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String department;
    @XmlElement(name = "Company", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String company;
    @XmlElement(name = "JobFunction", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String jobFunction;
    @XmlElement(name = "DirectPhone", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String directPhone;
    @XmlElement(name = "Mobile", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String mobile;
    @XmlElement(name = "DialCommPhone", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String dialCommPhone;
    @XmlElement(name = "OtherPhone", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String otherPhone;
    @XmlElement(name = "SupervisorSSOId", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String supervisorSSOId;
    @XmlElement(name = "SupervisorName", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String supervisorName;
    @XmlElement(name = "Fax", namespace = "http://treasury.ge.com/schemas/UserData.xsd")
    protected String fax;

    /**
     * Gets the value of the ssoid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSOID() {
        return ssoid;
    }

    /**
     * Sets the value of the ssoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSOID(String value) {
        this.ssoid = value;
    }

    /**
     * Gets the value of the personalTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalTitle() {
        return personalTitle;
    }

    /**
     * Sets the value of the personalTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalTitle(String value) {
        this.personalTitle = value;
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
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the displayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the streetAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets the value of the streetAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetAddress(String value) {
        this.streetAddress = value;
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
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
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
     * Gets the value of the zipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipCode(String value) {
        this.zipCode = value;
    }

    /**
     * Gets the value of the employeeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeType() {
        return employeeType;
    }

    /**
     * Sets the value of the employeeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeType(String value) {
        this.employeeType = value;
    }

    /**
     * Gets the value of the businessUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessUnit() {
        return businessUnit;
    }

    /**
     * Sets the value of the businessUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessUnit(String value) {
        this.businessUnit = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartment(String value) {
        this.department = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Gets the value of the jobFunction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobFunction() {
        return jobFunction;
    }

    /**
     * Sets the value of the jobFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobFunction(String value) {
        this.jobFunction = value;
    }

    /**
     * Gets the value of the directPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectPhone() {
        return directPhone;
    }

    /**
     * Sets the value of the directPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectPhone(String value) {
        this.directPhone = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the dialCommPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDialCommPhone() {
        return dialCommPhone;
    }

    /**
     * Sets the value of the dialCommPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDialCommPhone(String value) {
        this.dialCommPhone = value;
    }

    /**
     * Gets the value of the otherPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherPhone() {
        return otherPhone;
    }

    /**
     * Sets the value of the otherPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherPhone(String value) {
        this.otherPhone = value;
    }

    /**
     * Gets the value of the supervisorSSOId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupervisorSSOId() {
        return supervisorSSOId;
    }

    /**
     * Sets the value of the supervisorSSOId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupervisorSSOId(String value) {
        this.supervisorSSOId = value;
    }

    /**
     * Gets the value of the supervisorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupervisorName() {
        return supervisorName;
    }

    /**
     * Sets the value of the supervisorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupervisorName(String value) {
        this.supervisorName = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    public UserInformationResponse withSSOID(String value) {
        setSSOID(value);
        return this;
    }

    public UserInformationResponse withPersonalTitle(String value) {
        setPersonalTitle(value);
        return this;
    }

    public UserInformationResponse withFirstName(String value) {
        setFirstName(value);
        return this;
    }

    public UserInformationResponse withLastName(String value) {
        setLastName(value);
        return this;
    }

    public UserInformationResponse withFullName(String value) {
        setFullName(value);
        return this;
    }

    public UserInformationResponse withDisplayName(String value) {
        setDisplayName(value);
        return this;
    }

    public UserInformationResponse withEmailAddress(String value) {
        setEmailAddress(value);
        return this;
    }

    public UserInformationResponse withTitle(String value) {
        setTitle(value);
        return this;
    }

    public UserInformationResponse withStreetAddress(String value) {
        setStreetAddress(value);
        return this;
    }

    public UserInformationResponse withCity(String value) {
        setCity(value);
        return this;
    }

    public UserInformationResponse withState(String value) {
        setState(value);
        return this;
    }

    public UserInformationResponse withCountry(String value) {
        setCountry(value);
        return this;
    }

    public UserInformationResponse withZipCode(String value) {
        setZipCode(value);
        return this;
    }

    public UserInformationResponse withEmployeeType(String value) {
        setEmployeeType(value);
        return this;
    }

    public UserInformationResponse withBusinessUnit(String value) {
        setBusinessUnit(value);
        return this;
    }

    public UserInformationResponse withDepartment(String value) {
        setDepartment(value);
        return this;
    }

    public UserInformationResponse withCompany(String value) {
        setCompany(value);
        return this;
    }

    public UserInformationResponse withJobFunction(String value) {
        setJobFunction(value);
        return this;
    }

    public UserInformationResponse withDirectPhone(String value) {
        setDirectPhone(value);
        return this;
    }

    public UserInformationResponse withMobile(String value) {
        setMobile(value);
        return this;
    }

    public UserInformationResponse withDialCommPhone(String value) {
        setDialCommPhone(value);
        return this;
    }

    public UserInformationResponse withOtherPhone(String value) {
        setOtherPhone(value);
        return this;
    }

    public UserInformationResponse withSupervisorSSOId(String value) {
        setSupervisorSSOId(value);
        return this;
    }

    public UserInformationResponse withSupervisorName(String value) {
        setSupervisorName(value);
        return this;
    }

    public UserInformationResponse withFax(String value) {
        setFax(value);
        return this;
    }

}
