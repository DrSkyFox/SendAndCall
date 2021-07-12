package polymorph;

import static java.lang.Math.sqrt;

public class Triangle extends Shape {
    private Double sideA;
    private Double sideB;
    private Double sideC;


    public Triangle(String name, Double sideA, Double sideB) {
        super(name);
        this.sideA = sideA;
        this.sideB = sideB;
        sideC = sqrt(sideA*sideA + sideB*sideB);
    }

    @Override
    public void draw() {
        System.out.println("Drawing polymorph.Triangle with sideC: " + sideC);
    }

    public Double getSideA() {
        return sideA;
    }

    public void setSideA(Double sideA) {
        this.sideA = sideA;
    }

    public Double getSideB() {
        return sideB;
    }

    public void setSideB(Double sideB) {
        this.sideB = sideB;
    }

    public Double getSideC() {
        return sideC;
    }

    public void setSideC(Double sideC) {
        this.sideC = sideC;
    }
}
