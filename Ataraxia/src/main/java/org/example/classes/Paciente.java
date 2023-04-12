/*
 * Created on Mon Apr 03 2023
 *
 * Author: Sebastián Navarro Martínez - sebastian.navarro01@estudiantec.cr
 */
package org.example.classes;

import java.util.Date;
import java.util.List;

public class Paciente {
    private String patientID;
    private String patientName;
    private Date patientBirthdayDate;
    private String patientBloodType;
    private String patientNacionality;
    private String patientAdress;
    private int patientCenter;
    private List<String> patientPhoneNumbers;


    public Paciente(String patientID, String patientName, Date patientBirthdayDate, String patientBloodType, String patientNacionality, String patientAdress, int patientCenter, List<String> patientPhoneNumbers) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientBirthdayDate = patientBirthdayDate;
        this.patientBloodType = patientBloodType;
        this.patientNacionality = patientNacionality;
        this.patientAdress = patientAdress;
        this.patientCenter = patientCenter;
        this.patientPhoneNumbers = patientPhoneNumbers;
    }

    public Paciente() {
    }


    public String getPatientID() {
        return this.patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getPatientBirthdayDate() {
        return this.patientBirthdayDate;
    }

    public void setPatientBirthdayDate(Date patientBirthdayDate) {
        this.patientBirthdayDate = patientBirthdayDate;
    }

    public String getPatientBloodType() {
        return this.patientBloodType;
    }

    public void setPatientBloodType(String patientBloodType) {
        this.patientBloodType = patientBloodType;
    }

    public String getPatientNacionality() {
        return this.patientNacionality;
    }

    public void setPatientNacionality(String patientNacionality) {
        this.patientNacionality = patientNacionality;
    }

    public String getPatientAdress() {
        return this.patientAdress;
    }

    public void setPatientAdress(String patientAdress) {
        this.patientAdress = patientAdress;
    }

    public int getPatientCenter() {
        return this.patientCenter;
    }

    public void setPatientCenter(int patientCenter) {
        this.patientCenter = patientCenter;
    }

    public List<String> getPatientPhoneNumbers() {
        return this.patientPhoneNumbers;
    }

    public void setPatientPhoneNumbers(List<String> patientPhoneNumbers) {
        this.patientPhoneNumbers = patientPhoneNumbers;
    }

    @Override
    public String toString() {
        return "{" +
            " patientID='" + getPatientID() + "'" +
            ", patientName='" + getPatientName() + "'" +
            ", patientBirthdayDate='" + getPatientBirthdayDate() + "'" +
            ", patientBloodType='" + getPatientBloodType() + "'" +
            ", patientNacionality='" + getPatientNacionality() + "'" +
            ", patientAdress='" + getPatientAdress() + "'" +
            ", patientCenter='" + getPatientCenter() + "'" +
            ", patientPhoneNumbers='" + getPatientPhoneNumbers() + "'" +
            "}";
    }
}
