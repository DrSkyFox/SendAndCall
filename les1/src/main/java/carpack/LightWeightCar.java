package carpack;

public class LightWeightCar extends Car  implements Openable, Movable{

    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void move() {
        System.out.println("Moving");
    }


    @Override
    public void open() {
        Openable.super.open();
    }
}
