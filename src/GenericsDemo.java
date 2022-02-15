/**
 * @author d_shilko
 * Created: 15.02.2022
 */

public class GenericsDemo {

    public static void main(String[] args) {

        Wheels wheels = new Wheels();
        DPD<Wheels> wheelsDPD = new DPD<Wheels>();
        wheelsDPD.loading(wheels);
        wheelsDPD.unloading();

        System.out.println("-----------------------------------");

        Televisor televisor = new Televisor();
        DPD<Televisor> televisorDPD = new DPD<>();
        televisorDPD.loading(televisor);
        televisorDPD.unloading();

        System.out.println("-----------------------------------");

        FrameHouse frameHouse = new FrameHouse();
        DPD<FrameHouse> frameHouseDPD = new DPD<>();
        frameHouseDPD.loading(frameHouse);
        frameHouseDPD.unloading();


    }
}

interface cargo {
    void movable();
}

class DPD<Y extends cargo> {  //DPD - транспортная компания
    public Y cargo;

    public void loading(Y cargo) {
        cargo.movable();
        System.out.println((cargo) + " погрузили, все добро");
    }

    public Y unloading() {
        System.out.println("все разгрузили");
        return cargo;
    }
}

class Televisor implements cargo {

    @Override
    public void movable() {
        System.out.println("подними да неси");
    }
}

class Wheels implements cargo {

    @Override
    public void movable() {
        System.out.println("главное чтобы было 4");
    }
}

class FrameHouse implements cargo {

    @Override
    public void movable() {
        System.out.println("чуть не абас**лись!!!");
    }

}