package com.ourapp.drdoctor;

public class Appointment {

    // Attributes
    public String symptom1Text;
    public String symptom2Text;
    public String symptom3Text;
    public String dateTimeText;
    public String email;
    public String phoneNumber;

    // Empty Constructor
    public Appointment() {
        // Default constructor required for calls to DataSnapshot.getValue(Appointment.class)
    }

    // Constructor required for calls to DataSnapshot.getValue
    public Appointment(String symptom1Text, String symptom2Text, String symptom3Text, String dateTimeText, String email, String phoneNumber) {
        this.symptom1Text = symptom1Text;
        this.symptom2Text = symptom2Text;
        this.symptom3Text = symptom3Text;
        this.dateTimeText = dateTimeText;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters

    public String getSymptom1Text() {
        return symptom1Text;
    }

    public String getSymptom2Text() {
        return symptom2Text;
    }

    public String getSymptom3Text() {
        return symptom3Text;
    }

    public String getDateTimeText() {
        return dateTimeText;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters

    public void setSymptom1Text(String symptom1Text) {
        this.symptom1Text = symptom1Text;
    }

    public void setSymptom2Text(String symptom2Text) {
        this.symptom2Text = symptom2Text;
    }

    public void setSymptom3Text(String symptom3Text) {
        this.symptom3Text = symptom3Text;
    }

    public void setDateTimeText(String dateTimeText) {
        this.dateTimeText = dateTimeText;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
