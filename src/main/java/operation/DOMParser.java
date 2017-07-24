package operation;

import aircompany.Aircompany;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import plane.CargoPlane;
import plane.MilitaryPlane;
import plane.PassangerPlane;
import plane.WeaponType;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by User on 23.07.2017.
 */
public class DOMParser {


    private static final String CRUISING_SPEED = "cruisingSpeed";
    private static final String AIRCOMPANY = "aircompany";
    private static final String FLIGHT_RANGE = "flightRange";
    private static final String MAX_TAKE_OFF_WEIGHT = "maxTakeOfWeight";
    private static final String FUEL_CONSUMPTION = "fuelConsumption";
    private static final String MAX_FLIGHT_HEIGHT = "maxFlightHeight";
    private static final String CARGOPLANE = "cargoPlane";
    private static final String PASSENGERPLANE = "passengerPlane";
    private static final String MILITARYPLANE = "militaryPlane";
    private static final String OVERSEAS_FLIGHT = "overSeasFlight";
    private static final String PASSENGER_QUANTITY = "passengersQuantity";
    private static final String WEAPON_TYPE = "WeaponType";
    private static final String ROCKETS = "Rockets";
    private static final String MACHINEGUN = "Machinegun";
    private static final String NAME = "name";
    private static final String LASER = "Laser";
    private Aircompany aircompany;
    private boolean overSeasFlight;
    private WeaponType weaponType;
    private int passengerQuantity;
    private String name = "";
    private int cruisingSpeed; //km per hour
    private int flightRange; //km
    private int maxTakeOffWeight; // ton
    private int maxFlightHeight; // km
    private int fuelConsumption; // kg per hour

    public Aircompany getAircompany() {
        return aircompany;
    }

    public Aircompany parseXML(String pathXML){
        Element root = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            Document document = db.parse(pathXML);
            aircompany = new Aircompany();
            NodeList cargoList = document.getElementsByTagName(CARGOPLANE);
            setPlanes(cargoList, CARGOPLANE);
            NodeList passengerList = document.getElementsByTagName(PASSENGERPLANE);
            setPlanes(passengerList, PASSENGERPLANE);
            NodeList militaryList = document.getElementsByTagName(MILITARYPLANE);
            setPlanes(militaryList, MILITARYPLANE);
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }

        return aircompany;

    }
    private void setPlanes(NodeList list, String planeName){
        String attribute = "";
                for(int i = 0; i < list.getLength(); i++){
                    if(list.item(i).getNodeType() == Node.ELEMENT_NODE){
                        Element plane = (Element)list.item(i);
                        switch (planeName) {
                            case CARGOPLANE:
                                attribute = plane.getAttribute(OVERSEAS_FLIGHT);
                                break;
                            case PASSENGERPLANE:
                                attribute = plane.getAttribute(PASSENGER_QUANTITY);
                                break;
                            case MILITARYPLANE:
                                attribute = plane.getAttribute(WEAPON_TYPE);
                                break;
                        }
                        NodeList nameList = plane.getChildNodes();
                        createPlane(planeName, attribute, nameList);
                    }
                }
    }
    private void createPlane(String planeName, String attribute, NodeList nameList ){
        for(int j = 0; j < nameList.getLength(); j++) {
            if (nameList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                Element elName = (Element) nameList.item(j);
                switch (elName.getNodeName()) {
                    case NAME:
                        name = elName.getTextContent();
                        break;
                    case CRUISING_SPEED:
                        cruisingSpeed = Integer.parseInt(elName.getTextContent());
                        break;
                    case FLIGHT_RANGE:
                        flightRange = Integer.parseInt(elName.getTextContent());
                        break;
                    case MAX_FLIGHT_HEIGHT:
                        maxFlightHeight = Integer.parseInt(elName.getTextContent());
                        break;
                    case MAX_TAKE_OFF_WEIGHT:
                        maxTakeOffWeight = Integer.parseInt(elName.getTextContent());
                        break;
                    case FUEL_CONSUMPTION:
                        fuelConsumption = Integer.parseInt(elName.getTextContent());
                        break;
                }
            }
        }
                switch (planeName){
                    case CARGOPLANE:
                        overSeasFlight = Boolean.parseBoolean(attribute);
                        aircompany.getPlanes().add(new CargoPlane(name, cruisingSpeed, flightRange, maxTakeOffWeight,
                                maxFlightHeight,fuelConsumption, overSeasFlight));
                        break;
                    case PASSENGERPLANE:
                        passengerQuantity = Integer.parseInt(attribute);
                        aircompany.getPlanes().add(new PassangerPlane(name, cruisingSpeed, flightRange, maxTakeOffWeight,
                                maxFlightHeight,fuelConsumption, passengerQuantity));
                        break;
                    case MILITARYPLANE:
                        switch (attribute){
                            case LASER:
                                weaponType = WeaponType.LASER;
                                break;
                            case MACHINEGUN:
                                weaponType = WeaponType.MACHINEGUN;
                                break;
                            case ROCKETS:
                                weaponType = WeaponType.ROCKETS;
                                break;
                        }
                        aircompany.getPlanes().add(new MilitaryPlane(name, cruisingSpeed, flightRange, maxTakeOffWeight,
                                maxFlightHeight,fuelConsumption, weaponType));
                        break;
                }


    }
}
