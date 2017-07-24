package plane;

import plane.Plane;

/**
 * Created by User on 15.06.2017.
 */
public class PassangerPlane extends Plane {
    /**
     * added passanger quantity
     */
    private int passengersQuantity;

    public PassangerPlane(String name, int cruisingSpeed, int flightRange, int maxTakeOffWeight,
                          int maxFlightHeight, int fuelConsumption, int passengersQuantity) {
        super(name, cruisingSpeed, flightRange, maxTakeOffWeight, maxFlightHeight, fuelConsumption);
        this.passengersQuantity = passengersQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PassangerPlane that = (PassangerPlane) o;

        return passengersQuantity == that.passengersQuantity;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + passengersQuantity;
        return result;
    }

    public int getPassengersQuantity() {
        return passengersQuantity;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getCruisingSpeed() {
        return super.getCruisingSpeed();
    }

    @Override
    public int getFlightRange() {
        return super.getFlightRange();
    }

    @Override
    public int getMaxTakeOffWeight() {
        return super.getMaxTakeOffWeight();
    }

    @Override
    public int getMaxFlightHeight() {
        return super.getMaxFlightHeight();
    }

    @Override
    public int getFuelConsumption() {
        return super.getFuelConsumption();
    }
}
