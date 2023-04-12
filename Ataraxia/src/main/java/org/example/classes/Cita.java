/*
 * Created on Mon Apr 03 2023
 *
 * Author: Sebastián Navarro Martínez - sebastian.navarro01@estudiantec.cr
 */
package org.example.classes;

import java.util.Date;

public class Cita {
    private int appointmentId;
    private String appointmentStatus;
    private String appointmentSpecialty;
    private Date appointmentDate;
    private String appointmentTime;
    private String appointmentNotes;
    private String appointmentAttendant;

    public Cita(int appointmentId, String appointmentStatus, String appointmentSpecialty, Date appointmentDate,
            String appointmentTime, String appointmentNotes, String appointmentAttendant) {
        this.appointmentId = appointmentId;
        this.appointmentStatus = appointmentStatus;
        this.appointmentSpecialty = appointmentSpecialty;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentNotes = appointmentNotes;
        this.appointmentAttendant = appointmentAttendant;
    }

    public Cita() {
    }
    
    

    public int getAppointmentId() {
        return this.appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentStatus() {
        return this.appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentSpecialty() {
        return this.appointmentSpecialty;
    }

    public void setAppointmentSpecialty(String appointmentSpecialty) {
        this.appointmentSpecialty = appointmentSpecialty;
    }

    public Date getAppointmentDate() {
        return this.appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return this.appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentNotes() {
        return this.appointmentNotes;
    }

    public void setAppointmentNotes(String appointmentNotes) {
        this.appointmentNotes = appointmentNotes;
    }

    public String getAppointmentAttendant() {
        return this.appointmentAttendant;
    }

    public void setAppointmentAttendant(String appointmentAttendant) {
        this.appointmentAttendant = appointmentAttendant;
    }

    @Override
    public String toString() {
        return "{" +
                " appointmentId='" + getAppointmentId() + "'" +
                ", appointmentStatus='" + getAppointmentStatus() + "'" +
                ", appointmentSpecialty='" + getAppointmentSpecialty() + "'" +
                ", appointmentDate='" + getAppointmentDate() + "'" +
                ", appointmentTime='" + getAppointmentTime() + "'" +
                ", appointmentNotes='" + getAppointmentNotes() + "'" +
                ", appointmentAttendant='" + getAppointmentAttendant() + "'" +
                "}";
    }
}
