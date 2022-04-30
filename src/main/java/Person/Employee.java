package Person;

public abstract class Employee {
    private String name;
    private String surname;
    private String patronymic;
    private String post;
    private int passportSeries;
    private int passportNumber;
    private int number;
    private int age;
    private static int count = 1;
    private int id;

    public Employee(String surname,String name, String patronymic, int age, int number, int passportSeries, int passportNumber){
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
        this.number = number;
        this.passportSeries=passportSeries;
        this.passportNumber=passportNumber;
        this.id=count;
        count++;
    }

    public int getId() {
        return id;
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

    public int getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(int passportSeries) {
        this.passportSeries = passportSeries;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
