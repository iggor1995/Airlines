package operation;
        import org.xml.sax.SAXException;
        import javax.xml.XMLConstants;
        import javax.xml.transform.stream.StreamSource;
        import javax.xml.validation.Schema;
        import javax.xml.validation.SchemaFactory;
        import javax.xml.validation.Validator;
        import java.io.File;
        import java.io.IOException;

public class ValidatorXML {
    private static final String ISVALID = "XML соответствует XSD : ";
    private static final String XML_NOT_FOUND = "Не найден XML ";
    private static final String XSD_NOT_FOUND = "Не найден XSD ";

    public void validate(String pathXml, String pathXsd) {
        boolean b = checkXML(pathXml, pathXsd);
        System.out.println(ISVALID + b);

    }

    private boolean checkXML(String pathXml, String pathXsd) {

        try {
            File xml = new File(pathXml);
            File xsd = new File(pathXsd);

            if (!xml.exists() || !xsd.exists()) {
                return false;
            }

            if (!xml.exists()) {
                System.out.println(XML_NOT_FOUND + pathXml);
            }

            if (!xsd.exists()) {
                System.out.println(XSD_NOT_FOUND + pathXsd);
            }



            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(pathXsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(pathXml));
            return true;
        } catch (SAXException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
