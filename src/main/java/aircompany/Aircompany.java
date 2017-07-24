package aircompany;

import plane.Plane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 17.06.2017.
 */
public class Aircompany {
    private String name;
    private List<Plane> planes = new ArrayList<Plane>();

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        return name + " " + planes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aircompany that = (Aircompany) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return planes != null ? planes.equals(that.planes) : that.planes == null;
    }

    @Override
    public int hashCode() {
        return planes.hashCode();
    }
}
