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
 *         &lt;element name="Role_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="First_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Last_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sso_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Role_Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Business_Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "roleName",
    "firstName",
    "lastName",
    "ssoId",
    "roleId",
    "businessUnit"
})
@XmlRootElement(name = "Role_Info", namespace = "http://treasury.ge.com/schemas/ICFP/UserMgmt.xsd")
public class RoleInfo
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Role_Name", namespace = "http://treasury.ge.com/schemas/ICFP/UserMgmt.xsd")
    protected String roleName;
    @XmlElement(name = "First_Name", namespace = "http://treasury.ge.com/schemas/ICFP/UserMgmt.xsd")
    protected String firstName;
    @XmlElement(name = "Last_Name", namespace = "http://treasury.ge.com/schemas/ICFP/UserMgmt.xsd")
    protected String lastName;
    @XmlElement(name = "Sso_Id", namespace = "http://treasury.ge.com/schemas/ICFP/UserMgmt.xsd")
    protected String ssoId;
    @XmlElement(name = "Role_Id", namespace = "http://treasury.ge.com/schemas/ICFP/UserMgmt.xsd")
    protected Integer roleId;
    @XmlElement(name = "Business_Unit", namespace = "http://treasury.ge.com/schemas/ICFP/UserMgmt.xsd")
    protected String businessUnit;

    /**
     * Gets the value of the roleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the value of the roleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleName(String value) {
        this.roleName = value;
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
     * Gets the value of the ssoId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsoId() {
        return ssoId;
    }

    /**
     * Sets the value of the ssoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsoId(String value) {
        this.ssoId = value;
    }

    /**
     * Gets the value of the roleId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * Sets the value of the roleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRoleId(Integer value) {
        this.roleId = value;
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

    public RoleInfo withRoleName(String value) {
        setRoleName(value);
        return this;
    }

    public RoleInfo withFirstName(String value) {
        setFirstName(value);
        return this;
    }

    public RoleInfo withLastName(String value) {
        setLastName(value);
        return this;
    }

    public RoleInfo withSsoId(String value) {
        setSsoId(value);
        return this;
    }

    public RoleInfo withRoleId(Integer value) {
        setRoleId(value);
        return this;
    }

    public RoleInfo withBusinessUnit(String value) {
        setBusinessUnit(value);
        return this;
    }

}