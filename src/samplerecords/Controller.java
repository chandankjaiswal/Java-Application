package samplerecords;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

import static java.lang.System.exit;

public class Controller {

    @FXML
    private GridPane rec;

    @FXML
    private TextField st_name;
    @FXML
    private TextField mid_name;
    @FXML
    private TextField last_name;
    @FXML
    private TextField fat_name;
    @FXML
    private DatePicker DOB;
    @FXML
    private TextField adhar;
    @FXML
    private TextField phone;
    @FXML
    private TextField dep;
    @FXML
    private TextField course;
    @FXML
    private TextField session;
    @FXML
    private TextArea address;
    @FXML
    private TextField dist;
    @FXML
    private TextField pin;
    @FXML
    private ComboBox states;
    @FXML
    private ComboBox gen;
    @FXML
    private ComboBox com;
    @FXML
    private TextField email;
    @FXML
    private TextField del_st_id;


    @FXML
    public void saves(ActionEvent actionEvent) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "");
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO student(name,fat_name,dob,adhar,com,gender,dep,course,ses,address,dist,state,pin,phone,email) VALUES('" + st_name.getText() + " " + mid_name.getText() + " " + last_name.getText() + "','" + fat_name.getText() + "','" + DOB.getValue() + "','" + adhar.getText() + "','" + com.getValue().toString() + "','" + gen.getValue().toString() + "','" + dep.getText() + "','" + course.getText() + "','" + session.getText() + "','" + address.getText() + "','" + dist.getText() + "','" + states.getValue().toString() + "','" + pin.getText() + "','" + phone.getText() + "','" + email.getText() + "')");
            statement.close();
            connection.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successful");
            //alert.setHeaderText("Ooops, there was an error!");
            alert.setContentText("Data Saved Successful");

            alert.showAndWait();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setHeaderText("Ooops, there was an error!");
            alert.setContentText(e.toString());
            alert.showAndWait();
        }
    }

    @FXML
    public void clears(ActionEvent actionEvent) {
        st_name.clear();
        mid_name.clear();
        last_name.clear();
        fat_name.clear();
        adhar.clear();
        phone.clear();
        dep.clear();
        course.clear();
        session.clear();
        address.clear();
        dist.clear();
        pin.clear();
        email.clear();
    }

    @FXML
    public void close(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Closing Application");
        alert.setContentText("Do You really want to Quit");
        alert.showAndWait();
        exit(0);
    }

    private TableView table = new TableView();
    private ObservableList<ObservableList> data;
  //  ObservableList<Coffee> coffees = FXCollections.observableArrayList();

    public void buildData(){

        data = FXCollections.observableArrayList();
        table = new TableView();
        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("Student ID");
        firstNameCol.setMinWidth(200);

        TableColumn accNumberCol = new TableColumn("First Name");
        accNumberCol.setMinWidth(100);

        TableColumn contactsCol = new TableColumn("Father Name");
        contactsCol.setMinWidth(100);

        TableColumn divisionCol = new TableColumn("DOB");
        divisionCol.setMinWidth(200);

        table.getColumns().addAll(firstNameCol, contactsCol, accNumberCol,divisionCol);

        try{

            Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "");
            PreparedStatement ps = conn.prepareStatement("select stu_id,name,fat_name,dob from student" );
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String stu_id = rs.getString( "stu_id" );
                String name = rs.getString( "name" );
                String fat_name = rs.getString( "fat_name" );
                String dob = rs.getString( "dob" );
                String temp="";

                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                    temp+= rs.getString(i)+"\t ";
                }
                data.add(row);
                System.out.println("Data: "+ temp + "\n" );
//                System.out.println("Data "+ data );

            }

            //rs.close();
            //ps.close();
            //conn.close();

      }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
//        table.getItems().add(data);
        table.setItems(data);
        table.setUserData(data);
        System.out.println("Table Value::" + table);
    }




    @FXML
    public void record(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("records.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Studend Records");
            stage.setWidth(720);
            stage.setHeight(500);

            buildData();
            Scene scene = new Scene(table);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setHeaderText("Ooops, there was an error!");
            alert.setContentText(e.toString());
            alert.showAndWait();
        }
    }

    @FXML
    public void abouts(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("About Application");
        alert.setContentText("Developed by Dhiraj Kumar MCA 2nd Yr (16352003)");
        alert.showAndWait();
    }

    @FXML
    public void delrecord(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("del_record.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Delete Records");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setHeaderText("Ooops, there was an error!");
            alert.setContentText(e.toString());
            alert.showAndWait();
        }
    }

    @FXML
    public void del(ActionEvent actionEvent){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "");
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM student WHERE stu_id = "+del_st_id.getText());
            statement.close();
            connection.close();
            del_st_id.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(" Records Deleted");
            alert.setContentText("Data Deleted Successful");

            alert.showAndWait();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setHeaderText("Ooops, there was an error!");
            alert.setContentText(e.toString());
            alert.showAndWait();
        }
    }




}
