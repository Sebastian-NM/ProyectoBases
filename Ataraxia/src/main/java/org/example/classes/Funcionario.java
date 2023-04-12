/*
 * Created on Mon Apr 03 2023
 *
 * Author: Sebastián Navarro Martínez - sebastian.navarro01@estudiantec.cr
 */
package org.example.classes;

import java.util.Date;

public class Funcionario {
    private int employeeID;
    private String employeeName;
    private String employeeType;
    private Date employeeEnterDate;
    private String employeeArea;
    private int employeeCenter;

    public Funcionario() {

    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeType() {
        return this.employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Date getEmployeeEnterDate() {
        return this.employeeEnterDate;
    }

    public void setEmployeeEnterDate(Date employeeEnterDate) {
        this.employeeEnterDate = employeeEnterDate;
    }

    public String getEmployeeArea() {
        return this.employeeArea;
    }

    public void setEmployeeArea(String employeeArea) {
        this.employeeArea = employeeArea;
    }

    public int getEmployeeCenter() {
        return this.employeeCenter;
    }

    public void setEmployeeCenter(int employeeCenter) {
        this.employeeCenter = employeeCenter;
    }

    @Override
    public String toString() {
        return  "-FUNCIONARIO-\n"+
                "ID: " + getEmployeeID() + "\n" +
                "Name: " + getEmployeeName() + "\n" +
                "Type: " + getEmployeeType() + "\n" +
                "EnterDate: " + getEmployeeEnterDate() + "\n" +
                "Area: " + getEmployeeArea() + "\n" +
                "Center: " + getEmployeeCenter() + "\n";
    }
}
