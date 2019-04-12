import Animal.*;
import Interfaces.Swimable;

public class Course {

    protected String object;
    protected int size;

    private Course(String object, int size) {
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
        }else if(object.equals("Барьер")){
            animal.jump();
        }else if (animal instanceof Dog||animal instanceof Human){
            ((Swimable) animal).swim();
        }

    }


}
