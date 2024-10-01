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
    
    public enum AddressType{
        WORK,
        HOME
    }
    
    String streetAddress;
    int unitNumber;
    String city;
    String State;
    String zipcode;
    String PhoneNumber;
    AddressType type;

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
        this.unitNumber = unitNumber;
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
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }
    
    public boolean isValid(){
        return !(this.streetAddress.isBlank() ||
                this.city.isBlank() ||
                this.zipcode.isBlank() ||
                this.State.isBlank() ||
                this.unitNumber <=0 ||
                this.PhoneNumber.isBlank());
    }
}
