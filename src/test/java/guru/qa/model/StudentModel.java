package guru.qa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class StudentModel {

    @JsonProperty("Name")
    private String name;

    public String getName() {
        return name;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    private String gender;

    public String getGender() {
        return gender;
    }

    @JsonProperty("Date of Birth")
    private String DateBirth;

    public String getDateBirth() {
        return DateBirth;
    }

    private String subjects;

    public String getSubjects() {
        return subjects;
    }

    private ArrayList <String> hobbies;

    public ArrayList getHobbies() {
        return hobbies;
    }

    @JsonProperty("Current Address")
    private String currentAddress;

    public String getCurrentAddress() {
        return currentAddress;
    }

    private boolean offline;

    public boolean isOffline() {
        return offline;
    }
}
