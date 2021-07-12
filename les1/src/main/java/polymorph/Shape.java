package polymorph;

public abstract class Shape {
    private String name;

    public String getName() {
        return name;
    }

    public Shape(String name) {
        this.name = name;
    }

    public void draw() {
        System.out.println("This "  + name  + "is drawing");
    }

    @Override
    public String toString() {
        return "Shape{" +
                "name='" + name + '\'' +
                '}';
    }
}
