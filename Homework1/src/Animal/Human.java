package Animal;

import Interfaces.Swimable;

public class Human extends Animal implements Swimable {

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