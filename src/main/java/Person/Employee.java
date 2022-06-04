package Person;

import java.time.LocalDate;

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
    private Integer rateAnHour;
    private int hour;
    private LocalDate date;

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

    public Employee(String id, String surname, String name, String patronymic, String post) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.post = post;
        this.id = id;
    }

    public Employee(String id, String surname, String name, String patronymic, String post, int rateAnHour, int hour, LocalDate date) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.post = post;
        this.id = id;
        this.rateAnHour = rateAnHour;
        this.hour = hour;
        this.date = date;
    }

    public Employee(String id, String surname, String name, String patronymic, String post, String rateAnHour, String hour, String date) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.post = post;
        this.id = id;
        this.rateAnHour = Integer.valueOf(rateAnHour);
        this.hour = Integer.parseInt(hour);
        this.date = LocalDate.parse(date);
    }
    public static int salaryCalculation(int rateAnHour, int hour){
        int result = rateAnHour*hour;
        return result;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getRateAnHour() {
        return rateAnHour;
    }

    public void setRateAnHour(Integer rateAnHour) {
        this.rateAnHour = rateAnHour;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
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
