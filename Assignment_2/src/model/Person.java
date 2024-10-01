/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author apple
 */
public class Person {
    String firstName;
    String lastName;
    String socailSecurityNumber;
    int age;
    Address workAddress;
    Address homeAddress;

    public Person() {
        this.workAddress = new Address();
        this.homeAddress = new Address();
    }

    public Person(Person person) {
        this.firstName = person.firstName;
        this.lastName = person.lastName;
        this.socailSecurityNumber = person.socailSecurityNumber;
        this.age = person.age;
        this.homeAddress = new Address(person.homeAddress);  // Deep copy
        this.workAddress = new Address(person.workAddress);
    }

    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocailSecurityNumber() {
        return socailSecurityNumber;
    }

    public void setSocailSecurityNumber(String socailSecurityNumber) {
        this.socailSecurityNumber = socailSecurityNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
    
    public String toString(){
        return this.getFirstName();
    }
    
    public boolean validateInput(){
        return !(this.firstName.isBlank()||
                this.lastName.isBlank()||
                this.socailSecurityNumber.isBlank()||
                this.age <= 0||
                !this.homeAddress.isValid()||
                !this.workAddress.isValid());
    }
    
}
