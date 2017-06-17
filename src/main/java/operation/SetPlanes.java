package operation;

import plane.*;

/**
 * Created by User on 17.06.2017.
 */
public class SetPlanes {

    public static Plane[] setList(){
        Plane[] planes = new Plane[5];

        planes[0] = new CargoPlane("Boeing - 747 - 8", 900, 10500,
                447, 13750,  10300, true );
        planes[1] = new PassangerPlane("Tupolev TU - 154", 950, 5200,
                300, 11000,  6200, 180 );
        planes[2] = new PassangerPlane("Tupolev TU - 204", 850, 4000,
                107, 7200,  3450, 192 );
        planes[3] = new PassangerPlane("Sukhoi SuperJet - 100", 900, 4500,
                42, 8000,  1700, 95 );
        planes[4] = new MilitaryPlane("Douglas F-4 Phantom II", 2500, 2300,
                10, 17000,  4000, WeaponType.ROCKETS);
        return planes;
    }


}
