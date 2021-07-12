package carpack;
//Наследоваться класс может только от 1 класса. А movable и Stopable - это интрефейсы, которые подключаются через implements
public class Lorry extends Car implements Movable, Stopable {

    public Lorry(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void move() {
        System.out.println("Moving");
    }

    @Override
    public void stop() {
        System.out.println("Stopped");
    }
}
