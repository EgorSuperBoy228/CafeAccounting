package Person;

public class Security extends Employee{
    public Security(String id, String surname, String name, String patronymic, String age, String passportSeries, String passportNumber, String number, String post) {
        super(id, surname, name, patronymic, age, passportSeries, passportNumber, number, post);
        this.setPost("Охранник");
    }
}
