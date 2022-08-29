package entity;

/**
 * author:@song;
 * version:1.0;
 */
public class User {
    public String NAME;
    public String age;

    @Override
    public String toString() {
        return "User{" +
                "NAME='" + NAME + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
