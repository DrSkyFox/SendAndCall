package carpack;

public interface Openable {
    default void open() {
        System.out.println("Open the car");
    }

}
