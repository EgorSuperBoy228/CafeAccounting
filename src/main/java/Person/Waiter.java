package Person;

public class Waiter extends Employee{
    public Waiter(String surname, String name, String patronymic, int age, int number, int passportSeries, int passportNumber) {
        super(surname, name, patronymic, age, number, passportSeries, passportNumber);
        this.setPost("Официант");
    }
}
