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
public class Ownership extends Edge<Person, Node> {
    public Ownership (String sfrom,String sto,String documentNumber, String date, String amount){
        
        this.documentNumber=documentNumber;
        this.key=sfrom;
        this.amount=amount;
        this.date=date;
        this.sfrom=sfrom;
        this.sto=sto;
    }
    
    public String documentNumber;
    public String amount;
    public String date;
    public String sfrom;
    public String sto;
    
    
    @Override
    public String toString (){
        return "از:"+sfrom+" به : "+sto+"شماره سند: "+documentNumber+"قیمت: "+amount+"در تاریخ: "+date+"\n"; 
    }
}
