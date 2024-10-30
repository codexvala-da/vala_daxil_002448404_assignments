/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

/**
 *
 * @author kal bugrara
 */
public class Course {

    String number;
    String name;
    boolean isCore;
    int credits;
    int price = 1500; //per credit hour

    public Course(String n, String numb, int ch, boolean core) {
        name = n;
        number = numb;
        credits = ch;
        isCore = core;
    }

    public String getCOurseNumber() {
        return number;
    }

    public int getCoursePrice() {
        return price * credits;

    }

    public String getName() {
        return name;
    }

    
    public int getCredits() {
        return credits;
    
    }
    
    @Override
    public String toString() {
    return number + ": {name='" + name + "', credits=" + credits + " is_core=" + isCore + "}";
    }
    
}