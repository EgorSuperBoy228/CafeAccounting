package com.example.cafeaccounting;

import Database.DatabaseHandler;
import Person.Accounting;
import Person.Cafe;
import Person.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountingController{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker datePicker;


    @FXML
    private TableColumn<Employee, DatePicker> tableColumnDate;

    @FXML
    private TableColumn<Employee, Integer> tableColumnHour;

    @FXML
    private TableColumn<Employee, String> tableColumnId;

    @FXML
    private TableColumn<Employee, String> tableColumnName;

    @FXML
    private TableColumn<Employee, String> tableColumnPatronymic;

    @FXML
    private TableColumn<Employee, String> tableColumnPost;

    @FXML
    private TableColumn<Employee, Integer> tableColumnRateAnHour;

    @FXML
    private TableColumn<Employee, String> tableColumnSurname;
    @FXML
    private TextField idTextField;

    @FXML
    private ChoiceBox<String> choiceBoxEmployee;
    @FXML
    private TextField hourTextField;
    private LocalDate date;
    private Integer hour;
    private Integer rateAnHour;
    @FXML
    public TableView<Employee> table;
    private Employee employee;
    private  static Cafe data;
    private double xOffset;
    private double yOffset;
    private MenuItem update = new MenuItem("Изменить");
    private int id;
    private static ObservableList<String> employees = FXCollections.observableArrayList();

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTextField;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @FXML
    void initialize() throws ClassNotFoundException, SQLException {
        data = new Cafe();
        data.clearAccounting();

        //choiceBoxEmployee.setItems();
        DatabaseHandler dbHandler = new DatabaseHandler();
        try{
            Connection connection = DatabaseHandler.getDbConnection();
            ResultSet resultSet = dbHandler.getAccounting();
            while(resultSet.next()){
                data.addAccounting(new Employee(resultSet.getString("id"),resultSet.getString("idEmployee"),resultSet.getString("RateAnHour"),resultSet.getString("Hour"),resultSet.getString("Date")));
                System.out.println("True");
            };
        } catch (SQLException ex){
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("False");
        }
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try{
            Connection connection = DatabaseHandler.getDbConnection();
            ResultSet resultSetEmployee = databaseHandler.getEmployee();
            employees.clear();
            while(resultSetEmployee.next()){
                String id = resultSetEmployee.getString("id");
                String surname = resultSetEmployee.getString("surname");
                String name = resultSetEmployee.getString("name");
                String patronymic = resultSetEmployee.getString("patronymic");
                String entry = id+" - "+surname+" "+name+" "+patronymic;
                employees.add(entry);
                //employees.add(employee = new Employee(resultSetEmployee.getString("id"),resultSetEmployee.getString("surname"),resultSetEmployee.getString("name")));
                System.out.println("True");
            };
        } catch (SQLException ex){
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("False");
        }
        choiceBoxEmployee.setItems(employees);

        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idEmployee"));
        tableColumnRateAnHour.setCellValueFactory(new PropertyValueFactory<>("rateAnHour"));
        tableColumnHour.setCellValueFactory(new PropertyValueFactory<>("hour"));
        tableColumnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        table.setItems(data.getEmployeesAccounting());




        MenuItem dell = new MenuItem("Удалить");
        dell.setOnAction((ActionEvent event) -> {
            try {
                //DatabaseHandler dbHandler = new DatabaseHandler();
                int myIndex = table.getSelectionModel().getSelectedIndex();
                int idDell = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getIdAccounting()));
                dbHandler.dellAccounting(idDell);
                refreshTable();
            }
            catch (IndexOutOfBoundsException ex){
                Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Menu item 1");
            Object item = table.getSelectionModel().getSelectedItem();
            System.out.println("Selected item: " + item);
        });
        update.setOnAction((ActionEvent event) -> {
            int myIndex = table.getSelectionModel().getSelectedIndex();
            int idUpdate = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getIdAccounting()));
            data.addAccountingId(new Accounting(idUpdate));
            System.out.println(idUpdate);
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("updateaccounting-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 272, 237);
            } catch (IOException e) {
                e.printStackTrace();
            }
            scene.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = stage.getX() - event.getScreenX();
                    yOffset = stage.getY() - event.getScreenY();
                }
            });
            scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() + xOffset);
                    stage.setY(event.getScreenY() + yOffset);
                }
            });
            stage.setTitle("Редактор");
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            //UpdateAccounting updateAccounting = new UpdateAccounting(id);
            //updateAccounting.initialize();

        });

        ContextMenu menu = new ContextMenu();
        menu.getItems().add(update);
        menu.getItems().add(dell);
        table.setContextMenu(menu);

    }
    public void refreshTable() throws ClassNotFoundException {
        data = new Cafe();
        data.clearAccounting();
        DatabaseHandler dbHandler = new DatabaseHandler();
        try{
            Connection connection = DatabaseHandler.getDbConnection();
            ResultSet resultSet = dbHandler.getAccounting();
            while(resultSet.next()){
                data.addAccounting(new Employee(resultSet.getString("id"),resultSet.getString("idEmployee"),resultSet.getString("RateAnHour"),resultSet.getString("Hour"),resultSet.getString("Date")));
                System.out.println("True");
            };
        } catch (SQLException ex){
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("False");
        }
        //tableColumnIdAccounting.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idEmployee"));
        tableColumnRateAnHour.setCellValueFactory(new PropertyValueFactory<>("rateAnHour"));
        tableColumnHour.setCellValueFactory(new PropertyValueFactory<>("hour"));
        tableColumnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        table.setItems(data.getEmployeesAccounting());
    }
    @FXML
    void addButton(ActionEvent event) throws ClassNotFoundException, SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        date = datePicker.getValue();
        String value = choiceBoxEmployee.getValue();
        hour = Integer.valueOf(hourTextField.getText());
        rateAnHour = 155;
        Connection connection = DatabaseHandler.getDbConnection();
            employee = new Employee(untilSpace(value),rateAnHour,hour,date);
            System.out.println(untilSpace(value));
            dbHandler.setAccounting(employee);
            DialogManager dialogManager = new DialogManager();
            dialogManager.setTitle("Уведомление");
            dialogManager.setMessage("Добавление прошло успешно!");
            dialogManager.start();
            refreshTable();
    }

    private String untilSpace(String value) {
        return value.replaceAll(" .*", "");
    }


}
