
package com.utils.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.utils.ws package. 
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

    private final static QName _DoAnalysisBpipUnitResponse_QNAME = new QName("ws.utils.com", "doAnalysisBpipUnitResponse");
    private final static QName _DoAnalysisDoc_QNAME = new QName("ws.utils.com", "doAnalysisDoc");
    private final static QName _Exception_QNAME = new QName("ws.utils.com", "Exception");
    private final static QName _DoAnalysisBpipUnit_QNAME = new QName("ws.utils.com", "doAnalysisBpipUnit");
    private final static QName _DoAnalysisDocResponse_QNAME = new QName("ws.utils.com", "doAnalysisDocResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.utils.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link DoAnalysisBpipUnit }
     * 
     */
    public DoAnalysisBpipUnit createDoAnalysisBpipUnit() {
        return new DoAnalysisBpipUnit();
    }

    /**
     * Create an instance of {@link DoAnalysisBpipUnitResponse }
     * 
     */
    public DoAnalysisBpipUnitResponse createDoAnalysisBpipUnitResponse() {
        return new DoAnalysisBpipUnitResponse();
    }

    /**
     * Create an instance of {@link DoAnalysisDoc }
     * 
     */
    public DoAnalysisDoc createDoAnalysisDoc() {
        return new DoAnalysisDoc();
    }

    /**
     * Create an instance of {@link DoAnalysisDocResponse }
     * 
     */
    public DoAnalysisDocResponse createDoAnalysisDocResponse() {
        return new DoAnalysisDocResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoAnalysisBpipUnitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ws.utils.com", name = "doAnalysisBpipUnitResponse")
    public JAXBElement<DoAnalysisBpipUnitResponse> createDoAnalysisBpipUnitResponse(DoAnalysisBpipUnitResponse value) {
        return new JAXBElement<DoAnalysisBpipUnitResponse>(_DoAnalysisBpipUnitResponse_QNAME, DoAnalysisBpipUnitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoAnalysisDoc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ws.utils.com", name = "doAnalysisDoc")
    public JAXBElement<DoAnalysisDoc> createDoAnalysisDoc(DoAnalysisDoc value) {
        return new JAXBElement<DoAnalysisDoc>(_DoAnalysisDoc_QNAME, DoAnalysisDoc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ws.utils.com", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoAnalysisBpipUnit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ws.utils.com", name = "doAnalysisBpipUnit")
    public JAXBElement<DoAnalysisBpipUnit> createDoAnalysisBpipUnit(DoAnalysisBpipUnit value) {
        return new JAXBElement<DoAnalysisBpipUnit>(_DoAnalysisBpipUnit_QNAME, DoAnalysisBpipUnit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoAnalysisDocResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ws.utils.com", name = "doAnalysisDocResponse")
    public JAXBElement<DoAnalysisDocResponse> createDoAnalysisDocResponse(DoAnalysisDocResponse value) {
        return new JAXBElement<DoAnalysisDocResponse>(_DoAnalysisDocResponse_QNAME, DoAnalysisDocResponse.class, null, value);
    }

}
