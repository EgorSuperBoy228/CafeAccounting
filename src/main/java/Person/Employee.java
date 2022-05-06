package Person;

import javafx.beans.property.StringProperty;

public class Employee {
    private String name;
    private String surname;
    private String patronymic;
    private String post;
    private String passportSeries;
    private String passportNumber;
    private String number;
    private String age;
    private String id;
    private String gender;

    public Employee(String id, String surname, String name, String patronymic, String gender, String age, String passportSeries, String passportNumber, String number, String post) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
        this.number = number;
        this.gender=gender;
        this.passportSeries= passportSeries;
        this.passportNumber=passportNumber;
        this.id=id;
        this.post=post;
    }
    public Employee(String surname, String name, String patronymic, String gender, String age, String passportSeries, String passportNumber, String number, String post) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.age = age;
        this.number = number;
        this.passportSeries= passportSeries;
        this.passportNumber=passportNumber;
        this.post=post;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passport_number) {
        this.passportNumber = passportNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
