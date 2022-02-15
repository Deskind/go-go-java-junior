/**
 * @author d_shilko
 * Created: 15.02.2022
 */

public class GenericsDemo {

    public static void main(String[] args) {

        /**
         * Лучше использовать ссылку типа 'Cargo'
         */
        Wheels wheels = new Wheels();

        /*todo идея говорит что справа от знака равно можно 'Wheels' удалить
         * в данном конкретном случае можно написать
         * DPD<cargo> wheels = .....
         * потому как DPD и так параметризовано всем, что является 'cargo'
         * т.е завязываться на интерфейс всегда боле правильно (а не на конкретную реализацию интерфейса)*/
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

interface cargo { /*todo имя классов, интерфейсов - всегда с большой буквы*/

    /*todo название метода не очень
     * movable - это прилагательное , а лучше использовать глагол */
    void movable();

}

class DPD<Y extends cargo> {  //DPD - транспортная компания

    /* todo
     * данная ссылка всегда 'null'
     * т.е она никогда не указывает ни на какой объект
     */
    public Y cargo;

    public void loading(Y cargo) {
        cargo.movable();
        System.out.println((cargo) + " погрузили, все добро");
    }

    /*todo идея подчеркнула имя метода и написала, что значение, которое возвращает этот метод не используется
     * наполнить это метод неким большим слыслом ...
     * может быть возвращать стоимость разрузки или еще что ...
     * возможно, добавить 'cargo' стоимость или что то в этом духе
     * */
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