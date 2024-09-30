/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author apple
 */
public class PersonDirectory {
    
    ArrayList<Person> people;

    public PersonDirectory() {
        this.people = new ArrayList<Person>();
    }
    
    
    
    public Person addPerson(){
        Person person = new Person();
        people.add(person);
        return person;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }
    
    public Person search(String searchText){
        for(Person person : people){
            if (person.firstName.contains(searchText) || person.lastName.contains(searchText)){
                return person;
            }
            else if(person.workAddress.streetAddress.contains(searchText)|| person.homeAddress.streetAddress.contains(searchText)){
                return person;
            }
        }
        return null;
    }
}
