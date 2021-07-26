/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Node;

/**
 *
 * @author mohse
 */
public class Person extends Node {
    public Person (String firstname, String lastname, String nationalcode, String birthdate, String birthplace, String workplace){
    
    this.firstname=firstname;
    this.lastname=lastname;
    this.nationalcode=nationalcode;
    this.key=nationalcode;
    this.birthdate=birthdate;
    this.birthplace=birthplace;
    this.workplace=workplace;
    
    }
    
    public String firstname;
    public String lastname;
    public String nationalcode;
    public String birthdate;
    public String birthplace;
    public String workplace;
    
    @Override
    public String toString(){
        return firstname+" "+lastname+" کد ملی: "+nationalcode+
                "متولد"+birthdate+"در "+birthplace+"محل کار "+workplace+"\n";
    }
}

