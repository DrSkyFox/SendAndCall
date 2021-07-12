import carpack.Engine;
import carpack.Lorry;
import personalpack.*;
import polymorph.Circle;
import polymorph.Quad;
import polymorph.Shape;
import polymorph.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Person person = new PersonalBuilder()
                .setFirstName("Gender")
                .setMiddleName("Bender")
                .setAge(3000)
                .setGender(Gender.MALE)
                .setAddress("Earth")
                .build();
        System.out.println(person);
        System.out.println();

        Lorry lorry = new Lorry(new Engine("Electo"), "red", "Glory");
        System.out.println(lorry);

        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Circle("Circle", 10.0));
        shapeList.add(new Quad("Quad!!!", 5.0));
        shapeList.add(new Triangle("Triangle", 5.0, 10.0));

        for (Shape shape : shapeList) {
            shape.draw();
        }


    }
}
