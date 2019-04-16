import Animal.*;
import Interfaces.Jumpable;
import Interfaces.Swimable;

public class TournamentLauncher {

    public static void main(String[] args) {

        Team team1 = new Team( "Team1");
        team1.addMember(new Dog("Tuzik",5));
        team1.addMember(new Cat("Murka",3));
        team1.addMember(new Human("Vasya",15, Sex.MALE));
        team1.addMember(new Dog("Bobik",4));

        team1.info();

        Course c=new Course("Бег",500);
        Cat cat=new Cat("Murka",3);

        c.dolt(cat);


    }
}