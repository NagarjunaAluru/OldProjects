//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.04 at 01:19:41 PM IST 
//


package com.ge.aloc.model;

import java.io.Serializable;
import java.math.BigInteger;
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
import com.hydus.hwf.jaxb.adapters.XMLDateAsCalendarAdapter;
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
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/RequestDetails/MsgHeader.xsd}Msg_Header" minOccurs="0"/>
 *         &lt;element name="Template_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="DateFilter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FromDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ToDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="TemplateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bank" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Bussiness" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Treasury" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LastRunDT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SelectedSites" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Template_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="Site_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SelectedBanks" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Template_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="Bank_MDM_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/ADHOC/Filter.xsd}Filter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://treasury.ge.com/schemas/ALOC/ADHOC/Column.xsd}Column" maxOccurs="unbounded" minOccurs="0"/>
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
    "msgHeader",
    "templateID",
    "dateFilter",
    "fromDate",
    "toDate",
    "templateName",
    "description",
    "bank",
    "bussiness",
    "treasury",
    "lastRunDT",
    "selectedSites",
    "selectedBanks",
    "filters",
    "columns"
})
@XmlRootElement(name = "Template", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
public class Template
    extends JAXBObjectSecureSerializer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Msg_Header", namespace = "http://treasury.ge.com/schemas/ALOC/RequestDetails/MsgHeader.xsd")
    protected MsgHeader msgHeader;
    @XmlElement(name = "Template_ID", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
    protected BigInteger templateID;
    @XmlElement(name = "DateFilter", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
    protected String dateFilter;
    @XmlElement(name = "FromDate", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDateAsCalendarAdapter.class)
    protected Calendar fromDate;
    @XmlElement(name = "ToDate", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDateAsCalendarAdapter.class)
    protected Calendar toDate;
    @XmlElement(name = "TemplateName", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
    protected String templateName;
    @XmlElement(name = "Description", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
    protected String description;
    @XmlElement(name = "Bank", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
    protected Boolean bank;
    @XmlElement(name = "Bussiness", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
    protected Boolean bussiness;
    @XmlElement(name = "Treasury", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
    protected Boolean treasury;
    @XmlElement(name = "LastRunDT", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd", type = String.class)
    @XmlJavaTypeAdapter(XMLDateAsCalendarAdapter.class)
    protected Calendar lastRunDT;
    @XmlElement(name = "SelectedSites", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
    protected List<Template.SelectedSites> selectedSites;
    @XmlElement(name = "SelectedBanks", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
    protected List<Template.SelectedBanks> selectedBanks;
    @XmlElement(name = "Filter", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Filter.xsd")
    protected List<Filter> filters;
    @XmlElement(name = "Column", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Column.xsd")
    protected List<Column> columns;

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
     * Gets the value of the templateID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTemplateID() {
        return templateID;
    }

    /**
     * Sets the value of the templateID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTemplateID(BigInteger value) {
        this.templateID = value;
    }

    /**
     * Gets the value of the dateFilter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFilter() {
        return dateFilter;
    }

    /**
     * Sets the value of the dateFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFilter(String value) {
        this.dateFilter = value;
    }

    /**
     * Gets the value of the fromDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getFromDate() {
        return fromDate;
    }

    /**
     * Sets the value of the fromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromDate(Calendar value) {
        this.fromDate = value;
    }

    /**
     * Gets the value of the toDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getToDate() {
        return toDate;
    }

    /**
     * Sets the value of the toDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToDate(Calendar value) {
        this.toDate = value;
    }

    /**
     * Gets the value of the templateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * Sets the value of the templateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateName(String value) {
        this.templateName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the bank property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBank() {
        return bank;
    }

    /**
     * Sets the value of the bank property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBank(Boolean value) {
        this.bank = value;
    }

    /**
     * Gets the value of the bussiness property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBussiness() {
        return bussiness;
    }

    /**
     * Sets the value of the bussiness property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBussiness(Boolean value) {
        this.bussiness = value;
    }

    /**
     * Gets the value of the treasury property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTreasury() {
        return treasury;
    }

    /**
     * Sets the value of the treasury property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTreasury(Boolean value) {
        this.treasury = value;
    }

    /**
     * Gets the value of the lastRunDT property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getLastRunDT() {
        return lastRunDT;
    }

    /**
     * Sets the value of the lastRunDT property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastRunDT(Calendar value) {
        this.lastRunDT = value;
    }

    /**
     * Gets the value of the selectedSites property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the selectedSites property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSelectedSites().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Template.SelectedSites }
     * 
     * 
     */
    public List<Template.SelectedSites> getSelectedSites() {
        if (selectedSites == null) {
            selectedSites = new ArrayList<Template.SelectedSites>();
        }
        return this.selectedSites;
    }

    /**
     * Gets the value of the selectedBanks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the selectedBanks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSelectedBanks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Template.SelectedBanks }
     * 
     * 
     */
    public List<Template.SelectedBanks> getSelectedBanks() {
        if (selectedBanks == null) {
            selectedBanks = new ArrayList<Template.SelectedBanks>();
        }
        return this.selectedBanks;
    }

    /**
     * Gets the value of the filters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Filter }
     * 
     * 
     */
    public List<Filter> getFilters() {
        if (filters == null) {
            filters = new ArrayList<Filter>();
        }
        return this.filters;
    }

    /**
     * Gets the value of the columns property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the columns property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumns().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Column }
     * 
     * 
     */
    public List<Column> getColumns() {
        if (columns == null) {
            columns = new ArrayList<Column>();
        }
        return this.columns;
    }

    public Template withMsgHeader(MsgHeader value) {
        setMsgHeader(value);
        return this;
    }

    public Template withTemplateID(BigInteger value) {
        setTemplateID(value);
        return this;
    }

    public Template withDateFilter(String value) {
        setDateFilter(value);
        return this;
    }

    public Template withFromDate(Calendar value) {
        setFromDate(value);
        return this;
    }

    public Template withToDate(Calendar value) {
        setToDate(value);
        return this;
    }

    public Template withTemplateName(String value) {
        setTemplateName(value);
        return this;
    }

    public Template withDescription(String value) {
        setDescription(value);
        return this;
    }

    public Template withBank(Boolean value) {
        setBank(value);
        return this;
    }

    public Template withBussiness(Boolean value) {
        setBussiness(value);
        return this;
    }

    public Template withTreasury(Boolean value) {
        setTreasury(value);
        return this;
    }

    public Template withLastRunDT(Calendar value) {
        setLastRunDT(value);
        return this;
    }

    public Template withSelectedSites(Template.SelectedSites... values) {
        if (values!= null) {
            for (Template.SelectedSites value: values) {
                getSelectedSites().add(value);
            }
        }
        return this;
    }

    public Template withSelectedSites(Collection<Template.SelectedSites> values) {
        if (values!= null) {
            getSelectedSites().addAll(values);
        }
        return this;
    }

    public Template withSelectedBanks(Template.SelectedBanks... values) {
        if (values!= null) {
            for (Template.SelectedBanks value: values) {
                getSelectedBanks().add(value);
            }
        }
        return this;
    }

    public Template withSelectedBanks(Collection<Template.SelectedBanks> values) {
        if (values!= null) {
            getSelectedBanks().addAll(values);
        }
        return this;
    }

    public Template withFilters(Filter... values) {
        if (values!= null) {
            for (Filter value: values) {
                getFilters().add(value);
            }
        }
        return this;
    }

    public Template withFilters(Collection<Filter> values) {
        if (values!= null) {
            getFilters().addAll(values);
        }
        return this;
    }

    public Template withColumns(Column... values) {
        if (values!= null) {
            for (Column value: values) {
                getColumns().add(value);
            }
        }
        return this;
    }

    public Template withColumns(Collection<Column> values) {
        if (values!= null) {
            getColumns().addAll(values);
        }
        return this;
    }

    /**
     * Sets the value of the selectedSites property.
     * 
     * @param selectedSites
     *     allowed object is
     *     {@link Template.SelectedSites }
     *     
     */
    public void setSelectedSites(List<Template.SelectedSites> selectedSites) {
        this.selectedSites = selectedSites;
    }

    /**
     * Sets the value of the selectedBanks property.
     * 
     * @param selectedBanks
     *     allowed object is
     *     {@link Template.SelectedBanks }
     *     
     */
    public void setSelectedBanks(List<Template.SelectedBanks> selectedBanks) {
        this.selectedBanks = selectedBanks;
    }

    /**
     * Sets the value of the filters property.
     * 
     * @param filters
     *     allowed object is
     *     {@link Filter }
     *     
     */
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    /**
     * Sets the value of the columns property.
     * 
     * @param columns
     *     allowed object is
     *     {@link Column }
     *     
     */
    public void setColumns(List<Column> columns) {
        this.columns = columns;
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
     *         &lt;element name="Template_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="Bank_MDM_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
        "templateID",
        "bankMDMID"
    })
    public static class SelectedBanks
        extends JAXBObjectSecureSerializer
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        @XmlElement(name = "Template_ID", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
        protected BigInteger templateID;
        @XmlElement(name = "Bank_MDM_ID", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
        protected BigInteger bankMDMID;

        /**
         * Gets the value of the templateID property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTemplateID() {
            return templateID;
        }

        /**
         * Sets the value of the templateID property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTemplateID(BigInteger value) {
            this.templateID = value;
        }

        /**
         * Gets the value of the bankMDMID property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBankMDMID() {
            return bankMDMID;
        }

        /**
         * Sets the value of the bankMDMID property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBankMDMID(BigInteger value) {
            this.bankMDMID = value;
        }

        public Template.SelectedBanks withTemplateID(BigInteger value) {
            setTemplateID(value);
            return this;
        }

        public Template.SelectedBanks withBankMDMID(BigInteger value) {
            setBankMDMID(value);
            return this;
        }

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
     *         &lt;element name="Template_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="Site_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
        "templateID",
        "siteID"
    })
    public static class SelectedSites
        extends JAXBObjectSecureSerializer
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        @XmlElement(name = "Template_ID", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
        protected BigInteger templateID;
        @XmlElement(name = "Site_ID", namespace = "http://treasury.ge.com/schemas/ALOC/ADHOC/Template.xsd")
        protected BigInteger siteID;

        /**
         * Gets the value of the templateID property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTemplateID() {
            return templateID;
        }

        /**
         * Sets the value of the templateID property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTemplateID(BigInteger value) {
            this.templateID = value;
        }

        /**
         * Gets the value of the siteID property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getSiteID() {
            return siteID;
        }

        /**
         * Sets the value of the siteID property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setSiteID(BigInteger value) {
            this.siteID = value;
        }

        public Template.SelectedSites withTemplateID(BigInteger value) {
            setTemplateID(value);
            return this;
        }

        public Template.SelectedSites withSiteID(BigInteger value) {
            setSiteID(value);
            return this;
        }

    }

}
