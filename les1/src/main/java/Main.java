import personalpack.Gender;
import personalpack.Person;
import personalpack.PersonalBuilder;

public class Main {
    public static void main(String[] args) {
        Person person = new PersonalBuilder()
                .setFirstName("Ivan")
                .setLastName("Grozniy")
                .setMiddleName("Czar")
                .setPhone("777-77-77")
                .setGender(Gender.MALE)
                .build();
        System.out.println(person.toString());
    }

}
