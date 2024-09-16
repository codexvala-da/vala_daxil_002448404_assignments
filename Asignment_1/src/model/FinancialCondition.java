/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author apple
 */
public class FinancialCondition {
    public int annualIncome;
    public int monthlyExpense;
    public int numberOfDependents;
    public float currentSavings;
    public boolean ownsApartment;
    public EmploymentSector employmentSector;
    
    
    public static enum EmploymentSector {
        PRIVATE, GOVERNMENT, SELF_EMPLOYED, UNEMPLOYED
    } 

    public int getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(int annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getMonthlyExpense() {
        return monthlyExpense;
    }

    public void setMonthlyExpense(int monthlyExpense) {
        this.monthlyExpense = monthlyExpense;
    }

    public int getNumberOfDependents() {
        return numberOfDependents;
    }

    public void setNumberOfDependents(int numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    public float getCurrentSavings() {
        return currentSavings;
    }

    public void setCurrentSavings(float currentSavings) {
        this.currentSavings = currentSavings;
    }

    public boolean isOwnsApartment() {
        return ownsApartment;
    }

    public void setOwnsApartment(boolean ownsApartment) {
        this.ownsApartment = ownsApartment;
    }

    public EmploymentSector getEmploymentSector() {
        return employmentSector;
    }

    public void setEmploymentSector(EmploymentSector employmentSector) {
        this.employmentSector = employmentSector;
    }
}
