package operation;

import plane.CargoPlane;
import plane.MilitaryPlane;
import plane.PassangerPlane;
import plane.Plane;


/**
 * Created by User on 16.06.2017.
 */
public class PlanesListDrawer {

    public static void drawPlanesList(Plane[] planes){
        int counter = 0;
        for(Plane plane : planes){
            if(plane == null)
                break;
            counter++;
            System.out.println(counter + ") " + plane.getName());
            System.out.println("                   Cruising speed ---------------> " + plane.getCruisingSpeed() + "km/h");
            System.out.println("                   Flight Range -----------------> " + plane.getFlightRange() + "km");
            System.out.println("                   Max take off weight ----------> " + plane.getMaxTakeOffWeight() + "(ton)");
            System.out.println("                   Max flight height ------------> " + plane.getMaxFlightHeight() + "km");
            System.out.println("                   Fuel Consumption -------------> " + plane.getFuelConsumption() + "kg/h");

            if(plane instanceof CargoPlane){
                System.out.println(("                   Overseas flight possibility --> " +
                        ((CargoPlane) plane).isOverSeasFlight()));
            }

            if(plane instanceof PassangerPlane){
                System.out.println(("                   Passangers max quantity ------> " +
                        ((PassangerPlane) plane).getPassengersQuantity()));
            }

            if(plane instanceof MilitaryPlane){
                System.out.println(("                   Weapon type  -----------------> " + ((MilitaryPlane) plane).getWeaponType()));
            }
            System.out.println();

        }
        System.out.println("\n");
    }
}
