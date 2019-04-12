package Animal;

import Interfaces.Swimable;

public class Human extends Animal implements Swimable {

    public Human(String name, int age, Sex sex) {
        super(name, age);
        this.sex=sex;
    }

    private Sex sex;

    @Override
    public void run() {

    }

    @Override
    public void jump() {

    }

    @Override
    public void swim() {

    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}