package Person;

public class Cleaner extends Employee{
    public Cleaner(String id, String surname, String name, String patronymic, String age, String passportSeries, String passportNumber, String number, String post) {
        super(id, surname, name, patronymic, age, passportSeries, passportNumber, number, post);
        this.setPost("Уборщик");
    }
}
