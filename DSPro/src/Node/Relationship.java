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
public class Relationship extends Edge<Person, Person> {
    public Relationship (String firstNationalcode, String secoundNationalcode,String relationship, String dateOfRelationship){
        
        this.relationship=relationship;
        this.dateOfRelationship=dateOfRelationship;
        this.key=firstNationalcode+secoundNationalcode;
        this.firstNationalcode=firstNationalcode;
        this.secoundNationalcode=secoundNationalcode;
    }
    
    public String relationship;
    public String dateOfRelationship;
    public String firstNationalcode;
    public String secoundNationalcode;
    
    
    @Override
    public String toString (){
        return "نوع رابطه: "+relationship+" مدت زمان رابطه: "+dateOfRelationship+"\n";
    }
}
