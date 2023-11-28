import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SegundaParte {
    public static void main(String[] args) {
        new SegundaParte().inicio();
    }

    private void inicio() {
        String ruta = "bookings.xml";
        try {
            Document document = parsearDocumentoXML(ruta);
            crearXMLNuevo(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Document parsearDocumentoXML(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(filePath));
    }

    private void crearXMLNuevo(Document document) {
        try {
            Document doc = crearDocumentoXML();

            // Crear nodos y estructura
            crearClientes(document, doc);
            crearAgencias(document, doc);
            crearRooms(document, doc);
            crearHoteles(document, doc);
            guardarXML(doc, "nuevo.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Document crearDocumentoXML() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        doc.appendChild(doc.createElement("information"));
        return doc;
    }
    

    private void crearClientes(Document document, Document nuevoDocumento) {
        try {
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
    
            String expression = "//booking/client";
            NodeList nodes = (NodeList) xPath.evaluate(expression, document, XPathConstants.NODESET);
    
            Node clientsNode = nuevoDocumento.createElement("clients");
            System.out.println(nodes.getLength());
            for (int i = 0; i < nodes.getLength(); i++) {
                Node clientNode = nodes.item(i);
                String clientId = clientNode.getAttributes().getNamedItem("id_client").getNodeValue();
                String clientName = clientNode.getTextContent();
    
                Element clientElement = nuevoDocumento.createElement("client");
                clientElement.setTextContent(clientName);
                clientElement.setAttribute("id_client", clientId);
    
                clientsNode.appendChild(clientElement);
            }
    
            nuevoDocumento.getDocumentElement().appendChild(clientsNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    private void crearAgencias(Document document, Document nuevoDocumento) {
        try {
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            String expression = "//booking/agency";
            NodeList nodes = (NodeList) xPath.evaluate(expression, document, XPathConstants.NODESET);
            Node agenciesNode = nuevoDocumento.createElement("agencies");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node agencyNode = nodes.item(i);
                String agencyId = agencyNode.getAttributes().getNamedItem("id_agency").getNodeValue();
                String agencyName = agencyNode.getTextContent();

                Element agencyElement = nuevoDocumento.createElement("agency");
                agencyElement.setTextContent(agencyName);
                agencyElement.setAttribute("id_agency", agencyId);

                agenciesNode.appendChild(agencyElement);
            }
            nuevoDocumento.getDocumentElement().appendChild(agenciesNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void crearRooms(Document document, Document nuevoDocumento) {
        try {
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            String expression = "//booking/room";
            NodeList nodes = (NodeList) xPath.evaluate(expression, document, XPathConstants.NODESET);

            Node roomsNode = nuevoDocumento.createElement("rooms");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node roomNode = nodes.item(i);
                String roomId = roomNode.getAttributes().getNamedItem("id_type").getNodeValue();
                String roomName = roomNode.getTextContent();

                Element roomElement = nuevoDocumento.createElement("room");
                roomElement.setTextContent(roomName);
                roomElement.setAttribute("id_type", roomId);

                roomsNode.appendChild(roomElement);
            }

            nuevoDocumento.getDocumentElement().appendChild(roomsNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void crearHoteles(Document document, Document nuevoDocumento) {
        try {
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            String expression = "//booking/hotel";
            NodeList nodes = (NodeList) xPath.evaluate(expression, document, XPathConstants.NODESET);

            Node hotelsNode = nuevoDocumento.createElement("hotels");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node hotelNode = nodes.item(i);
                String hotelId = hotelNode.getAttributes().getNamedItem("id_hotel").getNodeValue();
                String hotelName = hotelNode.getTextContent();

                Element hotelElement = nuevoDocumento.createElement("hotel");
                hotelElement.setTextContent(hotelName);
                hotelElement.setAttribute("id_hotel", hotelId);

                hotelsNode.appendChild(hotelElement);
            }

            nuevoDocumento.getDocumentElement().appendChild(hotelsNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void guardarXML(Document document, String filePath) {
        try {
            javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(document);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}