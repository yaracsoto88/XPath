import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathConstants;

public class Main {
    public static void main(String[] args) {
        new Main().inicio();
    }

    private void inicio() {
        String ruta = "C:\\Users\\yarac\\Desktop\\2DAM\\acceso a datos\\Acceso a ficheros\\Act 10\\bookings.xml";
        try {
            Document document = parsearDocumentoXML(ruta);

            // Aplicar XPath
            aplicarXPath(document, "//book/title");

            // Extraer datos XML
            extraerDatosXML(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Document parsearDocumentoXML(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(filePath);
    }

    private void aplicarXPath(Document document, String expression) {
        try {
            document.getDocumentElement().normalize();
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            XPathExpression xPathExpression = xPath.compile(expression);

            NodeList nodeList = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Resultado de XPath para //book/title: " + node.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void extraerDatosXML(Document document) {
        try {
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
     

            // Extraer atributos
            String attributeExpression = "//booking/@location_number";
            NodeList attributeNodes = (NodeList) xPath.evaluate(attributeExpression, document, XPathConstants.NODESET);
            for (int i = 0; i < attributeNodes.getLength(); i++) {
                Node attributeNode = attributeNodes.item(i);
                System.out.println("Valor del atributo id: " + attributeNode.getNodeValue());
            }

            // Extraer elementos
            String elementExpression = "//booking/client";
            NodeList elementNodes = (NodeList) xPath.evaluate(elementExpression, document, XPathConstants.NODESET);
            for (int i = 0; i < elementNodes.getLength(); i++) {
                Node elementNode = elementNodes.item(i);
                System.out.println("Valor del elemento cliente: " + elementNode.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
