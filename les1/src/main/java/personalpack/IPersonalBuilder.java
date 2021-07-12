package personalpack;

public interface IPersonalBuilder<T>{

    T setFirstName(String firstName);
    T setLastName(String lastName);
    T setMiddleName(String middleName);
    T setCountry(String country);
    T setAddress(String address);
    T setPhone(String phone);
    T setAge(int age);
    T setGender(Gender gender);

}
