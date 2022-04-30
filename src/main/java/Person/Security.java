package Person;

public class Security extends Employee{
    public Security(String surname, String name, String patronymic, int age, int number, int passportSeries, int passportNumber) {
        super(surname, name, patronymic, age, number, passportSeries, passportNumber);
        this.setPost("Охранник");
    }
}
