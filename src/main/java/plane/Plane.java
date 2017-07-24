package plane;

/**
 * Created by User on 15.06.2017.
 */
public abstract class Plane implements Comparable<Plane>{

    private String name;
    private int cruisingSpeed; //km per hour
    private int flightRange; //km
    private int maxTakeOffWeight; // ton
    private int maxFlightHeight; // km
    private int fuelConsumption; // kg per hour

    public Plane(String name, int cruisingSpeed, int flightRange, int maxTakeOffWeight, int maxFlightHeight, int fuelConsumption){
        this.name = name;
        this.cruisingSpeed = cruisingSpeed;
        this.flightRange = flightRange;
        this.maxTakeOffWeight = maxTakeOffWeight;
        this.maxFlightHeight = maxFlightHeight;
        this.fuelConsumption = fuelConsumption;
    }

    public String getName() {
        return name;
    }

    public int getCruisingSpeed() {
        return cruisingSpeed;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public int getMaxTakeOffWeight() {
        return maxTakeOffWeight;
    }

    public int getMaxFlightHeight() {
        return maxFlightHeight;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int compareTo(Plane o) {

        if(this.flightRange < o.getFlightRange())
            return  -1;
        else if(this.flightRange == o.getFlightRange())
            return  0;
        else
            return  1;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        if (cruisingSpeed != plane.cruisingSpeed) return false;
        if (flightRange != plane.flightRange) return false;
        if (maxTakeOffWeight != plane.maxTakeOffWeight) return false;
        if (maxFlightHeight != plane.maxFlightHeight) return false;
        if (fuelConsumption != plane.fuelConsumption) return false;
        return name != null ? name.equals(plane.name) : plane.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + cruisingSpeed;
        result = 31 * result + flightRange;
        result = 31 * result + maxTakeOffWeight;
        result = 31 * result + maxFlightHeight;
        result = 31 * result + fuelConsumption;
        return result;
    }
}
