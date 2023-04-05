//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.06 at 12:05:58 AM ICT 
//


package io.spring.guides.credit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="creditName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditCvc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditExpire" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditAmountTransfer" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "creditName",
    "creditType",
    "creditNum",
    "creditCvc",
    "creditExpire",
    "creditAmountTransfer"
})
@XmlRootElement(name = "getCreditRequest")
public class GetCreditRequest {

    @XmlElement(required = true)
    protected String creditName;
    @XmlElement(required = true)
    protected String creditType;
    @XmlElement(required = true)
    protected String creditNum;
    @XmlElement(required = true)
    protected String creditCvc;
    @XmlElement(required = true)
    protected String creditExpire;
    protected int creditAmountTransfer;

    /**
     * Gets the value of the creditName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditName() {
        return creditName;
    }

    /**
     * Sets the value of the creditName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditName(String value) {
        this.creditName = value;
    }

    /**
     * Gets the value of the creditType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditType() {
        return creditType;
    }

    /**
     * Sets the value of the creditType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditType(String value) {
        this.creditType = value;
    }

    /**
     * Gets the value of the creditNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditNum() {
        return creditNum;
    }

    /**
     * Sets the value of the creditNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditNum(String value) {
        this.creditNum = value;
    }

    /**
     * Gets the value of the creditCvc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCvc() {
        return creditCvc;
    }

    /**
     * Sets the value of the creditCvc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCvc(String value) {
        this.creditCvc = value;
    }

    /**
     * Gets the value of the creditExpire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditExpire() {
        return creditExpire;
    }

    /**
     * Sets the value of the creditExpire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditExpire(String value) {
        this.creditExpire = value;
    }

    /**
     * Gets the value of the creditAmountTransfer property.
     * 
     */
    public int getCreditAmountTransfer() {
        return creditAmountTransfer;
    }

    /**
     * Sets the value of the creditAmountTransfer property.
     * 
     */
    public void setCreditAmountTransfer(int value) {
        this.creditAmountTransfer = value;
    }

}
