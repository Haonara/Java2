package Animal;

import Interfaces.Swimable;

public class Dog extends Animal implements Swimable {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void run() {

    }

    @Override
    public void jump() {

    }

    @Override
    public void swim() {

    }
}
