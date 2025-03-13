import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class SimpleXMLReader {
    public void read(String filePath) {
        try {
            // Open file
            File inputFile = new File(filePath);
            // Parses an XML file
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            // Create a list of people
            List<Person> people = new ArrayList<>();
            // Take in list of people
            SimpleXMLHandler handler = new SimpleXMLHandler(people);
            // Parse the content of the XML file
            saxParser.parse(inputFile, handler);

            System.out.println(people);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SimpleXMLHandler extends DefaultHandler {
        // Constructor
        List<Person> people;
        Map<String, String> current;
        // Mutable sequence of characters
        StringBuffer buffer = new StringBuffer();

        SimpleXMLHandler(List<Person> people) {
            this.people = people;
        }


        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) {
            buffer.setLength(0); // reset the buffer
            if (qName.equalsIgnoreCase("person")) {
                // Create new HashMap
                current = new HashMap<>();
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equalsIgnoreCase("person")) {
                people.add(Person.fromMap(current));
                current = null;
            } else {
                if (current != null) {
                    current.put(qName, buffer.toString());
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            buffer.append(ch, start, length);
        }
        // Adds the characters to the String Buffer
    }

    public static void main(String[] args) {
        SimpleXMLReader reader = new SimpleXMLReader();
        reader.read("simple.xml");
    }
}
