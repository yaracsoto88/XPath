import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SegundaParte {
    public static void main(String[] args) {
        new SegundaParte().inicio();
    }
        private void inicio() {
            try {
                // Crear documento XML
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();

                // Crear elemtento raíz
                Element information = doc.createElement("information");
                doc.appendChild(information);

                // Crear el elemento clients
                Element clients = doc.createElement("clients");
                information.appendChild(clients);

       
                Element client1 = doc.createElement("client");
                client1.setAttribute("id_client", "1");
                client1.appendChild(doc.createTextNode("Client Name 1"));
                clients.appendChild(client1);

                Element client2 = doc.createElement("client");
                client2.setAttribute("id_client", "2");
                client2.appendChild(doc.createTextNode("Client Name 2"));
                clients.appendChild(client2);

                // Crear el elemento agencia
                Element agencies = doc.createElement("agencies");
                information.appendChild(agencies);

        
                Element agency1 = doc.createElement("agency");
                agency1.setAttribute("id_agency", "1");
                agency1.appendChild(doc.createTextNode("Agency Name 1"));
                agencies.appendChild(agency1);

                Element agency2 = doc.createElement("agency");
                agency2.setAttribute("id_agency", "2");
                agency2.appendChild(doc.createTextNode("Agency Name 2"));
                agencies.appendChild(agency2);

                // Crear el elemento rooms
                Element rooms = doc.createElement("rooms");
                information.appendChild(rooms);

                Element room1 = doc.createElement("room");
                room1.setAttribute("id_type", "1");
                room1.appendChild(doc.createTextNode("Room Name 1"));
                rooms.appendChild(room1);

                Element room2 = doc.createElement("room");
                room2.setAttribute("id_type", "2");
                room2.appendChild(doc.createTextNode("Room Name 2"));
                rooms.appendChild(room2);

                // Crear el elemento hotels
                Element hotels = doc.createElement("hotels");
                information.appendChild(hotels);

                Element hotel1 = doc.createElement("hotel");
                hotel1.setAttribute("id_hotel", "1");
                hotel1.appendChild(doc.createTextNode("Hotel Name 1"));
                hotels.appendChild(hotel1);

                Element hotel2 = doc.createElement("hotel");
                hotel2.setAttribute("id_hotel", "2");
                hotel2.appendChild(doc.createTextNode("Hotel Name 2"));
                hotels.appendChild(hotel2);

                // String filePath = "/path/to/your/file.xml";
                // doc.write(new FileOutputStream(filePath));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
    

