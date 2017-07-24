package operation;

import aircompany.Aircompany;
import plane.CargoPlane;
import plane.MilitaryPlane;
import plane.PassangerPlane;
import plane.WeaponType;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by User on 22.07.2017.
 */
public class StAXParser {
    public Aircompany getAircompany() {
        return aircompany;
    }

    private Aircompany aircompany;
    private String elementName;
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
    private static final String EMPTY = "";
    private boolean overSeasFlight;
    private WeaponType weaponType;
    private int passengerQuantity;
    private String name = "";
    private int cruisingSpeed; //km per hour
    private int flightRange; //km
    private int maxTakeOffWeight; // ton
    private int maxFlightHeight; // km
    private int fuelConsumption; // kg per hour

    public Aircompany parseXML(String XMLPath) throws FileNotFoundException, XMLStreamException {

                XMLInputFactory factory = XMLInputFactory.newInstance();
                InputStream in = new FileInputStream(XMLPath);
                XMLStreamReader reader = factory.createXMLStreamReader(in);
                String elementName = EMPTY;
            while(reader.hasNext()){
                int event = reader.next();
                switch (event){
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = reader.getLocalName();
                        if(elementName.equals(AIRCOMPANY)){
                            aircompany = new Aircompany();
                        }
                        catchAttribute(reader);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        buildPlanes(reader);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        catchCharacters(reader, elementName);
                }
            }
            return aircompany;
    }
    private void catchCharacters(XMLStreamReader reader, String elementName) throws XMLStreamException {
        if (!reader.getText().trim().equals("")){
            switch (elementName){
                case NAME:
                    name = reader.getText();
                    break;
                case CRUISING_SPEED:
                    cruisingSpeed = Integer.parseInt(reader.getText());
                    break;
                case FLIGHT_RANGE:
                    flightRange = Integer.parseInt(reader.getText());
                    break;
               case MAX_TAKE_OFF_WEIGHT:
                   maxTakeOffWeight = Integer.parseInt(reader.getText());
                   break;
               case MAX_FLIGHT_HEIGHT:
                    maxFlightHeight = Integer.parseInt(reader.getText());
                    break;
               case FUEL_CONSUMPTION:
                   fuelConsumption = Integer.parseInt(reader.getText());
                   break;
            }
        }
    }
    private void buildPlanes(XMLStreamReader reader) {
        elementName = reader.getLocalName();
        switch (elementName){
            case CARGOPLANE:
                aircompany.getPlanes().add(new CargoPlane(name, cruisingSpeed, flightRange, maxTakeOffWeight,
                        maxFlightHeight, fuelConsumption, overSeasFlight));
                break;
            case PASSENGERPLANE:
                aircompany.getPlanes().add(new PassangerPlane(name, cruisingSpeed, flightRange, maxTakeOffWeight,
                    maxFlightHeight, fuelConsumption, passengerQuantity));
                break;
            case MILITARYPLANE:
                aircompany.getPlanes().add(new MilitaryPlane(name, cruisingSpeed, flightRange, maxTakeOffWeight,
                        maxFlightHeight, fuelConsumption, weaponType));
                break;
        }
    }
    private void catchAttribute(XMLStreamReader reader){
        String attributeName = reader.getAttributeLocalName(0);
        if(attributeName != null){
            switch (attributeName){
                case OVERSEAS_FLIGHT:
                    overSeasFlight = Boolean.parseBoolean(reader.getAttributeValue(0));
                    break;
                case PASSENGER_QUANTITY:
                    passengerQuantity = Integer.parseInt(reader.getAttributeValue(0));
                    break;
                case WEAPON_TYPE:
                    String type = reader.getAttributeValue(0);
                    switch (type) {
                        case ROCKETS:
                            weaponType = WeaponType.ROCKETS;
                            break;
                        case MACHINEGUN:
                            weaponType = WeaponType.MACHINEGUN;
                            break;
                        case LASER:
                            weaponType = WeaponType.LASER;
                            break;
                    }
                    break;
                }
            }
        }
    }


