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
public class AddressList {
    
    ArrayList<Address> addresses;
    
    ArrayList<Address> updateAddress(String type, Address updatedAddress){
        for(Address address : addresses){
            if (address.type.toString().equals(type)){
                address = updatedAddress;
            }
        }
        return addresses;
    }
    
}
