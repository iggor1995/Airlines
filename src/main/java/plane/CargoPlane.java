package plane;

import plane.Plane;

/**
 * Created by User on 15.06.2017.
 */
public class CargoPlane extends Plane {
    /**
     * added option: overseasFlight - if plane can fly overseas(more than 10000 km distance)
     */
    private boolean overSeasFlight;
    public CargoPlane(String name, int cruisingSpeed, int flightRange, int maxTakeOffWeight,
                      int maxFlightHeight, int fuelConsumption, boolean overSeasFlight) {
        super(name, cruisingSpeed, flightRange, maxTakeOffWeight, maxFlightHeight, fuelConsumption);
        this.overSeasFlight = overSeasFlight;
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

    public boolean isOverSeasFlight() {
        return overSeasFlight;
    }
}
