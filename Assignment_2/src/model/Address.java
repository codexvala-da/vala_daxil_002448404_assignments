/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author apple
 */
public class Address {
    
    
    String streetAddress;
    byte unitNumber;
    String city;
    String State;
    String zipcode;
    long PhoneNumber;

    public Address(){}
    
    public Address(Address other) {
        this.streetAddress = other.streetAddress;
        this.unitNumber = other.unitNumber;
        this.city = other.city;
        this.State = other.State;
        this.zipcode = other.zipcode;
        this.PhoneNumber = other.PhoneNumber;
    }
    
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = (byte) unitNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return Long.toString(PhoneNumber);
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = Long.parseLong(PhoneNumber);
    }
   
    
    public boolean isValid(){
        return !(this.streetAddress.isBlank() ||
                this.city.isBlank() ||
                this.zipcode.isBlank() ||
                this.State.isBlank() ||
                this.unitNumber <=0 ||
                this.PhoneNumber == 0);
    }
}
