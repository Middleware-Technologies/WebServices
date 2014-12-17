
package CLIENT;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory 
{
    private final static QName _SayHelloResponse_QNAME = new QName("http://SERVER/", "sayHelloResponse");
    private final static QName _SayHello_QNAME = new QName("http://SERVER/", "sayHello");


    public ObjectFactory() {    }


    public SayHello createSayHello() 
    {
        return new SayHello();
    }


    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }


    @XmlElementDecl(namespace = "http://SERVER/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }


    @XmlElementDecl(namespace = "http://SERVER/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }
}