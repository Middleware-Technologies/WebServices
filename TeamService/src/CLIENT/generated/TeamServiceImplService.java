
package CLIENT.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TeamServiceImplService", targetNamespace = "http://service.server/", wsdlLocation = "http://lucanet:8888/teams?wsdl")
public class TeamServiceImplService
    extends Service
{

    private final static URL TEAMSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException TEAMSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName TEAMSERVICEIMPLSERVICE_QNAME = new QName("http://service.server/", "TeamServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://lucanet:8888/teams?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TEAMSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        TEAMSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public TeamServiceImplService() {
        super(__getWsdlLocation(), TEAMSERVICEIMPLSERVICE_QNAME);
    }

    public TeamServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TEAMSERVICEIMPLSERVICE_QNAME, features);
    }

    public TeamServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, TEAMSERVICEIMPLSERVICE_QNAME);
    }

    public TeamServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TEAMSERVICEIMPLSERVICE_QNAME, features);
    }

    public TeamServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TeamServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TeamService
     */
    @WebEndpoint(name = "TeamServiceImplPort")
    public TeamService getTeamServiceImplPort() {
        return super.getPort(new QName("http://service.server/", "TeamServiceImplPort"), TeamService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TeamService
     */
    @WebEndpoint(name = "TeamServiceImplPort")
    public TeamService getTeamServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.server/", "TeamServiceImplPort"), TeamService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TEAMSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw TEAMSERVICEIMPLSERVICE_EXCEPTION;
        }
        return TEAMSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
