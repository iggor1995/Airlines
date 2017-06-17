package filter;

import operation.PlanesListDrawer;
import plane.Plane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 16.06.2017.
 */
public class PlaneFilter  {

    public static void getFuelPlanes(Plane[] planes) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input start fuel consumption value");
        int startVal = Integer.parseInt(reader.readLine()) ;
        System.out.println("input end fuel consumption value");
        int endVal = Integer.parseInt(reader.readLine());
        Plane[] fuelSortedPlanes = new Plane[planes.length];
        int counter = 0;
        for(Plane plane : planes){
            if(plane.getFuelConsumption() > startVal && plane.getFuelConsumption() < endVal){
                fuelSortedPlanes[counter] = plane;
                counter++;
            }
        }

        System.out.println("Fuel consumption sorted list between " + startVal + " and " + endVal);
        PlanesListDrawer.drawPlanesList(fuelSortedPlanes);
        System.out.println("End list");
    }

}
