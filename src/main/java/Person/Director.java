package Person;

public class Director extends User{
    public Director() {
    }

    public Director(String name, String surname, String patronymic, String passportSeries, String passportNumber, String number, String login, String password) {
        super(name, surname, patronymic, passportSeries, passportNumber, number, login, password);
    }
}
