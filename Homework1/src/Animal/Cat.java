package Animal;


public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void run() {

        System.out.println("Пробежал "+" метров.");

    }

    @Override
    public void jump() {

    }
}
