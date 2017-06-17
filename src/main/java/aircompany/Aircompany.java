package aircompany;

import plane.Plane;

/**
 * Created by User on 17.06.2017.
 */
public class Aircompany {
    private String name;
    private Plane[] planes;

    public Aircompany(String name, Plane[] planes){
        this.name = name;
        this.planes = planes;
    }

    public String getName() {
        return name;
    }

    public Plane[] getPlanes() {
        return planes;
    }
}
