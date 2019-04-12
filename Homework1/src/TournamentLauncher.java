import Animal.*;
import Interfaces.Jumpable;
import Interfaces.Swimable;

public class TournamentLauncher {

    public static void main(String[] args) {

        Human h = new Human();
        if (h.getSex() == Sex.FEMALE) {

        }

        Animal[] animals = new Animal[5];

        for (Animal animal : animals) {

            if (animal instanceof Swimable) {
                Swimable swimable = (Swimable) animal;
                swimable.swim();
            }
        }


    }
}