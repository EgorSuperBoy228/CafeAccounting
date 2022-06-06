package Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cafe  {
    private static ObservableList<Employee> employees = FXCollections.observableArrayList();
    private static ObservableList<Employee> employeesAccounting = FXCollections.observableArrayList();
    private static ObservableList<Employee> employeesReport = FXCollections.observableArrayList();
    public void addReport(Employee employee){
        this.employeesReport.add(employee);
    }
    public ObservableList<Employee> getReport(){
        return employeesReport;
    }

    public void add(Employee employee){
        this.employees.add(employee);
    }
    public ObservableList<Employee> getEmployees(){
        return employees;
    }

    public ObservableList<Employee> getEmployeesAccounting() {
        return employeesAccounting;
    }
    public void removeAllAccounting(){
        this.employeesAccounting.removeAll();
    }

    public void addAccounting(Employee employee){
        this.employeesAccounting.add(employee);
    }

    public void clear() {
        this.employees.clear();
    }
    public void clearReport() {
        this.employeesReport.clear();
    }
    public void clearAccounting() {
        this.employeesAccounting.clear();
    }

    public void remove(Employee employee) {
        this.employees.remove(employee);
    }
}
