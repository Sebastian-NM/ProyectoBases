/*
 * Created on Mon Apr 03 2023
 *
 * Author: Sebastián Navarro Martínez - sebastian.navarro01@estudiantec.cr
 */
package org.example.classes;

public class CentroAtencion {
    private int centerID;
    private String centerName;
    private String centerLocation;
    private int centerCapacity;
    private String centerType;

    public CentroAtencion(int centerID, String centerName, String centerLocation, int centerCapacity,
            String centerType) {
        this.centerID = centerID;
        this.centerName = centerName;
        this.centerLocation = centerLocation;
        this.centerCapacity = centerCapacity;
        this.centerType = centerType;
    }

    public CentroAtencion() {

    }

    public int getCenterID() {
        return this.centerID;
    }

    public void setCenterID(int centerID) {
        this.centerID = centerID;
    }

    public String getCenterName() {
        return this.centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterLocation() {
        return this.centerLocation;
    }

    public void setCenterLocation(String centerLocation) {
        this.centerLocation = centerLocation;
    }

    public int getCenterCapacity() {
        return this.centerCapacity;
    }

    public void setCenterCapacity(int centerCapacity) {
        this.centerCapacity = centerCapacity;
    }

    public String getCenterType() {
        return this.centerType;
    }

    public void setCenterType(String centerType) {
        this.centerType = centerType;
    }

    @Override
    public String toString() {
        return "{" +
                " centerID='" + getCenterID() + "'" +
                ", centerName='" + getCenterName() + "'" +
                ", centerLocation='" + getCenterLocation() + "'" +
                ", centerCapacity='" + getCenterCapacity() + "'" +
                ", centerType='" + getCenterType() + "'" +
                "}";
    }

}
