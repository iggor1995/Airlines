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
}
