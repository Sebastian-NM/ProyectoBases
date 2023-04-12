/*
 * Created on Mon Apr 03 2023
 *
 * Author: Sebastián Navarro Martínez - sebastian.navarro01@estudiantec.cr
 */
package org.example.classes;

public class Diagnostico {
    private int diagnosticID;
    private int appointmentID;
    private String diagnosticName;
    private String diagnosticLevel;
    private String diagnosticNotes;

    public Diagnostico(int appointmentID, String diagnosticName, String diagnosticLevel, String diagnosticNotes) {
        this.appointmentID = appointmentID;
        this.diagnosticName = diagnosticName;
        this.diagnosticLevel = diagnosticLevel;
        this.diagnosticNotes = diagnosticNotes;
    }

    public int getAppointmentID() {
        return this.appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getDiagnosticName() {
        return this.diagnosticName;
    }

    public void setDiagnosticName(String diagnosticName) {
        this.diagnosticName = diagnosticName;
    }

    public String getDiagnosticLevel() {
        return this.diagnosticLevel;
    }

    public void setDiagnosticLevel(String diagnosticLevel) {
        this.diagnosticLevel = diagnosticLevel;
    }

    public String getDiagnosticNotes() {
        return this.diagnosticNotes;
    }

    public void setDiagnosticNotes(String diagnosticNotes) {
        this.diagnosticNotes = diagnosticNotes;
    }


    public int getDiagnosticID() {
        return this.diagnosticID;
    }

    public void setDiagnosticID(int diagnosticID) {
        this.diagnosticID = diagnosticID;
    }


    @Override
    public String toString() {
        return "{" +
                " appointmentID='" + getAppointmentID() + "'" +
                ", diagnosticName='" + getDiagnosticName() + "'" +
                ", diagnosticLevel='" + getDiagnosticLevel() + "'" +
                ", diagnosticNotes='" + getDiagnosticNotes() + "'" +
                "}";
    }
}
