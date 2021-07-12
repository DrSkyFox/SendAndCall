package polymorph;

public class Circle extends Shape{

    private Double radius;

    public Circle(String name) {
        super("polymorph.Circle");
    }


    public Circle(String name, Double radius) {
        super("polymorph.Circle with radius: " + radius);
        this.radius = radius;
    }

    public Double getRadius() {
        if(radius!=null) {
            return radius*radius*3.14;
        }
        return 0.0;
    }


    @Override
    public void draw() {
        System.out.println("polymorph.Shape printing");;
    }
}
