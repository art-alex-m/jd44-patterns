public class Person {
    private final String name;
    private final String surname;
    private int age = 0;
    private String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void happyBirthday() {
        if (!hasAge()) return;
        age++;
    }

    public boolean hasAge() {
        return age > 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public PersonBuilder newChildBuilder(int age) {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(address)
                .setAge(age);
    }

    @Override
    public String toString() {
        return String.format("Person{name=%s, surname=%s, age=%s, address=%s}", name, surname, age, address);
    }
}
