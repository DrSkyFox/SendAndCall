package polymorph;

public class Quad extends Shape{
    private Double sideLength;

    public Quad(String name, Double sideLength) {
        super(name);
        this.sideLength = sideLength;
    }

    public Double getArea() {
        return sideLength*sideLength;
    }
}
