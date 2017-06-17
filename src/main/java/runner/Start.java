package runner;

import aircompany.Aircompany;
import filter.PlaneFilter;
import operation.SetPlanes;
import plane.CargoPlane;
import operation.PlanesListDrawer;
import plane.MilitaryPlane;
import plane.PassangerPlane;
import plane.Plane;
import plane.WeaponType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by User on 15.06.2017.
 */
public class Start {

    private static ArrayList<Plane> planes = new ArrayList();

    public static void main(String[] args) {

        Aircompany british = new Aircompany("British Airlines", SetPlanes.setList());

        System.out.println("**********" + british.getName() + " list*************");
        PlanesListDrawer.drawPlanesList(british.getPlanes());
        Arrays.sort(british.getPlanes());
        System.out.println("Range sorted list");
        PlanesListDrawer.drawPlanesList(british.getPlanes());

        try {
            PlaneFilter.getFuelPlanes(british.getPlanes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
