package polymorph;

public class Shape {
    private String name;

    public String getName() {
        return name;
    }

    public Shape(String name) {
        this.name = name;
    }

    public void draw() {
        System.out.println("Drawing shape...");
    }

    @Override
    public String toString() {
        return "polymorph.Shape{" +
                "name='" + name + '\'' +
                '}';
    }
}
