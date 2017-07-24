package plane;

import plane.Plane;

/**
 * Created by User on 15.06.2017.
 */
public class MilitaryPlane extends Plane {
    /**
     * added WeaponType
     */
    private WeaponType weaponType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MilitaryPlane that = (MilitaryPlane) o;

        return weaponType == that.weaponType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (weaponType != null ? weaponType.hashCode() : 0);
        return result;
    }

    public MilitaryPlane(String name, int cruisingSpeed, int flightRange, int maxTakeOffWeight, int maxFlightHeight,
                         int fuelConsumption, WeaponType weaponType) {
        super(name, cruisingSpeed, flightRange, maxTakeOffWeight, maxFlightHeight, fuelConsumption);
        this.weaponType = weaponType;
    }

    public WeaponType getWeaponType() {
        return weaponType;
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
