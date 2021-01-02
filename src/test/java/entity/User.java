package entity;

public class User implements java.io.Serializable {
    private String name;
    private int gender;

    public User() {
    }

    public static User initUser() {
        return new User("monkey",1);
    }

    public User(String name, int gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
