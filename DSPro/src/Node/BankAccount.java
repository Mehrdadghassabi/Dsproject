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
public class BankAccount extends Node {
    public BankAccount(String ownernatinalcode, String bankname, String shabanomber, String accountnumber){
        
        this.ownernatinalcode=ownernatinalcode;
        this.bankname=bankname;
        this.shabanomber=shabanomber;
        this.key=ownernatinalcode;
        this.accountnumber=accountnumber;
        
    }
    
    public String ownernatinalcode;
    public String bankname;
    public String shabanomber;
    public String accountnumber;
    
    
    
    @Override
    public String toString (){
        return " کد ملی صاحب حساب: "+ownernatinalcode+" نام بانک: "+bankname+
                " شماره شبا: "+shabanomber+" شماره حساب: "+accountnumber+"\n";
    }
}
