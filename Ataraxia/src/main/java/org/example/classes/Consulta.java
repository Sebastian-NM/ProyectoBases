/*
 * Created on Mon Apr 03 2023
 *
 * Author: Sebastián Navarro Martínez - sebastian.navarro01@estudiantec.cr
 */
package org.example.classes;

import java.util.Date;

public class Consulta {
    private int employeeID;
    private int patientID;
    private Date consultDate;
    private String consultTranscription;

    public Consulta(int employeeID, int patientID, Date consultDate, String consultTranscription) {
        this.employeeID = employeeID;
        this.patientID = patientID;
        this.consultDate = consultDate;
        this.consultTranscription = consultTranscription;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getPatientID() {
        return this.patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public Date getConsultDate() {
        return this.consultDate;
    }

    public void setConsultDate(Date consultDate) {
        this.consultDate = consultDate;
    }

    public String getConsultTranscription() {
        return this.consultTranscription;
    }

    public void setConsultTranscription(String consultTranscription) {
        this.consultTranscription = consultTranscription;
    }

    @Override
    public String toString() {
        return "{" +
                " employeeID='" + getEmployeeID() + "'" +
                ", patientID='" + getPatientID() + "'" +
                ", consultDate='" + getConsultDate() + "'" +
                ", consultTranscription='" + getConsultTranscription() + "'" +
                "}";
    }

}
