package operation;

import aircompany.Aircompany;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import plane.CargoPlane;
import plane.MilitaryPlane;
import plane.PassangerPlane;
import plane.WeaponType;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXParser extends  DefaultHandler {
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
    private boolean overSeasFlight;
    private WeaponType weaponType;
    private int passengerQuantity;
    private String name = "";
    private int cruisingSpeed; //km per hour
    private int flightRange; //km
    private int maxTakeOffWeight; // ton
    private int maxFlightHeight; // km
    private int fuelConsumption; // kg per hour


    public Aircompany parseXML(String pathXML) {
        try {
            javax.xml.parsers.SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setValidating(false);
            javax.xml.parsers.SAXParser sp = spf.newSAXParser();
            sp.parse(new File(pathXML), this);

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return aircompany;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.elementName = qName;
        if(elementName.equals(AIRCOMPANY)){
            aircompany = new Aircompany();
        }
        if (attributes.getQName(0) != null) {
            switch (attributes.getQName(0)) {
                case OVERSEAS_FLIGHT:
                    overSeasFlight = Boolean.parseBoolean(attributes.getValue(0));
                    break;
                case PASSENGER_QUANTITY:
                    passengerQuantity = Integer.parseInt(attributes.getValue(0));
                    break;
                case WEAPON_TYPE:
                    String type = attributes.getValue(0);
                    switch (type) {
                        case ROCKETS:
                            weaponType = WeaponType.ROCKETS;
                            break;
                        case MACHINEGUN:
                            weaponType = WeaponType.MACHINEGUN;
                            break;
                        case LASER:
                            weaponType = WeaponType.LASER;
                    }
            }
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!String.valueOf(ch, start, length).trim().equals("")) {
            switch (elementName) {
               case NAME:
                    this.name = String.valueOf(ch, start, length);
                    break;
               case CRUISING_SPEED:
                    this.cruisingSpeed = Integer.parseInt(String.valueOf(ch, start, length));
                    break;
               case FLIGHT_RANGE:
                    this.flightRange = Integer.parseInt(String.valueOf(ch, start, length));
                    break;
               case MAX_TAKE_OFF_WEIGHT:
                    this.maxTakeOffWeight = Integer.parseInt(String.valueOf(ch, start, length));
                    break;
               case MAX_FLIGHT_HEIGHT:
                    this.maxFlightHeight = Integer.parseInt(String.valueOf(ch, start, length));
                    break;
               case FUEL_CONSUMPTION:
                    this.fuelConsumption = Integer.parseInt(String.valueOf(ch, start, length));
                    break;

            }
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case CARGOPLANE:
                aircompany.getPlanes().add(new CargoPlane(name, cruisingSpeed, flightRange, maxTakeOffWeight,
                        maxFlightHeight, fuelConsumption, overSeasFlight));
                break;
            case PASSENGERPLANE:
                this.aircompany.getPlanes().add(new PassangerPlane(name, cruisingSpeed, flightRange, maxTakeOffWeight,
                        maxFlightHeight, fuelConsumption, passengerQuantity));
                break;
            case MILITARYPLANE:
                this.aircompany.getPlanes().add(new MilitaryPlane(name, cruisingSpeed, flightRange, maxTakeOffWeight,
                        maxFlightHeight, fuelConsumption, weaponType));
                break;

        }
    }
}

