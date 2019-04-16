package Animal;

public enum Sex {
    MALE("male"), FEMALE;

    private String name;

    Sex(String name) {
        this.name = name;
    }

    Sex() {
    }

    public String getName() {
        return name;
    }

}