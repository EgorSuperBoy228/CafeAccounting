package Person;

public class Cleaner extends Employee{
    public Cleaner(String surname, String name, String patronymic, int age, int number, int passportSeries, int passportNumber) {
        super(surname, name, patronymic, age, number, passportSeries, passportNumber);
        this.setPost("Уборщик");
    }
}
