public class Person {

    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person person = new Person("Mohit", 22);
        System.out.println(person.name);
        System.out.println(person.age);
    }

}
