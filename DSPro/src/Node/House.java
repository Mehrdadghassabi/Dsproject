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
public class House extends Node {
    public House (String ownernationalcode, String price, String postcode, String areaofhouse, String address){
        
        this.ownernationalcode=ownernationalcode;
        this.price=price;
        this.postcode=postcode;
        this.key=postcode;
        this.areaofhouse=areaofhouse;
        this.address=address;
        
    }
    
    public String ownernationalcode;
    public String price;
    public String postcode;
    public String areaofhouse;
    public String address;
    
    
    
    @Override
    public String toString (){
        return "کد ملی صاحب خانه :"+ownernationalcode+"قیمت :"+price+" کدپستی:"+postcode+
                " متراژخانه:"+areaofhouse+" آدرس:"+address+"\n";   
    }
}
