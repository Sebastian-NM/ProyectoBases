package org.example.classes;

public class Tratamiento {
    private int treatmentID;
    private String treatmentName;
    private int treatmentDosis;
    private String treatmentType;
    private int appointmentID;


    public Tratamiento(int treatmentID, String treatmentName, int treatmentDosis, String treatmentType, int appointmentID) {
        this.treatmentID = treatmentID;
        this.treatmentName = treatmentName;
        this.treatmentDosis = treatmentDosis;
        this.treatmentType = treatmentType;
        this.appointmentID = appointmentID;
    }

    public Tratamiento(){};


    public int getTreatmentID() {
        return this.treatmentID;
    }

    public void setTreatmentID(int treatmentID) {
        this.treatmentID = treatmentID;
    }

    public String getTreatmentName() {
        return this.treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public int getTreatmentDosis() {
        return this.treatmentDosis;
    }

    public void setTreatmentDosis(int treatmentDosis) {
        this.treatmentDosis = treatmentDosis;
    }

    public String getTreatmentType() {
        return this.treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public int getAppointmentID() {
        return this.appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }


    @Override
    public String toString() {
        return "{" +
            " treatmentID='" + getTreatmentID() + "'" +
            ", treatmentName='" + getTreatmentName() + "'" +
            ", treatmentDosis='" + getTreatmentDosis() + "'" +
            ", treatmentType='" + getTreatmentType() + "'" +
            ", appointmentID='" + getAppointmentID() + "'" +
            "}";
    }
}
