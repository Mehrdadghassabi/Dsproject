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
public class Car extends Node {
    public Car (String cartag, String ownernationalcode, String model, String color){
        
        this.cartag=cartag;
        this.key=cartag;
        this.ownernationalcode=ownernationalcode;
        this.model=model;
        this.color=color;
        
    }
    
    /*@Override
    public String toString(){
        return "Cartag: "+ this.cartag +"\n"+"Owner "
                +this.ownernationalcode+"\n"+"model: "+this.model+"\n"+"color: "+this.color;
    }*/
    
    public String cartag;
    public String ownernationalcode;
    public String model;
    public String color;
    
    
    
    @Override
    public String toString (){
        return  "شماره پلاک ماشین: "+cartag+"شماره ملی صاحب: "+ownernationalcode+"مدل: "+model+" رنگ: "+color+"\n";
    }
}
