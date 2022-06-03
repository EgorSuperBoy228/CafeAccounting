package Person;

public class  User {
    private String name;
    private String surname;
    private String patronymic;
    private String passportSeries;
    private String passportNumber;
    private String number;
    private String login;
    private String password;

    public User() {
    }

    public User(String name, String surname, String patronymic, String passportSeries, String passportNumber, String number, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.number = number;
        this.login = login;
        this.password = password;
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

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
