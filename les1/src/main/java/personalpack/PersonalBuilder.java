package personalpack;

public class PersonalBuilder implements IPersonalBuilder<PersonalBuilder>{

    private Person person;

    public PersonalBuilder() {
        person = new Person();
    }

    @Override
    public PersonalBuilder setFirstName(String firstName) {
        person.setFirstName(firstName);
        return this;
    }

    @Override
    public PersonalBuilder setLastName(String lastName) {
        person.setLastName(lastName);
        return this;
    }

    @Override
    public PersonalBuilder setMiddleName(String middleName) {
        person.setMiddleName(middleName);
        return this;
    }

    @Override
    public PersonalBuilder setCountry(String country) {
        person.setCountry(country);
        return this;
    }

    @Override
    public PersonalBuilder setAddress(String address) {
        person.setAddress(address);
        return this;
    }

    @Override
    public PersonalBuilder setPhone(String phone) {
        person.setPhone(phone);
        return this;
    }

    @Override
    public PersonalBuilder setAge(int age) {
        person.setAge(age);
        return this;
    }

    @Override
    public PersonalBuilder setGender(Gender gender) {
        person.setGender(gender);
        return this;
    }

    public Person build(){
        return person;
    }


}
