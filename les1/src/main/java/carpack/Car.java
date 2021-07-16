package carpack;

abstract class Car {

    private Engine engine; //Изменить модификатор доступа с public на private
    private String color;
    private String name;

    //Добавлен конструтор
    public Car(Engine engine, String color, String name) {
        this.engine = engine;
        this.color = color;
        this.name = name;
    }

    //Перенести методы open и start в интерфейс
    protected void start() {
        System.out.println("carpack.Car starting");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
