//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.hydus.hwf.jaxb.adapters.XMLDatetimeAsCalendarAdapter;
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
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/Admin/UserAnnouncement.xsd}User_Announcement_ID" minOccurs="0"/>
 *         &lt;element name="MessageContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/Admin/UserAnnouncement.xsd}DocumentLink" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/Admin/UserAnnouncement.xsd}HyperLink" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/Attachments.xsd}Attachment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/Admin/UserAnnouncement.xsd}SiteSelection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/MsgHeader.xsd}Msg_Header" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/Admin/RoleSelection.xsd}RoleSelection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Selected_Role" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/Admin/ActiveAnnouncement.xsd}ActiveAnnouncement" minOccurs="0"/>
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
    "userAnnouncementID",
    "messageContent",
    "documentLink",
    "hyperLink",
    "attachments",
    "siteSelections",
    "startDate",
    "endDate",
    "msgHeader",
    "roleSelections",
    "selectedRoles",
    "activeAnnouncement"
})
@XmlRootElement(name = "UserAnnouncement", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/UserAnnouncement.xsd")
public class UserAnnouncement
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "User_Announcement_ID", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/UserAnnouncement.xsd")
    protected Integer userAnnouncementID;
    @XmlElement(name = "MessageContent", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/UserAnnouncement.xsd")
    protected String messageContent;
    @XmlElement(name = "DocumentLink", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/UserAnnouncement.xsd")
    protected String documentLink;
    @XmlElement(name = "HyperLink", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/UserAnnouncement.xsd")
    protected String hyperLink;
    @XmlElement(name = "Attachment", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/Attachments.xsd")
    protected List<Attachment> attachments;
    @XmlElement(name = "SiteSelection", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/UserAnnouncement.xsd")
    protected List<BigDecimal> siteSelections;
    @XmlElement(name = "StartDate", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/UserAnnouncement.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar startDate;
    @XmlElement(name = "EndDate", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/UserAnnouncement.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDatetimeAsCalendarAdapter.class)
    protected Calendar endDate;
    @XmlElement(name = "Msg_Header", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/MsgHeader.xsd")
    protected MsgHeader msgHeader;
    @XmlElement(name = "RoleSelection", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/RoleSelection.xsd")
    protected List<RoleSelection> roleSelections;
    @XmlElement(name = "Selected_Role", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/UserAnnouncement.xsd", type = Integer.class)
    protected List<Integer> selectedRoles;
    @XmlElement(name = "ActiveAnnouncement", namespace = "http://treasury.ge.com/schemas/ALOC/Admin/ActiveAnnouncement.xsd")
    protected ActiveAnnouncement activeAnnouncement;

    /**
     * Gets the value of the userAnnouncementID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUserAnnouncementID() {
        return userAnnouncementID;
    }

    /**
     * Sets the value of the userAnnouncementID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUserAnnouncementID(Integer value) {
        this.userAnnouncementID = value;
    }

    /**
     * Gets the value of the messageContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * Sets the value of the messageContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageContent(String value) {
        this.messageContent = value;
    }

    /**
     * Gets the value of the documentLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentLink() {
        return documentLink;
    }

    /**
     * Sets the value of the documentLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentLink(String value) {
        this.documentLink = value;
    }

    /**
     * Gets the value of the hyperLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHyperLink() {
        return hyperLink;
    }

    /**
     * Sets the value of the hyperLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHyperLink(String value) {
        this.hyperLink = value;
    }

    /**
     * Gets the value of the attachments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attachment }
     * 
     * 
     */
    public List<Attachment> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<Attachment>();
        }
        return this.attachments;
    }

    /**
     * Gets the value of the siteSelections property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the siteSelections property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSiteSelections().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigDecimal }
     * 
     * 
     */
    public List<BigDecimal> getSiteSelections() {
        if (siteSelections == null) {
            siteSelections = new ArrayList<BigDecimal>();
        }
        return this.siteSelections;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(Calendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(Calendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the msgHeader property.
     * 
     * @return
     *     possible object is
     *     {@link MsgHeader }
     *     
     */
    public MsgHeader getMsgHeader() {
        return msgHeader;
    }

    /**
     * Sets the value of the msgHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgHeader }
     *     
     */
    public void setMsgHeader(MsgHeader value) {
        this.msgHeader = value;
    }

    /**
     * Gets the value of the roleSelections property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roleSelections property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoleSelections().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoleSelection }
     * 
     * 
     */
    public List<RoleSelection> getRoleSelections() {
        if (roleSelections == null) {
            roleSelections = new ArrayList<RoleSelection>();
        }
        return this.roleSelections;
    }

    /**
     * Gets the value of the selectedRoles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the selectedRoles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSelectedRoles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getSelectedRoles() {
        if (selectedRoles == null) {
            selectedRoles = new ArrayList<Integer>();
        }
        return this.selectedRoles;
    }

    /**
     * Gets the value of the activeAnnouncement property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveAnnouncement }
     *     
     */
    public ActiveAnnouncement getActiveAnnouncement() {
        return activeAnnouncement;
    }

    /**
     * Sets the value of the activeAnnouncement property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveAnnouncement }
     *     
     */
    public void setActiveAnnouncement(ActiveAnnouncement value) {
        this.activeAnnouncement = value;
    }

    public UserAnnouncement withUserAnnouncementID(Integer value) {
        setUserAnnouncementID(value);
        return this;
    }

    public UserAnnouncement withMessageContent(String value) {
        setMessageContent(value);
        return this;
    }

    public UserAnnouncement withDocumentLink(String value) {
        setDocumentLink(value);
        return this;
    }

    public UserAnnouncement withHyperLink(String value) {
        setHyperLink(value);
        return this;
    }

    public UserAnnouncement withAttachments(Attachment... values) {
        if (values!= null) {
            for (Attachment value: values) {
                getAttachments().add(value);
            }
        }
        return this;
    }

    public UserAnnouncement withAttachments(Collection<Attachment> values) {
        if (values!= null) {
            getAttachments().addAll(values);
        }
        return this;
    }

    public UserAnnouncement withSiteSelections(BigDecimal... values) {
        if (values!= null) {
            for (BigDecimal value: values) {
                getSiteSelections().add(value);
            }
        }
        return this;
    }

    public UserAnnouncement withSiteSelections(Collection<BigDecimal> values) {
        if (values!= null) {
            getSiteSelections().addAll(values);
        }
        return this;
    }

    public UserAnnouncement withStartDate(Calendar value) {
        setStartDate(value);
        return this;
    }

    public UserAnnouncement withEndDate(Calendar value) {
        setEndDate(value);
        return this;
    }

    public UserAnnouncement withMsgHeader(MsgHeader value) {
        setMsgHeader(value);
        return this;
    }

    public UserAnnouncement withRoleSelections(RoleSelection... values) {
        if (values!= null) {
            for (RoleSelection value: values) {
                getRoleSelections().add(value);
            }
        }
        return this;
    }

    public UserAnnouncement withRoleSelections(Collection<RoleSelection> values) {
        if (values!= null) {
            getRoleSelections().addAll(values);
        }
        return this;
    }

    public UserAnnouncement withSelectedRoles(Integer... values) {
        if (values!= null) {
            for (Integer value: values) {
                getSelectedRoles().add(value);
            }
        }
        return this;
    }

    public UserAnnouncement withSelectedRoles(Collection<Integer> values) {
        if (values!= null) {
            getSelectedRoles().addAll(values);
        }
        return this;
    }

    public UserAnnouncement withActiveAnnouncement(ActiveAnnouncement value) {
        setActiveAnnouncement(value);
        return this;
    }

    /**
     * Sets the value of the attachments property.
     * 
     * @param attachments
     *     allowed object is
     *     {@link Attachment }
     *     
     */
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    /**
     * Sets the value of the siteSelections property.
     * 
     * @param siteSelections
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSiteSelections(List<BigDecimal> siteSelections) {
        this.siteSelections = siteSelections;
    }

    /**
     * Sets the value of the roleSelections property.
     * 
     * @param roleSelections
     *     allowed object is
     *     {@link RoleSelection }
     *     
     */
    public void setRoleSelections(List<RoleSelection> roleSelections) {
        this.roleSelections = roleSelections;
    }

    /**
     * Sets the value of the selectedRoles property.
     * 
     * @param selectedRoles
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSelectedRoles(List<Integer> selectedRoles) {
        this.selectedRoles = selectedRoles;
    }

}
