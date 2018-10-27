package samplerecords;

import javafx.beans.property.SimpleStringProperty;

public class records {

    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty FatherName = new SimpleStringProperty("");
    private final SimpleStringProperty email = new SimpleStringProperty("");


    public records() {
        this("", "", "");
    }

    public records(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public String getFirstName() {
        return Name.get();
    }

    public void setFirstName(String fName) {
        Name.set(fName);
    }

    public String getLastName() {
        return FatherName.get();
    }

    public void setLastName(String fName) {
        FatherName.set(fName);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String fName) {
        email.set(fName);
    }
}
