package Person;

public class Bartender extends Employee{
    public Bartender(String surname, String name, String patronymic, int age, int number, int passportSeries, int passportNumber) {
        super(surname, name, patronymic, age, number, passportSeries, passportNumber);
        this.setPost("Бармен");
    }
}
