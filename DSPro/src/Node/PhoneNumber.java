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
public class PhoneNumber extends Node {
    public PhoneNumber (String ownernationalcode, String phonenumber, String operatorname){
        
        this.ownernationalcode=ownernationalcode;
        this.phonenumber=phonenumber;
        this.key=phonenumber;
        this.operatorname=operatorname;
        
    }
    public String ownernationalcode;
    public String phonenumber;
    public String operatorname;
    
    
    @Override
    public String toString (){
        return "کد ملی صاحب خط: "+ownernationalcode+" شماره موبایل: "+
                phonenumber+" نام اوپراتور: "+operatorname+"\n";
    }
}
