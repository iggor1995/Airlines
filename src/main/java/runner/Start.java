package runner;

import aircompany.Aircompany;
import filter.PlaneFilter;
import operation.*;
import plane.CargoPlane;
import plane.MilitaryPlane;
import plane.PassangerPlane;
import plane.Plane;
import plane.WeaponType;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by User on 15.06.2017.
 */
public class Start {
    public  final static String XML = "C:\\Users\\User\\IdeaProjects\\Airlines_XML\\src\\main\\java\\xmlpack\\airlines.xml";
    public  final static String XSD = "C:\\Users\\User\\IdeaProjects\\Airlines_XML\\src\\main\\java\\xmlpack\\xml.xsd";

    private static ArrayList<Plane> planes = new ArrayList();

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        ValidatorXML validatorXML = new ValidatorXML();
        validatorXML.validate(XML, XSD);

        SAXParser saxParser = new SAXParser();
        saxParser.parseXML(XML);
        StAXParser stAXParser = new StAXParser();
        stAXParser.parseXML(XML);
        DOMParser domParser = new DOMParser();
        domParser.parseXML(XML);
        System.out.println("DOM parser object equals SAX parser object: " +
                domParser.getAircompany().equals(saxParser.getAircompany()));
        System.out.println("DOM parser object equals StAX parser object: " +
                domParser.getAircompany().equals(stAXParser.getAircompany()));

    }

}
