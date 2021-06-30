
package pl.puci.owski.springbootsoap.mypackage;

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
 *         &lt;element name="klient" type="{http://pucilowski.pl/soap-example}klient"/>
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
    "klient"
})
@XmlRootElement(name = "getResponse", namespace = "http://pucilowski.pl/soap-example")
public class GetResponse {

    @XmlElement(required = true)
    protected Klient klient;

    /**
     * Gets the value of the klient property.
     * 
     * @return
     *     possible object is
     *     {@link Klient }
     *     
     */
    public Klient getKlient() {
        return klient;
    }

    /**
     * Sets the value of the klient property.
     * 
     * @param value
     *     allowed object is
     *     {@link Klient }
     *     
     */
    public void setKlient(Klient value) {
        this.klient = value;
    }

}
