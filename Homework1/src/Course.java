import Animal.*;
import Interfaces.Swimable;

public class Course {

    protected String object;
    protected int size;


    public Course(String object, int size) {
        this.object = object;
        this.size = size;
    }

    public String getObject() {
        return object;
    }

    public int getSize() {
        return size;
    }

    public void dolt(Animal animal){

        if (object.equals("Бег")){
            animal.run();
            System.out.println(animal.getName()+" пробежал "+ getSize()+" метров.");
        }else if(object.equals("Барьер")){
            animal.jump();
            System.out.println(animal.getName()+" прыгнул на "+ getSize()+" метров.");
        }else if (animal instanceof Dog||animal instanceof Human){
            ((Swimable) animal).swim();
            System.out.println(animal.getName()+" проплыл "+ getSize()+" метров.");
        }

    }


}
