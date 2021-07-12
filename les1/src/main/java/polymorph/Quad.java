package polymorph;

public class Quad extends Shape{
    private Double sideLength;

    public Quad(String name, Double sideLength) {
        super("polymorph.Quad");
        this.sideLength = sideLength;
    }

    //some function
    public Double getArea() {
        return sideLength*sideLength;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Type polymorph.Quad");
    }
}
