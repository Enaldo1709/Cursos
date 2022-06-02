package library.models;

public class Author {
    private String surname;
    private Gender gender;
    private int age;
    public Author(String surname, Gender gender, int age) {
        this.gender = gender;
        this.age = age;
        this.surname = surname;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
