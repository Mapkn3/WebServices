
package WebService1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the WebService1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetTime_QNAME = new QName("http://TimeService.mapkn3.my/", "getTime");
    private final static QName _GetTimeResponse_QNAME = new QName("http://TimeService.mapkn3.my/", "getTimeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: WebService1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTimeResponse }
     * 
     */
    public GetTimeResponse createGetTimeResponse() {
        return new GetTimeResponse();
    }

    /**
     * Create an instance of {@link GetTime }
     * 
     */
    public GetTime createGetTime() {
        return new GetTime();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TimeService.mapkn3.my/", name = "getTime")
    public JAXBElement<GetTime> createGetTime(GetTime value) {
        return new JAXBElement<GetTime>(_GetTime_QNAME, GetTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TimeService.mapkn3.my/", name = "getTimeResponse")
    public JAXBElement<GetTimeResponse> createGetTimeResponse(GetTimeResponse value) {
        return new JAXBElement<GetTimeResponse>(_GetTimeResponse_QNAME, GetTimeResponse.class, null, value);
    }

}
