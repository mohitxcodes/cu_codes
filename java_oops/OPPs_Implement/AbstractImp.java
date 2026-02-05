package OPPs_Implement;

abstract class Animal {
    abstract void sound();

    abstract void color();

    abstract void size();

    void eat() {
        System.out.println("Animal is eating");
    }

    void sleep() {
        System.out.println("Animal is sleeping");
    }

}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog is barking");
    }

    void color() {
        System.out.println("Dog is black");
    }

    void size() {
        System.out.println("Dog is small");
    }

}

public class AbstractImp {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
        dog.color();
        dog.size();
        dog.eat();
        dog.sleep();
    }
}
