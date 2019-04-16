import Animal.*;

public class Team {

    int maxNumber=4;
    private String teamName;
    private Animal[] members;

    public Team(String teamName) {
        this.teamName = teamName;
        members=new Animal[maxNumber];
    }

    void addMember(Animal animal) {
        if (!canAddMember(animal)){
            return;
        }

        for (int i = 0; i < members.length; i++) {
            if (members[i] == null ){
                members[i] = animal;
                return;
            }
        }
    }


    private boolean canAddMember(Animal animal){

        if (this.maxMember() == maxNumber){
            System.out.printf("Команда %s уже скомплектована\n", this.teamName);
            return false;
        }

        return true;
    }

    // колличество в команде
    private  int maxMember(){
        int res = 0;

        for (Animal animal: members) {
            if (animal != null){
                res ++;
            }
        }
        return res;
    }

    public String getTeamName() {
        return teamName;
    }
    // состав

    public  void info(){
        System.out.println("Команда '"+getTeamName()+"' состоит из:");
        for (Animal animal:members) {
            if (animal instanceof Human){
                System.out.println(animal.getName()+" "+animal.getAge()+" "+((Human)animal).getSex());
            }else{System.out.println(animal.getName()+" "+animal.getAge());}

        }

    }


    public  void showResults(){
        System.out.println("Результаты: ");
        for (Animal animal:members) {


        }

    }




}
