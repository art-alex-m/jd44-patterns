public class PersonBuilder {
    private String name;
    private String surname;
    private String address;
    private int age = 0;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Возраст должен быть больше 0");
        }
        this.age = age;
        return this;
    }

    public Person build() {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalStateException("Имя и фамилия должны быть указаны");
        }
        if (age > 0) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        person.setAddress(address);

        return person;
    }
}
